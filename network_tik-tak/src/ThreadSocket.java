import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ThreadSocket extends Thread {
    private int userIndex;
    private Socket socket;
    private final SocketThreadListener listener;
    private DataInputStream in;
    private DataOutputStream out;

    public ThreadSocket(int userIndex, Socket socket, SocketThreadListener listener) {
        this.userIndex = userIndex;
        this.socket = socket;
        this.listener = listener;
        start();
    }

    @Override
    public void run() {
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        while (true) {
            String msg;
            try {
                msg = in.readUTF();
            } catch (IOException exception) {
                exception.printStackTrace();
                continue;
            }
            if (!msg.equals("")) listener.onReceiveString(this, msg, userIndex);
        }
    }

    public void sendMessage(String msg)  {
        try {
            out.writeUTF(msg);
            out.flush();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
