package me.God_Tenshi.scb.Classes;

import me.God_Tenshi.scb.SCBPlayer;

import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public abstract class PlayerClass {
	
	public enum Type {
		//Classes will go here
		
	}
	
	
	protected SCBPlayer player;
	
	public PlayerClass(SCBPlayer player) {
		super();
		this.player = player;
	}

	public abstract String getName();
	
	public abstract void giveKit();
	
	public abstract void classTick();

	public abstract void onIntereact(PlayerInteractEvent event);

	public abstract void onKill(SCBPlayer victim);
	
	public abstract void onDeath();

	public abstract void onPlace(BlockPlaceEvent event);
	
	public abstract void onAttack(EntityDamageByEntityEvent event);
	
	public abstract void onDamaged(EntityDamageByEntityEvent event);
}
