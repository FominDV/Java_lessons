package homework3_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Date;

import static java.lang.String.format;

public class ClientGUI extends JFrame implements ActionListener {
    private static PrintStream printLog;

    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    private final JPanel panelTop = new JPanel(new GridLayout(2, 3));

    private final JTextField tfIPAddress = new JTextField("127.0.0.1");
    private final JTextField tfPort = new JTextField("8189");
    private final JCheckBox cbAlwaysOnTop = new JCheckBox("Always on top");
    private final JTextField tfLogin = new JTextField("ivan");
    private final JPasswordField tfPassword = new JPasswordField("123");
    private final JButton btnLogin = new JButton("Login");

    private final JPanel panelBottom = new JPanel(new BorderLayout());
    private final JButton btnDisconnect = new JButton("<html><b>Disconnect</b></html>");
    private final JTextField tfMessage = new JTextField();
    private final JButton btnSend = new JButton("Send");

    private final JList<String> userList = new JList<>();
    private final JTextArea log = new JTextArea();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ClientGUI());
    }

    ClientGUI() {
        new ExceptionForChat(this);
        setTitle("Client Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WIDTH, HEIGHT);
        JScrollPane scrollLog = new JScrollPane(log);
        JScrollPane scrollUserList = new JScrollPane(userList);
        String[] users = {"user1", "user2", "user3", "user4", "user5", "user_with_an_exceptionally_long_name_in_this_chat"};
        userList.setListData(users);
        log.setEditable(false);
        log.setLineWrap(true);
        log.setWrapStyleWord(true);
        scrollUserList.setPreferredSize(new Dimension(150, 0));
        cbAlwaysOnTop.addActionListener(this);
        btnSend.addActionListener(this);
        tfMessage.addActionListener(this);
        panelTop.add(tfIPAddress);
        panelTop.add(tfPort);
        panelTop.add(cbAlwaysOnTop);
        panelTop.add(tfLogin);
        panelTop.add(tfPassword);
        panelTop.add(btnLogin);
        add(panelTop, BorderLayout.NORTH);
        panelBottom.add(btnDisconnect, BorderLayout.WEST);
        panelBottom.add(tfMessage, BorderLayout.CENTER);
        panelBottom.add(btnSend, BorderLayout.EAST);
        add(panelBottom, BorderLayout.SOUTH);
        add(scrollLog, BorderLayout.CENTER);
        add(scrollUserList, BorderLayout.EAST);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == cbAlwaysOnTop) {
            setAlwaysOnTop(cbAlwaysOnTop.isSelected());
        } else if (source == btnSend || source == tfMessage) {
            addMessageIntoLog(tfMessage.getText(), tfLogin.getText());
        } else {
            throw new RuntimeException("Unknown source: " + source);
        }
    }

    private void addMessageIntoLog(String message, String userName) {
        try {
            printLog = new PrintStream(new FileOutputStream("log.txt", true));
        } catch (FileNotFoundException e) {
            new FileLogIsNotFound("log.txt", e);
        }
        if (!(message.equals(""))) {
            Date date = new Date();
            String messageForLog = format("%s(%tD %tR):\n%s\n", userName, date, date, message);
            log.append(messageForLog);
            printLog.print(messageForLog);
            tfMessage.setText(null);
            tfMessage.grabFocus();
        }
    }
}
