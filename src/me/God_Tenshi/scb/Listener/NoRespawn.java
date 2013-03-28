package me.God_Tenshi.scb.Listener;

import me.God_Tenshi.scb.Main;
import net.minecraft.server.v1_5_R1.Packet205ClientCommand;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_5_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class NoRespawn implements Listener {

	private Main plugin;

	public NoRespawn(Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onD(PlayerDeathEvent e) {
		final Player player = e.getEntity();
		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			@Override
			public void run() {
				Packet205ClientCommand packet = new Packet205ClientCommand();
				packet.a = 1;
				((CraftPlayer) player).getHandle().playerConnection.a(packet);
			}
		}, plugin.getConfig().getInt("death-screen-delay") * 20);
	}
}
