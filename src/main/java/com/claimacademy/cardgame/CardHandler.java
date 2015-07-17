package com.claimacademy.cardgame;

import java.util.ArrayList;

/**
 * Created by benjamin on 7/8/15.
 */
public class CardHandler {
    public static void addCard(ArrayList<Card> cardList, Card card){
        if ((!cardList.contains(card))){
            cardList.add(card);
        }else{
            System.out.println("The hand is full or that card is already in !");
        }
    }
    public static void removeCard(ArrayList<Card> cardList,Card card){
        if(cardList.size() > 0 && cardList.contains(card)){
            cardList.remove(card);
        }
    }

    public static void printCards(ArrayList<Card> cardList){
        for(Card card: cardList){
            card.printCard();
        }
    }
}