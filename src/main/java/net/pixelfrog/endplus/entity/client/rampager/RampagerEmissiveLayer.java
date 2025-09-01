package net.pixelfrog.endplus.entity.client.rampager;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.pixelfrog.endplus.EndPlus;
import net.pixelfrog.endplus.entity.custom.boss.Rampager;

@OnlyIn(Dist.CLIENT)
public class RampagerEmissiveLayer<T extends Rampager> extends EyesLayer<Rampager, RampagerModel<Rampager>> {
    public RampagerEmissiveLayer(RenderLayerParent<Rampager, RampagerModel<Rampager>> renderLayerParent) {
        super(renderLayerParent);
    }

    private static final RenderType EMISSIVE_LAYER = RenderType.eyes(ResourceLocation.fromNamespaceAndPath(EndPlus.MOD_ID, "textures/entity/rampager.png"));

    @Override
    public RenderType renderType() {
        return EMISSIVE_LAYER;
    }
}
