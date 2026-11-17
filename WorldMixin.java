package com.example.sandevistan.mixin;

import com.example.sandevistan.SlowTime;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

// Работает и на сервере (ServerWorld), и на клиенте (ClientWorld) — оба наследуют World.tickEntity
@Mixin(World.class)
public abstract class WorldMixin {
    @Inject(method = "tickEntity", at = @At("HEAD"), cancellable = true)
    private <T extends Entity> void sandevistan$slowEntities(Consumer<T> tickConsumer, T entity, CallbackInfo ci) {
        if (SlowTime.shouldSkip((World) (Object) this, entity)) {
            ci.cancel();
        }
    }
}
