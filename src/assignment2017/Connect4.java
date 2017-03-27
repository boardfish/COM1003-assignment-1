package assignment2017;
import assignment2017.codeprovided.Connect4GameState;
import assignment2017.codeprovided.Connect4Player;
public class Connect4 {

Connect4GameState gS;
Connect4Player r;
Connect4Player y;
Connect4ConsoleDisplay consoleDisplay;
public Connect4(Connect4GameState gameState, Connect4Player red, Connect4Player yellow, Connect4ConsoleDisplay display) {
        // TODO Auto-generated constructor stub
        gS = gameState;
        r = red;
        y = yellow;
        consoleDisplay = display;
}

public void play() {
        // TODO Auto-generated method stub
        do {
                consoleDisplay.displayBoard();
                r.makeMove(gS);
                consoleDisplay.displayBoard();
                y.makeMove(gS);
        } while (!gS.gameOver());
        consoleDisplay.displayBoard();
        System.out.print("The winner is...");
        int winner = gS.getWinner();
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
