package tk.shanebee.noleafdecay;

import com.google.common.collect.ImmutableSet;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.type.Leaves;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.LeavesDecayEvent;

public class DecayListener implements Listener {

    private static final ImmutableSet<Material> GROUND;

    static {
        GROUND = ImmutableSet.<Material>builder()
                .add(Material.GRASS_BLOCK)
                .add(Material.DIRT)
                .add(Material.PODZOL)
                .add(Material.COARSE_DIRT)
                .add(Material.SAND)
                .build();
    }

    @EventHandler
    public void onDecay(LeavesDecayEvent event) {
        Block block = event.getBlock();
        Block below = block.getRelative(BlockFace.DOWN);
        Block twoBelow = below.getRelative(BlockFace.DOWN);

        if (isGroundBlock(below) || (isGroundBlock(twoBelow) && Tag.LEAVES.isTagged(below.getType()))) {
            event.setCancelled(true);
            Leaves leaf = (Leaves) block.getBlockData();
            leaf.setPersistent(true);
            block.setBlockData(leaf);
        }
    }

    private boolean isGroundBlock(Block block) {
        return GROUND.contains(block.getType());
    }

}
