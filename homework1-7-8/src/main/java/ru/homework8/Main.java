package ru.homework8;

public class Main {
    static GameWindow window;

    public static void main(String[] args) {
        window = new GameWindow();
    }

    static void newGame() {
        window.setVisible(false);
        window = new GameWindow();
    }
}
