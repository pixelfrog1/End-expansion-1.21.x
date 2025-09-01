package net.pixelfrog.endplus.entity.client.vengeful_heart_of_ender;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;
import net.pixelfrog.endplus.EndPlus;
import net.pixelfrog.endplus.entity.custom.boss.VengefulHeartOfEnder;

public class VengefulHeartOfEnderEmissiveLayer<T extends VengefulHeartOfEnder> extends EyesLayer<VengefulHeartOfEnder, VengefulHeartOfEnderModel<VengefulHeartOfEnder>> {
    public VengefulHeartOfEnderEmissiveLayer(RenderLayerParent<VengefulHeartOfEnder, VengefulHeartOfEnderModel<VengefulHeartOfEnder>> renderLayerParent) {
        super(renderLayerParent);
    }

    @Override
    public RenderType renderType() {
        return RenderType.eyes(ResourceLocation.fromNamespaceAndPath(EndPlus.MOD_ID, "textures/entity/vengeful_heart_of_ender_emissive.png"));
    }
}
