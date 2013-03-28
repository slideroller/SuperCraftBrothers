package me.God_Tenshi.scb.Listener;

import me.God_Tenshi.scb.Main;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.WitherSkull;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BowListener implements Listener {
	
	private Main plugin;

	public BowListener (Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onShoot(EntityShootBowEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			if (p.isOp());
			e.setCancelled(true);
			p.launchProjectile(WitherSkull.class).setVelocity(
					e.getProjectile().getVelocity());
		} else if (e.getEntity() instanceof Player) {
			final Player player = (Player) e.getEntity();
			final ItemStack bow = e.getBow();
			Bukkit.getServer().getScheduler()
					.scheduleSyncDelayedTask(plugin, new Runnable() {
						@SuppressWarnings("deprecation")
						public void run() {
							bow.setDurability((short) 385);
							player.updateInventory();
						}
					}, 1);
		}
	}

	@EventHandler
	public void onHitEvent(ProjectileHitEvent event) {
		Projectile shot = event.getEntity();
		Location loc = shot.getLocation();
		shot.getWorld().getBlockAt(loc);
	}

	@EventHandler
	public void onHit(EntityDamageByEntityEvent event) {
		if (event.getEntity() instanceof Player) {
			Player damaged = (Player) event.getEntity();
			if (event.getDamager() instanceof WitherSkull) {
				@SuppressWarnings("unused")
				WitherSkull skull = (WitherSkull) event.getDamager();
				damaged.addPotionEffect(new PotionEffect(
						PotionEffectType.WITHER, 200, 1));
			}
		}
	}
}
