import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.util.List;

/**
 * Runner - implement a single, user-controlled avatar to avoid being caught by any of the chaser
 * objects.  The runner tries to evade the chasers.  The simulation ceases when the runner and any
 * of the chasers occupy the same location.
 * 
 * @author Mikeyg
 * @version 2/25/07
 */
public class Runner extends Character
{
    /**
     * Act - Interpret the users key input (up, down, left and right arrow keys) to control
     * the movement of the single runner object.  The runner moves through the world as if it
     * is a torus: it wraps around the world.
     */
    public void act() 
    {
        // See if the chase is up
        List cops = getObjectsAtOffset(0, 0, Chaser.class);
        
        if (cops.isEmpty()) {
            
            // Game still on, get the user's key input and move accordingly
            String keyDown = Greenfoot.getKey();
        
            if (keyDown == "left") {
                moveWithWrap(LEFT, STAY);
            }
            if (keyDown == "right") {
                moveWithWrap(RIGHT, STAY);
            }
            if (keyDown == "up") {
                moveWithWrap(STAY, UP);
            }
            if (keyDown == "down") {
                moveWithWrap(STAY, DOWN);
            }  
        }
        
        // The game is up :-(
        else {
            Rock r1 = new Rock();
            getWorld().addObject(r1, 1, 1);
            Greenfoot.stop();
        }
    }    
}
