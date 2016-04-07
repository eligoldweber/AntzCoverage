import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class wall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wall extends Actor
{
    
    public Wall(){
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - (image.getWidth()-10), 
        image.getHeight() - (image.getHeight()-10));
        setImage(image);
    }
    /**
     * Act - do whatever the wall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
