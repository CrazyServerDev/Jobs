package de.crazyserverdev.jobs;

import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import de.crazyserverdev.jobs.commands.getJobsCommand;
import de.crazyserverdev.jobs.configs.Jobs;
import de.crazyserverdev.jobs.configs.MYSQLConfig;
import de.crazyserverdev.jobs.mysql.getMYSQL;
import net.milkbowl.vault.economy.Economy;


public final class Main extends JavaPlugin {

    public static Main insance;
    public static Economy eco = null;

    @Override
    public void onEnable() {
    	
    	
        // Plugin startup logic
        insance = this;
        Jobs.loadFile();
        MYSQLConfig.loadConfig();
        MYSQLConfig.setupMessages();
        getCommand("jobs").setExecutor(new getJobsCommand());
        Bukkit.getLogger().info("uggggi");
        
        
        
        if (MYSQLConfig.file.exists()) {
            MYSQLConfig.loadConfig();
            MYSQLConfig.setupMessages();
            getMYSQL.connect();
            getMYSQL.createTableBewerbungen();
            Bukkit.getConsoleSender().sendMessage("testmysql");
          } 
        else
        {

            Bukkit.getConsoleSender().sendMessage("testmysql2");
        }
        

    }

    @Override
    public void onDisable() {
    	getMYSQL.close();
        // Plugin shutdown logic
    }

    
    
    
    
    
    
    public static boolean setupEconommy() {
        if (Bukkit.getServer().getPluginManager().getPlugin("Vault") == null)
          return false; 
        RegisteredServiceProvider<Economy> rsp = Bukkit.getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null)
          return false; 
        eco = (Economy)rsp.getProvider();
        return (eco != null);
      }
    
    
    public static Main getInstance() {
        return insance;
    }
    
    
    

}
