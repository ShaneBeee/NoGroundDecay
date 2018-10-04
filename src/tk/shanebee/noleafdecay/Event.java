package tk.shanebee.noleafdecay;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.LeavesDecayEvent;

public class Event implements Listener {

    @EventHandler
    public void onDecay(LeavesDecayEvent event) {
        Block below = event.getBlock().getRelative(BlockFace.DOWN);
        Block twobelow = below.getRelative(BlockFace.DOWN);

        if (below.getType() == Material.GRASS || below.getType() == Material.DIRT) {

            event.setCancelled(true);

        } else if (twobelow.getType() == Material.GRASS || twobelow.getType() == Material.DIRT) {

            event.setCancelled(true);
        }

    }
}
