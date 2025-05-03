package net.leafenzo.ltones.block.entity;

import net.leafenzo.ltones.block.custom.LoopingSoundscapeBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class LoopingSoundscapeBlockEntity extends BlockEntity {

    public LoopingSoundscapeBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityType.LOOPING_SOUNDSCAPE, pos, state);
    }

    public static void serverTick(World world, BlockPos pos, BlockState state, LoopingSoundscapeBlockEntity blockEntity) {
        LoopingSoundscapeBlock.playLoopingSound(world, pos, state);
    }
}
