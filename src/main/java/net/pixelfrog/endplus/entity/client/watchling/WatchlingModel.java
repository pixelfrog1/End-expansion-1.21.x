package net.pixelfrog.endplus.entity.client.watchling;

// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.pixelfrog.endplus.EndPlus;
import net.pixelfrog.endplus.entity.custom.monster.Watchling;

public class WatchlingModel<T extends Watchling> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(EndPlus.MOD_ID, "watchling"), "main");
    private final ModelPart root;
    private final ModelPart head;

    public WatchlingModel(ModelPart root) {
        this.root = root.getChild("root");
        this.head = this.root.getChild("body").getChild("head");

    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 4.0F, 0.0F));

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -12.0F, -3.0F, 12.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(36, 0).addBox(-5.0F, -8.0F, -4.0F, 10.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, 0.0F));

        PartDefinition l_arm = body.addOrReplaceChild("l_arm", CubeListBuilder.create().texOffs(18, 18).addBox(-4.0F, 0.0F, -2.5F, 4.0F, 29.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, -12.0F, 0.0F));

        PartDefinition r_arm = body.addOrReplaceChild("r_arm", CubeListBuilder.create().texOffs(0, 18).addBox(0.0F, 0.0436F, -2.7386F, 4.0F, 29.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, -12.0F, 0.25F));

        PartDefinition l_leg = body.addOrReplaceChild("l_leg", CubeListBuilder.create().texOffs(36, 38).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 0.0F, 0.0F));

        PartDefinition r_leg = body.addOrReplaceChild("r_leg", CubeListBuilder.create().texOffs(36, 16).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(Watchling entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);

        this.animateWalk(WatchlingAnimations.WATCHLING_WALK_NEW, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.animate(entity.idleAnimationState, WatchlingAnimations.WATCHLING_IDLE_NEW, ageInTicks, 1f);
        this.animate(entity.attackAnimationState, WatchlingAnimations.WATCHLING_ATTACK_NEW, ageInTicks, 1f);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int colour) {
        root.render(poseStack, vertexConsumer, packedLight, packedOverlay, colour);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }
}
