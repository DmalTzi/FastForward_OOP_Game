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
import Ui.Title;
import events.EventManager;
import events.SuperEvents;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import inputs.MouseHandler;
import menus.SuperMenu;

public class GamePanel extends JPanel implements Runnable{
    public final int SCALE = 1;

    public final int screenWidth = 1280;
    public final int screenHeight = 720;

    ImageIcon background;
    Thread gameThread;
    // ActionHandler aHandler = new ActionHandler(this);
    
    //set up 
    private Earth earth = new Earth(this);
    BackgroundManager backg = new BackgroundManager(this);
    ActionHandler aHandler = new ActionHandler(this) ;
    private SuperMenu[] menus = new SuperMenu[10]; // Push Menu in to this
    private SuperEvents[] events = new SuperEvents[10];
    public Title title = new Title(this);
    private EventSetter eventSetter = new EventSetter(this);
    private EventManager eventManager = new EventManager(this);
    private KeyHandler keyH = new KeyHandler(this);
    





    // flexible 
    int FPS = 60;
    private boolean showEvent = true;
    GameState gamest = GameState.Title; //เปลี่ยน state

    public Player player = new Player(getGamePanel());

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
    }

    public void loadEventAsset() {
        eventSetter.setUpEvent();
        for (int i = 0; i < 10; i++) {
            if (events[i] != null) {
                this.add(events[i].getMenu());
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

    public void paintComponent(Graphics g) { // วาดตลาดเวลา ไม่ต้องห่วง
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        if(gamest == GameState.Title){ //เข็คสภานะเกมส์
            showEvent = false;
            title.draw(g2);
        }else if(gamest == GameState.Gameplay){
            backg.draw(g2);
            earth.draw(g2);
            player.draw(g2);
        }
      
    }

    public void update() { // อะไรที่ต้องการเช็คตลอดเวลา ควรใช้อันนี้
        backg.updateblackground();
        player.update();
<<<<<<< HEAD
=======
        backg.checkObj(showEvent);
        
>>>>>>> ab2c3b01b35991533dc58fb08d3e7b7803c95466
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

    public SuperEvents[] getAllEvent() {
        return events;
    }

    public void setShowEvent(boolean showEvent) {
        this.showEvent = showEvent;
    }
    public GameState getgameState(){
        return gamest ; 
    }
    public void setgameState(GameState s){
       gamest =  s;
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
}
