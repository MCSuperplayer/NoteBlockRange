package io.github.mcsuperplayer.noteBlockRange;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class NoteBlockRange extends JavaPlugin {
    public static Plugin plugin;
    public static Logger logger;

    @Override
    public void onEnable() {
        plugin = this;
        logger = this.getLogger();
        getServer().getPluginManager().registerEvents(new NoteBlockRangeListener(), plugin);
        logger.info("Note Block Range active, All Note Block sounds are now audible within 192 Blocks. (except for custom head sounds)");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
