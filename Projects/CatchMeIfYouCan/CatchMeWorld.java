import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.awt.Color;

/**
 * CatchMeIfYouCan world
 * 
 * @author Mikeyg
 */
public class CatchMeWorld extends World 
{

    // Some useful constants related to the size of the world
    private static final int ENV_SIZE = 20;
    private static final int CELL_SIZE = 30;

    /**
     * Constructor for objects of class CatchMeWorld.
     * 
     */
    public CatchMeWorld() {    
        // Create a new world with 20x20 cells with a cell size of 10x10 pixels.
        super(ENV_SIZE, ENV_SIZE, CELL_SIZE);
        drawBackground();
        
        // Put in your own background image by replacing "greenfoot.png" with the
        // image that should be used as background and uncommenting the line below.
        Rock r1 = new Rock();
        
        addObject(r1, 2, 3);
        
        GreenfootImage aa = r1.getImage();
        aa.scale(CELL_SIZE, CELL_SIZE);
        //setBackground("greenfoot.png"); 
    }
    
    /**
     * drawBackground - draw grid lines on the world that has first been set to a yellow background
     *
     */
    private void drawBackground () {
        GreenfootImage bg = getBackground ();
        bg.setColor(Color.yellow);
        bg.fill();
        bg.setColor(Color.BLACK);
        for (int i=0; i < ENV_SIZE; i++) {
            bg.drawLine(i * CELL_SIZE, 0, i * CELL_SIZE, ENV_SIZE * CELL_SIZE);
            bg.drawLine(0, i * CELL_SIZE, ENV_SIZE * CELL_SIZE, i * CELL_SIZE);
        }
    }
}
