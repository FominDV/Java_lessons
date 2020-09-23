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
                        if (InterGame.isVictory(boxes, Boxes.USER)) {
                            endGame("VICTORY");
                        }else if (InterGame.isFullMap(boxes)) {
                            endGame("draw game");
                        } else {
                            InterGame.machineTurn(boxes);
                            if (InterGame.isVictory(boxes, Boxes.MACHINE)) {
                                endGame("LOSS");
                            }else if (InterGame.isFullMap(boxes)) {
                                endGame("draw game");
                            }
                        }
                    }
                }
            });
            map.add(box);
        }
        add(map, BorderLayout.CENTER);
    }

    JLabel ending = new JLabel();
    JPanel endButtons = new JPanel(new GridLayout(1, 2));
    Font endText = new Font("SANS_SERIF", Font.BOLD, 100);
    Font endButton = new Font("SANS_SERIF", Font.BOLD, 60);
    JButton exit = new JButton("Exit");
    JButton restart = new JButton("Restart");

    protected void endGame(String word) {
        map.setVisible(false);
        ending.setFont(endText);
        menu.setText(null);
        ending.setHorizontalAlignment(SwingConstants.CENTER);
        ending.setText(word);
        add(ending, BorderLayout.CENTER);
        exit.setFont(endButton);
        restart.setFont(endButton);
        setActionsEndingButtons();
        endButtons.add(exit);
        endButtons.add(restart);
        add(endButtons, BorderLayout.SOUTH);
    }

    protected void setActionsEndingButtons() {
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        restart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.newGame();
            }
        });
    }
}
