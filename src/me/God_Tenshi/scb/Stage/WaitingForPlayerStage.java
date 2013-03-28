package me.God_Tenshi.scb.Stage;

import me.God_Tenshi.scb.Main;
import me.God_Tenshi.scb.SCBPlayer;

import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class WaitingForPlayerStage extends Stage {

	public WaitingForPlayerStage(Main plugin) {
		super(plugin);
	}

	@Override
	public void begin() {
		// TODO Auto-generated method stub

	}

	@Override
	public void end() {
		// TODO Auto-generated method stub

	}

	@Override
	public void handlePlayerInteract(PlayerInteractEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleBlockPlace(BlockPlaceEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handlePlayerJoin(SCBPlayer player) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handlePlayerQuit(SCBPlayer player) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handlePlayerDeath(SCBPlayer victim, SCBPlayer killer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handlePlayerRespawn(PlayerRespawnEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleEntityDamage(EntityDamageByEntityEvent event) {
		// TODO Auto-generated method stub

	}

}
