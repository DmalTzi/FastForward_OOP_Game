package menus;

import java.awt.Color;
import java.awt.event.MouseListener;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import java.awt.event.MouseEvent;


import main.GamePanel;
import utilz.LoadSave;

public class BagMenu {
    GamePanel gp;
    protected JLayeredPane menu;
    protected JLabel bg;
    protected int menuWidth;
    protected int menuHeight;
    protected JButton[] btns = new JButton[2];
    protected BusMenu[] vehicleMenu = new BusMenu[2];

    public BagMenu(GamePanel gp) {
        this.gp = gp;
        menu = new JLayeredPane();
        bg = new JLabel();

        // bg.setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_bus.png")));
        bg.setBackground(null);
        // setup menuwidth and height
        menuWidth = 500;
        menuHeight = 500;
        bg.setBounds(0, 0, menuWidth*gp.SCALE, menuHeight*gp.SCALE);

        menu.setLocation(110, 110);
        menu.setSize(menuWidth, menuHeight);
        // set location of exit btn
        menu.setVisible(false);
        menu.add(bg);
        // setup btn
        setUpBtns();
        // setup action of btn
        setUpActionBtns();

        for (JButton j : btns) {
            if (j != null) {
                j.setBorder(null);
                j.setContentAreaFilled(false);
                menu.add(j, Integer.valueOf(1)); 
            }
        }
    }

    public void setUpBtns() {
        btns[0] = new JButton();
        btns[0].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_bag_disable_car.png")));
        btns[0].setSize(btns[0].getIcon().getIconWidth(), btns[0].getIcon().getIconHeight());
        btns[0].setLocation(0, 0);

        btns[1] = new JButton();
        btns[1].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_bag_disable_bike.png")));
        btns[1].setSize(btns[1].getIcon().getIconWidth(), btns[1].getIcon().getIconHeight());
        btns[1].setLocation(0, 15 + btns[0].getHeight() + btns[0].getLocation().y);
    }

    public void setUpActionBtns() {
        btns[0].addMouseListener(new MouseListener() {
            public void mouseReleased(MouseEvent e) {
                gp.setShowEvent(false);
                vehicleMenu[0].setMenuVisible(true);
            }
            public void mouseEntered(MouseEvent e) {
                if (gp.getPlayer().getInventory(0).equals("car")) {
                    btns[0].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_bag_car_hover.png")));
                }else {
                    btns[0].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_bag_disable_car.png")));
                }
            }
            public void mouseExited(MouseEvent e) {
                if (gp.getPlayer().getInventory(0).equals("car")) {
                    btns[0].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_bag_car.png")));
                }else {
                    btns[0].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_bag_disable_car.png")));
                }
            }
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
        });

        btns[1].addMouseListener(new MouseListener() {
            public void mouseReleased(MouseEvent e) {
                gp.setShowEvent(false);
                vehicleMenu[1].setMenuVisible(true);
            }
            public void mouseEntered(MouseEvent e) {
                if (gp.getPlayer().getInventory(1).equals("bike")) {
                    btns[1].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_bag_bike_hover.png")));
                }else {
                    btns[1].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_bag_disable_bike.png")));
                }
            }
            public void mouseExited(MouseEvent e) {
                if (gp.getPlayer().getInventory(1).equals("bike")) {
                    btns[1].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_bag_bike.png")));
                }else {
                    btns[1].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_bag_disable_bike.png")));
                }
            }
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
        });
    }

    public JLayeredPane getMenu() {
        return menu;
    }

    public JButton getBtn(int i) {
        return btns[i];
    }

    public void addVehicleMenu(int i, BusMenu menu) {
        this.vehicleMenu[i] = menu;
    }

    public BusMenu getVehicleMenu(int i) {
        return vehicleMenu[i];
    }
    
}
