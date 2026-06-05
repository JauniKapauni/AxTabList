package de.jaunikapauni.axtablist.command;

import de.jaunikapauni.axtablist.AxTabList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ReloadCommand implements CommandExecutor {
    AxTabList reference;
    public ReloadCommand(AxTabList reference){
        this.reference = reference;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        reference.getPlayerManager().reloadLangFile();
        for(Player onlinePlayer : Bukkit.getOnlinePlayers()){
            reference.getPlayerManager().setScoreboard(onlinePlayer);
        }
        sender.sendMessage("lang.yml reloaded!");
        return true;
    }
}
