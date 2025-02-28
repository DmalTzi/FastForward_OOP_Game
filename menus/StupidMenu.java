package menus;

import javax.swing.JLabel;

import main.GamePanel;

public class StupidMenu extends SuperMenu{

    public StupidMenu(GamePanel gp) {
        super(gp);
        super.setBound(86, 104, 1108, 563);
        super.setImage("menus", "menu_bg.png", super.bg);

        JLabel title = new JLabel();
        title.setText("Stupid Menus");
        title.setBounds(0, 0, 100, 100);
        menu.add(title, Integer.valueOf(2));
    }
}