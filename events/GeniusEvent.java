package events;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import main.GamePanel;

public class GeniusEvent extends SuperEvents {
    JLabel title;

    public GeniusEvent(GamePanel gp) {
        super(gp);
        super.setIcon("events", "supermarket.png");
        super.btn.setContentAreaFilled(false);
        super.btn.setBorder(null);
        super.setBound(500, 500, btn.getIcon().getIconWidth(), btn.getIcon().getIconHeight());
        super.btn.addMouseListener(new MouseListener() {
                public void mouseEntered(MouseEvent e) {}
                public void mouseReleased(MouseEvent e) {
                    System.out.println("Genius Event");
                    setMenuVisible(true);
                    gp.setShowEvent(false);
                }
                public void mouseExited(MouseEvent e) {}
                public void mouseClicked(MouseEvent e) {}
                public void mousePressed(MouseEvent e) {}
        });
    }
    
}
