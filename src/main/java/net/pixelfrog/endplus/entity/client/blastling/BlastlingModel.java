package net.pixelfrog.endplus.entity.client.blastling;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.pixelfrog.endplus.EndPlus;
import net.pixelfrog.endplus.entity.custom.monster.Blastling;

public class BlastlingModel<T extends Blastling> extends HierarchicalModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(EndPlus.MOD_ID, "blastling"), "main");
    private final ModelPart body;
    private final ModelPart head;

    public BlastlingModel(ModelPart root) {
        this.body = root.getChild("body");
        this.head = body.getChild("body2").getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 4.0F, 0.0F));

        PartDefinition body2 = body.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -16.0F, -3.0F, 14.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition head = body2.addOrReplaceChild("head", CubeListBuilder.create().texOffs(40, 0).addBox(-4.0F, -12.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, 0.0F));

        PartDefinition fire = head.addOrReplaceChild("fire", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition fire4_r1 = fire.addOrReplaceChild("fire4_r1", CubeListBuilder.create().texOffs(56, 28).addBox(-5.0F, -6.0F, -5.0F, 10.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));

        PartDefinition fire3_r1 = fire.addOrReplaceChild("fire3_r1", CubeListBuilder.create().texOffs(56, 16).addBox(-5.0F, -6.0F, -5.0F, 10.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition fire2_r1 = fire.addOrReplaceChild("fire2_r1", CubeListBuilder.create().texOffs(20, 54).addBox(-5.0F, -6.0F, -5.0F, 10.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition l_arm = body2.addOrReplaceChild("l_arm", CubeListBuilder.create().texOffs(24, 19).addBox(-7.0F, -4.0F, -3.0F, 6.0F, 29.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, -12.0F, 0.0F));

        PartDefinition r_arm = body2.addOrReplaceChild("r_arm", CubeListBuilder.create().texOffs(0, 19).addBox(1.0F, -4.0F, -3.2386F, 6.0F, 29.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, -12.0F, 0.25F));

        PartDefinition l_leg = body2.addOrReplaceChild("l_leg", CubeListBuilder.create().texOffs(48, 41).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 23.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 0.0F, 0.0F));

        PartDefinition r_leg = body2.addOrReplaceChild("r_leg", CubeListBuilder.create().texOffs(48, 16).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 23.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

        this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return body;
    }

    @Override
    public void setupAnim(Blastling entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animateWalk(BlastlingAnimations.BLASTLING_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.animate(entity.idleAnimationState, BlastlingAnimations.BLASTLING_IDLE, ageInTicks, 1f);
        this.animate(entity.attackAnimationState, BlastlingAnimations.BLASTLING_SHOOT, ageInTicks, 1f);
    }
}
