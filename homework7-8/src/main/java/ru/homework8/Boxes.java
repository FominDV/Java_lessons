package ru.homework8;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class Boxes extends JButton {
    protected char symbol;
    //'e' is 'empty'
Boxes(){
    setFont(new Font("SANS_SERIF", Font.BOLD,200));
    symbol='e';
}
protected boolean isEmpty(){
        if(symbol=='e'){
            return true;
        }else{
            return false;
        }
}
    protected void setCircle() {
            symbol = 'o';
            setText("O");
    }

     protected void setCross() {
            symbol = 'x';
            setText("X");

    }
}
