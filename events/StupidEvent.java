package events;

import javax.swing.JLabel;

import main.GamePanel;

public class StupidEvent extends SuperEvents {

    JLabel title;

    public StupidEvent(GamePanel gp) {
        super(gp);
        super.setBound(0, 0, 100, 100);
        super.setIcon("events", "btn2.png");

  
    }
}