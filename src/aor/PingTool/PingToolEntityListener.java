package aor.PingTool;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityListener;


public class PingToolEntityListener extends EntityListener {
	
	public static PingTool plugin;
	
	public PingToolEntityListener(PingTool instance) {
		plugin = instance;
	}

	public void onEntityDamage(EntityDamageEvent event){
		
		if(event.getEntity() instanceof Player){
		//If the entity being damaged is a player then...

			event.setCancelled(true);
		//Cancel the damage event, this will give the player unlimited health
		}
	}

}