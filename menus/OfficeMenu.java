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

        workBtn.setBorder(null);
        workBtn.setContentAreaFilled(false);
        menu.add(workBtn, Integer.valueOf(1));
    }

    private void setUpActionBtns() {
        workBtn.addMouseListener(new MouseListener() {
            public void mouseReleased(MouseEvent e) {
                System.out.println("Working 1hr+");
                if (gp.getPlayer().getCanWork()) {
                    gp.getPlayer().work("Office");
                }
                else {
                    workBtn.setEnabled(false);
                }
            }
            public void mouseEntered(MouseEvent e) {
                workBtn.setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_working_hover.png")));
                workBtn.setSize(workBtn.getIcon().getIconWidth(), workBtn.getIcon().getIconHeight());
            }
            public void mouseExited(MouseEvent e) {
                workBtn.setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_working.png")));
                workBtn.setSize(workBtn.getIcon().getIconWidth(), workBtn.getIcon().getIconHeight());
            }
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
        });
    }

    private void setUpBtns() {
        workBtn = new JButton();
        workBtn.setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_working.png")));
        workBtn.setSize(workBtn.getIcon().getIconWidth(), workBtn.getIcon().getIconHeight());
        workBtn.setLocation(550, menuHeight-200);
    }
}