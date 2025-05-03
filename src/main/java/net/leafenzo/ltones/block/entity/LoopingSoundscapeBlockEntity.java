package net.leafenzo.ltones.block.entity;

import net.leafenzo.ltones.sound.ModSoundEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static net.leafenzo.ltones.block.custom.LitBlock.LIT;


public class LoopingSoundscapeBlockEntity extends BlockEntity {
    public LoopingSoundscapeBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityType.LOOPING_SOUNDSCAPE, pos, state);
    }

    private static int delay;
    private static SoundEvent sound;
    public LoopingSoundscapeBlockEntity(BlockPos pos, BlockState state, int soundDelay, SoundEvent loopingSound) {
        super(ModBlockEntityType.LOOPING_SOUNDSCAPE, pos, state);
        delay = soundDelay;
        sound = loopingSound;
    }

    public static void serverTick(World world, BlockPos pos, BlockState state, LoopingSoundscapeBlockEntity blockEntity) {
        long l = world.getTime();
            if (l % delay == 0L && state.get(LIT)) {
                world.playSound(null, pos, sound, SoundCategory.BLOCKS, 0.25f, 1.0f);
            }
    }
}
