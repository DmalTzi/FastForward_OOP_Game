package Ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import main.GamePanel;

public class Title{
    GamePanel gp ; 
    int commandNum =  0 ; 
    public Title(GamePanel gp){
        this.gp = gp;
    }

    public void draw(Graphics2D g2){
        g2.setColor(new Color(240,255,255));
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);


        g2.setFont(g2.getFont().deriveFont(Font.TYPE1_FONT,50F));
        String text = "No time to see you because i have project ";
        int x  =  gettextcenter(text,g2); //สร้างไม่ได้ ใส่เข้าไปแม่งเลย ทำให้มันอยู่กลาง
        int y =  100; 

        //shadow 
        g2.setColor(Color.gray);
        g2.drawString(text, x+5, y+5);

        g2.setColor(Color.YELLOW);
        g2.drawString(text, x, y);



        //Menu
        g2.setFont(g2.getFont().deriveFont(Font.TYPE1_FONT,35F));
        g2.setColor(Color.BLACK);
        text = "PLAY GAME" ; 
        x  =  gettextcenter(text,g2);
        y+= 250;
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

    public int gettextcenter(String text,Graphics2D g2){
        int length = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        int x = gp.screenWidth/2 - length/2;

        return x;
    }
}