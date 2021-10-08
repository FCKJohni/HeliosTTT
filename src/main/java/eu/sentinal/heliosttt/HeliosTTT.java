package eu.sentinal.heliosttt;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class HeliosTTT extends JavaPlugin {

    public static final String PLUGIN_PREFIX = ChatColor.GRAY + "[" + ChatColor.GOLD + "TicTacToe" + ChatColor.GRAY + "] ";
    private HeliosLoader heliosLoader;

    @Override
    public void onEnable() {
        this.heliosLoader = new HeliosLoader(this);
        this.heliosLoader.initLoader();

    }

    @Override
    public void onDisable() {
        this.heliosLoader.unload();
    }

    public HeliosLoader getHeliosLoader() {
        return heliosLoader;
    }
}
