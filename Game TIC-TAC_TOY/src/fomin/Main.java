package fomin;
//Содержит методы для преключения между режимами игры. Запускает стартовое окно с выбором параметров.
public class Main {
    static StartWindow startWindow;
    static GameWindow window;

    public static void main(String[] args) {
        startWindow = new StartWindow();
    }

   protected static void newGame() {
        window.dispose();
        window = new GameWindow();
    }
    protected static void newStartParametersGame(){
        startWindow.dispose();
        window=new GameWindow();
    }
    protected static void newParametersGame(){
        window.dispose();
        startWindow=new StartWindow();
    }
}

