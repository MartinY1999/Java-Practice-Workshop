package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main
{
    public static Scanner reader = new Scanner (System.in);

    public static void main(String[] args)
    {
        int inputNumber = Integer.parseInt(reader.nextLine());
        String command = reader.nextLine();

        if (command.equals("encrypt"))
            encryptNumber(inputNumber);
        else if (command.equals("decrypt"))
            decryptNumber(inputNumber);
        else
            System.out.println("Invalid command!");
    }

    public static void encryptNumber(int number)
    {
        ArrayList<Integer> digitsEncrypted = new ArrayList<Integer>();
        while (number > 0)
        {
            digitsEncrypted.add((number % 10 + 7) % 10);
            number /= 10;
        }
        Collections.reverse(digitsEncrypted);
        swapDigits(digitsEncrypted);
        System.out.println(digitsEncrypted.stream().map(String::valueOf)
                .collect(Collectors.joining("")));
    }

    public static void decryptNumber(int number)
    {
        ArrayList<Integer> digitsDecrypted = new ArrayList<Integer>();
        while (number > 0)
        {
            digitsDecrypted.add(modInverse(number % 10));
            number /= 10;
        }
        Collections.reverse(digitsDecrypted);
        swapDigits(digitsDecrypted);
        System.out.println(digitsDecrypted.stream().map(String::valueOf)
                .collect(Collectors.joining("")));
    }

    private static void swapDigits(ArrayList<Integer> digitList)
    {
        for (int i = 0; i < digitList.size() / 2; i++)
        {
            Collections.swap(digitList, i, i + 2);
        }
    }

    private static int modInverse(int number)
    {

        for (int x = 1; x < 10; x++)
            if ((x + 7) % 10 == number)
                return x;
        return 0;
    }
}
