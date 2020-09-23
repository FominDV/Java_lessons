package ru.homework8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameWindow extends JFrame {
    protected int sizeOfMap = 3;
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

    JPanel map = new JPanel(new GridLayout(sizeOfMap, sizeOfMap));
    Boxes boxes[] = new Boxes[sizeOfMap * sizeOfMap];
    JLabel menu = new JLabel();

    protected void makeMap() {
        add(menu, BorderLayout.NORTH);
        for (int i = 0; i < boxes.length; i++) {
            final Boxes box = new Boxes();
            box.setName(String.valueOf(i));
            boxes[i] = box;
            box.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (box.isEmpty()) {
                        box.setCross();
                        boxes[Integer.parseInt(box.getName())] = box;
                        if (InterGame.verifyVictory(boxes, Boxes.USER)) {
                            victory();
                        }
                        InterGame.machineTurn(boxes);
                        if (InterGame.verifyVictory(boxes, Boxes.MACHINE)) {
                            loss();
                        }
                    }
                }
            });
            map.add(box);
        }
        add(map, BorderLayout.CENTER);
    }
    protected void victory(){
        map.setVisible(false);
    }
    protected void loss(){
        map.setVisible(false);
    }
}
