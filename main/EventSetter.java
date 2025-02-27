package main;

import javax.swing.JButton;

import events.GeniusEvent;
import events.StupidEvent;
import menus.GeniusMenu;
import menus.StupidMenu;

public class EventSetter {
    GamePanel gp;
    
    public EventSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setUpEvent() {
        StupidMenu stupidMenu = new StupidMenu(gp);
        stupidMenu.setBound(0, 0, 219, 176);
        stupidMenu.setBackground("menus", "menu_exit.png");

        JButton b = new JButton("Show Text");
        b.setBounds(10, 10, 30, 30);
        b.addActionListener(e -> System.out.println("Bullshit Text"));
        stupidMenu.addButton(b);
        
        StupidEvent btnEvent = new StupidEvent(gp);
        btnEvent.setBound(200, 200, 100, 100);
        btnEvent.setIcon("backgrounds", "menu_background.png");
        btnEvent.addMenu(stupidMenu);

        gp.addEvents(0, btnEvent);
        gp.addMenus(0, stupidMenu);

        gp.getEvents(0).getBtn().addActionListener((e) -> {
            System.out.println("Stupid Event");
            gp.getEvents(0).setVisible(true);;
        });
        // ==========================================
        GeniusMenu geniusMenu = new GeniusMenu(gp);
        geniusMenu.setBound(0, 0, 219, 176);
        geniusMenu.setBackground("menus", "menu_exit.png");


        JButton b1 = new JButton();
        b1.setBounds(10, 10, 30, 30);
        b1.addActionListener(e -> System.out.println("Bullshit Text1"));

        JButton b2 = new JButton();
        b2.setBounds(30, 30, 30, 30);
        b2.addActionListener(e -> System.out.println("Bullshit Text2"));

        geniusMenu.addButton(b1);
        geniusMenu.addButton(b2);
        
        GeniusEvent btnEvent2 = new GeniusEvent(gp);
        btnEvent2.setBound(300, 300, 100, 100);
        btnEvent2.setIcon("backgrounds", "menu_background.png");
        btnEvent2.addMenu(geniusMenu);

        gp.addEvents(1, btnEvent2);
        gp.addMenus(1, geniusMenu);

        gp.getEvents(1).getBtn().addActionListener((e) -> {
            System.out.println("Genius");
            gp.getEvents(1).getMenu().setVisible(true);
        });

    }
}
