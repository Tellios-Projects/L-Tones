package net.leafenzo.ltones.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;

public class RustingBlock extends Block {
    BlockState block;
    boolean rusted;
    public RustingBlock(Settings settings, BlockState rustedBlock, boolean isRusted) {
        super(settings);
        block = rustedBlock;
        rusted = isRusted;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.isReceivingRedstonePower(pos) && random.nextInt(18) == 0 && !rusted) {
            world.setBlockState(pos, block.getBlock().getStateWithProperties(state));
        }
    }
    @Override
    public boolean hasRandomTicks(BlockState state) {
        return !rusted;
    }

}
