package Ui;

import java.awt.Font;
import java.awt.Graphics2D;

import javax.swing.JLabel;

import main.GamePanel;
import utilz.LoadSave;

public class UIManager extends BackgroundManager {

    public UIManager(GamePanel gp) {
        super(gp);
    }
    
    public void draw(Graphics2D g2) {
        drawTextworld(g2);
        UIObj(g2);
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
        text = " " + (int)(gp.player.getCoin()) + " P"; 
        x = 800;
        y = 60;
        g2.drawString(text, x, y);

        Font Bauhaus = new Font("Bauhaus 93",Font.PLAIN, 35); // ขี้เกียจคิดละเขียนไปก่อน
        g2.setFont(Bauhaus);
        if (gp.getEarth().getHour() >= 12) {
            text = gp.getEarth().getHour() + " :" + (gp.getEarth().getMin() <= 9 ? "0":"") + gp.getEarth().getMin() + " PM."; 
            x = 1100;
            y = 110;
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

    public void UIObj(Graphics2D g2) {
        g2.drawImage(LoadSave.GetSprite("ui", "coin_c.png"), 745, 15, 59, 59, null);
        // createObject(0, 745, 15 , 59, 59, "ui", "coin_c.png");
        // g2.drawImage(LoadSave.GetSprite("ui", "earth_val.png"), 377, 19, 303, 64, null);
        createObject(1, 377, 19, 303, 64, "ui", "earth_val.png");
        createObject(2, 310, -3, 95, 94, "ui", "earth.png");
        createObject(3, 30, -1, 74, 244, "ui", "emo_val.png");
        if (gp.player.getPlayerEmo() >= 76 && gp.player.getPlayerEmo() <= 100) {
            createObject(4, 13, 220, 118, 117, "ui", "face1.png");
        }
        else if (gp.player.getPlayerEmo() >= 49 && gp.player.getPlayerEmo() <= 75) {
            createObject(4, 13, 220, 118, 117, "ui", "face2.png");
        }
        else if (gp.player.getPlayerEmo() >= 26 && gp.player.getPlayerEmo() <= 50) {
            createObject(4, 13, 220, 118, 117, "ui", "face3.png");
        }
        else if (gp.player.getPlayerEmo() >= 1 && gp.player.getPlayerEmo() <= 25) {
            createObject(4, 13, 220, 118, 117, "ui", "face4.png");
        }
        createObject(5, 130, 20, 64, 72, "ui", "bag1.png");
    }

    void loadUIAsset() {
        
    }
}
