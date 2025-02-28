package menus;

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
        menu.setBounds(x*gp.SCALE, y*gp.SCALE, width*gp.SCALE, height*gp.SCALE);
        bg.setBounds(0, 0, width*gp.SCALE, height*gp.SCALE);
        buttonExit.setBounds((width-30)*gp.SCALE, 30*gp.SCALE, 20, 20);
    }

    public void setImage(String des, String fileName, JLabel c) {
        c.setIcon(new ImageIcon(LoadSave.GetSprite(des, fileName)));
    }

    public void setMenuVisible(boolean v) {
        menu.setVisible(v);
    }

    public JLayeredPane getMenu() {
        return menu;
    }

}
