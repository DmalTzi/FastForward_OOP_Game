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

        bg.setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_office.png")));
        menuWidth = bg.getIcon().getIconWidth();
        menuHeight = bg.getIcon().getIconHeight();
        bg.setBounds(0, 0, menuWidth*gp.SCALE, menuHeight*gp.SCALE);
        menu.setSize(menuWidth, menuHeight);
        buttonExit.setLocation((menuWidth-150)*gp.SCALE, 175*gp.SCALE);

        setUpBtns();
        setUpActionBtns();

        for (JButton j : btns) {
            if (j != null) {
                j.setBorder(null);
                j.setContentAreaFilled(false);
                menu.add(j, Integer.valueOf(1)); 
            }
        }
    }

    private void setUpActionBtns() {
        btns[0].addMouseListener(new MouseListener() {
            public void mouseEntered(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {
                System.out.println("Working 1hr+");
                gp.player.work("Office");
                if (gp.player.getWorkHr() < 8) {
                    System.out.println(gp.player.getWorkHr());
                }
                else {
                    System.out.println("work hour reach limit");
                }
            }
            public void mouseExited(MouseEvent e) {}
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
        });
    }

    private void setUpBtns() {
        btns[0] = new JButton();
        btns[0].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_office_working.png")));
        btns[0].setSize(btns[0].getIcon().getIconWidth(), btns[0].getIcon().getIconHeight());
        btns[0].setLocation(550, menuHeight-200);
    }
}