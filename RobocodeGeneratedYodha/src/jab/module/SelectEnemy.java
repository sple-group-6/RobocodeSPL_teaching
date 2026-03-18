package jab.module;

import java.lang.Double;
import java.util.Iterator;

/**
 * Select enemy
 * 
 * @author jabier.martinez
 */
public class SelectEnemy extends Part {

	public Module bot;

	public SelectEnemy(Module bot) {
		this.bot = bot;
	}

	public void select() {
		Iterator<jab.module.BotInfo> iterator = bot.botsInfo.values().iterator();
		double maxEnergy = -1;
		jab.module.BotInfo selected = null;
		while (iterator.hasNext()) {
			jab.module.BotInfo e = iterator.next();
			if (maxEnergy < e.energy) {
				selected = e;
				maxEnergy = e.energy;
			}
		}
		bot.enemy = selected;
	}

}
