import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class NinjaWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NinjaWorld  extends World
{

    int counter;
    public static final int WIDTH = 750;
    public static final int HEIGHT = 750;
    public static final int MAXSPEED = 2;
    
    /**
     * Constructor for objects of class NinjaWorld.
     * 
     */
    public NinjaWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WIDTH, HEIGHT, 1);
        counter = 0;
        Ninja n = new Ninja();
        int heightOffset = ((n.getImage().getHeight()) / 2)+3;
        addObject (n, Greenfoot.getRandomNumber(WIDTH), HEIGHT-heightOffset);
    }
    
    public void act () {
        counter ++;
        int rVal = Greenfoot.getRandomNumber(100);
        
        if (((counter % 100) == 0) && (rVal > 50)){
            Banana b = new Banana(Greenfoot.getRandomNumber(MAXSPEED)+1);
            addObject (b, Greenfoot.getRandomNumber(WIDTH), 0);
        }
        if (((counter % 200) == 0) && (rVal > 70)) {
            Apple a = new Apple(Greenfoot.getRandomNumber(MAXSPEED)+1);
            addObject (a, Greenfoot.getRandomNumber(WIDTH), 0);
        }
        if (((counter % 100) == 0) && (rVal > 80)){
            Bomb b = new Bomb(Greenfoot.getRandomNumber(MAXSPEED)+1);
            addObject (b, Greenfoot.getRandomNumber(WIDTH), 0);
        }
    }
    
}
