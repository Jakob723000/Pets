package com.jakob.pet.main;

import com.jakob.pet.commands.pets;
import com.jakob.pet.listener.EntityDamagedListener;
import com.jakob.pet.listener.InventoryClickListener;
import com.jakob.pet.listener.VehicleEjectedListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Pet Plugin wurde aktiviert");

        Bukkit.getPluginManager().registerEvents(new InventoryClickListener(this), this);
        Bukkit.getPluginManager().registerEvents(new VehicleEjectedListener(), this);
        Bukkit.getPluginManager().registerEvents(new EntityDamagedListener(), this);
        getCommand("pets").setExecutor(new pets());
    }

    @Override
    public void onDisable() {
        System.out.println("Pet Plugin wurde deaktiviert");
    }
}
