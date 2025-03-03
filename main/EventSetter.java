package main;

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

        HomeEvent homeEvent = new HomeEvent(gp);
        homeEvent.addMenu(new HomeMenu(gp));
        gp.addEvents(0, homeEvent);

        GeniusEvent geniusEvent = new GeniusEvent(gp);
        geniusEvent.addMenu(new GeniusMenu(gp));
        gp.addEvents(1, geniusEvent);
    }
}
