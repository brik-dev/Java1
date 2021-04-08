package ru.geekbrains.java_one.lesson_a;

public class HelloWorld {
    //DRY = don't repeat yourself;

    private static void checkCoordinates(int x, int y) {//int x=6; int y=2;
        int fieldSizeX = 3;
        int fieldSizeY = 3;

        boolean outOfX = x >= fieldSizeX;
        boolean lessThanZero = x < 0;

        if (outOfX || lessThanZero) {
            System.out.println("Out of field X");
        } else {
            System.out.println("Put your mark to X");
        }

        if (y >= fieldSizeY || y < 0) {
            System.out.println("Out of field Y");
        } else {
            System.out.println("Put your mark to Y");
        }
    }

    private static long sumOfThreeNumbers(int x, int y, int z) {
        return x + y + z;
    }

    private static void helloUser(String name) {
        System.out.println("connichiwa " + name);
    }

    public static void main(String[] args) {
//        System.out.print("HelloWorld!");
//        System.out.println("Second String");
//
//        int i0;
//        byte b0 = -100;
//        byte b1 = 127;
//        short s0 = -32768;
//        short s1 = 32767;
//        int i = 2147000000;
//        long l = 5000000000L;
//        i0 = 100;
//        long l0 = 1234;
//        boolean boo0 = true;
//        boolean boo1 = false;
//        float f0 = 2.1238762153487126548712653487f; // 4bytes
//        double d0 = 4.5432128764592845681726; //8bytes
//        int i1 = 0xAF;
//        char c0 = 'A';
//        char c1 = 66;
//        System.out.println(c1);
//        String s = "Hello";

        // arithmetic
        // /
//        float f = 10 / 0;
//        System.out.println(f);
        // %
//        float i = 10f % 3;
//        System.out.println(i);
//        // ++
//        int i0 = 10;
//        i0--;
//        System.out.println(i0);
//        int i = 10;
//        i = i + 5;
//        i += 5;
//
//        i = -i;
        // return an error to user
        // if coord >= field size or coord < 0.
        int userInputX = 6;
        int userInputY = 2;

        checkCoordinates(userInputX, userInputY);
        checkCoordinates(2, 4);
        checkCoordinates(1, 1);
        checkCoordinates(87, 865);

        long i = 1 + 2 + 3;//sumOfThreeNumbers(1, 2, 3);
        long f = sumOfThreeNumbers(5, 6, 7);


//        if (1 == 0) { //equality
//            //...
//        } else if (1 != 10) { // not equal
//            //....
//        } else {
//            //...
//        }
    }
    // and && ret true if both op = true;
    // or  || ret true if at least one of op = true;
    // xor ^  ret true if op diff
    // not !  ret true if op = false;
}
