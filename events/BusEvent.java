package events;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLayeredPane;

import main.GamePanel;

public class BusEvent extends SuperEvents {

    private int posX;
    private int posY;

    public BusEvent(GamePanel gp, int[] poss) {
        super(gp);
        posX = poss[0];
        posY = poss[1];

        super.setIcon("events", "event_bus_stop.png");
        super.btn.setContentAreaFilled(false);
        super.btn.setBorder(null);
        super.setBound(posX, posY, btn.getIcon().getIconWidth(), btn.getIcon().getIconHeight());

        super.btn.addMouseListener(new MouseListener() {
            public void mouseReleased(MouseEvent e) {
                // if we don't check here we still use this btn
                if (btn.isEnabled()) {
                    setMenuVisible(true);
                    gp.setShowEvent(false);
                }
            }
            public void mouseEntered(MouseEvent e) {
                // same above
                if (btn.isEnabled()) {
                    setIcon("events", "event_bus_stop_hover.png");
                    setBound(posX-6, posY-5, btn.getIcon().getIconWidth(), btn.getIcon().getIconHeight());
                }
            }
            public void mouseExited(MouseEvent e) {
                // same above
                if (btn.isEnabled()) {
                    setIcon("events", "event_bus_stop.png");
                    setBound(posX, posY, btn.getIcon().getIconWidth(), btn.getIcon().getIconHeight());
                }
            }
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
        });
    }
}
