import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * Hare class - the prey in the predator-prey simulation
 * 
 * @author: mikeyg
 */
public class Hare extends Animal
{
    private static final int MAXAGE = 15;
    private static final int MENARCHE_AGE = 2;
    private static final int MINBREEDINGHEALTH = 5;
    private static final double BREEDING_PROBABILITY = 0.25;
    private static final int LACTATIONPERIOD = 2;
    
    private int ageAtLastLiter;
    private int age;
    private int healthLevel;
    
    /**
     * Hare Constructor
     *
     */
    public Hare (int hareSize) {
        super(hareSize, MAXAGE, MENARCHE_AGE);
    }  
    
    
    /**
     * Act - do whatever the Hare wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        incrementAge();
        if (isAlive()) {decrementHealth();}
    }    
    
    
    // Get methods for access to animal specific instance variables
    public int getMaxAge () {return (MAXAGE);}

}
