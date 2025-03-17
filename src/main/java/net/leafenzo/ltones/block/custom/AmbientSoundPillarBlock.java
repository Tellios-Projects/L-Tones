package net.leafenzo.ltones.block.custom;

import net.leafenzo.ltones.sound.ModSoundEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class AmbientSoundPillarBlock extends PillarBlock {

    SoundEvent sound;
    int soundFrequency;

    public AmbientSoundPillarBlock(Settings settings, SoundEvent ambientSound, int ambientSoundFrequency) {
        super(settings);
        sound = ambientSound;
        soundFrequency = ambientSoundFrequency;
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (random.nextInt(soundFrequency) == 0) {
            world.playSoundAtBlockCenter(pos, sound, SoundCategory.BLOCKS, 0.25f, (float) (world.getRandom().nextFloat() * 0.2 + 1.0), false);
        }
    }
}
