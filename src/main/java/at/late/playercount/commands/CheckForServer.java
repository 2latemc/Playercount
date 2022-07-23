package at.late.playercount.commands;

import at.late.playercount.filemanager.SQLGetter;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static at.late.playercount.Main.prefix;

public class CheckForServer implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length != 1) {
            sender.sendMessage(prefix + "§cGib den Servernamen an!");
            return false;
        }
        int players = SQLGetter.getPlayers(args[0]);
        sender.sendMessage(prefix + "§fSpieler auf " + args[0] + ": " + players);
        return false;
    }
}
