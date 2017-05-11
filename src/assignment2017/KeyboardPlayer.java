package assignment2017;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import assignment2017.codeprovided.Connect4Player;
import assignment2017.codeprovided.IllegalColumnException;
import assignment2017.codeprovided.ColumnFullException;
import assignment2017.codeprovided.Connect4Displayable;
import assignment2017.codeprovided.Connect4GameState;



public class KeyboardPlayer extends Connect4Player implements ActionListener {
Scanner cmd = new Scanner(System.in);
int col;
boolean moveExecuted = false;

public KeyboardPlayer() {}

/* Allows the user to make a move by way of terminal input.
 * @see assignment2017.codeprovided.Connect4Player#makeMove(assignment2017.codeprovided.Connect4GameState)
 */
@Override

public void actionPerformed(ActionEvent e) {
    col = Integer.valueOf(e.getActionCommand());
    moveExecuted = true;
}

public void makeMove(Connect4GameState gameState) {
        boolean moveExecuted = false;
        System.out.print("Choose a column [0-6]: ");
        int col = cmd.nextInt();
        do {
                try {
                        gameState.move(col);
                        moveExecuted = true;
                } catch (ColumnFullException cfe) {
                        System.out.println("That column is full! Try again!");
                } catch (IllegalColumnException ice) {
                        System.out.println("That column is illegal! Try again!");
                }
        } while (!moveExecuted);
}

public void makeMove(Connect4GameState gameState, Connect4GraphicalDisplay graphicalDisplay) {
    if (moveExecuted) {
            try {
                    gameState.move(col);
                    moveExecuted = true;
            } catch (ColumnFullException cfe) {
            		graphicalDisplay.killfeed.append("That column is full! Try again!\n");
            } catch (IllegalColumnException ice) {
            		graphicalDisplay.killfeed.append("That column is illegal! Try again!\n");
            }
            moveExecuted = false;
    }
}




}
