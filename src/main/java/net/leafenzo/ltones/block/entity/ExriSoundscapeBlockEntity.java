package net.leafenzo.ltones.block.entity;

import net.leafenzo.ltones.sound.ModSoundEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static net.leafenzo.ltones.block.custom.LitBlock.LIT;


public class ExriSoundscapeBlockEntity extends BlockEntity {
    public ExriSoundscapeBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityType.EXRI_SOUNDSCAPE, pos, state);
    }

    public static void serverTick(World world, BlockPos pos, BlockState state, ExriSoundscapeBlockEntity blockEntity) {
        long l = world.getTime();
            if (l % 105L == 0L && state.get(LIT)) {
                world.playSound(null, pos, ModSoundEvents.BLOCK_EXRI_AMBIENT, SoundCategory.BLOCKS, 0.25f, 1.0f);
            }
    }
}
