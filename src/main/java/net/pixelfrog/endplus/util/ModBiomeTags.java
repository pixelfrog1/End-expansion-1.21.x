package net.pixelfrog.endplus.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.pixelfrog.endplus.EndPlus;

public class ModBiomeTags {
    public static final TagKey<Biome> IS_END_WILDS = create("is_end_wilds");

    private static TagKey<Biome> create(String pName) {
        return TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(EndPlus.MOD_ID, pName));
    }

    public static TagKey<Biome> create(String namepsace, String path) {
        return create(ResourceLocation.fromNamespaceAndPath(namepsace, path));
    }

    public static TagKey<Biome> create(ResourceLocation name) {
        return TagKey.create(Registries.BIOME, name);
    }
}
