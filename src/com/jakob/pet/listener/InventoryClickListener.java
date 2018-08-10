package com.jakob.pet.listener;

import com.jakob.pet.main.Main;
import de.Modex.api.utils.ItemBuilder;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;

public class InventoryClickListener implements Listener {

    private Main m;
    public InventoryClickListener(Main m)
    {
        this.m = m;
    }
    // TODO: EntityDamageEvent canceln wenn es so ein viech ist
    // TODO: VehicleEjectedEvent (oderso) dass viech stirbt
    @EventHandler
    public void inventoryClicked(InventoryClickEvent ice)
    {
        if(ice.getClickedInventory().getTitle().equals("§cPets"))
        {
            ice.setCancelled(true);
            Player p = (Player) ice.getWhoClicked();
            p.closeInventory();

            Location loc = p.getLocation();
            World world = p.getWorld();
            ItemStack stack = ice.getCurrentItem();
            String name = stack.getItemMeta().getDisplayName();
            switch(name)
            {
                case "Pferd":
                    Horse h = world.spawn(loc, Horse.class);
                    h.setMetadata(p.getName(), new FixedMetadataValue(m, "canKill"));
                    h.setVariant(Horse.Variant.HORSE);
                    h.getInventory().setSaddle((new ItemBuilder(Material.SADDLE, 1)).build());
                    h.setPassenger(p);
                    break;
                case "Esel":
                    Horse e = world.spawn(loc, Horse.class);
                    e.setMetadata(p.getName(), new FixedMetadataValue(m, "canKill"));
                    e.setVariant(Horse.Variant.DONKEY);
                    e.getInventory().setSaddle((new ItemBuilder(Material.SADDLE, 1)).build());
                    e.setPassenger(p);
                    break;
                default:
            }
        }
    }
}
