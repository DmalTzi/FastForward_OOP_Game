package menus;

import java.awt.Button;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import main.GamePanel;
import utilz.LoadSave;

public abstract class SuperMenu {
    private GamePanel gp;
    private JLayeredPane menu;
    private JLabel bg;
    private JButton buttonExit;

    public SuperMenu(GamePanel gp) {
        this.gp = gp;

        menu = new JLayeredPane();

        bg = new JLabel();
        bg.setOpaque(true);

        menu.add(bg, Integer.valueOf(0));
        menu.setVisible(false);

        
        buttonExit = new JButton();
        buttonExit.addActionListener((e) -> {
            menu.setVisible(false);
        });

        buttonExit.setOpaque(true);
        menu.add(buttonExit, Integer.valueOf(1));

    }

    public void setBound(int x, int y, int width, int height) {
        menu.setBounds(x, y, width, height);
        bg.setBounds(x, y, width, height);
        buttonExit.setBounds(x,y, 20, 20);
    }

    public void setBackground(String des, String fileName) {
        bg.setIcon(new ImageIcon(LoadSave.GetSprite(des, fileName)));
    }

    public void addButton(Component btn) {
        menu.add(btn, Integer.valueOf(2));
    }

    public void setVisible(boolean v) {
        menu.setVisible(v);
    }

    public JLayeredPane getMenu() {
        return menu;
    }

}
