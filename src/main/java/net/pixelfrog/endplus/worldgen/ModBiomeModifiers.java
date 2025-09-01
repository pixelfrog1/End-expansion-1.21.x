package net.pixelfrog.endplus.worldgen;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import net.pixelfrog.endplus.EndPlus;
import net.pixelfrog.endplus.util.ModBiomeTags;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_CHORUS_TREE = registerKey("add_chorus");

    public static final ResourceKey<BiomeModifier> ADD_CHORUS_BUSH = registerKey("add_chorus_bush");

    public static final ResourceKey<BiomeModifier> ADD_TWISTING_END_VINES = registerKey("add_twisting_end_vines");


    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeature = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_CHORUS_TREE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(ModBiomeTags.IS_END_WILDS),
                HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.CHORUS_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));

        context.register(ADD_CHORUS_BUSH, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(ModBiomeTags.IS_END_WILDS),
                HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.CHORUS_BUSH_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));

        context.register(ADD_TWISTING_END_VINES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(ModBiomeTags.IS_END_WILDS),
                HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.TWISTING_END_VINES_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(EndPlus.MOD_ID, name));
    }
}
