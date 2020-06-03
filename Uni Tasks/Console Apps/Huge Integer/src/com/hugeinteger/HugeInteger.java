package com.hugeinteger;

import java.math.BigInteger;
import java.util.Arrays;

public class HugeInteger {
    private int[] hugeIntegerArray;

    public HugeInteger(){

    }

    public HugeInteger(int[] array){
        setHugeIntegerArray(array);
    }

    public HugeInteger(HugeInteger other){
        setHugeIntegerArray(other.hugeIntegerArray);
    }

    public int[] getHugeIntegerArray() {
        return hugeIntegerArray;
    }

    public void setHugeIntegerArray(int[] hugeIntegerArray) {
        if (hugeIntegerArray.length > 40)
            throw new IllegalArgumentException("The length of the array is too long");

        this.hugeIntegerArray = new int[hugeIntegerArray.length];

        for (int i = 0; i < hugeIntegerArray.length; i++){
            this.hugeIntegerArray[i] = hugeIntegerArray[i];
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.hugeIntegerArray.length; i++){
            if (i == 0 && this.hugeIntegerArray[i] == 0)
                continue;

            builder.append(this.hugeIntegerArray[i]);
        }

        return builder.toString();
    }

    public static class Extensions {
        public static String additionResult(HugeInteger integer1, HugeInteger integer2){
            BigInteger bigInteger1 = new BigInteger(String.valueOf(integer1.toString()));
            BigInteger bigInteger2 = new BigInteger(String.valueOf(integer2.toString()));

            BigInteger bigIntegerResult = bigInteger1.add(bigInteger2);

            return bigIntegerResult.toString();
        }

        public static String subtractResult(HugeInteger integer1, HugeInteger integer2){
            BigInteger bigInteger1 = new BigInteger(String.valueOf(integer1.toString()));
            BigInteger bigInteger2 = new BigInteger(String.valueOf(integer2.toString()));

            BigInteger bigIntegerResult = bigInteger1.subtract(bigInteger2);

            return bigIntegerResult.toString();
        }

        public static String multiplyResult(HugeInteger integer1, HugeInteger integer2){
            BigInteger bigInteger1 = new BigInteger(String.valueOf(integer1.toString()));
            BigInteger bigInteger2 = new BigInteger(String.valueOf(integer2.toString()));

            BigInteger bigIntegerResult = bigInteger1.multiply(bigInteger2);

            return bigIntegerResult.toString();
        }

        public static String divideResult(HugeInteger integer1, HugeInteger integer2){
            BigInteger bigInteger1 = new BigInteger(String.valueOf(integer1.toString()));
            BigInteger bigInteger2 = new BigInteger(String.valueOf(integer2.toString()));

            BigInteger bigIntegerResult = bigInteger1.divide(bigInteger2);

            return bigIntegerResult.toString();
        }
    }

    public boolean isEqualTo(HugeInteger other){
        return new BigInteger(this.toString()).compareTo(new BigInteger(other.toString())) == 0;
    }

    public boolean isNotEqualTo(HugeInteger other){
        return new BigInteger(this.toString()).compareTo(new BigInteger(other.toString())) != 0;
    }

    public boolean isGreaterThan(HugeInteger other){
        return new BigInteger(this.toString()).compareTo(new BigInteger(other.toString())) > 0;
    }

    public boolean isLessThan(HugeInteger other){
        return new BigInteger(this.toString()).compareTo(new BigInteger(other.toString())) < 0;
    }

    public boolean isZero(){
        return new BigInteger(this.toString()).compareTo(BigInteger.ZERO) == 0;
    }
}
