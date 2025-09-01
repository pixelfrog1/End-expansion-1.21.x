package net.pixelfrog.endplus.entity.custom.monster;

import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.pixelfrog.endplus.entity.custom.boss.Rampager;
import net.pixelfrog.endplus.entity.custom.projectile.SnarelingGoop;

import static java.lang.Math.sqrt;

public class Snareling extends Monster {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public final AnimationState attackAnimationState = new AnimationState();
    private int attackAnimationTimeout = 0;

    private boolean isShooting = false;

    public Snareling(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 20D)
                .add(Attributes.MOVEMENT_SPEED, 0F)
                .add(Attributes.ATTACK_DAMAGE, 5)
                .add(Attributes.FOLLOW_RANGE, 30);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 0, false));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 0f));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 50));

        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, Player.class, true, true));
        this.targetSelector.addGoal(8, new NearestAttackableTargetGoal<>(this, Lumen.class, false, false));
        this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, Rampager.class, false, false));
    }

    public void performRangedAttack(LivingEntity pTarget, float pVelocity) {
        SnarelingGoop snarelingGoop = new SnarelingGoop(this.level(), this);

        double d0 = pTarget.getX() - this.getX();
        double d1 = pTarget.getY(0.3333333333333333) - snarelingGoop.getY();
        double d2 = pTarget.getZ() - this.getZ();
        double d3 = sqrt(d0 * d0 + d2 * d2) * 0.2F;

        snarelingGoop.shoot(d0, (d1 + d3) * 2, d2, pVelocity, 10.0F);
        this.level().addFreshEntity(snarelingGoop);
    }

    public void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 10;
            this.attackAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }

        if (this.getTarget() != null && this.isWithinMeleeAttackRange(this.getTarget())) {
            if (this.attackAnimationTimeout <= 0) {
                this.attackAnimationTimeout = 10;
                this.attackAnimationState.start(this.tickCount);
            } else {
                --this.attackAnimationTimeout;
            }
        } else {
            this.attackAnimationState.stop();
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) {
            this.setupAnimationStates();
        }
    }
}
