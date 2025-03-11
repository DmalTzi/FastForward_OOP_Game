package menus;

import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseEvent;

import main.GamePanel;
import utilz.LoadSave;

public class HomeMenu extends SuperMenu{

    public HomeMenu(GamePanel gp) {
        super(gp);

        bg.setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_home.png")));
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
            public void mouseReleased(MouseEvent e) {
                gp.getPlayer().activity("Movie");
            }
            public void mouseEntered(MouseEvent e) {
                btns[0].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_home_watch_movie_hover.png")));
                btns[0].setSize(btns[0].getIcon().getIconWidth(), btns[0].getIcon().getIconHeight());
            }
            public void mouseExited(MouseEvent e) {
                btns[0].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_home_watch_movie.png")));
                btns[0].setSize(btns[0].getIcon().getIconWidth(), btns[0].getIcon().getIconHeight());
            }
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
        });

        btns[1].addMouseListener(new MouseListener() {
            public void mouseReleased(MouseEvent e) {
                gp.getPlayer().activity("Game");
            }
            public void mouseEntered(MouseEvent e) {
                btns[1].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_home_play_game_hover.png")));
                btns[1].setSize(btns[1].getIcon().getIconWidth(), btns[1].getIcon().getIconHeight());
            }
            public void mouseExited(MouseEvent e) {
                btns[1].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_home_play_game.png")));
                btns[1].setSize(btns[1].getIcon().getIconWidth(), btns[1].getIcon().getIconHeight());
            }
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
        });

        btns[2].addMouseListener(new MouseListener() {
            public void mouseReleased(MouseEvent e) {
                gp.getPlayer().activity("Exercise");
            }
            public void mouseEntered(MouseEvent e) {
                btns[2].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_home_exercise_hover.png")));
                btns[2].setSize(btns[2].getIcon().getIconWidth(), btns[2].getIcon().getIconHeight());
            }
            public void mouseExited(MouseEvent e) {
                btns[2].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_home_exercise.png")));
                btns[2].setSize(btns[2].getIcon().getIconWidth(), btns[2].getIcon().getIconHeight());
            }
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
        });

        btns[3].addMouseListener(new MouseListener() {
            public void mouseReleased(MouseEvent e) {
                gp.getPlayer().activity("Plante");
            }
            public void mouseEntered(MouseEvent e) {
                btns[3].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_home_plante_hover.png")));
                btns[3].setSize(btns[3].getIcon().getIconWidth(), btns[3].getIcon().getIconHeight());
            }
            public void mouseExited(MouseEvent e) {
                btns[3].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_home_plante.png")));
                btns[3].setSize(btns[3].getIcon().getIconWidth(), btns[3].getIcon().getIconHeight());
            }
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
        });

        btns[4].addMouseListener(new MouseListener() {
            public void mouseReleased(MouseEvent e) {
                gp.getPlayer().activity("ReadBk");
            }
            public void mouseEntered(MouseEvent e) {
                btns[4].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_home_read_book_hover.png")));
                btns[4].setSize(btns[4].getIcon().getIconWidth(), btns[4].getIcon().getIconHeight());
            }
            public void mouseExited(MouseEvent e) {
                btns[4].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_home_read_book.png")));
                btns[4].setSize(btns[4].getIcon().getIconWidth(), btns[4].getIcon().getIconHeight());
            }
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
        });

        btns[5].addMouseListener(new MouseListener() {
            public void mouseReleased(MouseEvent e) {
                gp.getPlayer().activity("Sleep");
            }
            public void mouseEntered(MouseEvent e) {
                btns[5].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_home_sleep_hover.png")));
                btns[5].setSize(btns[5].getIcon().getIconWidth(), btns[5].getIcon().getIconHeight());
            }
            public void mouseExited(MouseEvent e) {
                btns[5].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_home_sleep.png")));
                btns[5].setSize(btns[5].getIcon().getIconWidth(), btns[5].getIcon().getIconHeight());
            }
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
        });
    }

    private void setUpBtns() {
        btns[0] = new JButton();
        btns[0].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_home_watch_movie.png")));
        btns[0].setSize(btns[0].getIcon().getIconWidth(), btns[0].getIcon().getIconHeight());
        btns[0].setLocation(500, 220);

        btns[1] = new JButton();
        btns[1].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_home_play_game.png")));
        btns[1].setSize(btns[1].getIcon().getIconWidth(), btns[1].getIcon().getIconHeight());
        btns[1].setLocation(50+btns[0].getLocation().x + btns[0].getWidth(), 220);

        btns[2] = new JButton();
        btns[2].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_home_exercise.png")));
        btns[2].setSize(btns[2].getIcon().getIconWidth(), btns[2].getIcon().getIconHeight());
        btns[2].setLocation(50+btns[1].getLocation().x + btns[1].getWidth(), 220);

        btns[3] = new JButton();
        btns[3].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_home_plante.png")));
        btns[3].setSize(btns[3].getIcon().getIconWidth(), btns[3].getIcon().getIconHeight());
        btns[3].setLocation(500, 25+btns[0].getLocation().y + btns[0].getHeight());

        btns[4] = new JButton();
        btns[4].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_home_read_book.png")));
        btns[4].setSize(btns[4].getIcon().getIconWidth(), btns[4].getIcon().getIconHeight());
        btns[4].setLocation(50+btns[3].getLocation().x + btns[3].getWidth(), 25+btns[0].getLocation().y + btns[0].getHeight());

        btns[5] = new JButton();
        btns[5].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_home_sleep.png")));
        btns[5].setSize(btns[5].getIcon().getIconWidth(), btns[5].getIcon().getIconHeight());
        btns[5].setLocation(50+btns[4].getLocation().x + btns[4].getWidth(), 25+btns[0].getLocation().y + btns[0].getHeight());
    }
}