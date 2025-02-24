package backgroundMana;

import java.awt.Graphics2D;
import java.awt.Image;


import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Main.GamePanal;
import Main.events;

public class backgroundManager {
    public  JLabel[] Ob  = new JLabel[10];
    public ImageIcon[] build =new ImageIcon[10];
    GamePanal gp ;
    events ev ;
    public Image[] backg ; 
    int indexBack;


    public backgroundManager(GamePanal gp,events ev){
        this.gp =gp;
        this.ev = ev;
        backg =new Image[10];
        generateScreen();
    }

    public void loadedblackground(int index , String File){
        try{
            backg[index] =  new ImageIcon(this.getClass().getResource(File)).getImage();
            
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void draw(Graphics2D g2){
        g2.drawImage(backg[indexBack], 0, 0, gp.screenWidth, gp.screenHeight, null);

    }


    public void createobject(int index , int x ,int y , int obWidth,int obHeight,String File){
        if (Ob[index] == null) { 
            Ob[index] = new JLabel();
        }
        Ob[index].setBounds(x, y, obWidth, obHeight);
        build[index] = new ImageIcon(getClass().getResource(File));
        Ob[index].setIcon(build[index]);
        gp.add(Ob[index]); 
        
   
    }

    public void updateblackground(){
        if(ev.Time > 12){
            indexBack = 1;
        }else{
            indexBack =0;
        }
    }

    public void generateScreen(){
        loadedblackground(0, "/res/Background/back_01.jpg");
        loadedblackground(1, "/res/Background/Uselesspic.png");

        createobject(1, 600, 200, 300, 300, "/res/Building/B1.png");
        createobject(0, 100, 100, 450, 300, "/res/Building/camp.png");
        createobject(2, 500, 450, 300, 300, "/res/Building/grass.png");
        // createobject(3, 1, 450, 300, 300, "/res/Building/B1.png");


        
    }

}
