package com.lavacraftserver.KitPvP;

import java.util.HashSet;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class DeathEvent implements Listener {
	
	private Main plugin;

	public DeathEvent(Main plugin) {
		this.plugin = plugin;
	}
	
	public static HashSet<Player> death;
	
	@EventHandler (priority = EventPriority.HIGH)
	public void onEntityDeath (EntityDeathEvent event) { 
		if ((event.getEntity() instanceof Player)) {
			Player player = (Player)event.getEntity();
			if ((player.hasPermission("kitpvp.extra.nodeathdrop")) && (!event.getDrops().isEmpty())) {
				event.getDrops().clear();
			}
			
			if (plugin.getConfig().getBoolean("settings.once-per-life") == true) {
				Player p = (Player) event.getEntity();
				if (death.contains(p)) {
					death.remove(p);
				}
			}
		}
	}
}
