package events;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

import main.GamePanel;

public class SuperMarketEvent extends SuperEvents {

    public SuperMarketEvent(GamePanel gp) {
        super(gp);
        super.title = "supermarket";
        super.setIcon("events", "event_supermarket.png");
        super.btn.setContentAreaFilled(false);
        super.btn.setBorder(null);
        super.setBound(600, 158, btn.getIcon().getIconWidth(), btn.getIcon().getIconHeight());
        super.btn.addMouseListener(new MouseListener() {
            public void mouseReleased(MouseEvent e) {
                gp.getEarth().increaseTime(gp.getEventManager()
                .goToNextEvent(Arrays.asList(gp.getEarth().getLocation())
                                .indexOf(gp.getEarth().getCurrentPosition()), 
                                Arrays.asList(gp.getEarth().getLocation())
                                .indexOf(title), gp.getEarth().getMoveWith()));
                gp.getEarth().setCurrentPosition(title);
                gp.setShowEvent(false);
                setMenuVisible(true);
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
