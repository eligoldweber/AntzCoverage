import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Swoosh here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Swoosh  extends Actor
{
    private int age;
    
    public Swoosh () {
        age = 0;
    }
    
    public void act() 
    {
       age++;
       if (age == 20) {
           getWorld().removeObject(this);
        }
    }    
}
