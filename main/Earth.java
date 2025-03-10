package main;

public class Earth {
    public int time = 6*60;
    GamePanel gp;

    // list of location aka event
    private String[] location = {"market", "office", "supermarket", "home"};
    // bus location actual location x y
    private int[][] busLocation = {{564, 594}, {174, 448}, {720, 275}, {1089, 520}};
    private int[][] playerLocation = {{564, 594}, {174, 448}, {720, 275}, {1089, 520}};
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
