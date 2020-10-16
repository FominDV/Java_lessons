package fomin;

public class ArtificialIntelligenceLevel2 extends ArtificialIntelligenceLevel1 {

    protected static void turnAI2(Boxes[][] boxes, int pointsToWin, int maxVerifyPoints) {
        for (int i = 1; i < pointsToWin; i++) {
            if (i > maxVerifyPoints) {
                if (!isTurnAI2Realization(boxes, i, pointsToWin)) {
                    turnAI0(boxes);
                }
            } else {
                if (!isTurnAI2Realization(boxes, i, pointsToWin)) {
                    if (!isTurnAI1Realization(boxes, i, pointsToWin)) {
                        turnAI0(boxes);
                    }
                }
            }
        }
    }

    protected static boolean isTurnAI2Realization(Boxes[][] boxes, int maxPreVictory, int pointsToWin) {
        int newPointsToWin;
        for (int preVictory = 1; preVictory <= maxPreVictory; preVictory++) {
            newPointsToWin = pointsToWin - preVictory;
            if (isMadeLineTurnImportant(boxes, pointsToWin - preVictory + 1)) return true;
            if (isMadeDiagonalTurnImportant(boxes, pointsToWin - preVictory + 1)) return true;
            for (int i = 0; i < boxes.length; i++) {
                if (isMadeLineTurn(boxes, i, newPointsToWin, preVictory)) return true;
                if (isMadeDiagonalTurn(boxes, i, newPointsToWin, preVictory)) return true;
            }
        }
        return false;
    }
}
