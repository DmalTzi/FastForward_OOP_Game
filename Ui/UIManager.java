package Ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

import main.GamePanel;
import main.GameState;
import utilz.LoadSave;

public class UIManager extends BackgroundManager {
    JButton restart;

    public UIManager(GamePanel gp) {
        super(gp);
        restart = new JButton();
        restart.setVisible(false);
        restart.setBorder(null);
        restart.setContentAreaFilled(false);
        restart.setIcon(new ImageIcon(LoadSave.GetSprite("ui", "restart.png")));
        restart.setSize(restart.getIcon().getIconWidth(), restart.getIcon().getIconHeight());
        restart.setLocation(1150, 620);
        gp.add(restart);
        UIObj();
        restart.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                restart.setVisible(false);
                gp.setShowEvent(false);
                gp.player.playerReset();
                gp.getEarth().earthReset();
                gp.setgameState(GameState.Title);
                gp.playMu = true;
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                restart.setIcon(new ImageIcon(LoadSave.GetSprite("ui", "restart_hover.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                restart.setIcon(new ImageIcon(LoadSave.GetSprite("ui", "restart.png")));
            }
        });
    }

    public void draw(Graphics2D g2) {
        drawTextworld(g2);
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
        if (gp.getgameState() == GameState.Gameplay) {
            progressbar.setVisible(true);
            progressbar1.setVisible(true);

        } else {
            progressbar.setVisible(false);
            progressbar1.setVisible(false);

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
        text = " " + (int)(gp.getPlayer().getCoin()) + " P"; 
        x = 800;
        y = 60;
        g2.setFont(g2.getFont().deriveFont(Font.TRUETYPE_FONT, 35));
        g2.drawString(text, x, y);

        if (gp.getEarth().getHour() >= 12) {

            if(gp.getEarth().getHour() == 12){
                text = (gp.getEarth().getHour() == 12 ? "12" : (gp.getEarth().getHour() - 12)) + " :"
                + (gp.getEarth().getMin() <= 9 ? "0" : "") + gp.getEarth().getMin() + " PM.";
            }else{
                text = (gp.getEarth().getHour() - 12) + " :"
                + (gp.getEarth().getMin() <= 9 ? "0" : "") + gp.getEarth().getMin() + " PM.";
            }
            x = 1100;
            y = 110;
            if (gp.getEarth().getHour() > 18 || gp.getEarth().getHour() <= 5) {
                g2.setColor(Color.white);
            }
            else {
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
        text = "Day " + (gp.getEarth().getDay() <= 9 ? "0":"") + gp.getEarth().getDay(); 
        x = 1055;
        y = 60;
        g2.drawString(text, x, y);
    }

    public void UIObj() {
        // g2.drawImage(LoadSave.GetSprite("ui", "coin_c.png"), 745, 15, 59, 59, null);
        // createObject(0, 745, 15 , 59, 59, "ui", "coin_c.png");
        // g2.drawImage(LoadSave.GetSprite("ui", "earth_val.png"), 377, 19, 303, 64, null);
        createObject(6,745, 15, 60, 60, "ui", "Asset 163.png");
        createObject(5, 130, 20, 64, 72, "ui", "bag1.png");
        // createObject(1, 377, 19, 303, 64, "ui", "earth_val.png");
        createObject(2, 310, -3, 95, 94, "ui", "earth.png");
        // createObject(3, 30, -1, 74, 244, "ui", "emo_val.png");
        if (gp.getPlayer().getPlayerEmo() >= 76 && gp.getPlayer().getPlayerEmo() <= 100) {
            createObject(4, 13, 220, 118, 117, "ui", "face1.png");
        }
        else if (gp.getPlayer().getPlayerEmo() >= 49 && gp.getPlayer().getPlayerEmo() <= 75) {
            createObject(4, 13, 220, 118, 117, "ui", "face2.png");
        }
        else if (gp.getPlayer().getPlayerEmo() >= 26 && gp.getPlayer().getPlayerEmo() <= 50) {
            createObject(4, 13, 220, 118, 117, "ui", "face3.png");
        }
        else if (gp.getPlayer().getPlayerEmo() >= 1 && gp.getPlayer().getPlayerEmo() <= 25) {
            createObject(4, 13, 220, 118, 117, "ui", "face4.png");
        }
        createObject(5, 130, 20, 64, 72, "ui", "bag1.png");
        createObject(6,745, 15, 60, 60, "ui", "Asset 163.png");
    }

    JProgressBar progressbar = new JProgressBar();
    JProgressBar progressbar1 = new JProgressBar(JProgressBar.VERTICAL, 0, 100);


    public void loadingBar() {
        if(gp.getEarth().getEarthHeat() >132){

            progressbar.setForeground(new Color(255,0,0)); 
        }else if(gp.getEarth().getEarthHeat()> 65){
            progressbar.setForeground(new Color(255,94,0)); 
        }else{
            progressbar.setForeground(new Color(133,198,76)); 

        }

        progressbar.setBackground(Color.LIGHT_GRAY);
        progressbar.setBounds(410, 32, 300, 28);
        int target = gp.getEarth().getEarthHeat();
        progressbar.setMaximum(200);
        progressbar.setMinimum(0);
        System.out.println(target);
        progressbar.setValue(target);

        



        progressbar1.setForeground(new Color(102,178,255)); 
        progressbar1.setBackground(Color.LIGHT_GRAY);
        progressbar1.setBounds(41, 32, 50, 300);
        int emo = gp.getPlayer().getPlayerEmo();
        progressbar1.setMaximum(100);
        progressbar1.setMinimum(0);
        // System.out.println(target);
        progressbar1.setValue(emo);
        
        gp.add(progressbar1);
        gp.add(progressbar);

    }




    public JButton getRestartButton() {
        return this.restart;
    }

    public void setRestartVisible(boolean bool) {
        this.restart.setVisible(bool);
    }
}
