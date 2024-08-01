package net.leafenzo.ltones.block.custom;

import net.minecraft.block.*;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class AntennaBlock extends BasicHorizontalFacingBlock implements Waterloggable {
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public static final VoxelShape[] HORIZONTAL_FACING_TO_COLLISION_SHAPE = new VoxelShape[] {
            Block.createCuboidShape(0.5, 0.0, 5.5, 14.5, 12.0, 10.5),
            Block.createCuboidShape(0.5, 0.0, 5.5, 14.5, 12.0, 10.5),
            Block.createCuboidShape(5.5, 0.0, 0.5, 10.5, 12.0, 14.5),
            Block.createCuboidShape(5.5, 0.0, 0.5, 10.5, 12.0, 14.5)
    };
    public static final VoxelShape[] HORIZONTAL_FACING_TO_OUTLINE_SHAPE = new VoxelShape[]{
            Block.createCuboidShape(0.5, 0.0, 3.5, 15.5, 12.0, 12.5),
            Block.createCuboidShape(0.5, 0.0, 3.5, 15.5, 12.0, 12.5),
            Block.createCuboidShape(3.5, 0.0, 0.5, 12.5, 12.0, 15.5),
            Block.createCuboidShape(3.5, 0.0, 0.5, 12.5, 12.0, 15.5)
    };

    public AntennaBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(WATERLOGGED, false));
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return HORIZONTAL_FACING_TO_COLLISION_SHAPE[state.get(FACING).getId()-2];
    }

    @Override
    public VoxelShape getCameraCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return HORIZONTAL_FACING_TO_COLLISION_SHAPE[state.get(FACING).getId()-2];
    }

    @Override
    public VoxelShape getSidesShape(BlockState state, BlockView world, BlockPos pos) {
        return HORIZONTAL_FACING_TO_COLLISION_SHAPE[state.get(FACING).getId()-2];
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return HORIZONTAL_FACING_TO_OUTLINE_SHAPE[state.get(FACING).getId()-2];
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return world.getBlockState(pos.down()).isSolid();
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (!state.canPlaceAt(world, pos)) {
            return Blocks.AIR.getDefaultState();
        }
        if (state.get(WATERLOGGED)) {
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
