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

    public static void stop() {
        System.out.println("Server stopped");
    }

}
