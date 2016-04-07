import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Bug bomb subclass
 * 
 * @author (Mikey G) 
 * @version (4/20/11)
 */
public class DownBomb  extends Bomb
{
    private  int yDelta;
    
	// Constructor stores the yDelta value: downward speed of the bomb
    public DownBomb (int speed) {
        super();
        yDelta = speed;
    }
    
	// First see if hit an upward traveling bomb: if so remove both bombs.
	// o.w. call common move method
    public void act () {
        UpBomb b = (UpBomb) getOneIntersectingObject(UpBomb.class);
        if (b != null) {
            getWorld().removeObject(b);
            getWorld().removeObject(this);
        }
        else {
            move();
        }
    }
    
	// return traveling speed.
    public int getDelta() 
    {
        return (yDelta);
    }    
}
