package com.queuetwostacks;

import java.util.*;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
	    int tests = scanner.nextInt();
	    scanner.skip("\n");

	    Stack<Integer> queue = new Stack<>();

	    for (int i = 0; i < tests; i++) {
	        int command = scanner.nextInt();

	        if (command == 1) {
	            int number = scanner.nextInt();
	            queue.push(number);
            }
	        if (command == 2) {
	        	try {
					queue.removeElementAt(0);
				}
	        	catch(Exception e) {
	        		continue;
				}
            }
	        if (command == 3) {
				System.out.println(queue.firstElement());
            }
        }
    }
}
