import java.net.Socket;

public interface SocketThreadListener {
    void onReceiveString(ThreadSocket thread, String msg, int id);
}
