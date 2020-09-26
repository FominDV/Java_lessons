package ru.homework8;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class Boxes extends JButton {
    protected char symbol;
    static final char EMPTY = 'e';
    static final char USER = 'X';
    static final char MACHINE = 'O';
    private static int SIZE_OF_TEXT_INTO_BOX = (int) (GameWindow.height/(GameWindow.sizeOfMap*2));
    //'e' is 'empty'
    Boxes() {
        setFont(new Font("SANS_SERIF", Font.BOLD, SIZE_OF_TEXT_INTO_BOX));
        symbol = EMPTY;
    }

    protected boolean isEmpty() {
        if (symbol == EMPTY) {
            return true;
        } else {
            return false;
        }
    }

    protected void setCircle() {
        symbol = MACHINE;
        setText(String.valueOf(MACHINE));
    }

    protected void setCross() {
        symbol = USER;
        setText(String.valueOf(USER));
    }

    protected void setColor() {
        setBackground(Color.RED);
    }

    protected boolean isSymbol(char symbol) {
        if (this.symbol == symbol) {
            return true;
        } else {
            return false;
        }
    }
}
