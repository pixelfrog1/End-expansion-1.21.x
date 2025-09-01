package net.pixelfrog.endplus.item;

import net.minecraft.core.Direction;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pixelfrog.endplus.EndPlus;
import net.pixelfrog.endplus.block.ModBlocks;
import net.pixelfrog.endplus.entity.ModEntities;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EndPlus.MOD_ID);


    public static final RegistryObject<Item> WATCHLING_SPAWN_EGG = ITEMS.register("watchling_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.WATCHLING, 0x000000, 0xc746c0, new Item.Properties()));

    public static final RegistryObject<Item> ENDERSENT_SPAWN_EGG = ITEMS.register("endersent_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.ENDERSENT, 0x000000, 0x260024, new Item.Properties()));

    public static final RegistryObject<Item> BLASTLING_SPAWN_EGG = ITEMS.register("blastling_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.BLASTLING, 0x40122f, 0xff00a1, new Item.Properties()));

    public static final RegistryObject<Item> SNARELING_SPAWN_EGG = ITEMS.register("snareling_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.SNARELING, 0x000000, 0x879c1e, new Item.Properties()));

    public static final RegistryObject<Item> LUMEN_SPAWN_EGG = ITEMS.register("lumen_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.LUMEN, 0xffa966, 0xff9645, new Item.Properties()));

    public static final RegistryObject<Item> RAMPAGER_SPAWN_EGG = ITEMS.register("rampager_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.RAMPAGER, 0xff4000, 0xff4000, new Item.Properties()));

    public static final RegistryObject<Item> VENGEFUL_HEART_OF_ENDER_SPAWN_EGG = ITEMS.register("vengeful_heart_of_ender_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.VENGEFUL_HEART_OF_ENDER, 0xff94f4, 0xff75f1, new Item.Properties()));


    public static final RegistryObject<Item> CRYSTALLINE_DUST = ITEMS.register("crystalline_dust",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> VOID_ESSENCE = ITEMS.register("void_essence",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> STELLAR_ASHES = ITEMS.register("stellar_ashes",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ENDER_INGOT = ITEMS.register("ender_ingot",
            () -> new Item(new Item.Properties()));


    public static final RegistryObject<Item> ENDER_SWORD = ITEMS.register("ender_sword",
            () -> new SwordItem(ModToolTiers.ENDER, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.ENDER, 3, -2.4f))));

    public static final RegistryObject<Item> BACKSTABBER = ITEMS.register("backstabber",
            () -> new SwordItem(ModToolTiers.ENDER, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.ENDER, -2, 0.5f))));

    public static final RegistryObject<Item> OBSIDIAN_CLAYMORE = ITEMS.register("obsidian_claymore",
            () -> new SwordItem(ModToolTiers.ENDER, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.ENDER, 5, -2.8f))));

    public static final RegistryObject<Item> THE_STARLESS_NIGHT = ITEMS.register("the_starless_night",
            () -> new SwordItem(ModToolTiers.ENDER, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.ENDER, 7, -2.8f))));

    public static final RegistryObject<Item> CHORUS_HANGING_BULB = ITEMS.register("chorus_hanging_bulb",
            () -> new ItemNameBlockItem(ModBlocks.CHORUS_BULB_HEAD.get(), new Item.Properties()));

    public static final RegistryObject<Item> TWISTING_END_VINES = ITEMS.register("twisting_end_vines",
            () -> new ItemNameBlockItem(ModBlocks.TWISTING_END_VINES_HEAD.get(), new Item.Properties()));

    public static final RegistryObject<Item> ENDER_HELMET = ITEMS.register("ender_helmet",
            () -> new ArmorItem(ModArmorMaterials.ENDER_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(1000))));

    public static final RegistryObject<Item> ENDER_CHESTPLATE = ITEMS.register("ender_chestplate",
            () -> new ArmorItem(ModArmorMaterials.ENDER_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(1000))));

    public static final RegistryObject<Item> ENDER_LEGGINGS = ITEMS.register("ender_leggings",
            () -> new ArmorItem(ModArmorMaterials.ENDER_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(1000))));

    public static final RegistryObject<Item> ENDER_BOOTS = ITEMS.register("ender_boots",
            () -> new ArmorItem(ModArmorMaterials.ENDER_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(1000))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
