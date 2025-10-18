package io.github.mcsuperplayer.noteBlockRange;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.NotePlayEvent;

public class NoteBlockRangeListener implements Listener {

    @EventHandler
    public void onNoteBlockPlay(NotePlayEvent event) {
        Location loc = event.getBlock().getLocation();
        Sound sound = event.getInstrument().getSound();
        float pitch = event.getNote().getPitch();

        if (sound == null) {
            return;
        }
        event.setCancelled(true);

        for (Player p : loc.getWorld().getPlayers()) {
            if (p.getWorld().equals(loc.getWorld()) && p.getLocation().distanceSquared(loc) <= (192 * 192)) {
                p.playSound(loc, sound, SoundCategory.RECORDS, 12.0f, pitch);
            }
        }
    }
}
