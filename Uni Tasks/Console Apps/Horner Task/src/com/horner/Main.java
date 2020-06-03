package com.horner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        double[] digits = readDoubleArray();
        Horner controllerx2 = new Horner(2);
        Horner controllerx10 = new Horner(10);

        System.out.printf("Base 2: %f", controllerx2.computeByHorner(digits));
        System.out.printf("Base 10: %f", controllerx10.computeByHorner(digits));
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
