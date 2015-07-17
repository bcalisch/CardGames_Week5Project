package com.claimacademy.cardgame.mainmenu.ui;

import com.claimacademy.cardgame.poker.ui.PokerSetup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by benjamin on 7/14/15.
 */
public class MainMenu extends Component{
    JFrame frame;
    private JButton pokerButton;
    private JButton blackJackButton;
    private JButton warButton;
    private JLabel welcomeLabel;
    private JPanel panel1;
    private JLabel gameChoiceLabel;
    private JPanel pokerPanel;
    //private JPanel pokerPanel = new PokerSetup();


    public void showMainMenu(){
         frame = new JFrame("JMSUtilForm");
               frame.setContentPane(new MainMenu().panel1);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setSize(800, 600);
                frame.setVisible(true);
    }
    public  MainMenu(){
//
        pokerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pokerPanel = new PokerSetup().getMainPanel();
                JFrame frame = new JFrame("Poker Configuration");
                frame.getContentPane().add(pokerPanel);
                frame.setSize(800, 600);
                frame.pack();
                frame.setVisible(true);


            }
        });
        warButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}
