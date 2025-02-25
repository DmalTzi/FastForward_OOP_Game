package gamestates;

import org.w3c.dom.events.MouseEvent;

import Main.GamePanel;

public class State {
    protected GamePanel game;

	public State(GamePanel game) {
		this.game = game;
	}
	
	// public boolean isIn(MouseEvent e, MenuButton mb) {
	// 	return mb.getBounds().contains(e.getX(), e.getY());
	// }
	

	public GamePanel getGame() {
		return game;
	}
}
