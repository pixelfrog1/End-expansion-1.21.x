package net.pixelfrog.endplus.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.pixelfrog.endplus.block.ModBlocks;

public class EndVinesBodyBlock extends GrowingPlantBodyBlock {
    public static final MapCodec<EndVinesBodyBlock> CODEC = simpleCodec(EndVinesBodyBlock::new);
    public static final VoxelShape SHAPE = Block.box(1.0, 0.0, 1.0, 15.0, 16.0, 15.0);

    @Override
    public MapCodec<EndVinesBodyBlock> codec() {
        return CODEC;
    }

    public EndVinesBodyBlock(BlockBehaviour.Properties p_154975_) {
        super(p_154975_, Direction.DOWN, SHAPE, false);
    }

    @Override
    protected GrowingPlantHeadBlock getHeadBlock() {
        return (GrowingPlantHeadBlock) ModBlocks.CHORUS_BULB_HEAD.get();
    }
}
