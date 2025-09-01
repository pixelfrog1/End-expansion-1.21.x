package net.pixelfrog.endplus.entity.client.vengeful_heart_of_ender;

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
import net.pixelfrog.endplus.entity.custom.boss.VengefulHeartOfEnder;

public class VengefulHeartOfEnderModel<T extends VengefulHeartOfEnder> extends HierarchicalModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(EndPlus.MOD_ID, "vengeful_heart_of_ender"), "main");
    private final ModelPart root1;
    private final ModelPart head;

    public VengefulHeartOfEnderModel(ModelPart root) {
        this.root1 = root.getChild("root");
        this.head = root1.getChild("body").getChild("neck").getChild("neck5").getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, -7.0F, 0.0F));

        PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create(), PartPose.offset(0.0F, -16.0F, -47.0F));

        PartDefinition neck1 = neck.addOrReplaceChild("neck1", CubeListBuilder.create().texOffs(128, 0).addBox(-6.0F, -8.0F, -6.0F, 12.0F, 8.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(132, 85).addBox(-4.0F, 0.0F, -5.0F, 9.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));

        PartDefinition neck2 = neck.addOrReplaceChild("neck2", CubeListBuilder.create().texOffs(62, 104).addBox(-7.0F, -12.0F, -6.0F, 14.0F, 12.0F, 13.0F, new CubeDeformation(0.0F))
                .texOffs(88, 136).addBox(-4.0F, 0.0F, -4.0F, 9.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.0F, -1.0F));

        PartDefinition neck3 = neck.addOrReplaceChild("neck3", CubeListBuilder.create().texOffs(0, 96).addBox(-9.0F, -7.0F, -6.0F, 18.0F, 6.0F, 13.0F, new CubeDeformation(0.0F))
                .texOffs(124, 136).addBox(-4.0F, -1.0F, -4.0F, 9.0F, 4.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(0, 115).addBox(-9.0F, -13.0F, -6.0F, 15.0F, 6.0F, 13.0F, new CubeDeformation(0.0F))
                .texOffs(0, 158).addBox(5.0F, -13.0F, -2.0F, 4.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -22.0F, -1.0F));

        PartDefinition neck4 = neck.addOrReplaceChild("neck4", CubeListBuilder.create().texOffs(116, 104).addBox(-8.0F, -7.0F, -5.0F, 16.0F, 7.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(88, 149).addBox(-4.0F, 0.0F, -4.0F, 9.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -36.0F, -1.0F));

        PartDefinition neck5 = neck.addOrReplaceChild("neck5", CubeListBuilder.create(), PartPose.offset(0.0F, -45.0F, -1.0F));

        PartDefinition base = neck5.addOrReplaceChild("base", CubeListBuilder.create().texOffs(64, 153).addBox(-8.0F, -21.0F, -54.0F, 0.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(116, 123).addBox(-8.0F, -18.0F, -54.0F, 16.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(124, 149).addBox(-4.0F, -17.0F, -52.0F, 9.0F, 4.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(160, 37).addBox(8.0F, -21.0F, -54.0F, 0.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(132, 101).addBox(-8.0F, -21.0F, -42.0F, 16.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 18.0F, 48.0F));

        PartDefinition head = neck5.addOrReplaceChild("head", CubeListBuilder.create().texOffs(128, 19).addBox(-6.0F, -9.0F, -4.0F, 12.0F, 10.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(64, 64).addBox(-17.0F, -19.0F, -4.0F, 34.0F, 20.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(64, 84).addBox(-17.0F, -19.0F, 4.0F, 34.0F, 20.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(132, 98).addBox(-8.0F, -2.0F, -7.0F, 16.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 1.0F));

        PartDefinition lower = body.addOrReplaceChild("lower", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition legs = lower.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition leg1 = legs.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(128, 37).addBox(-16.0F, -10.0F, -52.0F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition leg2 = legs.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(56, 129).addBox(-14.0F, -10.0F, -52.0F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(22.0F, 0.0F, 0.0F));

        PartDefinition leg3 = legs.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(132, 61).addBox(-16.0F, -10.0F, -54.0F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 55.0F));

        PartDefinition leg4 = legs.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(0, 134).addBox(-16.0F, -10.0F, -54.0F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(24.0F, 0.0F, 55.0F));

        PartDefinition main = lower.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition body6 = main.addOrReplaceChild("body6", CubeListBuilder.create().texOffs(64, 32).addBox(-8.0F, -16.0F, 8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(32, 153).addBox(-8.0F, -21.0F, 16.0F, 8.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(32, 134).addBox(-14.0F, -15.0F, 20.0F, 6.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition body7 = main.addOrReplaceChild("body7", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -16.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition body8 = main.addOrReplaceChild("body8", CubeListBuilder.create().texOffs(0, 32).addBox(-8.0F, -16.0F, -24.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition body9 = main.addOrReplaceChild("body9", CubeListBuilder.create().texOffs(0, 64).addBox(-8.0F, -16.0F, -40.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition body10 = main.addOrReplaceChild("body10", CubeListBuilder.create().texOffs(64, 0).addBox(-8.0F, -16.0F, -56.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 256, 256);
    }

    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

        this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
    }

    @Override
    public void setupAnim(VengefulHeartOfEnder entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animateWalk(VengefulHeartOfEnderAnimations.HEART_WALK, limbSwing, limbSwingAmount, 1f, 2.5f);
        this.animate(entity.idleAnimationState, VengefulHeartOfEnderAnimations.HEART_IDLE, ageInTicks, 1f);
        this.animate(entity.sprayAnimationState, VengefulHeartOfEnderAnimations.HEART_SPRAY, ageInTicks, 1f);
        this.animate(entity.deathAnimationState, VengefulHeartOfEnderAnimations.HEART_DIE, ageInTicks, 1f);
    }

    @Override
    public ModelPart root() {
        return root1;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        root1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }
}
