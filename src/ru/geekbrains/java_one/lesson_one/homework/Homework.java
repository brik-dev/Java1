package ru.geekbrains.java_one.lesson_one.homework;

/**
 * 1. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат с плавающей точкой, где a, b, c, d – целочисленные входные параметры этого метода;
 * 2. Написать метод, принимающий на вход два целых числа, и проверяющий что их сумма лежит в пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
 * 3. Написать метод, которому в качестве параметра передается целое число, метод должен проверить положительное ли число передали, или отрицательное. Замечание: ноль считаем положительным числом. Результат работы метода вывести в консоль
 * 4. Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вернуть приветственное сообщение «Привет, переданное_имя!»; Вывести приветствие в консоль.
 * 5. *Написать метод, который определяет является ли год високосным. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный. Для проверки работы вывести результаты работы метода в консоль
 */

public class Homework {
    public static void main(String[] args) {
        int a = 5;
        int b = 6;
        int c = 4;
        int d = 2;
        String name = "Natalia";
        int year = 2016;

        System.out.println(calculateGetFloat(a, b, c, d));

        System.out.println(checkSum(a, b));

        isPositive(a);

        greet(name);

        checkLeapYear(year);


    }

    // task 5

    public static void checkLeapYear(int y){
        int rest = y%4;
        int is100 = y%100;
        int is400 = y%400;

        if(is400 == 0) {
            System.out.println(y + " - високосный год");
        }else{
            if(rest == 0 && is100 != 0){
                System.out.println(y + " - високосный год");
            } else {
                System.out.println(y + " - невисокосный год");
            }
        }
    }

    private static boolean isLeapYear(int year){
        return (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0);
    }

    // task 4

    private static String greet(String name) {
        //System.out.println("Hello, " + name);
        return "Hello, " + name + "!";
    }

    // task 3
    private static boolean isPositive(int a) {

        return a >= 0;

//        if(a >= 0){
//            System.out.println("Number you have entered is 0 or larger that 0");
//        } else {
//            System.out.println("Number you have entered is less than 0");
//        }
    }

    // task 2
    private static boolean checkSum(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    // task 1
    private static float calculateGetFloat(int a, int b, int c, int d) {
        // float dd = d;
        // return a * (b + (c / dd));
        return a * (b + (c * 1.0f / d));

    }
}
