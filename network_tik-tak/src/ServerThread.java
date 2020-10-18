import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ServerThread extends Thread implements SocketThreadListener {
    private int port;
    public static int indexServerSocket = 11;
    public static Vector<ThreadSocket> threadSockets = new Vector<>();

    public ServerThread(int port) {
        this.port = port;
        start();
    }

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            serverSocket.setSoTimeout(200);
            Socket socket;
            while (true) {
                try {
                    socket = serverSocket.accept();
                } catch (IOException e) {
                    continue;
                }
                threadSockets.add(new ThreadSocket(indexServerSocket, socket, this));
                indexServerSocket++;
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }

    @Override
    public void onReceiveString(ThreadSocket thread, String msg) {
        for(int i=0;i<threadSockets.size();i++) {
            if (!thread.equals(threadSockets.get(i))) threadSockets.get(i).sendMessage(msg);
        }
    }
}
