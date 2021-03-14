package client;

import common.CommandsAndConstants;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Client {
    private final Socket socket;
    private final DataInputStream in;
    private final DataOutputStream out;
    private JList<String> listUserFiles;
    private JList<String> listServerFiles;

    private static final String ROOT_USER = "client" + File.separator;
    private static final String FILE_NOT_CHOSEN="File was not chosen";

    public Client() throws IOException {
        socket = new Socket("localhost", 1235);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        runClient();
    }

    private void runClient() throws IOException {
        JFrame frame = new JFrame("Cloud Storage");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 450);
        // TODO: 02.03.2021
        // list file - JList
        listUserFiles = new JList<>();
        listServerFiles = new JList<>();

        JButton uploadButton = new JButton("Upload");
        JButton downloadButton = new JButton("Download");
        JButton removeButton = new JButton("Remove");

        JPanel panelButtons = new JPanel(new GridLayout(1, 3));
        JPanel panelLists = new JPanel(new GridLayout(1, 2));
        JPanel panelHeader = new JPanel(new GridLayout(1, 2));

        panelButtons.add(uploadButton);
        panelButtons.add(downloadButton);
        panelButtons.add(removeButton);
        panelHeader.add(new JLabel("USER"));
        panelHeader.add(new JLabel("SERVER"));
        panelLists.add(listUserFiles);
        panelLists.add(listServerFiles);
        frame.getContentPane().add(BorderLayout.SOUTH, panelButtons);
        frame.getContentPane().add(BorderLayout.NORTH, panelHeader);
        frame.getContentPane().add(BorderLayout.CENTER, panelLists);
        updateLists();
        frame.setVisible(true);

        uploadButton.addActionListener(a -> System.out.println(sendFile(listUserFiles.getSelectedValue())));
        downloadButton.addActionListener(a->System.out.println(download(listServerFiles.getSelectedValue())));
        removeButton.addActionListener(a->System.out.println(remove(listServerFiles.getSelectedValue())));
    }

    private String remove(String fileName) {
        if(fileName==null){
            return FILE_NOT_CHOSEN;
        }
        try {
            out.writeUTF(CommandsAndConstants.REMOVE);
            out.writeUTF(fileName);
            String response;
            if((response=in.readUTF()).equals(CommandsAndConstants.OK)){
                updateLists();
            }
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return CommandsAndConstants.ERROR;
    }

    private String download(String fileName) {
        if(fileName==null){
            return FILE_NOT_CHOSEN;
        }
        try {
            out.writeUTF(CommandsAndConstants.DOWNLOAD);
            out.writeUTF(fileName);
            File file = new File(ROOT_USER + fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            long size = in.readLong();
            FileOutputStream fos = new FileOutputStream(file);
            byte[] buffer = new byte[CommandsAndConstants.PACKAGE_SIZE];
            for (int i = 0; i < (size + CommandsAndConstants.PACKAGE_SIZE - 1) / CommandsAndConstants.PACKAGE_SIZE; i++) { // FIXME
                int read = in.read(buffer);
                fos.write(buffer, 0, read);
            }
            fos.close();
            updateLists();
            return fileName+" was download";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return CommandsAndConstants.ERROR;
    }

    private void updateLists() throws IOException {
        List<String> userFiles = new ArrayList<>();
        File userPath = new File(ROOT_USER);
        Arrays.stream(userPath.listFiles()).forEach(file -> userFiles.add(file.getName()));
        listUserFiles.setListData(userFiles.toArray(new String[userFiles.size()]));
        out.writeUTF(CommandsAndConstants.GET_FILE_LIST);
        String messageFiles = in.readUTF();
        listServerFiles.setListData(messageFiles.split(CommandsAndConstants.DELIMITER));
    }

    private String sendFile(String filename) {
        if (filename == null) {
            return FILE_NOT_CHOSEN;
        }
        try {
            File file = new File(ROOT_USER + filename);
            if (file.exists()) {
                out.writeUTF(CommandsAndConstants.UPLOAD);
                out.writeUTF(filename);
                long length = file.length();
                out.writeLong(length);
                FileInputStream fis = new FileInputStream(file);
                int read = 0;
                byte[] buffer = new byte[CommandsAndConstants.PACKAGE_SIZE];
                while ((read = fis.read(buffer)) != -1) {
                    out.write(buffer, 0, read);
                }
                out.flush();
                String status = in.readUTF();
                if (status.equals(CommandsAndConstants.OK)) {
                    updateLists();
                }
                return status;
            } else {
                return "File is not exists";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Something error";
    }

    public static void main(String[] args) throws IOException {
        new Client();
    }
}
