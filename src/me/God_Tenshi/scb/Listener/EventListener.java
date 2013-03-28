package me.God_Tenshi.scb.Listener;

import me.God_Tenshi.scb.Main;
import me.God_Tenshi.scb.SCBPlayer;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class EventListener extends Listener {

    public EventListener(Main plugin) {
        super(plugin);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
    	event.setJoinMessage(null);
        this.plugin.getCurrentStage().handlePlayerJoin(new SCBPlayer(event.getPlayer()));
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        SCBPlayer player = this.plugin.getPlayerManager().getPlayer(event.getPlayer());
        this.plugin.getCurrentStage().handlePlayerQuit(player);
        this.plugin.getPlayerManager().removePlayer(player.getPlayer());
    }
    
    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
    	 SCBPlayer victim = this.plugin.getPlayerManager().getPlayer(event.getEntity());
    	 SCBPlayer killer = this.plugin.getPlayerManager().getPlayer(event.getEntity().getKiller());
    	this.plugin.getCurrentStage().handlePlayerDeath(victim, killer);	
    }
    
    @EventHandler
    public void onDeath(PlayerRespawnEvent event) {
    	this.plugin.getCurrentStage().handlePlayerRespawn(event);	
    }
    
    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
    	this.plugin.getCurrentStage().handleEntityDamage(event);
    }
    
    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
    	this.plugin.getCurrentStage().handlePlayerInteract(event);
    }
    
    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
    	this.plugin.getCurrentStage().handleBlockPlace(event);
    }
    
    @EventHandler
    public void onWeatherChange(WeatherChangeEvent event) {
    	event.setCancelled(true);
    }
    
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
    	/*ned to redo this
    	 * SCBPlayer player = this.plugin.getPlayerManager().getPlayer(event.getPlayer());
    	
    	String pClass = "";
    	if(player.getPlayerClass() != null)
    	pClass = "[" + ChatColor.GRAY + player.getPlayerClass().getName() + colour + "]";
    	event.setFormat(colour + "["+ ChatColor.GRAY +"lvl:" + player.getLevel() + colour + "]"+ pClass + "%1$s"+ChatColor.GRAY+": %2$s");*/
    }
}
