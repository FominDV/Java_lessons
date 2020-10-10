package homework3_4;

import java.io.FileNotFoundException;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

public class FileLogIsNotFound extends FileNotFoundException {
    public FileLogIsNotFound(String fileName, Throwable e) {
        e.printStackTrace();
        String msg;
        StackTraceElement[] ste = e.getStackTrace();
        msg = "File " + fileName + " was not found.\nException in " + e.getClass().getCanonicalName() + "\n: " + e.getMessage() + "\n\t at " + ste[0];
        showMessageDialog(null, msg, "Exception", ERROR_MESSAGE);
        System.exit(1);
    }
}
