package ru.java_core_1.homework.fomin;


import java.util.Scanner;

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
        String line = "Hello World";
        System.out.println("a*(b+c/d)="+getCalculate(2.5,3L,10,floatNumber));
        System.out.println("the sum of numbers less than or equal to 20 and greater than 10: " + isCompareNumbers(7.6, floatNumber ));
        setCompareZero(integerNumber);
        System.out.println("number is negative: " + isNegative(47));
        //Read name from console and method "setHello" call
        Scanner input = new Scanner(System.in);
        System.out.println("What is your name?\nInput your name: ");
        String name = input.nextLine();
        setHello(name);
    }

    //part 3
    public static double getCalculate(double a, long b, int c, float d) {

        return a*(b+c/d);
    }
    //part 4
    public static boolean isCompareNumbers(double firstNumber, float secondNumber){
        double sum = firstNumber + secondNumber;
        return (sum > 10) && (sum <=20);
    }
    //part5
    public static void setCompareZero(int number){
        if(number>=0)
            System.out.println(number + " is greater than or equal to zero");
        else
            System.out.println(number + " is less than zero");
    }
    //part6
    public static boolean isNegative(int number){
        return (number<0);
    }
    //part 7
    public static void setHello(String name){
        System.out.println("Привет, " + name);
    }
   
}
