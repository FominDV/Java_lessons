package homework3_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerGUI extends JFrame implements  ActionListener {
    private static final int X_POS = 1000;
    private static final int Y_POS = 500;
    private static final int WIDTH = 200;
    private static final int HEIGHT = 100;
    private final JButton BTN_START = new JButton("Start");
    private final JButton BTN_STOP = new JButton("Stop");
    private final ChatServer CHAT_SERVER = new ChatServer();
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ServerGUI());
    }

    private ServerGUI() {
        new ExceptionForChat(this);
        setTitle("Chat Server");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 2));
        setBounds(X_POS, Y_POS, WIDTH, HEIGHT);
        setResizable(false);
        setAlwaysOnTop(true);
        BTN_START.addActionListener(this);
        BTN_STOP.addActionListener(this);
        add(BTN_START);
        add(BTN_STOP);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == BTN_START) {
            CHAT_SERVER.start(8189);
        } else if (source == BTN_STOP) {
            CHAT_SERVER.stop();
        } else {
            throw new RuntimeException("Unknown source: " + source);
        }
    }
}
