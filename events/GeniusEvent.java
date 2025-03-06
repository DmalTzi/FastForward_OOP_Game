package events;

import javax.swing.JLabel;

import main.GamePanel;

public class GeniusEvent extends SuperEvents {
    JLabel title;

    public GeniusEvent(GamePanel gp) {
        super(gp);
        super.setIcon("events", "supermarket.png");
        super.btn.setContentAreaFilled(false);
        super.btn.setBorder(null);
        super.setBound(600, 175, btn.getIcon().getIconWidth(), btn.getIcon().getIconHeight());
    }
    
}
