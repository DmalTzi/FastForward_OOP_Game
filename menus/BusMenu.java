package menus;

import java.awt.event.MouseListener;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseEvent;

import main.GamePanel;
import utilz.LoadSave;

public class BusMenu extends SuperMenu{

    // all possible is all location we have
    private JButton allPossible[] = new JButton[4];
    // every busstop have own location
    private String location;

    public BusMenu(GamePanel gp, String location) {
        super(gp);

        this.location = location;

        defaultBg = new ImageIcon(LoadSave.GetSprite("menus", "menu_bus.png"));
        bg.setIcon(defaultBg);
        // setup menuwidth and height
        menuWidth = bg.getIcon().getIconWidth();
        menuHeight = bg.getIcon().getIconHeight();
        bg.setBounds(0, 0, menuWidth*gp.SCALE, menuHeight*gp.SCALE);
        menu.setSize(menuWidth, menuHeight);
        // set location of exit btn
        buttonExit.setLocation((menuWidth-150)*gp.SCALE, 175*gp.SCALE);

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

    private void setUpActionBtns() {
        // set all possible btn
        allPossible[0].addMouseListener(new MouseListener() {
            public void mouseReleased(MouseEvent e) {
                int time = gp.getEventManager()
                .goToNextEvent(Arrays.asList(gp.getEarth().getLocation())
                                .indexOf(gp.getPlayer().getCurrentPosition()), 
                                Arrays.asList(gp.getEarth().getLocation())
                                .indexOf(gp.getEarth().getLocation()[0]), "bus");
                if (time > 0) {
                    menu.setVisible(false);
                    gp.getEarth().increaseTime(time);
                    gp.setShowEvent(true);
                }
                // after you select location where you want to go
                // set new position to current position
                // disable menu
                // show all locatin aka. event
            }
            public void mouseEntered(MouseEvent e) {
                // hover
                allPossible[0].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_bus_" + gp.getEarth().getLocation()[0] + "_hover.png")));
            }
            public void mouseExited(MouseEvent e) {
                // not hover
                allPossible[0].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_bus_" + gp.getEarth().getLocation()[0] + ".png")));
            }
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
        });

        // repeat
        allPossible[1].addMouseListener(new MouseListener() {
            public void mouseReleased(MouseEvent e) {
                int time = gp.getEventManager()
                .goToNextEvent(Arrays.asList(gp.getEarth().getLocation())
                                .indexOf(gp.getPlayer().getCurrentPosition()), 
                                Arrays.asList(gp.getEarth().getLocation())
                                .indexOf(gp.getEarth().getLocation()[1]), "bus");
                if (time > 0) {
                    menu.setVisible(false);
                    gp.getEarth().increaseTime(time);
                    gp.setShowEvent(true);
                }
            }
            public void mouseEntered(MouseEvent e) {
                allPossible[1].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_bus_" + gp.getEarth().getLocation()[1] + "_hover.png")));
                allPossible[1].setSize(allPossible[1].getIcon().getIconWidth(), allPossible[1].getIcon().getIconHeight());
            }
            public void mouseExited(MouseEvent e) {
                allPossible[1].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_bus_" + gp.getEarth().getLocation()[1] + ".png")));
                allPossible[1].setSize(allPossible[1].getIcon().getIconWidth(), allPossible[1].getIcon().getIconHeight());
            }
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
        });

        allPossible[2].addMouseListener(new MouseListener() {
            public void mouseReleased(MouseEvent e) {
                int time = gp.getEventManager()
                .goToNextEvent(Arrays.asList(gp.getEarth().getLocation())
                                .indexOf(gp.getPlayer().getCurrentPosition()), 
                                Arrays.asList(gp.getEarth().getLocation())
                                .indexOf(gp.getEarth().getLocation()[2]), "bus");
                if (time > 0) {
                    menu.setVisible(false);
                    gp.getEarth().increaseTime(time);
                    gp.setShowEvent(true);
                }
            }
            public void mouseEntered(MouseEvent e) {
                allPossible[2].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_bus_" + gp.getEarth().getLocation()[2] + "_hover.png")));
                allPossible[2].setSize(allPossible[2].getIcon().getIconWidth(), allPossible[2].getIcon().getIconHeight());
            }
            public void mouseExited(MouseEvent e) {
                allPossible[2].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_bus_" + gp.getEarth().getLocation()[2] + ".png")));
                allPossible[2].setSize(allPossible[2].getIcon().getIconWidth(), allPossible[2].getIcon().getIconHeight());
            }
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
        });

        allPossible[3].addMouseListener(new MouseListener() {
            public void mouseReleased(MouseEvent e) {
                int time = gp.getEventManager()
                .goToNextEvent(Arrays.asList(gp.getEarth().getLocation())
                                .indexOf(gp.getPlayer().getCurrentPosition()), 
                                Arrays.asList(gp.getEarth().getLocation())
                                .indexOf(gp.getEarth().getLocation()[3]), "bus");
                if (time > 0) {
                    menu.setVisible(false);
                    gp.getEarth().increaseTime(time);
                    gp.setShowEvent(true);
                }
            }
            public void mouseEntered(MouseEvent e) {
                allPossible[3].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_bus_" + gp.getEarth().getLocation()[3] + "_hover.png")));
                allPossible[3].setSize(allPossible[3].getIcon().getIconWidth(), allPossible[3].getIcon().getIconHeight());
            }
            public void mouseExited(MouseEvent e) {
                allPossible[3].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_bus_" + gp.getEarth().getLocation()[3] + ".png")));
                allPossible[3].setSize(allPossible[3].getIcon().getIconWidth(), allPossible[3].getIcon().getIconHeight());
            }
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
        });
    }

    private void setUpBtns() {
        // checkEach is loop allpossible time aka 4 time aka. 4 event
        int checkEach = 0;
        // useCheck is, we chose 3 in 4 to show in our menu because we don't show current event
        int useCheck = 0;

        // create all allPossible event
        allPossible[0] = new JButton();
        allPossible[0].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_bus_" + gp.getEarth().getLocation()[0] + ".png")));
        allPossible[0].setSize(allPossible[0].getIcon().getIconWidth(), allPossible[0].getIcon().getIconHeight());

        allPossible[1] = new JButton();
        allPossible[1].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_bus_" + gp.getEarth().getLocation()[1] + ".png")));
        allPossible[1].setSize(allPossible[1].getIcon().getIconWidth(), allPossible[1].getIcon().getIconHeight());

        allPossible[2] = new JButton();
        allPossible[2].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_bus_" + gp.getEarth().getLocation()[2] + ".png")));
        allPossible[2].setSize(allPossible[2].getIcon().getIconWidth(), allPossible[2].getIcon().getIconHeight());

        allPossible[3] = new JButton();
        allPossible[3].setIcon(new ImageIcon(LoadSave.GetSprite("menus", "menu_bus_" + gp.getEarth().getLocation()[3] + ".png")));
        allPossible[3].setSize(allPossible[3].getIcon().getIconWidth(), allPossible[3].getIcon().getIconHeight());

        // start loop
        while (checkEach < 4) {
            // if location in list is 4 == this location
            if (gp.getEarth().getLocation()[checkEach].equals(location)) {
                // after we found it, we will skip location that in allpossible
                checkEach++;
                continue;
            }
            
            // push allpossible into btns
            btns[useCheck] = allPossible[checkEach];
            // set localtion with genius method haha (bad joke)
            btns[useCheck].setLocation(25+(useCheck-1 >= 0? btns[useCheck-1].getLocation().x+btns[useCheck-1].getWidth():75), (menuHeight/2)-50);
            useCheck++;
            checkEach++;
        }
    }
}