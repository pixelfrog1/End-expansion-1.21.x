package net.pixelfrog.endplus.block;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.PushReaction;
import net.pixelfrog.endplus.block.custom.*;
import net.pixelfrog.endplus.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pixelfrog.endplus.EndPlus;
import net.pixelfrog.endplus.worldgen.tree.ModTreeGrowers;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, EndPlus.MOD_ID);


    public static final RegistryObject<Block> ENDER_FOLIAGE = registerBlock("ender_foliage",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .sound(SoundType.STONE)));

    public static final RegistryObject<Block> CHORUS_LOG = registerBlock("chorus_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_CHORUS_LOG = registerBlock("stripped_chorus_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));

    public static final RegistryObject<Block> CHORUS_PLANKS = registerBlock("chorus_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> VOID_BLOCK = registerBlock("void_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .sound(SoundType.STONE)));

    public static final RegistryObject<Block> CHORUS_SAPLING = registerBlock("chorus_sapling",
            () -> new ChorusSaplingBlock(ModTreeGrowers.CHORUS, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> CHORUS_SPROUT_BLOCK = registerBlock("chorus_sprout_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .sound(SoundType.WART_BLOCK)));

    public static final RegistryObject<Block> CHORUS_BULB_HEAD = registerBlock("chorus_bulb_head",
            () -> new EndVinesHeadBlock(BlockBehaviour.Properties.of()
                    .instabreak()
                    .noCollission()
                    .sound(SoundType.WART_BLOCK)
                    .pushReaction(PushReaction.DESTROY)
                    .lightLevel(p_152663_ -> 12)));

    public static final RegistryObject<Block> CHORUS_BULB_BODY = registerBlock("chorus_bulb_body",
            () -> new EndVinesBodyBlock(BlockBehaviour.Properties.of()
                    .instabreak()
                    .noCollission()
                    .sound(SoundType.WART_BLOCK)
                    .pushReaction(PushReaction.DESTROY)
                    .lightLevel(p_152663_ -> 3)));

    public static final RegistryObject<Block> CHORUS_SPROUTS = registerBlock("chorus_sprouts",
            () -> new ChorusSproutBlock(BlockBehaviour.Properties.of()
                    .instabreak()
                    .noCollission()
                    .sound(SoundType.WART_BLOCK)
                    .pushReaction(PushReaction.DESTROY)
                    .lightLevel(p_152663_ -> 3)) {
            });

    public static final RegistryObject<Block> TWISTING_END_VINES_BODY = registerBlock("twisting_end_vines_body",
            () -> new StandingEndVinesBodyBlock(BlockBehaviour.Properties.of()
                    .instabreak()
                    .noCollission()
                    .sound(SoundType.WART_BLOCK)
                    .pushReaction(PushReaction.DESTROY)
                    .lightLevel(p_152663_ -> 5)) {
            });

    public static final RegistryObject<Block> TWISTING_END_VINES_HEAD = registerBlock("twisting_end_vines_head",
            () -> new StandingEndVinesHeadBlock(BlockBehaviour.Properties.of()
                    .instabreak()
                    .noCollission()
                    .sound(SoundType.WART_BLOCK)
                    .pushReaction(PushReaction.DESTROY)
                    .lightLevel(p_152663_ -> 10)) {
            });


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
