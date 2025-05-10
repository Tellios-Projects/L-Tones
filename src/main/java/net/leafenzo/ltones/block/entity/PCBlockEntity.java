package net.leafenzo.ltones.block.entity;

import net.leafenzo.ltones.block.custom.PCBlock;
import net.leafenzo.ltones.sound.ModSoundEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PCBlockEntity extends BlockEntity {
    public PCBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityType.PC, pos, state);
    }

    public static <T extends BlockEntity> void tick(World world, BlockPos pos, BlockState state, T t) {
        long l = world.getTime();
        if (l % 40 == 0L && state.get(PCBlock.POWERED)) {
            world.playSound(null, pos, ModSoundEvents.BLOCK_PC_AMBIENT, SoundCategory.BLOCKS, 1.0f, 1.0f);
        }
    }


}
