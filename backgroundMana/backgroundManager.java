package backgroundMana;

import java.awt.Graphics2D;
import java.awt.Image;


import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Main.GamePanel;
import Main.events;

public class backgroundManager {
    public  JLabel[] obj  = new JLabel[10]; //ชื่อเก่าคือ Ob
    public ImageIcon[] build =new ImageIcon[10];
    GamePanel gp ;
    events ev ;
    public Image[] backg ; 
    int indexBack;


    public backgroundManager(GamePanel gp,events ev){
        this.gp = gp;
        this.ev = ev;
        backg = new Image[10];
        generateScreen();
    }

    public void loadBackground(int index , String File){
        try{
            backg[index] =  new ImageIcon(this.getClass().getResource(File)).getImage();
            
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void draw(Graphics2D g2){
        g2.drawImage(backg[indexBack], 0, 0, gp.screenWidth, gp.screenHeight, null);

    }


    public void createObject(int index , int x ,int y , int obWidth,int obHeight,String File){
        if (obj[index] == null) { 
            obj[index] = new JLabel();
        }
        obj[index].setBounds(x, y, obWidth, obHeight);
        build[index] = new ImageIcon(getClass().getResource(File));
        obj[index].setIcon(build[index]);
        gp.add(obj[index]); 
        
   
    }

    public void updateblackground(){ //เปลี่ยนพื้นหลังตามเวลา
        if(ev.Time > 12){
            indexBack = 1;
        }else{
            indexBack =0;
        }
    }

    public void generateScreen(){ //สร้าง object สถานที่และ bg
        loadBackground(0, "/res/Background/back_01.jpg");
        loadBackground(1, "/res/Background/Uselesspic.png");

        createObject(1, 600, 200, 300, 300, "/res/Building/B1.png");
        createObject(0, 100, 100, 450, 300, "/res/Building/camp.png");
        createObject(2, 500, 450, 300, 300, "/res/Building/grass.png");
        // createobject(3, 1, 450, 300, 300, "/res/Building/B1.png");


        
    }

}
