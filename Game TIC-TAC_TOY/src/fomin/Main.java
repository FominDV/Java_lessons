package fomin;

public class Main {
    static StartWindow startWindow;
    static GameWindow window;

    public static void main(String[] args) {
        startWindow = new StartWindow();
    }

    static void newGame() {
        window.dispose();
        window = new GameWindow();
    }
}

