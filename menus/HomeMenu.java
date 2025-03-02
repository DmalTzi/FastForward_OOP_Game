package menus;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

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
        profile.setLocation(50, 30+title.getIcon().getIconHeight());

        
        menu.add(profile, Integer.valueOf(1));
        menu.add(title, Integer.valueOf(1));
    }
}