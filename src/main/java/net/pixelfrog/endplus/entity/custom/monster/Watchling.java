package net.pixelfrog.endplus.entity.custom.monster;

import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.pixelfrog.endplus.entity.ai.goal.CustomTeleportGoal;

public class Watchling extends Monster {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public final AnimationState attackAnimationState = new AnimationState();
    private boolean attacking = false;
    private boolean canTeleport = false;

    public Watchling(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0, false));
        this.goalSelector.addGoal(1, new CustomTeleportGoal(this, this.canTeleport));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 0.2));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 50));

        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, Player.class, true, true));
        this.targetSelector.addGoal(8, new NearestAttackableTargetGoal<>(this, Lumen.class, false, false));
        this.targetSelector.addGoal(9, new NearestAttackableTargetGoal<>(this, ArmorStand.class, false, false));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 30D)
                .add(Attributes.MOVEMENT_SPEED, 0.2F)
                .add(Attributes.ATTACK_DAMAGE, 7);
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 20;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide() && !this.attacking) {
            this.setupAnimationStates();
        }

        // this.canTeleport = new Random().nextInt(0, 10) == 0;

        this.canTeleport = true;
    }

    @Override
    public void startSeenByPlayer(ServerPlayer pServerPlayer) {
        super.startSeenByPlayer(pServerPlayer);
    }

    @Override
    public void stopSeenByPlayer(ServerPlayer pServerPlayer) {
        super.stopSeenByPlayer(pServerPlayer);
    }

    @Override
    public void aiStep() {
        super.aiStep();
    }

    private boolean hurtWithCleanWater(DamageSource pSource, ThrownPotion pPotion, float pAmount) {
        ItemStack itemstack = pPotion.getItem();
        PotionContents potioncontents = itemstack.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY);
        return potioncontents.is(Potions.WATER) && super.hurt(pSource, pAmount);
    }

    private class WatchlingAttackGoal extends MeleeAttackGoal {
        private final Watchling mob;

        public WatchlingAttackGoal(Watchling mob, double speedModifier, boolean followingTargetEvenIfNotSeen) {
            super(mob, speedModifier, followingTargetEvenIfNotSeen);

            this.mob = mob;
        }

        @Override
        public void start() {
            super.start();

            this.mob.attacking = true;

            this.mob.idleAnimationState.stop();
            this.mob.attackAnimationState.start(this.mob.tickCount);
        }

        @Override
        public void stop() {
            super.stop();

            this.mob.attacking = false;
        }

        @Override
        protected boolean isTimeToAttack() {
            return this.getTicksUntilNextAttack() >= 10;
        }
    }
}
