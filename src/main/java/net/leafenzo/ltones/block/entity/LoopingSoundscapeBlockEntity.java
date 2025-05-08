package net.leafenzo.ltones.block.entity;

import net.leafenzo.ltones.block.custom.LitBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LoopingSoundscapeBlockEntity extends BlockEntity {

    public LoopingSoundscapeBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityType.LOOPING_SOUNDSCAPE, pos, state);
    }
    private int soundDelay = 20;
    private SoundEvent loopingSound = null;

    public LoopingSoundscapeBlockEntity(BlockPos pos, BlockState state, int delay, SoundEvent sound) {
        super(ModBlockEntityType.LOOPING_SOUNDSCAPE, pos, state);
        soundDelay = delay;
        loopingSound = sound;
    }

    public static void tick(World world, BlockPos pos, BlockState state, LoopingSoundscapeBlockEntity blockEntity) {
        long l = world.getTime();
        if (l % blockEntity.soundDelay == 0L && state.get(LitBlock.LIT)) {
            world.playSoundAtBlockCenter(pos, blockEntity.loopingSound, SoundCategory.BLOCKS, 0.25f, 1.0f, false);
        }
    }
}
