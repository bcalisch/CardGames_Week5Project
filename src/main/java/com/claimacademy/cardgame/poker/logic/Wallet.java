package com.claimacademy.cardgame.poker.logic;

import java.text.NumberFormat;

/**
 * Wallet will hold a player's cash
 */
public class Wallet {
    private double cash;
    private static NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

    public Wallet(){};
    public Wallet(double cash){
        this.cash = cash;
    }

    public void printWallet(){
        System.out.println("You currently have "+ currencyFormat.format(cash));
    }
    public void removeCash(double amount){
        cash -= amount;

        //System.out.println("You started with : "+ cash);

    }
    public void addCash(double amount){
        cash+=amount;
    }
    public double getCash(){
        return cash;
    }
}
