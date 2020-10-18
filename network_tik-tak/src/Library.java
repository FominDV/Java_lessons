public class Library {
    static final String DELIMITER = ":";
    static final String READY = "ready";
    static final String VICTORY = "victory";
    static final String LOSE = "lose";

    static String getMessageForSendingCoordinates(int[] coordinates) {
        return String.valueOf(coordinates[0]) + DELIMITER + String.valueOf(coordinates[1]);
    }

    static String getMessageForSendingLose(String msg) {
        return LOSE + msg;
    }

    static String getMessageForSendingVictory(String msg) {
        return VICTORY + msg;
    }

}
