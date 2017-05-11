package assignment2017;

import assignment2017.codeprovided.ColumnFullException;
import assignment2017.codeprovided.Connect4Displayable;
import assignment2017.codeprovided.Connect4GameState;
import assignment2017.codeprovided.Connect4Player;
import assignment2017.codeprovided.IllegalColumnException;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;

import javax.swing.*;

/** A command line display of a given state of a Connect 4 board.
 * @author Simon Fish
 *
 */
public class Connect4GraphicalDisplay extends JFrame implements Connect4Displayable, ActionListener {
public Connect4GameState gS;
public Toolkit toolkit = Toolkit.getDefaultToolkit();
public Dimension screenDimensions = toolkit.getScreenSize();
public Container contentPane = getContentPane();
public JPanel rowSelectorPanel = new JPanel(new FlowLayout());

public JPanel killfeedPanel = new JPanel(new GridLayout(0,1));
public JTextArea killfeed = new JTextArea();
public JScrollPane killfeedScroller = new JScrollPane(killfeed);

public final String[] playerOptions = { "Player", "CPU (Easy)" };
public JPanel gameSetupPanel = new JPanel(new GridLayout(0,1));
JComboBox selectorPlayer1 = new JComboBox(playerOptions);
JComboBox selectorPlayer2 = new JComboBox(playerOptions);
JButton buttonStart = new JButton("Start");
JButton buttonExit = new JButton("Exit");    

public GameBoardGUI gameBoardPanel = new GameBoardGUI();

/**
 * @param gameState A given game state that will be displayed.
 */
public Connect4GraphicalDisplay(Connect4GameState gameState) {
    // TODO Auto-generated constructor stub
    gS = gameState;
    setTitle("Connect 4");
    setSize(600, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(screenDimensions.width/2, screenDimensions.height/2);
    setLocation(new Point(screenDimensions.width/4, screenDimensions.height/4));
    JButton[] rowSelectorPanelButtons = new JButton[gS.NUM_COLS];
    for (int i=0; i<gS.NUM_COLS; i++) {
        rowSelectorPanelButtons[i] = new JButton(String.valueOf(i));
        rowSelectorPanelButtons[i].addActionListener(this);
    }
    for (int i=0; i<gS.NUM_COLS; i++) {
        rowSelectorPanel.add(rowSelectorPanelButtons[i]);
    }
    contentPane.setLayout(new BorderLayout());

    killfeed.setEditable(false);
    killfeedPanel.add(killfeedScroller);
    gameSetupPanel.add(selectorPlayer1);
    gameSetupPanel.add(selectorPlayer2);
    gameSetupPanel.add(buttonStart);
    buttonExit.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		System.exit(0);
    	}
    });
    gameSetupPanel.add(buttonExit);
    contentPane.add(killfeedPanel, BorderLayout.EAST);
    contentPane.add(rowSelectorPanel, BorderLayout.SOUTH);
    contentPane.add(gameBoardPanel, BorderLayout.CENTER);
    contentPane.add(gameSetupPanel, BorderLayout.WEST);
    pack();
}
/* Displays the board.
 * @see assignment2017.codeprovided.Connect4Displayable#displayBoard()
 */
@Override
public void displayBoard() {
	gameBoardPanel.repaint();
	
}

public void columnChosen(ActionEvent e) {
    if (Integer.valueOf(e.getActionCommand())<gS.NUM_COLS) {

    }
}

public static void main(String[] args) {
    //Connect4GraphicalDisplay connect4GraphicalDisplay = new Connect4GraphicalDisplay(gS);     //??
    
}
@Override
public void actionPerformed(ActionEvent e) {
    int col = Integer.valueOf(e.getActionCommand());
    try {
        gS.move(col);
    } catch (ColumnFullException cfe) {
        killfeed.append("That column is full! Try again!\n");
    } catch (IllegalColumnException ice) {
        killfeed.append("That column is illegal! Try again!\n");
    }
}

class Token {

private int xPos = 50;
private int yPos = 50;
private int width = 20;
private int height = 20;
private int player = -1;

public Token(int xpos, int ypos, int sidelength, int playerindex) {
    xPos = xpos;
    yPos = ypos;
    width = sidelength;
    height = sidelength;
    player = playerindex;
}

public void setX(int xPos){
    this.xPos = xPos;
}

public int getX(){
    return xPos;
}

public void setY(int yPos){
    this.yPos = yPos;
}

public int getY(){
    return yPos;
}

public int getWidth(){
    return width;
}

public int getHeight(){
    return height;
}
public void setPlayer(int player) {
    this.player = player;
}
public void paintSquare(Graphics g){
    Color tokenColor;
    switch (player) {
    case 0:
        tokenColor = Color.RED;
    break;
    case 1:
        tokenColor = Color.YELLOW;
    break;
    default:
        tokenColor = Color.DARK_GRAY;
    }
    g.setColor(tokenColor);
    g.fillRect(xPos,yPos,width,height);
    g.setColor(Color.BLACK);
    g.drawRect(xPos,yPos,width,height);
}
}

class GameBoardGUI extends JPanel {

private int boardX = 50;
private int boardY = 50;
private int boardW = 300;
private int boardH = 250;
private int tokenW = (int) ((boardW/Connect4GameState.NUM_COLS)*0.8);     //Get actual value!
private int tokenH = tokenW;
private int padding = tokenW/8;
private Token[][] board = new Token[Connect4GameState.NUM_ROWS][Connect4GameState.NUM_COLS];

public GameBoardGUI() {
    setBorder(BorderFactory.createLineBorder(Color.RED));
}

/*    public Dimension getPreferredSize() {
        return new Dimension(250,250);
    }
 */
public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.BLACK);
    g.fillRect(boardX,boardY,boardW,boardH);
    //for row/column, paint a new token with offset
    // Draw Text
    for (int i = 0; i<Connect4GameState.NUM_ROWS; i++) {
        for (int j = 0; j<Connect4GameState.NUM_COLS; j++) {
            board[i][j] = new Token(50+(j*(tokenW+(padding*2))), (50+(i*(tokenH+(padding*2)))), tokenW, gS.getCounterAt(j, Connect4GameState.NUM_ROWS-i-1));
            board[i][j].paintSquare(g);
        }
    }
}
}

}
