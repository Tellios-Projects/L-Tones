package net.leafenzo.ltones.block.custom;

import net.minecraft.block.*;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class KeyboardBlock extends BasicHorizontalFacingBlock implements Waterloggable {
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    protected static final VoxelShape[] HORIZONTAL_FACING_TO_SHAPE = new VoxelShape[]{
            Block.createCuboidShape(0.0, 0.0, 4.0, 16.0, 2.0, 12.0), // North
            Block.createCuboidShape(0.0, 0.0, 4.0, 16.0, 2.0, 12.0), // South
            Block.createCuboidShape(4.0, 0.0, 0.0, 12.0, 2.0, 16.0), // East
            Block.createCuboidShape(4.0, 0.0, 0.0, 12.0, 2.0, 16.0), // West
    };

    public KeyboardBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(WATERLOGGED, false));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        float a = world.getRandom().nextFloat() * 0.4f;
        float b = world.getRandom().nextFloat() * 0.3f;
        world.playSound(null, pos, SoundEvents.BLOCK_BAMBOO_WOOD_BUTTON_CLICK_ON, SoundCategory.BLOCKS, 0.3f + b, 1.8f + a);
        world.playSound(null, pos, SoundEvents.BLOCK_BAMBOO_WOOD_BUTTON_CLICK_OFF, SoundCategory.BLOCKS, 0.3f + a, 1.8f + b);

        float c = world.getRandom().nextFloat() * 0.2f;
        world.playSound(null, pos, SoundEvents.BLOCK_STONE_HIT, SoundCategory.BLOCKS, 0.2f + c, 2.4f - b);

        return ActionResult.SUCCESS;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return HORIZONTAL_FACING_TO_SHAPE[state.get(KeyboardBlock.FACING).getId()-2];
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return HORIZONTAL_FACING_TO_SHAPE[state.get(KeyboardBlock.FACING).getId()-2];
    }

    @Override
    public VoxelShape getSidesShape(BlockState state, BlockView world, BlockPos pos) {
        return HORIZONTAL_FACING_TO_SHAPE[state.get(KeyboardBlock.FACING).getId()-2];
    }

    @Override
    public VoxelShape getCameraCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return HORIZONTAL_FACING_TO_SHAPE[state.get(KeyboardBlock.FACING).getId()-2];
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return world.getBlockState(pos.down()).isSolid();
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (!state.canPlaceAt(world, pos)) {
            return Blocks.AIR.getDefaultState();
        }
        if (state.get(WATERLOGGED).booleanValue()) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        if (state.get(WATERLOGGED).booleanValue()) {
            return Fluids.WATER.getStill(false);
        }
        return super.getFluidState(state);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(WATERLOGGED);
    }
}
