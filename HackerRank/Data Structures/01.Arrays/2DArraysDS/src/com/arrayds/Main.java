package com.arrayds;

import java.io.*;
import java.util.*;

class Solution {
    static int hourglassSum(int[][] arr) {
        List<Integer> allSums = new ArrayList<>();

        for (int column = 0; column < arr.length - 2; column++)
            for (int row = 0; row < arr.length - 2; row++){
                allSums.add(arr[column][row] + arr[column][row + 1] + arr[column][row + 2]
                                             + arr[column + 1][row + 1]
                          + arr[column + 2][row] + arr[column + 2][row + 1] + arr[column + 2][row + 2]);
            }

        return Collections.max(allSums);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        System.out.println(result);

        scanner.close();
    }
}

