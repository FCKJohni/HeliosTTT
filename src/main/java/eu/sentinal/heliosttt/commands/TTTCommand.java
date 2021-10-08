package eu.sentinal.heliosttt.commands;

import eu.sentinal.heliosttt.HeliosTTT;
import eu.sentinal.heliosttt.utils.pojo.Pair;
import me.mattstudios.mf.annotations.Alias;
import me.mattstudios.mf.annotations.Command;
import me.mattstudios.mf.annotations.Default;
import me.mattstudios.mf.annotations.SubCommand;
import me.mattstudios.mf.base.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.UUID;

@Command("TTT")
@Alias("TicTacToe")
public class TTTCommand extends CommandBase {

    private HeliosTTT heliosTTT;

    public TTTCommand(HeliosTTT heliosTTT) {
        this.heliosTTT = heliosTTT;
    }

    @Default
    public void defaultCommand(final Player player) {
        if (player.hasPermission("ttt.play")) {
            if (heliosTTT.getHeliosLoader().getInventoryManager().caller != null) {
                player.sendMessage(HeliosTTT.PLUGIN_PREFIX + ChatColor.RED + "Es läuft bereits eine Runde, bitte warte bis diese vorbei ist!");
                return;
            }
            heliosTTT.getHeliosLoader().getInventoryManager().getByName("INVITE").initGUI().open(player, null);
        }
    }

    @SubCommand("accept")
    public void accept(final Player player) {
        Pair<UUID, UUID> invite = heliosTTT.getHeliosLoader().getInventoryManager().invite;
        if (invite.getValue().equals(player.getUniqueId())) {
            if (heliosTTT.getHeliosLoader().getInventoryManager().caller != null && !invite.getValue().equals(player.getUniqueId())) {
                player.sendMessage(HeliosTTT.PLUGIN_PREFIX + ChatColor.RED + "Es läuft bereits eine Runde, bitte warte bis diese vorbei ist!");
                return;
            }
            heliosTTT.getHeliosLoader().getInventoryManager().getByName("PLAY").initGUI().open(Bukkit.getPlayer(invite.getKey()), player);
        } else {
            player.sendMessage(HeliosTTT.PLUGIN_PREFIX + ChatColor.RED + "Die einladung ist abgelaufen!");
        }
    }

}
