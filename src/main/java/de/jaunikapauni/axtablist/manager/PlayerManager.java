package de.jaunikapauni.axtablist.manager;

import de.jaunikapauni.axtablist.AxTabList;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import java.io.File;

public class PlayerManager {

    AxTabList reference;
    public PlayerManager(AxTabList reference){
        this.reference = reference;
    }

    File langFile;
    FileConfiguration langConfig;

    public void createLangFile(){
        langFile = new File(reference.getDataFolder(), "lang.yml");
        if (!langFile.exists()) {
            reference.saveResource("lang.yml", false);
        }
        langConfig = YamlConfiguration.loadConfiguration(langFile);
    }

    public String getMessage(String path) {
        return langConfig.getString(path);
    }

    public void setScoreboard(Player p){
        ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = scoreboardManager.getNewScoreboard();

        Objective objective = scoreboard.registerNewObjective("tablist", "dummy");
        objective.setDisplaySlot(DisplaySlot.PLAYER_LIST);
        objective.getScore(p.getName());

        p.setScoreboard(scoreboard);
        p.setPlayerListHeader(PlaceholderAPI.setPlaceholders(p, getMessage("tablist.header")));
        p.setPlayerListFooter(PlaceholderAPI.setPlaceholders(p, getMessage("tablist.footer")));
    }

    public void reloadLangFile(){
        langConfig = YamlConfiguration.loadConfiguration(langFile);
    }

    public void updateScoreboard(Player p){
        p.setPlayerListHeader(PlaceholderAPI.setPlaceholders(p, getMessage("tablist.header")));
        p.setPlayerListFooter(PlaceholderAPI.setPlaceholders(p, getMessage("tablist.footer")));
    }

    public void startTabListUpdater(){
        Bukkit.getScheduler().runTaskTimer(reference, () -> {
            for(Player p : Bukkit.getOnlinePlayers()){
                updateScoreboard(p);
            }
        }, 20L, 20L);
    }
}
