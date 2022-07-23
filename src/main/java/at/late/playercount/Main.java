package at.late.playercount;

import at.late.playercount.commands.CheckForServer;
import at.late.playercount.filemanager.FileManager;
import at.late.playercount.filemanager.MySQL;
import at.late.playercount.utils.Scheduler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main instance;
    public static String prefix = "§c§lPlayercount §7| §f";
    private Scheduler scheduler;
    public static MySQL SQL;

    @Override
    public void onEnable() {

        Bukkit.getConsoleSender().sendMessage(prefix + "§aEnabled!");

        FileManager.setup();
        instance = this;
        Scheduler.run();

        getCommand("checkplayers").setExecutor(new CheckForServer());
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(prefix + "§aDisabled!");
    }

    public static Main getInstance() {
        return instance;
    }

}
