import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static java.lang.Math.*;

public class MouseActions extends MouseAdapter {
    MainCircles gameController;

    public MouseActions(MainCircles gameController) {
        super();
        this.gameController = gameController;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        float x = e.getX();
        float y = e.getY();
        switch (e.getButton()) {
            case MouseEvent.BUTTON1:
                addBall(gameController, x, y);
                break;
            case MouseEvent.BUTTON3:
                removeBall(gameController, x, y);
        }
    }

    private void addBall(MainCircles gameController, float x, float y) {
        Sprite[] sprites = new Sprite[gameController.sprites.length + 1];
        for (int i = 0; i < gameController.sprites.length; i++) {
            sprites[i] = gameController.sprites[i];
        }
        gameController.sprites = sprites;
        gameController.sprites[sprites.length - 1] = new Ball(x, y);
    }

    private void removeBall(MainCircles gameController, float x, float y) {
        for (int i = 0; i < gameController.sprites.length; i++) {
            if (sqrt(pow(gameController.sprites[i].x - x, 2) + pow(gameController.sprites[i].y - y, 2)) <= gameController.sprites[i].halfWidth) {
                rewriteSprites(gameController, i);
                break;
            }
        }
    }

    private void rewriteSprites(MainCircles gameController, int indexOfRemovedBall) {
        Sprite[] sprite = new Sprite[gameController.sprites.length - 1];
        for (int i = 0; i < indexOfRemovedBall; i++) {
            sprite[i] = gameController.sprites[i];
        }
        for (int i = indexOfRemovedBall; i < sprite.length; i++) {
            sprite[i] = gameController.sprites[i + 1];
        }
        gameController.sprites = sprite;
    }
}


