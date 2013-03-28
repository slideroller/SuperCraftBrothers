package me.God_Tenshi.scb.Stage;

import java.util.HashSet;
import java.util.Set;

import me.God_Tenshi.scb.Main;
import me.God_Tenshi.scb.SCBPlayer;

import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.scheduler.BukkitTask;

public abstract class Stage {
	
	protected final Main plugin;
    protected final Set<BukkitTask> taskList = new HashSet<BukkitTask>();


    public Stage(Main plugin) {
		this.plugin = plugin;
	}

	/**
     * Call only at the start of a stage.
     * Start any actions that need starting.
     * Announce as necessary.
     * Let this be handled only from the changeStage method.
     */
    public abstract void begin();

    /**
     * Call only at the end of a stage, clean up.
     */
    public abstract void end();

    public abstract void handlePlayerInteract(PlayerInteractEvent event);
    
    public abstract void handleBlockPlace(BlockPlaceEvent event);

    /**
     * Call this from the PlayerJoinEvent
     * 
     * @param player
     *            The Player joining the game
     */
    public abstract void handlePlayerJoin(SCBPlayer player);

    /**
     * Call this from the PlayerQuitEvent
     * 
     * @param player
     *            The Player leaving the game
     */
    public abstract void handlePlayerQuit(SCBPlayer player);
    
    /**
     * Call this from the PlayerdeathEvent
     * 
     * @param player
     *            The Player who died
     */
    public abstract void handlePlayerDeath(SCBPlayer victim, SCBPlayer killer);
    
    /**
     * Call this from the PlayerDeathEvent
     * 
     * @param player
     *            The Player who died
     */
    public abstract void handlePlayerRespawn(PlayerRespawnEvent event);
    
    /**
     * Call this from the EntityDamageByEntityEvent
     * 
     * @param victim
     * @param damager
     */
    public abstract void handleEntityDamage(EntityDamageByEntityEvent event);

}
