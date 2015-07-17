package com.claimacademy.cardgame;

/**
 * Created by benjamin on 7/15/15.
 */
public class Card {
    private String suit;
    private String cardValue;
    private int  cardInt;


    public Card(String suit, String value, int cardInt) {
        this.suit = suit;
        this.cardValue = value;
        this.cardInt = cardInt;
    }

    public String printCard() {

        return (cardValue + " of " + suit);


    }

    public String getSuit() {
        return suit;
    }

    public String getCardName() {
        return cardValue;
    }

    public int getCardInt() {
        return cardInt;
    }
}
