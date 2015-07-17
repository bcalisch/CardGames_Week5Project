package com.claimacademy.cardgame.poker.logic;


import com.claimacademy.cardgame.Player;

/**
 * Created by benjamin on
 */
public class PokerPlayer extends Player {


    public PokerPlayer(String name) {
        super(name);
        hand = new PokerHand();

    }
}


