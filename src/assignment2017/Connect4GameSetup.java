package assignment2017;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

import assignment2017.codeprovided.Connect4Player;

public class Connect4GameSetup extends JFrame implements ActionListener {
	public Container contentPane = getContentPane();
	public final String[] playerOptions = { "Player", "CPU (Easy)" };
	public JPanel gameSetupPanel = new JPanel(new GridLayout(0,1));
	
    JComboBox player1Selector = new JComboBox(playerOptions);
    JComboBox player2Selector = new JComboBox(playerOptions);
    
    Connect4Player r;
    Connect4Player y;
    Connect4Player[] players = new Connect4Player[2];
    
	public Connect4GameSetup() {
		// TODO Auto-generated constructor stub
		player1Selector.setSelectedIndex(0);
	    player2Selector.setSelectedIndex(1);
	    player1Selector.addActionListener(this);
	    gameSetupPanel.add(player1Selector);
	    gameSetupPanel.add(player2Selector);
	    gameSetupPanel.add(new JButton("Start"));
	    gameSetupPanel.add(new JButton("Exit"));
	    contentPane.add(gameSetupPanel);
	    this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		int player1 = player1Selector.getSelectedIndex();
		System.out.println(player1);
	}
	
	public static void main(String[] args) {
	    //Connect4GraphicalDisplay connect4GraphicalDisplay = new Connect4GraphicalDisplay(gS);     //??
	    Connect4GameSetup c4gs = new Connect4GameSetup();
	    
	}

}
