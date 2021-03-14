package server;

import common.CommandsAndConstants;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Обработчик входящих клиентов
 */
public class ClientHandler implements Runnable {
    private final Socket socket;
    private static final String ROOT_SERVER = "server" + File.separator;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (DataOutputStream out = new DataOutputStream(socket.getOutputStream());
             DataInputStream in = new DataInputStream(socket.getInputStream())) {
            while (true) {
                String command = in.readUTF();
                if (CommandsAndConstants.UPLOAD.equals(command)) {
                    try {
                        File file = new File(ROOT_SERVER + in.readUTF());
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
                        out.writeUTF(CommandsAndConstants.OK);
                    } catch (Exception e) {
                        out.writeUTF(CommandsAndConstants.ERROR);
                    }
                } else if (CommandsAndConstants.DOWNLOAD.equals(command)) {
                    // TODO: 02.03.2021
                    // realize download
                    File file= new File(ROOT_SERVER+in.readUTF());
                    out.writeLong(file.length());
                    FileInputStream fis = new FileInputStream(file);
                    int read = 0;
                    byte[] buffer = new byte[CommandsAndConstants.PACKAGE_SIZE];
                    while ((read = fis.read(buffer)) != -1) {
                        out.write(buffer, 0, read);
                    }
                    out.flush();

                } else if (CommandsAndConstants.REMOVE.equals(command)) {
                    // TODO: 02.03.2021
                    // realize remove
                    Path path =Paths.get(ROOT_SERVER+in.readUTF());
                    Files.delete(path);
                    out.writeUTF(CommandsAndConstants.OK);
                } else if (CommandsAndConstants.GET_FILE_LIST.equals(command)) {
                    String messageFiles = "";
                    for (File file : new File(ROOT_SERVER).listFiles()) {
                        messageFiles += file.getName() + CommandsAndConstants.DELIMITER;
                    }
                    messageFiles = messageFiles.substring(0, messageFiles.length() - CommandsAndConstants.DELIMITER.length());
                    out.writeUTF(messageFiles);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
