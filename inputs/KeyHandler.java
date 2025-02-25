package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Main.GamePanel;
import gamestates.Gamestate;

public class KeyHandler implements KeyListener{
    GamePanel gamePanel;

    public KeyHandler(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
    

    @Override
    public void keyReleased(KeyEvent e) {
        switch (Gamestate.state) {
            case MENU:
                gamePanel.getGamePanel().getMenu().keyReleased(e);
                break;
            case PLAYING:
                gamePanel.getGamePanel().getBackg().keyReleased(e);
            default:
                break;
    
            }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
		switch (Gamestate.state) {
		case MENU:
			gamePanel.getMenu().keyPressed(e);
			break;
        case PLAYING:
            gamePanel.getBackg().keyPressed(e);
		default:
			break;
		}
	}
}
