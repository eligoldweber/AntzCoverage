import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TicTacToeWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TicTacToeWorld  extends World
{
    public static final int DIM = 4;
    private Board stan;
    
    /**
     * Constructor for objects of class TicTacToeWorld.
     * 
     */
    public TicTacToeWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(DIM, DIM, 60); 
        stan = new Board(DIM);        
    }
    
    public void act () {
        if (Greenfoot.mouseClicked(null)) {
            MouseInfo myClick = Greenfoot.getMouseInfo();
            int myX = myClick.getX();
            int myY = myClick.getY();
            
            if (stan.blankClicked (myX, myY)) {
                stan.playerMove(myX, myY);
                HumanPlayer p = new HumanPlayer();
                addObject (p, myX, myY);
                if (!stan.isGameOver()){
                    Location place = stan.agentMove();
                    Agent g = new Agent();
                    addObject (g, place.getX(), place.getY());
                    if (stan.isGameOver()) {
                        Greenfoot.stop();
                    }
                }
                else {Greenfoot.stop();
                }
            }
        }
    }
    
}
