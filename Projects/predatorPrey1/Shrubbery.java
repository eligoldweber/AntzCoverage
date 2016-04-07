import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * Write a description of class Shrubbery here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shrubbery extends Actor
{
    /**
     * Shubbery Constructor
     *
     */
    public Shrubbery (int shrubSize)
    {
        GreenfootImage s1 = getImage();
        s1.scale (shrubSize, shrubSize);
    }
    
    
    /**
     * Act - do whatever the Shrubbery wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
