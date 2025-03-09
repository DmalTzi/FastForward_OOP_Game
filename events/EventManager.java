package events;

import java.util.Arrays;

import main.GamePanel;
import menus.SuperMenu;

public class EventManager {
    GamePanel gp;
    
    // path row and col is market office super home shortest path
    int [][] paths = {{0, 30, 45, 15},
                      {30, 0, 20, 45},
                      {45, 20, 0, 30},
                      {15, 45, 30, 0}};

    public EventManager(GamePanel gp) {
        this.gp = gp;
    }

    public int goToNextEvent(int cur, int next, String moveBy) {
        int time = 0;
        switch (moveBy) {
            case "bus":
                time = paths[cur][next];
                break;
            case "legs":
                time = paths[cur][next]+30;
                break;
            case "car":
                time = paths[cur][next]-15;
                break;
            case "bike":
                time = paths[cur][next];
                break;
        }
        return time;
    }

}