package com.claimacademy.cardgame;

import java.util.*;

/**
 * Created by benjamin on 7/17/15.
 */
public class Hand {
    private ArrayList<Card> cards = new ArrayList<Card>();



    public void addCard(Card card) {
        cards.add(card);
    }







    /**
     * Sort cards simply sorts the List of cards based on card integer.
     */
    public void sortCards() {
        Collections.sort(cards, new CardIntComparator());
    }

    public void printHand() {
        for(Card card : cards){
            System.out.println(card.getCardName() + " of "+ card.getSuit() );
        }
    }





    public ArrayList<Card> getCards() {
        return cards;
    }


    protected ArrayList<Integer[]> stripMap(HashMap cardMap) {
        ArrayList<Integer[]> arInt = new ArrayList<Integer[]>();
        Iterator<Map.Entry<Integer, Integer>> iterator = cardMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            if (entry.getValue() > 0) {
                arInt.add(new Integer[]{entry.getKey(), entry.getValue()});
            }
        }
        return arInt;
    }

    public static class CardIntComparator implements Comparator<Card> {

        public int compare(Card card1, Card card2) {
            if (card1.getCardInt() > card2.getCardInt()) return -1;
            return 1;
        }
    }

    public static class CardSuitComparator implements Comparator<Card> {

        public int compare(Card card1, Card card2) {
            return card1.getSuit().compareTo(card2.getSuit());
        }
    }




}
