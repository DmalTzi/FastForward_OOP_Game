package gamestates;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import Main.GamePanel;
import utilz.LoadSave;

public class Menu extends State {
    private BufferedImage backgroundImg;
	private int menuX, menuY, menuWidth, menuHeight;

    public Menu(GamePanel game) {
		super(game);
		loadBackground();
	}

    private void loadBackground() {
		backgroundImg = LoadSave.GetSpriteAtlas(LoadSave.MENU_BACKGROUND);
		menuWidth = (int) (backgroundImg.getWidth() * game.SCALE);
		menuHeight = (int) (backgroundImg.getHeight() * game.SCALE);
		menuX = game.screenWidth / 2 - menuWidth / 2;
		menuY = (int) (45 * game.SCALE);
	}

    public void draw(Graphics g) {

		g.drawImage(backgroundImg, menuX, menuY, menuWidth, menuHeight, null);
	}

    public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER)
			Gamestate.state = Gamestate.PLAYING;

	}

    public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
