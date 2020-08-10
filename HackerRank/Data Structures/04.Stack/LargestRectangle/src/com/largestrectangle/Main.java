package com.largestrectangle;

import java.io.*;
import java.util.*;

class Solution {
    static long largestRectangle(int[] h) {
        long maxArea = 1;
        long minHeight = 0;
        long width = 0;

        int left = 0;
        int right = 0;

        for(int i = 0; i < h.length; i++)
        {
            minHeight = h[i];
            width = 0;
            left = i;
            right = i;

            while(left >= 0 && h[left] >= minHeight)
            {
                width++;
                left--;
            }

            while(right < h.length && h[right] >= minHeight)
            {
                width++;
                right++;
            }
            width -= 1;
            maxArea = Math.max(maxArea,(minHeight*width));
        }

        return maxArea;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] h = new int[n];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        long result = largestRectangle(h);

        System.out.println(result);
        scanner.close();
    }
}
