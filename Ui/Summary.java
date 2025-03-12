package Ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import main.GamePanel;

public class Summary {
    GamePanel gp = new GamePanel();
    // Font Bauhaus = new Font("Bauhaus 93", Font.PLAIN, 50);
    Font fontTitle;
    String textTitle;
    
    public Summary(GamePanel gp) {
        this.gp = gp;
    }

    public void draw(Graphics2D g2) {
        g2.setColor(new Color(240, 255, 255));
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
        
        textTitle = "Summary of Day " + (gp.getEarth().getDay() <= 9 ? "0":"") + gp.getEarth().getDay();
        fontTitle = new Font("Bauhaus 93", Font.PLAIN, 50);
        g2.setFont(fontTitle);
        g2.drawString(textTitle, getXCenterPos(textTitle, g2), 500);

    }

    public int getXCenterPos(String text, Graphics2D g2) {
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - length/2;

        return x;
    }
}