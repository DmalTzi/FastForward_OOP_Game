package Ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;

import main.GamePanel;
import utilz.LoadSave;

public class Title {
    GamePanel gp;
    Image pic;
    Font Bauhaus = LoadSave.GetFont();
    int commandNum = 0;
    int pop = 0;

    public Title(GamePanel gp) {
        this.gp = gp;
        loadBackground();
        loadpop();
    }

    public void draw(Graphics2D g2) {
        g2.setColor(new Color(240, 255, 255));
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

        g2.drawImage(pic, 0, 0, gp.screenWidth, gp.screenHeight, null);
        g2.setFont(Bauhaus);
        String text = "";
        int x = 0; // สร้างไม่ได้ ใส่เข้าไปแม่งเลย ทำให้มันอยู่กลาง
        int y = 440;

        // Menu
        g2.setFont(g2.getFont().deriveFont(Font.TYPE1_FONT, 45F));
        g2.setColor(new Color(64, 64, 64));
        text = "PLAY GAME";
        x = gettextcenter(text, g2);
        y += 100;
        g2.drawString(text, x, y);
        g2.setColor(new Color(153, 204, 255));
        g2.drawString(text, x - 5, y);
        if (commandNum == 0) {
            g2.setColor(new Color(64, 64, 64));
            g2.drawString(">", x - 35, y);
            g2.setColor(new Color(204, 229, 255));
            g2.drawString(">", x - 42, y);
        }

        text = "EXIT GAME";
        x = gettextcenter(text, g2);
        y += 90;
        g2.setColor(new Color(64, 64, 64));
        g2.drawString(text, x, y);
        g2.setColor(new Color(153, 204, 255));
        g2.drawString(text, x - 5, y);
        if (commandNum == 1) {
            g2.setColor(new Color(64, 64, 64));
            g2.drawString(">", x - 35, y);
            g2.setColor(new Color(204, 229, 255));
            g2.drawString(">", x - 42, y);

        }
        text = "";
        g2.setColor(new Color(64, 64, 64));
        if (pop == 0) {
            text = "Code form my logic";
        } else if (pop == 1) {
            text = "Code is mine";
        } else if (pop == 2) {
            text = "Suntana SuSu";
        } else if (pop == 3) {
            text = "Boobie is mine XD";
        } else if (pop == 4) {
            text = "No time to Sleep  ZZ";
        }

        AffineTransform original = g2.getTransform();
        g2.rotate(-Math.toRadians(18), 860, 180);
        g2.drawString(text, 860, 180);
        g2.setColor(Color.yellow);
        g2.drawString(text, 855, 175);

        g2.setTransform(original);

    }

    public int loadpop() {
        pop = (int) (Math.random() * 4);
        return pop;
    }

    public void loadBackground() {

        try {
            pic = LoadSave.GetSprite("backgrounds", "frist.png");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Font getFont() {
        return Bauhaus;
    }

    public int gettextcenter(String text, Graphics2D g2) {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth / 2 - length / 2;

        return x;
    }
}