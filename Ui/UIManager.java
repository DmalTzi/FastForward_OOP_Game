package Ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import javax.swing.JLabel;

import main.GamePanel;

public class UIManager extends BackgroundManager {

    public UIManager(GamePanel gp) {
        super(gp);
        UIObj();
    }

    public void draw(Graphics2D g2) {
        drawTextworld(g2);
    }

    public void checkObj(boolean show) {
        for (JLabel o : obj) {
            if (o != null) {
                if (show)
                    o.setVisible(true);
                else
                    o.setVisible(false);
            }
        }
    }

    public void drawTextworld(Graphics2D g2){
        Font B = gp.title.getFont();
        String text = "";
        int x = 0 ;
        int y = 0 ;
        g2.setFont(B);
        if(gp.getEarth().getHour() >= 18){
            g2.setColor(Color.white);
        }else{
            g2.setColor(Color.BLACK);
        }
        text = " " + (int)(gp.player.getCoin()) + " P"; 
        x = 800;
        y = 60;
        g2.drawString(text, x, y);

        Font Bauhaus = new Font("Bauhaus 93",Font.PLAIN, 35); // ขี้เกียจคิดละเขียนไปก่อน
        g2.setFont(Bauhaus);
    
        if (gp.getEarth().getHour() >= 12) {
            
            text = (gp.getEarth().getHour()-12) + " :" + (gp.getEarth().getMin() <= 9 ? "0":"") + gp.getEarth().getMin() + " PM."; 
            x = 1100;
            y = 110;
            if(gp.getEarth().getHour() >= 18){
                g2.setColor(Color.white);
            }else{
                g2.setColor(Color.BLACK);
            }
            g2.drawString(text, x, y);
        }
        else {
          
            text = gp.getEarth().getHour() + " :" + (gp.getEarth().getMin() <= 9 ? "0":"") + gp.getEarth().getMin() +" AM."; 
            x = 1100;
            y = 110;
            g2.drawString(text, x, y);
        }
        Bauhaus = new Font("Bauhaus 93", Font.PLAIN, 60);
        g2.setFont(Bauhaus);

        text = "Day " + (gp.getEarth().getDay() <= 9 ? "0":"") + gp.getEarth().getDay(); 
        x = 1055;
        y = 60;
        g2.drawString(text, x, y);
    }

    public void UIObj() {
        // createObject(0, 745, 15 , 59, 59, "ui", "coin.png");
        createObject(1, 377, 10, 350, 80, "ui", "earth_val.png");
        createObject(2, 310, -3, 95, 94, "ui", "earth.png");
        createObject(3, 30, -1, 74, 244, "ui", "emo_val.png");
        // createObject(4, 13, 220, 118, 117, "ui", "face3.png");
        createObject(5, 130, 20, 64, 72, "ui", "bag1.png");
        createObject(6,745, 15, 60, 60, "ui", "Asset 163.png");
       

    }
}
