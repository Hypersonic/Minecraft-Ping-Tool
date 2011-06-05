package aor.PingTool; //Your package

import java.util.logging.Logger;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
//Any other imports can go here

/* Example Template
 * By Adamki11s
 * HUGE Plugin Tutorial
 */


public class PingTool extends JavaPlugin {

    //ClassListeners
        private final PingToolPlayerListener playerListener = new PingToolPlayerListener(this);
	private final PingToolBlockListener blockListener = new PingToolBlockListener(this);
	private final PingToolEntityListener entityListener = new PingToolEntityListener(this);
    //ClassListeners
	
	Logger log = Logger.getLogger("Minecraft");//Define your logger


	public void onDisable() {
		log.info("Disabled message here, shown in console on startup");
	}

	public void onEnable() {
		
        PluginManager pm = this.getServer().getPluginManager();
        
        
        pm.registerEvent(Event.Type.PLAYER_MOVE, playerListener, Event.Priority.Normal, this);
        pm.registerEvent(Event.Type.BLOCK_PLACE, blockListener, Event.Priority.Normal, this);
	pm.registerEvent(Event.Type.ENTITY_DAMAGE, entityListener, Event.Priority.Normal, this);

/*Some other example listeners

        pm.registerEvent(Event.Type.BLOCK_BREAK, blockListener, Event.Priority.Normal, this);
        pm.registerEvent(Event.Type.CREATURE_SPAWN, spawnListener, Event.Priority.Normal, this);
        pm.registerEvent(Event.Type.ENTITY_EXPLODE, entityListener, Event.Priority.Normal, this);
        pm.registerEvent(Event.Type.BLOCK_BURN, blockListener, Event.Priority.Normal, this);
        pm.registerEvent(Event.Type.BLOCK_IGNITE, blockListener, Event.Priority.Normal, this);
        pm.registerEvent(Event.Type.PLAYER_JOIN, playerListener, Event.Priority.Normal, this);
        pm.registerEvent(Event.Type.PLAYER_INTERACT, playerListener, Event.Priority.Normal, this);
*/
        
        
       
	}
	
}