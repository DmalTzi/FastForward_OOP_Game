package events;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import main.GamePanel;

public class HomeEvent extends SuperEvents {

    JLabel title;

    public HomeEvent(GamePanel gp) {
        super(gp);
        super.setIcon("events", "home.png");
        super.btn.setContentAreaFilled(false);
        super.btn.setBorder(null);
        super.setBound(500, 100, btn.getIcon().getIconWidth(), btn.getIcon().getIconHeight());
    }
}