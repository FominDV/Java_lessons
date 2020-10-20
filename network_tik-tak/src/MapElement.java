import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MapElement extends JButton implements ActionListener {
    protected static char user1Symbol = 'x';
    protected static char user2Symbol = 'o';
    protected static char empty = 'e';
    private char symbolOfElement = empty;
    private int index;
    private GameMap map;
    private int[] coordinates = new int[2];

    public MapElement(int index, GameMap map, int i, int j) {
        this.map = map;
        this.index = index;
        setFont(new Font("SANS_SERIF", Font.BOLD, 200));
        addActionListener(this);
        coordinates[0] = i;
        coordinates[1] = j;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (map.flag == true && symbolOfElement == empty) {
            if (index == 1) setUser1Symbol();
            else setUser2Symbol();
            map.threadSocket.sendMessage(Library.getMessageForSendingCoordinates(coordinates));
            map.flag = false;
            map.miniLog.setText("Your opponent's turn!");
        }
    }

    public char getSymbol() {
        return symbolOfElement;
    }

    public void setUser1Symbol() {
        this.setText(String.valueOf(user1Symbol));
        symbolOfElement = user1Symbol;
    }

    public void setUser2Symbol() {
        this.setText(String.valueOf(user2Symbol));
        symbolOfElement = user2Symbol;
    }
}
