package assignment2017.codeprovided;

import assignment2017.*;

public class PlayConnect4 {
	
	public static Connect4GameState gameState = new MyGameState();

	public PlayConnect4() {
		//empty
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connect4GameState gameState = new MyGameState();
		Connect4Player red = new RandomPlayer();
		Connect4Player yellow = new KeyboardPlayer();
		Connect4ConsoleDisplay display = new Connect4ConsoleDisplay(gameState);
		Connect4 game = new Connect4(gameState, red, yellow, display);
		gameState.startGame();
		game.play();
	}

}
