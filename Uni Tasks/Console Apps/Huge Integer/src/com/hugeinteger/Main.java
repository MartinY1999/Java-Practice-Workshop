package com.hugeinteger;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Random generator = new Random();
	    int size = scanner.nextInt();
	    int[] hugeArray = new int[size];
	    int[] secondHugeArray = new int[size];

	    for (int index = 0; index < size; index++){
	        hugeArray[index] = generator.nextInt(9);
	        secondHugeArray[index] = generator.nextInt(9);
        }

	    HugeInteger hugeInteger = new HugeInteger(hugeArray);
	    HugeInteger secondHugeInteger = new HugeInteger(secondHugeArray);
	    HugeInteger hugeIntegerCopy = hugeInteger;

	    System.out.println(String.format("%s, %s", hugeInteger.toString(), secondHugeInteger.toString()));

	    System.out.printf("Sum Result: %s\n", HugeInteger.Extensions.additionResult(hugeInteger, secondHugeInteger));
        System.out.printf("Subtract Result: %s\n", HugeInteger.Extensions.subtractResult(hugeInteger, secondHugeInteger));
        System.out.printf("Multiplication Result: %s\n", HugeInteger.Extensions.multiplyResult(hugeInteger, secondHugeInteger));
        System.out.printf("Divide Result: %s\n", HugeInteger.Extensions.divideResult(hugeInteger, secondHugeInteger));

        System.out.printf("Are Equal: %s\n", hugeInteger.isEqualTo(hugeIntegerCopy) ? "true" : "false");
        System.out.printf("Is Bigger: %s\n", hugeInteger.isGreaterThan(secondHugeInteger) ? "true" : "false");
        System.out.printf("Is Zero: %s\n", hugeInteger.isZero() ? "true" : "false");
    }
}
