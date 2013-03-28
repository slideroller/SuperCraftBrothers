package me.God_Tenshi.scb;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GemShop implements Listener {

	@SuppressWarnings("unused")
	private Main plugin;
	public static Inventory shopInventory;

	public GemShop(Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onGemClick(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		if (player.getItemInHand().getType() == Material.EMERALD) {
			if (e.getAction() == Action.RIGHT_CLICK_AIR) {
				List<String> price = new ArrayList<String>();
				price.add(ChatColor.GOLD + "Price: " + ChatColor.GREEN
						+ "100 Gems");
				List<String> price2 = new ArrayList<String>();
				price2.add(ChatColor.GOLD + "Price: " + ChatColor.GREEN
						+ "200 Gems");
				shopInventory = Bukkit.createInventory(null, 27,
						"Welcome To The Shop");
				shopInventory.addItem(setName(new ItemStack(
						Material.NETHER_STAR), ChatColor.DARK_AQUA
						+ "ClockTower", price2));
				shopInventory.addItem(setName(new ItemStack(
						Material.BEDROCK), ChatColor.DARK_AQUA
						+ "ClockTower", price));
				player.openInventory(shopInventory);
				shopInventory.clear();
				shopInventory.addItem(setName(new ItemStack(
						Material.NETHER_STAR), ChatColor.DARK_AQUA
						+ "ClockTower", price2));
				shopInventory.addItem(setName(new ItemStack(
						Material.BEDROCK), ChatColor.DARK_AQUA
						+ "Ying Yang", price));
			}
		}
	}

	private ItemStack setName(ItemStack is, String name, List<String> lore) {
		ItemMeta im = is.getItemMeta();
		if (name != null)
			im.setDisplayName(name);
		if (lore != null)
			im.setLore(lore);
		is.setItemMeta(im);
		return is;
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		if (event.getInventory().getSize() == 27
				|| event.getInventory().getTitle() == "Welcome To The Shop") {
			if (event.getCurrentItem().getType() == Material.NETHER_STAR) {
				Player player = (Player) event.getWhoClicked();
				event.setCancelled(true);
				player.getInventory().addItem(new ItemStack(Material.BEDROCK));
				player.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD
						+ "Map Shop" + ChatColor.GRAY + "]"
						+ ChatColor.DARK_GREEN + ":" + ChatColor.GREEN
						+ " You bought " + ChatColor.GOLD
						+ "an Item from the shop");
				player.closeInventory();
			} else if (event.getCurrentItem().getType() == Material.BEDROCK) {
				Player player = (Player) event.getWhoClicked();
				event.setCancelled(true);
				player.getInventory().addItem(new ItemStack(Material.NETHER_STAR));
				player.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD
						+ "Map Shop" + ChatColor.GRAY + "]"
						+ ChatColor.DARK_GREEN + ":" + ChatColor.GREEN
						+ " You bought " + ChatColor.GOLD
						+ "an Item from the shop");
				player.closeInventory();
			}
		}
	}
}
