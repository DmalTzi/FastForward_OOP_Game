package Main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import backgroundMana.backgroundManager;
import javax.swing.ImageIcon;

import gamestates.Gamestate;
import gamestates.Menu;
import inputs.KeyHandler;

public class GamePanel extends JPanel implements Runnable {
    public final int SCALE = 1;

    public final int screenWidth = 1280;
    public final int screenHeight = 720;
    ImageIcon background;
    Thread gameThread;

    public events ev = new events();
    public Menu menu;;
    backgroundManager backg = new backgroundManager(this);
    // ActionHandler aHandler = new ActionHandler(this);
    // flexible
    int FPS = 60;

    public GamePanel() {
        addKeyListener(new KeyHandler(this));
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setFocusable(true);
        this.setLayout(null);
        menu = new Menu(this);

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
                // System.out.println("FPS "+drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void paintComponent(Graphics g) { // วาดตลาดเวลา ไม่ต้องห่วง
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        switch (Gamestate.state) {
		case MENU:
			menu.draw(g);
			break;
		case PLAYING:
            backg.draw(g2);
			break;
		default:
			break;
		}
    }

    public void update() { // อะไรที่ต้องการเช็คตลอดเวลา ควรใช้อันนี้
        ev.update();
        backg.updateblackground();

    }

    // Test
    public GamePanel getGamePanel(){
        return this;
    }

    public Menu getMenu() {
        return menu;
    }

    public backgroundManager getBackg() {
        return backg;
    }
}
