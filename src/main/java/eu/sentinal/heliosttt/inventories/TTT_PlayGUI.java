package eu.sentinal.heliosttt.inventories;

import eu.sentinal.heliosttt.HeliosTTT;
import eu.sentinal.heliosttt.game.BoardSlots;
import eu.sentinal.heliosttt.game.Game;
import eu.sentinal.heliosttt.game.Mark;
import eu.sentinal.heliosttt.inventories.pojo.ItemUtils;
import eu.sentinal.heliosttt.utils.pojo.Pair;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class TTT_PlayGUI extends GUI {

    private final HeliosTTT heliosTTT;
    private Inventory inventory;
    private final Integer[] skip = {12, 13, 14, 21, 22, 23, 30, 31, 32};
    private Game game;
    private Player player;
    private Player target;

    public TTT_PlayGUI(HeliosTTT heliosTTT) {
        super("PLAY");
        this.heliosTTT = heliosTTT;
        inventory = Bukkit.createInventory(null, 9 * 5, centerTitle(ChatColor.GOLD + "TicTacToe"));
        heliosTTT.getHeliosLoader().getInventoryManager().register(inventory, this);
    }

    @Override
    public TTT_PlayGUI initGUI() {
        for (int i = 0; i < (9 * 5); i++) {
            if (Arrays.asList(skip).contains(i)) {
                inventory.setItem(i, new ItemStack(Material.AIR));
                continue;
            }
            inventory.setItem(i, new ItemUtils(Material.BLACK_STAINED_GLASS_PANE).addDisplayName("").build());
        }
        return this;
    }

    @Override
    public void open(Player player, Player target) {
        heliosTTT.getHeliosLoader().getInventoryManager().caller = new Pair<>(player, this);
        this.player = player;
        this.target = target;
        player.openInventory(inventory);
        target.openInventory(inventory);
        this.game = new Game(inventory, (m, p) -> {
            ended = true;
            player.closeInventory();
            target.closeInventory();
            if (target != p) {
                target.playSound(player.getLocation(), Sound.ENTITY_SHEEP_HURT, 0.2f, 0.2f);
            } else if (player != p) {
                player.playSound(player.getLocation(), Sound.ENTITY_SHEEP_HURT, 0.2f, 0.2f);
            }
            if (m == Mark.BLANK) {
                player.sendMessage(HeliosTTT.PLUGIN_PREFIX + ChatColor.RED + "Unentschieden!");
                target.sendMessage(HeliosTTT.PLUGIN_PREFIX + ChatColor.RED + "Unentschieden!");
                player.playSound(player.getLocation(), Sound.BLOCK_BEACON_DEACTIVATE, 0.2f, 0.2f);
                target.playSound(player.getLocation(), Sound.BLOCK_BEACON_DEACTIVATE, 0.2f, 0.2f);
                this.game = null;
                return;
            } else {
                p.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.2f, 0.2f);
                if (m == null) return;
                player.sendMessage(HeliosTTT.PLUGIN_PREFIX + ChatColor.GREEN + (player == p ? "Du hast gewonnen" : m.getMark() + " (" + p.getName() + ") hat gewonnen!"));
                target.sendMessage(HeliosTTT.PLUGIN_PREFIX + ChatColor.GREEN + (player == p ? "Du hast gewonnen" : m.getMark() + " (" + p.getName() + ") hat gewonnen!"));
            }
            heliosTTT.getHeliosLoader().getInventoryManager().caller = null;
        }, player, target);
    }

    @Override
    public void invClose(Player player) {
        if (ended) return;
        ended = true;
        this.game = null;
        this.target.sendMessage(HeliosTTT.PLUGIN_PREFIX + ChatColor.RED + player.getName() + " hat das Spiel vorzeitig beendet!");
        this.player.sendMessage(HeliosTTT.PLUGIN_PREFIX + ChatColor.RED + player.getName() + " hat das Spiel vorzeitig beendet!");
        this.target.closeInventory();
        this.target = null;
        this.player.closeInventory();
        this.player = null;
        heliosTTT.getHeliosLoader().getInventoryManager().caller = null;
    }

    @Override
    public void reSync(Player player) {
        throw new NotImplementedException("Not needed!");
    }

    @Override
    public boolean onClick(GUIClickEvent event) {
        BoardSlots slot = BoardSlots.getBySlot(event.getParent().getSlot());
        if (slot == null) return true;
        this.game.placeMark(slot.getRow(), slot.getColumn(), (Player) event.getParent().getWhoClicked());
        return true;
    }
}
