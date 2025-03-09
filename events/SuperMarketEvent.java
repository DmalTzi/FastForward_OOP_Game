package events;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import main.GamePanel;

public class SuperMarketEvent extends SuperEvents {

    public SuperMarketEvent(GamePanel gp) {
        super(gp);
        super.setIcon("events", "event_supermarket.png");
        super.btn.setContentAreaFilled(false);
        super.btn.setBorder(null);
        super.setBound(600, 158, btn.getIcon().getIconWidth(), btn.getIcon().getIconHeight());
        super.btn.addMouseListener(new MouseListener() {
            public void mouseReleased(MouseEvent e) {
                gp.ev.setCurrentPosition("supermarket");
                setMenuVisible(true);
                gp.setShowEvent(false);
            }
            public void mouseEntered(MouseEvent e) {
                setIcon("events", "event_supermarket_hover.png");
            }
            public void mouseExited(MouseEvent e) {
                setIcon("events", "event_supermarket.png");
            }
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
        });
    }
}
