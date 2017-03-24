package assignment2017.codeprovided;
import assignment2017.*;
public class Connect4 {
	
	Connect4GameState gs;
	Connect4Player r;
	Connect4Player y;
	Connect4ConsoleDisplay cdisplay;
	public Connect4(Connect4GameState gameState, Connect4Player red, Connect4Player yellow, Connect4ConsoleDisplay display) {
		// TODO Auto-generated constructor stub
		gs = gameState;
		r = red;
		y = yellow;
		cdisplay = display;	
	}

	public void play() {
		// TODO Auto-generated method stub
		do {
			cdisplay.displayBoard();
			r.makeMove(gs);
			cdisplay.displayBoard();
			y.makeMove(gs);
		} while (!gs.gameOver());
	}

}
