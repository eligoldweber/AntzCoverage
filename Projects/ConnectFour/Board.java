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
    private int[][] bb;
    public final static int GREEN = 1;
    public final static int BLUE = -1;
    private final static int CLEAR = 0;
    private int width;
    private int height;

    /**
     * Constructor for objects of class Board
     */
    public Board(int width, int height)
    {
        bb = new int[width][height];
        this.width = width;
        this.height = height;
        
        for (int i=0; i < width; i++) {
            for (int j=0; j < height; j++) {
                bb[i][j] = CLEAR;
            }
        }
    }
    
    public int highestOpenRow (int col)
    {
        int free = -1;
        int row = height-1;
        boolean holeFound = false;
        while (row >= 0) {
            if ((bb[col][row] == CLEAR) && (!holeFound)) {
                free = row;
                holeFound = true;
            }
            row--;
        }
        return free;
    }
    
    public void setDisk (int x, int y, int color)
    {
        bb[x][y] = color;
    }
    
    public void gameOver (int player)
    {
       boolean playerWon = false;
       int i = 0;
       int j = 0;
       while ((i < width) && (!playerWon)) {
           j = 0;
           while ((j < height) && (!playerWon)) {
               if (bb[i][j] == player) {
                   playerWon = foundFourFromEnd(i, j, player);
                }
                j++;
            }
            i++;
        }
        if (playerWon) {
            System.out.print("Player " );
            if (player == GREEN) {
                System.out.print("GREEN");
            } else {
                System.out.print("BLUE");
            }
            System.out.println(" won!");
            Greenfoot.stop();
        }
    }

    private boolean foundFourFromEnd(int x, int y, int player)
    {
        boolean returnValue = (fourRight(x, y, player) || fourDown(x, y, player));
        returnValue = returnValue || fourDownRight(x, y, player);
        returnValue = returnValue || fourUpRight(x, y, player);
        return (returnValue);
    }
    
    private boolean fourRight(int x, int y, int player)
    {
        int score = 0;
        if (x <= (width-ConnectFourWorld.GOAL)) {
            for (int i=0; i < ConnectFourWorld.GOAL; i++) {
                score += bb[x+i][y];
            }
        }
        score = score * player;
        return (score == ConnectFourWorld.GOAL);
    }
    
    private boolean fourDown(int x, int y, int player)
    {
        int score = 0;
        if (y <= (height-ConnectFourWorld.GOAL)) {
            for (int i=0; i < ConnectFourWorld.GOAL; i++) {
                score += bb[x][y+i];
            }
        }
        score = score * player;
        return (score == ConnectFourWorld.GOAL);
    }
    
    private boolean fourUpRight(int x, int y, int player)
    {
        int score = 0;
        if ((x <= (width-ConnectFourWorld.GOAL)) && (y >= (ConnectFourWorld.GOAL-1))) {
            for (int i=0; i < ConnectFourWorld.GOAL; i++) {
                score += bb[x+i][y-i];
            }
        }
        score = score * player;
        return (score == ConnectFourWorld.GOAL);
    }
    
    private boolean fourDownRight(int x, int y, int player) 
    {
        int score = 0;
        if ((y <= (height-ConnectFourWorld.GOAL)) && (x <= (width-ConnectFourWorld.GOAL))) {
            for (int i=0; i < ConnectFourWorld.GOAL; i++) {
                score += bb[x+i][y+i];
            }
        }
        score = score * player;
        return (score == ConnectFourWorld.GOAL);
    }
            
}
