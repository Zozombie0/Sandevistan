package com.example.sandevistan;

import dev.emi.trinkets.api.TrinketsApi;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;

public class SandevistanMod implements ModInitializer {
    public static final String MOD_ID = "sandevistan";
    public static final int DURATION = 8 * 20;      // 8 секунд
    public static final int COOLDOWN = 90 * 20;     // 1.5 минуты после окончания

    @Override
    public void onInitialize() {
        ModEffects.register();
        ModItems.register();

        ServerLivingEntityEvents.AFTER_DAMAGE.register((entity, source, baseDamage, damageTaken, blocked) -> {
            if (!(entity instanceof ServerPlayerEntity player)) return;
            if (damageTaken <= 0 || !player.isAlive()) return;

            boolean equipped = TrinketsApi.getTrinketComponent(player)
                    .map(c -> c.isEquipped(ModItems.SANDEVISTAN))
                    .orElse(false);
            if (!equipped) return;
            if (player.getItemCooldownManager().isCoolingDown(ModItems.SANDEVISTAN)) return;

            player.addStatusEffect(new StatusEffectInstance(ModEffects.SANDEVISTAN, DURATION, 0, false, false, true));
            player.getItemCooldownManager().set(ModItems.SANDEVISTAN, DURATION + COOLDOWN);
            player.getWorld().playSound(null, player.getX(), player.getY(), player.getZ(),
                    SoundEvents.BLOCK_BEACON_ACTIVATE, SoundCategory.PLAYERS, 1.0f, 1.6f);
        });
    }
}
