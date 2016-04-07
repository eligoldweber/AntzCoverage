import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb  extends Fruit
{
    ScoreKeeper goalie;
    
    public Bomb (int rate, ScoreKeeper goaler) {
        super (rate);
        goalie = goaler;
    }
    
    /**
     * Act - do whatever the Bomb wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.mouseMoved(this)) {
            goalie.gameOverMsg();
        }
        else {
            fall();
            if (getY() == getWorld().getHeight()-1) {
                getWorld().removeObject(this);
            }
        }
    }  
}
