import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Lizard subclass of Bug.  Lizards walk across the to of the screen
 * at periodic intervals, one at a time, dropping bombs
 * 
 * @author (Mikey G) 
 * @version (4/20/11)
 */
public class Lizard  extends Bug
{
	// Constants: horizontal speed, score value, and bomb speed
    private static final int XDELTA = 1;
    private static final int SCOREVALUE = 10;
    private static final int BOMBSPEED = 3;
    
    private int bombProbability;
    
    // record lizard bomb dropping frequency probability
    public Lizard(int prob) {
        super();
        bombProbability = prob;
    }
        
	// overridden move method: move horizontally across the screen top
	// remvoe from world at left screen edge
    public void move() {
        setLocation(getX()-XDELTA, getY());
        if (atEdge()) {
            decrementBugCount();
            getWorld().removeObject(this);
        }
    }
    
	// functions to supply the Bug superclass with appropriate subclass 
	// values.
    public int getValue() {
        return(SCOREVALUE);
    }
    
    public int getBombProbability() {
        return (bombProbability);
    }
    
    public int getBombSpeed() {
        return(BOMBSPEED);
    }
}
