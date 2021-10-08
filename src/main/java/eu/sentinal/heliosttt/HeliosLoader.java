package eu.sentinal.heliosttt;

import eu.sentinal.heliosttt.inventories.TTT_InviteGUI;
import eu.sentinal.heliosttt.inventories.TTT_PlayGUI;
import eu.sentinal.heliosttt.listeners.ConnectionHandler;
import eu.sentinal.heliosttt.listeners.InventoryCloseHandler;
import eu.sentinal.heliosttt.listeners.InventoryHandler;
import eu.sentinal.heliosttt.listeners.MoveHandler;
import eu.sentinal.heliosttt.utils.CommandInit;
import eu.sentinal.heliosttt.utils.InventoryManager;

public class HeliosLoader {

    private final HeliosTTT heliosTTT;
    private InventoryManager inventoryManager;
    private CommandInit commandInit;

    public HeliosLoader(HeliosTTT heliosTTT) {
        this.heliosTTT = heliosTTT;
    }

    public void initLoader() {
        initManager();
        initListeners();
        initInventories();
    }

    private void initListeners() {
        new InventoryHandler(heliosTTT);
        new MoveHandler(heliosTTT);
        new ConnectionHandler(heliosTTT);
        new InventoryCloseHandler(heliosTTT);
    }

    public void initManager() {
        this.inventoryManager = new InventoryManager(heliosTTT);
        this.commandInit = new CommandInit(heliosTTT);
        this.commandInit.init();
        this.commandInit.register();
    }

    private void initInventories() {
        new TTT_InviteGUI(heliosTTT);
        new TTT_PlayGUI(heliosTTT);
    }

    public void unload() {
    }

    public InventoryManager getInventoryManager() {
        return inventoryManager;
    }
}
