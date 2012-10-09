package com.lavacraftserver.KitPvP;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class DeathEvent implements Listener {
	
	@EventHandler (priority=EventPriority.HIGH)
	public void onEntityDeath (EntityDeathEvent event) { 
		if ((event.getEntity() instanceof Player)) {
			Player player = (Player)event.getEntity();
			if ((player.hasPermission("kitpvp.extra.nodeathdrop")) && (!event.getDrops().isEmpty())) {
				event.getDrops().clear();
			}
		}
	}
}
