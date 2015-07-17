package com.claimacademy.cardgame.poker.logic;
import java.util.Comparator;

/**
 * Created by benjamin on 7/11/15.
 */
public class PlayerComparator implements Comparator<Player> {

    public int compare(Player player1, Player player2) {
        if (player1.getHand().getHandRank() < player2.getHand().getHandRank()) {
            return 1;
        }else if(player1.getHand().getHandRank() > player2.getHand().getHandRank()) {
            return -1;
        }else {
            if (player1.getHand().getHighCard1() < player2.getHand().getHighCard1()) {
                return 1;
            } else if (player1.getHand().getHighCard1() > player2.getHand().getHighCard1()) {
                return -1;
            } else {
                if (player1.getHand().getHighCard2() < player2.getHand().getHighCard2()) {
                    return 1;
                } else if (player1.getHand().getHighCard2() > player2.getHand().getHighCard2()) {
                    return -1;
                }
                else {
                    if (player1.getHand().getHighCard3() < player2.getHand().getHighCard3()) {
                        return 1;
                    } else if (player1.getHand().getHighCard3() > player2.getHand().getHighCard3()) {
                        return -1;
                    }
                    else {
                        if (player1.getHand().getHighCard4() < player2.getHand().getHighCard4()) {
                            return 1;
                        } else if (player1.getHand().getHighCard4() > player2.getHand().getHighCard4()) {
                            return -1;
                        }
                        else {
                            if (player1.getHand().getHighCard5() < player2.getHand().getHighCard5()) {
                                return 1;
                            } else if (player1.getHand().getHighCard5() > player2.getHand().getHighCard5()) {
                                return -1;
                            }
                        }
                    }
                }
            }
        }

        return 1;
    }
}