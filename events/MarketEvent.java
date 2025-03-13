package events;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

import javax.swing.JButton;

import main.GamePanel;

public class MarketEvent extends SuperEvents {

    public MarketEvent(GamePanel gp) {
        super(gp);
        super.title = "market";
        super.setIcon("events", "event_market.png");
        super.btn.setContentAreaFilled(false);
        super.btn.setBorder(null);
        super.setBound(335, 580, btn.getIcon().getIconWidth(), btn.getIcon().getIconHeight());
        super.btn.addMouseListener(new MouseListener() {
            public void mouseReleased(MouseEvent e) {
                gp.getEarth().increaseTime(gp.getEventManager()
                .goToNextEvent(Arrays.asList(gp.getEarth().getLocation())
                                .indexOf(gp.getPlayer().getCurrentPosition()), 
                                Arrays.asList(gp.getEarth().getLocation())
                                .indexOf(title), gp.getPlayer().getMoveWith()));
                gp.getPlayer().setCurrentPosition(title);
                gp.setShowEvent(false);
                setMenuVisible(true);
                for (JButton j : getSuperMenu().getButtons()) {
                    if (j != null)
                        j.setVisible(false);
                }
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
