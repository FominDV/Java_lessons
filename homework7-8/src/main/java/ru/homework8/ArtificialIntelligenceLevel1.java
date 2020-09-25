package ru.homework8;

public class ArtificialIntelligenceLevel1 extends ArtificialIntelligenceLevel0 {
    private static int pointsHorizontal, pointsVertical, pointsMainDiagonal1, pointsMainDiagonal2, pointsSecondaryDiagonal1, pointsSecondaryDiagonal2;

    protected static void turnAI1(Boxes[][] boxes, int pointsToWin) {
        if (!isTurnAI1Realization(boxes, 2, pointsToWin)) {
            turnAI0(boxes);
        }
    }

    protected static boolean isTurnAI1Realization(Boxes[][] boxes, int maxPreVictory, int pointsToWin) {
        int[] machineTurn = {-1, -1};
        int newPointsToWin;
        for (int preVictory = 1; preVictory <= maxPreVictory; preVictory++) {
            newPointsToWin = pointsToWin - preVictory;
            for (int i = 0; i < boxes.length; i++) {
                if (isMadeLineTurn(boxes, i, newPointsToWin, preVictory)) return true;

            }
        }
        return false;
    }

    private static boolean isMadeLineTurn(Boxes[][] boxes, int i, int pointsToWin, int needingPoints) {
        pointsHorizontal = 0;
        pointsVertical = 0;
        for (int j = 0; j < boxes.length; j++) {
            if (boxes[i][j].isSymbol(Boxes.USER)) {
                pointsHorizontal++;
                if (pointsHorizontal == pointsToWin) {
                    if (isEmptyNextBoxForLine(boxes, i, j + 1, 'e', needingPoints) && isMachineMadeTurn(boxes[i][j + 1])) {
                        return true;
                    } else if (j - pointsToWin >= 0 && isEmptyNextBoxForLine(boxes, i, j - pointsToWin, 'w', needingPoints) && isMachineMadeTurn(boxes[i][j - pointsToWin])) {
                        return true;
                    }
                }
            } else {
                pointsHorizontal = 0;
            }
            if (boxes[j][i].isSymbol(Boxes.USER)) {
                pointsVertical++;
                if (pointsVertical == pointsToWin) {
                    if (isEmptyNextBoxForLine(boxes, j + 1, i, 's', needingPoints) && isMachineMadeTurn(boxes[j + 1][i])) {
                        return true;
                    } else if (j - pointsToWin >= 0 && isEmptyNextBoxForLine(boxes, j - pointsToWin, i, 'n', needingPoints) && isMachineMadeTurn(boxes[j - pointsToWin][i])) {
                        return true;
                    }
                }
            } else {
                pointsVertical = 0;
            }
        }
        return false;
    }

    protected static boolean isMachineMadeTurn(Boxes box) {
        if (box.isEmpty()) {
            box.setCircle();
            return true;
        } else {
            return false;
        }
    }

    private static boolean isEmptyNextBoxForLine(Boxes[][] boxes, int i, int j, char side, int needingPoints) {
        int points;
        switch (side) {
            case 'n':
                points=i-needingPoints+1;
                if (points >= 0 && (boxes[points][j].isEmpty() || boxes[points][j].isSymbol(Boxes.USER))) {
                    return true;
                } else {
                    return false;
                }
            case 'e':
                points=j+needingPoints-1;
                if (points < boxes.length && (boxes[i][points].isEmpty() || boxes[i][points].isSymbol(Boxes.USER))) {
                    return true;
                } else {
                    return false;
                }
            case 's':
                points=i+needingPoints-1;
                if (points < boxes.length && (boxes[points][j].isEmpty() || boxes[points][j].isSymbol(Boxes.USER))) {
                    return true;
                } else {
                    return false;
                }
            case 'w':
                points = j - needingPoints + 1;
                if (points >= 0 && (boxes[i][points].isEmpty() || boxes[i][points].isSymbol(Boxes.USER))) {
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }
}

