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
        StupidEvent btnEvent = new StupidEvent(gp);
        btnEvent.addMenu(stupidMenu);
        
        gp.addEvents(0, btnEvent);
        gp.addMenus(0, stupidMenu);

        gp.getEvents(0).getBtn().addActionListener((e) -> {
            System.out.println("Stupid Event");
            gp.getEvents(0).setMenuVisible(true);;
        });
        
    }
}
