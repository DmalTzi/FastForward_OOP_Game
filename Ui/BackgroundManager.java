package Ui;

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
    public ImageIcon[] build =new ImageIcon[10];
    GamePanel gp;
    Earth ev;

    int indexBack;
    public Image[] backg ; 

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
        }
    }

    public void createObject(int index , int x ,int y , int objWidth, int objHeight,String File){
        if (obj[index] == null) { 
            obj[index] = new JLabel();
        }
        obj[index].setBounds(x, y, objWidth, objHeight);
        build[index] = new ImageIcon(getClass().getResource(File));

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

        createObject(0, 691, 15 , 59, 59, "/res/ui/coin.png");
        createObject(1, 377, 19, 303, 64, "/res/ui/earth_val.png");
        createObject(2, 310, -3, 95, 94, "/res/ui/earth.png");
        createObject(3, 30, -1, 74, 244, "/res/ui/emo_val.png");
        createObject(4, 13, 220, 118, 117, "/res/ui/face3.png");
        createObject(5, 130, 20, 64, 72, "/res/ui/bag1.png");
    }
//310
//310
    // TEST
    public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

    public JLabel[] getObj() {
        return obj;
    }
}
