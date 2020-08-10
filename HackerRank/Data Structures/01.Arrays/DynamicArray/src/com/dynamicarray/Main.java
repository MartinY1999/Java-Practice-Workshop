package com.dynamicarray;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        List<List<Integer>> seqList = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int lastAnswer = 0;

        for (int i = 0; i < n; i++){
            seqList.add(new ArrayList<>());
        }

        for (List<Integer> query : queries){
            int command = query.get(0);
            int x = query.get(1);
            int y = query.get(2);

            if (command == 1){
                seqList.get((x ^ lastAnswer) % n).add(y);
            }
            if (command == 2){
                List<Integer> seq = seqList.get((x ^ lastAnswer) % n);
                lastAnswer = seq.get(y % seq.size());
                result.add(lastAnswer);
            }
        }

        return result;
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);
        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.dynamicArray(n, queries);

        System.out.println(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
    }
}
