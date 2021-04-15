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
//    private static void aiTurn() {
//        int x = 0;
//        int y = 0;
//
//        do {
//            for (int i = 0; i < fieldSizeY; i++) {
//                for (int j = 0; j < fieldSizeX; j++) {
//                    if (field[i][j] == 'X'){
//
//                        if(checkDiagonal(i, j)){
//                            x = j + 1;
//                            y = i + 1;
//                        } else if (checkVertical(i, j)){
//                            x = j;
//                            y = i + 1;
//                        } else if (checkHorizontal(i, j)){
//                            x = j + 1;
//                            y = i;
//                        }else{
//                            x = j + 1;
//                            y = i + 1;
//                        }
//                    }
//                }
//            }
//        } while (!isEmptyCell(x, y));
//        field[y][x] = DOT_AI;
//    }

    private static boolean checkDiagonal(int x, int y){
        if(x < 0 || y < 0){
            return field[y - 1][x - 1] == DOT_HUMAN;
        } else {
            return false;
        }
    }

    private static boolean checkVertical(int x, int y){
        if(x < 0 || y < 0){
            return field[y - 1][x] == DOT_HUMAN;
        } else {
            return false;
        }
    }

    private static boolean checkHorizontal(int x, int y){
        if(x < 0 || y < 0){
            return field[y][x - 1] == DOT_HUMAN;
        } else {
            return false;
        }
    }

    //aiTurn intelligent with known humanX and humanY   
    private static void aiTurn(int j, int i) {
        int humanX = j;
        int humanY = i;
        
        int aiX = 0;
        int aiY = 0;

        if(humanX == 0 & humanY == 0){
            for (j = 0; j < fieldSizeX; j++) {
                
            }
        }
        do {
            
        } while (!isEmptyCell(aiX, aiY) && isValidCell(aiX, aiY));
        field[aiY][aiX] = DOT_AI;
    }



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
                //aiTurn();
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
