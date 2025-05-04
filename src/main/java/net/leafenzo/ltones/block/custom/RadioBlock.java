package net.leafenzo.ltones.block.custom;

import net.leafenzo.ltones.block.ModBlocks;
import net.leafenzo.ltones.sound.ModSoundEvents;
import net.leafenzo.ltones.state.ModProperties;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.DustParticleEffect;
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
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;

public class RadioBlock extends BasicHorizontalFacingBlock {
    public static final BooleanProperty HAS_ANTENNA = ModProperties.HAS_ANTENNA;
    public static final BooleanProperty ENABLED = Properties.ENABLED;
    public static final VoxelShape[] HORIZONTAL_FACING_TO_COLLISION_SHAPE = new VoxelShape[] {
            Block.createCuboidShape(2.0, 0.0, 4.0, 14.0, 10.0, 12.0),
            Block.createCuboidShape(2.0, 0.0, 4.0, 14.0, 10.0, 12.0),
            Block.createCuboidShape(4.0, 0.0, 2.0, 12.0, 10.0, 14.0),
            Block.createCuboidShape(4.0, 0.0, 2.0, 12.0, 10.0, 14.0)
    };

    public RadioBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(ENABLED, false).with(HAS_ANTENNA, false));
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (state.get(HAS_ANTENNA) && !player.isCreative()) {
            dropStack(world,pos, ModBlocks.ANTENNA.asItem().getDefaultStack());
        }
        super.onBreak(world, pos, state, player);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (!state.canPlaceAt(world, pos)) {
            if (state.get(HAS_ANTENNA)) {
                dropStack((World) world,pos, ModBlocks.ANTENNA.asItem().getDefaultStack());
            }
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
        return ModSoundEvents.BLOCK_RADIO_ON;
    }
    public static SoundEvent getOffSound() {
        return ModSoundEvents.BLOCK_RADIO_OFF;
    }
    public static SoundEvent getFizzleSound() {
        return SoundEvents.ENTITY_ALLAY_DEATH;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (player.getStackInHand(hand).isOf(ModBlocks.ANTENNA.asItem()) && !state.get(HAS_ANTENNA)) {
            world.playSoundAtBlockCenter(pos, ModSoundEvents.BLOCK_ANTENNA_PLACE, SoundCategory.BLOCKS, 1.0f, 0.8f, false);
            if (world.isClient) {
                return ActionResult.SUCCESS;
            }
            if (!player.isCreative()) {
                player.getStackInHand(hand).decrement(1);
            }
            world.setBlockState(pos,state.with(HAS_ANTENNA,true));
        } else {
            if (world.isClient) {
                return ActionResult.SUCCESS;
            }
            if (state.get(ENABLED)) {
                turnOff(state, world, pos);
            } else {
                spawnParticles(world,pos);
                turnOn(state, world, pos);
            }
            world.emitGameEvent(player, state.get(ENABLED) ? GameEvent.BLOCK_ACTIVATE : GameEvent.BLOCK_DEACTIVATE, pos);
        }
        return ActionResult.CONSUME;
    }

    private static void spawnParticles(World world, BlockPos pos) {
        Random random = world.random;
        for (int i = 0; i < 8; i++) {
            world.addParticle(DustParticleEffect.DEFAULT, (double)pos.getX() + (double)random.nextFloat(), (double)pos.getY() + (double)random.nextFloat(), (double)pos.getZ() + (double)random.nextFloat(), 0.0, 0.0, 0.0);
        }
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
        builder.add(HAS_ANTENNA);
        builder.add(ENABLED);
    }
}
