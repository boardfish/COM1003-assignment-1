package assignment2017;

import assignment2017.codeprovided.Connect4Displayable;
import assignment2017.codeprovided.Connect4GameState;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.*;

/** A command line display of a given state of a Connect 4 board.
 * @author Simon Fish
 *
 */
public class Connect4GraphicalDisplay extends JFrame implements Connect4Displayable {
protected Connect4GameState gS;

/**
 * @param gameState A given game state that will be displayed.
 */
public Connect4GraphicalDisplay(Connect4GameState gameState) {
        // TODO Auto-generated constructor stub
        gS = gameState;
        setTitle("Connect 4");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenDimensions = toolkit.getScreenSize();
        setSize(screenDimensions.width/2, screenDimensions.height/2);
        setLocation(new Point(screenDimensions.width/4, screenDimensions.height/4));
        
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        //Dropdown - Player 1
        //Dropdown - Player 2
        contentPane.add(new JButton("Start"), BorderLayout.WEST);
        //Text box
        contentPane.add(new JButton("Exit"), BorderLayout.WEST);
        //FlowLayout inside the bottom bit?
        for (int i=0; i<gS.NUM_COLS; i++) {
        	contentPane.add(new JButton(String.valueOf(i)));
        }
}
/* Displays the board.
 * @see assignment2017.codeprovided.Connect4Displayable#displayBoard()
 */
@Override
public void displayBoard() {
        for (int i= Connect4GameState.NUM_ROWS-1; i>=0; i--) {
                System.out.print("|");
                for (int j=0; j<Connect4GameState.NUM_COLS; j++) {
                        char counter;
                        switch (gS.getCounterAt(j, i)) {
                        case 0:
                                counter = 'R';
                                break;
                        case 1:
                                counter = 'Y';
                                break;
                        default:
                                counter = 'X';
                                break;
                        }
                        System.out.print(" "+counter+" ");
                }
                System.out.println("|");
        }
        System.out.print("|");
        for (int i = 0; i < Connect4GameState.NUM_COLS; i++) {
                System.out.print(" " + i + " ");
        }
        System.out.println("|");
}

public static void main(String[] args) {
	Connect4GraphicalDisplay connect4GraphicalDisplay = new Connect4GraphicalDisplay(null); //??
	connect4GraphicalDisplay.setVisible(true);
}
}
