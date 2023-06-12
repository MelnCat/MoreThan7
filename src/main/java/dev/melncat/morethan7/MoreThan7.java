package dev.melncat.morethan7;

import dev.melncat.morethan7.listener.DeathListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class MoreThan7 extends JavaPlugin {
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new DeathListener(this), this);
	}
}
