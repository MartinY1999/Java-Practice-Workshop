package com.cipher;

import java.util.ArrayList;
import java.util.HashMap;

public class BarCode {
    private HashMap<Integer, String> codeTable;

    public BarCode(HashMap<Integer, String> table){
        this.codeTable = table;
    }

    public String decode(int zipCode){
        ArrayList<Integer> zipDigits = splitZipCode(zipCode);
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < zipDigits.size(); i++){
            if (this.codeTable.containsKey(zipDigits.get(i))){
                builder.append(convertBarCode(this.codeTable.get(zipDigits.get(i))));
            }
        }

        return builder.toString();
    }

    private ArrayList<Integer> splitZipCode(int zipCode){
        ArrayList<Integer> digits = new ArrayList<Integer>();

        while (zipCode > 0){
            digits.add(zipCode % 10);
            zipCode /= 10;
        }

        return digits;
    }

    private String convertBarCode(String barCode){
        String result = "";

        for (char letter : barCode.toCharArray()){
            if (letter == '0')
                result += ':';
            else
                result += '|';
        }

        return result;
    }
}
