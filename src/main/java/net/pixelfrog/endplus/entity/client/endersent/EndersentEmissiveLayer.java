package net.pixelfrog.endplus.entity.client.endersent;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.pixelfrog.endplus.EndPlus;
import net.pixelfrog.endplus.entity.custom.monster.Endersent;

@OnlyIn(Dist.CLIENT)
public class EndersentEmissiveLayer<T extends Endersent> extends EyesLayer<Endersent, EndersentModel<Endersent>> {
    public EndersentEmissiveLayer(RenderLayerParent<Endersent, EndersentModel<Endersent>> renderLayerParent) {
        super(renderLayerParent);
    }

    private static final RenderType EMISSIVE_LAYER = RenderType.eyes(ResourceLocation.fromNamespaceAndPath(EndPlus.MOD_ID, "textures/entity/endersent_eyes.png"));

    @Override
    public RenderType renderType() {
        return EMISSIVE_LAYER;
    }
}
