package Main;

public class events {
    public double Time = 0;





    public void update(){
        Time += 0.5;
        // System.out.println(Time);
        if(Time == 24){
            Time  = 0 ;
        }
        
    }
}
