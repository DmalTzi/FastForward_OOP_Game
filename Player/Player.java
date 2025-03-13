package Player;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import events.SuperEvents;
import main.GamePanel;
import main.GameState;
import menus.SuperMenu;

public class Player {
    GamePanel gp;
    public BufferedImage playerIm, playerIm1, playerIm2, playerIm3, remem;
    public int x;
    public int y;
    private int coin;
    private int emotion = 100;
    private int workHr = 0;
    private boolean canWork = true;
    private int speedUp = 0;
    private int dailyEarn = 0;
    private String[] inventory = new String[2];
    private String currentPosition = "home";
    private String moveWith = "legs";
    private int emotionalDamage = 0;
    private Map<String, int[]> activityHome = new HashMap<>();
    private Map<String, int[]> activityMarket = new HashMap<>();
    private Map<String, int[]> activitySuper = new HashMap<>();
    private Map<String, int[]> work = new HashMap<>();
    

    public Player(GamePanel gp) {
        this.gp = gp;
        loadPlayer();
        loadAsset();
    }

    public void update() { // walk check bulid
        System.out.println(emotion);
        if (workHr >= 8 )
            canWork = false;
        MoveTo();
        emotioncheck();
        for (int i = 0; i < 4; i++) {
            // find the position for enable bus that location
            int pos = Arrays.asList(gp.getEarth().getLocation()).indexOf(currentPosition);
            // if current position == in list of bus btn, the bus btn will enable
            if (i == pos)
                gp.getEvents(i).getBtn().setEnabled(true);
            // all of else is diable

            else
                gp.getEvents(i).getBtn().setEnabled(false);
        }
        if (getPlayerEmo() > 100) { // ไม่ให้เกิน 100
            setPlayerEmo(100);
        }

        emotionalDamage = (200 - gp.getEarth().getEarthHeat()) + emotion;
    }

    public void loadAsset() {
        activityHome.put("Movie", new int[] { 20, 25, -60, 120 }); // emo 1 c02 2 coin
        activityHome.put("Exercise", new int[] { 10, 15, -10, 30 });
        activityHome.put("Game", new int[] { 20, 30, -50, 60 });
        activityHome.put("Plante", new int[] { 25, -20, -5, 30 });
        activityHome.put("ReadBk", new int[] { 15, 10, -10, 60 });
        activityHome.put("Sleep", new int[] { 25, 5, 0 });

        activityMarket.put("Apple", new int[] { 5, 5, -10 });
        activityMarket.put("Water", new int[] { 2, 5, -10 });
        activityMarket.put("Coke", new int[] { 3, 15, -15 });
        activityMarket.put("Mama", new int[] { 10, 15, -20 });
        activityMarket.put("Egg_fried", new int[] { 15, 20, -25 });

        activitySuper.put("Pizza", new int[] { 20, 30, -50 });
        activitySuper.put("Hamburger", new int[] { 20, 30, -50 });
        activitySuper.put("Fried", new int[] { 15, 25, -35 });
        activitySuper.put("Car", new int[] { 30, 20, -1200 });
        activitySuper.put("Jakayan", new int[] { 25, 5, -500 });

        work.put("Market", new int[] { -5, 5, 30, 60 });
        work.put("Super", new int[] { -10, 10, 40, 60 });
        work.put("Office", new int[] { -15, 15, 50, 60 });
    }

    public void loadPlayer() {

        try {
            playerIm = ImageIO.read(getClass().getResourceAsStream("/res/player/Asset_78.png")); // happy
            playerIm1 = ImageIO.read(getClass().getResourceAsStream("/res/player/Asset 76.png"));// min
            playerIm2 = ImageIO.read(getClass().getResourceAsStream("/res/player/Asset 75.png"));// medium
            playerIm3 = ImageIO.read(getClass().getResourceAsStream("/res/player/Asset 77.png")); // verysad

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) { // วาดตัวละคร

        if (emotionalDamage > 225) {
            remem = playerIm;
        } else if (emotionalDamage > 150) {
            remem = playerIm1;
        } else if (emotionalDamage > 75) {
            remem = playerIm2;
        } else {
            remem = playerIm3;
        }
        // System.out.println(emotion);
        // for player
        g2.drawImage(remem, x, y, 80, 80, null);

        // for backgound
        // g2.drawImage(remem,50, 250, 118, 117, null); // มัน อยู่ล่่างสุด

    }

    private void emotioncheck() {
        // System.out.println(emotion);
        if (emotion <= 0) {
            gp.setgameState(GameState.Endgame);
            Arrays.asList(gp.getAllEvents()).forEach(e -> {
                if (e != null)
                    e.setMenuVisible(false);
            });
        }
    }

    public void MoveTo() {
        x = gp.getEarth().getPlayerLocation(Arrays.asList(gp.getEarth().getLocation()).indexOf(currentPosition))[0];
        y = gp.getEarth().getPlayerLocation(Arrays.asList(gp.getEarth().getLocation()).indexOf(currentPosition))[1];
    }

    public void buyCar(String name, int index) {
        inventory[index] = name;
    }

    public void equip(String vehicle){
    }

    public void work(String n) {
        if(canWork){
            if (n.equals("Market")) {
                increasWorkHr();
                increasePlayerEmo(work.get(n)[0]);
                gp.getEarth().setEarthCO2((work.get(n)[1]));
                setPlayerCoin((work.get(n)[2]));
                gp.getEarth().increaseTime(work.get(n)[3]);
                increaseDailyEarn((work.get(n)[2]));
            } else if (n.equals("Super")) {
                increasWorkHr();
                increasePlayerEmo(work.get(n)[0]);
                gp.getEarth().setEarthCO2((work.get(n)[1]));
                setPlayerCoin((work.get(n)[2]));
                gp.getEarth().increaseTime(work.get(n)[3]);
                increaseDailyEarn((work.get(n)[2]));
            } else if (n.equals("Office")) {
                increasWorkHr();
                increasePlayerEmo(work.get(n)[0]);
                gp.getEarth().setEarthCO2((work.get(n)[1]));
                setPlayerCoin((work.get(n)[2]));
                gp.getEarth().increaseTime(work.get(n)[3]);
                increaseDailyEarn((work.get(n)[2]));
            }
        }
    }

    public void activity(String n) {
        if (getCoin() <= 0) {
            if (gp.getEarth().time >= 19 * 60  || gp.getEarth().time <= 5 *60) {
                
                if (n.equals("Sleep")) {
                    setWorkHr();
                    increasePlayerEmo(activityHome.get(n)[0]);
                    gp.getEarth().setEarthCO2((activityHome.get(n)[1]));
                    setPlayerCoin((activityHome.get(n)[2]));
                    gp.getEarth().increasDay(1);
                    gp.setgameState(GameState.Summary);
                    gp.getEarth().time = 360;
                    gp.setShowEvent(false);
                    Arrays.asList(gp.getAllEvents()).forEach(e1 -> {if (e1 != null) e1.setMenuVisible(false);});
                }
            }
        } else {
            if (-(activityHome.get(n)[2]) <= getCoin()) {

                if (gp.getEarth().time >= 19 * 60 || gp.getEarth().time <= 5 * 60) {
                    if (n.equals("Sleep")) {
                        gp.setgameState(GameState.Summary);
                        setWorkHr();
                        increasePlayerEmo(activityHome.get(n)[0]);
                        gp.getEarth().setEarthCO2((activityHome.get(n)[1]));
                        setPlayerCoin((activityHome.get(n)[2]));
                        gp.getEarth().increasDay(1);
                        gp.getEarth().time = 360;
                        gp.setShowEvent(false);
                        Arrays.asList(gp.getAllEvents()).forEach(e1 -> {if (e1 != null) e1.setMenuVisible(false);});
                    }
                }

                if (n.equals("Movie")) {
                    increasePlayerEmo(activityHome.get(n)[0]);
                    gp.getEarth().setEarthCO2((activityHome.get(n)[1]));
                    setPlayerCoin((activityHome.get(n)[2]));
                    gp.getEarth().increaseTime(activityHome.get(n)[3]);
                } else if (n.equals("Exercise")) {
                    increasePlayerEmo(activityHome.get(n)[0]);
                    gp.getEarth().setEarthCO2((activityHome.get(n)[1]));
                    setPlayerCoin((activityHome.get(n)[2]));
                    gp.getEarth().increaseTime(activityHome.get(n)[3]);
                } else if (n.equals("Game")) {
                    increasePlayerEmo(activityHome.get(n)[0]);
                    gp.getEarth().setEarthCO2((activityHome.get(n)[1]));
                    setPlayerCoin((activityHome.get(n)[2]));
                    gp.getEarth().increaseTime(activityHome.get(n)[3]);
                } else if (n.equals("Plante")) {
                    increasePlayerEmo(activityHome.get(n)[0]);
                    gp.getEarth().setEarthCO2((activityHome.get(n)[1]));
                    setPlayerCoin((activityHome.get(n)[2]));
                    gp.getEarth().increaseTime(activityHome.get(n)[3]);
                } else if (n.equals("ReadBk")) {
                    increasePlayerEmo(activityHome.get(n)[0]);
                    gp.getEarth().setEarthCO2((activityHome.get(n)[1]));
                    setPlayerCoin((activityHome.get(n)[2]));
                    gp.getEarth().increaseTime(activityHome.get(n)[3]);
                }
            }
        }

    }

    public void buy(String foodname) {

        if (activityMarket.containsKey(foodname)) {
            if (getCoin() >= -activityMarket.get(foodname)[2]) {
                if (foodname.equals("Apple")) {
                    increasePlayerEmo(activityMarket.get(foodname)[0]);
                    gp.getEarth().setEarthCO2((activityMarket.get(foodname)[1]));
                    setPlayerCoin((activityMarket.get(foodname)[2]));
                } else if (foodname.equals("Water")) {
                    increasePlayerEmo(activityMarket.get(foodname)[0]);
                    gp.getEarth().setEarthCO2((activityMarket.get(foodname)[1]));
                    setPlayerCoin((activityMarket.get(foodname)[2]));
                } else if (foodname.equals("Coke")) {
                    increasePlayerEmo(activityMarket.get(foodname)[0]);
                    gp.getEarth().setEarthCO2((activityMarket.get(foodname)[1]));
                    setPlayerCoin((activityMarket.get(foodname)[2]));
                } else if (foodname.equals("Mama")) {
                    increasePlayerEmo(activityMarket.get(foodname)[0]);
                    gp.getEarth().setEarthCO2((activityMarket.get(foodname)[1]));
                    setPlayerCoin((activityMarket.get(foodname)[2]));
                } else if (foodname.equals("Egg_fried")) {
                    increasePlayerEmo(activityMarket.get(foodname)[0]);
                    gp.getEarth().setEarthCO2((activityMarket.get(foodname)[1]));
                    setPlayerCoin((activityMarket.get(foodname)[2]));
                }
            }
        }
        if (activitySuper.containsKey(foodname)) {
            if (getCoin() >= -activitySuper.get(foodname)[2]){
                if (foodname.equals("Pizza")) {
                    increasePlayerEmo(activitySuper.get(foodname)[0]);
                    gp.getEarth().setEarthCO2((activitySuper.get(foodname)[1]));
                    setPlayerCoin((activitySuper.get(foodname)[2]));
                } else if (foodname.equals("Hamburger")) {
                    increasePlayerEmo(activitySuper.get(foodname)[0]);
                    gp.getEarth().setEarthCO2((activitySuper.get(foodname)[1]));
                    setPlayerCoin((activitySuper.get(foodname)[2]));
                } else if (foodname.equals("Fried")) {
                    increasePlayerEmo(activitySuper.get(foodname)[0]);
                    gp.getEarth().setEarthCO2((activitySuper.get(foodname)[1]));
                    setPlayerCoin(activitySuper.get(foodname)[2]);
                }
            }
        }

    }

    public int getWorkHr() {
        return workHr;
    }
    public void  increasWorkHr(){
        workHr ++;
    }
    public void  setWorkHr(){
        workHr = 0;
    }
    public int getPlayerCoin() {
        return this.coin;
    }

    public void setPlayerCoin(int coin) {
        this.coin += coin;
    }

    public double getPlayerEmo() {
        return this.emotion;
    }

    public void increasePlayerEmo(double emo) { // ใช้เพิ่ม ลด
        this.emotion += emo;
    }

    public void setPlayerEmo(int n) {
        this.emotion = n;
    }

    public double getCoin() {
        return coin;
    }

    public String getCurrentPosition() {
        return currentPosition;
    }

    public String getMoveWith() {
        return moveWith;
    }

    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }

    public boolean getCanWork() {
        return canWork;
    }

    public int getDailyEarn() {
        return this.dailyEarn;
    }
    public void setDailyEarn(int dailyearn) {
        this.dailyEarn = dailyearn;
    }
    public void  increaseDailyEarn(int dailyearn) {
        this.dailyEarn += dailyearn;
    }
}
