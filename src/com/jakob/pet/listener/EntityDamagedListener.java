package com.jakob.pet.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.metadata.MetadataValue;

public class EntityDamagedListener implements Listener {
    @EventHandler
    public void entityDamaged(EntityDamageEvent ede) {
        boolean canKill = false;
        if(ede.getEntity() instanceof Player)
        {
            Player p = (Player) ede.getEntity();
            for (MetadataValue mv : p.getVehicle().getMetadata(p.getName())) {
                canKill = mv.asString().equals("canKill");
            }
        }
        else if(ede.getEntity().getPassenger() != null)
        {
            for (MetadataValue mv : ede.getEntity().getMetadata(ede.getEntity().getPassenger().getName())) {
                canKill = mv.asString().equals("canKill");
            }
        }
        if (canKill) {
            ede.setCancelled(true);
        }
    }
}
