package assignment2017;

import java.util.Scanner;

import assignment2017.codeprovided.Connect4Player;
import assignment2017.codeprovided.IllegalColumnException;
import assignment2017.codeprovided.ColumnFullException;
import assignment2017.codeprovided.Connect4GameState;



public class KeyboardPlayer extends Connect4Player {
Scanner cmd = new Scanner(System.in);

public KeyboardPlayer() {
        // TODO Auto-generated constructor stub
}

@Override
public void makeMove(Connect4GameState gameState) {
        // TODO Auto-generated method stub
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
