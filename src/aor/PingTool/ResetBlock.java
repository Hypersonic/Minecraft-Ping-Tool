package aor.PingTool;

import org.bukkit.Material;
import org.bukkit.block.Block;
import java.lang.Runnable;

public class ResetBlock implements Runnable{
	public void run(){
		PingToolPlayerListener.replaceBlock();
	}
}