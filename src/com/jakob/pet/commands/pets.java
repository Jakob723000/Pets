package com.jakob.pet.commands;

import de.Modex.api.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class pets implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            Inventory inv = Bukkit.createInventory(null, 54, "§cPets");
            ItemStack stack = (new ItemBuilder(Material.MONSTER_EGG, 1, (byte) EntityType.HORSE.getTypeId()).setName("Pferd")).build();
            ItemStack stack2 = (new ItemBuilder(Material.MONSTER_EGG, 1, (byte) EntityType.HORSE.getTypeId()).setName("Esel")).build();

            inv.addItem(stack, stack2);
            p.openInventory(inv);
        }
        return false;
    }
}
