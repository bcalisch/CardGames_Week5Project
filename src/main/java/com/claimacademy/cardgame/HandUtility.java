package com.claimacademy.cardgame;

import java.util.HashMap;

/**
 * Created by benjamin on 7/15/15.
 */
public class HandUtility {
    public static enum HANDRANK {
        HIGH_CARD, ONE_PAIR, TWO_PAIR, THREE_OF_A_KIND, STRAIGHT, FLUSH, FULL_HOUSE, FOUR_OF_A_KIND, STRAIGHT_FLUSH, ROYAL_FLUSH;
    }

    public enum SUIT {

        SPADES("Spades"), HEARTS("Hearts"), CLUBS("Clubs"), DIAMONDS("Diamonds");

        public final String DISPLAYNAME;

        SUIT(String DISPLAYNAME) {
            this.DISPLAYNAME = DISPLAYNAME;
        }
    }

    public enum VALUE {
        TWO("Two", 2), THREE("Three", 3), FOUR("Four", 4), FIVE("Five", 5), SIX("Six", 6),
        SEVEN("Seven", 7), EIGHT("Eight", 8), NINE("Nine", 9), TEN("Ten", 10), JACK("Jack", 11),
        QUEEN("Queen", 12), KING("King", 13), ACE("Ace", 14);

        public final int VALUE;
        public final String DISPLAYNAME;

        VALUE(String DISPLAYNAME, int VALUE) {
            this.VALUE = VALUE;
            this.DISPLAYNAME = DISPLAYNAME;
        }

        public int getValue() {
            return VALUE;
        }
    }

    public static HashMap makeValueMap() {
        HashMap<Integer, String> valueMap = new HashMap<Integer, String>();
        valueMap.put(2, "Two");
        valueMap.put(3, "Three");
        valueMap.put(4, "Four");
        valueMap.put(5, "Five");
        valueMap.put(6, "Six");
        valueMap.put(7, "Seven");
        valueMap.put(8, "Eight");
        valueMap.put(9, "Nine");
        valueMap.put(10, "Ten");
        valueMap.put(11, "Jack");
        valueMap.put(12, "Queen");
        valueMap.put(13, "King");
        valueMap.put(14, "Ace");
        return valueMap;
    }

    public static HashMap makeSuitMap() {
        HashMap<Integer, String> valueMap = new HashMap<Integer, String>();
        valueMap.put(SUIT.CLUBS.ordinal(), "Clubs");
        valueMap.put(SUIT.SPADES.ordinal(), "Spades");
        valueMap.put(SUIT.HEARTS.ordinal(), "Hearts");
        valueMap.put(SUIT.DIAMONDS.ordinal(), "Diamonds");

        return valueMap;
    }

    public static HashMap makeCardMap() {
        HashMap<Integer, Integer> cardMap = new HashMap();
        cardMap.put(VALUE.TWO.getValue(), 0);
        cardMap.put(VALUE.THREE.getValue(), 0);
        cardMap.put(VALUE.FOUR.getValue(), 0);
        cardMap.put(VALUE.FIVE.getValue(), 0);
        cardMap.put(VALUE.SIX.getValue(), 0);
        cardMap.put(VALUE.SEVEN.getValue(), 0);
        cardMap.put(VALUE.EIGHT.getValue(), 0);
        cardMap.put(VALUE.NINE.getValue(), 0);
        cardMap.put(VALUE.TEN.getValue(), 0);
        cardMap.put(VALUE.JACK.getValue(), 0);
        cardMap.put(VALUE.QUEEN.getValue(), 0);
        cardMap.put(VALUE.KING.getValue(), 0);
        cardMap.put(VALUE.ACE.getValue(), 0);

        return cardMap;
    }

    public static HashMap makeHandRankMap() {

        /*HIGH_CARD, ONE_PAIR, TWO_PAIR, THREE_OF_A_KIND, STRAIGHT, FLUSH, FULL_HOUSE, FOUR_OF_A_KIND, STRAIGHT_FLUSH, ROYAL_FLUSH;*/
        HashMap cardMap = new HashMap();
        cardMap.put(0, "High Card");
        cardMap.put(1, "One Pair");
        cardMap.put(2, "Two Pair");
        cardMap.put(3, "Three of a Kind");
        cardMap.put(4, "Straight");
        cardMap.put(5, "Flush");
        cardMap.put(6, "Full House");
        cardMap.put(7, "Four of a Kind");
        cardMap.put(8, "Straight Flush");
        cardMap.put(9, "Royal Flush");

        return cardMap;


    }
}

