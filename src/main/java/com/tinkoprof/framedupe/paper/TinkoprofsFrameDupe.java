// Tinkoprof so cute
// Team Astera on top!

package com.tinkoprof.framedupe.paper.TinkoprofsFrameDupe;

import org.bukkit.Material;
import org.bukkit.entity.ItemFrame;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Tinkoprof
 * @since 19/06/2023
 */

public final class Main extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onFrame(EntityDamageByEntityEvent event) {
        ItemFrame f = (ItemFrame) event.getEntity();

        if(f.getItem().getType() != Material.AIR && 0 + (int) (Math.random() * ((100 - 0) + 1)) <= getConfig().getInt("probability", 100)) {
            f.getWorld().dropItemNaturally(f.getLocation().add(0, 1, 0), f.getItem());
            f.getVelocity().zero();
        }
    }
}
