package net.pixelfrog.endplus.damagesource;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;
import net.pixelfrog.endplus.EndPlus;

public class ModDamageSources {
    public static final ResourceKey<DamageType> VOID_TOUCHED = register("void_touched");

    private static ResourceKey<DamageType> register(String name) {
        return ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(EndPlus.MOD_ID, name));
    }
}
