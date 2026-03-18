package jab.module;

import java.awt.event.MouseEvent;
import java.awt.event.InputEvent;
import robocode.Rules;
import robocode.Bullet;
import java.lang.Math;

/**
 * Gun
 * 
 * @author jab
 */
public class Gun extends Part {

	public Module bot;

	public Gun(Module bot) {
		this.bot = bot;
	}

	public void fire() {
		if (fireRequested) {
			fireRequested = false;
			double bulletPower = Math.min(Rules.MAX_BULLET_POWER, bot.getEnergy() - 0.01);
			bot.bulletPower = bulletPower;
			if (bot.getGunHeat() == 0) {
				Bullet b = bot.setFireBullet(bulletPower);
				bot.registerBullet(b);
			}
		}
	}

	private boolean fireRequested = false;

	public void listenInput(InputEvent e) {
		if (e instanceof MouseEvent) {
			MouseEvent me = (MouseEvent) e;
			if (me.getID() == MouseEvent.MOUSE_PRESSED) {
				fireRequested = true;
			}
		}
	}

}
