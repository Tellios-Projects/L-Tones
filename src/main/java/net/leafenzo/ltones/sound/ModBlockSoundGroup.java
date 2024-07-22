package net.leafenzo.ltones.sound;

import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class ModBlockSoundGroup {
    public static final BlockSoundGroup METAL_STICKS = new BlockSoundGroup(1.0f, 1.0f, ModSoundEvents.BLOCK_METAL_STICKS_BREAK, ModSoundEvents.BLOCK_METAL_STICKS_STEP, ModSoundEvents.BLOCK_METAL_STICKS_PLACE, ModSoundEvents.BLOCK_METAL_STICKS_HIT, ModSoundEvents.BLOCK_METAL_STICKS_FALL);

    //TODO add sfx files for these
    public static final BlockSoundGroup FOIL = new BlockSoundGroup(1.0f, 1.0f, ModSoundEvents.BLOCK_FOIL_BREAK, ModSoundEvents.BLOCK_FOIL_STEP, ModSoundEvents.BLOCK_FOIL_PLACE, ModSoundEvents.BLOCK_FOIL_HIT, ModSoundEvents.BLOCK_FOIL_FALL);
    public static final BlockSoundGroup STATIC = new BlockSoundGroup(1.0f, 1.0f, ModSoundEvents.BLOCK_STATIC_BREAK, ModSoundEvents.BLOCK_STATIC_STEP, ModSoundEvents.BLOCK_STATIC_PLACE, ModSoundEvents.BLOCK_STATIC_HIT, ModSoundEvents.BLOCK_STATIC_FALL);
    public static final BlockSoundGroup NEON = new BlockSoundGroup(1.0f, 1.0f, ModSoundEvents.BLOCK_NEON_BREAK, ModSoundEvents.BLOCK_NEON_STEP, ModSoundEvents.BLOCK_NEON_PLACE, ModSoundEvents.BLOCK_NEON_HIT, ModSoundEvents.BLOCK_NEON_FALL);
    public static final BlockSoundGroup POLYGON = new BlockSoundGroup(1.0f, 1.0f, ModSoundEvents.BLOCK_POLYGON_BREAK, ModSoundEvents.BLOCK_POLYGON_STEP, ModSoundEvents.BLOCK_POLYGON_PLACE, ModSoundEvents.BLOCK_POLYGON_HIT, ModSoundEvents.BLOCK_POLYGON_FALL);
    public static final BlockSoundGroup LAIR = new BlockSoundGroup(1.0f, 1.0f, ModSoundEvents.BLOCK_LAIR_BREAK, ModSoundEvents.BLOCK_LAIR_STEP, ModSoundEvents.BLOCK_LAIR_PLACE, ModSoundEvents.BLOCK_LAIR_HIT, ModSoundEvents.BLOCK_LAIR_FALL);
    public static final BlockSoundGroup SOL = new BlockSoundGroup(1.0f, 1.0f, SoundEvents.BLOCK_GLASS_BREAK, SoundEvents.BLOCK_GLASS_STEP, SoundEvents.BLOCK_SHROOMLIGHT_PLACE, SoundEvents.BLOCK_GLASS_HIT, SoundEvents.BLOCK_GLASS_FALL);
    public static final BlockSoundGroup ZKUL = new BlockSoundGroup(1.0f, 1.0f, ModSoundEvents.BLOCK_ZKUL_BREAK, ModSoundEvents.BLOCK_ZKUL_STEP, ModSoundEvents.BLOCK_ZKUL_PLACE, ModSoundEvents.BLOCK_ZKUL_HIT, ModSoundEvents.BLOCK_ZKUL_FALL);
    public static final BlockSoundGroup DECAL_SLAG = new BlockSoundGroup(1.0f, 1.0f, SoundEvents.BLOCK_STONE_HIT, SoundEvents.BLOCK_STONE_STEP, SoundEvents.BLOCK_STONE_HIT, SoundEvents.BLOCK_STONE_HIT, SoundEvents.BLOCK_STONE_FALL);
    public static final BlockSoundGroup DECAL_MOULDING = new BlockSoundGroup(0.33f, 1.0f, SoundEvents.BLOCK_GRAVEL_BREAK, SoundEvents.BLOCK_SUSPICIOUS_GRAVEL_STEP, SoundEvents.BLOCK_SUSPICIOUS_GRAVEL_PLACE, SoundEvents.BLOCK_GRAVEL_HIT, SoundEvents.BLOCK_SUSPICIOUS_GRAVEL_FALL);
    public static final BlockSoundGroup TIRE = new BlockSoundGroup(0.66f, 2.4f, SoundEvents.BLOCK_FROGLIGHT_BREAK, SoundEvents.BLOCK_FROGLIGHT_STEP, SoundEvents.BLOCK_FROGLIGHT_PLACE, SoundEvents.BLOCK_FROGLIGHT_HIT,SoundEvents.BLOCK_FROGLIGHT_FALL);
}
