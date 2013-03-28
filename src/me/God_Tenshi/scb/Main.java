package me.God_Tenshi.scb;


import me.God_Tenshi.scb.Classes.DoubleJump;
import me.God_Tenshi.scb.Classes.ItemGrenade;
import me.God_Tenshi.scb.Listener.BowListener;
import me.God_Tenshi.scb.Listener.ChatListener;
import me.God_Tenshi.scb.Listener.DeathListener;
import me.God_Tenshi.scb.Listener.NoFallDamage;
import me.God_Tenshi.scb.Listener.NoRespawn;
import me.God_Tenshi.scb.Listener.SignListener;
import me.God_Tenshi.scb.Listener.playerListener;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin { 

	public static Main plugin;
	public static Main instance;
	public boolean isWither = false;
	
	public void onEnable() {
		System.out.println("SuperCraftBrothers is Enabled!");
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new playerListener(this), this);
		pm.registerEvents(new DeathListener(this), this);
		pm.registerEvents(new ChatListener(this), this);
		pm.registerEvents(new BowListener(this), this);
		pm.registerEvents(new SignListener(this), this);
		pm.registerEvents(new ItemGrenade(this), this);
		pm.registerEvents(new NoRespawn(this), this);
		pm.registerEvents(new GemShop(this), this);
		pm.registerEvents(new DoubleJump(this), this);
		pm.registerEvents(new NoFallDamage(this), this);
		getConfig().options().copyDefaults(true);
		saveConfig();
	}

	public void onDisable() {
		System.out.println("SuperCraftBrothers is Disabled!");
		saveConfig();
	}
}
