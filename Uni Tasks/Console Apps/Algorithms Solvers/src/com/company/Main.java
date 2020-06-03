package com.company;

import java.util.Scanner;

public class Main {

    public static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        String message = reader.nextLine();
        solutionCaller(message);
    }

    private static void solutionCaller(String message){
        switch (message){
            case "first":
                firstAlgorithmSolver();
                break;
            case "second":
                secondAlgorithmSolver();
                break;
            case "third":
                thirdAlgorithmSolver();
                break;
        }
    }

    private static void firstAlgorithmSolver(){
        double number = reader.nextDouble();
        double sum = 1 + algorithmSolver(number);
        System.out.printf("Result: %s%n", String.format("%.3f", sum));
    }

    private static double algorithmSolver(double number){
        double denominator = 1;
        double sumToAdd = 0;
        while (denominator < number){
            sumToAdd += newValue(denominator);
            denominator += 1;
        }

        return sumToAdd;
    }

    private static double newValue(double denominator){
        double denominatorValue = 1;
        for (double i = 1; i <= denominator; i++){
            denominatorValue *= i;
        }

        return 1 / denominatorValue;
    }

    private static void secondAlgorithmSolver(){
        // not completed
    }

    private static void thirdAlgorithmSolver(){
        double x = reader.nextDouble();
        double sum = getSinX(x) + getCosX(x);
        System.out.printf("Result: %s%n", String.format("%.5f", sum));
    }


    private static double getSinX(double x){
        double result = 0;
        for (int i = 1; i <= x; i++){
            result += (Math.pow(-1, i) / getSinDenominator(i)) * Math.pow(x, 2 * i + 1);
        }

        return result;
    }

    private static double getSinDenominator(double number){
        double denominator = 1;
        for (double i = 1; i <= 2 * number + 1; i++){
            denominator *= i;
        }

        return denominator;
    }

    private static double getCosX(double x){
        double result = 0;
        for (int i = 1; i <= x; i++){
            result += (Math.pow(-1, i) / getCosDenominator(i)) * Math.pow(x, 2 * i);
        }

        return result;
    }

    private static double getCosDenominator(double number){
        double denominator = 1;
        for (double i = 1; i <= 2 * number; i++){
            denominator *= i;
        }

        return denominator;
    }
}
