package Main;

public class events {
    public double Time = 0;
    GamePanel gp ; 

    public events(GamePanel gp){
        this.gp = gp ;
    }



    public void update(){
        Time += 0.5;
        System.out.println(Time);
        if(Time == 24){
            Time  = 0 ;
        }
        
    }
}
