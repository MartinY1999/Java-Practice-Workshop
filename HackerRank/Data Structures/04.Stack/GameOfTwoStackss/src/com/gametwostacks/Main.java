package com.gametwostacks;

import java.io.*;
import java.util.*;

class Solution {static int twoStacks(int x, int[] a, int[] b) {
    if (a.length >= b.length)
        return play(a, b, x);
    else
        return play(b, a, x);
}

    static int play(int[] higher, int[] lower, int border) {
        int firstTryPopped = tryLowerStack(higher, lower, border);
        int secondTryPopped = tryLowerStack(lower, higher, border);

        return Math.max(firstTryPopped, secondTryPopped);
    }

    static int tryLowerStack(int[] higher, int[] lower, int border) {
        int validSum = 0;
        int poppedElements = 0;
        int lowIndex = -1;

        for (int element : lower) {
            if (validSum + element < border) {
                validSum += element;
                poppedElements++;
                lowIndex++;
            }
            else
                break;
        }

        for (int i = 0; i < higher.length; i++) {
            if (validSum + higher[i] > border) {
                if (lowIndex < 0)
                    break;
                else {
                    validSum = validSum - lower[lowIndex] + higher[i];
                    lowIndex--;
                }
            }
            else {
                validSum += higher[i];
                poppedElements++;
            }
        }

        return poppedElements;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int g = Integer.parseInt(scanner.nextLine().trim());

        for (int gItr = 0; gItr < g; gItr++) {
            String[] nmx = scanner.nextLine().split(" ");
            int n = Integer.parseInt(nmx[0].trim());
            int m = Integer.parseInt(nmx[1].trim());
            int x = Integer.parseInt(nmx[2].trim());
            int[] a = new int[n];
            String[] aItems = scanner.nextLine().split(" ");

            for (int aItr = 0; aItr < n; aItr++) {
                int aItem = Integer.parseInt(aItems[aItr].trim());
                a[aItr] = aItem;
            }

            int[] b = new int[m];
            String[] bItems = scanner.nextLine().split(" ");

            for (int bItr = 0; bItr < m; bItr++) {
                int bItem = Integer.parseInt(bItems[bItr].trim());
                b[bItr] = bItem;
            }

            int result = twoStacks(x, a, b);

            System.out.println(result);
        }
    }
}
