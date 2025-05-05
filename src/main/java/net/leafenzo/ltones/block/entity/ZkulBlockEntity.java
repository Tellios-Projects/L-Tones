package net.leafenzo.ltones.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class ZkulBlockEntity extends BlockEntity {
    public ZkulBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityType.ZKUL, pos, state);
    }

}
