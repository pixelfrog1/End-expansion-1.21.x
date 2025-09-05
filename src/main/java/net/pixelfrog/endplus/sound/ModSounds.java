package net.pixelfrog.endplus.sound;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pixelfrog.endplus.EndPlus;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, EndPlus.MOD_ID);


    public static final RegistryObject<SoundEvent> MUSIC_VENGEFUL_HEART_OF_ENDER_LOOP = registerSoundEvent("music_vengeful_heart_of_ender_loop");

    public static final RegistryObject<SoundEvent> MUSIC_VENGEFUL_HEART_OF_ENDER_DIE = registerSoundEvent("music_vengeful_heart_of_ender_die");

    public static final RegistryObject<SoundEvent> MUSIC_TENEBRE_ROSSO_SANGUE = registerSoundEvent("music_tenebre_rosso_sangue");

    public static final RegistryObject<SoundEvent> VENGEFUL_HEART_OF_ENDER_SHOOT = registerSoundEvent("vengeful_heart_of_ender_shoot");


    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(EndPlus.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
