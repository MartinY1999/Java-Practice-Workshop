package com.company;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        List<Integer> listOfNumbers = new ArrayList<>();
        double allNumsCount = getAllNumbersCount(listOfNumbers);
        listOfNumbers = getAllNumberWhichDivideBy12(listOfNumbers);
        System.out.printf("Possibility: %s%n", new DecimalFormat("0.##").format(listOfNumbers.size() / allNumsCount));
        System.out.println(String.format("%.0f", allNumsCount));
        System.out.println(listOfNumbers.size());
    }

    public static double getAllNumbersCount(List<Integer> listOfNumbers){

        for (int firstDigit = 3; firstDigit <= 9; firstDigit++)
            for (int secondDigit = 2; secondDigit <= 8; secondDigit++)
                for (int thirdDigit = 4; thirdDigit <= 9; thirdDigit++)
                    for (int fourthDigit = 1; fourthDigit <= 6; fourthDigit++)
                        for (int fifthDigit = 6; fifthDigit <= 9; fifthDigit++)
                        {
                            int number = 10000 * firstDigit + 1000 * secondDigit + 100 * thirdDigit + 10 * fourthDigit + fifthDigit;
                            listOfNumbers.add(number);
                        }

        return listOfNumbers.size();
    }

    public static List<Integer> getAllNumberWhichDivideBy12(List<Integer> listOfNumbers){
        listOfNumbers = listOfNumbers.stream().filter(x -> x % 12 == 0).collect(Collectors.toList());
        return listOfNumbers;
    }
}
