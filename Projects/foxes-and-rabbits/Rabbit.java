import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * Write a description of class Rabbit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rabbit extends Animal
{
    // Characteristics shared by all rabbits (static fields).

    // The age at which a rabbit can start to breed.
    private static final int BREEDING_AGE = 5;
    // The age to which a rabbit can live.
    private static final int MAX_AGE = 50;
    // The likelihood of a rabbit breeding (in percent).
    private static final double BREEDING_PROBABILITY = 12;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 5;
    
    // Individual characteristics (instance fields).

    /**
     * Default constructor for testing.
     */
    public Rabbit()
    {
        this(true);
    }

    /**
     * Create a new rabbit. A rabbit may be created with age
     * zero (a new born) or with a random age.
     * 
     * @param randomAge If true, the rabbit will have a random age.
     */
    public Rabbit(boolean randomAge)
    {
        super();
        if(randomAge) {
            setAge(Greenfoot.getRandomNumber(MAX_AGE));
        }
    }
    
    /**
     * This is what the rabbit does most of the time - it runs 
     * around. Sometimes it will breed or die of old age.
     */
    public void act() 
    {
        incrementAge();
        if (isAlive()) {
            int births = breed();
            for(int b = 0; b < births; b++) {
                Location loc = getField().freeAdjacentLocation(getX(), getY());
                if (loc != null) {
                    Rabbit newRabbit = new Rabbit(false);
                    getWorld().addObject(newRabbit, loc.getX(), loc.getY());
                }
            }
            Location newLocation = getField().freeAdjacentLocation(getX(), getY());
            // Only transfer to the updated field if there was a free location
            if(newLocation != null) {
                setLocation(newLocation.getX(), newLocation.getY());
            }
            else {
                // can neither move nor stay - overcrowding - all locations taken
                setDead();
            }
        }
    }    
    
    /**
     * Increase the age.
     * This could result in the rabbit's death.
     */
    private void incrementAge()
    {
        setAge(getAge() + 1);
        if(getAge() > MAX_AGE) {
            setDead();
        }
    }
    
    /**
     * Generate a number representing the number of births,
     * if it can breed.
     * @return The number of births (may be zero).
     */
    private int breed()
    {
        int births = 0;
        if(canBreed() && Greenfoot.getRandomNumber(100) <= BREEDING_PROBABILITY) {
            births = Greenfoot.getRandomNumber(MAX_LITTER_SIZE) + 1;
        }
        return births;
    }
    
    /**
     * @return A string representation of the rabbit.
     */
    public String toString()
    {
        return "Rabbit, age " + getAge();
    }

    /**
     * A rabbit can breed if it has reached the breeding age.
     */
    private boolean canBreed()
    {
        return getAge() >= BREEDING_AGE;
    }
}
