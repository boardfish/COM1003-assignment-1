package assignment2017;
import assignment2017.codeprovided.Connect4GameState;
import assignment2017.codeprovided.Connect4Player;
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
            System.out.println(gs.getWinner());
            cdisplay.displayBoard();
            y.makeMove(gs);
            System.out.println(gs.getWinner());
        } while (!gs.gameOver());
        cdisplay.displayBoard();
        System.out.print("The winner is...");
        int winner = gs.getWinner();
        if (winner==Connect4GameState.RED) {
            System.out.println("Red!");
        }
        if (winner==Connect4GameState.YELLOW) {
            System.out.println("Yellow!");
        }
        if (winner==Connect4GameState.EMPTY) {
            System.out.println("well, nobody actually. It's a tie!");
        }
    }
}
