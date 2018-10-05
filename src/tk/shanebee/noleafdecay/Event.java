package tk.shanebee.noleafdecay;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.type.Leaves;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.LeavesDecayEvent;

public class Event implements Listener {

    @EventHandler
    public void onDecay(LeavesDecayEvent event) {
        Block below = event.getBlock().getRelative(BlockFace.DOWN);
        Block twobelow = below.getRelative(BlockFace.DOWN);

        if (below.getType() == Material.GRASS_BLOCK || below.getType() == Material.DIRT || below.getType() == Material.PODZOL || below.getType() == Material.COARSE_DIRT) {

            event.setCancelled(true);
            Leaves leaf = (Leaves) event.getBlock().getState().getBlockData();
            leaf.setPersistent(true);
            event.getBlock().setBlockData(leaf);

        }
        else if (twobelow.getType() == Material.GRASS_BLOCK || twobelow.getType() == Material.DIRT || twobelow.getType() == Material.PODZOL || twobelow.getType() == Material.COARSE_DIRT) {

            if (below.getType() == Material.OAK_LEAVES || below.getType() == Material.BIRCH_LEAVES || below.getType() == Material.SPRUCE_LEAVES ||
                    below.getType() == Material.JUNGLE_LEAVES || below.getType() == Material.ACACIA_LEAVES || below.getType() == Material.DARK_OAK_LEAVES) {
                event.setCancelled(true);
                Leaves leaf = (Leaves) event.getBlock().getState().getBlockData();
                leaf.setPersistent(true);
                event.getBlock().setBlockData(leaf);
            }

        }

    }

}
