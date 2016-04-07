import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Lobster subclass of Bug.  Lobsters hang out in phalanaxes.  They move left
 * to right across the screen, dropping down one notch (as a group) whenever one
 * edge or the other hits the left/right world edge.  Lobsters drop bombs as well.
 * 
 * @author (Mikey G) 
 * @version (4/20/11)
 */
public class Lobster  extends Bug
{
	// Constants: notch height, score value, and bomb speed
    private static final int YDELTA = 15; 
    private static final int SCOREVALUE = 2;
    private static final int BOMBSPEED = 3;

	private static int xDelta = 2;   // left-right speed
    private int bombProbability;
    
    // record lizard bomb dropping frequency probability
	public Lobster (int prob) {
        super();
        bombProbability = prob;
    }
    
	// overridden move method: move horizontally across the screen as a group.
	// when an edge is detected, move the whole phalanax down one notch
	public void move() {
        setLocation (getX()+xDelta, getY());
        if (atEdge()) {
            shiftAllDown();
        } 
    }

	// Method to move all lobsters down one notch vertically
    private void shiftAllDown() {
        xDelta = -1 * xDelta;
        List<Bug> uglies = getWorld().getObjects(Lobster.class);
        for (Bug b : uglies) {
            b.setLocation (b.getX() + xDelta, b.getY() + YDELTA);
        }
    }
  
    // functions to supply the Bug superclass with appropriate subclass 
	// values.
	public int getBombProbability () {
        return (bombProbability);
    }
    
    public int getValue() {
        return(SCOREVALUE);
    }

    public int getBombSpeed() {
        return(BOMBSPEED);
    }
}
