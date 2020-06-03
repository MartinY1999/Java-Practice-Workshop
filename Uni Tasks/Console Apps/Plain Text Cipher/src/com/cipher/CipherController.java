package com.cipher;

import java.util.Arrays;

public class CipherController {
    private char[] lowerAlphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private char[] upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private String word;
    private int finalLength;

    public CipherController(String word, int length){
        this.word = word;
        this.finalLength = length;
    }

    public String cipher(){
        StringBuilder result = new StringBuilder();
        char[] textToCipher = this.word.toCharArray();

        for (int i = 0; i < textToCipher.length; i++){
            if (Character.isLowerCase(textToCipher[i]))
                result.append(cipherFromLowerAlphabet(textToCipher[i]));
            else
                result.append(cipherFromUpperAlphabet(textToCipher[i]));
        }

        return result.toString();
    }

    private Character cipherFromLowerAlphabet(char letter){
        int index = new String(lowerAlphabet).indexOf(letter);
        if (index + finalLength >= lowerAlphabet.length)
            return lowerAlphabet[index + finalLength - lowerAlphabet.length];
        else
            return lowerAlphabet[index + finalLength];
    }

    private Character cipherFromUpperAlphabet(char letter){
        int index = new String(upperAlphabet).indexOf(letter);
        if (index + finalLength >= upperAlphabet.length)
            return upperAlphabet[index + finalLength - upperAlphabet.length];
        else
            return upperAlphabet[index + finalLength];
    }

    public String decipher(){
        StringBuilder result = new StringBuilder();
        char[] textToCipher = this.word.toCharArray();

        for (int i = 0; i < textToCipher.length; i++){
            if (Character.isLowerCase(textToCipher[i]))
                result.append(decipherFromLowerAlphabet(textToCipher[i]));
            else
                result.append(decipherFromUpperAlphabet(textToCipher[i]));
        }

        return result.toString();
    }

    private Character decipherFromLowerAlphabet(char letter){
        int index = new String(lowerAlphabet).indexOf(letter);
        if (index - finalLength < 0)
            return lowerAlphabet[lowerAlphabet.length + (index - finalLength)];
        else
            return lowerAlphabet[index - finalLength];
    }

    private Character decipherFromUpperAlphabet(char letter){
        int index = new String(upperAlphabet).indexOf(letter);
        if (index - finalLength < 0)
            return upperAlphabet[upperAlphabet.length + (index - finalLength)];
        else
            return upperAlphabet[index - finalLength];
    }
}
