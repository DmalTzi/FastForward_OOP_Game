package menus;

import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Graphics2D;
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

        backWard.setBorder(null);
        backWard.setContentAreaFilled(false);
        backWard.setVisible(false);
        menu.add(backWard, Integer.valueOf(1));

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
                bg.setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_market_shop.png")));
                selectBtns[0].setVisible(false);
                selectBtns[1].setVisible(false);
                backWard.setVisible(true);
                isShopping = true;
                for (JButton j : btns) {
                    if (j != null) j.setVisible(true);
                }
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
                backWard.setVisible(true);
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
                if (gp.getPlayer().getCanWork()) {
                    gp.getPlayer().work("Market");
                }
                else {
                    btns[0].setEnabled(false);
                }
            }
            public void mouseEntered(MouseEvent e) {
                workBtn.setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_working_hover.png")));

            }
            public void mouseExited(MouseEvent e) {
                workBtn.setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_working.png")));
            }
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
        });

        backWard.addMouseListener(new MouseListener() {
            public void mouseReleased(MouseEvent e) {
                bg.setIcon(defaultBg);
                workBtn.setVisible(false);
                backWard.setVisible(false);
                selectBtns[0].setVisible(true);
                selectBtns[1].setVisible(true);
                isShopping = false;
                for (JButton j : btns) {
                    if (j != null) j.setVisible(false);
                }
            }
            public void mouseEntered(MouseEvent e) {
                backWard.setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_backward_hover.png")));
            }
            public void mouseExited(MouseEvent e) {
                backWard.setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_backward.png")));
            }
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
        });

        btns[0].addMouseListener(new MouseListener() {
            public void mouseReleased(MouseEvent e) {
                gp.getPlayer().buy("Apple");
            }
            public void mouseEntered(MouseEvent e) {
                btns[0].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_market_shop_apple_hover.png")));
            }
            public void mouseExited(MouseEvent e) {
                btns[0].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_market_shop_apple.png")));
            }
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
        });

        btns[1].addMouseListener(new MouseListener() {
            public void mouseReleased(MouseEvent e) {
                gp.getPlayer().buy("Coke");
            }
            public void mouseEntered(MouseEvent e) {
                btns[1].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_market_shop_cola_hover.png")));
            }
            public void mouseExited(MouseEvent e) {
                btns[1].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_market_shop_cola.png")));
            }
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
        });

        btns[2].addMouseListener(new MouseListener() {
            public void mouseReleased(MouseEvent e) {
                gp.getPlayer().buy("Water");
            }
            public void mouseEntered(MouseEvent e) {
                btns[2].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_market_shop_water_hover.png")));
            }
            public void mouseExited(MouseEvent e) {
                btns[2].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_market_shop_water.png")));
            }
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
        });

        btns[3].addMouseListener(new MouseListener() {
            public void mouseReleased(MouseEvent e) {
                gp.getPlayer().buy("Mama");
            }
            public void mouseEntered(MouseEvent e) {
                btns[3].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_market_shop_noodle_hover.png")));
            }
            public void mouseExited(MouseEvent e) {
                btns[3].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_market_shop_noodle.png")));
            }
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
        });

        btns[4].addMouseListener(new MouseListener() {
            public void mouseReleased(MouseEvent e) {
                gp.getPlayer().buy("Egg_fried");
            }
            public void mouseEntered(MouseEvent e) {
                btns[4].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_market_shop_egg_fire_hover.png")));
            }
            public void mouseExited(MouseEvent e) {
                btns[4].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_market_shop_egg_fire.png")));
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

        backWard = new JButton();
        backWard.setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_backward.png")));
        backWard.setSize(backWard.getIcon().getIconWidth(), backWard.getIcon().getIconHeight());
        backWard.setLocation(100, 165);

        btns[0] = new JButton();
        btns[0].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_market_shop_apple.png")));
        btns[0].setSize(btns[0].getIcon().getIconWidth(), btns[0].getIcon().getIconHeight());
        btns[0].setLocation(500, 300);

        btns[1] = new JButton();
        btns[1].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_market_shop_cola.png")));
        btns[1].setSize(btns[1].getIcon().getIconWidth(), btns[1].getIcon().getIconHeight());
        btns[1].setLocation(50 + btns[0].getWidth() + btns[0].getLocation().x, 300);

        btns[2] = new JButton();
        btns[2].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_market_shop_water.png")));
        btns[2].setSize(btns[2].getIcon().getIconWidth(), btns[2].getIcon().getIconHeight());
        btns[2].setLocation(50 + btns[1].getWidth() + btns[1].getLocation().x, 300);

        btns[3] = new JButton();
        btns[3].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_market_shop_noodle.png")));
        btns[3].setSize(btns[3].getIcon().getIconWidth(), btns[3].getIcon().getIconHeight());
        btns[3].setLocation(550, 50+btns[0].getHeight() + btns[0].getLocation().y);

        btns[4] = new JButton();
        btns[4].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_market_shop_egg_fire.png")));
        btns[4].setSize(btns[4].getIcon().getIconWidth(), btns[4].getIcon().getIconHeight());
        btns[4].setLocation(50 + btns[3].getWidth() + btns[3].getLocation().x, 50 + btns[0].getHeight() + btns[0].getLocation().y);
    }
}