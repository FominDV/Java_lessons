package com.company;

public class ConvertStringArrayToIntArrayException extends NumberFormatException {
    private StackTraceElement[] stackTrace;

    ConvertStringArrayToIntArrayException(StackTraceElement[] stackTrace) {
        super("ConvertStringArrayToIntArrayException\nEverybody elements of String array are not numbers!\nProcessing of calculation was stopped!");
        this.stackTrace = stackTrace;
    }

    public void printStackTrace() {
        System.err.println("StackTrace:");
        for (StackTraceElement element : stackTrace) {
            System.err.println(element);
        }
    }
}
