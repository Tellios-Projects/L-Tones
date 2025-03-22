package net.leafenzo.ltones.block.entity;

import net.leafenzo.ltones.sound.ModSoundEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static net.leafenzo.ltones.block.custom.LitBlock.LIT;


public class LairSoundscapeBlockEntity extends BlockEntity {
    public LairSoundscapeBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityType.LAIR_SOUNDSCAPE, pos, state);
    }

    public static void serverTick(World world, BlockPos pos, BlockState state, LairSoundscapeBlockEntity blockEntity) {
        long l = world.getTime();
            if (l % 80L == 0L && state.get(LIT)) {
                world.playSound(null, pos, ModSoundEvents.BLOCK_LAIR_AMBIENT, SoundCategory.BLOCKS, 1.0f, 1.0f);
            }
    }
}
