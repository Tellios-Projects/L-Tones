package net.leafenzo.ltones.block.custom;

import net.minecraft.block.*;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class KeyboardBlock extends BasicHorizontalFacingBlock {
    protected static final VoxelShape[] HORIZONTAL_FACING_TO_SHAPE = new VoxelShape[]{
            Block.createCuboidShape(0.0, 0.0, 4.0, 16.0, 2.0, 12.0), // North
            Block.createCuboidShape(0.0, 0.0, 4.0, 16.0, 2.0, 12.0), // South
            Block.createCuboidShape(4.0, 0.0, 0.0, 12.0, 2.0, 16.0), // East
            Block.createCuboidShape(4.0, 0.0, 0.0, 12.0, 2.0, 16.0), // West
    };

    public KeyboardBlock(AbstractBlock.Settings settings) {
        super(settings);
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
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
    }
}
