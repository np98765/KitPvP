package com.lavacraftserver.KitPvP;

import java.util.ArrayList;
import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public static HashSet<Player> death = new HashSet<Player>();
	
	@Override
	public void onEnable() {
		getCommand("pvp").setExecutor(new Kits(this));
	}
	
	@Override
	public void onDisable() {
		
	}
	   public Player[] getPlayers() {
		     ArrayList<Player> players = new ArrayList<Player>();
		     Player[] onlineplayers = Bukkit.getOnlinePlayers();
		     for (int i = 0; i < onlineplayers.length; i++) {
		       players.add(onlineplayers[i]);
		     }
			return onlineplayers;
		     }
	

  
  @EventHandler
  public void onKill(PlayerDeathEvent e) {
    if (e.getEntity().getKiller() != null) {
    	e.setDeathMessage(null);
      String killedName = e.getEntity().getName();
      String killerName = e.getEntity().getKiller().getName();
      getServer().broadcastMessage(ChatColor.RED + killedName + ChatColor.GRAY + " has been slain by " + ChatColor.RED + killerName);
      if (e.getEntity().getKiller().hasPermission("kitpvp.extra.xpkill")) {
      e.getEntity().getKiller().sendMessage(ChatColor.GOLD + "1 Level given, For Killing " + ChatColor.GREEN + killedName);
      e.getEntity().getKiller().giveExp(17);
      }
    }
  }
 }