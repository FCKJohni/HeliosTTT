package eu.sentinal.heliosttt.inventories;

import com.google.common.base.Strings;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public abstract class GUI {

    private final String name;
    public boolean ended;

    protected GUI(String name) {
        this.name = name;
    }

    public abstract GUI initGUI();

    public abstract void open(Player player, Player target);

    public abstract void reSync(Player player);

    public abstract boolean onClick(GUIClickEvent event);

    public abstract void invClose(Player player);

    public String getName() {
        return name;
    }

    public String centerTitle(String title) {
        return Strings.repeat(" ", 27 - ChatColor.stripColor(title).length()) + title;
    }
}
