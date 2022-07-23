package at.late.playercount.commands;

import at.late.playercount.filemanager.SQLGetter;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.sql.SQLException;

import static at.late.playercount.Main.SQL;
import static at.late.playercount.Main.prefix;

public class AddValue implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length != 2) {
            sender.sendMessage(prefix + "§cGib den Servernamen und das Value an!");
            return false;
        }

        try {
            SQLGetter.addValue(args[0], args[1]);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sender.sendMessage(prefix + "Erfolg!");
        return false;
    }
}
