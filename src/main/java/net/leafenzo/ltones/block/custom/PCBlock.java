package net.leafenzo.ltones.block.custom;

import net.leafenzo.ltones.block.entity.PCBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class PCBlock extends BlockWithEntity {

    public static final BooleanProperty POWERED = Properties.POWERED;
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    private final SoundEvent onSound;
    private final SoundEvent offSound;

    public PCBlock(Settings settings, SoundEvent turnOnSound, SoundEvent turnOffSound) {
        super(settings);
        this.onSound = turnOnSound;
        this.offSound = turnOffSound;
    }

    protected static final VoxelShape[] HORIZONTAL_FACING_TO_SHAPE = new VoxelShape[]{
            Block.createCuboidShape(4.0, 0.0, 0.0, 12.0, 16.0, 16.0), // North
            Block.createCuboidShape(4.0, 0.0, 0.0, 12.0, 16.0, 16.0), // South
            Block.createCuboidShape(0.0, 0.0, 4.0, 16.0, 16.0, 12.0), // East
            Block.createCuboidShape(0.0, 0.0, 4.0, 16.0, 16.0, 12.0), // West
    };

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return HORIZONTAL_FACING_TO_SHAPE[state.get(SwitchBlock.FACING).getId()-2];
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return HORIZONTAL_FACING_TO_SHAPE[state.get(SwitchBlock.FACING).getId()-2];
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (state.get(POWERED)) {
            world.playSound(null, pos, offSound, SoundCategory.BLOCKS, 0.6f, 1.0f);
        } else {
            world.playSound(null, pos, onSound, SoundCategory.BLOCKS, 0.6f, 1.0f);
        }

        if (world.isClient) {
            return ActionResult.SUCCESS;
        }
        state.cycle(POWERED);
        world.emitGameEvent(player, state.get(POWERED) ? GameEvent.BLOCK_ACTIVATE : GameEvent.BLOCK_DEACTIVATE, pos);
        return ActionResult.CONSUME;
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, POWERED);
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new PCBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}
