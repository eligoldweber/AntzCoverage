import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.lang.System;
import java.awt.Color;

/**
 * Bug class: Superclass for all baddies in the invader world.
 *   Handles generic move(act), bomb dropping, and hit detection.
 * 
 * @author (Mikey G) 
 * @version (4/20/11)
 */
public abstract class Bug  extends Actor
{
   
	// Constant for new defender life (due to hit detection repsponsibility)
    private static final int NEWLIFETHRESHOLD = 250;

	// Static variables: bugCount to learn when a level is over.
	//	score - duh
	//  modValue - keeps track of when a new life happens
    private static int bugCount = 0;
    private static int score = 0;
    private static int modValue = 0;

    
	// add 1 to bug count whenever a new bug is born:  level concludes whenever this value 
	// hits zero.
    public Bug () {
        bugCount++;
    }
    
	// Common act method:  if not hit, drop bombs and move to new location
    public void act() 
    {
        if (!hit()) {
            dropBomb();
            move(); 
        }
    } 
    
	// When a new game commences, static variables need resetting.
    public static void reset() {
        score = 0;
        modValue = 0;
        bugCount = 0;
    }
    
	// Predicate to check if the bug got hit:  if so, update score (each bug knows its own
	//  value).  Also remove the bug and the bomb that hit it.
    public boolean hit() {
        boolean returnValue = false;
        List hitList = getIntersectingObjects(UpBomb.class);
        if (hitList.size() != 0) {
            UpBomb b = (UpBomb) hitList.get(0);
            int scoreValue = getValue();
            displayScore(scoreValue);
            getWorld().removeObject(b);
            getWorld().removeObject(this);
            decrementBugCount();
            returnValue = true;
        }
        return (returnValue);
    }
    
	// Based on probability, drop a bomb.  Each bug knows its bomb dropping 
	// probability.  Furthermore, each bug knows the rate at which its bombs drop
    public void dropBomb() {
        int randomInt = Greenfoot.getRandomNumber(getBombProbability());
        if (randomInt < 1) {
            DownBomb b = new DownBomb(getBombSpeed());
            getWorld().addObject(b, getX(), getY());
        }
    }
    
	// should be obvious
    public void decrementBugCount() {
        bugCount--;
    }
    
	// ditto
    public static int getBugCount() {
        return (bugCount);
    }
    
	// predicate to learn if the lobster phalanax reached either the left or right edge
    protected boolean atEdge() {
        int xVal = getX();
        return ((xVal <= getImage().getWidth()) || (xVal >= (getWorld().getWidth() - getImage().getWidth())));
    }
    
	// Since this class is responsible for processing bug hits, it also displays the score.
    private void displayScore(int incrementValue) {
        score = score + incrementValue;
        int newMod = score / NEWLIFETHRESHOLD;
        if (newMod > modValue) {
            Planet myWorld = (Planet) getWorld();
            myWorld.addLife();
            modValue = newMod;
        }
        String outString = "Score: " + Integer.toString(score);
        GreenfootImage finalScore = new GreenfootImage(outString, 40, Color.white, Color.blue);
        GreenfootImage bg = getWorld().getBackground();
        bg.drawImage(finalScore, 25,25);
    }
    

    public abstract int getBombSpeed();
    public abstract void move();
    public abstract int getBombProbability ();
    public abstract int getValue();
}
