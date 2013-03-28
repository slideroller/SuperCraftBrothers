package me.God_Tenshi.scb;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;

public class PlayerManager {
	
	private Main plugin;
	private Map<String, SCBPlayer> players = new HashMap<String, SCBPlayer>();
	
	
	public PlayerManager(Main plugin) {
		this.plugin = plugin;
	}

	public SCBPlayer getPlayer(String name){
		if(players.containsKey(name))
		return players.get(name);
		return null;
	}
	
	public SCBPlayer getPlayer(Player player){
		return getPlayer(player.getName());
	}
	
	public void removePlayer(String player){
		if(players.containsKey(player)){
			players.remove(player);
		}
	}
	
	public void removePlayer(Player player){
		removePlayer(player.getName());
	}
	
	public void addPlayer(SCBPlayer player){
		players.put(player.getPlayer().getName(), player);
	}

}
