package tk.shanebee.noleafdecay;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.material.Leaves;

public class Event implements Listener {

    @EventHandler
    public void onDecay(LeavesDecayEvent event) {
        Block below = event.getBlock().getRelative(BlockFace.DOWN);
        Block twoBelow = below.getRelative(BlockFace.DOWN);

        if (below.getType() == Material.GRASS || below.getType() == Material.DIRT) {

            event.setCancelled(true);
            Block block = event.getBlock();
            BlockState state = block.getState();
            Leaves leaves = (Leaves) state.getData();
            leaves.setDecayable(false);
            state.setData(leaves);
            state.update();


        } else if (twoBelow.getType() == Material.GRASS || twoBelow.getType() == Material.DIRT) {

            event.setCancelled(true);
            Block block = event.getBlock();
            BlockState state = block.getState();
            Leaves leaves = (Leaves) state.getData();
            leaves.setDecayable(false);
            state.setData(leaves);
            state.update();
        }

    }
}
