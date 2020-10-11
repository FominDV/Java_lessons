package homework3_4;

public class ServerSocketThread extends Thread {
    private final String name;
    private final int port, timeout;

    public ServerSocketThread(String name, int port, int timeout) {
        this.name = name;
        this.port = port;
        this.timeout = timeout;
        start();
    }

    @Override
    public void run() {
        System.out.println("Server started");

        while (!isInterrupted()) {
            try {
                sleep(timeout);
            } catch (InterruptedException e) {
                interrupt();
                break;
            }
            System.out.println("Server is working");
        }
    }
}
