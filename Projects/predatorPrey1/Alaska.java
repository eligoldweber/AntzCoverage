import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.awt.Color;

/**
 * Alaska - the base world for a predator-prey simulation
 * 
 * @author (mikeyg) 
 */
public class Alaska extends World
{
    // Some useful constants related to the size of the world
    private static final int PARKSIZE = 40;
    public static final int CELL_SIZE = 16;
    private static final int INITIALBEARCNT = 10;
    private static final int INITIALHARECNT = 20;
    private static final int INTITIALSHRUBCNT = 50;

    /**
     * Constructor for objects of class Alaska.
     * 
     */
    public Alaska()
    {    
        // Create a new world with 20x20 cells with a cell size of 10x10 pixels.
        super(PARKSIZE, PARKSIZE, CELL_SIZE);
        drawBackground(PARKSIZE, CELL_SIZE, Color.BLACK, Color.BLACK);
        
        populateBears(INITIALBEARCNT, CELL_SIZE);
        populateHares(INITIALHARECNT, CELL_SIZE);
        populateHareFood(INTITIALSHRUBCNT, CELL_SIZE);
    }


    /**
     * drawBackground - fill in the background color and fill in grid lines as well.
     * By making the grid lines the same as the bg color, one can "eliminate" grid lines
     *
     */
    private void drawBackground (int gridSize, int cellSize, Color bgColor, Color lineColor) {
        GreenfootImage bg = getBackground ();
        bg.setColor(bgColor);
        bg.fill();
        bg.setColor(lineColor);
        for (int i=0; i < gridSize; i++) {
            bg.drawLine(i * cellSize, 0, i * cellSize, gridSize * cellSize);
            bg.drawLine(0, i * cellSize, gridSize * cellSize, i * cellSize);
        }
    }
    
    
    /**
     * populateBears - add a set amount of new bears into the park
     *
     */
    private void populateBears (int numberOfBears, int bearSize)
    {
        for (int i=0; i<numberOfBears; i++) {
            Bear smokey = new Bear(bearSize);
            addObject(smokey, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        }
    }
    

    /**
     * populateHares - add a set amount of new bears into the park
     *
     */
    private void populateHares (int numberOfHares, int hareSize)
    {
        for (int i=0; i<numberOfHares; i++) {
            Hare bugs = new Hare(hareSize);
            addObject(bugs, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        }
    }


    /**
     * populateBears - add a set amount of new bears into the park
     *
     */
    private void populateHareFood (int numberOfShrubs, int shrubSize)
    {
        for (int i=0; i<numberOfShrubs; i++) {
            Shrubbery plant = new Shrubbery(shrubSize);
            addObject(plant, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        }
    }

}
