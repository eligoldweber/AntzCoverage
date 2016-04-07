import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.lang.System;
import java.awt.Color;

/**
 * Write a description of class ScoreKeeper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreKeeper  
{
    // instance variables - replace the example below with your own
    private int missedCount;
    private int score;
    private World myWorld;

    /**
     * Constructor for objects of class ScoreKeeper
     */
    public ScoreKeeper(World theWorld)
    {
        missedCount = 0;
        score = 0;
        myWorld = theWorld;
    }

    
    public void scoreGoodFruit () {
        score++;
        displayScore();
    }

    public void scoreMissedFruit () {
        missedCount++;
        GreenfootImage bigX = new GreenfootImage ("X", 40, Color.red, Color.blue);
        if (missedCount == 1) {
            myWorld.getBackground().drawImage(bigX, 100, 140);
        }
        if (missedCount == 2) {
            myWorld.getBackground().drawImage(bigX, 140, 140);
        }
        if (missedCount == 3) {
            myWorld.getBackground().drawImage(bigX, 180, 140);
            gameOverMsg();
        }
    }
    

    private void displayScore() {
        String outString = "Score: " + Integer.toString(score);
        GreenfootImage finalScore = new GreenfootImage(outString, 40, Color.black, Color.blue);
        GreenfootImage bg = myWorld.getBackground();
        bg.drawImage(finalScore, 100,100);
        //System.out.println(score);
    }
    
    public void gameOverMsg() {
        GreenfootImage finalMsg = new GreenfootImage ("GAME OVER", 40, Color.white, Color.blue);
        myWorld.getBackground().drawImage(finalMsg, 300, 60);
        Greenfoot.stop();
    }
}
