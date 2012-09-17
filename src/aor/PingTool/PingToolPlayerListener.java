package aor.PingTool;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PingToolPlayerListener implements Listener {	
	public static PingTool plugin;
	public static List<Block> replacedBlocks=new ArrayList<Block>();
	public static List<BlockState> replacedBlocksState=new ArrayList<BlockState>();

	public PingToolPlayerListener(PingTool instance) {
		plugin = instance;
	}

	public static void replaceBlock(){
		//put the block back in world
		BlockState blockState = replacedBlocksState.remove(0);
		if(!replacedBlocks.contains(replacedBlocks.remove(0))){
			blockState.update(true); //forces existing block to become the block represented by blockState
		}
	}

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event){
		Player player = event.getPlayer();
		// Left clicking air or a block event:
		if ((event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) && player.getItemInHand().getType() == Material.WOOL) // If they left clicked with wool.
		{
			Block targetBlock = player.getTargetBlock(null, 1000); // Select the target block.
			if (targetBlock.getType() != Material.AIR) // No pinging midair!
			{
				event.setCancelled(true);
				if(!replacedBlocks.contains(targetBlock)){
					replacedBlocks.add(targetBlock);//store the block
					replacedBlocksState.add(targetBlock.getState());
				}
				else{
					int replacedBlockIndex = replacedBlocks.indexOf(targetBlock);
					replacedBlocks.add(replacedBlocks.get(replacedBlockIndex));//store the block
					replacedBlocksState.add(replacedBlocksState.get(replacedBlockIndex));
				}
				targetBlock.setType(Material.WOOL); // Turn it to wool!
				plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
					public void run() {
						replaceBlock();
					}
				}, 20L);
			}
		}
	}
}