package aor.PingTool;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerMoveEvent;


public class PingToolPlayerListener extends PlayerListener {
	
	public static PingTool plugin;
	
	public PingToolPlayerListener(PingTool instance) {
		plugin = instance;
	}

	public void onPlayerInteract(PlayerInteractEvent event){
		
		Player player = event.getPlayer();

		
		// Left clicking air or a block event:
		if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK && player.getItemInHand().getType() == Material.WOOL) // If they left clicked with wool.
		{
			Block targetBlock = player.getTargetBlock(null, 100); // Select the target block.
			if (targetBlock.getType() != Material.AIR) // No pinging midair!
			{
				targetBlock.setType(Material.WOOL); // Turn it to wool!
				
			}


			
		}

	
	}

}