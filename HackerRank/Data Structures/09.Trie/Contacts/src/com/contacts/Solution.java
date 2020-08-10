package com.contacts;

import java.io.*;
import java.util.*;

class Solution {
    static int[] contacts(String[][] queries) {
        Trie trie = new Trie();
        List<Integer> counts = new ArrayList<>();

        for (String[] row : queries) {
            String command = row[0];
            String word = row[1];

            if (command.equals("add"))
                trie.insert(word);
            if (command.equals("find"))
                counts.add(trie.find(word));
        }

        return counts.stream().mapToInt(i -> i).toArray();
    }

    private static class Node {
        private HashMap<Character, Node> children;
        private boolean endOfWord;
        private int size;

        public Node() {
            this.children = new HashMap<>();
            this.endOfWord = false;
            this.size = 0;
        }
    }

    private static class Trie {
        private final Node root;

        public Trie() {
            this.root = new Node();
        }

        public void insert(String word) {
            Node current = root;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                current.children.putIfAbsent(ch, new Node());

                current = current.children.get(ch);
                current.size++;
            }

            current.endOfWord = true;
        }

        public int find(String match) {
            Node current = root;

            for (char ch : match.toCharArray()) {
                current = current.children.get(ch);
                if (current == null) {
                    return 0;
                }
            }
            return current.size;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int queriesRows = Integer.parseInt(scanner.nextLine().trim());
        String[][] queries = new String[queriesRows][2];

        for (int queriesRowItr = 0; queriesRowItr < queriesRows; queriesRowItr++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");

            for (int queriesColumnItr = 0; queriesColumnItr < 2; queriesColumnItr++) {
                String queriesItem = queriesRowItems[queriesColumnItr];
                queries[queriesRowItr][queriesColumnItr] = queriesItem;
            }
        }

        int[] result = contacts(queries);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            System.out.println(result[resultItr]);
        }
    }
}
