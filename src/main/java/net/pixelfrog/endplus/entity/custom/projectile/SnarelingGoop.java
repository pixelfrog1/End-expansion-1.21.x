package net.pixelfrog.endplus.entity.custom.projectile;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.pixelfrog.endplus.entity.ModEntities;

public class SnarelingGoop extends Projectile {
    public SnarelingGoop(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public SnarelingGoop(Level pLevel, LivingEntity livingEntity) {
        this(ModEntities.SNARELING_GOOP.get(), pLevel);
        this.setOwner(livingEntity);
        this.setPos(
                livingEntity.getX() - (double)(livingEntity.getBbWidth() + 1.0F) * 0.5 * (double) Mth.sin(livingEntity.yBodyRot * (float) (Math.PI / 180.0)),
                livingEntity.getEyeY() - 0.1F,
                livingEntity.getZ() + (double)(livingEntity.getBbWidth() + 1.0F) * 0.5 * (double)Mth.cos(livingEntity.yBodyRot * (float) (Math.PI / 180.0))
        );
    }

    @Override
    protected double getDefaultGravity() {
        return 0.05;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder pBuilder) {

    }

    @Override
    public void tick() {
        super.tick();

        this.level().addParticle(ParticleTypes.SPIT, this.getX(), this.getY(), this.getZ(), 0, 0, 0);

        Vec3 vec3 = this.getDeltaMovement();
        HitResult hitresult = ProjectileUtil.getHitResultOnMoveVector(this, this::canHitEntity);
        if (hitresult.getType() != HitResult.Type.MISS && !net.minecraftforge.event.ForgeEventFactory.onProjectileImpact(this, hitresult))
            this.hitTargetOrDeflectSelf(hitresult);
        double d0 = this.getX() + vec3.x;
        double d1 = this.getY() + vec3.y;
        double d2 = this.getZ() + vec3.z;
        this.updateRotation();
        float f = 0.99F;

        this.setDeltaMovement(vec3.scale(0.99F));
        this.applyGravity();
        this.setPos(d0, d1, d2);
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        if (this.getOwner() instanceof LivingEntity livingentity) {
            Entity entity = pResult.getEntity();
            DamageSource damagesource = this.damageSources().spit(this, livingentity);
            if (entity.hurt(damagesource, 5.0F) && this.level() instanceof ServerLevel serverlevel) {
                EnchantmentHelper.doPostAttackEffects(serverlevel, entity, damagesource);
            }
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        super.onHitBlock(pResult);
        if (!this.level().isClientSide) {
            this.discard();
        }
    }
}
