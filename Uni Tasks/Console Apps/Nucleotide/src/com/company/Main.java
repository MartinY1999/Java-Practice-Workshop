package com.company;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main
{

    public static Scanner reader = new Scanner(System.in);

    public static void main(String[] args)
    {
        int number = reader.nextInt();
        if (!checkNumberLength(number))
        {
            System.out.println("Wrong number. Try again!");
            return;
        }

        String nucleotide = new StringBuffer(convertNumber(number)).reverse().toString();
        System.out.println(nucleotide);
    }

    public static boolean checkNumberLength(int number)
    {
        return String.valueOf(number).length() == 4;
    }

    public static String convertNumber(int number)
    {
        List<Character> characterList = new ArrayList<Character>();
        while (number > 0)
        {
            int remainder = number % 4;
            characterList.add(returnLetter(remainder));
            number /= 4;
        }

        return characterList.stream().map(e->e.toString()).collect(Collectors.joining());
    }

    public static char returnLetter(int remainder)
    {
        char letter;
        switch (remainder)
        {
            case 0:
                letter = 'A';
                break;
            case 1:
                letter = 'C';
                break;
            case 2:
                letter = 'G';
                break;
            case 3:
                letter = 'T';
                break;
            default:
                letter = ' ';
                break;
        }
        return letter;
    }

}
