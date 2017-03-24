package assignment2017;

import assignment2017.codeprovided.*;

public class MyGameState extends Connect4GameState {

    protected int currentTurn = RED;
    protected int[][] board = new int[NUM_ROWS][NUM_COLS];
    protected boolean[] columnsFull = new boolean[NUM_COLS];

    public MyGameState() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void startGame() {
        // Initialise empty board
        for (int i=0; i<NUM_ROWS; i++) {
            for (int j=0; j<NUM_COLS; j++) {
                board[i][j] = EMPTY;
            }
        }
        currentTurn = RED;
    }

    @Override
    public void move(int col) throws ColumnFullException, IllegalColumnException {
        // If column out of range, throw exception
        if (col<0 || col>=NUM_COLS) {
            throw new IllegalColumnException(col);
        }
        if (isColumnFull(col)) {
            throw new ColumnFullException(col);
        }
        for (int row=NUM_ROWS-1; row>=0; row--) {
            if (getCounterAt(col, row) == EMPTY) {
                board[row][col] = currentTurn;
                break;
            }
        }
        changeTurn();
    }

    @Override
    public int whoseTurn() {
        // TODO Auto-generated method stub
        return currentTurn;
    }

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

    @Override
    public int getCounterAt(int col, int row) throws IllegalColumnException, IllegalRowException {
        // Gets the value of the counter at the given location
        return board[row][col];
    }

    @Override
    public boolean isBoardFull() {
        // Checks if board is full per column
        for (int col=0; col<NUM_COLS; col++) {
            if (!isColumnFull(col)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isColumnFull(int col) throws IllegalColumnException {
        // Checks if given columns is full either from memory or by looping
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

    @Override
    public int getWinner() {
        // Horizontal check
        System.out.println("WINNER: ");
        Integer current, previous; //Integer used to allow null
        current = previous = null;
        for (int row=0; row < NUM_ROWS; row++) {
            current = previous = null;
            for (int col=0; col < NUM_COLS - 1 - NUM_IN_A_ROW_TO_WIN; col++) {
                currentcheck:
                for (int i=col; i<col+4; i++) {
                    previous = current;
                    current = getCounterAt(col, row);
                    if (previous!=current) {
                        break currentcheck;
                    }
                    if (i == col + 3) { //if it's the last iteration and they're still the same...
                        return current; //...then that's the winner.
                    }
                }
            }
            return EMPTY;
        }
        if (isBoardFull()) {
            return -1;
        }
        return -1;
    }

    @Override
    public boolean gameOver() {
        // Decides whether the game is now over based on the board state
        if (getWinner() != -1 || isBoardFull()) {
            return true;
        }
        return false;
    }

    @Override
    public Connect4GameState copy() {
        // TODO Auto-generated method stub
        return this;
    }
}
