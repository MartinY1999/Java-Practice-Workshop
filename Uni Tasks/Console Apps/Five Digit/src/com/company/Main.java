package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static Scanner reader = new Scanner(System.in);

    public static void main(String[] args)
    {
        int number = reader.nextInt();
        int originalNumber = number;
        List<Integer> digitList = new ArrayList<Integer>();
        if (!checkDigitCount(number))
        {
            System.out.println("Wrong number!");
            return;
        }

        fillList(number, digitList);
        String resultString = getResult(digitList);
        System.out.println(resultString);
    }

    public static boolean checkDigitCount(int number)
    {
        return String.valueOf(number).length() == 5;
    }

    public static void fillList(int number, List<Integer> digitList)
    {
        while (number > 0)
        {
            int digit = number % 10;
            digitList.add(digit);
            number /= 10;
        }
    }

    public static boolean checkIfPalindrome(List<Integer> digitList)
    {
        return digitList.get(0) == digitList.get(4) && digitList.get(1) == digitList.get(3);
    }

    public static String getResult(List<Integer> digitList)
    {
        if (checkIfPalindrome(digitList))
            return "The number is a palindrome";

        return "The number is not a palindrome";
    }
}
