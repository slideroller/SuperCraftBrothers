package me.God_Tenshi.scb.Listener;

import me.God_Tenshi.scb.Main;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

	private Main plugin;

	public ChatListener(Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		String playerName = player.getName();
		String message = event.getMessage();
		if (player.isOp()) {
			message = message.replaceAll("&", "§");
			event.setFormat(ChatColor.GRAY + "[" + ChatColor.DARK_RED + "OP"
					+ ChatColor.GRAY + "]" + ChatColor.GREEN + playerName
					+ ": " + ChatColor.RESET + message);
		} else if (!(player.isOp())) {
			event.setFormat(ChatColor.GRAY + "[" + ChatColor.GOLD + "SCB"
					+ ChatColor.GRAY + "]" + ChatColor.GRAY + playerName + ": "
					+ ChatColor.RESET + message);
		}else if(plugin.isWither == true && !(player.isOp())) {
			event.setFormat(ChatColor.GRAY + "[" + ChatColor.BLACK + "Wither" + ChatColor.GRAY + "]" + ChatColor.GRAY + playerName + ": " + ChatColor.RESET + message);
		}
	}
}
