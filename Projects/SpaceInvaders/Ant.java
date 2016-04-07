import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Ant subclass of Bug.  Ants fall quickly at an angle (bouncing off left/right world edges).
 *  They drop a lot of bombs as well.
 * 
 * @author (Mikey G) 
 * @version (4/20/11)
 */
public class Ant  extends Bug
{
    // Constants: descent speed, score value, and bomb speed
	private static final int SCOREVALUE = 50;
    private static final int SPEED = 4;
    private static final int DIM = 20;
    private static final int BOMBSPEED = 5;
    private int bombProbability;
    private boolean orientation;
    
	// record bomb dropping frequency probability and set up 
	// initial angle of descent (randomely selected)
    public Ant (int prob) {
        super();
        bombProbability = prob;
        orientation = (Greenfoot.getRandomNumber(100) > 50);
        getImage().scale(DIM, DIM);
    }
    
    
    // overridden move method: move diagonally down screen, bouncing
	// off left/right walls.  
	// remove when reaches bottom of world
	public void move() {
        int dx = Greenfoot.getRandomNumber(4);
        if (orientation) {
            dx = 0-dx;
        }
        setLocation(getX()+dx, getY()+SPEED);
        if ((getX() == 0) || (getX() == getWorld().getWidth()-1)) {
            orientation = !orientation;
        }
        if (atBottom()) {
            decrementBugCount();
            getWorld().removeObject(this);
        }
    }

    // predicate to indicate if at bottom of world
    private boolean atBottom() {
        return (getY() > getWorld().getHeight()-DIM);
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
