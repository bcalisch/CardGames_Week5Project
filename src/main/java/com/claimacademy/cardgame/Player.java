package com.claimacademy.cardgame;

import com.claimacademy.cardgame.poker.logic.Wallet;

import java.text.NumberFormat;

/**
 * Created by benjamin on
 */
public class Player {
    private static NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
    private String name;
    private Wallet wallet = new Wallet();
    private Hand hand = new Hand();


    public Player(String name){
        this.name = name;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }

    public void printPlayer() {
        System.out.println(name+": " );
        System.out.println("Wallet: " + currencyFormat.format(wallet.getCash()));
        hand.printHand();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player pokerPlayer = (Player) o;

        return !(getHand() != null ? !getHand().equals(pokerPlayer.getHand()) : pokerPlayer.getHand() != null);

    }

    @Override
    public int hashCode() {
        return getHand() != null ? getHand().hashCode() : 0;
    }
}

