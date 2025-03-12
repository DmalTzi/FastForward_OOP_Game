package main;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;

public class Earth {
    public int time = 6*60;
    GamePanel gp;

    // list of location aka event
    private String[] location = {"market", "office", "supermarket", "home"};
    // bus location actual location x y
    private int[][] busLocation = {{564, 594}, {174, 448}, {720, 275}, {1089, 520}};
    private int[][] playerLocation = {{590, 540}, {320, 420}, {720, 300}, {1159, 530}};
    private int worldHeat = 0;
    int min=0,hour=0 ; 
    int Day = 0 ;
    // set currentpostion

    public Earth(GamePanel gp){
        this.gp = gp;
    }
    
    public void checkerTime(){
        if(time == 20*60){
            time = 6*60;
        }
    }

    public void draw(Graphics2D g2){
        min = getTime()%60;
        hour = getTime()/60;
        if(hour == 24) {
            increasDay(1);
            if(!gp.getPlayer().getCurrentPosition().equals("home")){ //ถ้าไม่อยู่บ้าน
                gp.player.setPlayerCoin((int)(Math.random()*gp.player.getPlayerCoin()));
                gp.player.setPlayerEmo((int)(Math.random()*20)); 
            }
            time  = 0;
            hour = 0;
            min = 0 ;
        } 
    }
    // fucking getters setters
  

    public void increaseTime(int t) {
        System.out.println("Time increase : " + t);
        time += t;
    }

    public int getTime() {
        return time;
    }

    public String[] getLocation() {
        return location;
    }

    public int[][] getBusLocation() {
        return busLocation;
    }   
    public int[] getPlayerLocation(int i){
        return playerLocation[i];
    }

    public int getEarthHeat() {
        return this.worldHeat;
    }
    public void setEarthCO2(double co2) {
        this.worldHeat += co2;
    }
    public int getMin(){
        return min ; 
    }
    public int getHour(){
        return hour ; 
    }
    public void increasDay(int n) {
        Day +=n ;
    }
    public int getDay(){
        return Day;
    }
}
