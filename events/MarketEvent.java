package events;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import main.GamePanel;

public class MarketEvent extends SuperEvents {

    public MarketEvent(GamePanel gp) {
        super(gp);
        super.setIcon("events", "event_market.png");
        super.btn.setContentAreaFilled(false);
        super.btn.setBorder(null);
        super.setBound(335, 580, btn.getIcon().getIconWidth(), btn.getIcon().getIconHeight());
        super.btn.addMouseListener(new MouseListener() {
            public void mouseReleased(MouseEvent e) {
                setMenuVisible(true);
                gp.ev.setCurrentPosition("market");
                gp.setShowEvent(false);
            }
            public void mouseEntered(MouseEvent e) {
                setIcon("events", "event_market_hover.png");
            }
            public void mouseExited(MouseEvent e) {
                setIcon("events", "event_market.png");
            }
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
        });
    }
}
