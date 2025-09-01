
package net.pixelfrog.endplus;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.pixelfrog.endplus.block.ModBlocks;
import net.pixelfrog.endplus.effect.ModEffects;
import net.pixelfrog.endplus.entity.ModEntities;
import net.pixelfrog.endplus.entity.client.blastling.BlastlingRenderer;
import net.pixelfrog.endplus.entity.client.endersent.EndersentRenderer;
import net.pixelfrog.endplus.entity.client.lumen.LumenRenderer;
import net.pixelfrog.endplus.entity.client.rampager.RampagerFireballRenderer;
import net.pixelfrog.endplus.entity.client.rampager.RampagerRenderer;
import net.pixelfrog.endplus.entity.client.snareling.SnarelingGoopRenderer;
import net.pixelfrog.endplus.entity.client.snareling.SnarelingRenderer;
import net.pixelfrog.endplus.entity.client.vengeful_heart_of_ender.OrbMagicRenderer;
import net.pixelfrog.endplus.entity.client.vengeful_heart_of_ender.VengefulHeartOfEnderRenderer;
import net.pixelfrog.endplus.entity.client.vengeful_heart_of_ender.VoidSpewRenderer;
import net.pixelfrog.endplus.entity.client.watchling.WatchlingRenderer;
import net.pixelfrog.endplus.item.ModCreativeModeTabs;
import net.pixelfrog.endplus.item.ModItems;
import net.pixelfrog.endplus.sound.ModSounds;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(EndPlus.MOD_ID)
public class EndPlus {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "endplus";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public EndPlus(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();
        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        ModCreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEntities.register(modEventBus);
        ModSounds.register(modEventBus);
        ModEffects.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.WATCHLING.get(), (EntityRendererProvider.Context pContext) -> new WatchlingRenderer(pContext));
            EntityRenderers.register(ModEntities.ENDERSENT.get(), (EntityRendererProvider.Context pContext) -> new EndersentRenderer(pContext));
            EntityRenderers.register(ModEntities.BLASTLING.get(), (EntityRendererProvider.Context pContext) -> new BlastlingRenderer(pContext));
            EntityRenderers.register(ModEntities.SNARELING.get(), (EntityRendererProvider.Context pContext) -> new SnarelingRenderer(pContext));
            EntityRenderers.register(ModEntities.SNARELING_GOOP.get(), (EntityRendererProvider.Context pContext) -> new SnarelingGoopRenderer(pContext));
            EntityRenderers.register(ModEntities.LUMEN.get(), (EntityRendererProvider.Context pContext) -> new LumenRenderer(pContext));
            EntityRenderers.register(ModEntities.RAMPAGER.get(), (EntityRendererProvider.Context pContext) -> new RampagerRenderer(pContext));
            EntityRenderers.register(ModEntities.RAMPAGER_FIREBALL.get(), (EntityRendererProvider.Context pContext) -> new RampagerFireballRenderer(pContext));
            EntityRenderers.register(ModEntities.VENGEFUL_HEART_OF_ENDER.get(), (EntityRendererProvider.Context pContext) -> new VengefulHeartOfEnderRenderer(pContext));
            EntityRenderers.register(ModEntities.ORB_MAGIC.get(), (EntityRendererProvider.Context pContext) -> new OrbMagicRenderer(pContext));
            EntityRenderers.register(ModEntities.VOID_SPEW.get(), (EntityRendererProvider.Context pContext) -> new VoidSpewRenderer(pContext));
        }
    }
}
