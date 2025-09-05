package net.pixelfrog.endplus.entity.client.watchling;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.pixelfrog.endplus.EndPlus;
import net.pixelfrog.endplus.entity.custom.monster.Watchling;

@OnlyIn(Dist.CLIENT)
public class WatchlingRenderer extends MobRenderer<Watchling, WatchlingModel<Watchling>> {
    public WatchlingRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new WatchlingModel<>(pContext.bakeLayer(WatchlingModel.LAYER_LOCATION)), 0.85f);

        this.addLayer(new WatchlingEmissiveLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(Watchling watchlingEntity) {
        return ResourceLocation.fromNamespaceAndPath(EndPlus.MOD_ID, "textures/entity/watchling.png");
    }

    @Override
    public void render(Watchling pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.scale(1f, 1f, 1f);
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
