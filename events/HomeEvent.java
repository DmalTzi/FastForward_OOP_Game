package events;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

import javax.swing.JLabel;

import main.GamePanel;

public class HomeEvent extends SuperEvents {

    public HomeEvent(GamePanel gp) {
        super(gp);
        super.title = "home";
        super.setIcon("events", "event_home.png");
        super.btn.setContentAreaFilled(false);
        super.btn.setBorder(null);
        super.setBound(1123, 410, btn.getIcon().getIconWidth(), btn.getIcon().getIconHeight());
        super.btn.addMouseListener(new MouseListener() {
            public void mouseReleased(MouseEvent e) {
                // use increaseTime ขั้นแรก หาตำแหน่งปัจุบันของเรา ด้วยการ getCUrrentPosition ขั้นสอง หาตำแหน่งของที่นี่ผ่าน title แล้วเอาไปเทียบตำแหน่ง index ที่ทำเอาไว้
                gp.getEarth().increaseTime(gp.getEventManager()
                .goToNextEvent(Arrays.asList(gp.getEarth().getLocation())
                                .indexOf(gp.getPlayer().getCurrentPosition()), 
                                Arrays.asList(gp.getEarth().getLocation())
                                .indexOf(title), gp.getPlayer().getMoveWith()));
                gp.getPlayer().setCurrentPosition(title);
                gp.setShowEvent(false);
                setMenuVisible(true);
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