package com.claimacademy.cardgame.poker.logic;

import com.claimacademy.cardgame.Player;

import java.util.Comparator;

/**
 * Created by benjamin on 7/11/15.
 */
public class PlayerComparator implements Comparator<Player> {

    public int compare(Player pokerPlayer1, Player pokerPlayer2) {
        if (((PokerHand)pokerPlayer1.getHand()).getHandRank() < ((PokerHand)pokerPlayer2.getHand()).getHandRank()) {
            return 1;
        }else if(((PokerHand)pokerPlayer1.getHand()).getHandRank() > ((PokerHand)pokerPlayer2.getHand()).getHandRank()) {
            return -1;
        }else {
            if (((PokerHand)pokerPlayer1.getHand()).getHighCard1() < ((PokerHand)pokerPlayer2.getHand()).getHighCard1()) {
                return 1;
            } else if (((PokerHand)pokerPlayer1.getHand()).getHighCard1() > ((PokerHand)pokerPlayer2.getHand()).getHighCard1()) {
                return -1;
            } else {
                if (((PokerHand)pokerPlayer1.getHand()).getHighCard2() < ((PokerHand)pokerPlayer2.getHand()).getHighCard2()) {
                    return 1;
                } else if (((PokerHand)pokerPlayer1.getHand()).getHighCard2() > ((PokerHand)pokerPlayer2.getHand()).getHighCard2()) {
                    return -1;
                }
                else {
                    if (((PokerHand)pokerPlayer1.getHand()).getHighCard3() < ((PokerHand)pokerPlayer2.getHand()).getHighCard3()) {
                        return 1;
                    } else if (((PokerHand)pokerPlayer1.getHand()).getHighCard3() > ((PokerHand)pokerPlayer2.getHand()).getHighCard3()) {
                        return -1;
                    }
                    else {
                        if (((PokerHand)pokerPlayer1.getHand()).getHighCard4() < ((PokerHand)pokerPlayer2.getHand()).getHighCard4()) {
                            return 1;
                        } else if (((PokerHand)pokerPlayer1.getHand()).getHighCard4() > ((PokerHand)pokerPlayer2.getHand()).getHighCard4()) {
                            return -1;
                        }
                        else {
                            if (((PokerHand)pokerPlayer1.getHand()).getHighCard5() < ((PokerHand)pokerPlayer2.getHand()).getHighCard5()) {
                                return 1;
                            } else if (((PokerHand)pokerPlayer1.getHand()).getHighCard5() > ((PokerHand)pokerPlayer2.getHand()).getHighCard5()) {
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