package menus;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import main.GamePanel;
import utilz.LoadSave;

public abstract class SuperMenu {
    protected GamePanel gp;
    protected JLayeredPane menu;
    protected JLabel bg;
    protected JButton buttonExit;
    protected int menuWidth;
    protected int menuHeight;
    protected int menuPosX;
    protected int menuPosy;

    public SuperMenu(GamePanel gp) {
        this.gp = gp;

        menu = new JLayeredPane();

        bg = new JLabel();
        bg.setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_bg.png")));
        menuWidth = bg.getIcon().getIconWidth();
        menuHeight = bg.getIcon().getIconHeight();
        bg.setBounds(0, 0, menuWidth*gp.SCALE, menuHeight*gp.SCALE);


        menu.add(bg, JLayeredPane.POPUP_LAYER);
        menu.setVisible(false);
        menu.setBounds(45*gp.SCALE, 100*gp.SCALE, menuWidth, menuHeight);

        buttonExit = new JButton();
        buttonExit.setBorder(null);
        buttonExit.setContentAreaFilled(false);
        buttonExit.setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_exit.png")));
        buttonExit.setBounds((menuWidth-100)*gp.SCALE, 30*gp.SCALE, buttonExit.getIcon().getIconWidth(), buttonExit.getIcon().getIconHeight());

        buttonExit.addMouseListener(new MouseListener() {
            public void mouseEntered(MouseEvent e) {
                buttonExit.setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_exit_hover.png")));
            }
            public void mouseReleased(MouseEvent e) {
                menu.setVisible(false);
                gp.setShowEvent(true);
            }
            public void mouseExited(MouseEvent e) {
                buttonExit.setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_exit.png")));
            }
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
            
        });
        
        menu.add(buttonExit, JLayeredPane.DRAG_LAYER);
    }

    public void setMenuVisible(boolean v) {
        menu.setVisible(v);
    }

    public JLayeredPane getMenu() {
        return menu;
    }

}
