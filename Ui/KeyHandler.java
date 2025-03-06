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
                gp.title.commandNum --;
            } if(code ==KeyEvent.VK_S){
                gp.title.commandNum ++;
            }
            if(gp.title.commandNum > 1 ){
                gp.title.commandNum = 0 ;
            }else if(gp.title.commandNum < 0){
                gp.title.commandNum = 1 ;
            }

            if(code == KeyEvent.VK_ENTER){
                if(gp.title.commandNum  == 0){
                    gp.setgameState(GameState.Gameplay);
                }else if(gp.title.commandNum  == 1){
                    System.exit(0);
                }
            }
       }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    
    }
    
}