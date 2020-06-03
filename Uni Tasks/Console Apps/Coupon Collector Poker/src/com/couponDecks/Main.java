package com.couponDecks;

public class Main {

    public static void main(String[] args) {
        DeckOfCards myDeckOfCards = new DeckOfCards();
        myDeckOfCards.shuffle(); // place Cards in random order

        boolean found = false;
        String resultHand = "";
        int counter = 0;

        while (!found){
            String currentHand = myDeckOfCards.dealHand();
            if (myDeckOfCards.allSuitsDifferent()){
                resultHand = currentHand;
                found = true;
            }

            counter++;
        }

        System.out.println(resultHand);
        System.out.println("Number of picks: " + counter);
    }
}
