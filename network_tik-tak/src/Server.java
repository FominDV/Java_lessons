import sun.management.snmp.jvmmib.EnumJvmMemPoolType;

import java.net.ServerSocket;

public class Server {
    protected static char[][] gameMap = new char[GameMap.sizeOfMap][GameMap.sizeOfMap];
    private static char USER1 = '1';
    private static char USER2 = '2';
    private static char EMPTY = '0';

    public static void main(String[] args) {
        for (int i = 0; i < gameMap.length; i++) {
            for (int j = 0; j < gameMap.length; j++) {
                gameMap[i][j] = EMPTY;
            }
        }
        new ServerThread(8189);
    }

    public static boolean isVictory(int id) {
        char verifySymbol;
        if (id == 1) verifySymbol = USER1;
        else verifySymbol = USER2;
        if (isLineVictory(verifySymbol)) return true;
        if (isDiagonalVictory(verifySymbol)) return true;
        return false;
    }

    public static void setSymbol(int id, String msg) {
        String[] coordinatesString = msg.split(Library.DELIMITER);
        int[] coordinates = new int[2];
        coordinates[0] = Integer.parseInt(coordinatesString[0]);
        coordinates[1] = Integer.parseInt(coordinatesString[1]);
        if (id == 1) gameMap[coordinates[0]][coordinates[1]] = USER1;
        else gameMap[coordinates[0]][coordinates[1]] = USER2;
    }

    private static boolean isLineVictory(char symbol) {
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

    private static boolean isDiagonalVictory(char symbol) {
        int mainDiagonal = 0, secondDiagonal = 0;
        for (int i = 0; i < gameMap.length; i++) {
            if(gameMap[i][i]==symbol) mainDiagonal++;
            if(gameMap[i][gameMap.length-1-i]==symbol) secondDiagonal++;
        }
        if(mainDiagonal==gameMap.length||secondDiagonal==gameMap.length) return true;
        return false;
    }
}
