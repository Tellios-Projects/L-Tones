package net.leafenzo.ltones.block.custom;

import net.leafenzo.ltones.sound.ModSoundEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class SyncPillarBlock extends PillarBlock {

    public SyncPillarBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (random.nextInt(80) == 0) {
            world.playSoundAtBlockCenter(pos, ModSoundEvents.BLOCK_SYNC_AMBIENT, SoundCategory.BLOCKS, 0.25f, (float) (world.getRandom().nextFloat() * 0.2 + 1.0), false);
        }
    }
}
