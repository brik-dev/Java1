package ru.geekbrains.java_one.lesson_d.homework;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[5];
        Cat c0 = new Cat();
        c0.name = "Barsik";
        c0.color = "White";
        c0.age = 5;

        System.out.printf("Cat: %s is %s of age %d", c0.name, c0.color, c0.age);

    }
}
