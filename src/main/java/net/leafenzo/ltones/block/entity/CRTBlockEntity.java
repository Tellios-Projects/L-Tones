package net.leafenzo.ltones.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class CRTBlockEntity extends BlockEntity {
    public CRTBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityType.ZKUL, pos, state);
    }

    public void tick() {
        // mario
    }



}
