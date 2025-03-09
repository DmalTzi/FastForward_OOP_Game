package events;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import main.GamePanel;

public class HomeEvent extends SuperEvents {

    JLabel title;

    public HomeEvent(GamePanel gp) {
        super(gp);
        super.setIcon("events", "event_home.png");
        super.btn.setContentAreaFilled(false);
        super.btn.setBorder(null);
        super.setBound(1123, 410, btn.getIcon().getIconWidth(), btn.getIcon().getIconHeight());
        super.btn.addMouseListener(new MouseListener() {
            public void mouseReleased(MouseEvent e) {
                gp.ev.setCurrentPosition("home");
                setMenuVisible(true);
                gp.setShowEvent(false);
            }
                public void mouseEntered(MouseEvent e) {
                    setIcon("events", "event_home_hover.png");
                }
                public void mouseExited(MouseEvent e) {
                    setIcon("events", "event_home.png");
                }
                public void mouseClicked(MouseEvent e) {}
                public void mousePressed(MouseEvent e) {}
        });
    }
}