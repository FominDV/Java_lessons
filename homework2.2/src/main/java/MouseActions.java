import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseActions extends MouseAdapter {
    MainCircles gameController;

    public MouseActions(MainCircles gameController) {
        super();
        this.gameController = gameController;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        switch (e.getButton()) {
            case MouseEvent.BUTTON1:
                addBall(gameController, x, y);
                break;
            case MouseEvent.BUTTON3:
                removeBall();
                break;
        }
    }

    private void addBall(MainCircles gameController, int x, int y) {
        Sprite[] sprites = new Sprite[gameController.sprites.length + 1];
        for (int i = 0; i < gameController.sprites.length; i++) {
            sprites[i] = gameController.sprites[i];
        }
        gameController.sprites = sprites;
        gameController.sprites[sprites.length - 1] = new Ball(x, y);
    }

    private void removeBall() {

    }
}


