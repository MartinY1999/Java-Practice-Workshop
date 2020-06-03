package com.matrix;

import java.util.ArrayList;
import java.util.Arrays;

public class SquareMatrix {
    private int[][] dataArray;
    private int biggestRowSumAt = 0;
    private int biggestColumnSumAt = 0;
    private ArrayList<String> maxSubmatrices = new ArrayList<String>();

    public SquareMatrix() { }

    public SquareMatrix(int[][] dataArray){
        this.dataArray = dataArray;
    }

    public SquareMatrix(SquareMatrix other){
        this.dataArray = Arrays.stream(other.dataArray).map(int[]::clone).toArray(int[][]::new);
    }

    public int[][] getDataArray() {
        return dataArray;
    }

    public void setDataArray(int[][] dataArray) {
        this.dataArray = dataArray;
    }

    public int findMaxSum(){
        int currentRow = 0;
        int currentColumn = 0;
        int maxSum = Integer.MIN_VALUE;

        while (currentRow <= this.dataArray.length - 2){
            currentColumn = 0;
            while (currentColumn <= this.dataArray.length - 2) {
                int currentSum = returnCurrentSumOfSubMatrix(currentRow, currentColumn);

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    this.biggestRowSumAt = currentRow;
                    this.biggestColumnSumAt = currentColumn;
                }

                currentColumn++;
            }
            currentRow++;
        }

        return maxSum;
    }

    private int returnCurrentSumOfSubMatrix(int row, int column){
        return this.dataArray[row][column] + this.dataArray[row][column + 1]
                + this.dataArray[row + 1][column] + this.dataArray[row + 1][column + 1];
    }

    private void findAllMaxSubmatrices(int maxSum){

        int currentRow = 0;
        int currentColumn = 0;

        while (currentRow <= this.dataArray.length - 2){
            currentColumn = 0;
            while (currentColumn <= this.dataArray.length - 2) {
                int currentSum = returnCurrentSumOfSubMatrix(currentRow, currentColumn);

                if (currentSum == maxSum) {
                    this.maxSubmatrices.add("[" + currentRow + ", " + currentColumn + "]");
                }

                currentColumn++;
            }
            currentRow++;
        }
    }

    public void printAll(){
        int maxSum = findMaxSum();
        findAllMaxSubmatrices(maxSum);

        System.out.println("Maximum sum: " + maxSum);
        System.out.println("Submatrices with Maximum sum:");
        for (String submatrix : this.maxSubmatrices){
            System.out.print(submatrix + " ");
        }
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();

        for (int[] row : this.dataArray){
            for (int element : row){
                builder.append(element + " ");
            }
            builder.append("\n");
        }

        return builder.toString();
    }
}
