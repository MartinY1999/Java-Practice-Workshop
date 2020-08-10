package com.jesseandcookies;

import java.io.*;

import java.util.*;

class Solution {
    static int cookies(int k, int[] A) {
        int result = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i : A)
            heap.add(i);

        boolean allReady = false;

        while (!allReady && heap.size() >= 1) {
            Iterator<Integer> iterator = heap.iterator();
            int count = 0;
            while (iterator.hasNext()) {
                if (iterator.next() < k)
                    break;
                else
                    count++;
            }

            if (count == heap.size())
                allReady = true;
            else {
                try {
                    heap.add(heap.remove() + 2 * heap.remove());
                }
                catch(Exception e ) {
                    continue;
                }
                result++;
            }
        }

        return allReady == false ? -1 : result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0].trim());

        int k = Integer.parseInt(nk[1].trim());

        int[] A = new int[n];

        String[] AItems = scanner.nextLine().split(" ");

        for (int AItr = 0; AItr < n; AItr++) {
            int AItem = Integer.parseInt(AItems[AItr].trim());
            A[AItr] = AItem;
        }

        int result = cookies(k, A);

        System.out.println(result);
    }
}
