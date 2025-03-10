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
    private int[][] playerLocation = {{530, 540}, {320, 420}, {720, 300}, {1089, 550}};
    private int worldHeat = 0;
    // set currentpostion
    private String currentPosition = "home";
    private String moveWith = "legs";

    private double co2 = 0;

    public Earth(GamePanel gp){
        this.gp = gp;
    }
    
    public void checkerTime(){
        if(time == 20*60){
            time = 6*60;
        }
    }

    public void draw(Graphics2D g2){
            g2.setFont(g2.getFont().deriveFont(Font.TYPE1_FONT,50F));
            int m = getTime()%60;
            int h = getTime()/60;
            g2.getFontMetrics().getStringBounds(Integer.toString(h)+":"+Integer.toString(m), g2).getWidth();
            g2.draw(gp.getBounds());
            g2.setColor(Color.RED);
            g2.drawString(Integer.toString(h)+":"+Integer.toString(m), 600, 100);

    }
    // fucking getters setters
    public void increaseHeat(int h) {
        worldHeat += h;
    }

    public void increaseTime(int t) {
        System.out.println("increase : " + t);
        time += t;
    }

    public int getWorldHeat() {
        return worldHeat;
    }

    public int getTime() {
        return time;
    }

    public String[] getLocation() {
        return location;
    }

    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }

    public int[][] getBusLocation() {
        return busLocation;
    }   
    public int[] getPlayerLocation(int i){
        return playerLocation[i];
    }
    public String getCurrentPosition() {
        return currentPosition;
    }

    public String getMoveWith() {
        return moveWith;
    }

    public double getEarthCO2() {
        return this.co2;
    }
    public void setEarthCO2(double co2) {
        this.co2 += co2;
    }
}
