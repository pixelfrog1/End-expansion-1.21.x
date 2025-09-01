package net.pixelfrog.endplus.entity.client.rampager;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.pixelfrog.endplus.EndPlus;
import net.pixelfrog.endplus.entity.custom.boss.Rampager;

@OnlyIn(Dist.CLIENT)
public class RampagerRenderer extends MobRenderer<Rampager, RampagerModel<Rampager>> {
    public RampagerRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new RampagerModel<>(pContext.bakeLayer(RampagerModel.LAYER_LOCATION)), 0f);
        this.addLayer(new RampagerEmissiveLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(Rampager rampagerEntity) {
        return ResourceLocation.fromNamespaceAndPath(EndPlus.MOD_ID, "textures/entity/rampager.png");
    }

    @Override
    public void render(Rampager pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.scale(1f, 1f, 1f);
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
