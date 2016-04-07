import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * Rock Class
 * 
 * This class is just a simple "placeholder" for a class of objects that represent
 * obstacles in the world.  Rocks do not move, nor can other objects move onto a 
 * location occupied by a rock
 * 
 * @author Mikeyg
 */
public class Rock extends Actor
{
    public Rock () {
        GreenfootImage g1 = getImage();
        g1.scale (40, 40);
    }
    
    /**
     * Act - do whatever the Rock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
      
    
    protected void addedToWorld () {
        GreenfootImage g1 = getImage();
        g1.scale (30,30);
    }
}
