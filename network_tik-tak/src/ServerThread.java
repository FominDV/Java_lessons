import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ServerThread extends Thread implements SocketThreadListener {
    protected static char USER1 = '1';
    protected static char USER2 = '2';
    protected static char EMPTY = '0';
    private int port;
    public static int indexServerSocket = 1;
    public static Vector<ThreadSocket> threadSockets = new Vector<>();
    protected char[][] gameMap = new char[GameMap.sizeOfMap][GameMap.sizeOfMap];


    public ServerThread(int port) {
        for (int i = 0; i < gameMap.length; i++) {
            for (int j = 0; j < gameMap.length; j++) {
                gameMap[i][j] = EMPTY;
            }
        }
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
    public void onReceiveString(ThreadSocket thread, String msg, int id) {
        setSymbol(id, msg);
        if (isVictory(id)) {
            thread.sendMessage(Library.getMessageForSendingVictory(msg));
            for (int i = 0; i < threadSockets.size(); i++) {
                if (!thread.equals(threadSockets.get(i)))
                    threadSockets.get(i).sendMessage(Library.getMessageForSendingLose(msg));
            }
            return;
        }
        for (int i = 0; i < threadSockets.size(); i++) {
            if (!thread.equals(threadSockets.get(i))) threadSockets.get(i).sendMessage(msg);
        }
    }

    public boolean isVictory(int id) {
        char verifySymbol;
        if (id == 1) verifySymbol = USER1;
        else verifySymbol = USER2;
        if (isLineVictory(verifySymbol)) return true;
        if (isDiagonalVictory(verifySymbol)) return true;
        return false;
    }

    public  void setSymbol(int id, String msg) {
        String[] coordinatesString = msg.split(Library.DELIMITER);
        int[] coordinates = new int[2];
        coordinates[0] = Integer.parseInt(coordinatesString[0]);
        coordinates[1] = Integer.parseInt(coordinatesString[1]);
        if (id == 1) gameMap[coordinates[0]][coordinates[1]] = USER1;
        else gameMap[coordinates[0]][coordinates[1]] = USER2;
    }

    public boolean  isLineVictory(char symbol) {
        int horizontal, vertical;
        for (int i = 0; i < gameMap.length; i++) {
            horizontal = 0;
            vertical = 0;
            for (int j = 0; j < gameMap.length; j++) {
                if (gameMap[i][j] == symbol) horizontal++;
                if (gameMap[j][i] == symbol) vertical++;
            }
            if (horizontal == gameMap.length || vertical == gameMap.length) return true;
        }
        return false;
    }

    public  boolean isDiagonalVictory(char symbol) {
        int mainDiagonal = 0, secondDiagonal = 0;
        for (int i = 0; i < gameMap.length; i++) {
            if(gameMap[i][i]==symbol) mainDiagonal++;
            if(gameMap[i][gameMap.length-1-i]==symbol) secondDiagonal++;
        }
        if(mainDiagonal==gameMap.length||secondDiagonal==gameMap.length) return true;
        return false;
    }
}
