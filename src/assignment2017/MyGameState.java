package assignment2017;

import assignment2017.codeprovided.Connect4GameState;
import assignment2017.codeprovided.ColumnFullException;
import assignment2017.codeprovided.IllegalColumnException;
import assignment2017.codeprovided.IllegalRowException;

/** An implementation of the Connect4GameState abstract class.
 ** Provides standard functions for making moves and checking the board state. 
 * @author Simon Fish
 * @see assignment2017.codeprovided.Connect4GameState
 */
public class MyGameState extends Connect4GameState {

protected int currentTurn = RED;
protected int[][] board = new int[NUM_ROWS][NUM_COLS];
protected boolean[] columnsFull = new boolean[NUM_COLS];

public MyGameState() {}

public MyGameState(int[][] newBoard, int whoseTurn) {
    board = newBoard;
    currentTurn = whoseTurn;
}

/* Initialises an empty board.
 * @see assignment2017.codeprovided.Connect4GameState#startGame()
 */
@Override
public void startGame() {
        for (int i=0; i<NUM_ROWS; i++) {
                for (int j=0; j<NUM_COLS; j++) {
                        board[i][j] = EMPTY;
                }
        }
        currentTurn = RED;
}

/* Makes a move for the player whose turn it is, based on their prior input.
 * Is also able to handle exceptions created due to misinputs.
 * @see assignment2017.codeprovided.Connect4GameState#move(int)
 */
@Override
public void move(int col) throws ColumnFullException, IllegalColumnException {
        // If column out of range, throw exception
        if (col<0 || col>=NUM_COLS) {
                throw new IllegalColumnException(col);
        }
        if (isColumnFull(col)) {
                throw new ColumnFullException(col);
        }
        for (int row=0; row<NUM_ROWS; row++) {
                if (getCounterAt(col, row) == EMPTY) {
                        board[row][col] = currentTurn;
                        break;
                }
        }
        changeTurn();
}

/* Returns an integer value relating to whose turn it is - 0 for red, 1 for yellow.
 * @see assignment2017.codeprovided.Connect4GameState#whoseTurn()
 */
@Override
public int whoseTurn() {
        return currentTurn;
}

/** Method passed after a turn has successfully been taken to change hands.
 * There's probably a more codegolf-flavoured method to this, but I'm fine with a par.
 */
private void changeTurn() {
        switch (currentTurn) {
        case RED:
                currentTurn = YELLOW;
                break;
        case YELLOW:
                currentTurn = RED;
                break;
        }
}

/* Returns the counter at a given location.
 * @see assignment2017.codeprovided.Connect4GameState#getCounterAt(int, int)
 */
@Override
public int getCounterAt(int col, int row) throws IllegalColumnException, IllegalRowException {
        // Gets the value of the counter at the given location
        return board[row][col];
}

/* Checks if the entire board is full.
 * @see assignment2017.codeprovided.Connect4GameState#isBoardFull()
 */
@Override
public boolean isBoardFull() {
        for (int col=0; col<NUM_COLS; col++) {
                if (!isColumnFull(col)) {
                        return false;
                }
        }
        return true;
}

/* Checks if a single column is full. Remembers this if it is true.
 * @see assignment2017.codeprovided.Connect4GameState#isColumnFull(int)
 */
@Override
public boolean isColumnFull(int col) throws IllegalColumnException {
        // Checks if given column is full either from memory or by looping
        if (col<0 || col>=NUM_COLS) {
                throw new IllegalColumnException(col);
        }
        if (columnsFull[col]) {
                return columnsFull[col];
        }
        int currentPosition;
        for (int currentRow = 0; currentRow<NUM_ROWS; currentRow++) {
                currentPosition = getCounterAt(col, currentRow);
                if (currentPosition == EMPTY) {
                        return false;
                }
        }
        columnsFull[col] = true;
        return columnsFull[col];
}

/* Does all necessary checks to find out who the winner is, and returns the EMPTY value (-1) otherwise.
 * @see assignment2017.codeprovided.Connect4GameState#getWinner()
 */
@Override public int getWinner() {
        Integer current, previous;
        current = previous = null;
        // Horizontal check
        for (int row=0; row < NUM_ROWS; row++) {
                for (int col=0; col < NUM_COLS - 1 - NUM_IN_A_ROW_TO_WIN; col++) {
                        previous = getCounterAt(col, row);
                        for (int i=col; i<col+4; i++) {
                                current = getCounterAt(i, row);
                                if (previous!=current) {
                                        break;
                                }
                                if (i == col + 3 && current != EMPTY) {
                                        return current;
                                }
                                previous = current;
                        }
                }
        }
        // Vertical check
        current = previous = null;
        for (int col=0; col < NUM_COLS; col++) {
                for (int row=0; row <= NUM_ROWS - NUM_IN_A_ROW_TO_WIN; row++) {
                        previous = getCounterAt(col, row);
                        for (int i=row; i<row+4; i++) {
                                current = getCounterAt(col, i);
                                if (previous!=current) {
                                        break;
                                }
                                if (i == row + 3 && current != EMPTY) {
                                        return current;
                                }
                                previous = current;
                        }
                }
        }
        // Forward slash check
        for (int row=0; row < NUM_ROWS - NUM_IN_A_ROW_TO_WIN; row++) {
            for (int col=0; col < NUM_COLS - NUM_IN_A_ROW_TO_WIN; col++) {
                previous = getCounterAt(col, row);
                for (int y=col, x=row; x < row + NUM_IN_A_ROW_TO_WIN || y < col + NUM_IN_A_ROW_TO_WIN; y++, x++) {
                    current = getCounterAt(y, x);
                    if (previous!=current) {
                        break;
                    }
                    if (y == col + 3 && current != EMPTY) { 
                        return current; 
                    }
                    previous = current;
                }
            }
        }
     // Backward slash check
        for (int row=0; row <= NUM_ROWS - NUM_IN_A_ROW_TO_WIN; row++) {
            for (int col=0; col <= NUM_COLS - NUM_IN_A_ROW_TO_WIN; col++) {
                previous = getCounterAt(col, row+NUM_IN_A_ROW_TO_WIN - 1);
                for (int y=col,  x=row + NUM_IN_A_ROW_TO_WIN - 1; x >= row|| y < col + NUM_IN_A_ROW_TO_WIN ; y++, x--) {
                    current = getCounterAt(y, x);
                    if (previous!=current) {
                        break;
                    }
                    if (y == col + 3 && current != EMPTY) { 
                        return current;
                    }
                    previous = current;
                }
        }
        
        }
        return EMPTY;
}

/* Decides whether the game is now over based on the board state.
 * @see assignment2017.codeprovided.Connect4GameState#gameOver()
 */
@Override public boolean gameOver() {
        if (getWinner() != -1 || isBoardFull()) {
                return true;
        }
        return false;
}

/* Creates a deep copy of the board state.
 * @see assignment2017.codeprovided.Connect4GameState#copy()
 */
@Override public MyGameState copy() {
        int[][] newBoard = new int[NUM_ROWS][NUM_COLS];
        for (int i = 0; i<NUM_ROWS; i++) {
                newBoard[i] = board[i].clone();
        }
        return new MyGameState(newBoard, whoseTurn());
    }

	public boolean compareStates(MyGameState gamestate) {
        for (int i = 0; i<NUM_ROWS; i++) {
        	for (int j = 0; j<NUM_COLS; j++) {
                if (!(board[i][j] == gamestate.board[i][j])) {
                	return false;
                }	
        	}
        }
        return true;
	}
}
