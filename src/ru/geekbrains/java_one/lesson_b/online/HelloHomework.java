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

    private static boolean checkBalance2(int[] array){ // optimised with check ?sum - L == R -> TODO: to be tested
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        int left = 0;
        int right = sum - array[0];
        for (int i = 0; i < array.length; i++) {
            left += array[i];
            if((sum - left) == right) return true;
            right -= array[i];
        }

        return false;
    }

    public static void main(String[] args) {
        /*
         * 1.   Ð¡Ð¾Ð·Ð´Ð°Ñ‚ÑŒ Ð¼Ð°ÑÑÐ¸Ð², ÑÐ¾ÑÑ‚Ð¾ÑÑ‰Ð¸Ð¹ Ð¸Ð· ÑÐ»ÐµÐ¼ÐµÐ½Ñ‚Ð¾Ð² 0 Ð¸ 1,
         * Ð½Ð°Ð¿Ñ€Ð¸Ð¼ÐµÑ€, [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. Ð¡ Ð¿Ð¾Ð¼Ð¾Ñ‰ÑŒÑŽ Ñ†Ð¸ÐºÐ»Ð°
         * Ð¸ ÑƒÑÐ»Ð¾Ð²Ð¸Ñ Ð·Ð°Ð¼ÐµÐ½Ð¸Ñ‚ÑŒ 0 Ð½Ð° 1, 1 Ð½Ð° 0;
         */
        int[] bin = {1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0};
        System.out.println("1. Before:\t" + Arrays.toString(bin));
        change(bin);
        System.out.println("1. After:\t" + Arrays.toString(bin));

        /*
         * 2.   Ð¡Ð¾Ð·Ð´Ð°Ñ‚ÑŒ Ð¿ÑƒÑÑ‚Ð¾Ð¹ Ñ†ÐµÐ»Ð¾Ñ‡Ð¸ÑÐ»ÐµÐ½Ð½Ñ‹Ð¹ Ð¼Ð°ÑÑÐ¸Ð² Ñ€Ð°Ð·Ð¼ÐµÑ€Ð¾Ð¼ 8.
         * Ð¡ Ð¿Ð¾Ð¼Ð¾Ñ‰ÑŒÑŽ Ñ†Ð¸ÐºÐ»Ð° Ð·Ð°Ð¿Ð¾Ð»Ð½Ð¸Ñ‚ÑŒ ÐµÐ³Ð¾ Ð·Ð½Ð°Ñ‡ÐµÐ½Ð¸ÑÐ¼Ð¸
         * 0 3 6 9 12 15 18 21;
         */
        int[] arrInt = new int[8];
        fillIn(arrInt, 3, 1);
        System.out.println("2. Filled with cycle:\t" + Arrays.toString(arrInt));

        /*
         * 3.   Ð—Ð°Ð´Ð°Ñ‚ÑŒ Ð¼Ð°ÑÑÐ¸Ð² int[] mas = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
         * Ð¿Ñ€Ð¾Ð¹Ñ‚Ð¸ Ð¿Ð¾ Ð½ÐµÐ¼Ñƒ Ñ†Ð¸ÐºÐ»Ð¾Ð¼, Ð¸ Ñ‡Ð¸ÑÐ»Ð°, ÐºÐ¾Ñ‚Ð¾Ñ€Ñ‹Ðµ Ð¼ÐµÐ½ÑŒÑˆÐµ 6, ÑƒÐ¼Ð½Ð¾Ð¶Ð¸Ñ‚ÑŒ Ð½Ð° 2.
         */
        int[] mas = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        System.out.println("3. Before:\t" + Arrays.toString(mas));
        doubling(mas);
        System.out.println("3. After:\t" + Arrays.toString(mas));

        /*
         * 4.   Ð¡Ð¾Ð·Ð´Ð°Ñ‚ÑŒ ÐºÐ²Ð°Ð´Ñ€Ð°Ñ‚Ð½Ñ‹Ð¹ Ð´Ð²ÑƒÐ¼ÐµÑ€Ð½Ñ‹Ð¹ Ñ†ÐµÐ»Ð¾Ñ‡Ð¸ÑÐ»ÐµÐ½Ð½Ñ‹Ð¹
         * Ð¼Ð°ÑÑÐ¸Ð² (ÐºÐ¾Ð»Ð¸Ñ‡ÐµÑÑ‚Ð²Ð¾ ÑÑ‚Ñ€Ð¾Ðº Ð¸ ÑÑ‚Ð¾Ð»Ð±Ñ†Ð¾Ð² Ð¾Ð´Ð¸Ð½Ð°ÐºÐ¾Ð²Ð¾Ðµ),
         * Ð¸ Ñ Ð¿Ð¾Ð¼Ð¾Ñ‰ÑŒÑŽ Ñ†Ð¸ÐºÐ»Ð°(-Ð¾Ð²) Ð·Ð°Ð¿Ð¾Ð»Ð½Ð¸Ñ‚ÑŒ ÐµÐ³Ð¾ Ð´Ð¸Ð°Ð³Ð¾Ð½Ð°Ð»ÑŒÐ½Ñ‹Ðµ ÑÐ»ÐµÐ¼ÐµÐ½Ñ‚Ñ‹ ÐµÐ´Ð¸Ð½Ð¸Ñ†Ð°Ð¼Ð¸;
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
         * 5.	* Ð—Ð°Ð´Ð°Ñ‚ÑŒ Ð¾Ð´Ð½Ð¾Ð¼ÐµÑ€Ð½Ñ‹Ð¹ Ð¼Ð°ÑÑÐ¸Ð² Ð¸ Ð½Ð°Ð¹Ñ‚Ð¸ Ð² Ð½ÐµÐ¼
         * Ð¼Ð¸Ð½Ð¸Ð¼Ð°Ð»ÑŒÐ½Ñ‹Ð¹ Ð¸ Ð¼Ð°ÐºÑÐ¸Ð¼Ð°Ð»ÑŒÐ½Ñ‹Ð¹ ÑÐ»ÐµÐ¼ÐµÐ½Ñ‚Ñ‹;
         */
        System.out.println("5. Maximum: " + findMax(mas));
        System.out.println("5. Minimum: " + findMin(mas));

        /*
         * 6.   ** ÐÐ°Ð¿Ð¸ÑÐ°Ñ‚ÑŒ Ð¼ÐµÑ‚Ð¾Ð´, Ð² ÐºÐ¾Ñ‚Ð¾Ñ€Ñ‹Ð¹ Ð¿ÐµÑ€ÐµÐ´Ð°ÐµÑ‚ÑÑ Ð½Ðµ Ð¿ÑƒÑÑ‚Ð¾Ð¹
         * Ð¾Ð´Ð½Ð¾Ð¼ÐµÑ€Ð½Ñ‹Ð¹ Ñ†ÐµÐ»Ð¾Ñ‡Ð¸ÑÐ»ÐµÐ½Ð½Ñ‹Ð¹ Ð¼Ð°ÑÑÐ¸Ð², Ð¼ÐµÑ‚Ð¾Ð´ Ð´Ð¾Ð»Ð¶ÐµÐ½ Ð²ÐµÑ€Ð½ÑƒÑ‚ÑŒ
         * true ÐµÑÐ»Ð¸ Ð² Ð¼Ð°ÑÑÐ¸Ð²Ðµ ÐµÑÑ‚ÑŒ Ð¼ÐµÑÑ‚Ð¾, Ð² ÐºÐ¾Ñ‚Ð¾Ñ€Ð¾Ð¼ ÑÑƒÐ¼Ð¼Ð°
         * Ð»ÐµÐ²Ð¾Ð¹ Ð¸ Ð¿Ñ€Ð°Ð²Ð¾Ð¹ Ñ‡Ð°ÑÑ‚Ð¸ Ð¼Ð°ÑÑÐ¸Ð²Ð° Ñ€Ð°Ð²Ð½Ñ‹.
         * ÐŸÑ€Ð¸Ð¼ÐµÑ€Ñ‹: checkBalance([1, 1, 1, || 2, 1]) â†’ true,
         * checkBalance ([2, 1, 1, 2, 1]) â†’ false,
         * checkBalance ([10, || 10]) â†’ true,
         * Ð³Ñ€Ð°Ð½Ð¸Ñ†Ð° Ð¿Ð¾ÐºÐ°Ð·Ð°Ð½Ð° ÑÐ¸Ð¼Ð²Ð¾Ð»Ð°Ð¼Ð¸ ||, ÑÑ‚Ð¸ ÑÐ¸Ð¼Ð²Ð¾Ð»Ñ‹ Ð² Ð¼Ð°ÑÑÐ¸Ð² Ð½Ðµ Ð²Ñ…Ð¾Ð´ÑÑ‚.
         */
        int[] balance = {0};
        System.out.print("6. Is the " + Arrays.toString(balance) + " balanced? ");
        System.out.println(checkBalance(balance));

        /*
         * 7.    *** ÐÐ°Ð¿Ð¸ÑÐ°Ñ‚ÑŒ Ð¼ÐµÑ‚Ð¾Ð´, ÐºÐ¾Ñ‚Ð¾Ñ€Ð¼Ñƒ Ð½Ð° Ð²Ñ…Ð¾Ð´ Ð¿Ð¾Ð´Ð°Ñ‘Ñ‚ÑÑ Ð¾Ð´Ð½Ð¾Ð¼ÐµÑ€Ð½Ñ‹Ð¹
         * Ð¼Ð°ÑÑÐ¸Ð² Ð¸ Ñ‡Ð¸ÑÐ»Ð¾ n (Ð¼Ð¾Ð¶ÐµÑ‚ Ð±Ñ‹Ñ‚ÑŒ Ð¿Ð¾Ð»Ð¾Ð¶Ð¸Ñ‚ÐµÐ»ÑŒÐ½Ñ‹Ð¼, Ð¸Ð»Ð¸ Ð¾Ñ‚Ñ€Ð¸Ñ†Ð°Ñ‚ÐµÐ»ÑŒÐ½Ñ‹Ð¼),
         * Ð¿Ñ€Ð¸ ÑÑ‚Ð¾Ð¼ Ð¼ÐµÑ‚Ð¾Ð´ Ð´Ð¾Ð»Ð¶ÐµÐ½ ÑÐ¼ÐµÑÑ‚Ð¸Ñ‚ÑŒ Ð²ÑÐµ ÑÐ»ÐµÐ¼ÐµÐ½Ñ‚Ñ‹ Ð¼Ð°ÑÑÐ¸Ð²Ð° Ð½Ð° n Ð¿Ð¾Ð·Ð¸Ñ†Ð¸Ð¹.
         *
         * **** Ð”Ð»Ñ ÑƒÑÐ»Ð¾Ð¶Ð½ÐµÐ½Ð¸Ñ Ð·Ð°Ð´Ð°Ñ‡Ð¸ Ð½ÐµÐ»ÑŒÐ·Ñ Ð¿Ð¾Ð»ÑŒÐ·Ð¾Ð²Ð°Ñ‚ÑŒÑÑ Ð²ÑÐ¿Ð¾Ð¼Ð¾Ð³Ð°Ñ‚ÐµÐ»ÑŒÐ½Ñ‹Ð¼Ð¸ Ð¼Ð°ÑÑÐ¸Ð²Ð°Ð¼Ð¸
         */
        int[] shiftArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("7.  " + Arrays.toString(shiftArray));
        shifter(shiftArray, -3);
        System.out.println("-3 " + Arrays.toString(shiftArray));
        shifter2(shiftArray, 6);
        System.out.println("+6 " + Arrays.toString(shiftArray));
        
    }

}

