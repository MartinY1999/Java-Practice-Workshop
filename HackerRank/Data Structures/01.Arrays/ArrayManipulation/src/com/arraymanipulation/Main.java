package com.arraymanipulation;

import java.io.*;
import java.util.*;

class Solution {

    // 24.00/60 Points
    static long arrayManipulation(int n, int[][] queries) {
        long[] array = new long[n + 1];

        for (int[] row : queries){
            int start = row[0];
            int end = row[1];
            long sum = row[2];

            array[start] += sum;
            if (end < n)
                array[end + 1] -= sum;
        }

        long max = Long.MIN_VALUE;
        long tempMax = 0;

        for (int i = 1; i < n + 1; i++){
            tempMax += array[i];

            if (tempMax > max)
                max = tempMax;
        }

        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        System.out.println(result);
        scanner.close();
    }
}
