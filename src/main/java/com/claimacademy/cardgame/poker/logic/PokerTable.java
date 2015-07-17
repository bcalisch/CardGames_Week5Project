package com.claimacademy.cardgame.poker.logic;

import com.claimacademy.cardgame.Player;
import com.claimacademy.cardgame.Table;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by benjamin on 7/17/15.
 */
public class PokerTable extends Table {

    public PokerTable(){
        players = new ArrayList<Player>();
        winner = new ArrayList<Player>();
        foldedPlayers = new ArrayList<Player>();
    }

    @Override
    public void evaluateHands() {
        {
            winner.clear();
            for (Player player : players) {

                player.getHand().evaluateHand();
                player.printPlayer();
                System.out.println("\t\t\t\t\tPokerHand for "+ player.getName()+": " + player.getHand().printHandRank());
                System.out.println();
            }
            ArrayList<Player> copyPlayer = cloneArrayList(players);
            Collections.sort(copyPlayer, new PlayerComparator());
            winner = checkForTies(copyPlayer);

            distributePotToWinner();



        }
    }
}
