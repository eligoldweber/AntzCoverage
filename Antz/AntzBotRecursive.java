import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class AntzBot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AntzBotRecursive extends Actor
{
    
    private int id;
    private int dir = -1;
    private List neighbours;
    private AntzBotRecursive[] neighbors = new AntzBotRecursive[6];
    int highN;
    boolean flag;
    boolean gotOne;
    int count = 0;
    int temp = 0;
    
    int totalX = -1;
    int totalY = -1;
    int midX = -1;
    int midY = -1;
    int topY = -1;
    int botY = -1;
    int leftX = -1;
    int rightX = -1;
    int newX = 0;
    int newY = 0;
    int foundX = 0;
    int foundY = 0;
    boolean measure = false;
    
    //////
    int startSize = 0;
    
    public AntzBotRecursive(int tId){
        id = tId;
        GreenfootImage image = getImage();
        System.out.println("id is" + id);
        image.scale(image.getWidth()-90, image.getHeight()-90);
        setImage(image);
        //highN = id;
        highN = -1;
        flag = false;
        gotOne = false;
        
    }
    /**
     * Act - do whatever the AntzBot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       // System.out.println("STATRT");

        resetNeighborhood();
        for(int i = 0;i<6;i++){
            if(getNeighbor(i) != null)
            if(!inNeighborhood(getNeighbor(i))){
                neighbors[i] = getNeighbor(i);
            }
        }
        
        if((!flag) ){ //FIX
   
            
        setHighStart(neighbors);
        setHigh(neighbors);
            ////////System.out.println("id = " + id + " higsadasDasdasDasdsaDh = " + highN);
            //if(highN == 25){
             if(highN > 0){
                flag = true;
            }
            // if((getID() == 1 )&& (flag)){
                // gotOne = true;
            // }
            
        }else{

            calculatePosition();
            System.out.println("id = " + id + " high = " + highN + " x,y = " + foundX + " , " +foundY);
            
        }
        
        
       
    }    
    ////////
    
    public void calculatePositionNew(int size){///use!!!!
        int x;
        int y;
        int xOffset = 0;
        int yOffset = 0;
        int t = 0;
        for(int i=1;i<getHigh()+1;i++){ //find yOffset
            if(i == getID()){
            yOffset = (t*2);
        }
            if(i%(Math.sqrt(getHigh()))==0){
                t++;
                //System.out.println("t = " + t +" arfgafadsfasdfas "); 
            }
        }
        
        
        if((getID() % (Math.sqrt(getHigh()))) == 0){
             xOffset = ((int)(Math.sqrt(getHigh()))-1)*2 ;
        }else{
            xOffset = ((int)(getID() % (Math.sqrt(getHigh())))-1)*2;
        }
        
        foundX =  xOffset;
        foundY =  yOffset;
    }
    public int calcXnew(int x){
        int space = (x/(int)(Math.sqrt(getHigh())+1));
        int returnNum;
        if((getID() % (Math.sqrt(getHigh()))) == 0){
             returnNum = (int)(Math.sqrt(getHigh()))*(int)space;
        }else{
         returnNum = (int)(getID() % (Math.sqrt(getHigh())))*(int)space;
    }
        
        return returnNum;
    }
    public int calcYnew(int y){
        int space = (y/(int)(Math.sqrt(getHigh())+1));
        int t = 1;
        int returnNum = 0;
        for(int i=1;i<getHigh()+1;i++){
            if(i == getID()){
            returnNum = t*space;
        }
            if(i%(Math.sqrt(getHigh()))==0){
                t++;
                //System.out.println("t = " + t +" arfgafadsfasdfas "); 
            }
        }
         //returnNum = getID()*space;
        return returnNum;
    }
    
    
    ////////
    public void goToNewPos(){
        System.out.println("ID = " +getID() + "  HERERE " + newX + " OROROROR "  + getX() ); 
        if(newX > getX()){
            setLocation(getX()+1, getY());
            foundX++;
        }else if((newX < getX())){
            setLocation(getX()-1, getY());
            foundX--;
        }
        if(newY > getY()){
            setLocation(getX(), getY()+1);
            foundY++;
        }else if((newY < getY())){
            setLocation(getX(), getY()-1);
            foundY--;
        }
        
    }
    public int calcX(){
        int space = (totalX/(int)(Math.sqrt(getHigh())+1));
        int returnNum;
        if((getID() % (Math.sqrt(getHigh()))) == 0){
             returnNum = (int)(Math.sqrt(getHigh()))*(int)space;
        }else{
         returnNum = (int)(getID() % (Math.sqrt(getHigh())))*(int)space;
    }
        
        return returnNum;
    }
    public int calcY(){
        int space = (totalX/(int)(Math.sqrt(getHigh())+1));
        int t = 1;
        int returnNum = 0;
        for(int i=1;i<getHigh()+1;i++){
            if(i == getID()){
            returnNum = t*space;
        }
            if(i%(Math.sqrt(getHigh()))==0){
                t++;
                //System.out.println("t = " + t +" arfgafadsfasdfas "); 
            }
        }
         //returnNum = getID()*space;
        return returnNum;
    }
    public void calculateTotal(){
        totalX = rightX + leftX + midX;
        totalY = topY + botY + midY;
    }
    public void calculatePosition(){///use!!!!
        int x;
        int y;
        int xOffset = 0;
        int yOffset = 0;
        int t = 0;
        for(int i=1;i<getHigh()+1;i++){ //find yOffset
            if(i == getID()){
            yOffset = (t*2);
        }
            if(i%(Math.sqrt(getHigh()))==0){
                t++;
                //System.out.println("t = " + t +" arfgafadsfasdfas "); 
            }
        }
        
        
        if((getID() % (Math.sqrt(getHigh()))) == 0){
             xOffset = ((int)(Math.sqrt(getHigh()))-1)*2 ;
        }else{
            xOffset = ((int)(getID() % (Math.sqrt(getHigh())))-1)*2;
        }
        
        foundX =  xOffset;
        foundY =  yOffset;
    }
    public boolean gotAllInfo(){
        if(topY > 0 && botY > 0 && rightX > 0 && leftX > 0){
            return true;
        }
        else 
            return false;
    }
    public void passInfo(AntzBotRecursive[] neighbors){
        int tYup = topY;
        int tYdown = botY;
        int tXright = rightX;
        int tXleft = rightX;
        for(int i = 0; i <6;i++){
            if(neighbors[i] != null){
               if(neighbors[i].topY < topY){
                   neighbors[i].topY = topY;
                }
                if(neighbors[i].botY < botY){
                   neighbors[i].botY = botY;
                }
                if(neighbors[i].rightX < rightX){
                   neighbors[i].rightX = rightX;
                }
                if(neighbors[i].leftX < leftX){
                   neighbors[i].leftX = leftX;
                }
            }
        }
    }
    public void setMidDist(){
        double num = Math.sqrt(getHigh());
        num = num+(num-1);
        midX = (int)num;
        midY = (int)num;
        
    }
    public void triggerMeasure(){
        measure = true;
    }
    public int getHigh(){
        return highN;
    }
    public void setHigh(AntzBotRecursive[] neighbors){
        for(int i = 0; i <6;i++){
            if(neighbors[i] != null && neighbors[i].getHigh() > getHigh()){
                highN = neighbors[i].getHigh();
            }
        }
    }
    public void setHighStart(AntzBotRecursive[] neighbors){
        int highest = getID();
        for(int i = 0; i <6;i++){
            if(neighbors[i] != null && neighbors[i].getID() > highest){
                highest = neighbors[i].getID();
            }
        }
        if(highest == getID()){
            highN = getID();
        }
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

    public boolean inNeighborhood(AntzBotRecursive temp){
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
    
    public AntzBotRecursive getNeighbor(int dir){
        Actor thing;
        switch (dir) {
        case 0:
            thing = getOneObjectAtOffset(0,-1,AntzBotRecursive.class);//1 up
            if(thing != null){
                return (AntzBotRecursive)thing;
            }
            thing = getOneObjectAtOffset(0,-2,AntzBotRecursive.class);//2 up
            if(thing != null){
                return (AntzBotRecursive)thing;
            }
            thing = getOneObjectAtOffset(1,-2,AntzBotRecursive.class);//2 up R
            if(thing != null){
                return (AntzBotRecursive)thing;
            }
            thing = getOneObjectAtOffset(-1,-2,AntzBotRecursive.class);//2 up L
            if(thing != null){
                return (AntzBotRecursive)thing;
            }
            thing = getOneObjectAtOffset(0,-3,AntzBotRecursive.class);//3 up
            if(thing != null){
                return (AntzBotRecursive)thing;
            }
            thing = getOneObjectAtOffset(1,-3,AntzBotRecursive.class);//3 up R
            if(thing != null){
                return (AntzBotRecursive)thing;
            }
            thing = getOneObjectAtOffset(-1,-3,AntzBotRecursive.class);//3 up L
            if(thing != null){
                return (AntzBotRecursive)thing;
            }
            break;
        case 1:
            thing = getOneObjectAtOffset(1,-1,AntzBotRecursive.class);//1 up R
            if(thing != null){
                return (AntzBotRecursive)thing;
            }
            thing = getOneObjectAtOffset(2,-1,AntzBotRecursive.class);//1 up RR
            if(thing != null){
                return (AntzBotRecursive)thing;
            }
            thing = getOneObjectAtOffset(2,-2,AntzBotRecursive.class);//2 up RR
            if(thing != null){
                return (AntzBotRecursive)thing;
            }
            thing = getOneObjectAtOffset(2,0,AntzBotRecursive.class);//RR
            if(thing != null){
                return (AntzBotRecursive)thing;
            }
            thing = getOneObjectAtOffset(3,-2,AntzBotRecursive.class);//2 up RRR
            if(thing != null){
                return (AntzBotRecursive)thing;
            }
            thing = getOneObjectAtOffset(3,-1,AntzBotRecursive.class);//1 up RRR
            if(thing != null){
                return (AntzBotRecursive)thing;
            }
            thing = getOneObjectAtOffset(3,0,AntzBotRecursive.class);//RRR
            if(thing != null){
                return (AntzBotRecursive)thing;
            }
            break;
        case 2:
            thing = getOneObjectAtOffset(1,1,AntzBotRecursive.class);//1 dwn R
            if(thing != null){
                return (AntzBotRecursive)thing;
            }
            thing = getOneObjectAtOffset(2,1,AntzBotRecursive.class);//1 dwn RR
            if(thing != null){
                return (AntzBotRecursive)thing;
            }
            thing = getOneObjectAtOffset(2,2,AntzBotRecursive.class);//2 dwn RR
            if(thing != null){
                return (AntzBotRecursive)thing;
            }
            thing = getOneObjectAtOffset(2,0,AntzBotRecursive.class);//RR
            if(thing != null){
                return (AntzBotRecursive)thing;
            }
            thing = getOneObjectAtOffset(3,2,AntzBotRecursive.class);//2 dwn RRR
            if(thing != null){
                return (AntzBotRecursive)thing;
            }
            thing = getOneObjectAtOffset(3,1,AntzBotRecursive.class);//1 dwn RRR
            if(thing != null){
                return (AntzBotRecursive)thing;
            }
            thing = getOneObjectAtOffset(3,0,AntzBotRecursive.class);//RRR
            if(thing != null){
                return (AntzBotRecursive)thing;
            }
            break;
        case 3:
            thing = getOneObjectAtOffset(0,1,AntzBotRecursive.class);//1 dwn
            if(thing != null){
                return (AntzBotRecursive)thing;
            }
            thing = getOneObjectAtOffset(0,2,AntzBotRecursive.class);//2 dwn
            if(thing != null){
                return (AntzBotRecursive)thing;
            }
            thing = getOneObjectAtOffset(1,2,AntzBotRecursive.class);//2 dwn R
            if(thing != null){
                return (AntzBotRecursive)thing;
            }
            thing = getOneObjectAtOffset(-1,2,AntzBotRecursive.class);//2 dwn L
            if(thing != null){
                return (AntzBotRecursive)thing;
            }
            thing = getOneObjectAtOffset(0,3,AntzBotRecursive.class);//3 dwn
            if(thing != null){
                return (AntzBotRecursive)thing;
            }
            thing = getOneObjectAtOffset(1,3,AntzBotRecursive.class);//3 dwn R
            if(thing != null){
                return (AntzBotRecursive)thing;
            }
            thing = getOneObjectAtOffset(-1,3,AntzBotRecursive.class);//3 dwn L
            if(thing != null){
                return (AntzBotRecursive)thing;
            }
            break;
        case 4:
            thing = getOneObjectAtOffset(-1,1,AntzBotRecursive.class);//1 dwn L
            if(thing != null){
                return (AntzBotRecursive)thing;
            }
            thing = getOneObjectAtOffset(-2,1,AntzBotRecursive.class);//1 dwn LL
            if(thing != null){
                return (AntzBotRecursive)thing;
            }
            thing = getOneObjectAtOffset(-2,2,AntzBotRecursive.class);//2 dwn LL
            if(thing != null){
                return (AntzBotRecursive)thing;
            }
            thing = getOneObjectAtOffset(-2,0,AntzBotRecursive.class);//LL
            if(thing != null){
                return (AntzBotRecursive)thing;
            }
            thing = getOneObjectAtOffset(-3,2,AntzBotRecursive.class);//2 dwn LLL
            if(thing != null){
                return (AntzBotRecursive)thing;
            }
            thing = getOneObjectAtOffset(-3,1,AntzBotRecursive.class);//1 dwn LLL
            if(thing != null){
                return (AntzBotRecursive)thing;
            }
            thing = getOneObjectAtOffset(-3,0,AntzBotRecursive.class);//LLL
            if(thing != null){
                return (AntzBotRecursive)thing;
            }
            break;
        case 5:
            thing = getOneObjectAtOffset(-1,-1,AntzBotRecursive.class);//1 up L
            if(thing != null){
                return (AntzBotRecursive)thing;
            }
            thing = getOneObjectAtOffset(-2,-1,AntzBotRecursive.class);//1 up LL
            if(thing != null){
                return (AntzBotRecursive)thing;
            }
            thing = getOneObjectAtOffset(-2,-2,AntzBotRecursive.class);//2 up LL
            if(thing != null){
                return (AntzBotRecursive)thing;
            }
            thing = getOneObjectAtOffset(-2,0,AntzBotRecursive.class);//LL
            if(thing != null){
                return (AntzBotRecursive)thing;
            }
            thing = getOneObjectAtOffset(-3,-2,AntzBotRecursive.class);//2 up LLL
            if(thing != null){
                return (AntzBotRecursive)thing;
            }
            thing = getOneObjectAtOffset(-3,-1,AntzBotRecursive.class);//1 up LLL
            if(thing != null){
                return (AntzBotRecursive)thing;
            }
            thing = getOneObjectAtOffset(-3,0,AntzBotRecursive.class);//LLL
            if(thing != null){
                return (AntzBotRecursive)thing;
            }
            break;    
        default:
             return null;
        }
        return null;
    }
}
