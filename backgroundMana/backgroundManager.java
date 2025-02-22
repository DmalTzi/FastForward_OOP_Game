package backgroundMana;

import java.awt.Graphics2D;
import java.io.IOException;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import Main.GamePanal;

public class backgroundManager {

    GamePanal gp ;
    public Image[] backg ; 

    public backgroundManager(GamePanal gp){

        this.gp =gp;
        backg =new Image[10];
        loadedblackground();
    }


    public void loadedblackground(){

        try{

            backg[0] =  new ImageIcon(this.getClass().getResource("/res/Background/back_01.jpg")).getImage();

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void draw(Graphics2D g2){

        g2.drawImage(backg[0], 0, 0, gp.screenWidth, gp.screenHeight, null);


    }


}
