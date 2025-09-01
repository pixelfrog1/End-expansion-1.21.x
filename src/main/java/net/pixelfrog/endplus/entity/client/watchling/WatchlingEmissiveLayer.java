package net.pixelfrog.endplus.entity.client.watchling;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.pixelfrog.endplus.EndPlus;
import net.pixelfrog.endplus.entity.custom.monster.Watchling;

@OnlyIn(Dist.CLIENT)
public class WatchlingEmissiveLayer<T extends Watchling> extends EyesLayer<Watchling, WatchlingModel<Watchling>> {
    public WatchlingEmissiveLayer(RenderLayerParent<Watchling, WatchlingModel<Watchling>> renderLayerParent) {
        super(renderLayerParent);
    }

    @Override
    public RenderType renderType() {
        return RenderType.eyes(ResourceLocation.fromNamespaceAndPath(EndPlus.MOD_ID, "textures/entity/watchling_eyes.png"));
    }
}
