package net.pixelfrog.endplus.entity.client.lumen;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.pixelfrog.endplus.EndPlus;
import net.pixelfrog.endplus.entity.custom.monster.Lumen;

@OnlyIn(Dist.CLIENT)
public class LumenEmissiveLayer<T extends Lumen> extends EyesLayer<Lumen,LumenModel<Lumen>> {
    public LumenEmissiveLayer(RenderLayerParent<Lumen, LumenModel<Lumen>> renderLayerParent) {
        super(renderLayerParent);
    }

    private static final RenderType EMISSIVE_LAYER = RenderType.eyes(ResourceLocation.fromNamespaceAndPath(EndPlus.MOD_ID, "textures/entity/lumen.png"));

    @Override
    public RenderType renderType() {
        return EMISSIVE_LAYER;
    }
}
