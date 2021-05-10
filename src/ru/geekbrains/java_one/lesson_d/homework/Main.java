package ru.geekbrains.java_one.lesson_d.homework;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[5];
        Cat c0 = new Cat();
        c0.name = "Barsik";
        c0.color = "White";
        c0.age = 5;

        Cat c1 = new Cat();
        c1.name = "Murzik";
        c1.color = "Black";
        c1.age = 2;

        Cat c2 = c0;
        c2.age = 2;

        System.out.printf("Cat: %s is %s of age %d\n", c0.name, c0.color, c0.age);
        System.out.printf("Cat: %s is %s of age %d\n", c1.name, c1.color, c1.age);

    }
}
