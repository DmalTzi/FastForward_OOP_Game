package Ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import main.GamePanel;
import main.GameState;
import utilz.LoadSave;

public class UIManager extends BackgroundManager {
    JButton restart;
    JProgressBar progressbar;
    JProgressBar progressbar1;
    public BufferedImage playerIm, playerIm1, playerIm2, playerIm3, remem;

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
        restart.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
                restart.setVisible(false);
                gp.setShowEvent(false);
                gp.getEarth().earthReset();
                gp.setgameState(GameState.Title);
                gp.getBagEvents(0).getBag().setVisible(false);
                gp.getPlayer().setDailyUesed(0);
                gp.getPlayer().setDailyEarn(0);
                gp.stopmusic();
                gp.playMu = true;
                for (int i = 0; i < 2; i++) {
                    String name = gp.getPlayer().getInventory(i);
                    if (name != null)
                    gp.getBagEvents(0)
                    .getBagMenu()
                    .getBtn(i)
                    .setIcon(new ImageIcon(LoadSave.GetSprite("menus", String.format("menu_bag_disable_%s.png", name))));
                }
                gp.getPlayer().playerReset();
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                restart.setIcon(new ImageIcon(LoadSave.GetSprite("ui", "restart_hover.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                restart.setIcon(new ImageIcon(LoadSave.GetSprite("ui", "restart.png")));
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
        });
    }

    public void loadAsset() {
        loadPlayer();
        progressbar = new JProgressBar();
        progressbar1 = new JProgressBar(JProgressBar.VERTICAL, 0, 100);

        gp.add(progressbar1);
        gp.add(progressbar);

    }

    public void loadPlayer() {
        createObject(0, 13, 333, 118, 117, "ui", "face1.png");
        build[0] = new ImageIcon(LoadSave.GetSprite("ui", "face1.png"));
        build[1] = new ImageIcon(LoadSave.GetSprite("ui", "face2.png"));
        build[2] = new ImageIcon(LoadSave.GetSprite("ui", "face3.png"));
        build[3] = new ImageIcon(LoadSave.GetSprite("ui", "face4.png"));
    }

    public void draw(Graphics2D g2) {
        drawTextworld(g2);
        loadingBar();
        if (gp.getPlayer().getEmotionalDamage() > 225) {
            setImageObj(0);
        } else if (gp.getPlayer().getEmotionalDamage() > 150) {
            setImageObj(1);
        } else if (gp.getPlayer().getEmotionalDamage() > 75) {
            setImageObj(2);
        } else {
            setImageObj(3);
        }
    }

    public void checkObj(boolean show) {
        for (JLabel o : obj) {
            if (o != null) {
                if (gp.getgameState() != GameState.Gameplay)
                    o.setVisible(false);
                else
                    o.setVisible(true);
            }
        }
        if (gp.getgameState() == GameState.Gameplay) {
            progressbar.setVisible(true);
            progressbar1.setVisible(true);
            // progressbar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, false));


        } else {
            progressbar.setVisible(false);
            progressbar1.setVisible(false);

        }

    }

    public void drawTextworld(Graphics2D g2) {
        Font B = gp.getTitle().getFont();
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

    public void loadingBar() {
        if (gp.getEarth().getEarthHeat() > 132){
            progressbar.setForeground(new Color(255,0,0)); 
        }
        else if (gp.getEarth().getEarthHeat() > 65){
            progressbar.setForeground(new Color(255,94,0)); 
        }
        else {
            progressbar.setForeground(new Color(133,198,76)); 
        }

        progressbar.setBackground(new Color(232,232,232));
        progressbar.setBorderPainted(false);
        progressbar.setBounds(410, 32, 300, 28);
        int target = gp.getEarth().getEarthHeat();
        progressbar.setMaximum(200);
        progressbar.setMinimum(0);
        // System.out.println(target);
        progressbar.setUI(new RoundedProgressBarUI());
        progressbar.setOpaque(false); 
        progressbar.setValue(target);
        



        progressbar1.setForeground(new Color(102,178,255)); 
        progressbar1.setBackground(new Color(232,232,232));
        progressbar1.setBorderPainted(false);
        progressbar1.setBounds(41, 32, 50, 300);
        int emo = gp.getPlayer().getPlayerEmo();
        progressbar1.setMaximum(100);
        progressbar1.setMinimum(0);
        progressbar1.setOpaque(false); 
        progressbar1.setUI(new VerticalRoundedProgressBarUI());
        progressbar1.setValue(emo);
        
        

    }

    public JButton getRestartButton() {
        return this.restart;
    }

    public void setRestartVisible(boolean bool) {
        this.restart.setVisible(bool);
    }
}
