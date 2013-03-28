package me.God_Tenshi.scb.Listener;

import java.io.File;

import me.God_Tenshi.scb.Main;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public class playerListener implements Listener {

	private Main plugin;
	
	public playerListener(Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onLogin(PlayerLoginEvent event) {
		Player player = event.getPlayer();
		File playerDat = new File("world/players/" + player.getName() + ".dat");
		if (!playerDat.exists()) {
			String playerName = player.getName();
			int startupAmount = plugin.getConfig().getInt("startupAmount");
			if (startupAmount == 0) {
				// Nothing
			} else {
				plugin.getConfig().set(playerName + ".gems", startupAmount);
				plugin.saveConfig();
			}
		}
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		int credits = plugin.getConfig().getInt(player.getName() + ".credits");
		if(credits == 0) {
		//do nothing!
		} else {
			if (plugin.getConfig().getBoolean("joinMessage") == true) {
				player.sendMessage(ChatColor.GRAY + "Welcome To " + ChatColor.GOLD + "SuperCraftBrothers " + ChatColor.GRAY + "Server");
				player.sendMessage(ChatColor.AQUA + "You can purchase" + ChatColor.DARK_RED + "Maps" + "with the" + ChatColor.GREEN + "Gems" + ChatColor.AQUA + "you obtain when you win!");
			}
		}
	}
}

