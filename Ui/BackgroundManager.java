package Ui;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


import main.Earth;
import main.GamePanel;
import main.GameState;
import utilz.LoadSave;

public class BackgroundManager {
    public  JLabel[] obj  = new JLabel[10]; //ชื่อเก่าคือ Ob
    public ImageIcon[] build = new ImageIcon[10];
    GamePanel gp;
    Earth ev;
    Graphics2D g2;

    int indexBack;
    public Image[] backg; 

    public BackgroundManager(GamePanel gp){
        this.gp = gp;
        backg = new Image[10];
        generateScreen();
    }

    public void loadBackground(int index, String File){
        try {
            backg[index] = LoadSave.GetSprite("backgrounds", File);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2){
        if(gp.getgameState() == GameState.Endgame){
            g2.drawImage(backg[3], 0, 0, gp.screenWidth, gp.screenHeight, null);
        }else if(gp.getgameState()  == GameState.Gameplay){

            g2.drawImage(backg[indexBack], 0, 0, gp.screenWidth, gp.screenHeight, null);
        
        }else if(gp.getgameState() == GameState.Endgame_2){
            g2.drawImage(backg[2], 0, 0, gp.screenWidth, gp.screenHeight, null);
        }else if(gp.getgameState() == GameState.GoodEnd){
            g2.drawImage(backg[4],  0, 0, gp.screenWidth, gp.screenHeight, null);
        }

    }

    public void createObject(int index , int x ,int y , int objWidth, int objHeight,String des, String fileName){
        if (obj[index] == null) { 
            obj[index] = new JLabel();
        }

        obj[index].setBounds(x, y, objWidth, objHeight);
        ImageIcon originalIcon = new ImageIcon(LoadSave.GetSprite(des, fileName));
        Image originalImage = originalIcon.getImage();
        
        
        double aspectRatio = (double) originalImage.getWidth(null) / originalImage.getHeight(null);
        int newWidth = objWidth;
        int newHeight = (int) (newWidth / aspectRatio);
        
        if (newHeight > objHeight) { 
            newHeight = objHeight;
            newWidth = (int) (newHeight * aspectRatio);
        }
        
       
        Image resizedImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        build[index] = new ImageIcon(resizedImage);
        
        obj[index].setIcon(build[index]);
        gp.add(obj[index]);
    }

    public void updateblackground(){ //เปลี่ยนพื้นหลังตามเวลา
        if(gp.getEarth().getTime() > 18*60 || gp.getEarth().getTime() <= 5*60 ){
            indexBack = 1;
        }
        else {
            indexBack = 0;
        }
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

    public void generateScreen(){ //สร้าง object สถานที่และ bg
        loadBackground(0, "menu_background_morning.png");
        loadBackground(1, "menu_background_night.png");
        loadBackground(2, "end.png");
        loadBackground(3, "emoend.png");
        loadBackground(4, "goodend.png");
        loadBackground(5, "summary_bg.png");
    }

    // TEST
    public void keyReleased(KeyEvent e) {
	}

    public JLabel[] getObj() {
        return obj;
    }

    public Image getImage(int ind) {
        return backg[ind];
    }
}
