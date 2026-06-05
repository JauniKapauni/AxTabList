package de.jaunikapauni.axtablist.listener;

import de.jaunikapauni.axtablist.AxTabList;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class PlayerJoinListener implements Listener {

    AxTabList reference;
    public PlayerJoinListener(AxTabList reference){
        this.reference = reference;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        reference.getPlayerManager().setScoreboard(p);
        reference.getPlayerManager().startTabListUpdater(p);
    }
}
