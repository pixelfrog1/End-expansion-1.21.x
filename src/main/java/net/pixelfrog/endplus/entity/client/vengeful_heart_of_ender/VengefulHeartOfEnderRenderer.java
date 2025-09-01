package net.pixelfrog.endplus.entity.client.vengeful_heart_of_ender;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.pixelfrog.endplus.EndPlus;
import net.pixelfrog.endplus.entity.custom.boss.VengefulHeartOfEnder;

@OnlyIn(Dist.CLIENT)
public class VengefulHeartOfEnderRenderer extends MobRenderer<VengefulHeartOfEnder, VengefulHeartOfEnderModel<VengefulHeartOfEnder>> {
    public VengefulHeartOfEnderRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new VengefulHeartOfEnderModel<>(pContext.bakeLayer(VengefulHeartOfEnderModel.LAYER_LOCATION)), 4f);
        this.addLayer(new VengefulHeartOfEnderEmissiveLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(VengefulHeartOfEnder vengefulHeartOfEnderEntity) {
        return ResourceLocation.fromNamespaceAndPath(EndPlus.MOD_ID, "textures/entity/vengeful_heart_of_ender.png");
    }

    @Override
    public void render(VengefulHeartOfEnder pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.scale(1f, 1f, 1f);
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
