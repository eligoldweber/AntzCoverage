import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.util.List;
import java.util.Iterator;


/**
 * Chaser objects move independently around the world in the hope of "catching" the single runner
 * object.  The catch occurs when a chaser object occupies the same location as the runner object.
 * 
 * Chasers move randomly through the world unless they sense the runner is close by; the runner is
 * within PROXIMITY squares of the chaser.  If the runner is close, the chaser then moves purposefully
 * toward the runner.
 * 
 * @author Mikeyg
 * @version 2/25/07
 */
public class Chaser extends Character
{
    // Instance variable to control how close a runner is before a chaser can sense it.
    private static final int PROXIMITY = 6;
    
    
    /**
     * Act - If the runner is close by, move towards it, otherwise move in a random fashion.
     * The current implementation has chasers moving without wrap throughout the world.
     * 
     * Proximity detection is performed in a non-wrapping manner.
     */
    public void act() 
    {
        List runnerList = getNeighbours(PROXIMITY, true, Runner.class);
        
        if (runnerList.size() == 0) {
            // make a random move: pick a square from the set of nine square set centered around the chaser
            moveWithoutWrap(Greenfoot.getRandomNumber(MAXMOVE), Greenfoot.getRandomNumber(MAXMOVE));
        }
        
        else {
            // move towards the runner
            Runner badGuy = (Runner) runnerList.remove(0);
            moveTowardRunner(badGuy);
         }        
    }  
    
    
    /**
     * moveTowardRunner - A chaser is close to the runner.  This method moves the chaser towards 
     * the runner's location.  Determine which if of the nine squares centered around the chaser's
     * current location is "closest" to the runner and move into that square.
     *
     * @param  badGuy - reference to the runner
     */
    private void moveTowardRunner (Runner badGuy) {
        int baddieX = badGuy.getX();
        int baddieY = badGuy.getY();
        int myX = getX();
        int myY = getY();
        int xDirection, yDirection;
        
        if (baddieX == myX) {
            xDirection = STAY;
        } else if (baddieX < myX) {
            xDirection = LEFT;
        } else {
            xDirection = RIGHT;
        }
        
        if (baddieY == myY) {
            yDirection = STAY;
        } else if (baddieY < myY) {
            yDirection = UP;
        } else {
            yDirection = DOWN;
        }
        
        //System.out.println(baddieX + " " + baddieY + "  " + xDirection + "  " + yDirection);
        moveWithoutWrap(xDirection, yDirection);
    }   

}
