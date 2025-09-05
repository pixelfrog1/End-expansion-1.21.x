package net.pixelfrog.endplus.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.pixelfrog.endplus.effect.ModEffects;

public class VoidBlock extends Block {
    public VoidBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        ((LivingEntity)pEntity).addEffect(new MobEffectInstance(ModEffects.VOID_TOUCHED.getHolder().get(), 20), pEntity);
        super.entityInside(pState, pLevel, pPos, pEntity);
    }
}
