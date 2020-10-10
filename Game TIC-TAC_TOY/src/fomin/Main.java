package fomin;

public class Main {
    static GameWindow window;

    public static void main(String[] args) {
        window = new GameWindow();
    }

    static void newGame() {
        window.dispose();
        window = new GameWindow();
    }
}

