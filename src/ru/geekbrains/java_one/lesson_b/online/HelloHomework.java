package ru.geekbrains.java_one.lesson_b.online;
/*
Homework check with the prof
 */

public class HelloHomework {

    public static void main(String[] args) {

    }

    private static void change(int[] array) { // не нужно возвращать массив, так как мы передаем ссылку на массив в метод. Метод менят сам массив.
        for (int i = 0; i < array.length; i++){
            array[i] = (array[i] == 1) ? 0 : 1;
            //arr[i] = 1 - arr[i];
            //arr[i] ^= 1;
        }
    }

    // i = 0, 1, 2, 3, 4, 5 ..
    // *3 = 0, 3, 6, 9, ..
    // +1 = 1, 4, 7, 10

    private static void fillIn(int[] array) {
        for (int i = 0; i < array.length; i++){
            //array[i] = (i == 0) ? 1 : array[i-1] + 3;
            array[i] = i * 3 + 1;
        }
    }

    // улучшить с арифметической прогрессией
    private static void fillIn(int[] array, int step, int shift) {
        for (int i = 0; i < array.length; i++){
            //array[i] = (i == 0) ? 1 : array[i-1] + 3;
            array[i] = i * step + shift;
        }
    }

    private static void doubling(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if(array[i] < 6)
               array[i] *= 2;
        }
    }

    private static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if( arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    private static int findMin(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if( arr[i] < min)
                min = arr[i];
        }

//        for (int value : arr) {
//            if( value < min)
//                min = value;
//        }
        return min;
    }

    private static void crossFill(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 1;
            arr[i][arr.length - 1 - i] = 1;
        }
    }

    private static boolean checkBalance(int[] array){
        int right = 0, left = 0;
        for (int i = 0; i < array.length; i++) {
            left += array[i];
            for (int j = i + 1; j < array.length; j++)
                right += array[j];
            if(left == right) return true;
            right = 0;
        }
        return false;
    }

}

