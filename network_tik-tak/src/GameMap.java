import javax.swing.*;
import java.awt.*;
import java.net.Socket;

public class GameMap extends JFrame implements SocketThreadListener {
    public ThreadSocket threadSocket;
    public static int sizeOfMap = 3;
    private static int WIDTH = 800;
    private static int HEIGHT = 800;
    private JPanel map;
    public JLabel miniLog = new JLabel();
    public MapElement[][] mapElements;
    private int userIndex;
    public boolean flag = false;

    public GameMap( int userIndex, Socket socket) {
        this.userIndex = userIndex;
        if (userIndex == 1) flag = true;
        mapElements = new MapElement[sizeOfMap][sizeOfMap];
        SwingUtilities.invokeLater(() -> {
            initializationElements();
        });
        threadSocket = new ThreadSocket(this.userIndex, socket, this);
    }

    private void initializationElements() {
        setSize(WIDTH, HEIGHT);
        setTitle("Game Map");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        map = new JPanel(new GridLayout(sizeOfMap, sizeOfMap));
        addMapElements(map);
        miniLog.setFont(new Font("SANS_SERIF", Font.ITALIC, 30));
        miniLog.setText(String.valueOf(userIndex));
        add(miniLog, BorderLayout.NORTH);
        add(map, BorderLayout.CENTER);
        setVisible(true);
    }

    private void addMapElements(JPanel map) {
        for (int i = 0; i < sizeOfMap; i++) {
            for (int j = 0; j < sizeOfMap; j++) {
                MapElement mapElement = new MapElement(userIndex, this, i, j);
                map.add(mapElement);
                mapElements[i][j] = mapElement;
            }
        }
    }

    @Override
    public void onReceiveString(ThreadSocket thread, String msg, int id) {
        String[] coordinatesString = msg.split(Library.DELIMITER);
        if (coordinatesString.length == 3) {
            int[] coordinates = new int[2];
            coordinates[0] = Integer.parseInt(coordinatesString[1]);
            coordinates[1] = Integer.parseInt(coordinatesString[2]);
            if (coordinatesString[0].equals(Library.LOSE)) {
                miniLog.setText("LOSE");
                if (userIndex == 2) mapElements[coordinates[0]][coordinates[1]].setUser1Symbol();
                else mapElements[coordinates[0]][coordinates[1]].setUser2Symbol();
            }
            if (coordinatesString[0].equals(Library.VICTORY)) {
                miniLog.setText("VICTORY");
            }
        } else {
            int[] coordinates = new int[2];
            coordinates[0] = Integer.parseInt(coordinatesString[0]);
            coordinates[1] = Integer.parseInt(coordinatesString[1]);
            if (userIndex == 2) mapElements[coordinates[0]][coordinates[1]].setUser1Symbol();
            else mapElements[coordinates[0]][coordinates[1]].setUser2Symbol();
            flag = true;
            miniLog.setText("You turn!");
        }
    }

    public boolean isVictory(int id) {

        return false;
    }

    public void setSymbol(int id, String msg) {

    }

    public boolean isLineVictory(char symbol) {

        return false;
    }

    public boolean isDiagonalVictory(char symbol) {

        return false;
    }
}


