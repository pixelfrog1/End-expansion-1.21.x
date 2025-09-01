package net.pixelfrog.endplus.entity.client.blastling;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.pixelfrog.endplus.EndPlus;
import net.pixelfrog.endplus.entity.custom.monster.Blastling;

@OnlyIn(Dist.CLIENT)
public class BlastlingRenderer extends MobRenderer<Blastling, BlastlingModel<Blastling>> {
    public BlastlingRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new BlastlingModel<>(pContext.bakeLayer(BlastlingModel.LAYER_LOCATION)), 0.85f);
        this.addLayer(new BlastlingEmissiveLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(Blastling pEntity) {
        return ResourceLocation.fromNamespaceAndPath(EndPlus.MOD_ID, "textures/entity/blastling.png");
    }


    @Override
    public void render(Blastling pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.scale(1f, 1f, 1f);
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
