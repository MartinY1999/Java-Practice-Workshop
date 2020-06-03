package com.decks;

public class Main {

    public static void main(String[] args) {
        DeckOfCards myDeckOfCards = new DeckOfCards();
        myDeckOfCards.shuffle(); // place Cards in random order
        System.out.println(myDeckOfCards.dealHand());
        System.out.println(myDeckOfCards.pokerHandPower());
    }
}
