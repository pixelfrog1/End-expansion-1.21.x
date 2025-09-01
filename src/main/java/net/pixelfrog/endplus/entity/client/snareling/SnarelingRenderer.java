package net.pixelfrog.endplus.entity.client.snareling;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.pixelfrog.endplus.EndPlus;
import net.pixelfrog.endplus.entity.custom.monster.Snareling;

@OnlyIn(Dist.CLIENT)
public class SnarelingRenderer extends MobRenderer<Snareling, SnarelingModel<Snareling>> {
    public SnarelingRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new SnarelingModel<>(pContext.bakeLayer(SnarelingModel.LAYER_LOCATION)), 0.85f);
        this.addLayer(new SnarelingEmissiveLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(Snareling snarelingEntity) {
        return ResourceLocation.fromNamespaceAndPath(EndPlus.MOD_ID, "textures/entity/snareling.png");
    }

    @Override
    public void render(Snareling snarelingEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.scale(1f, 1f, 1f);
        super.render(snarelingEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
