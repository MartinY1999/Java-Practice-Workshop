package com.cipher;

import java.util.ArrayList;

public class TransCipher {
    private String plainText;
    private int cipherKey;
    private StringBuilder customBuilder;
    private int rowCounter;

    public TransCipher(String plainText, String phrase){
        this.plainText = plainText;
        this.cipherKey = phrase.length();
        this.customBuilder = new StringBuilder();
    }

    public String encrypt(){
        String textToEncrypt = plainText;
        ArrayList<String> parts = splitText(textToEncrypt);

        customBuilder.setLength(0);
        for (int i = 0; i < cipherKey; i++){
            for (int k = 0; k < parts.size(); k++){
                customBuilder.append(parts.get(k).toCharArray()[i]);
            }
        }

        return customBuilder.toString();
    }

    private ArrayList<String> splitText(String textToEncrypt) {
        ArrayList<String> list = new ArrayList<String>();
        int index = 0;
        this.rowCounter = 0;

        while (index < textToEncrypt.length()) {
            if (index + this.cipherKey < textToEncrypt.length()) {
                list.add(textToEncrypt.substring(index, index + cipherKey));
                index += cipherKey;
            }
            else{
                ArrayList<Character> lastPart = new ArrayList<>(cipherKey);
                String lastPartText = textToEncrypt.substring(index, textToEncrypt.length());
                while (lastPartText.length() != cipherKey){
                    lastPartText += ' ';
                }

                list.add(lastPartText);
                index += cipherKey;
            }

            this.rowCounter++;
        }

        return list;
    }

    public String decrypt(){
        String textToDecrypt = plainText;
        splitText(textToDecrypt);
        ArrayList<String> parts = splitDecryptedText(textToDecrypt);

        customBuilder.setLength(0);
        for (int i = 0; i < this.rowCounter; i++){
            for (int k = 0; k < parts.size(); k++){
                customBuilder.append(parts.get(k).toCharArray()[i]);
            }
        }

        return customBuilder.toString();
    }

    private ArrayList<String> splitDecryptedText(String text){
        ArrayList<String> parts = new ArrayList<String>();
        int index = 0;

        while (index < text.length()){
            parts.add(text.substring(index, index + this.rowCounter));
            index += this.rowCounter;
        }

        return parts;
    }
}
