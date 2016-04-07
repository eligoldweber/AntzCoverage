import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.System;
import java.awt.Color;

/**
 * BlueLobster subclass of Lobster.  A blue lobster acts just like a regular lobster only it has 
 * a blue indicator and drops bombs at a higher rate (and is worth more to kill)
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlueLobster  extends Lobster
{
    private static final int SCOREVALUE = 20;
    private int bombProbability;
 
    // record lizard bomb dropping frequency probability and set up 
	// the blue indicator
	public BlueLobster (int prob) {  
        super(prob);
        bombProbability = prob;
        GreenfootImage lobsterPicture = getImage();
        lobsterPicture.setColor(Color.blue);
        int imageHeight = lobsterPicture.getHeight();
        int imageWidth = lobsterPicture.getWidth();
        lobsterPicture.fillOval(imageWidth/2-10, imageHeight/2-10, 20, 20);
    }
    
    // functions to supply the Bug superclass with appropriate subclass 
	// values.
	public int getBombProbability () {
        return (bombProbability);
    }
    
    public int getValue() {
        return(SCOREVALUE);
    }
}
