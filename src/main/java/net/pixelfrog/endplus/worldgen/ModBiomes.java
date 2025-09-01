package net.pixelfrog.endplus.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.pixelfrog.endplus.EndPlus;

public class ModBiomes {
    public static final ResourceKey<Biome> END_WILDS = register("end_wilds");

    private static ResourceKey<Biome> register(String pKey) {
        return ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(EndPlus.MOD_ID, pKey));
    }
}
