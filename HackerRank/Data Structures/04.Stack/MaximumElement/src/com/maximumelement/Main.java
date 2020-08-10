package com.maximumelement;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> maxes = new Stack<>();
        int tests = scanner.nextInt();
        int maxElement = Integer.MIN_VALUE;
        scanner.skip("\n");

        for (int i = 0; i < tests; i++) {
            String[] commandParts = scanner.nextLine().split(" ");
            int command = Integer.parseInt(commandParts[0]);

            if (command == 1) {
                int number = Integer.parseInt(commandParts[1]);
                if (number > maxElement) {
                    maxElement = number;
                    maxes.push(maxElement);
                }
                stack.push(number);
            }
            if (command == 2) {
                int number = stack.pop();
                if (number == maxElement) {
                    maxes.pop();
                    if (maxes.size() != 0)
                        maxElement = maxes.peek();
                    else
                        maxElement = Integer.MIN_VALUE;
                }
            }
            if (command == 3)
                System.out.println(maxElement);
        }
    }
}
