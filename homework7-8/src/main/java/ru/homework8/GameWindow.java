package ru.homework8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameWindow extends JFrame {
    protected int sizeOfMap=3;
    private int height = 800;
    private int width = 700;
    GameWindow() {
        super();
        setTitle("Tic-tic-toe 3x3");
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
    protected Boxes[][] boxes=new Boxes[sizeOfMap][sizeOfMap];
    JPanel map = new JPanel(new GridLayout(sizeOfMap, sizeOfMap));
    JLabel menu = new JLabel();
    protected void makeMap() {
        add(menu, BorderLayout.NORTH);
        for (int i = 0; i < sizeOfMap; i++) {
            for (int j = 0; j < sizeOfMap; j++) {
                boxes[i][j] = new Boxes(i, j);
                boxes[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Boxes.setCross(boxes);
                    }
                });
                map.add(boxes[i][j]);
            }
        }
        add(map, BorderLayout.CENTER);
    }

}
