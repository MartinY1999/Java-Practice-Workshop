package com.creditcard;

import java.util.Scanner;

public class Main {
    public static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        String firstNumber = convertToBinary(reader.nextInt());
        String secondNumber = convertToBinary(reader.nextInt());

        System.out.println(firstNumber);
        System.out.println(secondNumber);
        System.out.println(hammingDistance(firstNumber, secondNumber));
    }

    public static int hammingDistance(String first, String second){
        int distance = 0;
        for (int i = 0; i < first.length() && i < second.length(); i++){
            if (first.charAt(i) != second.charAt(i))
                distance++;
        }

        return distance;
    }

    public static String convertToBinary(int number){
        String result = Integer.toBinaryString(number);
        while (result.length() != 8){
            result = "0" + result;
        }

        return result;
    }
}
