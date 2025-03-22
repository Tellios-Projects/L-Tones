package net.leafenzo.ltones.block.custom;

import net.leafenzo.ltones.block.entity.LairSoundscapeBlockEntity;
import net.leafenzo.ltones.block.entity.ModBlockEntityType;
import net.minecraft.block.*;
import net.minecraft.block.entity.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import static net.leafenzo.ltones.block.custom.SoundscapeBlock.LIT;

public class LairSoundscapeBlock extends BlockWithEntity {

    public LairSoundscapeBlock(Settings settings) {
        super(settings);
    }

    @Override
    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(LIT, ctx.getWorld().isReceivingRedstonePower(ctx.getBlockPos()));
    }

    @Override
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return world.isClient ? null : LairSoundscapeBlock.checkType(type, ModBlockEntityType.LAIR_SOUNDSCAPE, LairSoundscapeBlockEntity::serverTick);
    }


    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (world.isClient) {
            return;
        }
        boolean bl = state.get(LIT);
        if (bl != world.isReceivingRedstonePower(pos)) {
            toggleLit(state, world, pos);
        }
    }

    protected void toggleLit(BlockState state, World world, BlockPos pos) {
        world.setBlockState(pos, state.cycle(LIT), Block.NOTIFY_LISTENERS);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(LIT);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state)  {
        return new LairSoundscapeBlockEntity(pos, state); // useful for future
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}