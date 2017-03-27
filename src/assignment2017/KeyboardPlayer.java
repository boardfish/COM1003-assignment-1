package assignment2017;

import java.util.Scanner;

import assignment2017.codeprovided.Connect4Player;
import assignment2017.codeprovided.IllegalColumnException;
import assignment2017.codeprovided.ColumnFullException;
import assignment2017.codeprovided.Connect4GameState;



public class KeyboardPlayer extends Connect4Player {
Scanner cmd = new Scanner(System.in);

public KeyboardPlayer() {}

/* Allows the user to make a move by way of terminal input.
 * @see assignment2017.codeprovided.Connect4Player#makeMove(assignment2017.codeprovided.Connect4GameState)
 */
@Override
public void makeMove(Connect4GameState gameState) {
        boolean moveExecuted = false;
        do {
                System.out.print("Which column will you choose? [0-7]:"); //const
                int col = cmd.nextInt();
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


}
