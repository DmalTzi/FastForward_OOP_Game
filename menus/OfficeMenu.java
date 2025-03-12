package menus;

import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.MouseEvent;

import main.GamePanel;
import utilz.LoadSave;

public class OfficeMenu extends SuperMenu{

    public OfficeMenu(GamePanel gp) {
        super(gp);

        defaultBg = new ImageIcon(LoadSave.GetSprite("menus", "menu_office.png"));
        bg.setIcon(defaultBg);
        menuWidth = bg.getIcon().getIconWidth();
        menuHeight = bg.getIcon().getIconHeight();
        bg.setBounds(0, 0, menuWidth*gp.SCALE, menuHeight*gp.SCALE);
        menu.setSize(menuWidth, menuHeight);
        buttonExit.setLocation((menuWidth-150)*gp.SCALE, 175*gp.SCALE);

        setUpBtns();
        setUpActionBtns();

        btns[0].setBorder(null);
        btns[0].setContentAreaFilled(false);
        menu.add(btns[0], Integer.valueOf(1));
    }

    private void setUpActionBtns() {
        btns[0].addMouseListener(new MouseListener() {
            public void mouseReleased(MouseEvent e) {
                System.out.println("Working 1hr+");
                if (gp.getPlayer().getCanWork()) {
                    gp.getPlayer().work("Office");
                }
                else {
                    btns[0].setEnabled(false);
                }
            }
            public void mouseEntered(MouseEvent e) {
                btns[0].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_working_hover.png")));
                btns[0].setSize(btns[0].getIcon().getIconWidth(), btns[0].getIcon().getIconHeight());
            }
            public void mouseExited(MouseEvent e) {
                btns[0].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_working.png")));
                btns[0].setSize(btns[0].getIcon().getIconWidth(), btns[0].getIcon().getIconHeight());
            }
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
        });
    }

    private void setUpBtns() {
        btns[0] = new JButton();
        btns[0].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_working.png")));
        btns[0].setSize(btns[0].getIcon().getIconWidth(), btns[0].getIcon().getIconHeight());
        btns[0].setLocation(550, menuHeight-200);
    }
}