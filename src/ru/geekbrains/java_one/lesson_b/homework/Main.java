package ru.geekbrains.java_one.lesson_b.homework;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //task 1:
        int[] arr = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        System.out.println(Arrays.toString(revertArray(arr)));

        //task 2:
        int[] arr1 = new int[8];
        System.out.println(Arrays.toString(fillArray(arr1)));

        //task 3:
        int[] arr2 = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        System.out.println(Arrays.toString(multiplyArray(arr2)));

        //task 4:
        int[] arr3 = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9 };
        System.out.println(findMax(arr3));
        System.out.println(findMin(arr3));

        //task 5:
        int tableSize = 3;
        int[][] table = new int[tableSize][tableSize];

        fillDiagonal(tableSize, table);

        // task 6:
        int[] arr4 = { 1, 1, 1, 2, 1 };
        System.out.println(isLeftAndRightSumEqual(arr4, 2));

        //task 7:
        int[] arr5 = { 1, 2, 3, 4, 5 };
        int moves = -3;

        System.out.println(Arrays.toString(moveToRightOrLeft(arr5, moves)));

    }

    /**
     * 7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
     * при этом метод должен сместить все элементымассива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
     *
     * @param arr5
     * @param moves
     * @return
     */
    private static int[] moveToRightOrLeft(int[] arr5, int moves) {

        // check if moves >= arr5.lengths needed
        int[] newArray = new int[arr5.length];
        if( moves >= 0 ) {
            int n = moves;
            for (int i = 0, j = i + n; i < arr5.length; i++, j++) {
                if (j < newArray.length) {
                    newArray[j] = arr5[i];
                } else {
                    for (int k = 0, l = arr5.length - n; k < newArray.length - i; k++, l++) {
                        newArray[k] = arr5[l];
                    }
                }
            }
        } else {
            int n = Math.abs(moves);
            for (int i = 0, j = i + n; i < arr5.length; i++, j++) {
                if(j < newArray.length){
                    newArray[i] = arr5[j];
                }else {
                    for (int k = 0, l = arr5.length - n; k < newArray.length - i; k++, l++) {
                        newArray[l] = arr5[k];
                    }
                }
            }
        }
        return newArray;
    }

    /**
     * 6 ** Написать метод, в который передается не пустой одномерный целочисленный массив,
     * метод должен вернуть true если в массиве есть место, в котором сумма левой и правой части массива равны.
     * Примеры: checkBalance([1, 1, 1, 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false, checkBalance ([10, 1, 2, 3, 4]) → true.
     * @param arr4
     */

    private static boolean isLeftAndRightSumEqual(int[] arr4, int startPoint) {
        int sumLeft = 0;
        int sumRight = 0;

        if (startPoint == 0) {
            sumLeft += arr4[startPoint];
            for (int j = startPoint + 1; j < arr4.length; j++) {
                sumRight += arr4[j];
            }
        } else {
            for (int k = startPoint; k >= 0; k--) {
                sumLeft += arr4[k];
            }
            for (int l = startPoint + 1; l < arr4.length; l++) {
                sumRight += arr4[l];
            }
        }

        if (sumLeft == sumRight){
            return true;
        }else{
            return false;
        }
    }


    /**
     * 5 * Создать квадратный целочисленный массив (количество строк и столбцов одинаковое), заполнить его диагональные элементы единицами, используя цикл(ы);
     * 
     * @param tableSize
     * @param table
     */
    private static void fillDiagonal(int tableSize, int[][] table) {
        for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table.length; j++) {

                    if((i + 1) != tableSize && (j + 1) != tableSize){
                        table[i][j] = 1;
                        table[i+1][j+1] = 1;
                    }
                    System.out.print(table[i][j] + "\t");
                }
                System.out.println();
            }
    }

    /**
     * A try to solve task 5 with recursion
     */
//    private static void fillDiagonal(int[][] table, int x, int y) {
//        while (!isOutOfTable(table, x, y)){
//            table[x + 1][y + 1] = 1;
//        }
//    }
//
//    public static boolean isOutOfTable(int[][] table, int x, int y){
//        for (int i = 0; i < table.length; i++) {
//            for (int j = 0; j < table.length; j++) {
//                if(x > j || y > i){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    /**
     * 4 Задать одномерный массив. Написать методы поиска в нём минимального и максимального элемента;
     * @param arr
     * @return
     */

    private static int findMin(int[] arr) {
        int min = arr[0];


        for (int i = 0; i < arr.length; i++) {
            if( arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }

    private static int findMax(int[] arr) {
        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if( arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * 3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], написать метод, принимающий на вход массив и умножающий числа меньше 6 на 2;
     * @param arr
     * @return
     */
    private static int[] multiplyArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < 6){
                arr[i] = arr[i] * 2;
            }
        }
        return arr;
    }

    /**
     * 2 Задать пустой целочисленный массив размером 8. Написать метод, который помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22;
     * @param arr1
     * @return
     */
    private static int[] fillArray(int[] arr1) {
        for (int i = 0; i < arr1.length; i++){
            arr1[i] = (i == 0) ? 1 : arr1[i-1] + 3;
        }
        return arr1;
    }

    /**
     * 1 Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. Написать метод, заменяющий в принятом массиве 0 на 1, 1 на 0;
     * @param arr
     * @return
     */
    private static int[] revertArray(int[] arr) {
        for (int i = 0; i < arr.length; i++){
            arr[i] = (arr[i] == 1) ? 0 : 1;
            arr[i] = 1 - arr[i];
            arr[i] ^= 1;
        }
        return arr;
    }
}
