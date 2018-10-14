package tk.shanebee.noleafdecay;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {

    FileConfiguration config = getConfig();

    @Override
    public void onEnable() {

        PluginDescriptionFile pdfFile = getDescription();

        String pre = ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + pdfFile.getName() + ChatColor.DARK_GRAY + "]";
        String ver = ChatColor.GRAY + "v" + pdfFile.getVersion() + ChatColor.RESET;

        getServer().getConsoleSender().sendMessage(pre + ChatColor.GREEN + " Successfully loaded " + ver);
        getServer().getPluginManager().registerEvents(new Event(), this);

        config.addDefault("Metrics.Enabled", true);
        config.options().header(
                "No Ground Leaf Decay\n" + "Version = " + pdfFile.getVersion() +
                "\nYou can disable metrics if you prefer, although it has no affect on your servers performance"
        ).copyDefaults(true);
        saveConfig();

        if (config.getBoolean("Metrics.Enabled")) {
            Metrics metrics = new Metrics(this);
            getServer().getConsoleSender().sendMessage(pre + ChatColor.GREEN + " Metrics Enabled");
        }
        else {
            getServer().getConsoleSender().sendMessage(pre + ChatColor.GOLD + " Metrics Disabled");
        }
    }

    @Override
    public void onDisable() {

        getLogger().info("Unloaded successfully!");

    }

}
