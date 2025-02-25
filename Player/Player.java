package Player;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Main.GamePanel;

public class Player {
    GamePanel gp;
    public BufferedImage playerIm;
    public int x ;
    public int y;
    
    public Player (GamePanel gp){
        this.gp = gp ;
         x  = gp.screenWidth/2;
         y = gp.screenHeight/2;

        loadPlayer();
    }




    public void update(){ //walk check bulid
 
    
  
    }

    public void loadPlayer(){

         try{
            playerIm = ImageIO.read(getClass().getResourceAsStream("/res/player/pngegg.png"));
           
        }catch(IOException e){
  
            e.printStackTrace();
        }
    }

    

    public void draw(Graphics2D g2){ // วาดตัวละคร
     
        g2.drawImage(playerIm, x,y, 60,60,null);
       
    } 
}
