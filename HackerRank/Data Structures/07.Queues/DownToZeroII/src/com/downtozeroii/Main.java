package com.downtozeroii;

import java.io.*;
import java.util.*;

class Solution {
    static int downToZero(int n) {
        Queue<Integer> factors = new ArrayDeque<>();
        HashMap<Integer, Integer> steps = new HashMap<>();

        factors.offer(n);
        steps.put(n, 0);

        while (!factors.isEmpty() && !steps.containsKey(0)) {
            int number = factors.poll();
            int step = steps.get(number);
            int i = 2;

            while (i <= Math.sqrt(number))
            {
                if(number % i == 0 && number / i != 1)
                {
                    if(!steps.containsKey(number / i) || steps.get(number / i) > step + 1)
                    {
                        steps.put(number / i, step + 1);
                        factors.add(number / i);
                    }
                }

                i++;
            }
            if(!steps.containsKey(number - 1) || steps.get(number - 1) > step + 1)
            {
                factors.add(number - 1);
                steps.put(number - 1, step + 1);
            }
        }

        return steps.get(0);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int q = Integer.parseInt(scanner.nextLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            int n = Integer.parseInt(scanner.nextLine().trim());
            int result = downToZero(n);
            System.out.println(result);
        }
    }
}

