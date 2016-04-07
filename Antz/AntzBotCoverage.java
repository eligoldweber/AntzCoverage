import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class AntzBot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AntzBotCoverage extends Actor
{
    
    private int id;
    private int dir = -1;
    private List neighbours;
    private AntzBotCoverage[] neighbors = new AntzBotCoverage[6];
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
    
    public AntzBotCoverage(int tId){
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

        resetNeighborhood();
        for(int i = 0;i<6;i++){
            if(getNeighbor(i) != null)
            if(!inNeighborhood(getNeighbor(i))){
                neighbors[i] = getNeighbor(i);
            }
        }
        
        // for(int i = 0;i<6;i++){ //print neighborhood
            // int num = 0;
            // if(neighbors[i] != null){
                // num = neighbors[i].getID();
            // }
            // System.out.println("I am "+id+" neighbor at " +i+ " = " +num);
        // }
        
        //System.out.println("id = " + id + " neighborNum = " + neighborNum());
        
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
            
        }else{//start to move initial
           if(!measure){

            if(neighborNum()<=3 && getID() ==1){
                                  System.out.println(flag + "asdfsasdfasdfasdfasdfasdfadsfasdfasdfasdfdfasdfasdfasdf  " + id+ "and HIGH == " + getHigh());
                //int count = 0;
                if((!isAtEdge()) && (!gotOne)){
                    setLocation(getX(), getY()-1);
                    System.out.println("!!!!!!!!!!!!!!!!!!!HERE AT NOT EDGE : " + gotOne);
                    count++;
                    temp++;
                }else{
                     System.out.println(flag + "EDGEEDGE  EDGEEDGE EDGEEDGE EDGEEDGE " + id);
                    gotOne = true;
                    //temp = count;
                }
                if(count > 0 && gotOne){
                  System.out.println("HERE AT EDGE : " + temp);
                //for(int i=0;i<count;i++){
                    setLocation(getX(), getY()+1);
                //}
                //temp --;
                count--;
                if(count == 0){
                    count = temp;
                    measure = true;
                }
                /////gotOne = false;
            }
           }
           
           if(neighborNum()<=3 && getID() == Math.sqrt(getHigh())){
                                  System.out.println(flag + "asdfsasdfasdfasdfasdfasdfadsfasdfasdfasdfdfasdfasdfasdf  " + id+ "and HIGH == " + getHigh());
                //int count = 0;
                if((!isAtEdge()) && (!gotOne)){
                    setLocation(getX()+1, getY());
                    System.out.println("!!!!!!!!!!!!!!!!!!!HERE AT NOT EDGE : " + gotOne);
                    count++;
                    temp++;
                }else{
                     System.out.println(flag + "EDGEEDGE  EDGEEDGE EDGEEDGE EDGEEDGE " + id);
                    gotOne = true;
                    //temp = count;
                }
                if(count > 0 && gotOne){
                  System.out.println("HERE AT EDGE : " + temp);
                //for(int i=0;i<count;i++){
                    setLocation(getX()-1, getY());
                //}
                //temp --;
                count--;
                if(count == 0){
                    count = temp;
                    measure = true;
                }
                /////gotOne = false;
            }
           }
                   
           if(neighborNum()<=3 && (getID()==(getHigh()-Math.sqrt(getHigh()))+1)){
                                  System.out.println(flag + "asdfsasdfasdfasdfasdfasdfadsfasdfasdfasdfdfasdfasdfasdf  " + id+ "and HIGH == " + getHigh());
                //int count = 0;
                if((!isAtEdge()) && (!gotOne)){
                    setLocation(getX()-1, getY());
                    System.out.println("!!!!!!!!!!!!!!!!!!!HERE AT NOT EDGE : " + gotOne);
                    count++;
                    temp++;
                }else{
                     System.out.println(flag + "EDGEEDGE  EDGEEDGE EDGEEDGE EDGEEDGE " + id);
                    gotOne = true;
                    //temp = count;
                    
                }
                if(count > 0 && gotOne){
                  System.out.println("HERE AT EDGE : " + temp);
                //for(int i=0;i<count;i++){
                    setLocation(getX()+1, getY());
                //}
                //temp --;
                count--;
                if(count == 0){
                    count = temp;
                    measure = true;
                }
                /////gotOne = false;
            }
           }
            if(neighborNum()<=3 && getID() == getHigh()){
                                  System.out.println(flag + "asdfsasdfasdfasdfasdfasdfadsfasdfasdfasdfdfasdfasdfasdf  " + id + "and HIGH == " + getHigh());
                //int count = 0;
                if((!isAtEdge()) && (!gotOne)){
                    setLocation(getX(), getY()+1);
                    System.out.println("!!!!!!!!!!!!!!!!!!!HERE AT NOT EDGE : " + gotOne);
                    count++;
                    temp++;
                }else{
                     System.out.println(flag + "EDGEEDGE  EDGEEDGE EDGEEDGE EDGEEDGE " + id);
                    gotOne = true;
                   // temp = count;
                }
                if(count > 0 && gotOne){
                  System.out.println("HERE AT EDGE : " + temp);
                //for(int i=0;i<count;i++){
                    setLocation(getX(), getY()-1);
                //}
                //temp --;
                count--;
                if(count == 0){
                    count = temp;
                    System.out.println("*******************&****** "+ temp);
                    measure = true;
                }
                /////gotOne = false;
            }
           }
        }else{//splitup
            
            System.out.println("CALCULATEW !@!@!@!@#$##$#$%^%^%&*&*&()()(( " + id + " my count is " + count);
            for(int i = 0; i <6;i++){
            if(neighbors[i] != null && 
            (!(neighbors[i].getID() ==1 || neighbors[i].getID() == Math.sqrt(getHigh()) || 
            (neighbors[i].getID()==(getHigh()-Math.sqrt(getHigh()))+1) || neighbors[i].getID() == getHigh()))){
                neighbors[i].triggerMeasure();
            }
        }
        if(neighborNum()<=3 && getID() ==1){
            topY = count;
        }
        if(neighborNum()<=3 && getID() == Math.sqrt(getHigh())){
            rightX = count;
        }
        if(neighborNum()<=3 && (getID()==(getHigh()-Math.sqrt(getHigh()))+1)){
            leftX = count;
        }
        if(neighborNum()<=3 && getID() == getHigh()){
            botY = count;
        }
        
        passInfo(neighbors);
        setMidDist();
        if(gotAllInfo()){
            calculateTotal();
            calculatePosition();
            System.out.println("my real x is " + getX() + "i am at " + foundX);
            System.out.println("my real y is " + getY() + "i am at " + foundY);
            newX = calcX();
            newY = calcY();
           //if(newX != getX() || newY != getY()){
             if(newX != foundX || newY != foundY){
               goToNewPos();
            }
            // if(getID() <= getHigh()/2){
           // for(int t=1;t<=Math.sqrt(getHigh())/2;t++){
            // if((getID() % (Math.sqrt(getHigh())) == t)){
                 // setLocation(getX(), getY()-1);
            // }
        // }
        // }else if(getID() > getHigh()/2){
            // for(int t=(int)((Math.sqrt(getHigh())/2)+1);t<=Math.sqrt(getHigh());t++){
            // if((getID() % (Math.sqrt(getHigh())) == t) ||(getID() % (Math.sqrt(getHigh())) == 0)){
                 // setLocation(getX(), getY()+1);
            // }
        // }
    // }
            }
        
        System.out.println("ID = "  + id + " total x = "+ totalX + " toatal y = " + totalY); 
        System.out.println("ID = "  + id + " new x = "+ newX + " new y = " + newY); 
                System.out.println("ID = "  + id + " current x = "+ getX() + " current y = " + getY()); 
        
       
        
        
    }
        
        
        }
        
        
       
        
       ////Share environment results
      
        //setLocation(getX(), getY()+dir);
       
    }    
    
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
        
        foundX = leftX + xOffset;
        foundY = topY + yOffset;
    }
    public boolean gotAllInfo(){
        if(topY > 0 && botY > 0 && rightX > 0 && leftX > 0){
            return true;
        }
        else 
            return false;
    }
    public void passInfo(AntzBotCoverage[] neighbors){
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
    public void setHigh(AntzBotCoverage[] neighbors){
        for(int i = 0; i <6;i++){
            if(neighbors[i] != null && neighbors[i].getHigh() > getHigh()){
                highN = neighbors[i].getHigh();
            }
        }
    }
    public void setHighStart(AntzBotCoverage[] neighbors){
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

    public boolean inNeighborhood(AntzBotCoverage temp){
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
    
    public AntzBotCoverage getNeighbor(int dir){
        Actor thing;
        switch (dir) {
        case 0:
            thing = getOneObjectAtOffset(0,-1,AntzBotCoverage.class);//1 up
            if(thing != null){
                return (AntzBotCoverage)thing;
            }
            thing = getOneObjectAtOffset(0,-2,AntzBotCoverage.class);//2 up
            if(thing != null){
                return (AntzBotCoverage)thing;
            }
            thing = getOneObjectAtOffset(1,-2,AntzBotCoverage.class);//2 up R
            if(thing != null){
                return (AntzBotCoverage)thing;
            }
            thing = getOneObjectAtOffset(-1,-2,AntzBotCoverage.class);//2 up L
            if(thing != null){
                return (AntzBotCoverage)thing;
            }
            thing = getOneObjectAtOffset(0,-3,AntzBotCoverage.class);//3 up
            if(thing != null){
                return (AntzBotCoverage)thing;
            }
            thing = getOneObjectAtOffset(1,-3,AntzBotCoverage.class);//3 up R
            if(thing != null){
                return (AntzBotCoverage)thing;
            }
            thing = getOneObjectAtOffset(-1,-3,AntzBotCoverage.class);//3 up L
            if(thing != null){
                return (AntzBotCoverage)thing;
            }
            break;
        case 1:
            thing = getOneObjectAtOffset(1,-1,AntzBotCoverage.class);//1 up R
            if(thing != null){
                return (AntzBotCoverage)thing;
            }
            thing = getOneObjectAtOffset(2,-1,AntzBotCoverage.class);//1 up RR
            if(thing != null){
                return (AntzBotCoverage)thing;
            }
            thing = getOneObjectAtOffset(2,-2,AntzBotCoverage.class);//2 up RR
            if(thing != null){
                return (AntzBotCoverage)thing;
            }
            thing = getOneObjectAtOffset(2,0,AntzBotCoverage.class);//RR
            if(thing != null){
                return (AntzBotCoverage)thing;
            }
            thing = getOneObjectAtOffset(3,-2,AntzBotCoverage.class);//2 up RRR
            if(thing != null){
                return (AntzBotCoverage)thing;
            }
            thing = getOneObjectAtOffset(3,-1,AntzBotCoverage.class);//1 up RRR
            if(thing != null){
                return (AntzBotCoverage)thing;
            }
            thing = getOneObjectAtOffset(3,0,AntzBotCoverage.class);//RRR
            if(thing != null){
                return (AntzBotCoverage)thing;
            }
            break;
        case 2:
            thing = getOneObjectAtOffset(1,1,AntzBotCoverage.class);//1 dwn R
            if(thing != null){
                return (AntzBotCoverage)thing;
            }
            thing = getOneObjectAtOffset(2,1,AntzBotCoverage.class);//1 dwn RR
            if(thing != null){
                return (AntzBotCoverage)thing;
            }
            thing = getOneObjectAtOffset(2,2,AntzBotCoverage.class);//2 dwn RR
            if(thing != null){
                return (AntzBotCoverage)thing;
            }
            thing = getOneObjectAtOffset(2,0,AntzBotCoverage.class);//RR
            if(thing != null){
                return (AntzBotCoverage)thing;
            }
            thing = getOneObjectAtOffset(3,2,AntzBotCoverage.class);//2 dwn RRR
            if(thing != null){
                return (AntzBotCoverage)thing;
            }
            thing = getOneObjectAtOffset(3,1,AntzBotCoverage.class);//1 dwn RRR
            if(thing != null){
                return (AntzBotCoverage)thing;
            }
            thing = getOneObjectAtOffset(3,0,AntzBotCoverage.class);//RRR
            if(thing != null){
                return (AntzBotCoverage)thing;
            }
            break;
        case 3:
            thing = getOneObjectAtOffset(0,1,AntzBotCoverage.class);//1 dwn
            if(thing != null){
                return (AntzBotCoverage)thing;
            }
            thing = getOneObjectAtOffset(0,2,AntzBotCoverage.class);//2 dwn
            if(thing != null){
                return (AntzBotCoverage)thing;
            }
            thing = getOneObjectAtOffset(1,2,AntzBotCoverage.class);//2 dwn R
            if(thing != null){
                return (AntzBotCoverage)thing;
            }
            thing = getOneObjectAtOffset(-1,2,AntzBotCoverage.class);//2 dwn L
            if(thing != null){
                return (AntzBotCoverage)thing;
            }
            thing = getOneObjectAtOffset(0,3,AntzBotCoverage.class);//3 dwn
            if(thing != null){
                return (AntzBotCoverage)thing;
            }
            thing = getOneObjectAtOffset(1,3,AntzBotCoverage.class);//3 dwn R
            if(thing != null){
                return (AntzBotCoverage)thing;
            }
            thing = getOneObjectAtOffset(-1,3,AntzBotCoverage.class);//3 dwn L
            if(thing != null){
                return (AntzBotCoverage)thing;
            }
            break;
        case 4:
            thing = getOneObjectAtOffset(-1,1,AntzBotCoverage.class);//1 dwn L
            if(thing != null){
                return (AntzBotCoverage)thing;
            }
            thing = getOneObjectAtOffset(-2,1,AntzBotCoverage.class);//1 dwn LL
            if(thing != null){
                return (AntzBotCoverage)thing;
            }
            thing = getOneObjectAtOffset(-2,2,AntzBotCoverage.class);//2 dwn LL
            if(thing != null){
                return (AntzBotCoverage)thing;
            }
            thing = getOneObjectAtOffset(-2,0,AntzBotCoverage.class);//LL
            if(thing != null){
                return (AntzBotCoverage)thing;
            }
            thing = getOneObjectAtOffset(-3,2,AntzBotCoverage.class);//2 dwn LLL
            if(thing != null){
                return (AntzBotCoverage)thing;
            }
            thing = getOneObjectAtOffset(-3,1,AntzBotCoverage.class);//1 dwn LLL
            if(thing != null){
                return (AntzBotCoverage)thing;
            }
            thing = getOneObjectAtOffset(-3,0,AntzBotCoverage.class);//LLL
            if(thing != null){
                return (AntzBotCoverage)thing;
            }
            break;
        case 5:
            thing = getOneObjectAtOffset(-1,-1,AntzBotCoverage.class);//1 up L
            if(thing != null){
                return (AntzBotCoverage)thing;
            }
            thing = getOneObjectAtOffset(-2,-1,AntzBotCoverage.class);//1 up LL
            if(thing != null){
                return (AntzBotCoverage)thing;
            }
            thing = getOneObjectAtOffset(-2,-2,AntzBotCoverage.class);//2 up LL
            if(thing != null){
                return (AntzBotCoverage)thing;
            }
            thing = getOneObjectAtOffset(-2,0,AntzBotCoverage.class);//LL
            if(thing != null){
                return (AntzBotCoverage)thing;
            }
            thing = getOneObjectAtOffset(-3,-2,AntzBotCoverage.class);//2 up LLL
            if(thing != null){
                return (AntzBotCoverage)thing;
            }
            thing = getOneObjectAtOffset(-3,-1,AntzBotCoverage.class);//1 up LLL
            if(thing != null){
                return (AntzBotCoverage)thing;
            }
            thing = getOneObjectAtOffset(-3,0,AntzBotCoverage.class);//LLL
            if(thing != null){
                return (AntzBotCoverage)thing;
            }
            break;    
        default:
             return null;
        }
        return null;
    }
}
