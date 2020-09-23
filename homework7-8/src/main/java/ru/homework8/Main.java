package ru.homework8;

public class Main {
   static GameWindow window ;
    public static void main(String[] args) {
        window = new GameWindow();
        window.makeMap();
        window.menu.setText("Let's play! Your symbol is 'CROSS'");
    }

    static void newGame() {
        window.setVisible(false);
        window=new GameWindow();
        window.makeMap();
        window.menu.setText("Let's play! Your symbol is 'CROSS'");
    }
}
