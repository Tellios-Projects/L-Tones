package net.leafenzo.ltones.block.custom;

import net.leafenzo.ltones.particle.ModParticleTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class ZkulBlock extends Block {

    public ZkulBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (world.getRandom().nextFloat() > 0.8) {
            world.playSoundAtBlockCenter(pos, SoundEvents.BLOCK_RESPAWN_ANCHOR_AMBIENT, SoundCategory.BLOCKS, 0.8f, (float) (world.getRandom().nextFloat() * 0.2 + 0.5), false);
        }

        for (int i = 0; i < 2; i++) {
            world.addParticle(ModParticleTypes.ZKUL, ((world.getRandom().nextFloat() - 0.5f) * 16) + pos.getX(), ((world.getRandom().nextFloat() - 0.5f) * 16) + pos.getY(), ((world.getRandom().nextFloat() - 0.5f) * 16) + pos.getZ(), 0, 0, 0);
        }
    }
}
