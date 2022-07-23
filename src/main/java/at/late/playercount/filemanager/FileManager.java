package at.late.playercount.filemanager;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class FileManager {
    public static File configFile = new File("plugins//Playersync", "config.yml");

    public static YamlConfiguration configuration = YamlConfiguration.loadConfiguration(configFile);

    public static void setup() {
        configuration.options().copyDefaults(true);
        configuration.addDefault("MSQL." + "host", "localhost");
        configuration.addDefault("MSQL." + "port", "3306");
        configuration.addDefault("MSQL." + "database", "database");
        configuration.addDefault("MSQL." + "username", "root");
        configuration.addDefault("MSQL." + "password", "password");
        configuration.addDefault("ThisServerName", "server01");
        saveConfig();
    }


    public static String getServer() {
        return configuration.getString("ThisServerName");
    }

    public static void saveConfig() {
        try {
            configuration.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}