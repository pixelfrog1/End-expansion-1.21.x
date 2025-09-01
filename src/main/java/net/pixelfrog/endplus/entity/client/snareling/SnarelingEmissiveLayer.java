package net.pixelfrog.endplus.entity.client.snareling;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.pixelfrog.endplus.EndPlus;
import net.pixelfrog.endplus.entity.custom.monster.Snareling;

@OnlyIn(Dist.CLIENT)
public class SnarelingEmissiveLayer<T extends Snareling> extends EyesLayer<Snareling, SnarelingModel<Snareling>> {
    public SnarelingEmissiveLayer(RenderLayerParent<Snareling, SnarelingModel<Snareling>> renderLayerParent) {
        super(renderLayerParent);
    }

    private static final RenderType EMISSIVE_LAYER = RenderType.eyes(ResourceLocation.fromNamespaceAndPath(EndPlus.MOD_ID, "textures/entity/snareling_emissive.png"));

    @Override
    public RenderType renderType() {
        return EMISSIVE_LAYER;
    }
}
