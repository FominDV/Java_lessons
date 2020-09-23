package ru.homework8;

import java.util.Random;

public class InterGame {
    static Random random = new Random();

    static void machineTurn(Boxes[] boxes) {
        while (true) {
            int numberOfBox = random.nextInt(9);
            if (boxes[numberOfBox].isEmpty()) {
                boxes[numberOfBox].setCircle();
                break;
            }
        }
    }

    static boolean isFullMap(Boxes[] boxes) {
        for (int i = 0; i < boxes.length; i++) {
            if (boxes[i].isEmpty()) {
                return false;
            }
        }
        return true;
    }

    static boolean isVictory(Boxes[] boxes, char symbol) {
        int pointsHorizontal, pointsVertical, diagonal1 = 0, diagonal2 = 0;
        int length = (int) Math.sqrt(boxes.length);
        for (int i = 0, h = 0; i < boxes.length; i += 3, h += 4) {
            if (boxes[h].isSymbol(symbol)) {
                diagonal1++;
            }
            if (boxes[h / 2 + 2].isSymbol(symbol)) {
                diagonal2++;
            }
            pointsHorizontal = 0;
            pointsVertical = 0;
            for (int j = i, k = 0; j < length + i; j++, k++) {
                if (boxes[j].isSymbol(symbol)) {
                    pointsHorizontal++;
                }
                if (boxes[k * length + i / 3].isSymbol(symbol)) {
                    pointsVertical++;
                }
            }
            if (pointsHorizontal == length || pointsVertical == length || diagonal1 == length || diagonal2 == length) {
                return true;
            }
        }

        return false;
    }
}
