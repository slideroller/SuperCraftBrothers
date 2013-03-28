package me.God_Tenshi.scb.Listener;


import me.God_Tenshi.scb.Main;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class SignListener implements Listener {

	int Bow = 261;
	int Infinity = 51;
	int unbreakingid = 34;
	int EnchLevel = 1;
	int unbreakinglevel = 3;
	ItemStack WitherBow = new ItemStack(Bow);
	Enchantment infinity = new EnchantmentWrapper(Infinity);
	Enchantment unbreaking = new EnchantmentWrapper(unbreakingid);
	
	private Main plugin;

	public SignListener(Main plugin) {
		this.plugin = plugin;
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onSignClick(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (event.getClickedBlock().getType() == Material.WALL_SIGN
					|| event.getClickedBlock().getType() == Material.SIGN_POST) {
				Sign sign = (Sign) event.getClickedBlock().getState();
				if (sign.getLine(1).equals(ChatColor.BLUE + "" + ChatColor.UNDERLINE + "WITHER")) {
					player.sendMessage(ChatColor.GREEN
							+ "You have choose the class " + ChatColor.DARK_GRAY
							+ "Wither");
					player.getInventory().clear();
					WitherBow.addEnchantment(unbreaking, unbreakinglevel);
					WitherBow.addEnchantment(infinity, EnchLevel);
					player.getInventory().addItem(WitherBow);
					player.getInventory()
							.addItem(new ItemStack(Material.ARROW));
					 player.updateInventory();
					 plugin.isWither = true;
				}
			}
		}
	}

	@EventHandler
	public void onSignCreate(SignChangeEvent event) {
		Player player = event.getPlayer();
		if (event.getLine(0).equalsIgnoreCase("wither")) {
			player.sendMessage(ChatColor.GREEN
					+ "Class Sign Successfully Created");
			event.setLine(0, "");
			event.setLine(1, ChatColor.BLUE + "" + ChatColor.UNDERLINE + "WITHER");
		}
	}
}
