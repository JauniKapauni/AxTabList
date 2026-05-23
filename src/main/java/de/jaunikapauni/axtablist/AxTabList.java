package de.jaunikapauni.axtablist;

import de.jaunikapauni.axtablist.listener.PlayerJoinListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class AxTabList extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
