package de.crazyserverdev.jobs.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

import de.crazyserverdev.jobs.configs.Config;
import de.crazyserverdev.jobs.configs.Jobs;

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
		 
//##################					Hauptmenü					#######################################################################
			 
			 if(e.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', Config.config.getString("MenuSettings.MainMenuName"))))
			 {
				 
				 p.sendMessage("test");
				
//###################					Abfrage ob ein jobITEM IM JAUPTMENÜ GEKLICKT WURDE					#############################*
				 
				 if(e.getCurrentItem().getItemMeta().getDisplayName() != null)
				 {
				 String clickitename = ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName());
				 
				 
				 p.sendMessage(Jobs.config.contains("Jobs.Menu." + clickitename) + "");
				
				 if(Jobs.config.contains("Jobs.Menu." + clickitename))
				 {

					 
					if(e.getAction() == InventoryAction.PICKUP_ALL)
					{
						//links klick
						p.sendMessage("Linksklick"+ e.getAction());
					}
					if(e.getAction() == InventoryAction.PICKUP_HALF)
					{
						//rechst klick

						p.sendMessage("Rechstklick"+ e.getAction());
					}
					 
				 }
				 
				 }
				e.setCancelled(true);
			 }
			 
			 
			 
			 
			 
			 
			 
			 
		 
		 
		 
		 
		 }
		 
		 
		 
		 
		
		 
		 
		 
		
		
	}
	
	
	

}
