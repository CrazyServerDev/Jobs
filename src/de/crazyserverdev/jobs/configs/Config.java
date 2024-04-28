package de.crazyserverdev.jobs.configs;

import de.crazyserverdev.jobs.main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputFilter;
import java.lang.module.Configuration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Config {



    public static ObjectInputFilter.Config configs;


    public static File file = new File("plugins/Jobs", "Config.yml");

    public static FileConfiguration config = (FileConfiguration) YamlConfiguration.loadConfiguration(file);


    public static void loadFile() {


        try {

            Bukkit.getLogger().info("start2");
            file = new File(main.getInstance().getDataFolder(), "Config.yml");
            boolean created = true;
            if (!file.exists()) {

                Bukkit.getLogger().info("3");
                file.createNewFile();
                loadMessages();
            }


        } catch (Exception exception) {
        }
    }


    public static void loadMessages() {
        Bukkit.getLogger().info("start4");

        try {

            file = new File(main.getInstance().getDataFolder(), "Config.yml");



            Bukkit.getLogger().info("start5");
            config.set("MYSQL", false);
            

               save();

        } catch (Exception exception) {
        }
    }


    public static void save() {
        try {
            config.save(file);
        } catch (IOException e) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, (String) null, e);
        }
    }
}