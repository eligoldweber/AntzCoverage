import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public static final int WIDTH = 60;
    public static final int HEIGHT = 60;
    /**
     * Constructor for objects of class MyWorld
     * 
     */
    public MyWorld()
    {    
   
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WIDTH, HEIGHT, 10);
        
        /**
        * Create robots; ie( robot num is num of grid of bots)
        */
        int x;
        int y;
        int id = 1;
        int robotNum = 10;
        int startX = WIDTH/2;
        int startY = HEIGHT/2;
        String wallString = "square";
        //x = (WIDTH/2)+(j);
        //y = (HEIGHT/2)+(i);
        for(int i = 0;i<robotNum;i++){
            for(int j = 0;j<robotNum;j++){
            addObject(new AntzBotCoverage(id),(WIDTH/2)+(j)+j,(HEIGHT/2)+(i)+i); 
            // if(j == 0 && i == 0){
                // addObject(new AntzBot(id),(WIDTH/2)+(j),(HEIGHT/2)+(i)); 
            // }else if(i > 0){
                 // addObject(new AntzBot(id),(WIDTH/2)+(j)+j,(HEIGHT/2)+(i)+i); 
            // }else{
                // addObject(new AntzBot(id),(WIDTH/2)+(j)+j,(HEIGHT/2)+(i)); 
            // }
            id ++;
           }
        }
        
        /**
        * Create wall
        */
       if(wallString.equals("square")){
       for(int i= 0; i<HEIGHT;i++){
           addObject(new Wall(),1,i);
           addObject(new Wall(),i,1);
        }
       for(int i= WIDTH; i>0;i--){
           addObject(new Wall(),WIDTH-2,i);
           addObject(new Wall(),i,WIDTH-2);
        }
       }else if (wallString.equals("circle")){
        for(int i=0; i<HEIGHT/2-1;i++){
           for(int j=HEIGHT/2-1; j>0;j--){
            addObject(new Wall(),i,j);
        }
        }
      }
    }
}
