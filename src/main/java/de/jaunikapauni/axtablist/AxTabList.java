package de.jaunikapauni.axtablist;

import de.jaunikapauni.axtablist.command.ReloadCommand;
import de.jaunikapauni.axtablist.listener.PlayerJoinListener;
import de.jaunikapauni.axtablist.manager.PlayerManager;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import java.io.File;

public final class AxTabList extends JavaPlugin {
    PlayerManager playerManager;
    public PlayerManager getPlayerManager(){
        return playerManager;
    }
    @Override
    public void onEnable() {
        // Plugin startup logic
        playerManager = new PlayerManager(this);
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);
        playerManager.createLangFile();
        getCommand("reload").setExecutor(new ReloadCommand(this));
        playerManager.startTabListUpdater();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
