package assignment2017;
import assignment2017.codeprovided.Connect4GameState;
import assignment2017.codeprovided.Connect4Player;

/** Initialiser for a test game of Connect 4 versus an opponent that
 ** makes its moves at random.
 * @author Simon Fish
 *
 */
public class PlayConnect4 {
	
		static Connect4Player red;
		static Connect4Player yellow;
	
public PlayConnect4(Connect4Player[] playerslot) {
			red = playerslot[0];
			yellow = playerslot[1];
		}

public static void main(String[] args) {
        MyGameState gameState = new MyGameState();
        gameState.startGame();
        Connect4ConsoleDisplay display = new Connect4ConsoleDisplay(gameState);
        Connect4GraphicalDisplay display2 = new Connect4GraphicalDisplay(gameState);
        System.out.println(red);
        System.out.println(yellow);
        if (red==null) {
        	red = new KeyboardPlayer();
        }
        if (yellow==null) {
        	yellow = new RandomPlayer();
        }
        Connect4 game = new Connect4(gameState, red, yellow, display, display2);
        String displaySelection;
        if (args.length > 0) {
            displaySelection = args[0];
            if (displaySelection.equals("--gui") || displaySelection.equals("-g")) {
            	game.play(1);
            } else {
            	System.out.println("Usage: java PlayConnect4 [OPTION...]\n\n"
            					  +"  -g, --gui     use Swing graphical user interface\n"
            			          +"  -c, --no-gui  use command line display (default)");
            	System.exit(0);
            }
        } else {
        	game.play(0);
        }
}
}
