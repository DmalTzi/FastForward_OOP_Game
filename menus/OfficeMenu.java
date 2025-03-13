package menus;

import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.event.MouseEvent;

import main.GamePanel;
import utilz.LoadSave;

public class OfficeMenu extends SuperMenu{

    public OfficeMenu(GamePanel gp) {
        super(gp);

        defaultBg = new ImageIcon(LoadSave.GetSprite("menus", "menu_office.png"));
        bg.setIcon(defaultBg);
        menuWidth = bg.getIcon().getIconWidth();
        menuHeight = bg.getIcon().getIconHeight();
        bg.setBounds(0, 0, menuWidth*gp.SCALE, menuHeight*gp.SCALE);
        menu.setSize(menuWidth, menuHeight);
        buttonExit.setLocation((menuWidth-150)*gp.SCALE, 175*gp.SCALE);

        setUpBtns();
        setUpActionBtns();

        time.setVisible(true);
        menu.add(time, Integer.valueOf(1));

        btns[0].setBorder(null);
        btns[0].setContentAreaFilled(false);
        menu.add(btns[0], Integer.valueOf(1));
    }
    
    private void setUpActionBtns() {
        btns[0].addMouseListener(new MouseListener() {
            public void mouseReleased(MouseEvent e) {
                gp.getPlayer().work("Office");
                time.setText(Integer.toString(gp.getPlayer().getWorkHr()));
            }
            public void mouseEntered(MouseEvent e) {

                btns[0].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_working_hover.png")));
                btns[0].setSize(btns[0].getIcon().getIconWidth(), btns[0].getIcon().getIconHeight());
            }
            public void mouseExited(MouseEvent e) {
                btns[0].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_working.png")));
                btns[0].setSize(btns[0].getIcon().getIconWidth(), btns[0].getIcon().getIconHeight());
            }
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
        });
    }

    private void setUpBtns() {
        btns[0] = new JButton();
        btns[0].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_working.png")));
        btns[0].setSize(btns[0].getIcon().getIconWidth(), btns[0].getIcon().getIconHeight());
        btns[0].setLocation(550, menuHeight-200);

        time = new JLabel();
        time.setFont(LoadSave.GetFont(200));
        time.setText(Integer.toString(gp.getPlayer().getWorkHr()));
        time.setSize(200, 210);
        time.setLocation(btns[0].getLocation().x+270, btns[0].getLocation().y-230);
    }

    public void draw(Graphics2D g2){
        g2.drawString(""+gp.player.getWorkHr(), menuWidth/2, menuHeight/2);
    }
}