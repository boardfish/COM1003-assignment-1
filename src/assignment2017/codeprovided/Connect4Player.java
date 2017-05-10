package assignment2017.codeprovided;

import assignment2017.Connect4GraphicalDisplay;

public abstract class Connect4Player {

	public int col;

	/**
	 * Decides which column in which to move, and then calls move on the gameState instance
	 * in order to make the move.  The method is free to query gameState (i.e. through the
	 * getCounterAt method in order to decide which move to make)
	 * @param gameState the current Connect4 game state
	 */
	public abstract void makeMove(Connect4GameState gameState);

	public abstract void makeMove(Connect4GameState gS, Connect4GraphicalDisplay currentDisplay);
}
