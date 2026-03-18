package jab.module;

import java.awt.event.MouseEvent;
import java.awt.event.InputEvent;
import robocode.util.Utils;
import java.lang.Math;

/**
 * Targeting
 * 
 * @author jabier.martinez
 */
public class Targeting extends Part {

	public Module bot;

	public Targeting(Module bot) {
		this.bot = bot;
	}

	public void target() {
		double theta = Utils.normalAbsoluteAngle(Math.atan2(mouseX - bot.getX(), mouseY - bot.getY()));
		bot.setTurnGunRightRadians(Utils.normalRelativeAngle(theta - bot.getGunHeadingRadians()));
	}

	private double mouseX;
	private double mouseY;

	public void listenInput(InputEvent e) {
		if (e instanceof MouseEvent) {
			MouseEvent me = (MouseEvent) e;
			mouseX = me.getX();
			mouseY = me.getY();
		}
	}

}
