package net.pixelfrog.endplus.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.pixelfrog.endplus.EndPlus;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_VOID_TOOL = createTag("needs_voide_tool");
        public static final TagKey<Block> INCORRECT_FOR_VOID_TOOL = createTag("incorrect_for_void_tool");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(EndPlus.MOD_ID, name));
        }
    }
}
