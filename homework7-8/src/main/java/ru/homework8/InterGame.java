package ru.homework8;

import java.util.Random;

public class InterGame {
    static Random random = new Random();
    private static int pointsToWin = 3;

    static void machineTurn(Boxes[][] boxes) {
        while (true) {
            int numberOfBoxX = random.nextInt(boxes.length);
            int numberOfBoxY = random.nextInt(boxes.length);
            if (boxes[numberOfBoxX][numberOfBoxY].isEmpty()) {
                boxes[numberOfBoxX][numberOfBoxY].setCircle();
                break;
            }
        }
    }

    static boolean isFullMap(Boxes[][] boxes) {
        for (int i = 0; i < boxes.length; i++) {
            for (int j = 0; j < boxes.length; j++) {
                if (boxes[i][j].isEmpty()) {
                    return false;
                }
            }
        }
        return true;

    }

    private static int pointsHorizontal, pointsVertical, pointsMainDiagonal1, pointsMainDiagonal2, pointsSecondaryDiagonal1, pointsSecondaryDiagonal2;

    static boolean isVictory(Boxes[][] boxes, char symbol) {
        for (int i = 0; i < boxes.length; i++) {
            if (isFullLinesForVictory(boxes, symbol, i)) return true;
            if (isFullDiagonalsForVictory(boxes, symbol)) return true;
        }
        return false;
    }

    private static boolean isFullLinesForVictory(Boxes[][] boxes, char symbol, int i) {
        pointsHorizontal = 0;
        pointsVertical = 0;
        for (int j = 0; j < boxes.length; j++) {
            if (boxes[i][j].isSymbol(symbol)) {
                pointsHorizontal++;
                if (pointsHorizontal == pointsToWin) return true;
            } else {
                pointsHorizontal = 0;
            }
            if (boxes[j][i].isSymbol(symbol)) {
                pointsVertical++;
                if (pointsVertical == pointsToWin) return true;
            } else {
                pointsVertical = 0;
            }
        }
        return false;
    }

    private static boolean isFullDiagonalsForVictory(Boxes[][] boxes, char symbol) {
        for (int i = 0; i <= (boxes.length - pointsToWin); i++) {
            pointsMainDiagonal1 = 0;
            pointsMainDiagonal2 = 0;
            pointsSecondaryDiagonal1 = 0;
            pointsSecondaryDiagonal2 = 0;
            for (int j = 0; j < boxes.length; j++) {
                if ((i + j) < boxes.length && boxes[i + j][j].isSymbol(symbol)) {
                    pointsMainDiagonal1++;
                    if (pointsMainDiagonal1 == pointsToWin) return true;
                } else {
                    pointsMainDiagonal1 = 0;
                }
                if ((i + j) < boxes.length && boxes[j][j + i].isSymbol(symbol)) {
                    pointsMainDiagonal2++;
                    if (pointsMainDiagonal2 == pointsToWin) return true;
                }else{
                    pointsMainDiagonal2=0;
                }
                if ((i + j) < boxes.length && boxes[i + j][boxes.length - j-1].isSymbol(symbol)) {
                    pointsSecondaryDiagonal1++;
                    if (pointsSecondaryDiagonal1 == pointsToWin) return true;
                } else {
                    pointsSecondaryDiagonal1 = 0;
                }
                if ((i + j) < boxes.length && boxes[j][boxes.length - j - i-1].isSymbol(symbol)) {
                    pointsSecondaryDiagonal2++;
                    if (pointsSecondaryDiagonal2 == pointsToWin) return true;
                } else {
                    pointsSecondaryDiagonal2 = 0;
                }
            }
        }
        return false;
    }
}