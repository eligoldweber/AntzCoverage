import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Defender class - operates the user controlled avatar.
 * 
 * @author (Mikey G) 
 * @version (4/20/11)
 */
public class Defender  extends Actor
{
	// Useful constants: left-right speed and bomb shooting parameters
    private static final int XDELTA = 4;
    private static final int STARTINGMAXBOMBCNT = 5;
    private static final int DELTABOMBCOUNT = 1;
    private static int maxCurrentBombs;
    
    public Defender () {
        maxCurrentBombs = STARTINGMAXBOMBCNT;
    }
    
	// First see if hit (if so remove from world and let the world take it from there).
	// If not hit:  process key inputs: move left, right and/or shoot bomb
    public void act() 
    {
        if (!hit()) {
            String keyDown = Greenfoot.getKey();
            if (Greenfoot.isKeyDown("left")) {
                setLocation(getX()-XDELTA, getY());
            }
            if (Greenfoot.isKeyDown("right")) {
                setLocation(getX()+XDELTA, getY());
            }
            if (keyDown == "space") {
                List <UpBomb> bombList = getWorld().getObjects(UpBomb.class);
                if (bombList.size() < maxCurrentBombs) {
                    UpBomb b = new UpBomb();
                    getWorld().addObject(b, getX(), getY());
                }
            }

        }    
        else {
            getWorld().removeObject(this);
        }
    }
    
	// The number of simultaneous bombs shot by the defender on the screen is controlled by 
	// maxCurrentBombs.  This value is incremented whenever a new level is cleared.  When a 
	// defender gets reincarnated (new instantiation) the rate gets reset.
    public void incrementMaxBombCnt () {
        maxCurrentBombs = maxCurrentBombs + DELTABOMBCOUNT;
    }
    
	// predicate to see if defender should die: hit by bomb or intersecting bug
    private boolean hit() {
        List<DownBomb> hitList = getIntersectingObjects(DownBomb.class);
        List<Bug> bugList = getIntersectingObjects(Bug.class);
        return ((!hitList.isEmpty()) || (!bugList.isEmpty()));
    }
}
