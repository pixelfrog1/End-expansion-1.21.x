package net.pixelfrog.endplus.entity.client.snareling;

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
import net.pixelfrog.endplus.entity.custom.monster.Snareling;

public class SnarelingModel<T extends Snareling> extends HierarchicalModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(EndPlus.MOD_ID, "snareling"), "main");
    private final ModelPart body;
    private final ModelPart head;

    public SnarelingModel(ModelPart root) {
        this.body = root.getChild("body");
        this.head = this.body.getChild("body2").getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -21.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition body2 = body.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(0, 0).addBox(-5.5F, -7.0F, -4.0F, 11.0F, 14.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));

        PartDefinition head = body2.addOrReplaceChild("head", CubeListBuilder.create().texOffs(42, 1).addBox(-4.5F, -8.0F, -4.0F, 9.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 0.0F));

        PartDefinition leg_l = body2.addOrReplaceChild("leg_l", CubeListBuilder.create().texOffs(16, 55).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 33.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 5.0F, 0.0F));

        PartDefinition leg_r = body2.addOrReplaceChild("leg_r", CubeListBuilder.create().texOffs(24, 55).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 33.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 5.0F, 0.0F));

        PartDefinition sac = body2.addOrReplaceChild("sac", CubeListBuilder.create().texOffs(16, 22).addBox(-5.0F, -6.0F, -6.0F, 10.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -4.0F));

        PartDefinition arm_l = body.addOrReplaceChild("arm_l", CubeListBuilder.create().texOffs(0, 22).addBox(0.0F, -1.0F, 0.0F, 2.0F, 44.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(5.5F, 2.0F, -1.0F));

        PartDefinition hand_l = arm_l.addOrReplaceChild("hand_l", CubeListBuilder.create().texOffs(16, 40).addBox(-1.5F, -1.0F, -13.0F, 2.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 42.0F, 0.0F));

        PartDefinition arm_r = body.addOrReplaceChild("arm_r", CubeListBuilder.create().texOffs(8, 22).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 44.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.5F, 1.0F, 0.0F));

        PartDefinition hand_r = arm_r.addOrReplaceChild("hand_r", CubeListBuilder.create().texOffs(46, 40).addBox(7.0F, -7.0F, -14.0F, 2.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(-9.0F, 49.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

        this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
    }

    @Override
    public void setupAnim(Snareling entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animateWalk(SnarelingAnimations.SNARELING_WALK, limbSwing, limbSwingAmount, 3f, 3f);
        this.animate(entity.idleAnimationState, SnarelingAnimations.SNARELING_IDLE, ageInTicks, 2f);
        this.animate(entity.attackAnimationState, SnarelingAnimations.SNARELING_ATTACK, ageInTicks, 2f);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return body;
    }
}
