package Ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import utilz.LoadSave;

public class Summary extends BackgroundManager {
    // Font Bauhaus = new Font("Bauhaus 93", Font.PLAIN, 50);
    Font font;
    String textTitle, textEmo;
    
    public Summary(GamePanel gp) {
        super(gp);
    }
    
    public void draw(Graphics2D g2) {
        g2.drawImage(gp.getBackgroundManager().getImage(3), 0, 0, gp.screenWidth, gp.screenHeight, null);

        textTitle = "Summary of Day " + (gp.getEarth().getDay() <= 9 ? "0":"") + gp.getEarth().getDay();
        font = new Font("Bauhaus 93", Font.PLAIN, 48);
        g2.setFont(font);
        g2.drawString(textTitle, 690, 157);
        
        if (gp.player.getPlayerEmo() >= 76 && gp.player.getPlayerEmo() <= 100) {
            textEmo = "Happy ^^";
        }
        else if (gp.player.getPlayerEmo() >= 49 && gp.player.getPlayerEmo() <= 75) {
            textEmo = "Unhappy :(";
        }
        else if (gp.player.getPlayerEmo() >= 26 && gp.player.getPlayerEmo() <= 50) {
            textEmo = "Anxious!";
        }
        else if (gp.player.getPlayerEmo() >= 1 && gp.player.getPlayerEmo() <= 25) {
            textEmo = "Breaking Point!";
        }
        font = new Font("Bauhaus 93", Font.PLAIN, 50);
        g2.setFont(font);
        g2.drawString(textEmo, 835, 250);

        summaryObj(g2);
    }

    public int getXCenterPos(String text, Graphics2D g2) {
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }

    public void summaryObj(Graphics2D g2) {
        g2.drawImage(LoadSave.GetSprite("ui", "sum_frame1.png"), 647, 233, 106, 121, null);
        g2.drawImage(LoadSave.GetSprite("ui", "sum_earth.png"), 635, 380, 117, 123, null);
        g2.drawImage(LoadSave.GetSprite("ui", "sum_coin.png"), 645, 531, 106, 121, null);
        g2.drawImage(LoadSave.GetSprite("ui", "sum_frame2.png"), 730, 193, 365, 188, null);
        g2.drawImage(LoadSave.GetSprite("ui", "sum_frame2.png"), 730, 347, 365, 188, null);
        g2.drawImage(LoadSave.GetSprite("ui", "sum_frame2.png"), 730, 501, 365, 188, null);
        g2.drawImage(getPlayer(), 657, 249, 78, 78, null);
    }

    BufferedImage getPlayer() {
        BufferedImage player = null, player1 = null, player2 = null, player3 = null, player4 = null;
        try {
            player1 = ImageIO.read(getClass().getResourceAsStream("/res/ui/face1.png")); //happy
            player2 = ImageIO.read(getClass().getResourceAsStream("/res/ui/face2.png"));//min
            player3 = ImageIO.read(getClass().getResourceAsStream("/res/ui/face3.png"));//medium
            player4= ImageIO.read(getClass().getResourceAsStream("/res/ui/face4.png")); //verysad
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        if (gp.player.getPlayerEmo() >= 76 && gp.player.getPlayerEmo() <= 100) {
            player = player1;
        }
        else if (gp.player.getPlayerEmo() >= 49 && gp.player.getPlayerEmo() <= 75) {
            player = player2;
        }
        else if (gp.player.getPlayerEmo() >= 26 && gp.player.getPlayerEmo() <= 50) {
            player = player3;
        }
        else if (gp.player.getPlayerEmo() >= 1 && gp.player.getPlayerEmo() <= 25) {
            player = player4;
        }

        return player;
    }
}