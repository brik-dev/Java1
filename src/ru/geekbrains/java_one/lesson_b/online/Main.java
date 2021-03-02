package ru.geekbrains.java_one.lesson_b.online;

import java.util.Arrays;

public class Main {
    private static int power(int base, int sign) {
        int result = 1;
        for (int i = 0; i < sign; i++) {
            result = result * base;
        }
        return result;
    }

    public static void main(String[] args) {
        // switchCase();
        // cycles
//        whileExample();
//        doWhileExample();
//        forCyclesExample();
        // arrays
//        arraysExample();
        int[][] arr = new int[2][4];
        int[][] ar0 = new int[3][];
        ar0[0] = new int[2];
        ar0[0][0] = 1;
        ar0[0][1] = 2;
        ar0[1] = new int[3];
        ar0[1][0] = 3;
        ar0[1][1] = 4;
        ar0[1][2] = 5;
//...
        int[][][] ar3 = new int[3][3][3];
        System.out.println(Arrays.deepToString(ar0));
    }

    private static void arraysExample() {
        int[] arr;
        arr = new int[10];
        arr[0] = 10;
        arr[1] = 5;

        int[] ar0 = arr;
        ar0[0] = 4;

        System.out.println(arr[0]);

        String[] ar1 = { "Hello", "Java", "World" };
        printArray(ar1);
        String[] ar2 = {"Hello", "World"};
        printArray(ar2);

        System.out.println(Arrays.toString(ar2));
    }

    private static void forCyclesExample() {
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int y = 1; y < 10; y++) {
            for (int x = 1; x < 10; x++) {
                System.out.printf("%3d", x * y);
            }
            System.out.println();
        }
    }

    private static void printArray(String[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.println();
    }

    private static void doWhileExample() {
        int a = 0;
        do {
            System.out.print(a++ + " ");
        } while (a < 10);
        System.out.println("We do things here");
    }

    private static void whileExample() {
        int a = 0;
        while (a < 10) {
            System.out.print(++a + " ");
        }
    }

    private static void switchCase() {
        String name = "pavel";
        switch (name) {
            case "ivan":
                System.out.println("document sent to desk #1");
                break;
            case "petr":
                System.out.println("document sent to desk #10");
                break;
            default:
                System.out.println("Can't find recipient");
                break;
            case "vasiliy":
                System.out.println("document sent to desk #4");
                break;
        }
    }

    private static void selection() {
        int a = 10;
        int b = 5;
        int c;
        if (a > b) {
            c = a;
        } else {
            c = b;
        }
        System.out.println(c);

        c = (a > b) ? a : b;
    }
}
