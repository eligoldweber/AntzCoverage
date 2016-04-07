import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class ConnectFourWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ConnectFourWorld  extends World
{

    public static final int BOARDWIDTH = 7;
    public static final int BOARDHEIGHT = 6;
    public static final int GOAL = 4;
    public static final int CELLSIZE = 60;
    public static final int LEFTCLICK = 1;
    
    private Board theBoard;
    private BluePlayer blueGuy;
    
    /**
     * Constructor for objects of class ConnectFourWorld.
     * 
     */
    public ConnectFourWorld()
    {    
        // Create a new world with 20x20 cells with a cell size of 10x10 pixels.
        super(BOARDWIDTH, BOARDHEIGHT, CELLSIZE); 
        drawBackground(BOARDHEIGHT, BOARDWIDTH, CELLSIZE, Color.ORANGE, Color.BLACK);
        theBoard = new Board(BOARDWIDTH, BOARDHEIGHT);
        blueGuy = new BluePlayer();
    }
    
    public void act()
    {
        if ((Greenfoot.mouseClicked(this))) {
           MouseInfo mi = Greenfoot.getMouseInfo();
           if (mi.getButton() == LEFTCLICK) {
               int newX = mi.getX();
               int newY = mi.getY();
                
               placeGreenDisk(newX);
               blueGuy.placeBlueDisk(theBoard, this);
           }
        }
    }
    
           
    private void placeGreenDisk(int newX)
    {
        int newY = theBoard.highestOpenRow(newX);
        if (newY >= 0) {
            GreenDisk gg = new GreenDisk();
            addObject(gg, newX, newY);
            theBoard.setDisk(newX, newY, Board.GREEN);            
            theBoard.gameOver(Board.GREEN);
        }
    }

   /**
     * drawBackground - fill in the background color and fill in grid lines as well.
     * By making the grid lines the same as the bg color, one can "eliminate" grid lines
     *
     */
    private void drawBackground (int gridHeight, int gridWidth, int cellSize, Color bgColor, 
                                 Color lineColor) {
        GreenfootImage bg = getBackground ();
        bg.setColor(bgColor);
        bg.fill();
        //bg.setColor(Color.GREEN);
        //bg.fillRect(0, (gridHeight-1) * cellSize, gridWidth * cellSize, cellSize);
        bg.setColor(lineColor);
        for (int i=0; i < gridWidth; i++) {
            bg.drawLine(i * cellSize, 0, i * cellSize, gridHeight * cellSize);
        }
        for (int i=0; i < gridHeight; i++) {
            bg.drawLine(0, i * cellSize, gridWidth * cellSize, i * cellSize);
        }
    }

}
