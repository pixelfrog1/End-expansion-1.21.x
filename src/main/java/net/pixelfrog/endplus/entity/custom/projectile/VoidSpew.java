package net.pixelfrog.endplus.entity.custom.projectile;

import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.pixelfrog.endplus.entity.ModEntities;

import java.util.Random;

public class VoidSpew extends AbstractHurtingProjectile {
    private int lifeTicks = 0;

    public VoidSpew(EntityType<? extends VoidSpew> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public VoidSpew(Level pLevel, LivingEntity pOwner, Vec3 pMovement) {
        super(ModEntities.VOID_SPEW.get(), pOwner, pMovement, pLevel);
    }

    @Override
    protected void onHit(HitResult pResult) {
        super.onHit(pResult);

        if (!this.level().isClientSide) {
            Random random = new Random();

            this.level().explode(this.getOwner(), this.getX(), this.getY(), this.getZ(), 2, false, Level.ExplosionInteraction.MOB);

            this.discard();
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        if (this.level() instanceof ServerLevel serverlevel) {
            Entity entity = pResult.getEntity();

            entity.hurt(this.damageSources().magic(), 10.0F);


            if (random.nextDouble() > 0.5) {

                this.level().explode(this.getOwner(), this.getX(), this.getY(), this.getZ(), 1, false, Level.ExplosionInteraction.MOB);
            }

            this.discard();
        }
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder pBuilder) {

    }

    @Override
    public void tick() {
        super.tick();

        this.applyGravity();
    }

    @Override
    protected double getDefaultGravity() {
        return 0.07;
    }
}