package com.couponDecks;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class DeckOfCards {
    private Card deck[]; // array of Card objects
    private int currentCard; // index of next Card to be dealt
    private final int NUMBER_OF_CARDS = 52; // constant number of Cards
    private Random randomNumbers; // random number generator
    private Card[] pokerHand;

    public DeckOfCards()
    {
        String faces[] = { "Ace", "Deuce", "Three", "Four", "Five", "Six",
                "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
        String suits[] = { "Hearts", "Diamonds", "Clubs", "Spades" };

        deck = new Card[ NUMBER_OF_CARDS ]; // create array of Card objects
        currentCard = 0; // set currentCard so first Card dealt is deck[ 0 ]
        randomNumbers = new Random(); // create random number generator

        // populate deck with Card objects
        for ( int count = 0; count < deck.length; count++ )
            deck[ count ] =
                    new Card( faces[ count % 13 ], suits[ count / 13 ] );

        pokerHand = new Card[4];
    }

    public void shuffle()
    {
        Collections.shuffle(Arrays.asList(this.deck));
    }

    public Card dealCard()
    {
        // determine whether Cards remain to be dealt
        if ( currentCard < deck.length )
            return deck[ currentCard++ ]; // return current Card in array
        else
            return null; // return null to indicate that all Cards were dealt
    }

    public String dealHand(){
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < pokerHand.length; i++){
            this.pokerHand[i] = dealCard();
            builder.append(pokerHand[i].toString() + "\n");
        }

        return builder.toString();
    }

    public boolean allSuitsDifferent(){
        HashSet<String> suits = new HashSet<String>();
        for (int i = 0; i < this.pokerHand.length; i++){
            suits.add(this.pokerHand[i].getSuit());
        }

        return suits.size() == 4;
    }
}
