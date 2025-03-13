package menus;

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
    protected JButton btns[] = new JButton[10];
    protected JButton selectBtns[] = new JButton[2];
    protected JButton workBtn;
    protected boolean isShopping = false;
    protected JButton backWard;
    ImageIcon defaultBg;

    public SuperMenu(GamePanel gp) {
        this.gp = gp;

        menu = new JLayeredPane();
        bg = new JLabel();
        buttonExit = new JButton();

        menu.setVisible(false);
        menu.setLocation(0*gp.SCALE, 0*gp.SCALE);

        buttonExit.setBorder(null);
        buttonExit.setContentAreaFilled(false);
        buttonExit.setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_exit.png")));
        buttonExit.setSize(buttonExit.getIcon().getIconWidth(), buttonExit.getIcon().getIconHeight());

        buttonExit.addMouseListener(new MouseListener() {
            public void mouseEntered(MouseEvent e) {
                buttonExit.setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_exit_hover.png")));
            }
            public void mouseReleased(MouseEvent e) {
                menu.setVisible(false);
                gp.setShowEvent(true);
                bg.setIcon(defaultBg);
                if (selectBtns[0] != null && selectBtns[1] != null) {
                    selectBtns[0].setVisible(true);
                    selectBtns[1].setVisible(true);
                }

                if (isShopping) {
                    workBtn.setVisible(false);
                    backWard.setVisible(false);
                    for (JButton j : btns) {
                        if (j != null) {
                            j.setVisible(false);
                        }
                    }
                }else {
                    for (JButton j : btns) {
                        if (j != null) {
                            j.setVisible(true);
                        }
                    }
                }
                isShopping = false;
            }
            public void mouseExited(MouseEvent e) {
                buttonExit.setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_exit.png")));
            }
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
        });


        menu.add(bg, Integer.valueOf(0));
        menu.add(buttonExit, Integer.valueOf(1));
    }

    public void setMenuVisible(boolean v) {
        menu.setVisible(v);
    }

    public JLayeredPane getMenu() {
        return menu;
    }

    public JButton[] getButtons() {
        return btns;
    }

}
