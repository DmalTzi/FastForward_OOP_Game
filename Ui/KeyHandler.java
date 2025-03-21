package Ui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.GamePanel;
import main.GameState;

public class KeyHandler implements KeyListener  {
    GamePanel gp ; 
    public KeyHandler(GamePanel gp){
        this.gp = gp;
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
      int code = e.getKeyCode();
       if(gp.getgameState() == GameState.Title){
            if(code ==KeyEvent.VK_W){
                gp.getTitle().commandNum --;
            } if(code ==KeyEvent.VK_S){
                gp.getTitle().commandNum ++;
            }
            if(gp.getTitle().commandNum > 1 ){
                gp.getTitle().commandNum = 0 ;
            }else if(gp.getTitle().commandNum < 0){
                gp.getTitle().commandNum = 1 ;
            }

            if(code == KeyEvent.VK_ENTER){
                if(gp.getTitle().commandNum  == 0){
                    gp.setgameState(GameState.Gameplay);
                    gp.playMu = true;
                    gp.setStart();
                }else if(gp.getTitle().commandNum  == 1){
                    System.exit(0);
                }
            }
       }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    
    }
    
}