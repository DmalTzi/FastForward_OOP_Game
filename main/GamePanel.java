package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import backgroundMana.BackgroundManager;
import events.SuperEvents;

import javax.swing.ImageIcon;

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
    public Earth ev = new Earth(this);
    BackgroundManager backg = new BackgroundManager(this);
    ActionHandler aHandler = new ActionHandler(this) ;
    public MouseHandler mHandler = new MouseHandler(this);
    private SuperMenu[] menus = new SuperMenu[10]; // Push Menu in to this
    private SuperEvents[] events = new SuperEvents[10];
    private EventSetter eSetter = new EventSetter(this);

    // flexible 
    int FPS = 60;
    private boolean showEvent = true;
    private int gametitle = 0;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setFocusable(true);
        this.setLayout(null);
    }

    public void loadGameEvents() {
        eSetter.setUpEvent();
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
                System.out.println("FPS " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void paintComponent(Graphics g) { // วาดตลาดเวลา ไม่ต้องห่วง\
        Graphics2D g2 = (Graphics2D) g;

        if(gametitle == 1){
            showEvent = false;
        }else{
            showEvent =true;
            super.paintComponent(g);
        
            backg.draw(g2);
        }
    }

    public void update() { // อะไรที่ต้องการเช็คตลอดเวลา ควรใช้อันนี้
        ev.update();
        backg.updateblackground();
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

    // Test
    public GamePanel getGamePanel(){
        return this;
    }

    // public BackgroundManager getBackg() {
    //     return backg;
    // }

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

    public void setShowEvent(boolean showEvent) {
        this.showEvent = showEvent;
    }
}
