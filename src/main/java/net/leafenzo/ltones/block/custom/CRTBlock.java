package net.leafenzo.ltones.block.custom;

import net.leafenzo.ltones.block.entity.CRTBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class CRTBlock extends BlockWithEntity {
    public static final DirectionProperty FACING;
    public static final BooleanProperty LIT = Properties.LIT;
    public final SoundEvent turnOnSound;
    public final SoundEvent turnOffSound;

    public CRTBlock(AbstractBlock.Settings settings, @Nullable SoundEvent turnOnSound, @Nullable SoundEvent turnOffSound) {
        super(settings);
        this.turnOnSound = turnOnSound;
        this.turnOffSound = turnOffSound;
        this.setDefaultState(this.getDefaultState().with(LIT, false));
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
        if (state.get(LIT) && !world.isReceivingRedstonePower(pos)) {
            toggleLit(state, world, pos);
        }
    }

    public void toggleLit(BlockState state, World world, BlockPos pos) {
        if(state.get(LIT)) {
            if(turnOffSound != null) world.playSound(null, pos, this.turnOffSound, SoundCategory.BLOCKS, 1.0f, 1.0f);
        }
        else {
            if(turnOnSound != null) world.playSound(null, pos, this.turnOnSound, SoundCategory.BLOCKS, 1.0f, 1.0f);
        }
        world.setBlockState(pos, state.cycle(LIT), Block.NOTIFY_LISTENERS);
    }

    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    static {
        FACING = Properties.HORIZONTAL_FACING;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(HorizontalFacingBlock.FACING);
        builder.add(LIT);
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CRTBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}
