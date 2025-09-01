package net.pixelfrog.endplus.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pixelfrog.endplus.EndPlus;
import net.pixelfrog.endplus.entity.custom.boss.VengefulHeartOfEnder;
import net.pixelfrog.endplus.entity.custom.boss.Rampager;
import net.pixelfrog.endplus.entity.custom.monster.*;
import net.pixelfrog.endplus.entity.custom.projectile.OrbMagic;
import net.pixelfrog.endplus.entity.custom.projectile.RampagerFireball;
import net.pixelfrog.endplus.entity.custom.projectile.SnarelingGoop;
import net.pixelfrog.endplus.entity.custom.projectile.VoidSpew;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, EndPlus.MOD_ID);


    public static final RegistryObject<EntityType<Watchling>> WATCHLING =
            ENTITY_TYPES.register("watchling",
                    () -> EntityType.Builder.of(Watchling::new, MobCategory.MONSTER)
                            .sized(1f, 2f)
                            .fireImmune()
                            .build(("watchling")));

    public static final RegistryObject<EntityType<Endersent>> ENDERSENT =
            ENTITY_TYPES.register("endersent",
                    () -> EntityType.Builder.of(Endersent::new, MobCategory.MONSTER)
                            .sized(1f, 5f)
                            .fireImmune()
                            .build(("endersent")));

    public static final RegistryObject<EntityType<Blastling>> BLASTLING =
            ENTITY_TYPES.register("blastling",
                    () -> EntityType.Builder.of(Blastling::new, MobCategory.MONSTER)
                            .sized(1f, 2f)
                            .fireImmune()
                            .build(("blastling")));

    public static final RegistryObject<EntityType<Snareling>> SNARELING =
            ENTITY_TYPES.register("snareling",
                    () -> EntityType.Builder.of(Snareling::new, MobCategory.MONSTER)
                            .sized(1f, 2f)
                            .fireImmune()
                            .build(("snareling")));

    public static final RegistryObject<EntityType<SnarelingGoop>> SNARELING_GOOP =
            ENTITY_TYPES.register("snareling_goop",
                    () -> EntityType.Builder.<SnarelingGoop>of(SnarelingGoop::new, MobCategory.MISC)
                            .sized(1f, 1f)
                            .fireImmune()
                            .build(("snareling_goop")));

    public static final RegistryObject<EntityType<Lumen>> LUMEN =
            ENTITY_TYPES.register("lumen",
                    () -> EntityType.Builder.of(Lumen::new, MobCategory.MONSTER)
                            .sized(2f, 3f)
                            .fireImmune()
                            .build(("lumen")));

    public static final RegistryObject<EntityType<Rampager>> RAMPAGER =
            ENTITY_TYPES.register("rampager",
                    () -> EntityType.Builder.of(Rampager::new, MobCategory.MONSTER)
                            .sized(4f, 6f)
                            .fireImmune()
                            .build(("rampager")));

    public static final RegistryObject<EntityType<RampagerFireball>> RAMPAGER_FIREBALL =
            ENTITY_TYPES.register("rampager_fireball",
                    () -> EntityType.Builder.<RampagerFireball>of(RampagerFireball::new, MobCategory.MISC)
                            .sized(1.5f, 1.5f)
                            .build(("rampager_fireball")));

    public static final RegistryObject<EntityType<VengefulHeartOfEnder>> VENGEFUL_HEART_OF_ENDER =
            ENTITY_TYPES.register("vengeful_heart_of_ender",
                    () -> EntityType.Builder.of(VengefulHeartOfEnder::new, MobCategory.MONSTER)
                            .sized(5f, 5f)
                            .fireImmune()
                            .build(("vengeful_heart_of_ender")));

    public static final RegistryObject<EntityType<OrbMagic>> ORB_MAGIC =
            ENTITY_TYPES.register("orb_magic",
                    () -> EntityType.Builder.<OrbMagic>of(OrbMagic::new, MobCategory.MISC)
                            .sized(1f, 1f)
                            .fireImmune()
                            .build(("orb_magic")));

    public static final RegistryObject<EntityType<VoidSpew>> VOID_SPEW =
            ENTITY_TYPES.register("void_spew",
                    () -> EntityType.Builder.<VoidSpew>of(VoidSpew::new, MobCategory.MISC)
                            .sized(1f, 1f)
                            .fireImmune()
                            .build(("void_spew")));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
