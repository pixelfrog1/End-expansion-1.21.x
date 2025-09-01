package net.pixelfrog.endplus.effect;

import net.minecraft.core.Holder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.pixelfrog.endplus.damagesource.ModDamageSources;

public class VoidTouchedEffect extends MobEffect {
    private int damageTick = 0;

    public VoidTouchedEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void onMobHurt(LivingEntity pLivingEntity, int pAmplifier, DamageSource pDamageSource, float pAmount) {
        pLivingEntity.hurt(pLivingEntity.damageSources().magic(), 1.0F * pAmplifier);

        super.onMobHurt(pLivingEntity, pAmplifier, pDamageSource, pAmount);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int pDuration, int pAmplifier) {
        return true;
    }
}