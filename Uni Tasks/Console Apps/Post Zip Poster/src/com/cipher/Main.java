package com.cipher;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        HashMap<Integer, String> customTable = new HashMap<Integer, String>(){
            {
                put(1, "00011");
                put(2, "00101");
                put(3, "00110");
                put(4, "01001");
                put(5, "01010");
                put(6, "01100");
                put(7, "10001");
                put(8, "10010");
                put(9, "10100");
                put(0, "11000");
            }
        };

        BarCode barCodeController = new BarCode(customTable);
        int barCode = reader.nextInt();
        System.out.println(barCodeController.decode(barCode));
    }
}
