package Ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;

import main.GamePanel;
import utilz.LoadSave;

public class Title{
    GamePanel gp ; 
    Image pic ;
    Font Bauhaus = new Font("Bauhaus 93", Font.PLAIN, 50);
    int commandNum =  0 ; 
    public Title(GamePanel gp){
        this.gp = gp;
        loadBackground();
    }

    public void draw(Graphics2D g2) {
        g2.setColor(new Color(240, 255, 255));
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

        g2.drawImage(pic, 0,0,gp.screenWidth,gp.screenHeight,null);
        g2.setFont(Bauhaus);
        String text = "";
        int x  =  0; //สร้างไม่ได้ ใส่เข้าไปแม่งเลย ทำให้มันอยู่กลาง
        int y =  420; 

    
        //Menu
        g2.setFont(g2.getFont().deriveFont(Font.TYPE1_FONT,35F));
        g2.setColor(Color.BLACK);
        text = "PLAY GAME" ; 
        x  =  gettextcenter(text,g2);
        y+= 100;
        g2.drawString(text, x, y);
        if(commandNum == 0){
            g2.drawString(">", x-25, y);
        }

        text = "EXIT GAME" ; 
        x  =  gettextcenter(text,g2);
        y+= 100;
        g2.drawString(text, x, y);
        if(commandNum == 1){
            g2.drawString(">", x-25, y);

        }
         
    }
    public void loadBackground() {
        
            try {
               pic  = LoadSave.GetSprite("backgrounds", "frist.png");
            }
            catch(Exception e){
                e.printStackTrace();
            }
        
    }
    public Font getFont(){
        return Bauhaus;
    }

    public int gettextcenter(String text, Graphics2D g2){
        int length = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        int x = gp.screenWidth/2 - length/2;

        return x;
    }
}