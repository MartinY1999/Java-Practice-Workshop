package com.company;

import java.util.Scanner;

public class Main {

    public static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        double number = reader.nextDouble();
        double sum = 1 + algorithmSolver(number);
        System.out.printf("Result: %f", sum);
    }

    public static double algorithmSolver(double number){
        double denominator = 1;
        double powLevel = 1;
        double sumToAdd = 0;
        while (true){
            sumToAdd += newValue(number, denominator, powLevel);
            if (valueInvalid(newValue(number, denominator, powLevel), newValue(number, denominator + 1, powLevel + 1)))
                break;

            denominator++;
            powLevel++;
        }

        return sumToAdd;
    }

    public static boolean valueInvalid(double number1, double number2){
        if (Math.abs(Math.abs(number1) - Math.abs(number2)) < 0.001)
            return true;

        return false;
    }

    public static double newValue(double number, double denominator, double powLevel){
        double denominatorValue = 1;
        for (double i = 1; i <= denominator; i++){
            denominatorValue *= i;
        }

        return Math.pow(number, powLevel) / denominatorValue;
    }
}
