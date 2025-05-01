package net.leafenzo.ltones.block.custom;

import net.leafenzo.ltones.sound.ModSoundEvents;
import net.minecraft.block.*;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class KeyboardBlock extends BasicHorizontalFacingBlock implements Waterloggable {
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public static final BooleanProperty POWERED = Properties.POWERED;
    private final int pressTicks;
    private final SoundEvent click;

    protected static final VoxelShape[] HORIZONTAL_FACING_TO_SHAPE = new VoxelShape[]{
            Block.createCuboidShape(0.0, 0.0, 4.0, 16.0, 2.0, 12.0), // North
            Block.createCuboidShape(0.0, 0.0, 4.0, 16.0, 2.0, 12.0), // South
            Block.createCuboidShape(4.0, 0.0, 0.0, 12.0, 2.0, 16.0), // East
            Block.createCuboidShape(4.0, 0.0, 0.0, 12.0, 2.0, 16.0), // West
    };

    public KeyboardBlock(AbstractBlock.Settings settings, SoundEvent clickSound, int pressTicks) {
        super(settings);
        this.pressTicks = pressTicks;
        this.click = clickSound;
        this.setDefaultState(this.getDefaultState().with(WATERLOGGED, false).with(POWERED, false));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        float a = world.getRandom().nextFloat() * 0.1f;
        float b = world.getRandom().nextFloat() * 0.3f;
        world.playSoundAtBlockCenter(pos, click, SoundCategory.BLOCKS, 0.3f + b, 0.95f + a, false);
        this.powerOn(state, world, pos);
        return ActionResult.SUCCESS;
    }

    public void powerOn(BlockState state, World world, BlockPos pos) {
        world.setBlockState(pos, state.with(POWERED, true), Block.NOTIFY_ALL);
        this.updateNeighbors(state, world, pos);
        world.scheduleBlockTick(pos, this, pressTicks);
    }

    @Override
    public int getWeakRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        return state.get(POWERED) ? 15 : 0;
    }

    @Override
    public int getStrongRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        if (state.get(POWERED)) {
            return 15;
        }
        return 0;
    }

    @Override
    public boolean emitsRedstonePower(BlockState state) {
        return true;
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!state.get(POWERED)) {
            return;
        }
        world.setBlockState(pos, state.with(POWERED, false), Block.NOTIFY_ALL);
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

    private void updateNeighbors(BlockState state, World world, BlockPos pos) {
        world.updateNeighborsAlways(pos, this);
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
        if (state.get(WATERLOGGED)) {
            return Fluids.WATER.getStill(false);
        }
        return super.getFluidState(state);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(WATERLOGGED);
        builder.add(POWERED);
    }
}
