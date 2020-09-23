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

    static boolean verifyVictory(Boxes[] boxes, char symbol) {
        int pointsHorizontal, pointsVertical;
        int length=(int)Math.sqrt(boxes.length);
        for (int i = 0; i < boxes.length; i+=3) {
            pointsHorizontal=0;
            pointsVertical=0;
            for(int j=i, k=0; j<length+i;j++, k++) {
                if (boxes[j].isSymbol(symbol)) {
                    pointsHorizontal++;
                }
                if(boxes[k*length+i/3].isSymbol(symbol)){
                    pointsVertical++;
                }
            }
            if(pointsHorizontal==length||pointsVertical==length){
                return true;
            }
        }
        return false;
    }

}
