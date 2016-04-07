import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * Bear class - the predator in the predator prey simulation
 * 
 * @author: mikeyg
 */
public class Bear extends Animal
{
    private static final int MAXAGE = 45;
    private static final int MENARCHE_AGE = 5;
    private static final int MINBREEDINGHEALTH = 5;
    private static final double BREEDING_PROBABILITY = 0.15;
    private static final int LACTATIONPERIOD = 4;
    
 
    /**
     * Bear Constructor
     *
     */
    public Bear (int bearSize) {
        super(bearSize, MAXAGE, MENARCHE_AGE);
    }
    
    /**
     * Act - do whatever the Bear wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        incrementAge();
        if (isAlive()) {decrementHealth();}
    }    
    
    
    // Get methods for access to animal specific instance variables
    public int getMaxAge () {return (MAXAGE);}
    
    
}
