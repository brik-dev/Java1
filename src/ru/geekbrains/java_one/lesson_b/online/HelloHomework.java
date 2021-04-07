package ru.geekbrains.java_one.lesson_b.online;
/*
Homework check with the prof
 */

import java.util.Arrays;

public class HelloHomework {

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

    private static boolean checkBalance2(int[] array){ // optimised with check ?sum - L == R -> TODO: to be tested
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        int left = 0;
        int right = sum;
        for (int i = 0; i < array.length; i++) {
            right -= array[i];
            left += array[i];
            if(left == right) return true;
        }
        return false;
    }

    private static void shifter(int[] array, int value) {
        boolean direction;
        if (value < 0) {
            direction = true;
            value = -value;
        } else {
            direction = false;
        }
        value %= array.length;
        int lastIndex = array.length - 1;
        for (int i = 0; i < value; i++) {
            int temp = (direction) ? array[0] : array[lastIndex];
            for (int j = 0; j < lastIndex; j++) {
                if (direction)
                    array[j] = array[j + 1];
                else
                    array[lastIndex - j] = array[lastIndex - j - 1];
            }
            if (direction)
                array[lastIndex] = temp;
            else
                array[0] = temp;
        }
    }

    private static void shifter2(int[] array, int value) {
        boolean direction = value < 0;
        if (direction) value = -value;

        value %= array.length;
        int lastIndex = array.length - 1;
        for (int i = 0; i < value; i++) {
            int temp = (direction) ? array[0] : array[lastIndex];
            if (direction) {
                System.arraycopy(array, 1, array, 0, lastIndex);
                array[lastIndex] = temp;
            } else {
                System.arraycopy(array, 0, array, 1, lastIndex);
                array[0] = temp;
            }
        }
    }

    public static void main(String[] args) {
        /*
         * 1 Задать целочисленный массив, состоящий из элементов 0 и 1.
         * Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
         * Написать метод, заменяющий в принятом массиве 0 на 1, 1 на 0;
         */
        int[] bin = {1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0};
        System.out.println("1. Before:\t" + Arrays.toString(bin));
        change(bin);
        System.out.println("1. After:\t" + Arrays.toString(bin));

        /*
         * 2 Задать пустой целочисленный массив размером 8.
         * Написать метод, который помощью цикла
         * заполнит его значениями 1 4 7 10 13 16 19 22;
         */
        int[] arrInt = new int[8];
        fillIn(arrInt, 3, 1);
        System.out.println("2. Filled with cycle:\t" + Arrays.toString(arrInt));

        /*
         * 3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ],
         * написать метод, принимающий на вход массив и умножающий числа меньше 6 на 2;
         */
        int[] mas = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        System.out.println("3. Before:\t" + Arrays.toString(mas));
        doubling(mas);
        System.out.println("3. After:\t" + Arrays.toString(mas));

        /*
         * 5 * Создать квадратный целочисленный массив (количество строк и столбцов одинаковое),
         * заполнить его диагональные элементы единицами, используя цикл(ы);
         */
        final int side = 10;
        int[][] dArr = new int[side][side];
        crossFill(dArr);
        for (int i = 0; i < dArr.length; i++) {
            for (int j = 0; j < dArr[i].length; j++) {
                System.out.print(dArr[i][j] + " ");
            }
            System.out.println();
        }

        /*
         * 4 Задать одномерный массив. Написать методы поиска в нём минимального и максимального элемента;
         */
        System.out.println("5. Maximum: " + findMax(mas));
        System.out.println("5. Minimum: " + findMin(mas));

        /*
         * 6 ** Написать метод, в который передается не пустой одномерный целочисленный массив,
         * метод должен вернуть true если в массиве есть место, в котором сумма левой и правой части массива равны.
         * Примеры: checkBalance([1, 1, 1, 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false, checkBalance ([10, 1, 2, 3, 4]) → true.
         */
        int[] balance = {10, 2, 3, 4};
        System.out.print("6. Is the " + Arrays.toString(balance) + " balanced? ");
        System.out.println(checkBalance(balance) + "\t" + checkBalance2(balance));

        /*
         * 7. **** Написать метод, которому на вход подается одномерный массив и
         * число n (может быть положительным, или отрицательным),
         * при этом метод должен сместить все элементымассива на n позиций.
         * Для усложнения задачи нельзя пользоваться вспомогательными массивами.
         */
        int[] shiftArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("7.  " + Arrays.toString(shiftArray));
        shifter(shiftArray, -3);
        System.out.println("-3 " + Arrays.toString(shiftArray));
        shifter2(shiftArray, 6);
        System.out.println("+6 " + Arrays.toString(shiftArray));
        
    }

    private static void shifter3(int[] array, int value) {
        value %= array.length;
        if (value == 0) return;
        boolean dir = value < 0;
        if (dir) value = -value;
        int shift = (dir) ? array.length - value : value;

        for (int i = 0; i < shift; i++) {
            int temp = array[array.length - 1];
            System.arraycopy(array, 0, array, 1, array.length - 1);
            array[0] = temp;
        }
    }
}

