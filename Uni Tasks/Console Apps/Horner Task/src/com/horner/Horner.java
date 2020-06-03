package com.horner;

public class Horner {
    private int x;

    public Horner(int x){
        this.x = x;
    }

    public double computeByHorner(double[] digits){
        int k = digits.length - 1;
        double bk = digits[k];
        while (k > 0){
            bk = digits[k - 1] + x * bk;
            k--;
        }

        return bk;
    }
}
