package inputs;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Main.GamePanel;
import gamestates.Gamestate;

public class MouseHandler implements MouseListener {

    GamePanel gp;
    public MouseHandler(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Clicked!");
        gp.py.x = e.getXOnScreen();
        gp.py.y =e.getYOnScreen();
        System.out.println("X :"+e.getXOnScreen() +"   Y : "+ e.getYOnScreen());
        Gamestate.state = Gamestate.MENU;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
    }
    
}
