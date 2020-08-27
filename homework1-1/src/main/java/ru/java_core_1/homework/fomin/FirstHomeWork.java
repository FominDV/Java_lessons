package ru.java_core_1.homework.fomin;

public class FirstHomeWork {
    public static void main(String args[]) {
        //initialization of primitive types
        byte byteNumber = 17;
        short shotNumber = 32760;
        int integerNumber = 2100200300;
        long longNumber = 2345345356363636L;
        float floatNumber = 2.5f;
        double doubleNumber = 9.834;
        char symbol = 'F';
        boolean flag = true;
        System.out.println("a*(b+c/d)="+getCalculate(2.5,3L,10,floatNumber));
    }

    //part 3
    public static double getCalculate(double a, long b, int c, float d) {
    return a*(b+c/d);
    }
    //part 4

}
