package com.decks;

import java.util.*;

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

        deck = new Card[NUMBER_OF_CARDS]; // create array of Card objects
        currentCard = 0; // set currentCard so first Card dealt is deck[0]
        randomNumbers = new Random(); // create random number generator

        // populate deck with Card objects
        for ( int count = 0; count < deck.length; count++ )
            deck[ count ] =
                    new Card( faces[ count % 13 ], suits[ count / 13 ] );

        pokerHand = new Card[5];
    }
    // shuffle deck of Cards with one-pass algorithm
    public void shuffle()
    {
        Collections.shuffle(Arrays.asList(this.deck));
    }

    // deal one Card
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

    public String pokerHandPower(){
        if (hasFullHouse())
            return "Full House";
        else if (hasStraight())
            return "Straight";
        else if (hasFlush())
            return "Flush";
        else if (hasFourOfAKind())
            return "Four of a kind";
        else if (hasTwoPairs())
            return "Three of a kind";
        else if (hasThreeOfAKind())
            return "Two Pairs";
        else if (hasPair())
            return "Pair";
        else
            return "None";
    }

    private boolean hasFullHouse(){
        //TODO: implement function
        return false;
    }

    private boolean hasStraight(){
        return false;
    }

    private boolean hasFlush(){
        boolean sameSuit = true;
        for (int i = 1; i < pokerHand.length; i++){
            if (pokerHand[i - 1].getSuit() != pokerHand[i].getSuit())
            {
                sameSuit = false;
                break;
            }
        }

        return sameSuit;
    }

    private boolean hasFourOfAKind(){
        return sameFacesChecker(3);
    }

    private boolean hasThreeOfAKind(){
        return sameFacesChecker(2);
    }

    private boolean hasTwoPairs(){
        ArrayList<String> faces = new ArrayList<>();
        for (int i = 0; i < pokerHand.length; i++){
            faces.add(pokerHand[i].getFace());
        }

        int duplicates = 0;
        for (int i = 0; i < faces.size() - 1; i++)
        {
            int copies = 0;
            for (int k = i + 1; k < faces.size(); k++)
            {
                if (faces.get(i).equals(faces.get(k)))
                    copies++;
            }

            if (copies == 1)
                duplicates++;
        }

        return duplicates == 2;
    }

    private boolean hasPair(){
        return sameFacesChecker(1);
    }

    private boolean sameFacesChecker(int number){
        HashSet<String> faces = new HashSet<String>();
        for (Card card : pokerHand){
            faces.add(card.getFace());
        }

        return faces.size() == pokerHand.length - number;
    }
}
