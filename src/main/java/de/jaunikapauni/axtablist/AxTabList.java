package de.jaunikapauni.axtablist;

import com.google.inject.Inject;
import com.velocitypowered.api.event.player.ServerPostConnectEvent;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.plugin.Plugin;
import net.kyori.adventure.text.Component;
import org.slf4j.Logger;

@Plugin(
        id = "axtablist",
        name = "AxTabList",
        version = "0.0.0"
)

public class AxTabList {

    @Inject private Logger logger;

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
      // Plugin initialization logic goes here
    }

    @Subscribe
    public void onJoin(ServerPostConnectEvent e){
        e.getPlayer().sendPlayerListHeaderAndFooter(Component.text("header"), Component.text("footer"));
    }
}
