package me.God_Tenshi.scb.Listener;

import me.God_Tenshi.scb.Main;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DeathListener implements Listener {

	public DeathListener(Main plugin) {
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onPlayerDeath(PlayerDeathEvent event) {
		Player p = event.getEntity();
		EntityDamageEvent ede = p.getLastDamageCause();
		DamageCause dc = ede.getCause();
		String name = event.getEntity().getName();
		// Player killing Player
		if (dc == DamageCause.CONTACT) {
			Player killer = p.getKiller();
			String killername = killer.getName();
			event.setDeathMessage(ChatColor.GREEN + name + ChatColor.GOLD
					+ " has been killed by " + ChatColor.DARK_RED + killername);
		} else if (dc == DamageCause.VOID) { // Player died in the void
			event.setDeathMessage(ChatColor.GRAY + "[" + ChatColor.GOLD
					+ "SuperCraftBrothers" + ChatColor.GRAY + "] "
					+ ChatColor.DARK_AQUA + name + " fell into the Void");
			event.getDrops().clear();
		} else if (dc == DamageCause.WITHER) {
			event.setDeathMessage(ChatColor.GRAY + "[" + ChatColor.GOLD
					+ "SuperCraftBrothers" + ChatColor.GRAY + "] "
					+ ChatColor.DARK_AQUA + name + " Withered Away");
			event.getDrops().clear();
		} else if (dc == DamageCause.POISON) {
			event.setDeathMessage(ChatColor.GRAY + "[" + ChatColor.GOLD
					+ "SuperCraftBrothers" + ChatColor.GRAY + "] "
					+ ChatColor.DARK_AQUA + name + " died from Poison");
			event.getDrops().clear();
		} else if (dc == DamageCause.BLOCK_EXPLOSION) {
			event.setDeathMessage(ChatColor.GRAY + "[" + ChatColor.GOLD
					+ "SuperCraftBrothers" + ChatColor.GRAY + "] "
					+ ChatColor.DARK_AQUA + name + " Blew Up");
			event.getDrops().clear();
		} else if (dc == DamageCause.CUSTOM) {
			event.setDeathMessage(ChatColor.GRAY + "[" + ChatColor.GOLD
					+ "SuperCraftBrothers" + ChatColor.GRAY + "] "
					+ ChatColor.DARK_AQUA + name + " Died");
			event.getDrops().clear();
		} else if (dc == DamageCause.MAGIC) {
			event.setDeathMessage(ChatColor.GRAY + "[" + ChatColor.GOLD
					+ "SuperCraftBrothers" + ChatColor.GRAY + "] "
					+ ChatColor.DARK_AQUA + name + " was killed by Dark Magic");
		} else if (dc == DamageCause.FIRE) {
			event.setDeathMessage(ChatColor.GRAY + "[" + ChatColor.GOLD
					+ "SuperCraftBrothers" + ChatColor.GRAY + "] "
					+ ChatColor.DARK_AQUA + name + " Burned to Death");
		}
	}

	@EventHandler
	public void onDropItem(PlayerDropItemEvent event) {
		Player player = event.getPlayer();
		player.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD
				+ "SuperCraftBrothers" + ChatColor.GRAY + "] "
				+ ChatColor.DARK_AQUA
				+ "I'm sorry, but the dropping of items is disabled.");
		event.setCancelled(true);
	}
}
