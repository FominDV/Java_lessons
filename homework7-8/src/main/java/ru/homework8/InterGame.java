package ru.homework8;

import java.util.Random;

public class InterGame {
    static Random random = new Random();

    static void machineTurn(Boxes[] boxes, int sizeOfMap) {
        while (true) {
            int numberOfBox = random.nextInt(9);
                if (boxes[numberOfBox].isEmpty()) {
                    boxes[numberOfBox].setCircle();
                    break;
            }
        }
    }

}
