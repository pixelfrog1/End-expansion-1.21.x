package net.pixelfrog.endplus.entity.client.lumen;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.pixelfrog.endplus.EndPlus;
import net.pixelfrog.endplus.entity.custom.monster.Lumen;

@OnlyIn(Dist.CLIENT)
public class LumenRenderer extends MobRenderer<Lumen,LumenModel<Lumen>> {
    public LumenRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new LumenModel<>(pContext.bakeLayer(LumenModel.LAYER_LOCATION)), 0f);
        this.addLayer(new LumenEmissiveLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(Lumen lumenEntity) {
        return ResourceLocation.fromNamespaceAndPath(EndPlus.MOD_ID, "textures/entity/lumen.png");
    }

    @Override
    public void render(Lumen pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.scale(1f, 1f, 1f);
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
