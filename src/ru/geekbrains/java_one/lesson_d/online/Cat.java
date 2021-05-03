package ru.geekbrains.java_one.lesson_d.online;

public class Cat {
    private static final int CURRENT_YEAR = 2020;

    private static final int pawsAmount = 4;

    public static int getPawsAmount() {
        return pawsAmount;
    }

    private String name;
    private int birthDate;
    private String color;

    Cat(String name, String color, int age) {
        this(color, age);
        this.name = name;
    }

    Cat(String color, int age) {
        this.color = color;
        this.setBirthDate(age);
    }

    Cat() {
        this.setBirthDate(0);
    }

    Cat(Cat c) {
        name = c.name;
        birthDate = c.birthDate;
        color = c.color;
    }

    void voice() {
        System.out.println(this.name + " meows");
    }

    void jump() {
        if (this.getAge() < 6)
            System.out.println(this.name + " jumps");
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return CURRENT_YEAR - this.birthDate;
    }

    public String getColor() {
        return this.color;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void setBirthDate(int age) {
        this.birthDate = CURRENT_YEAR - age;
    }

    Cat myClone() {
        return new Cat(this);
    }
}
