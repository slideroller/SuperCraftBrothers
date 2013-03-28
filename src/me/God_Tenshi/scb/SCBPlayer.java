package me.God_Tenshi.scb;


import me.God_Tenshi.scb.Classes.PlayerClass;

import org.bukkit.entity.Player;

public class SCBPlayer {

	private final Player player;
	private PlayerClass playerClass;
	
	public SCBPlayer(Player player) {
		this.player = player;
	}

	public PlayerClass getPlayerClass() {
		return playerClass;
	}

	public void setPlayerClass(PlayerClass playerClass) {
		this.playerClass = playerClass;
	}

	public Player getPlayer() {
		return player;
	}

}
