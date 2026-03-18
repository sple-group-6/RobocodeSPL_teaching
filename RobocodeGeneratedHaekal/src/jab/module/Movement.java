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
		Movement$AutoMovementCornering(bot);
		this.turnRightValue = 45;
	}

	public void move() {
		bot.setMaxVelocity(8);
		bot.setAhead(10000);
	}

	private int moveDirection;
	private int turnRightValue;

	private void Movement$AutoMovementCornering(Module bot) {
		this.bot = bot;
	}

	public void listen(Event e) {
		if (e instanceof HitWallEvent) {
			bot.setTurnRight(turnRightValue);
		}
	}

}
