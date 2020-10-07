package homework3_4;

import javax.swing.*;

import java.util.Date;

import static java.lang.String.format;

public class ChatServer {
    public static void start(int port) {
        System.out.println("Server started at " + port);
    }

    public static void stop() {
        System.out.println("Server stopped");
    }

    public static void addMessageIntoLog(String message,String userName, JTextArea log){
        Date date = new Date();
        log.append(format("%s(%tD %tR):\n%s\n",userName,date,date,message));
    }
}
