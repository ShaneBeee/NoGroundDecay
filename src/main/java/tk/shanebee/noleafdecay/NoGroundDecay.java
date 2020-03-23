package tk.shanebee.noleafdecay;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class NoGroundDecay extends JavaPlugin {

    @Override
    public void onEnable() {
        new Metrics(this, 3420);
        getServer().getPluginManager().registerEvents(new DecayListener(), this);
        log("&aSuccessfully loaded!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Unloaded successfully!");
    }

    private void log(String log) {
        String prefix = "&7[&bNo&3Ground&bDecay&7] ";
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + log));
    }

}
