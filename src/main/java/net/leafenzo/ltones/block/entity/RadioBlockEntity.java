package net.leafenzo.ltones.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class RadioBlockEntity extends BlockEntity {
    public RadioBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public float acquireStation(World world, BlockPos pos) {
        int x = Math.round((float) pos.getX() / 100);
        int z = Math.round((float) pos.getZ() / 100);
        long seed = ((long) x * z);

        world.getTime()


        Random random = Random.create(seed);


        int d = random.nextInt(4);
    }

}
