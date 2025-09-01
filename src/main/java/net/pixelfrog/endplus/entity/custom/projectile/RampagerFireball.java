package net.pixelfrog.endplus.entity.custom.projectile;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.pixelfrog.endplus.entity.ModEntities;

import java.util.Random;

public class RampagerFireball extends AbstractHurtingProjectile {
    private static final EntityDataAccessor<Boolean> DATA_DANGEROUS = SynchedEntityData.defineId(RampagerFireball.class, EntityDataSerializers.BOOLEAN);

    public RampagerFireball(EntityType<? extends RampagerFireball> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public RampagerFireball(Level pLevel, LivingEntity pOwner, Vec3 pMovement) {
        super(ModEntities.RAMPAGER_FIREBALL.get(), pOwner, pMovement, pLevel);
    }


    @Override
    protected float getInertia() {
        return this.isDangerous() ? 0.73F : super.getInertia();
    }

    @Override
    public boolean isOnFire() {
        return false;
    }

    @Override
    public float getBlockExplosionResistance(Explosion pExplosion, BlockGetter pLevel, BlockPos pPos, BlockState pBlockState, FluidState pFluidState, float pExplosionPower) {
        return this.isDangerous() && pBlockState.canEntityDestroy(pLevel, pPos, this) ? Math.min(0.8F, pExplosionPower) : pExplosionPower;
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        if (this.level() instanceof ServerLevel serverlevel) {
            Entity entity = pResult.getEntity();
            boolean flag;
            if (this.getOwner() instanceof LivingEntity livingentity) {
                DamageSource damagesource = this.damageSources().mobProjectile(this, livingentity);
                flag = entity.hurt(damagesource, 10.0F);
            } else {
                flag = entity.hurt(this.damageSources().magic(), 10.0F);
            }
            int fireTicks = entity.getRemainingFireTicks();
            entity.setRemainingFireTicks(fireTicks);


            if (flag && entity instanceof LivingEntity livingentity1) {
                int i = 0;
                if (this.level().getDifficulty() == Difficulty.NORMAL) {
                    i = 10;
                } else if (this.level().getDifficulty() == Difficulty.HARD) {
                    i = 40;
                }
            }
        }
    }

    @Override
    protected void onHit(HitResult pResult) {
        super.onHit(pResult);
        if (!this.level().isClientSide) {
            this.level().explode(this.getOwner(), this.getX(), this.getY(), this.getZ(), 1, true, Level.ExplosionInteraction.MOB);
            this.discard();
        }
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        return false;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder pBuilder) {
        pBuilder.define(DATA_DANGEROUS, false);
    }

    public boolean isDangerous() {
        return this.entityData.get(DATA_DANGEROUS);
    }

    public void setDangerous(boolean pInvulnerable) {
        this.entityData.set(DATA_DANGEROUS, pInvulnerable);
    }

    @Override
    protected boolean shouldBurn() {
        return true;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putBoolean("dangerous", this.isDangerous());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.setDangerous(pCompound.getBoolean("dangerous"));
    }

    @Override
    public void tick() {
        super.tick();

        Random random = new Random();
        double chance = random.nextDouble();

        this.level().addParticle(ParticleTypes.LAVA, this.getX() + (chance - 0.5) * 2, this.getY() + chance, this.getZ() + (chance - 0.5) * 2, 0, 0, 0);
        this.level().addParticle(ParticleTypes.SMOKE, this.getX() + (chance - 0.5) * 2, this.getY() + chance * 5, this.getZ() + (  chance - 0.5) * 2, 0, 0, 0);
        this.level().addParticle(ParticleTypes.TRIAL_SPAWNER_DETECTED_PLAYER, this.getX() + (chance - 0.5) * 2, this.getY() + chance * 5, this.getZ() + (  chance - 0.5) * 2, 0, 0, 0);

        random = new Random();
        chance = random.nextDouble();

        this.level().addParticle(ParticleTypes.LAVA, this.getX() + (chance - 0.5) * 2, this.getY() + chance, this.getZ() + (chance - 0.5) * 2, 0, 0, 0);
        this.level().addParticle(ParticleTypes.SMOKE, this.getX() + (chance - 0.5) * 2, this.getY() + chance * 5, this.getZ() + (  chance - 0.5) * 2, 0, 0, 0);
        this.level().addParticle(ParticleTypes.TRIAL_SPAWNER_DETECTED_PLAYER, this.getX() + (chance - 0.5) * 2, this.getY() + chance * 5, this.getZ() + (  chance - 0.5) * 2, 0, 0, 0);

        this.applyGravity();
    }

    @Override
    protected double getDefaultGravity() {
        return 0.05;
    }
}
