import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Defender's subclass of the bomb
 * 
 * @author (Mikey G) 
 * @version (4/20/11)
 */
public class UpBomb  extends Bomb
{
	// All defender bombs travel at a constant rate
    private static final int YDELTA = -4;
    
    public UpBomb () {
        super();
    }
    
	// Call common move method
    public void act () {
        move();
    }
    
	// return the bomb's traveling speed
    public int getDelta() {
        return(YDELTA);
    }
}
