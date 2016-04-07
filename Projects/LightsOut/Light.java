import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * An individual "light" for the Lights Out game.  A light is a two-state object: on or off.
 * 
 * When one clicks on a light, two things happen:  the light changes state.  Addditionally, all
 * adjacent (non-diagonal) neighbors also change state.  
 * The game is over when all the lights are in the off state.  Hence there is a static variable
 * keeping track of the number of lights that are in the "on" state.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Light  extends Actor
{
    private boolean stateOn = true;
    private static int onCount = 0;
    
    public Light () {
        onCount++;
    }
    
    /**
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked (this)) {
            flip();
        
            List neighbors = getNeighbours(1, false, Light.class);
            int index = 0;
            while (index < neighbors.size()) {
                Light x = (Light) neighbors.get(index);
                x.flip();
                index++;
            }
            
            if (gameOver()) {
                System.out.println("well done");
            }
        }
    }   
    
    public void flip () {
        GreenfootImage img = getImage();
        if (stateOn) {
            img.setTransparency(0);
            stateOn = false;
            onCount--;
        } else {
            img.setTransparency(255);
            stateOn = true;
            onCount++;
        }
    }
    
    private boolean gameOver () {
        return (onCount == 0);
    }
        
}
