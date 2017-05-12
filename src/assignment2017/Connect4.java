package assignment2017;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import assignment2017.codeprovided.Connect4Displayable;
import assignment2017.codeprovided.Connect4GameState;
import assignment2017.codeprovided.Connect4Player;
public class Connect4 {

MyGameState gS;
Connect4Player r;
Connect4Player y;
Connect4ConsoleDisplay consoleDisplay;
Connect4GraphicalDisplay graphicalDisplay;
ArrayList<Connect4Displayable> inputs = new ArrayList<>();
boolean[] turns = {false, false};
Connect4Player[] players = new Connect4Player[2];
Connect4Player player;
/**
 * @param gameState A given initial gamestate.
 * @param red A Connect4 player to be the first player.
 * @param yellow A Connect4 player to be the second player.
 * @param display A display interface for the game.
 */
public Connect4(MyGameState gameState, Connect4Player red, Connect4Player yellow, Connect4ConsoleDisplay display, Connect4GraphicalDisplay display2) {
        gS = gameState;
        r = red;
        y = yellow;
        consoleDisplay = display;
        graphicalDisplay = display2;
        inputs.add(consoleDisplay);
        inputs.add(graphicalDisplay);
        players[0] = r;
        players[1] = y;
        player = r;
}

/** Initialises the main loop of the game.
 * 
 */
public void play(int input) {
        // TODO Auto-generated method stub
		Connect4Displayable currentDisplay = inputs.get(input);
		if (currentDisplay instanceof Connect4GraphicalDisplay) {
			graphicalDisplay.pack();
			graphicalDisplay.setVisible(true);
		}
        do {
        		MyGameState previousState = gS.copy();
        		player = players[gS.whoseTurn()];
        		while (gS.compareStates(previousState)) {
                if (currentDisplay instanceof Connect4ConsoleDisplay) {
                  	player.makeMove(gS);
                } else {
                   	player.makeMove(gS, graphicalDisplay);
                }
                gS.getWinner();
        		}
        		currentDisplay.displayBoard();
        		//Killfeed Append
        		graphicalDisplay.killfeed.append("Player ");
                switch(gS.whoseTurn()) {
                case 0:
                	graphicalDisplay.killfeed.append("RED ");
                	break;
                case 1:
                	graphicalDisplay.killfeed.append("YELLOW ");
                	break;
                }
        		graphicalDisplay.killfeed.append("placed a counter in column ");
               	graphicalDisplay.killfeed.append(String.valueOf(player.col) + "\n");
        } while (!gS.gameOver());
        currentDisplay.displayBoard();
        System.out.print("The winner is...");
        int winner = gS.getWinner();
        if (winner==Connect4GameState.RED) {
                System.out.println("Red!");
        }
        if (winner==Connect4GameState.YELLOW) {
                System.out.println("Yellow!");
        }
        if (winner==Connect4GameState.EMPTY) {
                System.out.println("well, nobody actually. It's a tie!");
        }
        System.exit(0);
}

public void actionPerformed(ActionEvent e) {
    int col = Integer.valueOf(e.getActionCommand());
    if (players[gS.whoseTurn()] instanceof KeyboardPlayer) {
    	turns[gS.whoseTurn()] = true;
    }
}

public void setRed(Connect4Player p) {
	r = p;
	players[0] = r;
}

public void setYellow(Connect4Player p) {
	y = p;
	players[1] = y;
}

}
