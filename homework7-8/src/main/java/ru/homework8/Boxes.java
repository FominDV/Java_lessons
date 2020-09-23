package ru.homework8;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class Boxes extends JButton {
    private int x, y;
    private char symbol;

    //'e' is 'empty'
    Boxes(int x, int y) {
        setFont( new Font("SANS_SERIF",Font.BOLD,200));
        this.x = x;
        this.y = y;
        symbol = 'e';
    }


    static void setCircle(Boxes box) {
        box.symbol = 'o';
        box.setText("O");
    }

     static void setCross(Boxes box) {
        box.symbol = 'x';
        box.setText("X");
    }
}
