package net.leafenzo.ltones.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.mob.WardenEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class ZkulBlockEntity extends BlockEntity {
    public ZkulBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityType.ZKUL, pos, state);
    }

    public void darkness(ServerWorld serverWorld, BlockPos pos) {
        WardenEntity.addDarknessToClosePlayers(serverWorld, Vec3d.ofCenter(this.getPos()), null, 40);
    }

    public void tick() {
        // mario
    }

}
