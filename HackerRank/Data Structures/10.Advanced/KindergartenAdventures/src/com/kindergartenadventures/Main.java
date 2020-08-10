package com.kindergartenadventures;

import java.io.*;
import java.util.*;

class Solution {
    private static int solve(int[] t) {
        int[] deltas = new int[t.length];
        int current = 0;

        for (int i = 0; i < t.length; i++) {
            if (i >= t[i]) {
                current++;
            }

            deltas[(i + 1- t[i] + t.length) % t.length]--;
            deltas[(i + 1) % t.length]++;
        }

        int result = 0;
        int bestVal = current;

        for(int i = 1; i < t.length; i++) {
            if ((current += deltas[i]) > bestVal) {
                bestVal = current;
                result = i;
            }
        }

        return result+1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int tCount = Integer.parseInt(scanner.nextLine().trim());
        int[] t = new int[tCount];
        String[] tItems = scanner.nextLine().split(" ");

        for (int tItr = 0; tItr < tCount; tItr++) {
            int tItem = Integer.parseInt(tItems[tItr].trim());
            t[tItr] = tItem;
        }

        int id = solve(t);
        System.out.println(id);
    }
}
