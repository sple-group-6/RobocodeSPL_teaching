package jab.module;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

/**
 * Movement
 * 
 * @author jab
 */
public class Movement extends Part {

	public Module bot;

	public Movement(Module bot) {
		this.bot = bot;
	}

	public void move() {
		if (moveDirection == 1) {
			bot.setAhead(40000);
		} else if (moveDirection == -1) {
			bot.setBack(40000);
		} else {
			bot.setAhead(0);
		}

		if (turnDirection == 1) {
			bot.setTurnRight(10000);
		} else if (turnDirection == -1) {
			bot.setTurnLeft(10000);
		} else {
			bot.setTurnRight(0);
		}
	}

	private int moveDirection = 0;
	private int turnDirection = 0;

	public void listenInput(InputEvent e) {
		if (e instanceof KeyEvent) {
			KeyEvent ke = (KeyEvent) e;
			if (ke.getID() == KeyEvent.KEY_PRESSED) {
				switch (ke.getKeyCode()) {
				case KeyEvent.VK_UP:
					moveDirection = 1;
					break;
				case KeyEvent.VK_DOWN:
					moveDirection = -1;
					break;
				case KeyEvent.VK_RIGHT:
					turnDirection = 1;
					break;
				case KeyEvent.VK_LEFT:
					turnDirection = -1;
					break;
				}
			} else if (ke.getID() == KeyEvent.KEY_RELEASED) {
				switch (ke.getKeyCode()) {
				case KeyEvent.VK_UP:
				case KeyEvent.VK_DOWN:
					moveDirection = 0;
					break;
				case KeyEvent.VK_RIGHT:
				case KeyEvent.VK_LEFT:
					turnDirection = 0;
					break;
				}
			}
		}
	}

}
