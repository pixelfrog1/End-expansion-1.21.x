package net.pixelfrog.endplus.entity.client.vengeful_heart_of_ender;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.pixelfrog.endplus.EndPlus;
import net.pixelfrog.endplus.entity.custom.projectile.VoidSpew;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class VoidSpewRenderer extends EntityRenderer<VoidSpew> {
    private final VoidSpewModel<VoidSpew> model;

    public VoidSpewRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new VoidSpewModel<>(pContext.bakeLayer(VoidSpewModel.LAYER_LOCATION));
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull VoidSpew pEntity) {
        return ResourceLocation.fromNamespaceAndPath(EndPlus.MOD_ID, "textures/entity/orb_magic.png");
    }

        public void render(VoidSpew pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.pushPose();
        pPoseStack.translate(0.0F, 0.15F, 0.0F);
        pPoseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.yRotO, pEntity.getYRot()) - 90.0F));
        pPoseStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.xRotO, pEntity.getXRot())));
        this.model.setupAnim(pEntity, pPartialTicks, 0.0F, -0.1F, 0.0F, 0.0F);
        VertexConsumer vertexconsumer = pBuffer.getBuffer(this.model.renderType(ResourceLocation.fromNamespaceAndPath(EndPlus.MOD_ID, "textures/entity/orb_magic.png")));
        this.model.renderToBuffer(pPoseStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY);
        pPoseStack.popPose();
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
