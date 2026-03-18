package jab.module;

import robocode.Event;
import robocode.HitWallEvent;

/**
 * Movement
 * 
 * @author jab
 */
public class Movement extends Part {

	public Module bot;

	public Movement(Module bot) {
		Movement$AutoMovementLine(bot);
		this.moveDirection = 1;
	}

	public void move() {
		bot.setMaxVelocity(8);
		bot.setAhead(10000 * moveDirection);
	}

	private int moveDirection;

	private void Movement$AutoMovementLine(Module bot) {
		this.bot = bot;
	}

	public void listen(Event e) {
		if (e instanceof HitWallEvent) {
			moveDirection *= -1;
		}
	}

}
