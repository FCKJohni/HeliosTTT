package eu.sentinal.heliosttt.listeners;

import eu.sentinal.heliosttt.HeliosTTT;
import eu.sentinal.heliosttt.utils.InventoryManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveHandler implements Listener {

    private final HeliosTTT heliosTTT;

    public MoveHandler(HeliosTTT heliosTTT) {
        this.heliosTTT = heliosTTT;
        Bukkit.getPluginManager().registerEvents(this, this.heliosTTT);
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        InventoryManager inventoryManager = heliosTTT.getHeliosLoader().getInventoryManager();
        if (!hasMoved(event.getFrom(), event.getTo())) return;
        if (inventoryManager.caller == null) return;
        if (inventoryManager.caller.getValue().getName().equals("INVITE"))
            inventoryManager.getByName("INVITE").reSync(inventoryManager.caller.getKey());
    }

    private boolean hasMoved(Location from, Location to) {
        int fromX = (int) from.getX();
        int fromY = (int) from.getY();
        int fromZ = (int) from.getZ();
        int toX = (int) to.getX();
        int toY = (int) to.getY();
        int toZ = (int) to.getZ();
        return fromX != toX || fromZ != toZ || fromY != toY;
    }
}
