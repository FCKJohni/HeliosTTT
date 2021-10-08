package eu.sentinal.heliosttt.listeners;

import eu.sentinal.heliosttt.HeliosTTT;
import eu.sentinal.heliosttt.inventories.GUI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class InventoryCloseHandler implements Listener {

    private HeliosTTT heliosTTT;

    public InventoryCloseHandler(HeliosTTT heliosTTT) {
        this.heliosTTT = heliosTTT;
        Bukkit.getPluginManager().registerEvents(this, this.heliosTTT);
    }

    @EventHandler
    public void onClose(InventoryCloseEvent event) {
        if (!(event.getPlayer() instanceof Player)) return;
        GUI gui = heliosTTT.getHeliosLoader().getInventoryManager().getGUI(event.getInventory());
        if (gui != null && !gui.ended) {
            gui.invClose((Player) event.getPlayer());
        }
    }
}
