package events;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JToggleButton;

import main.GamePanel;
import menus.BagMenu;
import menus.SuperMenu;
import utilz.LoadSave;

public abstract class SuperEvents {
    protected GamePanel gp;
    protected JButton btn;
    protected SuperMenu menu;
    protected BagMenu bagMenu;
    protected String title;
    protected JToggleButton bag;

    public SuperEvents(GamePanel gp) {
        this.gp = gp;
        btn = new JButton();
        btn.setOpaque(false);
        btn.setContentAreaFilled(false);
    }

    /*
     * Override method JButton By myself
     */
    public void setBound(int x, int y, int width, int height) {
        btn.setBounds(x*gp.SCALE, y*gp.SCALE, width*gp.SCALE, height*gp.SCALE);
    }

    public void setIcon(String des, String fileName) {
        btn.setIcon(new ImageIcon(LoadSave.GetSprite(des, fileName)));
    }

    public void addMenu(SuperMenu menu) {
        this.menu = menu;
    }

    public void addBag(BagMenu bagMenu) {
        this.bagMenu = bagMenu;
    }

    public SuperMenu getSuperMenu() {
        return menu;
    }

    public JLayeredPane getMenu() {
        return menu.getMenu();
    }

    public BagMenu getBagMenu() {
        return bagMenu;
    }

    public void setMenuVisible(boolean v) {
        menu.setMenuVisible(v);
    }

    public JButton getBtn() {
        return btn;
    }

    public JToggleButton getBag() {
        return bag;
    }
}
