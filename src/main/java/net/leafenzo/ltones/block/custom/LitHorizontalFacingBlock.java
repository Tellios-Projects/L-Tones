package net.leafenzo.ltones.block.custom;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class LitHorizontalFacingBlock extends HorizontalFacingBlock {
    public static final BooleanProperty LIT = Properties.LIT;
    public final SoundEvent turnOnSound;
    public final SoundEvent turnOffSound;

    public LitHorizontalFacingBlock(AbstractBlock.Settings settings, @Nullable SoundEvent turnOnSound, @Nullable SoundEvent turnOffSound) {
        super(settings);
        this.turnOnSound = turnOnSound;
        this.turnOffSound = turnOffSound;
        this.setDefaultState((BlockState)this.getDefaultState().with(LIT, false));
    }
    public LitHorizontalFacingBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.turnOnSound = null;
        this.turnOffSound = null;
        this.setDefaultState((BlockState)this.getDefaultState().with(LIT, false));
    }

    @Override
    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return super.getPlacementState(ctx).with(LIT, ctx.getWorld().isReceivingRedstonePower(ctx.getBlockPos())).with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (world.isClient) {
            return;
        }
        boolean bl = state.get(LIT);
        if (bl != world.isReceivingRedstonePower(pos)) {
            if (bl) {
                world.scheduleBlockTick(pos, this, 4);
            } else {
                toggleLit(state, world, pos);
            }
        }
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (state.get(LIT).booleanValue() && !world.isReceivingRedstonePower(pos)) {
            toggleLit(state, world, pos);
        }
    }

    public void toggleLit(BlockState state, World world, BlockPos pos) {
        if(state.get(LIT).booleanValue()) {
            if(turnOffSound != null) world.playSound(null, pos, this.turnOffSound, SoundCategory.BLOCKS, 1.0f, 1.0f);
        }
        else {
            if(turnOnSound != null) world.playSound(null, pos, this.turnOnSound, SoundCategory.BLOCKS, 1.0f, 1.0f);
        }
        world.setBlockState(pos, (BlockState)state.cycle(LIT), Block.NOTIFY_LISTENERS);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(HorizontalFacingBlock.FACING);
        builder.add(LIT);
    }
}
