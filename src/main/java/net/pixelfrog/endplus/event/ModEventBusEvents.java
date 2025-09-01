package net.pixelfrog.endplus.event;

import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.pixelfrog.endplus.EndPlus;
import net.pixelfrog.endplus.entity.ModEntities;
import net.pixelfrog.endplus.entity.client.blastling.BlastlingModel;
import net.pixelfrog.endplus.entity.client.endersent.EndersentModel;
import net.pixelfrog.endplus.entity.client.lumen.LumenModel;
import net.pixelfrog.endplus.entity.client.rampager.RampagerFireballModel;
import net.pixelfrog.endplus.entity.client.rampager.RampagerModel;
import net.pixelfrog.endplus.entity.client.snareling.SnarelingGoopModel;
import net.pixelfrog.endplus.entity.client.snareling.SnarelingModel;
import net.pixelfrog.endplus.entity.client.vengeful_heart_of_ender.OrbMagicModel;
import net.pixelfrog.endplus.entity.client.vengeful_heart_of_ender.VengefulHeartOfEnderModel;
import net.pixelfrog.endplus.entity.client.vengeful_heart_of_ender.VoidSpewModel;
import net.pixelfrog.endplus.entity.client.watchling.WatchlingModel;
import net.pixelfrog.endplus.entity.custom.boss.VengefulHeartOfEnder;
import net.pixelfrog.endplus.entity.custom.boss.Rampager;
import net.pixelfrog.endplus.entity.custom.monster.*;

@Mod.EventBusSubscriber(modid = EndPlus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(WatchlingModel.LAYER_LOCATION, WatchlingModel::createBodyLayer);
        event.registerLayerDefinition(EndersentModel.LAYER_LOCATION, EndersentModel::createBodyLayer);
        event.registerLayerDefinition(BlastlingModel.LAYER_LOCATION, BlastlingModel::createBodyLayer);
        event.registerLayerDefinition(SnarelingModel.LAYER_LOCATION, SnarelingModel::createBodyLayer);
        event.registerLayerDefinition(SnarelingGoopModel.LAYER_LOCATION, SnarelingGoopModel::createBodyLayer);
        event.registerLayerDefinition(LumenModel.LAYER_LOCATION, LumenModel::createBodyLayer);
        event.registerLayerDefinition(RampagerModel.LAYER_LOCATION, RampagerModel::createBodyLayer);
        event.registerLayerDefinition(RampagerFireballModel.LAYER_LOCATION, RampagerFireballModel::createBodyLayer);
        event.registerLayerDefinition(VengefulHeartOfEnderModel.LAYER_LOCATION, VengefulHeartOfEnderModel::createBodyLayer);
        event.registerLayerDefinition(OrbMagicModel.LAYER_LOCATION, OrbMagicModel::createBodyLayer);
        event.registerLayerDefinition(VoidSpewModel.LAYER_LOCATION, VoidSpewModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.WATCHLING.get(), Watchling.createAttributes().build());
        event.put(ModEntities.ENDERSENT.get(), Endersent.createAttributes().build());
        event.put(ModEntities.BLASTLING.get(), Blastling.createAttributes().build());
        event.put(ModEntities.SNARELING.get(), Snareling.createAttributes().build());
        event.put(ModEntities.LUMEN.get(), Lumen.createAttributes().build());
        event.put(ModEntities.RAMPAGER.get(), Rampager.createAttributes().build());
        event.put(ModEntities.VENGEFUL_HEART_OF_ENDER.get(), VengefulHeartOfEnder.createAttributes().build());
    }
}
