package com.example.sandevistan;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> SANDEVISTAN = Registry.registerReference(
            Registries.STATUS_EFFECT, Identifier.of(SandevistanMod.MOD_ID, "sandevistan"), new SandevistanEffect());

    public static void register() {}
}
