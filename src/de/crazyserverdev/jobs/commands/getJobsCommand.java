package de.crazyserverdev.jobs.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import de.crazyserverdev.jobs.utils.Menue;


public class getJobsCommand implements CommandExecutor {
    public static Inventory inv;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player)
        {
        Player p = (Player) sender;




        p.openInventory(Menue.defaultMenu(p));
        return true;
        }
        else
        {
            Bukkit.getLogger().info("konsole");
            return true;

        }


    }
}
