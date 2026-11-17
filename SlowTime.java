package com.example.sandevistan;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class SlowTime {
    /** Во сколько раз замедляется мир (4 = всё остальное идёт в 4 раза медленнее). */
    public static final int FACTOR = 4;

    public static boolean isActive(World world) {
        for (PlayerEntity p : world.getPlayers()) {
            if (p.hasStatusEffect(ModEffects.SANDEVISTAN)) return true;
        }
        return false;
    }

    /** true = пропустить тик этой сущности. Игроки и их транспорт не замедляются. */
    public static boolean shouldSkip(World world, Entity entity) {
        if (entity instanceof PlayerEntity) return false;
        if (entity.getRootVehicle() instanceof PlayerEntity) return false;
        if (!isActive(world)) return false;
        return world.getTime() % FACTOR != 0;
    }
}
