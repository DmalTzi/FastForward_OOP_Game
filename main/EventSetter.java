package main;

import javax.swing.JButton;

import events.GeniusEvent;
import events.HomeEvent;
import menus.GeniusMenu;
import menus.HomeMenu;

public class EventSetter {
    GamePanel gp;
    
    public EventSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setUpEvent() {

        HomeMenu stupidMenu = new HomeMenu(gp);
        HomeEvent btnEvent = new HomeEvent(gp);
        btnEvent.addMenu(stupidMenu);
        
        gp.addEvents(0, btnEvent);
        gp.addMenus(0, stupidMenu);

        gp.getEvents(0).getBtn().addActionListener((e) -> {
            System.out.println("Stupid Event");
            gp.getEvents(0).setMenuVisible(true);
            gp.setShowEvent(false);
        });

        GeniusMenu geniusMenu = new GeniusMenu(gp);
        GeniusEvent btnMenu = new GeniusEvent(gp);
        btnMenu.addMenu(geniusMenu);
        
        gp.addEvents(1, btnMenu);
        gp.addMenus(1, geniusMenu);

        gp.getEvents(1).getBtn().addActionListener((e) -> {
            System.out.println("Genius Event");
            gp.getEvents(1).setMenuVisible(true);
            gp.setShowEvent(false);
        });
        
    }
}
