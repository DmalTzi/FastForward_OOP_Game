package main;

import events.*;
import menus.*;

public class EventSetter {
    GamePanel gp;
    
    public EventSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setUpEvent() {

        int i = 0;
        int pos = 0;
        while (i < 4) {
            BusEvent busEvent = new BusEvent(gp, gp.ev.getBusLocation()[i]);
            busEvent.addMenu(new BusMenu(gp, gp.ev.getLocation()[i++]));
            gp.addEvents(pos++, busEvent);
        }

        HomeEvent homeEvent = new HomeEvent(gp);
        homeEvent.addMenu(new HomeMenu(gp));
        gp.addEvents(4, homeEvent);

        OfficeEvent officeEvent = new OfficeEvent(gp);
        officeEvent.addMenu(new OfficeMenu(gp));
        gp.addEvents(5, officeEvent);
        
        MarketEvent marketEvent = new MarketEvent(gp);
        marketEvent.addMenu(new MarketMenu(gp));
        gp.addEvents(6, marketEvent);
        
        SuperMarketEvent superMarketEvent = new SuperMarketEvent(gp);
        superMarketEvent.addMenu(new SuperMarketMenu(gp));
        gp.addEvents(7, superMarketEvent);

    }
}
