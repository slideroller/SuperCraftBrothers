package me.God_Tenshi.scb.Listener;

import me.God_Tenshi.scb.Main;

public abstract class Listener implements org.bukkit.event.Listener {

    protected Main plugin;

    public Listener(Main plugin) {
        this.plugin = plugin;
    }
}
