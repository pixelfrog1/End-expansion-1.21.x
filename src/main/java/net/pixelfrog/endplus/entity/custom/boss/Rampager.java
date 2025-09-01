package net.pixelfrog.endplus.entity.custom.boss;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.BossEvent;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.pixelfrog.endplus.entity.ModEntities;
import net.pixelfrog.endplus.entity.custom.monster.*;
import net.pixelfrog.endplus.entity.custom.projectile.RampagerFireball;

import java.util.Random;

public class Rampager extends PathfinderMob implements RangedAttackMob {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public Rampager(EntityType<? extends PathfinderMob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 300D)
                .add(Attributes.MOVEMENT_SPEED, 0.4F)
                .add(Attributes.ATTACK_DAMAGE, 7)
                .add(Attributes.STEP_HEIGHT, 3)
                .add(Attributes.FOLLOW_RANGE, 150);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new RangedAttackGoal(this, 20, 10, 150));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 0.6, false));

        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Player.class, false, true));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, VengefulHeartOfEnder.class, false, true));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Endersent.class, false, true));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Watchling.class, false, true));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Blastling.class, false, true));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Snareling.class, false, true));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, EnderMan.class, false, true));
    }

    @Override
    public void performRangedAttack(LivingEntity pTarget, float pVelocity) {
        this.playSound(SoundEvents.BLAZE_SHOOT, 1.0F, 1F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        LivingEntity livingentity = this.getTarget();

        double d0 = this.distanceToSqr(livingentity);
        double d1 = livingentity.getX() - this.getX();
        double d3 = livingentity.getZ() - this.getZ();
        double d4 = Math.sqrt(Math.sqrt(d0)) * 0.5;

        double distanceFactor = Math.sqrt((d1 * d1) * (d3 * d3));

        double d2 = livingentity.getY(0.3333333333333333) - this.getY(0.5);

        Vec3 vec3 = new Vec3(
                this.getRandom().triangle(d1, 2.297 * d4), d2 + distanceFactor, this.getRandom().triangle(d3, 2.297 * d4)
        );

        RampagerFireball fireball = new RampagerFireball(this.level(), this, vec3.normalize());
        fireball.setPos(fireball.getX(), this.getY(0.5), fireball.getZ());
        this.level().addFreshEntity(fireball);
    }

    private final ServerBossEvent rampagerEvent = new ServerBossEvent(Component.literal("Rampager"),
            BossEvent.BossBarColor.RED, BossEvent.BossBarOverlay.NOTCHED_10);

    @Override
    public void startSeenByPlayer(ServerPlayer pServerPlayer) {
        super.startSeenByPlayer(pServerPlayer);
        this.rampagerEvent.addPlayer(pServerPlayer);
    }

    @Override
    public void stopSeenByPlayer(ServerPlayer pServerPlayer) {
        super.stopSeenByPlayer(pServerPlayer);
        this.rampagerEvent.removePlayer(pServerPlayer);
    }

    @Override
    public void aiStep() {
        super.aiStep();
        this.rampagerEvent.setProgress(this.getHealth() / this.getMaxHealth());
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 40;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
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

        if (this.level().isClientSide()) {
            this.setupAnimationStates();
        }

        random = new Random();
        chance = random.nextDouble();

        float healthPercent = this.getHealth() / this.getMaxHealth();

        if (healthPercent < 0.5) {
            if (chance <= 0.0005) {
                Lumen lumenEntity = new Lumen(ModEntities.LUMEN.get(), this.level());
                lumenEntity.moveTo(this.getX(), this.getY(), this.getZ());
                this.level().addFreshEntity(lumenEntity);
            }
        }
    }
}
