package com.coin;

public class MonetaryCoinTest {

    public static void main(String[] args) {
        MonetaryCoin coin1 = new MonetaryCoin(Face.HEAD);
        MonetaryCoin coin2 = new MonetaryCoin(Face.HEAD);
        MonetaryCoin coin3 = new MonetaryCoin(Face.TAIL);
        MonetaryCoin coin4 = new MonetaryCoin(Face.TAIL);

        coin4.flip();

        int sum = coin1.getFace().getValue() + coin2.getFace().getValue()
                + coin3.getFace().getValue() + coin4.getFace().getValue();

        System.out.printf("Sum: %d", sum);
    }
}
