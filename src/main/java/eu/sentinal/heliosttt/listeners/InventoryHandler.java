package eu.sentinal.heliosttt.listeners;

import eu.sentinal.heliosttt.HeliosTTT;
import eu.sentinal.heliosttt.inventories.GUI;
import eu.sentinal.heliosttt.inventories.GUIClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryHandler implements Listener {

    private final HeliosTTT heliosTTT;

    public InventoryHandler(HeliosTTT heliosTTT) {
        this.heliosTTT = heliosTTT;
        Bukkit.getPluginManager().registerEvents(this, this.heliosTTT);
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        GUI gui = heliosTTT.getHeliosLoader().getInventoryManager().getGUI(event.getClickedInventory());
        if (gui != null) {
            event.setCancelled(gui.onClick(new GUIClickEvent(event)));
        }
    }
}
