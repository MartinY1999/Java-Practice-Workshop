package com.equalStacks;

import java.io.*;
import java.util.*;

class Solution {
    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        Stack<Integer> firstStack = new Stack<Integer>();
        Stack<Integer> secondStack = new Stack<Integer>();
        Stack<Integer> thirdStack = new Stack<Integer>();

        int firstHeight, secondHeight, thirdHeight;
        firstHeight = secondHeight = thirdHeight = 0;

        for (int i = h1.length - 1; i >= 0; i--) {
            firstStack.push(h1[i]);
            firstHeight += h1[i];
        }

        for (int i = h2.length - 1; i >= 0; i--) {
            secondStack.push(h2[i]);
            secondHeight += h2[i];
        }

        for (int i = h3.length - 1; i >= 0; i--) {
            thirdStack.push(h3[i]);
            thirdHeight += h3[i];
        }

        int minStack = Math.min(Math.min(firstHeight, secondHeight), thirdHeight);

        while (firstHeight != secondHeight || firstHeight != thirdHeight || secondHeight != thirdHeight) {
            while (firstHeight > minStack) {
                firstHeight -= firstStack.pop();
            }
            minStack = Math.min(Math.min(firstHeight, secondHeight), thirdHeight);

            while (secondHeight > minStack) {
                secondHeight -= secondStack.pop();
            }
            minStack = Math.min(Math.min(firstHeight, secondHeight), thirdHeight);

            while (thirdHeight > minStack) {
                thirdHeight -= thirdStack.pop();
            }
            minStack = Math.min(Math.min(firstHeight, secondHeight), thirdHeight);
        }

        return minStack;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] n1N2N3 = scanner.nextLine().split(" ");

        int n1 = Integer.parseInt(n1N2N3[0].trim());

        int n2 = Integer.parseInt(n1N2N3[1].trim());

        int n3 = Integer.parseInt(n1N2N3[2].trim());

        int[] h1 = new int[n1];

        String[] h1Items = scanner.nextLine().split(" ");

        for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
            int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
            h1[h1Itr] = h1Item;
        }

        int[] h2 = new int[n2];

        String[] h2Items = scanner.nextLine().split(" ");

        for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
            int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
            h2[h2Itr] = h2Item;
        }

        int[] h3 = new int[n3];

        String[] h3Items = scanner.nextLine().split(" ");

        for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
            int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
            h3[h3Itr] = h3Item;
        }

        int result = equalStacks(h1, h2, h3);

        System.out.println(String.valueOf(result));
    }
}
