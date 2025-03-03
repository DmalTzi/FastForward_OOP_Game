package menus;

import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseEvent;

import main.GamePanel;
import utilz.LoadSave;

public class HomeMenu extends SuperMenu{

    private JLabel title;
    private JButton btns[] = new JButton[6];
    private JLabel profile;

    public HomeMenu(GamePanel gp) {
        super(gp);
        title = new JLabel();
        title.setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_title_home.png")));
        title.setBounds(70*gp.SCALE, 30*gp.SCALE, title.getIcon().getIconWidth(), title.getIcon().getIconHeight());
        title.setOpaque(false);

        profile = new JLabel();
        profile.setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_profile.png")));
        profile.setSize(profile.getIcon().getIconWidth(), profile.getIcon().getIconHeight());
        profile.setLocation(70, 30+title.getHeight());

        setUpBtns();
        setUpActionBtns();

        for (JButton j : btns) {
            j.setBorder(null);
            j.setContentAreaFilled(false);
            menu.add(j, Integer.valueOf(1)); 
        }
        menu.add(profile, Integer.valueOf(1));
        menu.add(title, Integer.valueOf(1));
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

        btns[2].addMouseListener(new MouseListener() {
            public void mouseEntered(MouseEvent e) {
                System.out.println("You Click top right");
            }
            public void mouseReleased(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
        });

        btns[3].addMouseListener(new MouseListener() {
            public void mouseEntered(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {
                System.out.println("You Click bottom left");
                gp.ev.setTime(3);
            }
            public void mouseExited(MouseEvent e) {}
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
        });

        btns[4].addMouseListener(new MouseListener() {
            public void mouseEntered(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {
                System.out.println("You Click bottom middle");
            }
            public void mouseExited(MouseEvent e) {}
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
        });

        btns[5].addMouseListener(new MouseListener() {
            public void mouseEntered(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {
                System.out.println("You Click bottom right");
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
        btns[0].setLocation(60+profile.getWidth() + profile.getLocation().x, 30+title.getHeight());

        btns[1] = new JButton();
        btns[1].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_sub_btn.png")));
        btns[1].setSize(btns[1].getIcon().getIconWidth(), btns[1].getIcon().getIconHeight());
        btns[1].setLocation(60 + btns[0].getLocation().x+btns[0].getWidth(), 30+title.getHeight());

        btns[2] = new JButton();
        btns[2].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_sub_btn.png")));
        btns[2].setSize(btns[2].getIcon().getIconWidth(), btns[2].getIcon().getIconHeight());
        btns[2].setLocation(60 + btns[1].getLocation().x+btns[1].getWidth(), 30+title.getHeight());

        btns[3] = new JButton();
        btns[3].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_sub_btn.png")));
        btns[3].setSize(btns[3].getIcon().getIconWidth(), btns[3].getIcon().getIconHeight());
        btns[3].setLocation(60+profile.getWidth() + profile.getLocation().x, 30+btns[0].getLocation().y +btns[0].getHeight());

        btns[4] = new JButton();
        btns[4].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_sub_btn.png")));
        btns[4].setSize(btns[4].getIcon().getIconWidth(), btns[4].getIcon().getIconHeight());
        btns[4].setLocation(60+btns[3].getWidth() + btns[3].getLocation().x, 30+btns[0].getLocation().y +btns[0].getHeight());

        btns[5] = new JButton();
        btns[5].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_sub_btn.png")));
        btns[5].setSize(btns[5].getIcon().getIconWidth(), btns[5].getIcon().getIconHeight());
        btns[5].setLocation(60+btns[4].getWidth() + btns[4].getLocation().x, 30+btns[0].getLocation().y +btns[0].getHeight());
    }
}