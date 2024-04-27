package de.crazyserverdev.jobs.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.crazyserverdev.jobs.Main;
import de.crazyserverdev.jobs.configs.Jobs;

public class Menue {
	

    public static Inventory inv;
	public static Inventory defaultMenu(Player p) {

    	Inventory inv = Bukkit.createInventory(null, 54 * 1, "§aJobs Hauptmenü");
    	
    	
    	
    	ItemStack item = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName("§l");
        item.setItemMeta(itemMeta);
        inv.addItem(item);
    	for (int i = 0; i < 54; i++) {
            inv.setItem(i, item);
        }
    	
    	
    	
    	 for (String key : Jobs.config.getConfigurationSection("Jobs.Menu").getKeys(false)) {
         	p.sendMessage(key);
         	String mat = Jobs.config.getString("Jobs.Menu." +  key + ".MenuMaterials");
         
         	//now id[0] is the Material Id you can use it like Material.getMaterial(id[0]);
         	//and id[1] is the MaterialData you can use it liek item.setData((byte) id[1]);
         	
         	
             ItemStack is2 = new ItemStack(Material.getMaterial(mat), 1);
             ItemMeta im2 = is2.getItemMeta();
             im2.setDisplayName(ChatColor.translateAlternateColorCodes('&', Jobs.config.getString("Jobs.Menu." +  key + ".Prefix")));
             
             
             ArrayList<String> lore = new ArrayList<String>();
             lore.clear();
             for(String beschreibung : Jobs.config.getStringList("Jobs.Menu." + key + ".Beschreibung"))
             {
             lore.add(ChatColor.translateAlternateColorCodes('&', beschreibung).replaceAll("%soldmoney%", "50€"));
             }
             im2.setLore(lore);
             
             is2.setItemMeta(im2);
             
             inv.setItem(Jobs.config.getInt("Jobs.Menu." +  key + ".MenuSlot"), is2);
         	
         }
    	
    	
		return inv;
		
	}
	
	
	
	
	





	public static ItemStack getNextPageButton() {
    	
    	ItemStack is = new ItemStack(Material.LEGACY_BARRIER);
    	ItemMeta im = is.getItemMeta();
    	im.setDisplayName("§a§lNähste Seite");
    	is.setItemMeta(im);
    	return is;
    	
    	
    }
	
	public static ItemStack getPageBackButton() {
    	
    	ItemStack is = new ItemStack(Material.LEGACY_BARRIER);
    	ItemMeta im = is.getItemMeta();
    	im.setDisplayName("§c§lSeite Zurück");
    	is.setItemMeta(im);
    	return is;
    	
    	
    }



































}