package com.simpletexteditor;

import java.util.*;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
	    int tests = scanner.nextInt();
	    scanner.skip("\n");

	    Stack<String> changes = new Stack<>();
	    StringBuilder builder = new StringBuilder();

	    for (int i = 0; i < tests; i++) {

	    	int command = scanner.nextInt();

	        if (command == 1) {
				changes.push(builder.toString());
                builder.append(scanner.next());
            }
	        if (command == 2) {
				changes.push(builder.toString());

	            builder.delete(builder.length() - scanner.nextInt(), builder.length());
            }
	        if (command == 3) {
	            System.out.println(builder.charAt(scanner.nextInt() - 1));
            }
	        if (command == 4) {
	            builder.setLength(0);
	            builder.append(changes.pop());
            }
        }
    }
}
