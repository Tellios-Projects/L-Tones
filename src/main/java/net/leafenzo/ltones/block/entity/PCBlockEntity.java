package net.leafenzo.ltones.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;

public class PCBlockEntity extends BlockEntity {
    public PCBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityType.PC_TOWER, pos, state);
    }

    private static SoundEvent sound;
    public PCBlockEntity(BlockPos pos, BlockState state, SoundEvent loopSound) {
        super(ModBlockEntityType.PC_TOWER, pos, state);
        sound = loopSound;
    }

    public void tick() {
        // mario
    }

}
