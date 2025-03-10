package Player;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Player {
    GamePanel gp;
    public BufferedImage playerIm;
    public int x ;
    public int y;
    private double coin;
    private double emotion = 100;
    private int workHr = 0;
    
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
    
    public double getPlayerCoin() {
        return this.coin;
    }
    public void setPlayerCoin(double coin) {
        this.coin += coin;
    }

    public double getPlayerEmo() {
        return this.emotion;
    }
    public void setPlayerEmo(double emo) {
        this.emotion -= emo;
    }

    public int getWorkHr() {
        return this.workHr;
    }
    public void setWorkHr(int hr) {
        this.workHr += hr;
    }
}
