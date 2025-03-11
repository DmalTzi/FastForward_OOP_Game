package Player;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
    private int speedup = 0 ;
    private String[] inventory = new String[2];
    private Map<String,int[]> activityHome = new HashMap<>();
    private Map<String,int[]> activityMarket = new HashMap<>();
    private Map<String,int[]> activitySuper = new HashMap<>();


    public Player (GamePanel gp){
        this.gp = gp ;
        loadPlayer();
        loadAsset();
    }




    public void update(){ //walk check bulid
        MoveTo();
        emotioncheck();

        System.out.println( coin);
    }   
    public void loadAsset(){
        activityHome.put("Movie",new int[]{20,25,-60}); // emo 1 c02  2 coin
        activityHome.put("Exercise",new int[]{10,15,-10});
        activityHome.put("Game",new int[]{20,30,-50});
        activityHome.put("Plante",new int[]{25,-20,-5});
        activityHome.put("ReadBk",new int[]{15,10,-10});
        activityHome.put("Sleep",new int[]{25,5,0});

        activityMarket.put("Apple", new int[]{5,5,-10});
        activityMarket.put("Water", new int[]{2,5,-10});
        activityMarket.put("Coke", new int[]{3,15,-15});
        activityMarket.put("Mama", new int[]{10,15,-20});
        activityMarket.put("Egg_fried", new int[]{15,20,-25});

       activitySuper.put("Pizza", new int[] {20,30,-50});
       activitySuper.put("Hamburger", new int[] {20,30,-50});
       activitySuper.put("Fried", new int[] {15,25,-35});
       activitySuper.put("Car", new int[] {30,20,-1200});
       activitySuper.put("Jakayan", new int[] {25,5,-500});
       




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
            gp.getEvents(Arrays.asList(gp.getEarth().getLocation()).indexOf(gp.getEarth().getCurrentPosition())+4)
            .setMenuVisible(false); //เซ็นให้หน่อย
            
        }
    }
    public void MoveTo(){
        x = gp.getEarth().getPlayerLocation(Arrays.asList(gp.getEarth().getLocation()).indexOf(gp.getEarth().getCurrentPosition()))[0];
        y = gp.getEarth().getPlayerLocation(Arrays.asList(gp.getEarth().getLocation()).indexOf(gp.getEarth().getCurrentPosition()))[1];
    }
    
    public void buyCar(String name , int index){
        inventory[index] = name;
    }
    public void work(int amount){
        setPlayerCoin(amount * 50);
        increasePlayerEmo(-amount*15);
        gp.getEarth().setEarthCO2(amount*15);
    }
    public void equip(String vehicle){

    }
    public void Activity(String n){

    }
    public void buy(String foodname ,int amount){

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
    public void increasePlayerEmo(double emo) { // ใช้เพิ่ม ลด
        this.emotion += emo;
    }
    public void setPlayerEmo(int n){
        this.coin = n;
    }

    public int getWorkHr() {
        return this.workHr;
    }
    public void setWorkHr(int hr) {
        this.workHr += hr;
    }
}
