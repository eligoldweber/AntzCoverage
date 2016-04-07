import java.util.ArrayList;
import greenfoot.*;

/**
 * Write a description of class Board here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Board  
{
    // instance variables - replace the example below with your own
    private int size;
    private int [][] twoD;
    private static final int X = 1;
    private static final int O = -1;
    private static final int BLANK = 0;

    /**
     * Constructor for objects of class Board
     */
    public Board(int dimension)
    {
        size = dimension;
        twoD = new int[size][size];
        
        for (int i=0; i < size; i++) {
            for (int j=0; j < size; j++) {
                twoD[i][j] = BLANK;
            }
        }
    }
    
    public void playerMove (int myX, int myY) {
        twoD[myX][myY] = X;
    }
    
    public Location agentMove () {
        ArrayList <Location> choice = new ArrayList<Location>();
        for (int i=0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (twoD[i][j] == BLANK) {
                    Location newbie = new Location (i, j);
                    choice.add (newbie);
                }
            }
        }
        int pick = Greenfoot.getRandomNumber (choice.size());
        Location winner = choice.get(pick);
        twoD[winner.getX()][winner.getY()] = O;
        return winner;
    }
    
    public boolean isGameOver () {
        boolean done = horizontalWin() || verticalWin() || diagonalWin();
        if (!done) {
            done = catsGame();
        }
        return done;
    }
    
    public boolean blankClicked(int theX, int theY) {
        return (twoD[theX][theY] == BLANK);
    }
    
    private boolean catsGame() {
        int count = 0;
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (twoD[x][y] == BLANK) {count++;}
            }
        }
        return (count == 0);
    }

    private boolean diagonalWin () {
        boolean winFound = false;
        int diagonalSum = 0;
        for (int i = 0; i < size; i++) {
            diagonalSum = diagonalSum + twoD[i][i];
        }
        winFound = ((diagonalSum == size) || (diagonalSum == -size));
        
        diagonalSum = 0;
        for (int i = 0; i < size; i++) {
            diagonalSum = diagonalSum + twoD[size-1-i][i];
        }
        winFound = (winFound || (diagonalSum == size) || (diagonalSum == -size));
        return(winFound);
    }
        
        
    private boolean horizontalWin() {
        boolean winFound = false;
        for (int col = 0; col < size; col++) {
            int rowSum = 0;
            for (int row = 0; row < size; row++) {
                rowSum = rowSum + twoD[row][col];
            }
            if ((rowSum == size) || (rowSum == -size)) {
                winFound = true;
            }
        }
        return (winFound);
    }
    
    private boolean verticalWin() {
        boolean winFound = false;
        for (int row = 0; row < size; row++) {
            int colSum = 0;
            for (int col = 0; col < size; col++) {
                colSum = colSum + twoD[row][col];
            }
            if ((colSum == size) || (colSum == -size)) {
                winFound = true;
            }
        }
        return (winFound);
    }
    
   
}
