import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Board here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Board  extends World
{
    public static final int DIM = 6;
    private static final int PIXELSIZE = 60;
    private static final int PROBABILITYON = 15;

    /**
     * Constructor for objects of class Board.
     * 
     */
    public Board()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(DIM, DIM, PIXELSIZE);
        setBackground("sand.jpg");
        populate();
    }
    
    private void populate() {
            for (int i=0; i < DIM; i++) {
                for (int j=0; j < DIM; j++) {
                    Light x = new Light ();
                    addObject (x, i, j);
                    x.flip();
                    
                    int maybe = Greenfoot.getRandomNumber(100);
                    if (maybe < PROBABILITYON) {
                        x.flip();
                    }
                }
            }
        }
}
