package assignment2017;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import assignment2017.codeprovided.ColumnFullException;
import assignment2017.codeprovided.Connect4Displayable;
import assignment2017.codeprovided.Connect4GameState;
import assignment2017.codeprovided.Connect4Player;
import assignment2017.codeprovided.IllegalColumnException;


/** RandomPlayer - a Connect 4 Player that chooses at random as opposed to using a given algorithm.
 * @author Simon Fish
 *
 */
public class RandomPlayer extends Connect4Player {

Scanner cmd = new Scanner(System.in);
int col;

public RandomPlayer() {
}

/* Makes a move through the use of RNG.
 * @see assignment2017.codeprovided.Connect4Player#makeMove(assignment2017.codeprovided.Connect4GameState)
 */
@Override
public void makeMove(Connect4GameState gameState) {
    // TODO Auto-generated method stub
    System.out.print("Random Player chose: ");
    boolean moveExecuted = false;
    do {
        col = ThreadLocalRandom.current().nextInt(0, gameState.NUM_COLS + 1);
        try {
            gameState.move(col);
            moveExecuted = true;
        } catch (ColumnFullException expected) {
        } catch (IllegalColumnException expected) {
        }
    } while (!moveExecuted);
    System.out.println(col);
}

public void makeMove(Connect4GameState gameState, Connect4GraphicalDisplay graphicalDisplay) {
    // TODO Auto-generated method stub
    boolean moveExecuted = false;
    int col;
    do {
        col = ThreadLocalRandom.current().nextInt(0, gameState.NUM_COLS + 1);
        try {
            gameState.move(col);
            moveExecuted = true;
        } catch (ColumnFullException expected) {
        } catch (IllegalColumnException expected) {
        }
    } while (!moveExecuted);
}

}
