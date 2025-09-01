package net.pixelfrog.endplus.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.pixelfrog.endplus.EndPlus;
import net.pixelfrog.endplus.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EndPlus.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ENDPLUS = CREATIVE_MODE_TABS.register("endplus",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.ENDER_FOLIAGE.get()))
                    .title(Component.translatable("creativetab.endplus.endplus"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModItems.CRYSTALLINE_DUST.get());
                        output.accept(ModItems.VOID_ESSENCE.get());
                        output.accept(ModItems.STELLAR_ASHES.get());
                        output.accept(ModItems.ENDER_INGOT.get());
                        output.accept(ModBlocks.ENDER_FOLIAGE.get());
                        output.accept(ModBlocks.CHORUS_LOG.get());
                        output.accept(ModBlocks.CHORUS_PLANKS.get());
                        output.accept(ModBlocks.CHORUS_SAPLING.get());
                        output.accept(ModBlocks.CHORUS_SPROUT_BLOCK.get());
                        output.accept(ModBlocks.CHORUS_SPROUTS.get());
                        output.accept(ModItems.CHORUS_HANGING_BULB.get());
                        output.accept(ModBlocks.VOID_BLOCK.get());
                        output.accept(ModItems.ENDER_SWORD.get());
                        output.accept(ModItems.BACKSTABBER.get());
                        output.accept(ModItems.OBSIDIAN_CLAYMORE.get());
                        output.accept(ModItems.THE_STARLESS_NIGHT.get());
                        output.accept(ModItems.ENDER_HELMET.get());
                        output.accept(ModItems.ENDER_CHESTPLATE.get());
                        output.accept(ModItems.ENDER_LEGGINGS.get());
                        output.accept(ModItems.ENDER_BOOTS.get());
                        output.accept(ModItems.WATCHLING_SPAWN_EGG.get());
                        output.accept(ModItems.BLASTLING_SPAWN_EGG.get());
                        output.accept(ModItems.ENDERSENT_SPAWN_EGG.get());
                        output.accept(ModItems.SNARELING_SPAWN_EGG.get());
                        output.accept(ModItems.LUMEN_SPAWN_EGG.get());
                        output.accept(ModItems.RAMPAGER_SPAWN_EGG.get());
                        output.accept(ModItems.VENGEFUL_HEART_OF_ENDER_SPAWN_EGG.get());

                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}