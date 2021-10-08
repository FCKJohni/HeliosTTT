package eu.sentinal.heliosttt.listeners;

import eu.sentinal.heliosttt.HeliosTTT;
import eu.sentinal.heliosttt.utils.pojo.Pair;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.UUID;

public class ConnectionHandler implements Listener {

    private HeliosTTT heliosTTT;

    public ConnectionHandler(HeliosTTT heliosTTT) {
        this.heliosTTT = heliosTTT;
        Bukkit.getPluginManager().registerEvents(this, this.heliosTTT);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Pair<UUID, UUID> invite = heliosTTT.getHeliosLoader().getInventoryManager().invite;
        if (invite.getKey().equals(event.getPlayer().getUniqueId()) || invite.getValue().equals(event.getPlayer().getUniqueId())) {
            heliosTTT.getHeliosLoader().getInventoryManager().invite = null;
        }
    }
}
