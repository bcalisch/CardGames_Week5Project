package com.claimacademy.cardgame.poker.logic;


import com.claimacademy.cardgame.Card;
import com.claimacademy.cardgame.Deck;
import com.claimacademy.cardgame.CardHandler;


import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by benjamin on 7/7/15.
 */
public class Table {
    private static NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
    private ArrayList<Player> players = new ArrayList<Player>();
    private ArrayList<Player> foldedPlayers = new ArrayList<Player>();
    private ArrayList<Player> winner = new ArrayList<Player>();
    private Deck deck = new Deck();
    private double pot = 0.0;
    private double ante=0.0;

    public void addPlayer(Player player) {
        players.add(player);


    }

    public void dealHands(int numCards) {
        int totalCardsNeeded = players.size() * numCards;

        if (totalCardsNeeded <= deck.getDeck().size()) {
            Collections.shuffle(deck.getDeck());
            for (int i = 0; i < numCards; i++) {
                System.out.println();
                for (Player player : players) {
                    Card thisCard = deck.getDeck().get(0);
                    CardHandler.removeCard(deck.getDeck(), thisCard);
                    CardHandler.addCard(player.getHand().getCards(), thisCard);
                }
            }
        } else {
            System.out.println("There are not enough cards to handle this number of players.");
        }

        for (Player player : players) {
            player.getHand().sortCards();
        }
    }

    public void cleanUp() {
        for (Player player : players) {
            while (player.getHand().getCards().size() > 0) {
                Card thisCard = player.getHand().getCards().get(0);
                CardHandler.removeCard(player.getHand().getCards(), thisCard);
                CardHandler.addCard(deck.getDeck(), thisCard);
            }
        }
        Iterator<Player> playerIterator = players.iterator();
        while (playerIterator.hasNext()){
            Player player = playerIterator.next();
            if (player.getWallet().getCash() <= 0.0){
                playerIterator.remove();
                System.out.println("Player "+ player.getName() + " ran out of money and is out of the game!");
            }
        }

        winner.clear();
        foldedPlayers.clear();

    }

    public void evaluateHands() {
        winner.clear();
        for (Player player : players) {

            player.getHand().evaluateHand();
            player.printPlayer();
            System.out.println("\t\t\t\t\tHand for "+ player.getName()+": " + player.getHand().printHandRank());
            System.out.println();
        }
        ArrayList<Player> copyPlayer = cloneArrayList(players);
        Collections.sort(copyPlayer, new PlayerComparator());
        winner = checkForTies(copyPlayer);

        distributePotToWinner();



    }

    private void distributePotToWinner() {
        if(winner.size() ==1) {
           System.out.println("The winner is " + winner.get(0).getName() + " with a " + winner.get(0).getHand().getHandRankString() + ": " + winner.get(0).getHand().getHighCard1() + ": " + winner.get(0).getHand().getHighCard2());
            winner.get(0).getWallet().addCash(getPot());
            removePot(getPot());
        }else{
            System.out.println("We have a tie!");
            double splitPot = pot / winner.size();
            for(Player player : winner){
                System.out.println("Player: " + player.getName());
                player.getWallet().addCash(splitPot);
                removePot(splitPot);
            }
        }
    }

    private ArrayList<Player> checkForTies(ArrayList<Player> copyPlayer) {
        for(Player player : copyPlayer){
            if(player.equals(copyPlayer.get(0))){
                winner.add(player);
            }
        }
        return winner;
    }

    private ArrayList<Player> cloneArrayList(ArrayList<Player> players) {
        ArrayList<Player> tempArrayList = new ArrayList<Player>();
        for (Player player : players){

            if(!foldedPlayers.contains(player))
            tempArrayList.add(player);
        }

        return tempArrayList;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public double getPot() {
        return pot;
    }

    public void addPot(double pot) {
        this.pot += pot;
    }

    public void removePot(double pot) {
        if(this.pot <= pot){
            this.pot = 0;
        }else{
            this.pot -= pot;
        }

    }

    public double getAnte() {
        return ante;
    }

    public void setAnte(double ante) {
        this.ante = ante;
    }

    public ArrayList<Player> getFoldedPlayers() {
        return foldedPlayers;
    }

    public ArrayList<Player> getWinner() {
        return winner;
    }

    /**
     * Place Bets goes through each player and takes out the ante, and adds it to the pot.
     * @param anteNum: an int amount that will be bet each round.
     */
    public void placeBets(double anteNum) {

        for (Player player : players) {
            player.getWallet().removeCash(anteNum);
            addPot(anteNum);
        }
    }
}