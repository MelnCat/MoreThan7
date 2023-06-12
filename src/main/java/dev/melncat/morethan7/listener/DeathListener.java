package dev.melncat.morethan7.listener;

import dev.melncat.morethan7.MoreThan7;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandSendEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

public class DeathListener implements Listener {
	private final MoreThan7 plugin;
	
	public DeathListener(MoreThan7 plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler(ignoreCancelled = true, priority = EventPriority.HIGH)
	private void on(PlayerDeathEvent event) {
		if (event.getKeepLevel()) return;
		Player player = event.getEntity();
		int level = player.getLevel();
		event.setDroppedExp(
			expAtLevel(level) + Math.round(
				player.getExp() * (expAtLevel(level + 1) - expAtLevel(level))
			)
		);
	}
	
	private int expAtLevel(int level) {
		if (level <= 16)
			return level * level + 6 * level;
		else if (level <= 31)
			return (5 * level * level - 81 * level + 720) / 2;
		else
			return (9 * level * level - 325 * level + 4440) / 2;
	}
}

