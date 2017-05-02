package assignment2017;
import java.util.ArrayList;

import assignment2017.codeprovided.Connect4Displayable;
import assignment2017.codeprovided.Connect4GameState;
import assignment2017.codeprovided.Connect4Player;
public class Connect4 {

Connect4GameState gS;
Connect4Player r;
Connect4Player y;
Connect4ConsoleDisplay consoleDisplay;
Connect4GraphicalDisplay graphicalDisplay;
ArrayList<Connect4Displayable> inputs;
/**
 * @param gameState A given initial gamestate.
 * @param red A Connect4 player to be the first player.
 * @param yellow A Connect4 player to be the second player.
 * @param display A display interface for the game.
 */
public Connect4(Connect4GameState gameState, Connect4Player red, Connect4Player yellow, Connect4ConsoleDisplay display, Connect4GraphicalDisplay display2) {
        gS = gameState;
        r = red;
        y = yellow;
        consoleDisplay = display;
        graphicalDisplay = display2;
        inputs.add(consoleDisplay);
        inputs.add(graphicalDisplay);
}

/** Initialises the main loop of the game.
 * 
 */
public void play(int input) {
        // TODO Auto-generated method stub
        do {
                inputs.get(input).displayBoard();
                r.makeMove(gS);
                gS.getWinner();
                consoleDisplay.displayBoard();
                y.makeMove(gS);
                gS.getWinner();
        } while (!gS.gameOver());
        consoleDisplay.displayBoard();
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
}
}
