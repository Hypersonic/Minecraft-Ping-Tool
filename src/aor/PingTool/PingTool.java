package aor.PingTool; //Your package

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/* Example Template
 * By Adamki11s
 * HUGE Plugin Tutorial
 */


public class PingTool extends JavaPlugin {

    //ClassListeners
	private final PingToolPlayerListener playerListener = new PingToolPlayerListener(this);
    //ClassListeners

	public void onDisable() {
		getLogger().info("Disabled message here, shown in console on startup");
	}

	public void onEnable() {
		getLogger().info("Ping Tool .5 is enabled!");
        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(playerListener, this);
	}
	
}