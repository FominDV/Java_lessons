package homework3_4;

import javax.swing.*;

import java.awt.*;

import static javax.swing.JOptionPane.*;

public class ExceptionForChat implements Thread.UncaughtExceptionHandler {
    private static Component o;
    public  ExceptionForChat(Object o){
       Thread.setDefaultUncaughtExceptionHandler(this);
       this.o=(Component)o;
    }
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        e.printStackTrace();
        String msg;
        StackTraceElement[] ste = e.getStackTrace();
        msg = "Exception in " + t.getName() + " " +
                e.getClass().getCanonicalName() + "\n: " +
                e.getMessage() + "\n\t at " + ste[0];
        showMessageDialog(o, msg, "Exception", ERROR_MESSAGE);
        System.exit(1);
    }
}
