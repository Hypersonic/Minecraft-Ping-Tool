package aor.PingTool;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerMoveEvent;


public class PingToolPlayerListener extends PlayerListener {
	
	public static PingTool plugin;
	
	public PingToolPlayerListener(PingTool instance) {
		plugin = instance;
	}

	public void onPlayerInteract(PlayerMoveEvent event){
		
		Player player = event.getPlayer();

	
	}

}