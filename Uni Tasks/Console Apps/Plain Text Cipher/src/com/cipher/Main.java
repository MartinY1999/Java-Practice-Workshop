package com.cipher;

import java.util.Scanner;

public class Main {

    public static Scanner reader = new Scanner(System.in);
    public static CipherController cipherController;
    public static TransCipher transCipher;

    public static void main(String[] args) {
        showMenu();
        int option = reader.nextInt();
        reader.nextLine();

        if (option == 1 || option == 2) {
            String word = reader.nextLine();
            int finalLength = reader.nextInt();
            cipherController = new CipherController(word, finalLength);
        }
        else {
            String word = reader.nextLine();
            String phrase = reader.nextLine();
            transCipher = new TransCipher(word, phrase);
        }
        if (option == 1)
            System.out.println(cipherController.cipher());
        else if (option == 2)
            System.out.println(cipherController.decipher());
        else if (option == 3)
            System.out.println(transCipher.encrypt());
        else
            System.out.println(transCipher.decrypt());
    }

    public static void showMenu(){
        System.out.println("Choose option: ");
        System.out.println("Press 1 to cipher!");
        System.out.println("Press 2 to decipher!");
        System.out.println("Press 3 to trans encrypt");
        System.out.println("Press 4 to trans decrypt");
    }
}
