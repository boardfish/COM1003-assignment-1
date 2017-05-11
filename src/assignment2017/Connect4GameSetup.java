package assignment2017;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

import assignment2017.codeprovided.Connect4Player;

public class Connect4GameSetup extends JFrame {
	public Container contentPane = getContentPane();
	public final String[] playerOptions = { "Player", "CPU (Easy)" };
	public JPanel gameSetupPanel = new JPanel(new GridLayout(0,1));
	
    JComboBox selectorPlayer1 = new JComboBox(playerOptions);
    JComboBox selectorPlayer2 = new JComboBox(playerOptions);
    JButton buttonStart = new JButton("Start");
    JButton buttonExit = new JButton("Exit");    
    Connect4Player r;
    Connect4Player y;
    Connect4Player[] players = new Connect4Player[2];
    
	public Connect4GameSetup() {
		// TODO Auto-generated constructor stub
		players[0] = r;
		players[1] = y;
		selectorPlayer1.setSelectedIndex(0);
		selectorPlayer2.setSelectedIndex(1);
		buttonStart.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		int[] playerselection = new int[2];
	    		Connect4Player[] playerslot = new Connect4Player[2];
	    		playerselection[0] = selectorPlayer1.getSelectedIndex();
	    		playerselection[1] = selectorPlayer2.getSelectedIndex();
	    		for (int i = 0; i<playerselection.length; i++) {
	    			switch (playerselection[i]) {
	    			case 1:
	    				playerslot[i] = new RandomPlayer();
	    				break;
	    			default:
	    				playerslot[i] = new KeyboardPlayer();
	    				break;
	    			}
	    		}
	    		dispose();
	    		PlayConnect4 game = new PlayConnect4(playerslot);
	    		String[] gameArgs = {"-g"};
	    		game.main(gameArgs);
	    	}
	    });
		buttonExit.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		System.exit(0);
	    	}
	    });
	    gameSetupPanel.add(selectorPlayer1);
	    gameSetupPanel.add(selectorPlayer2);
	    gameSetupPanel.add(buttonStart);
	    gameSetupPanel.add(buttonExit);
	    contentPane.add(gameSetupPanel);
	    this.setVisible(true);
	}
	
	public static void main(String[] args) {
	    //Connect4GraphicalDisplay connect4GraphicalDisplay = new Connect4GraphicalDisplay(gS);     //??
	    Connect4GameSetup c4gs = new Connect4GameSetup();
	    
	}

}
