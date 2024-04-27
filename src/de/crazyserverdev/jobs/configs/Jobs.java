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

public class Jobs {



    public static ObjectInputFilter.Config configs;


    public static File file = new File("plugins/Jobs", "Jobs.yml");

    public static FileConfiguration config = (FileConfiguration) YamlConfiguration.loadConfiguration(file);


    public static void loadFile() {


        try {

            Bukkit.getLogger().info("start2");
            file = new File(main.getInstance().getDataFolder(), "Jobs.yml");
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

            file = new File(main.getInstance().getDataFolder(), "Jobs.yml");



            Bukkit.getLogger().info("start5");
            config.set("Jobs.Menu.Miner.Prefix", "§9Miner");
            List<String> messages = config.getStringList("Jobs.Menu.Miner.Beschreibung");
            messages.add("&8######################################");
            messages.add("&8Der Jobs Dient zum abbu von Gestein");
            messages.add("§eLinks Klick §8|| §eMehr infos");
            messages.add("§aRechst Klick §8|| §eJob Menü");
            messages.add("&8######################################");
            config.set("Jobs.Menu.Miner.Beschreibung", messages);
            config.set("Jobs.Menu.Miner.MenuSlot", 0);
            config.set("Jobs.Menu.Miner.MenuMaterials", "STONE");
            config.set("Jobs.Miner.Ranks.1.Prefix", "&aMiner1");
            config.set("Jobs.Miner.Ranks.1.XPForRank", 250);
            config.set("Jobs.Miner.Ranks.1.RankXpMulti", 1.0);
            config.set("Jobs.Miner.Ranks.1.RankMoneyMulti", 1.0);
            config.set("Jobs.Miner.Ranks.1.Beschreibung", messages);

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