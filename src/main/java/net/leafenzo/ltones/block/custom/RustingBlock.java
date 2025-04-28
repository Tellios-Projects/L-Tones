package net.leafenzo.ltones.block.custom;

import net.leafenzo.ltones.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Optional;

public class RustingBlock extends Block {
    public BlockState rustBlock;
    public boolean rusted;
    public RustingBlock(Settings settings, BlockState rustedBlock, boolean isRusted) {
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
