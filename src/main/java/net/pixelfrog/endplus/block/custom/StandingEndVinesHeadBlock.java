package net.pixelfrog.endplus.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.pixelfrog.endplus.block.ModBlocks;

public class StandingEndVinesHeadBlock extends GrowingPlantHeadBlock {
    public static final MapCodec<StandingEndVinesHeadBlock> CODEC = simpleCodec(StandingEndVinesHeadBlock::new);
    public static final VoxelShape SHAPE = Block.box(4.0, 0.0, 4.0, 12.0, 15.0, 12.0);

    @Override
    public MapCodec<StandingEndVinesHeadBlock> codec() {
        return CODEC;
    }

    public StandingEndVinesHeadBlock(BlockBehaviour.Properties p_154864_) {
        super(p_154864_, Direction.UP, SHAPE, false, 0.1);
    }

    @Override
    protected int getBlocksToGrowWhenBonemealed(RandomSource p_222649_) {
        return NetherVines.getBlocksToGrowWhenBonemealed(p_222649_);
    }

    @Override
    protected Block getBodyBlock() {
        return ModBlocks.TWISTING_END_VINES_BODY.get();
    }

    @Override
    protected boolean canGrowInto(BlockState p_154869_) {
        return NetherVines.isValidGrowthState(p_154869_);
    }
}
