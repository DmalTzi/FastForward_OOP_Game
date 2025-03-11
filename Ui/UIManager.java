package Ui;

import java.awt.Font;
import java.awt.Graphics2D;

import main.GamePanel;

public class UIManager extends BackgroundManager {

    public UIManager(GamePanel gp) {
        super(gp);
        // UIObj();
    }

    public void draw(Graphics2D g2) {
        drawTextworld(g2);
    }

    public void drawTextworld(Graphics2D g2){
        Font B = gp.title.getFont();
        String text = "";
        int x = 0 ;
        int y = 0 ;
        g2.setFont(B);
        text = " " +(int)(gp.player.getCoin()) + " P"; 
        x = 800;
        y = 60;
        g2.drawString(text, x, y);

        Font Bauhaus = new Font("Bauhaus 93",Font.PLAIN, 35); // ขี้เกียจคิดละเขียนไปก่อน
        g2.setFont(Bauhaus);
        if(gp.getEarth().getHour() >= 12){
            text = gp.getEarth().getHour() +" :" + (gp.getEarth().getMin() <= 9 ? "0":"") +gp.getEarth().getMin() +" PM."; 
            x = 1100;
            y = 110;
            g2.drawString(text, x, y);
        }else{
            text = gp.getEarth().getHour() +" :" + (gp.getEarth().getMin() <= 9 ? "0":"") +gp.getEarth().getMin() +" AM."; 
            x = 1100;
            y = 110;
            g2.drawString(text, x, y);
        }
        Bauhaus = new Font("Bauhaus 93",Font.PLAIN, 60);
        g2.setFont(Bauhaus);

        text = "Day " + (gp.getEarth().getDay() <= 9 ? "0":"") + gp.getEarth().getDay(); 
        x = 1055;
        y = 60;
        g2.drawString(text, x, y);
    }

    public void UIObj() {
        createObject(0, 691, 15 , 59, 59, "/res/ui/coin.png");
        createObject(1, 377, 19, 303, 64, "/res/ui/earth_val.png");
        createObject(2, 310, -3, 95, 94, "/res/ui/earth.png");
        createObject(3, 30, -1, 74, 244, "/res/ui/emo_val.png");
        createObject(4, 13, 220, 118, 117, "/res/ui/face3.png");
        createObject(5, 130, 20, 64, 72, "/res/ui/bag1.png");
    }
    
}
