package backgroundMana;

import java.awt.Graphics2D;
import java.io.IOException;
import java.security.KeyStore.LoadStoreParameter;
import java.awt.Image;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import inputs.MouseHandler;
import main.Earth;
import main.GamePanel;
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
        g2.drawImage(backg[indexBack], 0, 0, gp.screenWidth, gp.screenHeight, null);
    }



    public void createObject(int index , int x ,int y , int objWidth, int objHeight,String File){
        if (obj[index] == null) { 
            obj[index] = new JLabel();
        }
        obj[index].setBounds(x, y, objWidth, objHeight);
        build[index] = new ImageIcon(getClass().getResource(File));

        obj[index].setIcon(build[index]);
        obj[index].addMouseListener(new MouseHandler(gp));

        // obj[index].addMouseListener(new MouseListener() {
        //     @Override
        //     public void mouseClicked(MouseEvent e) {
        //         System.out.println("Clicked!");
        //         Gamestate.state = Gamestate.MENU;
        //     }

        //     @Override
        //     public void mousePressed(MouseEvent e) {
        //     }

        //     @Override
        //     public void mouseReleased(MouseEvent e) {
        //     }

        //     @Override
        //     public void mouseEntered(MouseEvent e) {
        //     }

        //     @Override
        //     public void mouseExited(MouseEvent e) {
        //         Gamestate.state = Gamestate.PLAYING;
        //     }
        // });

        gp.add(obj[index]);
    }

    public void updateblackground(){ //เปลี่ยนพื้นหลังตามเวลา
        if(gp.ev.Time > 12){
            indexBack = 1;
        }
        else {
            indexBack = 0;
        }
    }

    public void generateScreen(){ //สร้าง object สถานที่และ bg
        loadBackground(0, "back_01.jpg");
        loadBackground(1, "backni_02.jpg");
        // createObject(0, 100, 100, 100, 100, "/res/ISAG_Logo_sq.png");
        // createObject(1, 200, 200, 100, 100, "/res/ISAG_Logo_sq.png");
        // createObject(1, 600, 200, 300, 300, "/res/Building/B1.png");
        // createObject(0, 100, 100, 450, 300, "/res/Building/camp.png");
        // createObject(2, 500, 450, 300, 300, "/res/Building/grass.png");
        // createobject(3, 1, 450, 300, 300, "/res/Building/B1.png");
    }

    // TEST
    
    // TEST
    public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}



}
