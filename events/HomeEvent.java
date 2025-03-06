package events;


import javax.swing.JLabel;

import main.GamePanel;

public class HomeEvent extends SuperEvents {

    JLabel title;

    public HomeEvent(GamePanel gp) {
        super(gp);
        super.setIcon("events", "home.png");
        super.btn.setContentAreaFilled(false);
        super.btn.setBorder(null);
        super.setBound(1120, 405, btn.getIcon().getIconWidth(), btn.getIcon().getIconHeight());
    }
}