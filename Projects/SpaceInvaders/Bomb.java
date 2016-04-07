import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Superclass for both bomb types: downward and upward.
 * 
 * @author (Mikey G) 
 * @version (4/20/11)
 */
public abstract class Bomb  extends Actor
{
    private static final int DIM = 10;
    
	// Common constructor so that all bombs have the same dimension.
    public Bomb () {
        getImage().scale(DIM, DIM);
    }
    

	// Common "act" method.  Each subclass returns its delta (y) value.  
	// If a bomb reaches either the top or bottom horizon it is removed from the world.
    public void move() 
    {
        setLocation(getX(), getY()+getDelta());
        if ((getY() <= DIM) || (getY() >= getWorld().getHeight()-2)) {
            getWorld().removeObject(this);
        }
    }  
    
    public abstract int getDelta();
}
