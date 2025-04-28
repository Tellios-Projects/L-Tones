package net.leafenzo.ltones.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public class RustingPillarBlock extends PillarBlock {

    public BlockState rustBlock;
    public boolean rusted;
    public RustingPillarBlock(Settings settings, BlockState rustedBlock, boolean isRusted) {
        super(settings);
        rustBlock = rustedBlock;
        rusted = isRusted;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.isReceivingRedstonePower(pos) && random.nextInt(18) == 0 && !rusted) {
            world.setBlockState(pos, rustBlock.getBlock().getStateWithProperties(state));
        }
    }
    @Override
    public boolean hasRandomTicks(BlockState state) {
        return !rusted;
    }

}
