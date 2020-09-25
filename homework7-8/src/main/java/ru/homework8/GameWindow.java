package ru.homework8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameWindow extends JFrame {
    protected static int sizeOfMap = 5;
    private int height = 1000;
    private int width = 1000;

    GameWindow() {
        super();
        setTitle("Tic-tic-toe by Dmitriy Fomin");
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        makeMap();
    }

    JPanel map = new JPanel(new GridLayout(sizeOfMap, sizeOfMap));
    Boxes boxes[][] = new Boxes[sizeOfMap][sizeOfMap];
    protected void makeMap() {
        for (int i = 0; i < boxes.length; i++) {
            for (int j = 0; j < boxes.length; j++) {
                final Boxes box = new Boxes();
                box.setName(i+""+j);
                boxes[i][j] = box;
                box.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (box.isEmpty()) {
                            box.setCross();
                            boxes[Character.getNumericValue(box.getName().charAt(0))][Character.getNumericValue(box.getName().charAt(1))] = box;
                            if (InterGame.isVictory(boxes, Boxes.USER)) {
                                JOptionPane.showMessageDialog(null,"It was last turn!");
                                endGame("VICTORY");
                            }
                            if (InterGame.isFullMap(boxes)) {
                                endGame("draw game");
                            } else {
                                InterGame.machineTurn(boxes);
                                if (InterGame.isVictory(boxes, Boxes.MACHINE)) {
                                    JOptionPane.showMessageDialog(null,"It was last turn!");
                                    endGame("LOSS");
                                }
                                if (InterGame.isFullMap(boxes)) {
                                    endGame("draw game");
                                }
                            }
                        }
                    }
                });
                map.add(box);
            }
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
