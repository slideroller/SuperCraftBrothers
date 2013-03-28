package me.God_Tenshi.scb.Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import me.God_Tenshi.scb.Main;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class ItemGrenade implements Listener {

		List<UUID> droppedItems = new ArrayList<UUID>();
		
		private Main plugin;
		
		public ItemGrenade (Main plugin) {
			this.plugin = plugin;
		}
		
		@EventHandler
		public void onClick(PlayerInteractEvent event) {
			Player player = event.getPlayer();
			Inventory playerInv = player.getInventory();
			World world = player.getWorld();
			if (playerInv.contains(new ItemStack(Material.SLIME_BALL))) {
				if (event.getAction() == Action.RIGHT_CLICK_AIR) {
					final Item grenade = world.dropItem(player.getEyeLocation(),
							new ItemStack(Material.SLIME_BALL));
					droppedItems.add(grenade.getUniqueId());
					 Vector currentVelocity = player.getLocation().getDirection();
					 grenade.setVelocity(currentVelocity.multiply(1.5D));
					 player.getInventory().remove(new ItemStack(Material.SLIME_BALL, 1));
					Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
						 public void run() {
						 grenade.getWorld().createExplosion(grenade.getLocation(), 2F);
						 grenade.remove();
						}
					}, 20L);
				}
			}
		}
	}

