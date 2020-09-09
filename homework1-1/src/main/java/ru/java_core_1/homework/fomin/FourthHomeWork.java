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

    static boolean isVictory(char symbol) {
        int diagonalPoints1 = 0, diagonalPoints2 = 0, verticalPoints, horizontalPoints;
        for (int i = 0; i < map.length; i++) {
            verticalPoints = 0;
            horizontalPoints = 0;
            diagonalPoints1 = 0;
            diagonalPoints2 = 0;
            for (int j = 0, k = i; k < map.length; k++, j++) {
                if (map[k][j] == symbol) {
                    diagonalPoints1 += 1;
                } else {
                    diagonalPoints1 = 0;
                }
                if (map[k][map.length - 1 - j] == symbol) {
                    diagonalPoints2 += 1;
                } else {
                    diagonalPoints2 = 0;
                }
                if (diagonalPoints1 == POINTS_FOR_WIN || diagonalPoints2 == POINTS_FOR_WIN) {
                    return true;
                }
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

    //Methods for Machine's turn
    static void machineTurn() {
        int[] XY = {0, 0};
        XY = blockTurn(USER_SYMBOL, 2);
        if (XY[0] == -1) {
            XY = blockTurn(MACHINE_SYMBOL, (POINTS_FOR_WIN - 1));
            if (XY[0] == -1) {
                XY = randomTurn();
            }
        }
        map[XY[0]][XY[1]] = MACHINE_SYMBOL;
        System.out.println("Machine's turn is (" + (XY[0] + 1) + "," + (XY[1] + 1) + ")");
    }

    static int[] randomTurn() {
        int[] XY = {0, 0};
        do {
            XY[0] = random.nextInt(map.length);
            XY[1] = random.nextInt(map.length);
        } while (!(isEmpty(XY[0], XY[1])) && isRationalTurn(XY[0], XY[1]));
        return XY;
    }

    static boolean isRationalTurn(int x, int y) {
        if (x > 0 && y > 0 && x < (map.length - 1) && y < (map.length - 1)) {
            return true;
        } else {
            return false;
        }
    }

    static int[] blockTurn(char symbol, int maxRange) {
        int XY[] = {-1, -1};
        int diagonalPoints1 = 0;
        int[] buffer = {-1, -1};
        //Verify diagonal1
        for (int range = maxRange; range > 0; range--) {
            buffer[0] = -1;
            buffer[1] = -1;
            diagonalPoints1 = 0;
            for (int i = 0; i < map.length; i++) {
                if (map[i][i] == symbol) {
                    diagonalPoints1 += 1;
                } else {
                    if (diagonalPoints1 == (POINTS_FOR_WIN - range)) {
                        if (isEmpty(i, i)) {
                            XY[0] = i;
                            XY[1] = i;
                            break;
                        } else if (isEmpty(buffer[0], buffer[1])) {
                            XY[0] = buffer[0];
                            XY[1] = buffer[1];
                            break;
                        }
                    } else {
                        diagonalPoints1 = 0;
                        buffer[0] = i;
                        buffer[1] = i;
                    }
                }
            }
            if (XY[0] == -1 && buffer[0] != -1 && diagonalPoints1 == (POINTS_FOR_WIN - range) && isEmpty(buffer[0], buffer[1])) {
                XY[0] = buffer[0];
                XY[1] = buffer[1];
                break;
            }
            //Verify diagonal2
            int diagonalPoints2 = 0;
            buffer[0] = -1;
            buffer[1] = -1;
            for (int i = 0; i < map.length; i++) {
                if (map[i][map.length - 1 - i] == symbol) {
                    diagonalPoints2 += 1;
                } else {
                    if (diagonalPoints2 == (POINTS_FOR_WIN - range)) {
                        if (isEmpty(i, i)) {
                            XY[0] = i;
                            XY[1] = map.length - 1 - i;
                            break;
                        } else if (isEmpty(buffer[0], buffer[1])) {
                            XY[0] = buffer[0];
                            XY[1] = buffer[1];
                            break;
                        }
                    } else {
                        diagonalPoints2 = 0;
                        buffer[0] = i;
                        buffer[1] = map.length - 1 - i;
                    }
                }
            }
            if (XY[0] == -1 && buffer[0] != -1 && diagonalPoints2 == (POINTS_FOR_WIN - range) && isEmpty(buffer[0], buffer[1])) {
                XY[0] = buffer[0];
                XY[1] = buffer[1];
                break;
            }

            for (int i = 0; i < map.length; i++) {
                //Verify horizontal
                int horizontalPoints = 0;
                buffer[0] = -1;
                buffer[1] = -1;
                for (int j = 0; j < map.length; j++) {
                    if (map[i][j] == symbol) {
                        horizontalPoints += 1;
                    } else {
                        if (horizontalPoints == (POINTS_FOR_WIN - range)) {
                            if (isEmpty(i, j)) {
                                XY[0] = i;
                                XY[1] = j;
                                break;
                            } else if (isEmpty(buffer[0], buffer[1])) {
                                XY[0] = buffer[0];
                                XY[1] = buffer[1];
                                break;
                            }
                        } else {
                            horizontalPoints = 0;
                            buffer[0] = i;
                            buffer[1] = j;
                        }
                    }
                }
                if (XY[0] == -1 && buffer[0] != -1 && horizontalPoints == (POINTS_FOR_WIN - range) && isEmpty(buffer[0], buffer[1])) {
                    XY[0] = buffer[0];
                    XY[1] = buffer[1];
                    break;
                }
                //Verify vertical
                int verticalPoints = 0;
                buffer[0] = -1;
                buffer[1] = -1;
                for (int j = 0; j < map.length; j++) {
                    if (map[j][i] == symbol) {
                        verticalPoints += 1;
                    } else {
                        if (verticalPoints == (POINTS_FOR_WIN - range)) {
                            if (isEmpty(j, i)) {
                                XY[0] = j;
                                XY[1] = i;
                                break;
                            } else if (isEmpty(buffer[0], buffer[1])) {
                                XY[0] = buffer[0];
                                XY[1] = buffer[1];
                                break;
                            }
                        } else {
                            verticalPoints = 0;
                            buffer[0] = j;
                            buffer[1] = i;
                        }
                    }
                    if (XY[0] == -1 && buffer[0] != -1 && verticalPoints == (POINTS_FOR_WIN - range) && isEmpty(buffer[0], buffer[1])) {
                        XY[0] = buffer[0];
                        XY[1] = buffer[1];
                        break;
                    }
                }
            }
        }
        return XY;
    }

    static boolean isEmpty(int x, int y) {
        if (x >= 0 && y >= 0 && x < map.length && y < map.length && map[x][y] == EMPTY) {
            return true;
        } else
            return false;
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
