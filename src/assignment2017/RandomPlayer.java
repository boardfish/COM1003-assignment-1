package assignment2017;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import assignment2017.codeprovided.ColumnFullException;
import assignment2017.codeprovided.Connect4GameState;
import assignment2017.codeprovided.Connect4Player;
import assignment2017.codeprovided.IllegalColumnException;


public class RandomPlayer extends Connect4Player {
    Scanner cmd = new Scanner(System.in);

    public RandomPlayer() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void makeMove(Connect4GameState gameState) {
        // TODO Auto-generated method stub
        System.out.print("Random Player chose: ");
        boolean moveExecuted = false;
        int col;
        do {
            col = ThreadLocalRandom.current().nextInt(0, 7 + 1);
            try {
                gameState.move(col);
                moveExecuted = true;
            } catch (ColumnFullException expected) {
            } catch (IllegalColumnException expected) {
            }
        } while (!moveExecuted);
        System.out.println(col);
    }

}
