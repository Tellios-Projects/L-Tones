package net.leafenzo.ltones.sound;

import net.minecraft.sound.BlockSoundGroup;

public class ModBlockSoundGroup {
    public static final BlockSoundGroup METAL_STICKS = new BlockSoundGroup(1.0f, 1.0f, ModSoundEvents.BLOCK_METAL_STICKS_BREAK, ModSoundEvents.BLOCK_METAL_STICKS_STEP, ModSoundEvents.BLOCK_METAL_STICKS_PLACE, ModSoundEvents.BLOCK_METAL_STICKS_HIT, ModSoundEvents.BLOCK_METAL_STICKS_FALL);

    //TODO add sfx files for these
    public static final BlockSoundGroup FOIL = new BlockSoundGroup(1.0f, 1.0f, ModSoundEvents.BLOCK_FOIL_BREAK, ModSoundEvents.BLOCK_FOIL_STEP, ModSoundEvents.BLOCK_FOIL_PLACE, ModSoundEvents.BLOCK_FOIL_HIT, ModSoundEvents.BLOCK_FOIL_FALL);
    public static final BlockSoundGroup STATIC = new BlockSoundGroup(1.0f, 1.0f, ModSoundEvents.BLOCK_STATIC_BREAK, ModSoundEvents.BLOCK_STATIC_STEP, ModSoundEvents.BLOCK_STATIC_PLACE, ModSoundEvents.BLOCK_STATIC_HIT, ModSoundEvents.BLOCK_STATIC_FALL);
    public static final BlockSoundGroup POLYGON = new BlockSoundGroup(1.0f, 1.0f, ModSoundEvents.BLOCK_POLYGON_BREAK, ModSoundEvents.BLOCK_POLYGON_STEP, ModSoundEvents.BLOCK_POLYGON_PLACE, ModSoundEvents.BLOCK_POLYGON_HIT, ModSoundEvents.BLOCK_POLYGON_FALL);
    public static final BlockSoundGroup ZKUL = new BlockSoundGroup(1.0f, 1.0f, ModSoundEvents.BLOCK_ZKUL_BREAK, ModSoundEvents.BLOCK_ZKUL_STEP, ModSoundEvents.BLOCK_ZKUL_PLACE, ModSoundEvents.BLOCK_ZKUL_HIT, ModSoundEvents.BLOCK_ZKUL_FALL);
}
