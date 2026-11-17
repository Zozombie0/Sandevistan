package com.example.sandevistan;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item SANDEVISTAN = Registry.register(Registries.ITEM,
            Identifier.of(SandevistanMod.MOD_ID, "sandevistan"), new SandevistanItem());

    public static void register() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(e -> e.add(SANDEVISTAN));
    }
}
