package eu.sentinal.heliosttt.utils;

import eu.sentinal.heliosttt.HeliosTTT;
import eu.sentinal.heliosttt.inventories.GUI;
import eu.sentinal.heliosttt.utils.pojo.Pair;
import eu.sentinal.heliosttt.utils.pojo.ParameterRunnable;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.PlayerInventory;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class InventoryManager {

    private final HeliosTTT heliosTTT;
    private final Map<GUI, Inventory> guiInventoryMap = new HashMap<>();
    public Pair<Player, GUI> caller;

    public Pair<UUID, UUID> invite;

    public InventoryManager(HeliosTTT heliosTTT) {
        this.heliosTTT = heliosTTT;
    }

    public GUI getGUI(Inventory inventory) {
        for (Map.Entry<GUI, Inventory> guiInventoryEntry : guiInventoryMap.entrySet()) {
            if (guiInventoryEntry.getValue().equals(inventory)) {
                return guiInventoryEntry.getKey();
            }
        }
        return null;
    }

    public GUI getByName(String name){
        for (Map.Entry<GUI, Inventory> guiInventoryEntry : guiInventoryMap.entrySet()) {
            if(guiInventoryEntry.getKey().getName().equals(name)){
                return guiInventoryEntry.getKey();
            }
        }
        return null;
    }

    public void register(Inventory inventory, GUI gui) {
        this.guiInventoryMap.put(gui, inventory);
    }
}
