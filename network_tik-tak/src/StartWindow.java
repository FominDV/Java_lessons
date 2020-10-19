import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

public class StartWindow extends JFrame implements ActionListener {
    private JButton btnConnect = new JButton("CONNECT");
    private JTextArea log = new JTextArea();
    private JTextField id=new JTextField("1");
    private JPanel panel = new JPanel(new GridLayout(2, 1));
    private int port = 8189;
    private String ip = "127.0.0.1";

    public static void main(String[] args) {
        new StartWindow();
    }

    public StartWindow() {
        SwingUtilities.invokeLater(() -> initializationElements());
    }

    private void initializationElements() {
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        btnConnect.addActionListener(this);
        log.setLineWrap(true);
        log.setEditable(false);
        panel.add(log);
        panel.add(btnConnect);
        log.setFont(new Font("SANS_SERIF", Font.ITALIC, 30));
        id.setFont(new Font("SANS_SERIF", Font.ITALIC, 30));
        add(panel, BorderLayout.CENTER);
        add(id, BorderLayout.SOUTH);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Socket socket;
        try {
            socket = new Socket(ip, port);
        } catch (IOException exception) {
            log.append("Connection error\n");
            exception.printStackTrace();
            return;
        }


        new GameMap(Integer.parseInt(id.getText()), socket);

        this.setVisible(false);
    }


}
