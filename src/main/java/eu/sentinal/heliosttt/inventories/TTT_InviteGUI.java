package eu.sentinal.heliosttt.inventories;

import com.destroystokyo.paper.profile.PlayerProfile;
import eu.sentinal.heliosttt.HeliosTTT;
import eu.sentinal.heliosttt.inventories.pojo.ItemUtils;
import eu.sentinal.heliosttt.utils.pojo.Pair;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;
import java.util.Comparator;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class TTT_InviteGUI extends GUI {

    private final HeliosTTT heliosTTT;
    private Inventory inventory;
    private final Integer[] skip = {
            10, 11, 12, 13, 14, 15, 16,
            19, 20, 21, 22, 23, 24, 25,
            28, 29, 30, 31, 32, 33, 34,
            37, 38, 39, 40, 41, 42, 43};

    private Player invoker;

    public TTT_InviteGUI(HeliosTTT heliosTTT) {
        super("INVITE");
        this.heliosTTT = heliosTTT;
        inventory = Bukkit.createInventory(null, 9 * 6, centerTitle(ChatColor.GOLD + "Spieler Einladen"));
        heliosTTT.getHeliosLoader().getInventoryManager().register(inventory, this);
    }


    @Override
    public TTT_InviteGUI initGUI() {
        for (int i = 0; i < (9 * 6); i++) {
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
        this.invoker = player;
        heliosTTT.getHeliosLoader().getInventoryManager().caller = new Pair<>(player, this);
        reSync(player);
        player.openInventory(inventory);
    }

    @Override
    public void reSync(Player player) {
        initGUI();
        int index = 0;
        int current = skip[index];
        for (Entity entity : player.getNearbyEntities(5, 5, 5).stream().filter(Player.class::isInstance).limit(skip.length).sorted(Comparator
                .comparingDouble(e -> e.getLocation().distance(player.getLocation()))).collect(Collectors.toList())) {
            for (Integer integer : skip) {
                inventory.setItem(integer, new ItemStack(Material.AIR));
            }
            if (inventory.getItem(current) != null && inventory.getItem(current).getType() != Material.AIR)
                current = skip[++index];

            inventory.setItem(current, makeHead(entity.getUniqueId(), ((Player) entity).getName()));
        }
    }

    private ItemStack makeHead(UUID uuid, String name) {
        ItemStack stack = makeStack();
        assert stack != null;
        SkullMeta meta = (SkullMeta) stack.getItemMeta();
        makeProfile(uuid, meta::setPlayerProfile);
        meta.setDisplayName(ChatColor.GOLD + name);
        stack.setItemMeta(meta);
        return stack;
    }

    private void makeProfile(UUID uuid, Consumer<PlayerProfile> playerProfileConsumer) {
        if (Bukkit.getPlayer(uuid) != null) {
            playerProfileConsumer.accept(Bukkit.getPlayer(uuid).getPlayerProfile());
        } else {
            PlayerProfile playerProfile = Bukkit
                    .createProfile(uuid, Bukkit.getOfflinePlayer(uuid).getName());
            Bukkit.getScheduler().runTaskAsynchronously(heliosTTT, () -> {
                playerProfile.complete();
                playerProfileConsumer.accept(playerProfile);
            });
        }
    }

    private ItemStack makeStack() {
        ItemStack itemStack = new ItemUtils(Material.PLAYER_HEAD).setAmount(1).setSubId((short) 3)
                .build();
        if (itemStack.getItemMeta() instanceof SkullMeta) {
            SkullMeta meta = ((SkullMeta) itemStack.getItemMeta());
            meta.setDisplayName(ChatColor.GOLD + "§4");
            itemStack.setItemMeta(meta);
            return itemStack;
        }
        return null;
    }

    @Override
    public void invClose(Player player) {
        heliosTTT.getHeliosLoader().getInventoryManager().caller = null;
    }

    @Override
    public boolean onClick(GUIClickEvent event) {
        if (event.getParent().getCurrentItem() == null) return true;

        if (event.getParent().getCurrentItem().getType().equals(Material.PLAYER_HEAD)) {
            SkullMeta skullMeta = (SkullMeta) event.getParent().getCurrentItem().getItemMeta();
            Player player = Bukkit.getPlayer(skullMeta.getOwningPlayer().getUniqueId());
            if (player == null) return true;
            TextComponent textComponent = new TextComponent(HeliosTTT.PLUGIN_PREFIX + ChatColor.GREEN + "Du wurdest zu einer Partie TicTacToe eingeladen, klicke hier um anzunehmen");
            textComponent.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/ttt accept"));
            textComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(ChatColor.GOLD + "Made by Johni ;)")));
            player.sendMessage(textComponent);

            invoker.sendMessage(HeliosTTT.PLUGIN_PREFIX + ChatColor.GREEN + "Einladung versendet!");
            this.heliosTTT.getHeliosLoader().getInventoryManager().invite = new Pair<>(invoker.getUniqueId(), player.getUniqueId());
        }
        return true;
    }
}
