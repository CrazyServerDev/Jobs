package de.crazyserverdev.jobs.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

import de.crazyserverdev.jobs.configs.Config;

public class getIventoryClickEvent implements Listener{
	
	
	@EventHandler
	public void onClickInevtory(InventoryClickEvent e) {
	
		String invname;
		 
		
		
		 if(e.getView().getTitle() != null)
		 {
			 invname = e.getView().getTitle();
			 invname = ChatColor.stripColor(invname);
			 Player p = (Player)e.getWhoClicked();
			 
		 
			 p.sendMessage(invname);
		 
			 //Hauptmenü #######################################################################
			 
			 
			 
			 
			 if(e.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', Config.config.getString("MenuSettings.MainMenuName"))))
			 {
				 
				 p.sendMessage("test");
				
				e.setCancelled(true);
			 }
			 
			 
			 
			 
			 
			 
			 
			 
		 
		 
		 
		 
		 }
		 
		 
		 
		 
		
		 
		 
		 
		
		
	}
	
	
	

}
