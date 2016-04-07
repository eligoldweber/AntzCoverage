import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class GoodFruit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GoodFruit  extends Fruit
{
    
    public GoodFruit (int rate) {
        super(rate);
    }
    
    public void act () {
        fall();
        missedFruit();
    }
    
    
    public void missedFruit () {
         if (getY() == getWorld().getHeight()-1) {
            List avatars = getWorld().getObjects(Ninja.class);
            Ninja me = (Ninja) avatars.get(0);
            me.scoreMissedFruit();
            getWorld().removeObject(this);
        }
    }
}
