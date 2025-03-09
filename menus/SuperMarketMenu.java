package menus;

import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseEvent;

import main.GamePanel;
import utilz.LoadSave;

public class SuperMarketMenu extends SuperMenu{

    public SuperMarketMenu(GamePanel gp) {
        super(gp);

        bg.setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_supermarket.png")));
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
                System.out.println("You Click top left");
            }
            public void mouseExited(MouseEvent e) {}
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
        });

        btns[1].addMouseListener(new MouseListener() {
            public void mouseEntered(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {
                System.out.println("You Click top middle");
            }
            public void mouseExited(MouseEvent e) {}
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
        });
    }

    private void setUpBtns() {
        btns[0] = new JButton();
        btns[0].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_sub_btn.png")));
        btns[0].setSize(btns[0].getIcon().getIconWidth(), btns[0].getIcon().getIconHeight());
        // btns[0].setLocation(100+profile.getWidth() + profile.getLocation().x, 30+title.getHeight());

        btns[1] = new JButton();
        btns[1].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_sub_btn.png")));
        btns[1].setSize(btns[1].getIcon().getIconWidth(), btns[1].getIcon().getIconHeight());
        // btns[1].setLocation(100 + btns[0].getLocation().x+btns[0].getWidth(), 30+title.getHeight());
    }
}