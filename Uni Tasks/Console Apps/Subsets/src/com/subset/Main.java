package com.subset;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
	    int size = scanner.nextInt();
	    int end = scanner.nextInt();
	    ArrayList<Integer> array = new ArrayList<Integer>();
	    for (int i = 1; i <= end; i++){
	        array.add(i);
	    }
	    printCombination(array, end, size);
    }

    public static void combinationUtil(ArrayList<Integer> arr, int end, int size,
                                int index, int data[], int i)
    {
        if (index == size) {
            StringBuilder current = new StringBuilder();
            current.append("(");
            for (int j = 0; j < size; j++) {
                current.append(String.format("%d, ", data[j]));
            }
            current.delete(current.length() - 2, current.length());
            current.append(")");
            System.out.printf("%s ", current.toString());
            return;
        }

        if (i >= end)
            return;


        data[index] = arr.get(i);
        combinationUtil(arr, end, size, index + 1,
                data, i + 1);

        combinationUtil(arr, end, size, index, data, i + 1);
    }

    public static void printCombination(ArrayList<Integer> arr, int end, int size)
    {
        int data[] = new int[size];

        combinationUtil(arr, end, size, 0, data, 0);
    }
}
