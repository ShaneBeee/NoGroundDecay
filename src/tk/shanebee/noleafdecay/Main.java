package tk.shanebee.noleafdecay;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        getLogger().info("Loaded successfully!");
        getServer().getPluginManager().registerEvents(new Event(), this);
    }

    @Override
    public void onDisable() {

        getLogger().info("Unloaded successfully!");

    }
}
