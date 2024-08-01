package net.leafenzo.ltones.block.custom;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
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
import net.minecraft.world.event.GameEvent;

public class RadioBlock extends BasicHorizontalFacingBlock {
    public static final BooleanProperty ENABLED = Properties.ENABLED;
    public static final VoxelShape[] HORIZONTAL_FACING_TO_COLLISION_SHAPE = new VoxelShape[] {
            Block.createCuboidShape(0.5, 0.0, 5.5, 14.5, 12.0, 10.5),
            Block.createCuboidShape(0.5, 0.0, 5.5, 14.5, 12.0, 10.5),
            Block.createCuboidShape(5.5, 0.0, 0.5, 10.5, 12.0, 14.5),
            Block.createCuboidShape(5.5, 0.0, 0.5, 10.5, 12.0, 14.5)
    };

    public RadioBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(ENABLED, false));
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (!state.canPlaceAt(world, pos)) {
            return Blocks.AIR.getDefaultState();
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }
    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return world.getBlockState(pos.down()).isSolid();
    }

    public void turnOn(BlockState state, World world, BlockPos pos) {
        world.playSound(null, pos, getOnSound(), SoundCategory.BLOCKS, 0.3f, 1.0f);
        //enable Blockentity
        world.setBlockState(pos, state.with(ENABLED, true));
    }
    public void turnOff(BlockState state, World world, BlockPos pos) {
        world.playSound(null, pos, getOffSound(), SoundCategory.BLOCKS, 0.3f, 1.0f);
        //put Blockentity to sleep
        world.setBlockState(pos, state.with(ENABLED, false));
    }
    public static SoundEvent getOnSound() {
        return SoundEvents.BLOCK_LEVER_CLICK;
    }
    public static SoundEvent getOffSound() {
        return SoundEvents.BLOCK_LEVER_CLICK;
    }
    public static SoundEvent getFizzleSound() {
        return SoundEvents.ENTITY_ALLAY_DEATH;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(world.isClient) {
            return ActionResult.SUCCESS;
        }
        if (state.get(ENABLED)) { turnOff(state, world, pos); }
        else { turnOn(state, world, pos); }
        world.emitGameEvent(player, state.get(ENABLED) ? GameEvent.BLOCK_ACTIVATE : GameEvent.BLOCK_DEACTIVATE, pos);
        return ActionResult.CONSUME;
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
        return HORIZONTAL_FACING_TO_COLLISION_SHAPE[state.get(FACING).getId()-2];
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(ENABLED);
    }
}
