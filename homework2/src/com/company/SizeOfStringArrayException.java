package com.company;

public class SizeOfStringArrayException extends Exception {
    SizeOfStringArrayException(int wrongLength, int i, int j) {
        super("Size of String Array must be " + i + " by " + j + "\nOne from lengths of this array is " + wrongLength + "!\nProcessing of calculation was stopped!");
    }
}
