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
		getServer().getPluginManager().registerEvents(new DeathEvent(this), this);
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
	

  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    Player player = null;
    if ((sender instanceof Player)) {
      player = (Player)sender;
    }
    if (cmd.getName().equalsIgnoreCase("kitpvp")) {
      if (player == null) {
        sender.sendMessage("This command can only be run by a player.");
      }
      else if (args.length == 0) {
        player.sendMessage(" ");
        player.sendMessage(ChatColor.WHITE + ChatColor.BOLD + "------------" + ChatColor.BLUE + ChatColor.BOLD + "KitPVP " + ChatColor.AQUA + ChatColor.ITALIC + "Info" + ChatColor.WHITE + ChatColor.BOLD + "------------");
        player.sendMessage(ChatColor.RED + "KitPVP v1.0 " + ChatColor.YELLOW + "Developed by " + ChatColor.GOLD + "njb_said" + ChatColor.YELLOW + " and " + ChatColor.GOLD + "np98765.");
        player.sendMessage(ChatColor.GRAY + "To clear your kit type " + ChatColor.AQUA + "- /clear");
        player.sendMessage(ChatColor.GRAY + "To refill your soup type " + ChatColor.AQUA + "- /refill " + ChatColor.GRAY + "or " + ChatColor.AQUA + "/soup");
        player.sendMessage("  ");
        player.sendMessage(ChatColor.DARK_GREEN + "Our Sponsers: TechGe3ks");
        player.sendMessage(ChatColor.GREEN + "Want this plugin? " + ChatColor.DARK_AQUA + "http://dev.bukkit.org/server-mods/kitpvp/");
        player.sendMessage("  ");
      } else if (args.length == 1) {
        player.sendMessage(ChatColor.RED + "Error: Too many arguments. Please use " + ChatColor.WHITE + "/kitpvp");
      }
    }
// I think i forgot to add somethings like return false; and some } I just though id add this.
  
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