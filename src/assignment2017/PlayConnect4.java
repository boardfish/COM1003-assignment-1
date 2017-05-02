package assignment2017;
import assignment2017.codeprovided.Connect4GameState;
import assignment2017.codeprovided.Connect4Player;

/** Initialiser for a test game of Connect 4 versus an opponent that
 ** makes its moves at random.
 * @author Simon Fish
 *
 */
public class PlayConnect4 {
public static void main(String[] args) {
        Connect4GameState gameState = new MyGameState();
        gameState.startGame();
        Connect4Player red = new RandomPlayer();
        Connect4Player yellow = new KeyboardPlayer();
        Connect4ConsoleDisplay display = new Connect4ConsoleDisplay(gameState);
        Connect4GraphicalDisplay display2 = new Connect4GraphicalDisplay(gameState);
        Connect4 game = new Connect4(gameState, red, yellow, display, display2);
        String displaySelection;
        if (args.length > 0) {
            displaySelection = args[0];
            if (displaySelection=="-gui") {
            	game.play(1);
            } else {
            	System.out.println("Usage: java PlayConnect4 [OPTION...]\n\n  -g, --gui     use Swing graphical user interface\n  -c, --no-gui  use command line display");
            	System.exit(0);
            }
        } else {
        	game.play(0);
        }
}
}
