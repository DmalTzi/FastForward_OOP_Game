package main;

public class Earth {
    private double Time = 0; //1440
    
    GamePanel gp; 

    public Earth(GamePanel gp){
        this.gp = gp;
    }
    public double getTime(){
        return Time;
    }
    public void  setTime(int n){
        Time += n;
    }

    public void update(){
        // Time += 0.1;
        // System.out.println(Time);
        if((int)Time == 24){
            Time = 0;
        }
    }
}
