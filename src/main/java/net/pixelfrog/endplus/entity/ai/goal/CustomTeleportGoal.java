package net.pixelfrog.endplus.entity.ai.goal;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

import java.util.Random;

public class CustomTeleportGoal extends Goal {
    private final Mob mob;

    private Vec3 teleportPos;

    private int teleportTick;

    private boolean isUsing;
    private final boolean canTeleport;

    public CustomTeleportGoal(Mob mob, boolean canTeleport) {
        this.mob = mob;

        this.isUsing = true;
        this.canTeleport = canTeleport;
    }

    @Override
    public boolean canUse() {
        return this.mob.getTarget() != null && this.isUsing && this.canTeleport;
    }

    @Override
    public boolean canContinueToUse() {
        return this.canUse() && this.isUsing;
    }

    @Override
    public boolean requiresUpdateEveryTick() {
        return true;
    }

    private Vec3 getTeleportPos(int x, int y, int z) {
        if (!this.mob.level().getBlockState(new BlockPos(x, y, z)).is(Blocks.AIR)) {

            return new Vec3(x, y, z);

        } else if (!this.mob.level().getBlockState(new BlockPos(x, y + 1, z)).is(Blocks.AIR)) {

            return new Vec3(x, y + 1, z);


        } else if (!this.mob.level().getBlockState(new BlockPos(x, z - 1, z)).is(Blocks.AIR)) {

            return new Vec3(x, y - 1, z);

        } else {
            return null;
        }
    }

    @Override
    public void start() {
        super.start();

        this.mob.setInvulnerable(true);
        this.mob.setInvisible(true);

        this.mob.stopInPlace();

        this.teleportTick = 0;


        int x = (int) (this.mob.getTarget().getX() + new Random().nextInt(-10, 10));
        int y = (int) this.mob.getTarget().getY();
        int z = (int) (this.mob.getTarget().getZ() + new Random().nextInt(-10, 10));

        if (this.getTeleportPos(x, y, z) == null) {
            this.isUsing = false;
        } else {
            this.isUsing = true;

            this.teleportPos = this.getTeleportPos(x, y, z);
        }
    }

    @Override
    public void stop() {
        super.stop();

        this.mob.setInvulnerable(false);
        this.mob.setInvisible(false);
    }

    @Override
    public void tick() {
        super.tick();

        this.teleportTick++;

        if (this.teleportTick >= new Random().nextInt(10, 60)) {
            this.mob.teleportTo(this.teleportPos.x, this.teleportPos.y, this.teleportPos.z);
            this.isUsing = false;
        }
    }
}
