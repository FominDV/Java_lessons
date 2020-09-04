package ru.java_core_1.homework.fomin;

/*1. Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать это число.
 * При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или меньше.
 * После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
 * 2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
 * "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin",
 * "potato"}; */
/*При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
apple – загаданное
apricot - ответ игрока
ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
Для сравнения двух слов посимвольно, можно пользоваться:
String str = "apple";
str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
Играем до тех пор, пока игрок не отгадает слово
Используем только маленькие буквы*/

import java.util.Random;
import java.util.Scanner;

public class ThirdHomeWork {
    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        //Task1
        guessTheNumberGame();
    }

    //Methods for task1
    static int generateRandomNumber(int range) {
        Random random = new Random();
        return random.nextInt(range);
    }

    static void guessTheNumberGame() {
        while (true) {
            bodyOfGame(3);
            if (playerAnswer() == 0) break;
        }
    }

    static void bodyOfGame(int attempts) {
        System.out.println("You should guess the number from 0 to 9 for three attempts!\nLet's start!");
        int randomNumber = generateRandomNumber(10);
        int playerNumber;
        for (int attemptNow = attempts; attemptNow > 0; attemptNow--) {
            System.out.println("Now range of your attempt is " + attemptNow);
            System.out.print("Inter your answer: ");
            playerNumber = read.nextInt();
            if (playerNumber < randomNumber) {
                System.out.println(playerNumber + " is less than guess number");
            } else if (playerNumber > randomNumber) {
                System.out.println(playerNumber + " is greater than guess number");
            } else {
                System.out.println("You are WIN! It's really was " + randomNumber);
                return;
            }
        }
        System.out.println("Sorry, you have not more attempts!\nThe guess number was " + randomNumber);
    }

    static int playerAnswer() {
        int answer = 2;
        do {
            System.out.println("If you want to play again - write 1\nFor exit write 0");
            answer = read.nextInt();
        } while (answer != 0 && answer != 1);
        return answer;
    }
}
