package com.matrix;

import java.util.Random;
import java.util.Scanner;

public class SquareMatrixTest {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int size = scanner.nextInt();
        int[][] squareMatrix = fillMatrix(size);
        SquareMatrix matrixController = new SquareMatrix(squareMatrix);
        System.out.println(matrixController.toString());
        System.out.println();
        matrixController.printAll();
    }

    public static int[][] fillMatrix(int size){
        int [][] matrix = new int[size][size];

        for (int row = 0; row < size; row++){
            matrix[row] = generateRow(size);
        }

        return matrix;
    }

    public static int[] generateRow(int size){
        int[] row = new int[size];
        Random generator = new Random();
        for (int i = 0; i < row.length; i++){
            row[i] = generator.nextInt(8);
        }

        return row;
    }
}
