import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class AntzBot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AntzBot extends Actor
{
    
    private int id;
    private int dir = -1;
    private List neighbours;
    private AntzBot[] neighbors = new AntzBot[6];
    
    public AntzBot(int tId){
        id = tId;
        GreenfootImage image = getImage();
        System.out.println("id is" + id);
        image.scale(image.getWidth()-90, image.getHeight()-90);
        setImage(image);
    }
    /**
     * Act - do whatever the AntzBot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        resetNeighborhood();
        for(int i = 0;i<6;i++){
            if(getNeighbor(i) != null)
            if(!inNeighborhood(getNeighbor(i))){
                neighbors[i] = getNeighbor(i);
            }
        }
        
        for(int i = 0;i<6;i++){ //print neighborhood
            int num = 0;
            if(neighbors[i] != null){
                num = neighbors[i].getID();
            }
            System.out.println("I am "+id+" neighbor at " +i+ " = " +num);
        }
        //System.out.println("BEFOREid " + id + "x = " + getX() + " Y= " + getY());
        
        
        // Actor Thing = getOneObjectAtOffset(0,dir,AntzBot.class);
        // if(isAtEdge()||(Thing != null)){
            // dir = dir*-1;
            // System.out.println("HERER " + id + " " + dir);
        // }
        
        System.out.println("id = " + id + " neighborNum = " + neighborNum());
        
        if(neighborNum() == 0){
            System.out.println("ALONE " + id );
        }else{
            makeMove(pickRandomDirection());
           // if(neighborNum()<=3){
           //     pickDirection();
           // }
        }
        //setLocation(getX(), getY()+dir);
       
    }    
    
    public int neighborNum(){
        int num = 0;
        for(int i = 0; i <6;i++){
            if(neighbors[i] != null){
                num++;
            }
        }
        return num;
    }
    public boolean inNeighborhood(AntzBot temp){
        for(int i = 0;i<6;i++){
            if(neighbors[i] != null){
                if(temp.getID() == neighbors[i].getID()){
                    return true;
                }
            }
        }
        return false;
    }
    public void resetNeighborhood(){
        for (int i = 0;i<6;i++){
            neighbors[i] = null;
        }
    }
    public int getID(){
        return id;
    }
    public void makeMove(int dir){
        switch(dir){
            case 0:
                //System.out.println("Before " + id + "x = " + getX() + " Y= " + getY());
                setLocation(getX(), getY()-1);
                //System.out.println("AFTER " + id + "x = " + getX() + " Y= " + getY());
                break;
            case 1:
                setLocation(getX()+1, getY()-1);
                break;
            case 2:
                setLocation(getX()+1, getY());
                break;
            case 3:
                setLocation(getX()+1, getY()+1);
                break;
            case 4:
                setLocation(getX(), getY()+1);
                break;
            case 5:
                setLocation(getX()-1, getY()+1);
                break;
            case 6:
                setLocation(getX()-1, getY());
                break;
            case 7:
                setLocation(getX()-1, getY()-1);
                break;
            default:
                setLocation(getX(), getY());
                break;
        }
    }
    public int pickRandomDirection(){
        int num = Greenfoot.getRandomNumber(8);
        return num;
    }
    public void pickDirection(){
        int x = 0;
        int y = 0;
        for(int i = 0;i<6;i++){
            if(neighbors[i] != null){
                switch(i){
                    case 0:
                        x += 0;
                        y += 1;
                        break;
                    case 1:
                        x -= 1;
                        y += 1;
                        break;
                    case 2:
                        x -= 1;
                        y -= 1;
                        break;
                    case 3:
                        x += 0;
                        y -= 1;
                        break;
                    case 4:
                        x += 1;
                        y -= 1;
                        break;
                    case 5:
                        x += 1;
                        y += 1;
                        break;
                    default:
                        break;
                }
            }
        }
        //return 0;
        System.out.println("I am " + id + " my new x is " + x + " y = " + y);
        setLocation(getX()+x, getY()+y);
    }
    ////////////////////////////////////////////////////////////////////
    
    public AntzBot getNeighbor(int dir){
        Actor thing;
        switch (dir) {
        case 0:
            thing = getOneObjectAtOffset(0,-1,AntzBot.class);//1 up
            if(thing != null){
                return (AntzBot)thing;
            }
            thing = getOneObjectAtOffset(0,-2,AntzBot.class);//2 up
            if(thing != null){
                return (AntzBot)thing;
            }
            thing = getOneObjectAtOffset(1,-2,AntzBot.class);//2 up R
            if(thing != null){
                return (AntzBot)thing;
            }
            thing = getOneObjectAtOffset(-1,-2,AntzBot.class);//2 up L
            if(thing != null){
                return (AntzBot)thing;
            }
            thing = getOneObjectAtOffset(0,-3,AntzBot.class);//3 up
            if(thing != null){
                return (AntzBot)thing;
            }
            thing = getOneObjectAtOffset(1,-3,AntzBot.class);//3 up R
            if(thing != null){
                return (AntzBot)thing;
            }
            thing = getOneObjectAtOffset(-1,-3,AntzBot.class);//3 up L
            if(thing != null){
                return (AntzBot)thing;
            }
            break;
        case 1:
            thing = getOneObjectAtOffset(1,-1,AntzBot.class);//1 up R
            if(thing != null){
                return (AntzBot)thing;
            }
            thing = getOneObjectAtOffset(2,-1,AntzBot.class);//1 up RR
            if(thing != null){
                return (AntzBot)thing;
            }
            thing = getOneObjectAtOffset(2,-2,AntzBot.class);//2 up RR
            if(thing != null){
                return (AntzBot)thing;
            }
            thing = getOneObjectAtOffset(2,0,AntzBot.class);//RR
            if(thing != null){
                return (AntzBot)thing;
            }
            thing = getOneObjectAtOffset(3,-2,AntzBot.class);//2 up RRR
            if(thing != null){
                return (AntzBot)thing;
            }
            thing = getOneObjectAtOffset(3,-1,AntzBot.class);//1 up RRR
            if(thing != null){
                return (AntzBot)thing;
            }
            thing = getOneObjectAtOffset(3,0,AntzBot.class);//RRR
            if(thing != null){
                return (AntzBot)thing;
            }
            break;
        case 2:
            thing = getOneObjectAtOffset(1,1,AntzBot.class);//1 dwn R
            if(thing != null){
                return (AntzBot)thing;
            }
            thing = getOneObjectAtOffset(2,1,AntzBot.class);//1 dwn RR
            if(thing != null){
                return (AntzBot)thing;
            }
            thing = getOneObjectAtOffset(2,2,AntzBot.class);//2 dwn RR
            if(thing != null){
                return (AntzBot)thing;
            }
            thing = getOneObjectAtOffset(2,0,AntzBot.class);//RR
            if(thing != null){
                return (AntzBot)thing;
            }
            thing = getOneObjectAtOffset(3,2,AntzBot.class);//2 dwn RRR
            if(thing != null){
                return (AntzBot)thing;
            }
            thing = getOneObjectAtOffset(3,1,AntzBot.class);//1 dwn RRR
            if(thing != null){
                return (AntzBot)thing;
            }
            thing = getOneObjectAtOffset(3,0,AntzBot.class);//RRR
            if(thing != null){
                return (AntzBot)thing;
            }
            break;
        case 3:
            thing = getOneObjectAtOffset(0,1,AntzBot.class);//1 dwn
            if(thing != null){
                return (AntzBot)thing;
            }
            thing = getOneObjectAtOffset(0,2,AntzBot.class);//2 dwn
            if(thing != null){
                return (AntzBot)thing;
            }
            thing = getOneObjectAtOffset(1,2,AntzBot.class);//2 dwn R
            if(thing != null){
                return (AntzBot)thing;
            }
            thing = getOneObjectAtOffset(-1,2,AntzBot.class);//2 dwn L
            if(thing != null){
                return (AntzBot)thing;
            }
            thing = getOneObjectAtOffset(0,3,AntzBot.class);//3 dwn
            if(thing != null){
                return (AntzBot)thing;
            }
            thing = getOneObjectAtOffset(1,3,AntzBot.class);//3 dwn R
            if(thing != null){
                return (AntzBot)thing;
            }
            thing = getOneObjectAtOffset(-1,3,AntzBot.class);//3 dwn L
            if(thing != null){
                return (AntzBot)thing;
            }
            break;
        case 4:
            thing = getOneObjectAtOffset(-1,1,AntzBot.class);//1 dwn L
            if(thing != null){
                return (AntzBot)thing;
            }
            thing = getOneObjectAtOffset(-2,1,AntzBot.class);//1 dwn LL
            if(thing != null){
                return (AntzBot)thing;
            }
            thing = getOneObjectAtOffset(-2,2,AntzBot.class);//2 dwn LL
            if(thing != null){
                return (AntzBot)thing;
            }
            thing = getOneObjectAtOffset(-2,0,AntzBot.class);//LL
            if(thing != null){
                return (AntzBot)thing;
            }
            thing = getOneObjectAtOffset(-3,2,AntzBot.class);//2 dwn LLL
            if(thing != null){
                return (AntzBot)thing;
            }
            thing = getOneObjectAtOffset(-3,1,AntzBot.class);//1 dwn LLL
            if(thing != null){
                return (AntzBot)thing;
            }
            thing = getOneObjectAtOffset(-3,0,AntzBot.class);//LLL
            if(thing != null){
                return (AntzBot)thing;
            }
            break;
        case 5:
            thing = getOneObjectAtOffset(-1,-1,AntzBot.class);//1 up L
            if(thing != null){
                return (AntzBot)thing;
            }
            thing = getOneObjectAtOffset(-2,-1,AntzBot.class);//1 up LL
            if(thing != null){
                return (AntzBot)thing;
            }
            thing = getOneObjectAtOffset(-2,-2,AntzBot.class);//2 up LL
            if(thing != null){
                return (AntzBot)thing;
            }
            thing = getOneObjectAtOffset(-2,0,AntzBot.class);//LL
            if(thing != null){
                return (AntzBot)thing;
            }
            thing = getOneObjectAtOffset(-3,-2,AntzBot.class);//2 up LLL
            if(thing != null){
                return (AntzBot)thing;
            }
            thing = getOneObjectAtOffset(-3,-1,AntzBot.class);//1 up LLL
            if(thing != null){
                return (AntzBot)thing;
            }
            thing = getOneObjectAtOffset(-3,0,AntzBot.class);//LLL
            if(thing != null){
                return (AntzBot)thing;
            }
            break;    
        default:
             return null;
        }
        return null;
    }
}
