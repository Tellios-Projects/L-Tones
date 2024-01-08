package net.leafenzo.ltones.sound;

import net.leafenzo.ltones.Super;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSoundEvents {
    public static final SoundEvent BLOCK_METAL_STICKS_BREAK = registerSoundEvent("block.metal_sticks.break");
    public static final SoundEvent BLOCK_METAL_STICKS_STEP = registerSoundEvent("block.metal_sticks.step");
    public static final SoundEvent BLOCK_METAL_STICKS_PLACE = registerSoundEvent("block.metal_sticks.place");
    public static final SoundEvent BLOCK_METAL_STICKS_HIT = registerSoundEvent("block.metal_sticks.hit");
    public static final SoundEvent BLOCK_METAL_STICKS_FALL = registerSoundEvent("block.metal_sticks.fall");

    public static final SoundEvent BLOCK_FOIL_BREAK = registerSoundEvent("block.foil.break");
    public static final SoundEvent BLOCK_FOIL_STEP = registerSoundEvent("block.foil.step");
    public static final SoundEvent BLOCK_FOIL_PLACE = registerSoundEvent("block.foil.place");
    public static final SoundEvent BLOCK_FOIL_HIT = registerSoundEvent("block.foil.hit");
    public static final SoundEvent BLOCK_FOIL_FALL = registerSoundEvent("block.foil.fall");

    public static final SoundEvent BLOCK_STATIC_BREAK = registerSoundEvent("block.static.break");
    public static final SoundEvent BLOCK_STATIC_STEP = registerSoundEvent("block.static.step");
    public static final SoundEvent BLOCK_STATIC_PLACE = registerSoundEvent("block.static.place");
    public static final SoundEvent BLOCK_STATIC_HIT = registerSoundEvent("block.static.hit");
    public static final SoundEvent BLOCK_STATIC_FALL = registerSoundEvent("block.static.fall");

    public static final SoundEvent BLOCK_NEON_BREAK = registerSoundEvent("block.neon.break");
    public static final SoundEvent BLOCK_NEON_STEP = registerSoundEvent("block.neon.step");
    public static final SoundEvent BLOCK_NEON_PLACE = registerSoundEvent("block.neon.place");
    public static final SoundEvent BLOCK_NEON_HIT = registerSoundEvent("block.neon.hit");
    public static final SoundEvent BLOCK_NEON_FALL = registerSoundEvent("block.neon.fall");

    public static final SoundEvent BLOCK_POLYGON_BREAK = registerSoundEvent("block.polygon.break");
    public static final SoundEvent BLOCK_POLYGON_STEP = registerSoundEvent("block.polygon.step");
    public static final SoundEvent BLOCK_POLYGON_PLACE = registerSoundEvent("block.polygon.place");
    public static final SoundEvent BLOCK_POLYGON_HIT = registerSoundEvent("block.polygon.hit");
    public static final SoundEvent BLOCK_POLYGON_FALL = registerSoundEvent("block.polygon.fall");
    public static final SoundEvent BLOCK_POLYGON_ACTIVATE = registerSoundEvent("block.polygon.activate");
    public static final SoundEvent BLOCK_POLYGON_DEACTIVATE = registerSoundEvent("block.polygon.deactivate");

    public static final SoundEvent BLOCK_ZKUL_BREAK = registerSoundEvent("block.zkul.break");
    public static final SoundEvent BLOCK_ZKUL_STEP = registerSoundEvent("block.zkul.step");
    public static final SoundEvent BLOCK_ZKUL_PLACE = registerSoundEvent("block.zkul.place");
    public static final SoundEvent BLOCK_ZKUL_HIT = registerSoundEvent("block.zkul.hit");
    public static final SoundEvent BLOCK_ZKUL_FALL = registerSoundEvent("block.zkul.fall");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(Super.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
}
