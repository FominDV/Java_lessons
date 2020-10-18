public class Library {
    static final String DELIMITER = ":";
    static final String READY="ready";

    static String getMessageForSending(int[] coordinates) {
        return String.valueOf(coordinates[0]) + DELIMITER + String.valueOf(coordinates[1]);
    }


}
