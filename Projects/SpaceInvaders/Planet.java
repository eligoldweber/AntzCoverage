import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
import java.lang.System;
import java.awt.Color;

/**
 * Planet class - the underlying world class for a game of space invaders
 * 
 * @author (Mikey G) 
 * @version (4/20/11)
 */
public class Planet  extends World
{
    // General constants
    private final static int HEIGHT = 750;
    private final static int WIDTH = 900;
    private final static int DELAYTIME = 20;
    private final static int STARTINGLIFECOUNT = 3;
    private int lifeCount;
    private int level;
    
	// My own enumerated type
    private final static int LIZARD = 0;
    private final static int ANT = 1;
    private final static int LOBSTER = 2;
    private final static int BLUELOBSTER = 3;
    
    ArrayList<Integer> deltaBombValues;
    ArrayList<Integer> currentBombValues;
    ArrayList<Integer> deltaProbs;
    ArrayList<Integer> currentProbs;
    
    // Lobster parameters
    private final static int PHALANAXWIDTH = 10;
    private final static int PHALANAXHEIGHT = 5;
    private final static int ROWDELTA = 15;
    private final static int STARTINGROW = 45;
    private int startRow;
    
    // Lizard parameters
    private final static int LIZARDROW = 25;
    

	// Constructor to reset all to starting configurations.  There are four arrayLists
	// each enumerated by the same enumerated type.  These lists store:
	// current bomb drop rate for each baddie class
	// delta bomb drop rate for each baddie class
	// current appearance rate for lizards and ants
	// delta appearance rates for lizards and ants
    public Planet()
    {    
        super(WIDTH, HEIGHT, 1); 
        Bug.reset();
        deltaBombValues = new ArrayList<Integer>();
        currentBombValues = new ArrayList<Integer>();
        resetBombValues();
        
        currentProbs = new ArrayList<Integer>();
        deltaProbs = new ArrayList<Integer>();
        resetProbValues();
        
        startRow = STARTINGROW;
        lifeCount = STARTINGLIFECOUNT;
        level = 0;
        createPhalanax (startRow);
        addDefender();
        displayLives();
    }
    
// Note on probabilites:  These are the upper value for the selection of a random number.
// Success is defined as picking one out of x.  So if the probability is 100, then the probability
// of success is 1% (chance that zero is picked from [0..99]).  As the values decrease, probability
// of success increases

	// reset appearance probabilities to starting values
    private void resetProbValues() {
        currentProbs.add(LIZARD, 500);
        deltaProbs.add(LIZARD, 20);
        currentProbs.add(ANT, 500);
        deltaProbs.add(ANT, 50);
    }
    
	// reset bomb dropping probabilities to starting values
    private void resetBombValues() {
        currentBombValues.add(LIZARD, 800);
        deltaBombValues.add(LIZARD, 100);
        currentBombValues.add(ANT, 25);
        deltaBombValues.add(ANT, 1);
        currentBombValues.add(LOBSTER, 750);
        deltaBombValues.add(LOBSTER, 15);
        currentBombValues.add(BLUELOBSTER, 20);
        deltaBombValues.add(BLUELOBSTER, 1);
    }
    
    // World's act method:  first check to see if a level is over: no bugs on the screen.
	//	If so, reset to the next level.  
	// If not a new level, check to see if the defender died: if so, reincarnate (if lifecount > 0)
	// o.w. end the game.  When reincarnating a defender, remove all bombs from the world.
	public void act () {
		
		// End of level?
        List<Defender> dList = getObjects(Defender.class);
        if (Bug.getBugCount() == 0) {
            Greenfoot.delay(DELAYTIME);
            setUpNewLevel();
            createPhalanax (startRow);
            Defender d = dList.get(0);
            if (d != null) {d.incrementMaxBombCnt();}
        }
        
		// Defender dead?
        if (dList.isEmpty()) {
            lifeCount--;
            displayLives();
            if (lifeCount == 0) {
                displayGameOver();
            }
            else {
                // remove all bombs from world before reincarnating defender
				List<DownBomb> bombList = getObjects(DownBomb.class);
                for (DownBomb b : bombList) {
                    removeObject(b);
                }
                Greenfoot.delay(DELAYTIME);
                addDefender();
            }
        }
        
		// based on stored probabilites, add lizards and/or ants to the mix.
        addLizards();
        addAnts();
    }
    
	// Whenever the score reaches some present threshold, increment life count
    public void addLife() {
        lifeCount++;
        displayLives();
    }
    
    // Set up a new level:  update all probabilites, increment level counter, and update row
	// that the lobster phalanx starts at.
	private void setUpNewLevel() {
        level++;
        startRow += ROWDELTA;
        for (int i=0; i< 4; i++) {
            int newValue = currentBombValues.get(i) - deltaBombValues.get(i);
            if (newValue > 1) {
                currentBombValues.set(i, newValue);
            }
        }
        for (int i=0; i < 2; i++) {
            int newValue = currentProbs.get(i) - deltaProbs.get(i);
            if (newValue > 1) {
                currentProbs.set(i, newValue);
            }
        }
    }
    
	// Based on a stored probability, add a lizard to the world.  Only 1 lizard at a time
    private void addLizards() {
        List<Lizard> lizardList = getObjects(Lizard.class);
        int lizardChance = Greenfoot.getRandomNumber(currentProbs.get(LIZARD));
        if ((lizardList.isEmpty()) && (lizardChance < 1)) {
            Lizard l = new Lizard(currentBombValues.get(LIZARD));
            addObject(l, WIDTH-l.getImage().getWidth(), LIZARDROW);
        }
    }
    
	// Based on a stored probability, add an ant to the world.  The maximum number of
	// simultaneous ants is based on the level # (level # + 2)
    private void addAnts() {
        List<Ant> antList = getObjects(Ant.class);
        int antChance = Greenfoot.getRandomNumber(currentProbs.get(ANT));
        if ((antList.size() < (level+2)) && (antChance < 1)) {
            Ant a = new Ant(currentBombValues.get(ANT));
            addObject(a, WIDTH/2, LIZARDROW);
        }
    }


	// Instantiate a phalanax of lobsters: width, and height set by constants.
	// Startrow is an (ever lowering) parameter value.
	// Based on a probablity determined by level number upgrade some red lobsters
	// to blue lobsters.
    private void createPhalanax (int startRow) {
        for (int i=0; i < PHALANAXHEIGHT; i++) {
            for (int j=0; j < PHALANAXWIDTH; j++) {
                int blueGuyChance = Greenfoot.getRandomNumber(100);
                Lobster l;
                if (blueGuyChance < (level+2)) {
                    l = new BlueLobster(currentBombValues.get(BLUELOBSTER));
                }
                else {
                    l = new Lobster(currentBombValues.get(LOBSTER));
                }
                int halfWidth = l.getImage().getWidth();
                int halfHeight = l.getImage().getHeight();
                addObject (l, (j * halfWidth) + 150, (i * halfHeight) + startRow);
            }
        }
    }
    
	// Graphic to display the number of lives remaining (includes current defender)
    private void displayLives() {
        String outString = "Lives: " + Integer.toString(lifeCount);
        GreenfootImage finalScore = new GreenfootImage(outString, 40, Color.white, Color.blue);
        GreenfootImage bg = getBackground();
        bg.drawImage(finalScore, getWidth()-150, 25);
    }
    
	// The So long and thanks for all the fish message
    private void displayGameOver() {
        String outString = "Game Over!";
        GreenfootImage finalScore = new GreenfootImage(outString, 70, Color.white, Color.blue);
        GreenfootImage bg = getBackground();
        bg.drawImage(finalScore, (getWidth()/2-(finalScore.getWidth()/2)), (getHeight()/2 - (finalScore.getHeight() / 2)));
        Greenfoot.stop();
    }

	// Instantiates a reincarnated defender
    private void addDefender () {
        Defender d = new Defender();
        addObject (d, (WIDTH / 2), HEIGHT);
    }
        
}
