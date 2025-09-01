package net.pixelfrog.endplus.util;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.pixelfrog.endplus.worldgen.ModBiomes;

import java.util.concurrent.CompletableFuture;

public class ModBiomeTagsModifier extends TagsProvider<Biome> {
    public ModBiomeTagsModifier(PackOutput pOutput, ResourceKey<? extends Registry<Biome>> pRegistryKey, CompletableFuture<HolderLookup.Provider> pLookupProvider) {
        super(pOutput, pRegistryKey, pLookupProvider);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModBiomeTags.IS_END_WILDS)
                .add(ModBiomes.END_WILDS);
    }
}
