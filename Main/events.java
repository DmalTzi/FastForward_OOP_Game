package Main;

public class events {
    public double Time = 0;





    public void update(){
        Time += 0.1;
        System.out.println(Time);
        if((int)Time == 24){
            Time  = 0 ;
        }
        
    }
}
