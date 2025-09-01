package net.pixelfrog.endplus.item;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.pixelfrog.endplus.util.ModTags;

public class ModToolTiers {
    public static final Tier ENDER = new ForgeTier(1400, 1.6f, 6f, 20,
            ModTags.Blocks.NEEDS_VOID_TOOL, () -> Ingredient.of(ModItems.ENDER_INGOT.get()),
            ModTags.Blocks.INCORRECT_FOR_VOID_TOOL);
}
