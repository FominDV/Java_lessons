package ru.java_core_1.homework.fomin;

/*1. Полностью разобраться с кодом, попробовать переписать с нуля, стараясь не подглядывать в методичку;
        2. Переделать проверку победы, чтобы она не была реализована просто набором условий, например, с использованием циклов.
        3. * Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и количества фишек 4. Очень желательно не делать это просто набором условий для каждой из возможных ситуаций;
        4. *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.*/

import java.util.Scanner;
import java.util.Random;

public class FourthHomeWork {

    static char[][] map;
    static char USER_SYMBOL, MACHINE_SYMBOL;
    static final char EMPTY = '*';
    static int SIZE_OF_MAP, POINTS_FOR_WIN;
    static Scanner read = new Scanner(System.in);
    static Random random = new Random();

    //Preparation for the game
    static void setSymbols() {
        System.out.println("Chose your symbol, enter 'o' or 'x'");
        switch (read.nextLine()) {
            case "o":
                USER_SYMBOL = 'o';
                MACHINE_SYMBOL = 'x';
                break;
            case "x":
                USER_SYMBOL = 'x';
                MACHINE_SYMBOL = 'o';
                break;
            default:
                System.out.println("You entered wrong symbol!\nTry again!");
                setSymbols();
        }
    }

    static void setPointsAndSize() {
        while (true) {
            System.out.println("Chose size of the game map:");
            SIZE_OF_MAP = inputInteger();
            if (SIZE_OF_MAP > 2) {
                read.nextLine();
                break;
            } else {
                System.out.println("Size of the game map must de greater two!\nTry again!");
            }
        }
        while (true) {
            System.out.println("Insert count of points for win in this game:");
            POINTS_FOR_WIN = inputInteger();
            if (POINTS_FOR_WIN > 2 && POINTS_FOR_WIN <= SIZE_OF_MAP) {
                read.nextLine();
                break;
            } else {
                System.out.println("Count of points for win in this game must be greater 2 and less than " + (SIZE_OF_MAP + 1) + "!\nTry again!");
            }
        }
    }

    static int inputInteger() {
        while (true) {
            if (read.hasNextInt()) {
                return read.nextInt();
            } else {
                System.out.println("It is not integer value!\nTry again!");
                read.nextLine();
            }
        }
    }

    static void initMap() {
        map = new char[SIZE_OF_MAP][SIZE_OF_MAP];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                map[i][j] = EMPTY;
            }
        }
    }

    //Methods for body of the game
    static void printMap() {
        System.out.print("  ");
        for (int i = 1; i <= map.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 1; i <= map.length; i++) {
            System.out.print(i + " ");
            for (char symbol : map[i - 1]) {
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
    }

    static boolean isEmptyAndExist(int x, int y) {
        if (x >= 0 && x < map.length && y >= 0 && y < map.length && map[x][y] == EMPTY) {
            return true;
        } else {
            System.out.println("It's impossible!\nTry again!");
            return false;
        }
    }

    static void userTurn() {
        int x, y;
        do {
            System.out.println("Enter coordination of your turn (x,y)\nEnter X:");
            x = inputInteger() - 1;
            read.nextLine();
            System.out.println("Enter Y:");
            y = inputInteger() - 1;
            read.nextLine();
        } while (!(isEmptyAndExist(x, y)));
        map[x][y] = USER_SYMBOL;
    }

    static void machineTurn() {
        int x, y;
        do {
            x = random.nextInt(map.length);
            y = random.nextInt(map.length);
        } while (!(isEmptyAndExist(x, y)));
        map[x][y] = MACHINE_SYMBOL;
        System.out.println("Machine's turn is (" + x + "," + y + ")");
    }

    static boolean isVictory(char symbol) {
        int diagonalPoints1 = 0, diagonalPoints2 = 0, verticalPoints, horizontalPoints;
        for (int i = 0; i < map.length; i++) {
            verticalPoints = 0;
            horizontalPoints = 0;
            if (map[i][i] == symbol) {
                diagonalPoints1 += 1;
            } else {
                diagonalPoints1 = 0;
            }
            if (map[i][map.length - 1 - i] == symbol) {
                diagonalPoints2 += 1;
            } else {
                diagonalPoints2 = 0;
            }
            if (diagonalPoints1 == POINTS_FOR_WIN || diagonalPoints2 == POINTS_FOR_WIN) {
                return true;
            }
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == symbol) {
                    horizontalPoints += 1;
                } else {
                    horizontalPoints = 0;
                }
                if (map[j][i] == symbol) {
                    verticalPoints += 1;
                } else {
                    verticalPoints = 0;
                }
                if (horizontalPoints == POINTS_FOR_WIN || verticalPoints == POINTS_FOR_WIN) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean isFullMap() {
        for (int i = 0; i < map.length; i++) {
            for (char value : map[i]) {
                if (value == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }


    //Main method
    public static void main(String[] Args) {
        System.out.println("Hello! It's the TIC-TAC-toe game");
        setSymbols();
        setPointsAndSize();
        initMap();
        printMap();
        while (true) {
            userTurn();
            printMap();
            if (isVictory(USER_SYMBOL)) {
                System.out.println("You WON!");
                break;
            }
            machineTurn();
            printMap();
            if (isVictory(MACHINE_SYMBOL)) {
                System.out.println("You are lose!");
                break;
            }
            if (isFullMap()) {
                System.out.println("The game map is filled!\nThe game ended in a draw!");
                break;
            }
        }
    }
}
