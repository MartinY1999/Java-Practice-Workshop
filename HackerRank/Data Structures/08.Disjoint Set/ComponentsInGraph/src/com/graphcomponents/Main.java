package com.graphcomponents;

import java.io.*;
import java.util.*;

class Solution {
    static int[] componentsInGraph(int[][] gb) {
        Graph graph = new Graph();
        int minSize = Integer.MAX_VALUE;
        int maxSize = Integer.MIN_VALUE;
        int[] result = new int[2];

        for (int[] row : gb) {
            if (row.length != 2)
                continue;

            graph.addEdge(row[0], row[1]);
            graph.addEdge(row[1], row[0]);
        }

        for (int vertex : graph.vertices) {
            int currentSize = graph.dfs(vertex);

            minSize = Math.min(currentSize, minSize);
            maxSize = Math.max(currentSize, maxSize);
        }

        result[0] = minSize;
        result[1] = maxSize;

        return result;
    }

    private static class Graph {
        private int numberOfVertices;
        private HashSet<Integer> vertices;
        private LinkedList<Integer>[] adjacent;

        public Graph() {
            this.numberOfVertices = 30000;
            this.vertices = new HashSet<>();
            this.adjacent = new LinkedList[numberOfVertices];

            for (int i = 0; i < numberOfVertices; ++i) {
                this.adjacent[i] = new LinkedList();
            }
        }

        public void addEdge(int vertex, int edge) {
            this.adjacent[vertex].add(edge);

            this.vertices.add(vertex);
        }

        public int dfs(int vertex) {
            boolean[] visited = new boolean[30001];

            return dfsComponentSize(vertex, visited);
        }

        private int dfsComponentSize(int vertex, boolean[] visited) {
            int componentSize = 1;
            visited[vertex] = true;

            Iterator<Integer> iterator = this.adjacent[vertex].listIterator();
            while (iterator.hasNext()) {
                int current = iterator.next();

                if (visited[current] == false)
                    componentSize += dfsComponentSize(current, visited);
            }

            return componentSize;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] gb = new int[n][2];

        for (int gbRowItr = 0; gbRowItr < n; gbRowItr++) {
            String[] gbRowItems = scanner.nextLine().split(" ");

            for (int gbColumnItr = 0; gbColumnItr < 2; gbColumnItr++) {
                int gbItem = Integer.parseInt(gbRowItems[gbColumnItr].trim());
                gb[gbRowItr][gbColumnItr] = gbItem;
            }
        }

        int[] result = componentsInGraph(gb);

        for (int SPACEItr = 0; SPACEItr < result.length; SPACEItr++) {
            System.out.println(result[SPACEItr]);
        }
    }
}
