import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * Animal class
 * 
 * @author: mikeyg
 */
public abstract class Animal extends Actor
{
    protected static final int UP = 1;
    protected static final int DOWN = 2;
    protected static final int STAY = 0;
    protected static final int LEFT = 1;
    protected static final int RIGHT = 2;
    protected static final int MAXMOVE = 3;
    
    private int ageAtLastLiter;
    private int age;
    private int healthLevel;
    private boolean alive;

    
    /**
     * Animal contructor
     * 
     */
    public Animal(int animalSize, int maxAge, int reproductionAge) {
        GreenfootImage a1 = getImage();
        a1.scale (animalSize, animalSize);

        alive = true;
        age = Greenfoot.getRandomNumber(maxAge);
        if (age > reproductionAge) {
            ageAtLastLiter = reproductionAge + Greenfoot.getRandomNumber(age - reproductionAge);
        } else {
            ageAtLastLiter = 0;
        }
        healthLevel = Greenfoot.getRandomNumber(maxAge);
    }
    
    
    // abstract methods that will get redefined in the subclasses
    abstract public int getMaxAge ();
    
    /**
     * isAlive - get method to learn if the animal is alive
     *
     */
    public boolean isAlive () {return (alive);}
    
    
    /**
     * incrementAge
     *
     */
    public void incrementAge () {
        age++;
        if (age > getMaxAge()) {
            alive = false;
            getWorld().removeObject(this);
        }
    }
    
    
    /**
     * decrementHealth
     *
     */
    public void decrementHealth () {
        healthLevel--;
        if (healthLevel < 0) {
            alive = false;
            getWorld().removeObject(this);
        }
    }
    

    /**
     * Act - do whatever the Animal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    
    /**
     * MoveWithWrap - move the current object in the indicated direction: 
     * Consider the 8 adjacent squares (and the current square).  The parameters indicate
     * by way of two 3-way variables which adjacent square to move into.  This function allows
     * "wrapping" around the world in a torus fashion.  Finally, after the new coordinates have 
     * been computed, the move is only made if the square to be moved into does not contain a 
     * barrier
     *
     * @param  leftRight: a 3-state variable indicating left, right, or stay put
     *         upDonw: a 3-state variable indicating up, down, or stay put.
     *         
     */
    protected void moveWithWrap (int leftRight, int upDown) {
        int currentX = getNewX(leftRight);
        int currentY = getNewY(upDown);
        
        if (currentX < 0) {
            currentX = (getWorld().getWidth()-1);
        }
        if (currentY < 0) {
            currentY = (getWorld().getHeight()-1);
        }
        currentX = currentX % getWorld().getWidth();
        currentY = currentY % getWorld().getHeight();
        
        moveIfAllowed (currentX, currentY);    
    }
    
    
    /**
     * MoveWithoutWrap - move the current object in the indicated direction: 
     * Consider the 8 adjacent squares (and the current square).  The parameters indicate
     * by way of two 3-way variables which adjacent square to move into.  This function does not
     * allow "wrapping" around the world in a torus fashion.  Any attempt to move beyond the world's 
     * bounaries is considered a no-op.  Finally, after the new coordinates have 
     * been computed, the move is only made if the square to be moved into does not contain a 
     * barrier
     *
     * @param  leftRight: a 3-state variable indicating left, right, or stay put
     *         upDonw: a 3-state variable indicating up, down, or stay put.
     *         
     */
    protected void moveWithoutWrap (int leftRight, int upDown) {
        int currentX = getNewX(leftRight);
        int currentY = getNewY(upDown);
         
        if ((currentX < 0) || (currentX >= getWorld().getWidth())) {
            currentX = getX();
        }
        if ((currentY < 0) || (currentY >= getWorld().getHeight())) {
            currentY = getY();
        }
        
        moveIfAllowed (currentX, currentY); 
    }
    
    
    /**
     * MoveIfAllowed - Given a set of coordinates move the current object to the new location 
     * if and only if the new location is not currently occupied by a barrier (i.e. an instance of
     * the Rock class.
     *
     * @param  newX - the new X coordinate
     *         newY - the new Y coordinate
     */
    private void moveIfAllowed (int newX, int newY) {
        setLocation(newX, newY);
        
//         List stuff = getWorld().getObjectsAt(newX, newY, Rock.class);
//         if (stuff.isEmpty()) {
//             setLocation (newX, newY);
//         }
    }
        
    
    /**
     * getNewX - Translate the Left, Right, Stay Put directive into a new value for the 
     * X coordinate.
     *
     * @param  leftRight: a 3-valued int: Left, Right, or Stay
     * @return     the new X coordinate.
     */  
    private int getNewX (int leftRight) {
        int currentX = getX();
        
        switch (leftRight) {
            case LEFT:
                currentX--;
                break;
            case RIGHT:
                currentX++;
                break;
            default:
                break;
            }
            
        return (currentX);
    }

    
    /**
     * getNewY - Translate the Up, Down, and Stay Put directive into a new value for the 
     * Y coordinate.
     *
     * @param  upDown: a 3-valued int: Up, Down, or Stay
     * @return     the new Y coordinate.
     */  
    private int getNewY (int upDown) {
        int currentY = getY();
        
        switch (upDown) {
            case UP:
                currentY--;
                break;
            case DOWN:
                currentY++;
                break;
            default:
                break;
            }
            
        return (currentY);
    }

}
