package ru.homework8;

import java.util.Random;

public class ArtificialIntelligenceLevel0 {
    static Random random = new Random();

    protected static void turnAI0(Boxes[][] boxes) {
        while (true) {
            int numberOfBoxX = random.nextInt(boxes.length);
            int numberOfBoxY = random.nextInt(boxes.length);
            if (boxes[numberOfBoxX][numberOfBoxY].isEmpty() && numberOfBoxX > 0 && numberOfBoxX < boxes.length - 1 && numberOfBoxY > 0 && numberOfBoxY < boxes.length - 1) {
                boxes[numberOfBoxX][numberOfBoxY].setCircle();
                break;
            }
        }
    }
}
