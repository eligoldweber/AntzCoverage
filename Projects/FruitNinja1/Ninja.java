import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.lang.System;
import java.awt.Color;

/**
 * Write a description of class Ninja here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ninja  extends Actor
{
    private int speed = 3;
    private int score;
    private int missedCount;
    
    public Ninja () {
        score = 0;
        missedCount = 0;
    }
    
    /**
     * Act - do whatever the Ninja wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int imageWidthOffset = (getImage().getWidth() / 2) + 1;
        int imageHeightOffset = (getImage().getHeight() / 2) + 1;
        if (Greenfoot.isKeyDown("left")) {
            setLocation(getX()-speed, getY());
        }
        
        if (Greenfoot.isKeyDown("right")) {
            setLocation(getX()+speed, getY());
        }
        if (Greenfoot.isKeyDown("up")) {
            setLocation(getX(), getY()-speed);
        }
        if (Greenfoot.isKeyDown("down")) {
            setLocation(getX(), getY()+speed);
        }
        
        if (getX() == 0) setLocation(getWorld().getWidth()-imageWidthOffset, getY());
        if (getX() == getWorld().getWidth()-1) setLocation(0, getY());
        if (getY() == 0) setLocation(getX(), getWorld().getHeight()-imageHeightOffset);
        if (getY() == getWorld().getHeight()-1) setLocation(getX(), 0);  
        
        scoreGoodFruit();
        scoreBombs();
    }    
    
    private void scoreGoodFruit () {
        List objList = getIntersectingObjects(GoodFruit.class);
        while (objList.size() != 0) {
            GoodFruit f = (GoodFruit) objList.remove(0);
            score++;
            getWorld().removeObject(f);
        }
        displayScore();
    }
    
    public void scoreMissedFruit () {
        missedCount++;
        GreenfootImage bigX = new GreenfootImage ("X", 40, Color.red, Color.blue);
        if (missedCount == 1) {
            getWorld().getBackground().drawImage(bigX, 100, 140);
        }
        if (missedCount == 2) {
            getWorld().getBackground().drawImage(bigX, 140, 140);
        }
        if (missedCount == 3) {
            getWorld().getBackground().drawImage(bigX, 180, 140);
            gameOverMsg();
            Greenfoot.stop();
        }
    }

    private void scoreBombs () {
        List objList = getIntersectingObjects(Bomb.class);
        if (objList.size() != 0) {
            Bomb b = (Bomb) objList.get(0);
            getWorld().removeObject(b);
            gameOverMsg();
            Greenfoot.stop();
            //displayScore();
        }
    }
    private void displayScore() {
        String outString = "Score: " + Integer.toString(score);
        GreenfootImage finalScore = new GreenfootImage(outString, 40, Color.black, Color.blue);
        GreenfootImage bg = getWorld().getBackground();
        bg.drawImage(finalScore, 100,100);
        //System.out.println(score);
    }
    
    private void gameOverMsg() {
        GreenfootImage finalMsg = new GreenfootImage ("GAME OVER", 40, Color.white, Color.blue);
        getWorld().getBackground().drawImage(finalMsg, 300, 60);
    }
}
