package com.claimacademy.cardgame.poker.ui;

import com.claimacademy.cardgame.poker.logic.Player;

import com.claimacademy.cardgame.poker.logic.Table;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

/**
 * Created by benjamin on 7/15/15.
 */
public class PokerPlay {
    Table table = new Table();
    private JFrame frame;
    private NumberFormat currencyFormat =  NumberFormat.getCurrencyInstance();
    private JPanel playPokerMain;
    private JTextArea playerTextArea;
    private JButton startGameButton;
    private JButton exitButton;
    private JPanel optionPanel;
    private JLabel optionLabel;
    private JSlider betSlider;
    private JPanel computerOnePanel;
    private JPanel computerFivePanel;
    private JTextArea computerFiveTextArea;
    private JPanel computerThreePanel;
    private JTextArea computerThreeTextArea;
    private JPanel playerPanel;
    private JPanel computerTwoPanel;
    private JTextArea computerTwoTextArea;
    private JPanel computerFourPanel;
    private JTextArea computerFourTextArea;
    private JTextArea computerOneTextArea;
    private JLabel playerCard1;
    private JLabel playerCard2;
    private JLabel playerCard3;
    private JLabel playerCard4;
    private JLabel playerCard5;
    private JLabel comTwoCard1;
    private JLabel comTwoCard2;
    private JLabel comTwoCard3;
    private JLabel comTwoCard4;
    private JLabel comTwoCard5;
    private JLabel comOneCard1;
    private JLabel comOneCard2;
    private JLabel comOneCard3;
    private JLabel comOneCard4;
    private JLabel comOneCard5;
    private JLabel comThreeCard1;
    private JLabel comThreeCard2;
    private JLabel comThreeCard3;
    private JLabel comThreeCard4;
    private JLabel comThreeCard5;
    private JLabel comFourCard1;
    private JLabel comFourCard2;
    private JLabel comFourCard3;
    private JLabel comFourCard4;
    private JLabel comFiveCard1;
    private JLabel comFiveCard2;
    private JLabel comFiveCard3;
    private JLabel comFiveCard4;
    private JLabel comFiveCard5;
    private JLabel comFourCard5;
    private JButton betButton;
    private JButton foldButton;
    private JLabel potLabel;
    private JLabel betMinLabel;
    private JLabel betMaxLabel;
    private JLabel anteLabel;

    public PokerPlay() {
        startGameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                table.dealHands(5);
                table.getPlayers().get(0).getHand().evaluateHand();
                table.placeBets(table.getAnte());
                potLabel.setText(currencyFormat.format(table.getPot()));
                anteLabel.setText(currencyFormat.format(table.getAnte()));
                playerTextArea.setText(playerStringBuilder(table.getPlayers().get(0)).toString());

                playerTextArea.append(table.getPlayers().get(0).getHand().getHandRankString()+"\n");
                setCards();
                betSlider.setVisible(true);
                betSlider.setMinimum((int)table.getAnte());
                betSlider.setMaximum((int) table.getPlayers().get(0).getWallet().getCash());
                betButton.setVisible(true);
                foldButton.setVisible(true);
                betMinLabel.setVisible(true);
                betMaxLabel.setVisible(true);


                startGameButton.setVisible(false);
                for (int i = 1; i <table.getPlayers().size() ; i++) {
                    if(i==1){
                        computerOneTextArea.setText(computerStringBuilder(table.getPlayers().get(i)).toString());

                    }else if(i==2){
                        computerTwoTextArea.setText(computerStringBuilder(table.getPlayers().get(i)).toString());

                    }else if(i==3){
                        computerThreeTextArea.setText(computerStringBuilder(table.getPlayers().get(i)).toString());

                    }else if(i==4){
                        computerFourTextArea.setText(computerStringBuilder(table.getPlayers().get(i)).toString());

                    }else if(i==5){
                        computerFiveTextArea.setText(computerStringBuilder(table.getPlayers().get(i)).toString());

                    }
                }

                betMinLabel.setText(currencyFormat.format(table.getAnte()));
                betMaxLabel.setText(currencyFormat.format(table.getPlayers().get(0).getWallet().getCash()));

            }
        });

        betSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                betButton.setText("Bet " + currencyFormat.format(betSlider.getValue()));
            }
        });
        betButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int betToPlace = betSlider.getValue();
                for(Player player : table.getPlayers()){
                    if(player.getWallet().getCash() < betToPlace){
                        table.getFoldedPlayers().add(player);

                    }
                    else{
                        player.getWallet().removeCash(betToPlace);
                        table.addPot(betToPlace);
                        potLabel.setText(currencyFormat.format(table.getPot()));
                    }
                }
                finishGame();

            }
        });
        foldButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                table.getFoldedPlayers().add(table.getPlayers().get(0));
                finishGame();
            }
        });
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }

    private void finishGame() {
        table.evaluateHands();
        refreshTextArea(table);
        betButton.setVisible(false);
        betSlider.setVisible(false);
        betMaxLabel.setVisible(false);
        betMinLabel.setVisible(false);
        foldButton.setVisible(false);
        if(table.getPlayers().get(0).getWallet().getCash()>=table.getAnte()) {
            startGameButton.setVisible(true);
        }
        else{
            playerTextArea.setText("GAME OVER!!!!");
        }
        table.cleanUp();

    }

    private void setComputerCardText(int computer) {
        Player player;
        switch(computer){
            case(1):{
                player = table.getPlayers().get(1);
                comOneCard1.setText(player.getHand().getCards().get(0).printCard());
                comOneCard2.setText(player.getHand().getCards().get(1).printCard());
                comOneCard3.setText(player.getHand().getCards().get(2).printCard());
                comOneCard4.setText(player.getHand().getCards().get(3).printCard());
                comOneCard5.setText(player.getHand().getCards().get(4).printCard());
                break;
            }
            case(2):{
                player = table.getPlayers().get(2);
                comTwoCard1.setText(player.getHand().getCards().get(0).printCard());
                comTwoCard2.setText(player.getHand().getCards().get(1).printCard());
                comTwoCard3.setText(player.getHand().getCards().get(2).printCard());
                comTwoCard4.setText(player.getHand().getCards().get(3).printCard());
                comTwoCard5.setText(player.getHand().getCards().get(4).printCard());
                break;
            }
            case(3):{
                player = table.getPlayers().get(3);
                comThreeCard1.setText(player.getHand().getCards().get(0).printCard());
                comThreeCard2.setText(player.getHand().getCards().get(1).printCard());
                comThreeCard3.setText(player.getHand().getCards().get(2).printCard());
                comThreeCard4.setText(player.getHand().getCards().get(3).printCard());
                comThreeCard5.setText(player.getHand().getCards().get(4).printCard());
                break;
            }
            case(4):{
                player = table.getPlayers().get(4);
                comFourCard1.setText(player.getHand().getCards().get(0).printCard());
                comFourCard2.setText(player.getHand().getCards().get(1).printCard());
                comFourCard3.setText(player.getHand().getCards().get(2).printCard());
                comFourCard4.setText(player.getHand().getCards().get(3).printCard());
                comFourCard5.setText(player.getHand().getCards().get(4).printCard());
                break;
            }
            case(5):{
                player = table.getPlayers().get(5);
                comFiveCard1.setText(player.getHand().getCards().get(0).printCard());
                comFiveCard2.setText(player.getHand().getCards().get(1).printCard());
                comFiveCard3.setText(player.getHand().getCards().get(2).printCard());
                comFiveCard4.setText(player.getHand().getCards().get(3).printCard());
                comFiveCard5.setText(player.getHand().getCards().get(4).printCard());
                break;
            }
        }
    }

    private void refreshTextArea(Table table) {
        int size = table.getPlayers().size();
        StringBuilder playerInfo = new StringBuilder();
        for (int i = 0; i <size; i++) {
            if (table.getFoldedPlayers().contains(table.getPlayers().get(i))){
                if(i==0){
                    playerTextArea.append("FOLDED!!!");
                }
                else if(i==1){
                    computerOneTextArea.append("FOLDED!!!");
                }
                else if (i==2){
                    computerTwoTextArea.append("FOLDED!!!");
                }
                else if (i==3){
                    computerThreeTextArea.append("\nFOLDED!!!\n");
                }
                else if(i==4){
                    computerFourTextArea.append("FOLDED!!!");
                }
                else if (i==5){
                    computerFiveTextArea.append("FOLDED!!!");
                }
            }
            else{
                playerInfo = playerStringBuilder(table.getPlayers().get(i));
                if (table.getPlayers().get(i).equals(table.getWinner().get(0))){
                    playerInfo.append("\nWINNER!!!\n");
                }
                if(i==0){
                    playerTextArea.setText(playerInfo.toString());
                }
                else if(i==1){
                    computerOneTextArea.setText(playerInfo.toString());
                    setComputerCardText(1);
                }
                else if (i==2){
                    computerTwoTextArea.setText(playerInfo.toString());
                    setComputerCardText(2);
                }
                else if (i==3){
                    computerThreeTextArea.setText(playerInfo.toString());
                    setComputerCardText(3);
                }
                else if(i==4){
                    computerFourTextArea.setText(playerInfo.toString());
                    setComputerCardText(4);
                }
                else if (i==5){
                    computerFiveTextArea.setText(playerInfo.toString());
                    setComputerCardText(5);
                }

            }
        }
    }

    private void setCards() {
        playerCard1.setText(table.getPlayers().get(0).getHand().getCards().get(0).printCard());
        playerCard2.setText(table.getPlayers().get(0).getHand().getCards().get(1).printCard());
        playerCard3.setText(table.getPlayers().get(0).getHand().getCards().get(2).printCard());
        playerCard4.setText(table.getPlayers().get(0).getHand().getCards().get(3).printCard());
        playerCard5.setText(table.getPlayers().get(0).getHand().getCards().get(4).printCard());

        for (int i = 1; i < table.getPlayers().size(); i++) {

            if(i==1){
                comOneCard1.setText("#####");
                comOneCard2.setText("#####");
                comOneCard3.setText("#####");
                comOneCard4.setText("#####");
                comOneCard5.setText("#####");
            }else if(i==2){
                comTwoCard1.setText("#####");
                comTwoCard2.setText("#####");
                comTwoCard3.setText("#####");
                comTwoCard4.setText("#####");
                comTwoCard5.setText("#####");
            }
            else if(i==3){
                comThreeCard1.setText("#####");
                comThreeCard2.setText("#####");
                comThreeCard3.setText("#####");
                comThreeCard4.setText("#####");
                comThreeCard5.setText("#####");
            }
            else if(i==4){
                comFourCard1.setText("#####");
                comFourCard2.setText("#####");
                comFourCard3.setText("#####");
                comFourCard4.setText("#####");
                comFourCard5.setText("#####");

            }
            else if (i ==5){
                comFiveCard1.setText("#####");
                comFiveCard2.setText("#####");
                comFiveCard3.setText("#####");
                comFiveCard4.setText("#####");
                comFiveCard5.setText("#####");
            }

        }
    }

    public JPanel getPanel1() {
        return playPokerMain;
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        //playPokerMain = new JPanel();
        //playerDisplayTable = new JTable();
        System.out.println("##### PokerPlay.createUIComponents");
    }

    public void setupTable(int startingWallet, String name, int numPlayers) {
        StringBuilder myString = new StringBuilder();
        int anteAmount = (int)(startingWallet*.05);
        table.setAnte(anteAmount);

        table.addPlayer(new Player(name));
        table.getPlayers().get(0).getWallet().addCash(startingWallet);
        addComputers(startingWallet, numPlayers);

        myString =  playerStringBuilder(table.getPlayers().get(0));


        frame = new JFrame("Play Poker!!!");
        frame.setContentPane(playPokerMain);
        frame.setSize(800, 600);
        frame.pack();
        frame.setVisible(true);
        playerTextArea.setText(myString.toString());


    }

    private StringBuilder computerStringBuilder(Player player) {

        StringBuilder myString = new StringBuilder();

        myString.append("Player: " + player.getName() + "\n");
        myString.append("Wallet: " + currencyFormat.format(player.getWallet().getCash())+"\n");
       // myString.append("Ante: " + currencyFormat.format(anteAmount)+"\n");
        return myString;
    }


    private void addComputers(int startingWallet, int numPlayers) {
        StringBuilder playerInfo = new StringBuilder();
        for (int i = 1; i <= numPlayers; i++) {
            table.addPlayer(new Player("Computer "+ i ));
            table.getPlayers().get(i).getWallet().addCash(startingWallet);
            playerInfo = playerStringBuilder(table.getPlayers().get(i));
            if(i ==1){
                computerOnePanel.setVisible(true);
                computerOneTextArea.setText(playerInfo.toString());
            }
            else if (i == 2){
                computerTwoPanel.setVisible(true);
                computerTwoTextArea.setText(playerInfo.toString());
            }
            else if(i == 3){
                computerThreePanel.setVisible(true);
                computerThreeTextArea.setText(playerInfo.toString());
            }
            else if(i == 4){
                computerFourPanel.setVisible(true);
                computerFourTextArea.setText(playerInfo.toString());
            }
            else if(i == 5){
                computerFivePanel.setVisible(true);
                computerFiveTextArea.setText(playerInfo.toString());
            }
        }
    }

    private StringBuilder playerStringBuilder(Player player) {
        StringBuilder playerInfo = new StringBuilder();

        playerInfo.append("Player: " + player.getName() + "\n");
        playerInfo.append("Wallet: " + currencyFormat.format(player.getWallet().getCash())+"\n");
        if(player.getHand().getCards().size() >0){
            playerInfo.append("Hand: " + player.getHand().printHandRank()+"\n");
        }

        return playerInfo;

    }
}
