package net.pixelfrog.endplus.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.pixelfrog.endplus.block.ModBlocks;

public class StandingEndVinesBodyBlock extends GrowingPlantBodyBlock {
    public static final MapCodec<StandingEndVinesBodyBlock> CODEC = simpleCodec(StandingEndVinesBodyBlock::new);
    public static final VoxelShape SHAPE = Block.box(4.0, 0.0, 4.0, 12.0, 16.0, 12.0);

    @Override
    public MapCodec<StandingEndVinesBodyBlock> codec() {
        return CODEC;
    }

    public StandingEndVinesBodyBlock(BlockBehaviour.Properties p_154873_) {
        super(p_154873_, Direction.UP, SHAPE, false);
    }

    @Override
    protected GrowingPlantHeadBlock getHeadBlock() {
        return (GrowingPlantHeadBlock) ModBlocks.TWISTING_END_VINES_HEAD.get();
    }
}
