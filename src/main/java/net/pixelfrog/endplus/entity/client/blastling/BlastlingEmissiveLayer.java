package net.pixelfrog.endplus.entity.client.blastling;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.pixelfrog.endplus.EndPlus;
import net.pixelfrog.endplus.entity.custom.monster.Blastling;

@OnlyIn(Dist.CLIENT)
public class BlastlingEmissiveLayer<T extends Blastling> extends EyesLayer<Blastling, BlastlingModel<Blastling>> {
    public BlastlingEmissiveLayer(RenderLayerParent<Blastling, BlastlingModel<Blastling>> renderLayerParent) {
        super(renderLayerParent);
    }

    private static final RenderType EMISSIVE_LAYER = RenderType.eyes(ResourceLocation.fromNamespaceAndPath(EndPlus.MOD_ID, "textures/entity/blastling_emissive.png"));

    @Override
    public RenderType renderType() {
        return EMISSIVE_LAYER;
    }
}
