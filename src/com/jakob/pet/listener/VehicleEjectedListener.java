package com.jakob.pet.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.metadata.MetadataValue;

public class VehicleEjectedListener implements Listener {

    @EventHandler
    public void vehicleEjected(VehicleExitEvent vee)
    {
        boolean canKill = false;
        for (MetadataValue mv: vee.getVehicle().getMetadata(vee.getExited().getName())) {
            canKill = mv.asString().equals("canKill");
        }
        if(canKill)
        {
            vee.getVehicle().remove();
        }
    }
}
