package events;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

import main.GamePanel;

public class OfficeEvent extends SuperEvents {

    public OfficeEvent(GamePanel gp) {
        super(gp);
        super.title = "office";
        super.setIcon("events", "event_office.png");
        super.btn.setContentAreaFilled(false);
        super.btn.setBorder(null);
        super.setBound(10, 152, btn.getIcon().getIconWidth(), btn.getIcon().getIconHeight());
        super.btn.addMouseListener(new MouseListener() {
            public void mouseReleased(MouseEvent e) {
                gp.getEarth().increaseTime(gp.getEventManager()
                .goToNextEvent(Arrays.asList(gp.getEarth().getLocation())
                                .indexOf(gp.getPlayer().getCurrentPosition()), 
                                Arrays.asList(gp.getEarth().getLocation())
                                .indexOf(title), gp.getPlayer().getMoveWith()));
                gp.getPlayer().setCurrentPosition(title);
                gp.setShowEvent(false);
                getSuperMenu().getTime().setVisible(true);
                setMenuVisible(true);
            }
            public void mouseEntered(MouseEvent e) {
                setIcon("events", "event_office_hover.png");
            }
            public void mouseExited(MouseEvent e) {
                setIcon("events", "event_office.png");
            }
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
        });
    }
}
