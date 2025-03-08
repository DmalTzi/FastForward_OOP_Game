package main;

public class Earth {
    public double Time = 0;
    GamePanel gp;

    // list of location aka event
    private String[] location = {"market", "office", "supermarket", "home"};
    // bus location actual location x y
    private int[][] busLocation = {{564, 594}, {174, 448}, {720, 275}, {1089, 520}};
    // set currentpostion
    private String currentPosition = "home";

    public Earth(GamePanel gp){
        this.gp = gp;
    }

    public void update(){
        Time += 0.1;
        // System.out.println(Time);
        if((int)Time == 24){
            Time = 0;
        }
    }

    // fucking getters setters
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
}
