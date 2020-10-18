import javax.swing.*;
import java.awt.*;
import java.net.Socket;

public class GameMap extends JFrame implements SocketThreadListener {
    public ThreadSocket threadSocket;
    public static int sizeOfMap;
    private static int WIDTH = 800;
    private static int HEIGHT = 800;
    private JPanel map;
    public JLabel miniLog = new JLabel();
    public MapElement[][] mapElements;
    private int userIndex;
    public boolean flag = false;

    public GameMap(int sizeOfMap, int userIndex, Socket socket) {
        this.userIndex = userIndex;
        if (userIndex == 1) flag = true;
        this.sizeOfMap = sizeOfMap;
        mapElements = new MapElement[sizeOfMap][sizeOfMap];
        SwingUtilities.invokeLater(() -> {
            initializationElements();
        });
        threadSocket = new ThreadSocket(userIndex, socket, this);
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
    public void onReceiveString(ThreadSocket thread, String msg) {
        String[] coordinatesString = msg.split(Library.DELIMITER);
        int[] coordinates = new int[2];
        coordinates[0] = Integer.parseInt(coordinatesString[0]);
        coordinates[1] = Integer.parseInt(coordinatesString[1]);
        if (userIndex == 2) mapElements[coordinates[0]][coordinates[1]].setUser1Symbol();
        else mapElements[coordinates[0]][coordinates[1]].setUser2Symbol();
        flag = true;
        miniLog.setText("You turn!");
    }
}
