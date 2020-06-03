package com.merge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {
    public static Integer[] readIntegerArray() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String  lines = br.readLine();

        String[] strs = lines.trim().split("\\s+");
        Integer[] array = new Integer[strs.length];

        for (int i = 0; i < strs.length; i++) {
            array[i] = Integer.parseInt(strs[i]);
        }

        return array;
    }

    public static void main(String[] args) throws IOException {
        System.out.print("Enter list 1: ");
	    Integer[] list1 = readIntegerArray();

	    System.out.print("Enter list 2: ");
	    Integer[] list2 = readIntegerArray();

	    Integer[] mergedList = merge(list1, list2);

	    System.out.println("The merged list is: ");
	    for (int digit : mergedList){
	        System.out.printf("%d, ", digit);
        }
    }

    public static Integer[] merge(Integer[] list1, Integer[] list2){
        HashSet<Integer> mergeList = new HashSet<Integer>();

        for (int i = 0; i < list1.length; i++){
            mergeList.add(list1[i]);
        }
        for (int i = 0; i < list2.length; i++){
            mergeList.add(list2[i]);
        }

        Integer[] mergedList = new Integer[mergeList.size()];
        TreeSet<Integer> sortedMergeList = new TreeSet<Integer>(mergeList);
        mergedList = sortedMergeList.toArray(new Integer[sortedMergeList.size()]);

        return mergedList;
    }
}
