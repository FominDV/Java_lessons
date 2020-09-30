package com.company;

public class ConvertStringArrayToIntArrayException extends NumberFormatException {
    private StackTraceElement[] stackTrace;

    ConvertStringArrayToIntArrayException(StackTraceElement[] stackTrace) {
        super("Error\nEverybody elements of String array are not numbers!\nProcessing of calculation was stopped!");
        this.stackTrace = stackTrace;
    }

    public void printStackTrace() {
        for (StackTraceElement element : stackTrace) {
            System.out.println(element);
        }
    }
}
