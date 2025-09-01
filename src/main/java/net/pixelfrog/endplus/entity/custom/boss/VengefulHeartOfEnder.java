package net.pixelfrog.endplus.entity.custom.boss;

import net.minecraft.client.Minecraft;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.pixelfrog.endplus.entity.custom.monster.Lumen;
import net.pixelfrog.endplus.entity.custom.projectile.VoidSpew;
import net.pixelfrog.endplus.sound.ModSounds;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class VengefulHeartOfEnder extends Monster {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public final AnimationState sprayAnimationState = new AnimationState();
    public final AnimationState deathAnimationState = new AnimationState();
    private int soundTicks = 2700;
    public boolean isOnSurface = true;
    private int attack = 0;

    public VengefulHeartOfEnder(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 700D)
                .add(Attributes.MOVEMENT_SPEED, 0.2F)
                .add(Attributes.ATTACK_DAMAGE, 20)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0)
                .add(Attributes.ATTACK_KNOCKBACK, 25)
                .add(Attributes.STEP_HEIGHT, 1.5)
                .add(Attributes.FOLLOW_RANGE, 200);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(2, new VoidSpewGoal(this));
        this.goalSelector.addGoal(1, new ChargeGoal(this));

        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, Player.class, false));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Lumen.class, false));

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

        if (this.level().isClientSide()) {
            this.setupAnimationStates();
        }

        this.soundTicks++;
        if (this.soundTicks >= 2700) {
            this.soundTicks = 0;
            Musics.
        }

        Endermite endermite = new Endermite(EntityType.ENDERMITE, this.level());
        endermite.moveTo(this.getX(), this.getY(), this.getZ());

        Random random = new Random();
        double chance = (random.nextDouble() * 10) + 1;

        if (chance <= 0.05) {
            this.level().addFreshEntity(endermite);
        }

        if (this.getTarget() != null) {
            if (this.getAttackBoundingBox().intersects(this.getTarget().getBoundingBox())) {
                this.doHurtTarget(this.getTarget());
            }
        }
    }

    private final ServerBossEvent vengefulHeartOfEnderEvent = new ServerBossEvent(Component.literal("§5Vengeful Heart Of Ender§r"),
            BossEvent.BossBarColor.PURPLE, BossEvent.BossBarOverlay.NOTCHED_12);


    @Override
    public void startSeenByPlayer(@NotNull ServerPlayer pServerPlayer) {
        super.startSeenByPlayer(pServerPlayer);
        this.vengefulHeartOfEnderEvent.addPlayer(pServerPlayer);
    }

    @Override
    public void stopSeenByPlayer(@NotNull ServerPlayer pServerPlayer) {
        super.stopSeenByPlayer(pServerPlayer);
        this.vengefulHeartOfEnderEvent.removePlayer(pServerPlayer);
    }

    @Override
    public void aiStep() {
        super.aiStep();
        this.vengefulHeartOfEnderEvent.setProgress(this.getHealth() / this.getMaxHealth());
    }

    @Override
    public boolean isPersistenceRequired() {
        return super.isPersistenceRequired();
    }

    /** Well, well, well...
     *  Look what we have here...
     *  I don't know if you can tell, but
     *  this is the code for a boss mob.
     *  Yeah, I know. Not as much as you thought, huh.
     */

    @Override
    public void die(@NotNull DamageSource pDamageSource) {
        super.die(pDamageSource);

        Minecraft.getInstance().getSoundManager().stop();
        ;

        this.idleAnimationState.stop();
        this.deathAnimationState.start(this.tickCount);
    }

    public void spawnParticles(ParticleOptions particleOptions, float randomness) {
        Random random = new Random();
        double chance = random.nextDouble();

        double randX = this.getX() + ((chance + 1) * randomness);

        random = new Random();
        chance = random.nextDouble();

        double randY = this.getY() + ((chance + 1) * randomness);

        random = new Random();
        chance = random.nextDouble();

        double randZ = this.getZ() + ((chance + 1) * randomness);

        this.level().addParticle(particleOptions, randX, randY + 5, randZ, 0, 0, 0);
    }

    @Override
    protected void tickDeath() {
        this.deathTime++;
        if (this.deathTime >= 350 && !this.level().isClientSide() && !this.isRemoved()) {
            // this.spawnParticles(ParticleTypes.DRAGON_BREATH, 20);
            this.level().explode(this, this.getX(), this.getY(), this.getZ(), 5.0F, true, Level.ExplosionInteraction.MOB);
            this.remove(RemovalReason.KILLED);
        }
    }

    class VoidSpewGoal extends Goal {
        private final VengefulHeartOfEnder parent;

        private int attackAmount;
        private int attackDelay;

        private int attackCooldownTime;

        private boolean stopped = false;

        public VoidSpewGoal(VengefulHeartOfEnder parent) {
            this.parent = parent;
            this.attackDelay = 0;
            this.attackAmount = 0;
        }

        @Override
        public boolean canUse() {
            return this.parent.getTarget() != null && this.parent.isOnSurface && this.parent.attack == 1;
        }

        @Override
        public boolean canContinueToUse() {
            return this.canUse() && this.attackAmount <= 5 && this.parent.attack == 1 && !this.stopped;
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }

        @Override
        public void start() {
            this.parent.lookControl.setLookAt(this.parent.getTarget());

            this.parent.idleAnimationState.stop();
            this.parent.sprayAnimationState.start(this.parent.tickCount);
        }

        @Override
        public void tick() {
            super.tick();

            this.attackDelay--;
            if (this.attackDelay <= 0) {
                this.attackDelay = 5;
                this.attackAmount++;

                LivingEntity livingentity = this.parent.getTarget();

                Random random = new Random();
                double chance = (random.nextDouble() * 4) - 2;

                double d0 = this.parent.distanceToSqr(livingentity);
                double d1 = (livingentity.getX() - this.parent.getX()) + chance;

                random = new Random();
                chance = (random.nextDouble() * 4) - 2;

                double d3 = (livingentity.getZ() - this.parent.getZ()) + chance;
                double d4 = Math.sqrt(Math.sqrt(d0)) * 0.5;

                double distanceFactor = Math.sqrt((d1 * d1) * (d3 * d3));

                double d2 = this.parent.getY(0.5) + 5;

                Vec3 vec3 = new Vec3(
                        this.parent.getRandom().triangle(d1, 2.297 * d4), d2 + distanceFactor, this.parent.getRandom().triangle(d3, 2.297 * d4)
                );

                VoidSpew fireball = new VoidSpew(this.parent.level(), this.parent, vec3.normalize());
                fireball.setPos(fireball.getX(), this.parent.getY(0.5), fireball.getZ());
                this.parent.level().addFreshEntity(fireball);
            }

            if (this.attackAmount > 5) {
                this.parent.attack = 0;
                this.stopped = true;
            }
        }
    }

    class ChargeGoal extends Goal {
        private final VengefulHeartOfEnder parent;
        private int chargeTick = 0;
        private boolean stopped = false;

        public ChargeGoal(VengefulHeartOfEnder parent) {
            this.parent = parent;
        }

        @Override
        public boolean canUse() {
            return this.parent.getTarget() != null && this.parent.isOnSurface;
        }

        @Override
        public boolean canContinueToUse() {
            return this.canUse() && !this.stopped;
        }

        @Override
        public void start() {
            this.parent.lookControl.setLookAt(this.parent.getTarget());
            this.stopped = false;
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }

        @Override
        public void tick() {
            super.tick();

            this.chargeTick++;

            if (this.chargeTick >= 100) {
                Random random = new Random();
                this.parent.stopInPlace();

                if (this.chargeTick >= 140) {
                    this.parent.lookControl.setLookAt(this.parent.getTarget());
                    if (this.parent.distanceToSqr(this.parent.getTarget()) <= 10) {
                        this.parent.attack = 1;
                    } else {
                        this.parent.attack = 0;
                    }
                    this.stopped = true;
                }
            } else {
                this.parent.moveControl.strafe(10, 0);
            }
        }
    }
}

