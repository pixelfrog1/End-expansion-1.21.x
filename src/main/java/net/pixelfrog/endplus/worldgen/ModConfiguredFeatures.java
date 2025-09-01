package net.pixelfrog.endplus.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.BendingTrunkPlacer;
import net.pixelfrog.endplus.EndPlus;
import net.pixelfrog.endplus.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> CHORUS_KEY = registerKey("chorus");

    public static final ResourceKey<ConfiguredFeature<?, ?>> CHORUS_BUSH_KEY = registerKey("chorus_bush");

    public static final ResourceKey<ConfiguredFeature<?, ?>> TWISTING_END_VINES_KEY = registerKey("twisting_end_vines");


    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
            register(context, CHORUS_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                            BlockStateProvider.simple(ModBlocks.CHORUS_LOG.get()),
                            new BendingTrunkPlacer(4, 2, 0, 3, UniformInt.of(1, 2)),
                            new WeightedStateProvider(
                                    SimpleWeightedRandomList.<BlockState>builder().add(ModBlocks.CHORUS_SPROUT_BLOCK.get().defaultBlockState(), 3)
                            ),
                            new RandomSpreadFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), ConstantInt.of(2), 50),
                            new TwoLayersFeatureSize(3, 2, 2))

                            .dirt(BlockStateProvider.simple(ModBlocks.ENDER_FOLIAGE.get()))
                            .forceDirt()
                            .build());

        register(context, CHORUS_BUSH_KEY, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                        BlockStateProvider.simple(ModBlocks.CHORUS_SPROUTS.get().defaultBlockState())
                ), List.of(ModBlocks.ENDER_FOLIAGE.get())));

        register(context, TWISTING_END_VINES_KEY, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                        BlockStateProvider.simple(ModBlocks.TWISTING_END_VINES_HEAD.get().defaultBlockState())
                ), List.of(ModBlocks.ENDER_FOLIAGE.get())));
    }

        public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
            return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(EndPlus.MOD_ID, name));
        }

        private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                              ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
            context.register(key, new ConfiguredFeature<>(feature, configuration));
        }
}

