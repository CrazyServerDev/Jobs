package de.crazyserverdev.jobs.configs;

import de.crazyserverdev.jobs.Main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputFilter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MYSQLConfig {
	  public static File file = new File("plugins/Jobs", "MYSQL.yml");
	  
	  public static FileConfiguration cfg = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
	  
	  public static void setupMessages() {
	    cfg.addDefault("Host", "Host");
	    cfg.addDefault("Database", "Database");
	    cfg.addDefault("Port", Integer.valueOf(3306));
	    cfg.addDefault("Username", "User");
	    cfg.addDefault("Passwort", "Passwort");
	    cfg.addDefault("Tableplayer", "Players");
	    cfg.addDefault("Tablebewerbung", "Bewerbung");
	    cfg.addDefault("Tablefirma", "Firma");
	    cfg.options().copyDefaults(true);
	    save();
	  }
	  
	  public static void loadConfig() {
	    if (!file.exists()) {
	      cfg.options().copyDefaults(true);
	      save();
	    } else {
	      try {
	        cfg.load(file);
	      } catch (IOException|org.bukkit.configuration.InvalidConfigurationException ex) {
	        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, (String)null, ex);
	      } 
	    } 
	  }
	  
	  public static void save() {
	    try {
	      cfg.save(file);
	    } catch (IOException e) {
	      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, (String)null, e);
	    } 
	  }
}