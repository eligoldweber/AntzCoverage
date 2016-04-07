import greenfoot.*;

/**
 * Write a description of class BluePlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BluePlayer  
{
    /**
     * Constructor for objects of class BluePlayer
     */
    public BluePlayer() {}


    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void placeBlueDisk(Board theBoard, ConnectFourWorld theWorld)
    {
        int newX = Greenfoot.getRandomNumber(theWorld.BOARDWIDTH);
        int newY = theBoard.highestOpenRow(newX);
        while (newY < 0) {
            newX = Greenfoot.getRandomNumber(theWorld.BOARDWIDTH);
            newY = theBoard.highestOpenRow(newX);
        }
        BlueDisk blueBlob = new BlueDisk();
        theWorld.addObject(blueBlob, newX, newY);
        theBoard.setDisk(newX, newY, Board.BLUE);
        theBoard.gameOver(Board.BLUE);
    }
}
