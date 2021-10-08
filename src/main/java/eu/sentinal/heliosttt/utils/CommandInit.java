package eu.sentinal.heliosttt.utils;

import eu.sentinal.heliosttt.HeliosTTT;
import eu.sentinal.heliosttt.commands.TTTCommand;
import me.mattstudios.mf.base.CommandManager;
import org.bukkit.ChatColor;

public class CommandInit {

    private HeliosTTT heliosTTT;
    private CommandManager commandManager;

    public CommandInit(HeliosTTT heliosTTT){
        this.heliosTTT = heliosTTT;
        this.commandManager = new CommandManager(heliosTTT);
    }

    public void init(){
        this.commandManager.getMessageHandler().register("cmd.no.permission", sender -> sender.sendMessage(HeliosTTT.PLUGIN_PREFIX + ChatColor.RED + "You don't have the required Permissions for that Command!"));
        this.commandManager.getMessageHandler().register("cmd.no.console", sender -> sender.sendMessage(HeliosTTT.PLUGIN_PREFIX + ChatColor.RED + "This Command is not meant to be used in the Console!"));
        this.commandManager.getMessageHandler().register("cmd.no.exists", sender -> sender.sendMessage(HeliosTTT.PLUGIN_PREFIX + ChatColor.RED + "This (Sub)Command does not exist!"));
        this.commandManager.getMessageHandler().register("cmd.wrong.usage", sender -> sender.sendMessage(HeliosTTT.PLUGIN_PREFIX + ChatColor.RED + "Invalid Syntax"));



    }

    public void register(){
        this.commandManager.register(new TTTCommand(heliosTTT));
    }

}
