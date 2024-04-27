package de.crazyserverdev.jobs.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import de.crazyserverdev.jobs.configs.MYSQLConfig;

public class getMYSQL {
	

	  public static String host = MYSQLConfig.cfg.getString("Host");
	  
	  public static String user = MYSQLConfig.cfg.getString("Username");
	  
	  public static String password = MYSQLConfig.cfg.getString("Passwort");
	  
	  public static String database = MYSQLConfig.cfg.getString("Database");
	  
	  public static String port = MYSQLConfig.cfg.getString("Port");
	  
	  public static String tableplayer = MYSQLConfig.cfg.getString("Tableplayer");
	  
	  public static String tablefirma = MYSQLConfig.cfg.getString("Tablefirma");
	  
	  public static String tablebewerbung = MYSQLConfig.cfg.getString("Tablebewerbung");
	  
	  public static Connection con;
	  
	  public static void connect() {
	    if (!isConnected())
	      try {
	        con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?autoReconnect=true", user, password);
	        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&aDie MYSQL Verbindung ist erfolgreich aufgebaut."));
	      } catch (SQLException e) {
	        e.printStackTrace();
	        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&cDie MYSQL Verbindung ist Fehlgeschlagen."));
	      }  
	  }
	  
	  public static void close() {
	    if (isConnected())
	      try {
	        con.close();
	        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&aDie MYSQL Verbindung wurde getrennt"));
	      } catch (SQLException e) {
	        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&cDie MYSQL Verbindung konnte nicht geschlossen werden."));
	      }  
	  }
	  
	  public static boolean isConnected() {
	    return (con != null);
	  }
	  
	  public static void createTablePlayers() {
	    try {
	      con.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS " + tableplayer + "(id INT(100) AUTO_INCREMENT NOT NULL PRIMARY KEY, uuid VARCHAR(100), firma VARCHAR(100), einnahmen VARCHAR(100), rank VARCHAR(100))");
	    } catch (SQLException e) {
	      e.printStackTrace();
	    } 
	  }
	  
	  public static void createTableFirma() {
	    try {
	      con.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS " + tablefirma + "(id INT(100) AUTO_INCREMENT NOT NULL PRIMARY KEY, firma VARCHAR(100), firma_art VARCHAR(100), besitzeruuid VARCHAR(100), einnahmen VARCHAR(100), lohn int(100))");
	    } catch (SQLException e) {
	      e.printStackTrace();
	    } 
	  }
	  
	  public static void createTableBewerbungen() {
	    try {
	      con.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS " + tablebewerbung + "(id INT(100) AUTO_INCREMENT NOT NULL PRIMARY KEY, uuid VARCHAR(100), firma_name VARCHAR(100))");
	    } catch (SQLException e) {
	      e.printStackTrace();
	    } 
	  }
}
