import java.net.Socket;

public interface SocketThreadListener {
    void onReceiveString(ThreadSocket thread, String msg, int id);
    public boolean isVictory(int id);
    public  void setSymbol(int id, String msg);
    public boolean  isLineVictory(char symbol);
    public  boolean isDiagonalVictory(char symbol);
}
