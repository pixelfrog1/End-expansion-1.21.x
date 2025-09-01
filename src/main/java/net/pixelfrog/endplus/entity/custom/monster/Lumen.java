package net.pixelfrog.endplus.entity.custom.monster;

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
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.pixelfrog.endplus.entity.custom.boss.VengefulHeartOfEnder;

import java.util.Random;

public class Lumen extends PathfinderMob implements RangedAttackMob {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public Lumen(EntityType<? extends PathfinderMob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 70D)
                .add(Attributes.MOVEMENT_SPEED, 0.3F)
                .add(Attributes.ATTACK_DAMAGE, 5)
                .add(Attributes.STEP_HEIGHT, 3)
                .add(Attributes.FOLLOW_RANGE, 100);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new RangedAttackGoal(this, 2, 15, 100));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0, false));

        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Player.class, false, true));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, VengefulHeartOfEnder.class, false, true));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Endersent.class, false, true));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Watchling.class, false, true));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Blastling.class, false, true));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Snareling.class, false, true));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, EnderMan.class, false, true));
    }

    public void calculateFireballTargetAndShoot(LivingEntity livingentity, double d1, double d2, double d3) {
        double d0 = this.distanceToSqr(livingentity);
        double d4 = Math.sqrt(Math.sqrt(d0)) * 0.5;

        Vec3 vec3 = new Vec3(
                this.getRandom().triangle(d1, 2.297 * d4), d2, this.getRandom().triangle(d3, 2.297 * d4));

        SmallFireball largeFireball = new SmallFireball(this.level(), this, vec3.normalize());
        largeFireball.setPos(largeFireball.getX(), this.getY(0.5) + 0.5, largeFireball.getZ());
        this.level().addFreshEntity(largeFireball);
    }

    @Override
    public void performRangedAttack(LivingEntity pTarget, float pVelocity) {
        this.playSound(SoundEvents.BLAZE_SHOOT, 1.0F, 0.4F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        LivingEntity livingentity = this.getTarget();

        double d0 = this.distanceToSqr(livingentity);
        double d1 = livingentity.getX() - this.getX();
        double d2 = livingentity.getY(0.5) - this.getY(0.5);
        double d3 = livingentity.getZ() - this.getZ();
        double d4 = Math.sqrt(Math.sqrt(d0)) * 0.5;

        Vec3 vec3 = new Vec3(
                this.getRandom().triangle(d1, 2.297 * d4), d2, this.getRandom().triangle(d3, 2.297 * d4)
        );

        Random random = new Random();
        double chance = random.nextDouble();

        if (chance <= 0.2) {
            LargeFireball fireball = new LargeFireball(this.level(), this, vec3.normalize(), 0);
            fireball.setPos(fireball.getX(), this.getY(0.5) + 0.5, fireball.getZ());
            this.level().addFreshEntity(fireball);
        } else {
            SmallFireball fireball = new SmallFireball(this.level(), this, vec3.normalize());
            fireball.setPos(fireball.getX(), this.getY(0.5) + 0.5, fireball.getZ());
            this.level().addFreshEntity(fireball);
        }
    }

    private final ServerBossEvent lumenEvent = new ServerBossEvent(Component.literal("Lumen"),
            BossEvent.BossBarColor.YELLOW, BossEvent.BossBarOverlay.PROGRESS);

    @Override
    public void startSeenByPlayer(ServerPlayer pServerPlayer) {
        super.startSeenByPlayer(pServerPlayer);
        this.lumenEvent.addPlayer(pServerPlayer);
    }

    @Override
    public void stopSeenByPlayer(ServerPlayer pServerPlayer) {
        super.stopSeenByPlayer(pServerPlayer);
        this.lumenEvent.removePlayer(pServerPlayer);
    }

    @Override
    public void aiStep() {
        super.aiStep();
        this.lumenEvent.setProgress(this.getHealth() / this.getMaxHealth());
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

        if (this.level().isClientSide()) {
            this.setupAnimationStates();
        }
    }
}
