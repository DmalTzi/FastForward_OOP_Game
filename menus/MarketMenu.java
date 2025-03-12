package menus;

import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseEvent;

import main.GamePanel;
import utilz.LoadSave;

public class MarketMenu extends SuperMenu{

    public MarketMenu(GamePanel gp) {
        super(gp);
        defaultBg = new ImageIcon(LoadSave.GetSprite("menus", "menu_market.png"));
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
        workBtn.setVisible(false);
        menu.add(workBtn, Integer.valueOf(1));

        for (JButton j : btns) {
            if (j != null) {
                j.setBorder(null);
                j.setContentAreaFilled(false);
                j.setVisible(false);
                menu.add(j, Integer.valueOf(1)); 
            }
        }

        for (JButton s : selectBtns) {
            s.setBorder(null);
            s.setContentAreaFilled(false);
            menu.add(s, Integer.valueOf(1));
        }

    }

    private void setUpActionBtns() {
        selectBtns[0].addMouseListener(new MouseListener() {
            public void mouseReleased(MouseEvent e) {
            }
            public void mouseEntered(MouseEvent e) {
                selectBtns[0].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_eat_hover.png")));
            }
            public void mouseExited(MouseEvent e) {
                selectBtns[0].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_eat.png")));
            }
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
        });

        selectBtns[1].addMouseListener(new MouseListener() {
            public void mouseReleased(MouseEvent e) {
                bg.setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_market_work.png")));
                selectBtns[0].setVisible(false);
                selectBtns[1].setVisible(false);
                workBtn.setVisible(true);
            }
            public void mouseEntered(MouseEvent e) {
                selectBtns[1].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_work_hover.png")));

            }
            public void mouseExited(MouseEvent e) {
                selectBtns[1].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_work.png")));
            }
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
        });

        workBtn.addMouseListener(new MouseListener() {
            public void mouseReleased(MouseEvent e) {
                // gp.getPlayer().work();
            }
            public void mouseEntered(MouseEvent e) {
                selectBtns[1].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_work_hover.png")));

            }
            public void mouseExited(MouseEvent e) {
                selectBtns[1].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_work.png")));
            }
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
        });
    }

    private void setUpBtns() {
        selectBtns[0] = new JButton();
        selectBtns[0].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_eat.png")));
        selectBtns[0].setSize(selectBtns[0].getIcon().getIconWidth(), selectBtns[0].getIcon().getIconHeight());
        selectBtns[0].setLocation((menuWidth/2)+125, menuHeight-125);

        selectBtns[1] = new JButton();
        selectBtns[1].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_work.png")));
        selectBtns[1].setSize(selectBtns[1].getIcon().getIconWidth(), selectBtns[1].getIcon().getIconHeight());
        selectBtns[1].setLocation(menuWidth/2-menuWidth/3, menuHeight-125);

        workBtn = new JButton();
        workBtn.setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_working.png")));
        workBtn.setSize(workBtn.getIcon().getIconWidth(), workBtn.getIcon().getIconHeight());
        workBtn.setLocation(550, menuHeight-200);
    }
}