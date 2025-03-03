package events;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import main.GamePanel;

public class HomeEvent extends SuperEvents {

    JLabel title;

    public HomeEvent(GamePanel gp) {
        super(gp);
        super.setIcon("events", "home.png");
        super.btn.setContentAreaFilled(false);
        super.btn.setBorder(null);
        super.setBound(500, 100, btn.getIcon().getIconWidth(), btn.getIcon().getIconHeight());
        super.btn.addMouseListener(new MouseListener() {
                public void mouseEntered(MouseEvent e) {}
                public void mouseReleased(MouseEvent e) {
                    System.out.println("Home Event");
                    setMenuVisible(true);
                    gp.setShowEvent(false);
                }
                public void mouseExited(MouseEvent e) {}
                public void mouseClicked(MouseEvent e) {}
                public void mousePressed(MouseEvent e) {}
        });
    }
}