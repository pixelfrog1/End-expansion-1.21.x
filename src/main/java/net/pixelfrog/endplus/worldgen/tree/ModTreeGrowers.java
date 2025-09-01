package net.pixelfrog.endplus.worldgen.tree;

import net.minecraft.world.level.block.grower.TreeGrower;
import net.pixelfrog.endplus.EndPlus;
import net.pixelfrog.endplus.worldgen.ModConfiguredFeatures;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower CHORUS = new TreeGrower(EndPlus.MOD_ID + ":chorus",
            Optional.empty(), Optional.of(ModConfiguredFeatures.CHORUS_KEY), Optional.empty());
}
