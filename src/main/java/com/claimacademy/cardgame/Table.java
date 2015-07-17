package com.claimacademy.cardgame;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 */
public abstract class Table {
    protected ArrayList<Player> players;
    protected ArrayList<Player> foldedPlayers;
    protected ArrayList<Player> winner;
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
                System.out.println("PokerPlayer "+ player.getName() + " ran out of money and is out of the game!");
            }
        }

        winner.clear();
        foldedPlayers.clear();

    }

    public abstract void evaluateHands();


    protected void distributePotToWinner() {
        if(winner.size() ==1) {
            winner.get(0).getWallet().addCash(getPot());
            removePot(getPot());
        }else{
            System.out.println("We have a tie!");
            double splitPot = pot / winner.size();
            for(Player player : winner){
                System.out.println("PokerPlayer: " + player.getName());
                player.getWallet().addCash(splitPot);
                removePot(splitPot);
            }
        }
    }

    protected ArrayList<Player> checkForTies(ArrayList<Player> copyPlayer) {
        for(Player player : copyPlayer){
            if(player.equals(copyPlayer.get(0))){
                winner.add(player);
            }
        }
        return winner;
    }

    protected ArrayList<Player> cloneArrayList(ArrayList<Player> players) {
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

        for (Player pokerPlayer : players) {
            pokerPlayer.getWallet().removeCash(anteNum);
            addPot(anteNum);
        }
    }
}