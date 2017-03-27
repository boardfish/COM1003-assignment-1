package assignment2017;
import assignment2017.codeprovided.Connect4GameState;
import assignment2017.codeprovided.Connect4Player;

public class PlayConnect4 {
public static void main(String[] args) {
        Connect4GameState gameState = new MyGameState();
        gameState.startGame();
        Connect4Player red = new RandomPlayer();
        Connect4Player yellow = new KeyboardPlayer();
        Connect4ConsoleDisplay display = new Connect4ConsoleDisplay(gameState);
        Connect4 game = new Connect4(gameState, red, yellow, display);
        game.play();
}
}
