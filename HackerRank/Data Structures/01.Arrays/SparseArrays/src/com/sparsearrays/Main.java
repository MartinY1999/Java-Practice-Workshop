package com.sparsearrays;

import java.io.*;
import java.util.*;


class Solution {
    static int[] matchingStrings(String[] strings, String[] queries) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String string : strings) {
            if (!map.containsKey(string))
                map.put(string, 1);
            else
                map.put(string, map.getOrDefault(string, 1) + 1);
        }

        int[] results = new int[queries.length];

        int index = 0;
        for (String query : queries) {
            results[index] = map.containsKey(query) ? map.get(query) : 0;
            index++;
        }

        return results;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int stringsCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] strings = new String[stringsCount];

        for (int i = 0; i < stringsCount; i++) {
            String stringsItem = scanner.nextLine();
            strings[i] = stringsItem;
        }

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] queries = new String[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            String queriesItem = scanner.nextLine();
            queries[i] = queriesItem;
        }

        int[] res = matchingStrings(strings, queries);

        for (int i = 0; i < res.length; i++) {
            System.out.println(String.valueOf(res[i]));
        }

        scanner.close();
    }
}

