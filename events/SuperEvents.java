package events;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLayeredPane;

import main.GamePanel;
import menus.SuperMenu;
import utilz.LoadSave;

public abstract class SuperEvents {
    protected GamePanel gp;
    protected JButton btn;
    protected SuperMenu menu;

    public SuperEvents(GamePanel gp) {
        this.gp = gp;
        btn = new JButton();
        btn.setOpaque(false);
        // btn.addFocusListener(new FocusListener() {

        //     @Override
        //     public void focusGained(FocusEvent e) {
        //     btn.setBorder(new LineBorder(Color.RED));
        //     }

        //     @Override
        //     public void focusLost(FocusEvent e) {
        //     btn.setBorder(new LineBorder(Color.WHITE));
        //     }
        // });
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

    public SuperMenu getSuperMenu() {
        return menu;
    }

    public JLayeredPane getMenu() {
        return menu.getMenu();
    }

    public void setMenuVisible(boolean v) {
        menu.setMenuVisible(v);
    }

    public JButton getBtn() {
        return btn;
    }
}
