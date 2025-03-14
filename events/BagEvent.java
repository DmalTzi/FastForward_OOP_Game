package events;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

import main.GamePanel;
import utilz.LoadSave;

public class BagEvent extends SuperEvents {

    public BagEvent(GamePanel gp) {
        super(gp);
        bag = new JToggleButton();
        bag.setIcon(new ImageIcon(LoadSave.GetSprite("events", "event_bag.png")));
        bag.setSize(bag.getIcon().getIconWidth(), bag.getIcon().getIconHeight());
        bag.setLocation(125, 30);
        bag.setBorder(null);
        bag.setContentAreaFilled(false);
        bag.setVisible(false);
        bag.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent itemEvent) {
                if (itemEvent.getStateChange() == ItemEvent.SELECTED) {
                    bagMenu.getMenu().setVisible(true);
                }
                else {
                    bagMenu.getMenu().setVisible(false);
                }
            }
        });
    }
}
