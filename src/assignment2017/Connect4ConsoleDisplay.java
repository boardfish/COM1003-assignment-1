package assignment2017;
import assignment2017.codeprovided.*;

public class Connect4ConsoleDisplay implements Connect4Displayable {
    protected Connect4GameState gS;

    public Connect4ConsoleDisplay(Connect4GameState gameState) {
        // TODO Auto-generated constructor stub
        gS = gameState;
    }
    @Override
    public void displayBoard() {
        for (int i=0;i<=Connect4GameState.NUM_ROWS;i++) {
            System.out.print("|");
            for (int j=0; j<Connect4GameState.NUM_COLS;j++) {
                char counter;
                if (i == Connect4GameState.NUM_ROWS) {
                    counter = (char) j;
                }
                else {
                    switch (gS.getCounterAt(j, i)) {
                    case 0:
                        counter = 'R';
                        break;
                    case 1:
                        counter = 'Y';
                        break;
                    default:
                        counter = 'X';
                        break;
                    }
                }
                System.out.print(" "+counter+" ");
            }
            System.out.println("|");
        }
    }
}
