package eu.sentinal.heliosttt.inventories;

import org.bukkit.event.inventory.InventoryClickEvent;

public class GUIClickEvent {

    private final InventoryClickEvent parent;

    public GUIClickEvent(InventoryClickEvent parent) {
        this.parent = parent;
    }

    public InventoryClickEvent getParent() {
        return parent;
    }



}
