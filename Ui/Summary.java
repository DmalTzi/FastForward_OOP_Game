package Ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import main.GamePanel;
import main.GameState;
import utilz.LoadSave;

public class Summary extends BackgroundManager {
    Font font;
    String textTitle = "", textEmo = "", textEarn = "", textCO2 = "";
    JButton exit;
    
    public Summary(GamePanel gp) {
        super(gp);
        exit = new JButton();
        exit.setVisible(false);
        exit.setBorder(null);
        exit.setContentAreaFilled(false);
        exit.setIcon(new ImageIcon(LoadSave.GetSprite("ui", "sum_ok.png")));
        exit.setSize(exit.getIcon().getIconWidth(), exit.getIcon().getIconHeight());
        exit.setLocation(1130, 530);
        gp.add(exit);
    
        exit.addMouseListener(new MouseListener() {
            
            @Override
            public void mouseReleased(MouseEvent e) {
                exit.setVisible(false);
                gp.setShowEvent(true);
                gp.setgameState(GameState.Gameplay);
                gp.getPlayer().setWorkHr();
                gp.getEarth().increasDay(1);
                gp.getEarth().time = 6*60;
                gp.getPlayer().setDailyEarn(0);
                gp.playMu =true ;
                gp.getPlayer().increasePlayerEmo(gp.getPlayer().getactiveHome().get("Sleep")[0]);
                
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                exit.setIcon(new ImageIcon(LoadSave.GetSprite("ui", "sum_ok_hover.png")));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                exit.setIcon(new ImageIcon(LoadSave.GetSprite("ui", "sum_ok.png")));
            }
    
            @Override
            public void mouseClicked(MouseEvent e) {
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            
        });
    }
    
    public void draw(Graphics2D g2) {
        g2.drawImage(gp.getBackgroundManager().getImage(5), 0, 0, gp.screenWidth, gp.screenHeight, null);
        summaryObj(g2);
        
        textTitle = "Summary of Day " + (gp.getEarth().getDay() <= 9 ? "0":"") + gp.getEarth().getDay();
        font = LoadSave.GetFont();
        g2.setColor(new Color(125, 125, 169));
        g2.setFont(font);
        g2.setFont(g2.getFont().deriveFont(Font.TRUETYPE_FONT,48));
        g2.drawString(textTitle, 690+1, 157+2);
        g2.setColor(new Color(0, 0, 102));
        g2.drawString(textTitle, 690, 157);
        
        if (gp.getPlayer().getPlayerEmo() >= 76 && gp.getPlayer().getPlayerEmo() <= 100) {
            textEmo = "Happy ^^";
            g2.setFont(g2.getFont().deriveFont(Font.TRUETYPE_FONT,50));
        }
        else if (gp.getPlayer().getPlayerEmo() >= 49 && gp.getPlayer().getPlayerEmo() <= 75) {
            textEmo = "Unhappy :(";
            g2.setFont(g2.getFont().deriveFont(Font.TRUETYPE_FONT,40));
        }
        else if (gp.getPlayer().getPlayerEmo() >= 26 && gp.getPlayer().getPlayerEmo() <= 50) {
            textEmo = "Anxious!";
            g2.setFont(g2.getFont().deriveFont(Font.TRUETYPE_FONT,50));

        }
        else if (gp.getPlayer().getPlayerEmo() >= 1 && gp.getPlayer().getPlayerEmo() <= 25) {
            textEmo = "Breaking Point!";
            g2.setFont(g2.getFont().deriveFont(Font.TRUETYPE_FONT,33));
        }
        g2.setColor(new Color(0, 0, 102));
      
        g2.drawString(textEmo, 835+4, 300+3);
        g2.setColor(Color.WHITE);
        g2.drawString(textEmo, 835, 300);
        
        textCO2 = gp.getEarth().getEarthHeat() + " pts.";
        g2.setColor(new Color(0, 0, 102));
        g2.setFont(g2.getFont().deriveFont(Font.TRUETYPE_FONT,50));
        g2.drawString(textCO2, 880+4, 455+3);
        g2.setColor(Color.WHITE);
        g2.drawString(textCO2, 880, 455);
        
        textEarn = (gp.getPlayer().getDailyEarn() - gp.getPlayer().getPlayerCoin()) + " c.";
        g2.setColor(new Color(0, 0, 102));
        g2.setFont(g2.getFont().deriveFont(Font.TRUETYPE_FONT,50));
        g2.drawString(textEarn, 900+4, 615+3);
        g2.setColor(Color.WHITE);
        g2.drawString(textEarn, 900, 615);
        
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

        if (gp.getPlayer().getPlayerEmo() >= 76 && gp.getPlayer().getPlayerEmo() <= 100) {
            player = player1;
        }
        else if (gp.getPlayer().getPlayerEmo() >= 49 && gp.getPlayer().getPlayerEmo() <= 75) {
            player = player2;
        }
        else if (gp.getPlayer().getPlayerEmo() >= 26 && gp.getPlayer().getPlayerEmo() <= 50) {
            player = player3;
        }
        else if (gp.getPlayer().getPlayerEmo() >= 1 && gp.getPlayer().getPlayerEmo() <= 25) {
            player = player4;
        }

        return player;
    }

    public void setOKButton(boolean bool) {
        exit.setVisible(bool);
    }
}