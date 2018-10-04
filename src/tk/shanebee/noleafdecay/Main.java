package tk.shanebee.noleafdecay;

import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void onEnable() {

        PluginDescriptionFile pdfFile = getDescription();

        String pre = ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + pdfFile.getName() + ChatColor.DARK_GRAY + "]";
        String ver = ChatColor.GRAY + "v" + pdfFile.getVersion() + ChatColor.RESET;

        getServer().getConsoleSender().sendMessage(pre + ChatColor.GREEN + " Successfully loaded " + ver);
        getServer().getPluginManager().registerEvents(new Event(), this);
    }

    @Override
    public void onDisable() {

        getLogger().info("Unloaded successfully!");

    }
}
