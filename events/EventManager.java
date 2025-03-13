package events;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import main.GamePanel;
import menus.SuperMenu;

public class EventManager {
    GamePanel gp;
    
    // path row and col is market office super home shortest path
    int [][] paths = {{0, 30, 45, 15},
                      {30, 0, 20, 45},
                      {45, 20, 0, 30},
                      {15, 45, 30, 0}};

    private Map<String, int[]> travels = new HashMap<>();

    public EventManager(GamePanel gp) {
        this.gp = gp;
        travels.put("bus", new int[] { 0, 15, -10 });
        travels.put("legs", new int[] { -5, 0, 0 });
        travels.put("car", new int[] { 0, 5, 0 });
        travels.put("bike", new int[] { 0, 0, 0 });

    }

    public int goToNextEvent(int cur, int next, String moveBy) {
        int time = 0;
        // เช็คว่าอยู่ที่เดิม
        if (cur == next) return 0;
        if (gp.getPlayer().getCoin() >= -travels.get(moveBy)[2]) {
            gp.getPlayer().increasePlayerEmo(travels.get(moveBy)[0]);
            gp.getEarth().setEarthCO2((travels.get(moveBy)[1]));
            gp.getPlayer().setPlayerCoin((travels.get(moveBy)[2]));
            gp.getPlayer().setCurrentPosition(gp.getEarth().getLocation()[next]);
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
        }
        return time;
    }

}