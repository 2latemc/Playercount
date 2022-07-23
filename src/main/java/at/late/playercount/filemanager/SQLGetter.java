package at.late.playercount.filemanager;

import at.late.playercount.Main;
import org.bukkit.Bukkit;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static at.late.playercount.Main.SQL;

public class SQLGetter {
    private Main plugin;
    public SQLGetter(Main plugin) {
        this.plugin = plugin;
    }

    public void createTable() {
        PreparedStatement preparedStatement;
        try{
            preparedStatement = SQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS PLAYERCOUNT " + "(SERVER VARCHAR(100),PLAYERS VARCHAR(100))");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updatePlayers() {
        try {
            String players = String.valueOf(Bukkit.getOnlinePlayers().size());
            String serverName = FileManager.getServer();

            PreparedStatement preparedStatement = SQL.getConnection().prepareStatement("DELETE FROM PLAYERCOUNT");
            preparedStatement.executeUpdate();
            PreparedStatement preparedStatement1 = SQL.getConnection().prepareStatement ("INSERT IGNORE INTO PLAYERCOUNT" + " (SERVER,PLAYERS) VALUES (?,?)");
            preparedStatement1.setString(1, serverName);
            preparedStatement1.setString(2, players);
            preparedStatement1.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getPlayers(String serverName) {
        try {
            PreparedStatement preparedStatement = SQL.getConnection().prepareStatement("SELECT PLAYERS FROM PLAYERCOUNT WHERE SERVER=?");
            preparedStatement.setString(1, serverName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                int players = Integer.parseInt(resultSet.getString("PLAYERS"));
                return players;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}