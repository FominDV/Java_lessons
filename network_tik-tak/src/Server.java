import sun.management.snmp.jvmmib.EnumJvmMemPoolType;

import java.net.ServerSocket;

public class Server  {
    protected char[][] gameMap = new char[GameMap.sizeOfMap][GameMap.sizeOfMap];


    public static void main(String[] args) {

        new ServerThread(8189);
    }

}
