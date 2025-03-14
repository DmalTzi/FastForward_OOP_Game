package main;

import events.BagEvent;
import events.BusEvent;
import events.HomeEvent;
import events.MarketEvent;
import events.OfficeEvent;
import events.SuperMarketEvent;
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
            BusEvent busEvent = new BusEvent(gp, gp.getEarth().getBusLocation()[i]);
            busEvent.addMenu(new BusMenu(gp, gp.getEarth().getLocation()[i++], "bus"));
            gp.addEvents(pos++, busEvent);
        }

        
        MarketEvent marketEvent = new MarketEvent(gp);
        marketEvent.addMenu(new MarketMenu(gp));
        gp.addEvents(4, marketEvent);
        
        OfficeEvent officeEvent = new OfficeEvent(gp);
        officeEvent.addMenu(new OfficeMenu(gp));
        gp.addEvents(5, officeEvent);
        
        SuperMarketEvent superMarketEvent = new SuperMarketEvent(gp);
        superMarketEvent.addMenu(new SuperMarketMenu(gp));
        gp.addEvents(6, superMarketEvent);

        HomeEvent homeEvent = new HomeEvent(gp);
        homeEvent.addMenu(new HomeMenu(gp));
        gp.addEvents(7, homeEvent);

        BagEvent bagEvent = new BagEvent(gp);
        bagEvent.addBag(new BagMenu(gp));
        gp.addBag(0, bagEvent);
        bagEvent.getBagMenu().addVehicleMenu(0, new BusMenu(gp, "vechicle", "car"));
        bagEvent.getBagMenu().addVehicleMenu(1, new BusMenu(gp, "vechicle", "bike"));
    }
}
