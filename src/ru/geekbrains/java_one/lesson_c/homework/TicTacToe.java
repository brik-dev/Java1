package ru.geekbrains.java_one.lesson_c.homework;

import java.util.Random;
import java.util.Scanner;

/**
 * Полностью разобраться с кодом;
 * Переделать проверку победы, чтобы она не была реализована просто набором условий.
 * * Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и количества фишек 4.
 * *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока, и пытаться выиграть сам.
 */

public class TicTacToe {
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = '-';
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();
    private static int fieldSizeY;
    private static int fieldSizeX;
    private static char[][] field;
    private static int winCombination = 3;

    private static void initField() {
        fieldSizeX = 3;
        fieldSizeY = 3;
        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    private static void printField() {
        System.out.print("+");
        for (int x = 0; x < fieldSizeX * 2 + 1; x++)
            System.out.print((x % 2 == 0) ? "-" : x / 2 + 1);
        System.out.println();

        for (int y = 0; y < fieldSizeY; y++) {
            System.out.print(y + 1 + "|");
            for (int x = 0; x < fieldSizeX; x++)
                System.out.print(field[y][x] + "|");
            System.out.println();
        }

        for (int x = 0; x <= fieldSizeX * 2 + 1; x++)
            System.out.print("-");
        System.out.println();

//        for (int y = 0; y < fieldSizeY; y++) {
//            for (int x = 0; x < fieldSizeX; x++) {
//                //formatted output (String.format())
//                System.out.printf("%c", field[y][x]); // placeholder
//            }
//            System.out.println();
//        }
    }
    private static void humanTurn() {
        int x;
        int y;
        do {
            System.out.println("Enter the coordinates X и Y (from 1 to 5) for your turn with a space in between >>>");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isValidCell(x, y) || !isEmptyCell(x, y));
        field[y][x] = DOT_HUMAN;
    }

    private static boolean isEmptyCell(int x, int y) {
        return field[y][x] == DOT_EMPTY;
    }

    private static boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    // aiTurn random x y
//    private static void aiTurn() {
//        int x;
//        int y;
//        do {
//            x = RANDOM.nextInt(fieldSizeX);
//            y = RANDOM.nextInt(fieldSizeY);
//        } while (!isEmptyCell(x, y));
//        field[y][x] = DOT_AI;
//    }

    //aiTurn intelligent
    private static void aiTurn() {
        int x = 0;
        int y = 0;

        int diagonal = checkDiagonal();
        int vertical = checkVertical();
        int horizontal = checkHorizontal();

        if(diagonal > vertical || diagonal > horizontal){
            for (int i = 0, j = 0; i < fieldSizeY; i++, j++) {
                if(field[i][j] == DOT_HUMAN && isValidCell(i+1, j+1) && (!isEmptyCell(i+1, j+1))){
                    x = i+1;
                    y = j+1;
                }
            }
        } else if (vertical > diagonal || vertical > horizontal){
            for (int j = 0; j < fieldSizeX; j++) {
                for (int i = 0; i < fieldSizeY; i++) {
                    if(field[i][j] == DOT_HUMAN && isValidCell(i+1, j) && (!isEmptyCell(i+1, j))){
                        x = i;
                        y = j+1;
                    }
                }
            }
        }else{
            for (int i = 0; i < fieldSizeX; i++) {
                for (int j = 0; j < fieldSizeY; j++) {
                    if(field[i][j] == DOT_HUMAN && isValidCell(i, j+1) && (!isEmptyCell(i, j+1))){
                        x = i+1;
                        y = j;
                    }
                }
            }
        }
        field[y][x] = DOT_AI;
    }

    private static int checkDiagonal(){
        int countXinDiagonal = 0;
        for (int i = 0, j = 0; i < fieldSizeY; i++, j++) {
            if(field[i][j] == DOT_HUMAN) countXinDiagonal++;
        }
        return countXinDiagonal;
    }

    private static int checkVertical(){
        int countXinVertical = 0;
        for (int j = 0; j < fieldSizeX; j++) {
            for (int i = 0; i < fieldSizeY; i++) {
                if(field[i][j] == DOT_HUMAN) countXinVertical++;
            }
        }
        return countXinVertical;
    }

    private static int checkHorizontal(){
        int countXinHorizontal = 0;
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if(field[i][j] == DOT_HUMAN) countXinHorizontal++;
            }
        }
        return countXinHorizontal;
    }

    //aiTurn intelligent with known humanX and humanY   
//    private static void aiTurn(int j, int i) {
//        int humanX = j;
//        int humanY = i;
//
//        int aiX = 0;
//        int aiY = 0;
//
//        if(humanX == 0 & humanY == 0){
//            for (j = 0; j < fieldSizeX; j++) {
//
//            }
//        }
//        do {
//
//        } while (!isEmptyCell(aiX, aiY) && isValidCell(aiX, aiY));
//        field[aiY][aiX] = DOT_AI;
//    }



    private static boolean checkDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isEmptyCell(x, y)) return false;
            }
        }
        return true;
    }

    private static boolean checkWin(char c) {
        // hor
        int count = 0;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == c) count++;
            }
            if (count == winCombination) return true;
            count = 0;
        }
//        if (field[0][0] == c && field[0][1] == c && field[0][2] == c) return true;
//        if (field[1][0] == c && field[1][1] == c && field[1][2] == c) return true;
//        if (field[2][0] == c && field[2][1] == c && field[2][2] == c) return true;

        // ver
        for (int j = 0; j < field.length; j++) {
            for (int i = 0; i < field.length; i++) {
                if (field[i][j] == c) count++;
            }
            if (count == winCombination) return true;
            count = 0;
        }
//        if (field[0][0] == c && field[1][0] == c && field[2][0] == c) return true;
//        if (field[0][1] == c && field[1][1] == c && field[2][1] == c) return true;
//        if (field[0][2] == c && field[1][2] == c && field[2][2] == c) return true;

        // dia

        for (int i = 0; i < field.length; i++) {
            if (field[i][i] == c) count++;
            if (count == winCombination) return true;
            count = 0;
        }
//        if (field[0][0] == c && field[1][1] == c && field[2][2] == c) return true;
//        if (field[0][2] == c && field[1][1] == c && field[2][0] == c) return true;
        return false;

    }

    public static void main(String[] args) {

        initField();
        printField();
        String answer;
        do {
            while (true) {
                humanTurn();
                if (checkEndGame(DOT_HUMAN, "Human win!")) break;
                aiTurn();
                if (checkEndGame(DOT_AI, "Computer win!")) break;
            }
            System.out.println("Wanna play again? (y/n) >>> ");
            answer = SCANNER.next();
        } while (answer.equals("y"));
        SCANNER.close();
    }

    private static boolean checkEndGame(char dot, String winMessage) {
        printField();
        if (checkWin(dot)) {
            System.out.println(winMessage);
            return true;
        }
        if (checkDraw()) {
            System.out.println("Draw!");
            return true;
        }
        return false;
    }
}
