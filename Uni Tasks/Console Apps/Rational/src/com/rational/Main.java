package com.rational;

public class Main {

    public static void main(String[] args) {
        Rational rational1 = new Rational(4, 6);
        Rational rational2 = new Rational(10, -16);

        rational1.subtract(rational2);
        System.out.printf("Result: %s", rational1.toString());
    }
}
