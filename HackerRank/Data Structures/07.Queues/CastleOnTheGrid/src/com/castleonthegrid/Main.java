package com.castleonthegrid;

import java.io.*;
import java.util.*;

class Solution {
    public static int rowLength;
    public static int columnLength;

    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {
        rowLength = grid.length;
        columnLength = grid.length;

        Queue<Position> moves = new ArrayDeque<>();
        int[][] matrix = new int[rowLength][columnLength];

        for (int i = 0; i < rowLength; i++) {
            char[] row = grid[i].toCharArray();
            for (int j = 0; j < columnLength; j++) {
                matrix[i][j] = row[j] == '.' ? 1 : -1;
            }
        }

        moves.offer(new Position(startX, startY, 0));

        while (!moves.isEmpty()) {
            Position current = moves.poll();

            if (current.row == goalX && current.column == goalY)
                return current.step;

            matrix[current.row][current.column] = 0;
            addMoves(moves, current, matrix);
        }

        return -1;
    }

    private static void addMoves(Queue<Position> moves, Position current, int[][] matrix) {
        int row = current.row;
        int col = current.column;
        int number = current.step + 1;

        while(--row >= 0 && matrix[row][col] == 1){
            moves.offer(new Position(row, col, number));
        }

        row = current.row;
        col = current.column;

        while(++row < matrix.length && matrix[row][col] == 1){
            moves.offer(new Position(row, col, number));
        }

        row = current.row;
        col = current.column;

        while(--col >= 0 && matrix[row][col] == 1){
            moves.offer(new Position(row, col, number));
        }

        row = current.row;
        col = current.column;

        while(++col < matrix.length && matrix[row][col] == 1){
            moves.offer(new Position(row, col, number));
        }
    }

    private static class Position {
        private int row;
        private int column;
        private int step;

        public Position(int row, int column, int step) {
            this.row = row;
            this.column = column;
            this.step = step;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] startXStartY = scanner.nextLine().split(" ");

        int startX = Integer.parseInt(startXStartY[0]);
        int startY = Integer.parseInt(startXStartY[1]);
        int goalX = Integer.parseInt(startXStartY[2]);
        int goalY = Integer.parseInt(startXStartY[3]);

        int result = minimumMoves(grid, startX, startY, goalX, goalY);

        System.out.println(result);
        scanner.close();
    }
}

