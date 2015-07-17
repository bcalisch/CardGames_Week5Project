package com.claimacademy.cardgame.poker.ui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Enumeration;

/**
 * Created by benjamin
 */
public class PokerSetup extends JPanel{
    private NumberFormat currencyFormat =  NumberFormat.getCurrencyInstance();
    private JPanel pokerSetupPanel;
    private JPanel headerPanel;
    private JLabel headerLabel;
    private JPanel playerSetup;
    private JLabel chooseOpponentsLabel;
    private JRadioButton opponentRadio1;
    private JRadioButton opponentRadio2;
    private JRadioButton opponentRadio3;
    private JRadioButton opponentRadio4;
    private JRadioButton opponentRadio5;
    private JSlider initialMoneySlider;
    private JLabel initialMoneyLabel;
    private JPanel initialMoneyLabelPanel;
    private JLabel maxSliderLabel;
    private JLabel minSliderLabel;
    private JTextField nameTextBox;
    private JLabel nameLabel;
    private JButton pokerSubmitButton;
    private JPanel enterNamePanel;
    private JPanel sliderPanel;
    private JPanel radioPanel;
    private JPanel opponentPanelForLabel;
    private JLabel initialWalletSelection;
    private ButtonGroup opponentGroup;


    private JPanel playPokerPanel;

    private void createUIComponents() {
        // TODO: place custom component creation code here
        pokerSetupPanel = new JPanel();
        headerPanel = new JPanel();
        headerLabel = new JLabel();
        playerSetup = new JPanel();
        opponentGroup = new ButtonGroup();


    }

    public JPanel getMainPanel() {
        return pokerSetupPanel;
    }

    public PokerSetup(){

        initialMoneySlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                Integer number = initialMoneySlider.getValue();
                initialWalletSelection.setText(currencyFormat.format(number));
               // initialWalletSelection.setBackground(new Color(132,180,100));
            }
        });
        pokerSubmitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if(nameTextBox.getText().length() ==0){
                    nameLabel.setBackground(Color.red);

                }
                else{
                    nameLabel.setBackground(new Color(132,180,100));
                    PokerPlay pokerPlay = new PokerPlay();
                    makeRadioGroup();
                    String selected = new GroupButtonUtils().getSelectedButtonText(opponentGroup);
                    int selectedInt = Integer.parseInt(selected);
                    pokerPlay.setupTable(initialMoneySlider.getValue(), nameTextBox.getText(), selectedInt);


                }
            }
        });
    }

    private void makeRadioGroup() {
        opponentGroup.add(opponentRadio1);
        opponentGroup.add(opponentRadio2);
        opponentGroup.add(opponentRadio3);
        opponentGroup.add(opponentRadio4);
        opponentGroup.add(opponentRadio5);
    }

    public class GroupButtonUtils {

        public String getSelectedButtonText(ButtonGroup buttonGroup) {
            for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
                AbstractButton button = buttons.nextElement();

                if (button.isSelected()) {
                    return button.getText();
                }
            }

            return null;
        }
    }
}
