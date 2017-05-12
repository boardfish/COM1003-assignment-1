package assignment2017;

import assignment2017.codeprovided.Connect4Displayable;
import assignment2017.codeprovided.Connect4GameState;

/** A command line display of a given state of a Connect 4 board.
 * @author Simon Fish
 *
 */
public class Connect4ConsoleDisplay implements Connect4Displayable {
protected Connect4GameState gS;

/**
 * @param gameState A given game state that will be displayed.
 */
public Connect4ConsoleDisplay(Connect4GameState gameState) {
    // TODO Auto-generated constructor stub
    gS = gameState;
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
}
