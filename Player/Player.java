package Player;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

import events.SuperEvents;
import main.GamePanel;
import main.GameState;
import menus.SuperMenu;

public class Player {
    GamePanel gp;
    public BufferedImage playerIm,playerIm1,playerIm2,playerIm3, remem;
    public int x ;
    public int y;
    private double coin;
    private double emotion = 100;
    private int workHr = 0;
    
    public Player (GamePanel gp){
        this.gp = gp ;

        loadPlayer();
    }




    public void update(){ //walk check bulid
         x = gp.getEarth().getPlayerLocation(Arrays.asList(gp.getEarth().getLocation()).indexOf(gp.getEarth().getCurrentPosition()))[0];
         y = gp.getEarth().getPlayerLocation(Arrays.asList(gp.getEarth().getLocation()).indexOf(gp.getEarth().getCurrentPosition()))[1];
        emotioncheck();

        
    }

    public void loadPlayer(){

         try{
            playerIm = ImageIO.read(getClass().getResourceAsStream("/res/player/Asset_78.png")); //happy
            playerIm1 = ImageIO.read(getClass().getResourceAsStream("/res/player/Asset 76.png"));//min
            playerIm2 = ImageIO.read(getClass().getResourceAsStream("/res/player/Asset 75.png"));//medium
            playerIm3= ImageIO.read(getClass().getResourceAsStream("/res/player/Asset 77.png")); //verysad

            
        }catch(IOException e){
  
            e.printStackTrace();
        }
    }

    

    public void draw(Graphics2D g2){ // วาดตัวละคร
        if(emotion > 75){
            remem = playerIm;
        }else if (emotion >51){
            remem = playerIm1;
        }else if( emotion > 26){
            remem = playerIm2;
        }else{
            remem =  playerIm3;
        }
        // System.out.println(emotion);
        g2.drawImage(remem, x,y, 80,80,null);
       
    }
    private void emotioncheck(){
        // System.out.println(emotion);
        if(emotion <= 0 ){
            gp.setgameState(GameState.Endgame);
            // gp.getMenus(3).setMenuVisible(false); //เซ็นให้หน่อย
            
        }
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
        this.emotion += emo;
    }

    public int getWorkHr() {
        return this.workHr;
    }
    public void setWorkHr(int hr) {
        this.workHr += hr;
    }
}
