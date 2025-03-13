package Ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import javax.swing.Timer;

import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

import main.GamePanel;
import utilz.LoadSave;

public class UIManagers extends BackgroundManager {

    public UIManagers(GamePanel gp) {
        super(gp);
    }

    public void draw(Graphics2D g2) {
        drawTextworld(g2);
        UIObj(g2);
        loadingBar();
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

    public void drawTextworld(Graphics2D g2) {
        Font B = gp.title.getFont();
        String text = "";
        Font Bauhaus = LoadSave.GetFont();
        g2.setFont(Bauhaus);
        int x = 0;
        int y = 0;
        g2.setFont(B);
        if (gp.getEarth().getHour() > 18) {
            g2.setColor(Color.white);
        } else {
            g2.setColor(Color.BLACK);
        }
        text = " " + (int) (gp.player.getCoin()) + " P";
        x = 800;
        y = 60;
        g2.setFont(g2.getFont().deriveFont(Font.TRUETYPE_FONT, 35));
        g2.drawString(text, x, y);

        if (gp.getEarth().getHour() >= 12) {

            text = (gp.getEarth().getHour() == 12 ? "12" : (gp.getEarth().getHour() - 12)) + " :"
                    + (gp.getEarth().getMin() <= 9 ? "0" : "") + gp.getEarth().getMin() + " PM.";
            x = 1100;
            y = 110;
            if (gp.getEarth().getHour() > 18 || gp.getEarth().getHour() <= 5) {
                g2.setColor(Color.white);
            } else {
                g2.setColor(Color.BLACK);
            }
            g2.drawString(text, x, y);
        } else {

            text = (gp.getEarth().getHour() == 0 ? "12" : (gp.getEarth().getHour())) + " :"
                    + (gp.getEarth().getMin() <= 9 ? "0" : "") + gp.getEarth().getMin() + " AM.";
            x = 1100;
            y = 110;
            g2.drawString(text, x, y);
        }

        g2.setFont(g2.getFont().deriveFont(Font.TRUETYPE_FONT, 60));

        text = "Day " + (gp.getEarth().getDay() <= 9 ? "0" : "") + gp.getEarth().getDay();
        x = 1055;
        y = 60;
        g2.drawString(text, x, y);
    }

    public void UIObj(Graphics2D g2) {
        g2.drawImage(LoadSave.GetSprite("ui", "coin_c.png"), 745, 15, 59, 59, null);
        // createObject(0, 745, 15 , 59, 59, "ui", "coin_c.png");
        // g2.drawImage(LoadSave.GetSprite("ui", "earth_val.png"), 377, 19, 303, 64,
        // null);
        createObject(1, 377, 19, 303, 64, "ui", "earth_val.png");
        createObject(2, 310, -3, 95, 94, "ui", "earth.png");
        createObject(3, 30, -1, 74, 244, "ui", "emo_val.png");
        if (gp.player.getPlayerEmo() >= 76 && gp.player.getPlayerEmo() <= 100) {
            createObject(4, 13, 220, 118, 117, "ui", "face1.png");
        } else if (gp.player.getPlayerEmo() >= 49 && gp.player.getPlayerEmo() <= 75) {
            createObject(4, 13, 220, 118, 117, "ui", "face2.png");
        } else if (gp.player.getPlayerEmo() >= 26 && gp.player.getPlayerEmo() <= 50) {
            createObject(4, 13, 220, 118, 117, "ui", "face3.png");
        } else if (gp.player.getPlayerEmo() >= 1 && gp.player.getPlayerEmo() <= 25) {
            createObject(4, 13, 220, 118, 117, "ui", "face4.png");
        }
        createObject(5, 130, 20, 64, 72, "ui", "bag1.png");

        createObject(6, 745, 15, 60, 60, "ui", "Asset 163.png");

    }

    boolean add = true;

    JProgressBar progressbar = new JProgressBar();

    public void loadingBar() {
     
        progressbar.setLayout(null);
        progressbar.setBounds(390, 32, 300, 28);
        // progressbar.setStringPainted(true);

        // int i = 1;
        int target = gp.getEarth().getEarthHeat();
        progressbar.setMaximum(200);
        progressbar.setMinimum(0);
        System.out.println(target);
        progressbar.setValue(target);

        gp.add(progressbar);

        // while (i < target) {
        // progressbar.setValue(i);
        // System.out.println(i);
        // i++;

        // try {
        // Thread.sleep(1000);
        // } catch (Exception ex) {

        // }

        // }
        // progressbar.setVisible(false);
        // progressbar.setString("");
        // g2.add(progressbar);

    }

    void loadUIAsset() {

    }
}
