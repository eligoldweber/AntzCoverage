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
    private ScoreKeeper goalie;
    
    public GoodFruit (int rate, ScoreKeeper goaler) {
        super(rate);
        goalie = goaler;
    }
    
    public void act () {
        if (Greenfoot.mouseMoved(this)) {
            getWorld().removeObject(this);
            goalie.scoreGoodFruit();
        } else {
            fall();
            missedFruit();
        }
    }
    
   
    public void missedFruit () {
         if (getY() == getWorld().getHeight()-1) {
            //List avatars = getWorld().getObjects(Ninja.class);
            //Ninja me = (Ninja) avatars.get(0);
            goalie.scoreMissedFruit();
            getWorld().removeObject(this);
        }
    }
}
