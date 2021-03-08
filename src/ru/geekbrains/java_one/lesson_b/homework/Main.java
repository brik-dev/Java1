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




    }

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
            if(arr[i] > 6){
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
        }
        return arr;
    }
}
