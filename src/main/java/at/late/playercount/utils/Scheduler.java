package at.late.playercount.utils;

import at.late.playercount.filemanager.SQLGetter;
import at.late.playercount.Main;
import org.bukkit.scheduler.BukkitRunnable;

public class Scheduler {
    public static void run() {
        new BukkitRunnable() {
            @Override
            public void run() {
                SQLGetter.updatePlayers();
            }
        }.runTaskTimer(Main.getInstance(), 0L, 3 * 20);
    }
}