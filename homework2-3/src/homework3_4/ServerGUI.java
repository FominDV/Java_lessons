package homework3_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerGUI extends JFrame implements Thread.UncaughtExceptionHandler, ActionListener {
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
        Thread.setDefaultUncaughtExceptionHandler(this);
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
    public void uncaughtException(Thread t, Throwable e) {
        e.printStackTrace();
        String msg;
        StackTraceElement[] ste = e.getStackTrace();
        msg = "Exception in " + t.getName() + " " +
                e.getClass().getCanonicalName() + "\n: " +
                e.getMessage() + "\n\t at " + ste[0];
        JOptionPane.showMessageDialog(this, msg, "Exception", JOptionPane.ERROR_MESSAGE);
        System.exit(1);
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
