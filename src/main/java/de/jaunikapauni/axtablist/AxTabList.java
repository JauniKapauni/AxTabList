package de.jaunikapauni.axtablist;

import de.jaunikapauni.axtablist.listener.PlayerJoinListener;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class AxTabList extends JavaPlugin {

    File langFile;
    FileConfiguration langConfig;


    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);
        createLangFile();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void createLangFile(){
        langFile = new File(getDataFolder(), "lang.yml");
        if (!langFile.exists()) {
            saveResource("lang.yml", false);
        }
        langConfig = YamlConfiguration.loadConfiguration(langFile);
    }

    public String getMessage(String path) {
        return langConfig.getString(path);
    }
}
