package net.pixelfrog.endplus.entity.client.endersent;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.pixelfrog.endplus.EndPlus;
import net.pixelfrog.endplus.entity.custom.monster.Endersent;

@OnlyIn(Dist.CLIENT)
public class EndersentRenderer extends MobRenderer<Endersent, EndersentModel<Endersent>> {
    public EndersentRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new EndersentModel<>(pContext.bakeLayer(EndersentModel.LAYER_LOCATION)), 0.85f);
        this.addLayer(new EndersentEmissiveLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(Endersent endersentEntity) {
        return ResourceLocation.fromNamespaceAndPath(EndPlus.MOD_ID, "textures/entity/endersent.png");
    }

    @Override
    public void render(Endersent pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.scale(1f, 1f, 1f);
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
