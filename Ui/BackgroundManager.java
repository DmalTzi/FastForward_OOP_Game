package Ui;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import inputs.MouseHandler;
import main.Earth;
import main.GamePanel;
import main.GameState;
import utilz.LoadSave;

public class BackgroundManager {
    public  JLabel[] obj  = new JLabel[10]; //ชื่อเก่าคือ Ob
    public ImageIcon[] build = new ImageIcon[10];
    GamePanel gp;
    Earth ev;

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
            g2.drawImage(backg[2], 0, 0, gp.screenWidth, gp.screenHeight, null);
        }else{

            g2.drawImage(backg[indexBack], 0, 0, gp.screenWidth, gp.screenHeight, null);
            // drawTextworld(g2);
        }
    }

    public void createObject(int index , int x ,int y , int objWidth, int objHeight,String des, String fileName){
        if (obj[index] == null) { 
            obj[index] = new JLabel();
        }
        obj[index].setBounds(x, y, objWidth, objHeight);
        build[index] = new ImageIcon(LoadSave.GetSprite(des, fileName));

        obj[index].setIcon(build[index]);
        obj[index].addMouseListener(new MouseHandler(gp));

        gp.add(obj[index]);
    }

    public void updateblackground(){ //เปลี่ยนพื้นหลังตามเวลา
        if(gp.getEarth().getTime() > 18*60){
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
    }

    // TEST
    public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

    public JLabel[] getObj() {
        return obj;
    }
}
