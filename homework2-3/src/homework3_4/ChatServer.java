package homework3_4;

import javax.swing.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Date;

import static java.lang.String.format;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

public class ChatServer {
    public static void start(int port) {
        System.out.println("Server started at " + port);
    }

    private static PrintStream printLog;

    {
        try {
            printLog = new PrintStream(new FileOutputStream("log.txt", true));
        } catch (FileNotFoundException e) {
            new FileLogIsNotFound("log.txt", e);
        }
    }

    public static void stop() {
        System.out.println("Server stopped");
    }

    public static void addMessageIntoLog(String message, String userName, JTextArea log) {
        if (!(message.equals(""))) {
            Date date = new Date();
            String messageForLog = format("%s(%tD %tR):\n%s\n", userName, date, date, message);
            log.append(messageForLog);
            printLog.print(messageForLog);
        }
    }
}
