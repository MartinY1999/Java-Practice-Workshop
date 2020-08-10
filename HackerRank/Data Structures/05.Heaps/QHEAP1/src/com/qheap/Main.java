package com.qheap;

import java.util.*;

public class Main {
    public static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        int tests = reader.nextInt();
        reader.skip("\n");

        PriorityQueue<Long> heap = new PriorityQueue<>();

        for (int i = 0; i < tests; i++) {
            String[] parts = reader.nextLine().split(" ");
            int command = Integer.parseInt(parts[0]);
            long number;

            switch (command) {
                case 1:
                    number = Long.parseLong(parts[1]);
                    heap.add(number);
                    break;
                case 2:
                    number = Long.parseLong(parts[1]);
                    heap.remove(number);
                    break;
                case 3:
                    System.out.println(heap.iterator().next());
                    break;
            }
        }
    }
}