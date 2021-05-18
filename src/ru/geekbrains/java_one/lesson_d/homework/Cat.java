package ru.geekbrains.java_one.lesson_d.homework;

public class Cat {
    String name;
    int age;
    String color;

    Cat(String n, String c, int a){
        name = n;
        color = c;
        age = a;
    }

    Cat(){
        age = 0;
    }

    void voice(){
        System.out.println(name + "meows");
    }

    void jump(){
        if(age < 6)
            System.out.println(name + "jumps");
    }
    //next steps
}

