package Main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
public class GamePanal extends JPanel implements Runnable{
    final int screenWidth = 1280;
    final int screenHeight = 720;
    ImageIcon background ; 
 

    public GamePanal(){
        
        this.loadedblackground();
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setFocusable(true);
        
    }

     public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(background.getImage(), 0, 0, screenWidth, screenHeight, null);
    }


    public void loadedblackground(){
        background = new ImageIcon(this.getClass().getResource("/res/Background/back_01.jpg"));
    }


    public void run(){


        


        
    }

    public void update() {



    }
}

