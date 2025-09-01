package net.pixelfrog.endplus.entity.client.lumen;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.pixelfrog.endplus.EndPlus;
import net.pixelfrog.endplus.entity.custom.monster.Lumen;

public class LumenModel<T extends Lumen> extends HierarchicalModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(EndPlus.MOD_ID, "lumen"), "main");
    private final ModelPart root;


    public LumenModel(ModelPart root) {
        this.root = root.getChild("root");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition wind = root.addOrReplaceChild("wind", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition wind1 = wind.addOrReplaceChild("wind1", CubeListBuilder.create().texOffs(0, 2).addBox(-8.0F, -2.0F, -8.0F, 16.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition wind_a_r1 = wind1.addOrReplaceChild("wind_a_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -2.0F, -8.0F, 16.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition wind2 = wind.addOrReplaceChild("wind2", CubeListBuilder.create().texOffs(0, 6).addBox(-8.0F, -2.0F, -8.0F, 16.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition wind_a_r2 = wind2.addOrReplaceChild("wind_a_r2", CubeListBuilder.create().texOffs(0, 4).addBox(-8.0F, -2.0F, -8.0F, 16.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition wind3 = wind.addOrReplaceChild("wind3", CubeListBuilder.create().texOffs(0, 10).addBox(-8.0F, -2.0F, -8.0F, 16.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition wind_a_r3 = wind3.addOrReplaceChild("wind_a_r3", CubeListBuilder.create().texOffs(0, 8).addBox(-8.0F, -2.0F, -8.0F, 16.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition wind4 = wind.addOrReplaceChild("wind4", CubeListBuilder.create().texOffs(0, 14).addBox(-8.0F, -2.0F, -8.0F, 16.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition wind_a_r4 = wind4.addOrReplaceChild("wind_a_r4", CubeListBuilder.create().texOffs(0, 12).addBox(-8.0F, -2.0F, -8.0F, 16.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition wind5 = wind.addOrReplaceChild("wind5", CubeListBuilder.create().texOffs(0, 18).addBox(-8.0F, -2.0F, -8.0F, 16.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -16.0F, 0.0F));

        PartDefinition wind_a_r5 = wind5.addOrReplaceChild("wind_a_r5", CubeListBuilder.create().texOffs(0, 16).addBox(-8.0F, -2.0F, -8.0F, 16.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition wind6 = wind.addOrReplaceChild("wind6", CubeListBuilder.create().texOffs(0, 22).addBox(-8.0F, -2.0F, -8.0F, 16.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -20.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition wind_a_r6 = wind6.addOrReplaceChild("wind_a_r6", CubeListBuilder.create().texOffs(0, 20).addBox(-8.0F, -2.0F, -8.0F, 16.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition wind7 = wind.addOrReplaceChild("wind7", CubeListBuilder.create().texOffs(0, 26).addBox(-8.0F, -2.0F, -8.0F, 16.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition wind_a_r7 = wind7.addOrReplaceChild("wind_a_r7", CubeListBuilder.create().texOffs(0, 24).addBox(-8.0F, -2.0F, -8.0F, 16.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition wind8 = wind.addOrReplaceChild("wind8", CubeListBuilder.create().texOffs(0, 30).addBox(-8.0F, -2.0F, -8.0F, 16.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -28.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition wind_a_r8 = wind8.addOrReplaceChild("wind_a_r8", CubeListBuilder.create().texOffs(0, 28).addBox(-8.0F, -2.0F, -8.0F, 16.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition wind9 = wind.addOrReplaceChild("wind9", CubeListBuilder.create().texOffs(32, 0).addBox(-8.0F, -18.0F, -8.0F, 16.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -32.0F, 0.0F));

        PartDefinition wind_a_r9 = wind9.addOrReplaceChild("wind_a_r9", CubeListBuilder.create().texOffs(0, 32).addBox(-8.0F, -2.0F, -8.0F, 16.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition wind10 = wind.addOrReplaceChild("wind10", CubeListBuilder.create().texOffs(32, 4).addBox(-8.0F, -2.0F, -8.0F, 16.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -36.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition wind_a_r10 = wind10.addOrReplaceChild("wind_a_r10", CubeListBuilder.create().texOffs(32, 2).addBox(-8.0F, -2.0F, -8.0F, 16.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition wind11 = wind.addOrReplaceChild("wind11", CubeListBuilder.create().texOffs(32, 8).addBox(-8.0F, -2.0F, -8.0F, 16.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -40.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition wind_a_r11 = wind11.addOrReplaceChild("wind_a_r11", CubeListBuilder.create().texOffs(32, 6).addBox(-8.0F, -2.0F, -8.0F, 16.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition wind12 = wind.addOrReplaceChild("wind12", CubeListBuilder.create().texOffs(32, 12).addBox(-8.0F, -2.0F, -8.0F, 16.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -44.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition wind_a_r12 = wind12.addOrReplaceChild("wind_a_r12", CubeListBuilder.create().texOffs(32, 10).addBox(-8.0F, -2.0F, -8.0F, 16.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition eyes = root.addOrReplaceChild("eyes", CubeListBuilder.create(), PartPose.offset(0.0F, 3.0F, -2.0F));

        PartDefinition eye1 = eyes.addOrReplaceChild("eye1", CubeListBuilder.create().texOffs(32, 14).addBox(0.5F, -33.0F, -10.0F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition eye2 = eyes.addOrReplaceChild("eye2", CubeListBuilder.create().texOffs(32, 22).addBox(-8.5F, -33.0F, -10.0F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition fire = root.addOrReplaceChild("fire", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition fire1 = fire.addOrReplaceChild("fire1", CubeListBuilder.create().texOffs(32, 30).addBox(-1.0F, -17.0F, -16.0F, 2.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition fire2 = fire.addOrReplaceChild("fire2", CubeListBuilder.create().texOffs(0, 34).addBox(-1.0F, -47.0F, -16.0F, 2.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition fire3 = fire.addOrReplaceChild("fire3", CubeListBuilder.create().texOffs(4, 34).addBox(-1.0F, -17.0F, -16.0F, 2.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition fire4 = fire.addOrReplaceChild("fire4", CubeListBuilder.create().texOffs(8, 34).addBox(-1.0F, -47.0F, -16.0F, 2.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(Lumen entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);

        this.animateWalk(LumenAnimations.LUMEN_SPIN, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.animate(entity.idleAnimationState, LumenAnimations.LUMEN_SPIN, ageInTicks, 1f);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        root.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return root;
    }
}
