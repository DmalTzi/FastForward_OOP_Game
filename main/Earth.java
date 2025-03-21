package main;
import java.awt.Graphics2D;
import java.util.Arrays;
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
    int min = 0,hour = 0 ; 
    int Day = 1 ;
    int dayFinish = 7;
    // set currentpostion
    private String moveWith = "legs";

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
        if(getTime() >= 24*60) {
            gp.getPlayer().sleep("Sleep");
            if(!gp.getPlayer().getCurrentPosition().equals("home")){ //ถ้าไม่อยู่บ้าน
                gp.getPlayer().setPlayerCoinss((int)(Math.random()*gp.getPlayer().getPlayerCoin()));
                gp.getPlayer().setPlayerEmo((int)(Math.random()*20)); 
                gp.getPlayer().setCurrentPosition("home");
            }
        }
    }
    // fucking getters setters
    public void Checkworld(){
        // System.out.println(worldHeat);
        if(worldHeat < 0 ){
            worldHeat = 0;
        }
        if (worldHeat > 200){
            gp.setgameState(GameState.Endgame_2);
             Arrays.asList(gp.getAllEvents()).forEach(e -> {
                if (e != null)
                    e.setMenuVisible(false);
            });
            gp.getBagEvents(0).getBag().setVisible(false);
            gp.getBagEvents(0).getBagMenu().getMenu().setVisible(false);
        }

        if (Day >= dayFinish){
            gp.setgameState(GameState.GoodEnd);
            Arrays.asList(gp.getAllEvents()).forEach(e -> {
                if (e != null)
                    e.setMenuVisible(false);
            });
            gp.getBagEvents(0).getBag().setVisible(false);
            gp.getBagEvents(0).getBagMenu().getMenu().setVisible(false);
        }
    }

    public void increaseTime(int t) {
        // System.out.println("Time increase : " + t);
        time += t;
    }

    public int getTime() {
        return time;
    }

    public String[] getLocation() {
        return location;
    }

    public void increaseDay(int day) {
        Day++;
    }

    public int[][] getBusLocation() {
        return busLocation;
    }   
    public int[] getPlayerLocation(int i){
        return playerLocation[i];
    }

    public String getMoveWith() {
        return moveWith;
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

    public void earthReset() {
        this.Day = 1;
        this.worldHeat = 0;
        this.time = 6*60;
        this.hour = 0;
        this.min = 0;
    }
}
