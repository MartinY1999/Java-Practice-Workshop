package com.arraysds;

import java.util.*;

public class Main {
    public static final Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
	    String[] items = reader.nextLine().split(" ");
	    int[] array = new int[items.length];

	    for (int i = 0; i < array.length; i++){
	        array[i] = Integer.parseInt(items[i]);
        }

	    int mid = array.length / 2;
		int index = 0;

		while (index != mid){
			int temp = array[array.length - 1 - index];
			array[array.length - 1 - index] = array[index];
			array[index] = temp;

			index++;
		}

	    System.out.println(Arrays.toString(array));
    }
}
