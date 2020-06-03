package com.merge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int sizeOfArrays = reader.nextInt();
        double[][] leftMatrix = fillMatrix(sizeOfArrays);
        double[][] rightMatrix = fillMatrix(sizeOfArrays);
        double[][] multipliedMatrix = multiplyMatrix(leftMatrix, rightMatrix, sizeOfArrays);

        System.out.println(printMatrix(multipliedMatrix));
    }

    public static double[][] multiplyMatrix(double[][] first, double[][] second, int size){
        double[][] multipliedMatrix = new double[size][size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                double result = 0;

                for (int index = 0; index < size; index++){
                    result += (first[i][index] * second[index][j]);
                }

                multipliedMatrix[i][j] = result;
            }
        }

        return multipliedMatrix;
    }

    public static double[][] fillMatrix(int size) throws IOException {
        double[][] matrix = new double[size][size];

        for (int row = 0; row < size; row++){
            matrix[row] = readDoubleArray();
        }

        return matrix;
    }

    public static String printMatrix(double[][] matrix){
        StringBuilder builder = new StringBuilder();

        for (double[] row : matrix){
            for (int i = 0; i < row.length; i++){
                builder.append(String.valueOf(row[i]) + " ");
            }
            builder.append("\n");
        }

        return builder.toString();
    }

    public static double[] readDoubleArray() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String  lines = br.readLine();

        String[] strs = lines.trim().split("\\s+");
        double[] array = new double[strs.length];

        for (int i = 0; i < strs.length; i++) {
            array[i] = Double.parseDouble(strs[i]);
        }

        return array;
    }
}
