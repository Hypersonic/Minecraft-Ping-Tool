package aor.PingTool;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.material.*;
import java.util.*;
import org.bukkit.scheduler.*;
import org.bukkit.DyeColor;

public class PingToolPlayerListener extends PlayerListener {    
    public static PingTool plugin;
    public static List<Block> replacedBlocks=new ArrayList<Block>();
    public static List<Material> replacedBlocksMaterial=new ArrayList<Material>();
    public static final MaterialData redWool=new MaterialData(Material.WOOL,(byte)14);
    public byte redByte=(byte)14;
//  public Material redwool=
    public PingToolPlayerListener(PingTool instance) {
        plugin = instance;
    }
    public static void replaceBlock(){
        //put the block back in world
        Block block=replacedBlocks.get(0);
        Block tempBlock=replacedBlocks.get(0);
        Material tempMaterial=replacedBlocksMaterial.get(0);
        System.out.println("Stored the blocks");
        replacedBlocks.remove(0);
        replacedBlocksMaterial.remove(0);
        if(!replacedBlocks.contains(block)){
            tempBlock.setType(tempMaterial);
            System.out.println("changed it back");
        }
        System.out.println("Finished");
        
    }
    public void onPlayerInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();
        // Left clicking air or a block event:
        if ((event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) && player.getItemInHand().getType() == Material.WOOL) // If they left clicked with wool.
        {
            Block targetBlock = player.getTargetBlock(null, 1000); // Select the target block.
            if (targetBlock.getType() != Material.AIR) // No pinging midair!
            {
                if(replacedBlocks.size()>0){
                    if(!replacedBlocks.contains(targetBlock)){
                        replacedBlocks.add(targetBlock);//store the block
                        replacedBlocksMaterial.add(targetBlock.getType());
                        targetBlock.setType(redWool.getItemType()); // Turn it to wool!
                        try{
                            Thread.sleep(2000);
                        }
                        catch(InterruptedException ae){
                            System.out.println(ae);
                        }
                        replaceBlock();
                    }
                    else{
                        replacedBlocks.add(replacedBlocks.get(replacedBlocks.indexOf(targetBlock)));//store the block
                        replacedBlocksMaterial.add(replacedBlocks.get(replacedBlocks.indexOf(targetBlock)).getType());
                        targetBlock.setType(redWool.getItemType()); // Turn it to wool!
                        try{
                            Thread.sleep(2000);
                        }
                        catch(InterruptedException ae){
                            System.out.println(ae);
                        }
                        replaceBlock();
                    }
                }
                else{
                    System.out.println("First Use Run");
                    replacedBlocks.add(targetBlock);//store the block
                    replacedBlocksMaterial.add(targetBlock.getType());
                    targetBlock.setType(redWool.getItemType());
                    System.out.println("Set to Red");
                    try{
                        Thread.sleep(2000);
                    }
                    catch(InterruptedException ae){
                        System.out.println(ae);
                    }
                    System.out.println("Slept");
                    replaceBlock();
                }
            }
        }
    }
}