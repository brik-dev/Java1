package ru.geekbrains.java_one.lesson_d.online;

public class Main {
    public static void main(String[] args) {
        Cat c0 = new Cat("Barsik", "White", 5);
        Cat c1 = new Cat("Murzik", "Black", 2);
        Cat c3 = new Cat("Peachy", 4);

        Cat c4 = new Cat(c0);
        c3.setName("Kissik");

        System.out.printf("Cat: %s is %s of age %d\n",
                c0.getName(), c0.getColor(), c0.getAge());
        System.out.printf("Cat: %s is %s of age %d\n",
                c1.getName(), c1.getColor(), c1.getAge());

        c0.jump();
        c0.voice();
        c1.jump();
        c1.voice();

        System.out.println("Cat usually has " + Cat.getPawsAmount() + " paws");
    }
}
