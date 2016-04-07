import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Banana here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fruit  extends Actor
{
    private int speed;
    private boolean orientation;
    
    public Fruit (int rate) {
        speed = rate;
        orientation = (Greenfoot.getRandomNumber(100) > 50);
    }
    
    
    
    
    public void fall() 
    {
        int dx = Greenfoot.getRandomNumber(4);
        if (orientation) {
            dx = 0-dx;
        }
        setLocation(getX()+dx, getY()+speed);
        if ((getX() == 0) || (getX() == getWorld().getWidth()-1)) {
            orientation = !orientation;
        }
    }   
    
}
