package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Arrays;

import javax.swing.JPanel;

import Player.Player;
import Ui.BackgroundManager;
import Ui.KeyHandler;
import Ui.Summary;
import Ui.Title;
import Ui.UIManager;
import events.BagEvent;
import events.EventManager;
import events.SuperEvents;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import menus.SuperMenu;

public class GamePanel extends JPanel implements Runnable{
    public final int SCALE = 1;

    public final int screenWidth = 1280;
    public final int screenHeight = 720;
   
    ImageIcon background;
    Sound sound = new Sound();

    Thread gameThread;

    //set up 
    private Earth earth = new Earth(this);
    private BackgroundManager backg = new BackgroundManager(this);
    private SuperMenu[] menus = new SuperMenu[25]; // Push Menu in to this
    private SuperEvents[] events = new SuperEvents[10];
    private BagEvent[] bagEvents = new BagEvent[1];
    private Title title = new Title(this);
    private EventSetter eventSetter = new EventSetter(this);
    private EventManager eventManager = new EventManager(this);
    private KeyHandler keyH = new KeyHandler(this);
    private Player player = new Player(this);
    private Summary sum = new Summary(this);
    private UIManager uiMng = new UIManager(this);

    // flexible 
    int FPS = 250;

    // flexible 
    private boolean showEvent = true;
    GameState gamest = GameState.Title; //เปลี่ยน state


    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setFocusable(true);
        this.setLayout(null);
        this.setBackground(Color.black);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        loadEventAsset();

    }   

    public void setStart() {
        showEvent = true;
        bagEvents[0].getBag().setVisible(true);
    }

    public void loadEventAsset() {
        eventSetter.setUpEvent();
        for (int i = 0; i < 10; i++) {
            if (events[i] != null) {
                this.add(events[i].getMenu());
            }
        }

        this.add(bagEvents[0].getBag());
        this.add(bagEvents[0].getBagMenu().getVehicleMenu(0).getMenu());
        this.add(bagEvents[0].getBagMenu().getVehicleMenu(1).getMenu());
        this.add(bagEvents[0].getBagMenu().getMenu());

        uiMng.loadAsset();
        for (int i = 0; i < 10; i++) {
            if (events[i] != null) {
                this.add(events[i].getBtn());
            }
        }
    }

    public void StartGameThread() { // ตัวเกมจ้า ตัวรันๆ
        gameThread = new Thread(this);
        gameThread.start(); // tell run
    }

    @Override
    public void run() { // run fps don't touch ib
        double drawInterval = 1000000000 / (FPS); // วาดทุก 0.016 second
        double delta = 0;
        long lasttime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lasttime) / drawInterval;
            timer += (currentTime - lasttime);
            lasttime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if (timer >= 1000000000) {
                // System.out.println("FPS " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }
    public boolean  playMu = true;

    public void paintComponent(Graphics g) { // วาดตลาดเวลา ไม่ต้องห่วง

        super.paintComponent(g);
       Graphics2D g2 = (Graphics2D) g;
        
        if (gamest == GameState.Title){ 
            //เข็คสภานะเกมส์
            if(playMu ){
                playMu =false;
                playmusic(0);
            }
            title.draw(g2);
            showEvent = false;
        }
        else if (gamest == GameState.Gameplay){
            if(playMu){
                stopmusic();
                playMu = false ;
                playmusic(2);
                sound.mute(-20.0f);
            }
            backg.draw(g2);
            earth.draw(g2);
            player.draw(g2);
            uiMng.draw(g2);
        }
        else if (gamest == GameState.Endgame){
            stopmusic();
            showEvent = false;
            backg.draw(g2);
        }
        else if(gamest == GameState.Endgame_2){
            stopmusic();
            showEvent = false;
            backg.draw(g2);
        }
        else if(gamest == GameState.GoodEnd){
            showEvent = false;
            backg.draw(g2);
        }
        else if (gamest == GameState.Summary) {
            if(playMu){
                stopmusic();
                playMu = false;
                playmusic(1);
            }
            showEvent = false;
            sum.draw(g2);
        }
    }

    public void update() { // อะไรที่ต้องการเช็คตลอดเวลา ควรใช้อันนี้
        backg.updateblackground();
        player.update();
        // backg.checkObj(showEvent);

        uiMng.checkObj(showEvent);
        earth.Checkworld();
        // ============ This part should have lived in player ==============
        
        // =================================================================
        for (SuperEvents e : events) {
            if (e != null) {
                // เช็คว่าเมนูไหนเปิดอยู่
                if (showEvent) {
                    e.getBtn().setVisible(true);
                }else {
                    e.getBtn().setVisible(false);
                }
            }
        }

    }

    // Fucking Getters Setters
    public GamePanel getGamePanel(){
        return this;
    }
    public void addMenus(int i, SuperMenu m) {
        menus[i] = m;
    }
    public SuperMenu getMenus(int i) {
        return menus[i];
    }

    public void addEvents(int i, SuperEvents e) {
        events[i] = e;
    }
    public SuperEvents getEvents(int i) {
        return events[i];
    }
    public SuperEvents[] getAllEvents() {
        return events;
    }
    public void setShowEvent(boolean showEvent) {
        this.showEvent = showEvent;
    }

    public GameState getgameState(){
        return gamest ; 
    }
    public void setgameState(GameState s){
       gamest = s;
    }

    public Earth getEarth() {
        return earth;
    }

    public EventManager getEventManager() {
        return eventManager;
    }

    public Player getPlayer() {
        return player;
    }

    public BackgroundManager getBackgroundManager() {
        return backg;
    }

    public Summary getSummary() {
        return this.sum;
    }

    public UIManager getUiManager() {
        return this.uiMng;
    }

    public Title getTitle() {
        return this.title;
    }
    
    public void playmusic(int i){
        sound.setFile(i);
        sound.play();
        sound.loop();
    }

    public void stopmusic(){
        sound.stop();
    }
    public void playmusicS(int i){ //with our loop
        sound.setFile(i);
        sound.play();
    }
    public void addBag(int i, BagEvent b) {
        bagEvents[i] = b;
    }

    public BagEvent getBagEvents(int i) {
        return bagEvents[i];
    }
}
