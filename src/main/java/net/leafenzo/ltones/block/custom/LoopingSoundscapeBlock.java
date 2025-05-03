package net.leafenzo.ltones.block.custom;

import net.leafenzo.ltones.block.entity.LoopingSoundscapeBlockEntity;
import net.leafenzo.ltones.block.entity.ModBlockEntityType;
import net.minecraft.block.*;
import net.minecraft.block.entity.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import static net.leafenzo.ltones.block.custom.SoundscapeBlock.LIT;

public class LoopingSoundscapeBlock extends BlockWithEntity {
    public static int delay;
    public static SoundEvent sound;

    public LoopingSoundscapeBlock(Settings settings, SoundEvent loopingSound, int soundDelay) {
        super(settings);
        delay = soundDelay;
        sound = loopingSound;
    }
//TODO: how to make this not static help why is it static how do i make it not static skdgnj sadrgb huearbguiosbdrghseb
    public static void playLoopingSound(World world, BlockPos pos, BlockState state) {
        long l = world.getTime();
        if (l % delay == 0L && state.get(LitBlock.LIT)) {
            world.playSound(null, pos, sound, SoundCategory.BLOCKS, 0.25f, 1.0f);
        }
    }

    @Override
    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(LIT, ctx.getWorld().isReceivingRedstonePower(ctx.getBlockPos()));
    }

    @Override
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return world.isClient ? null : LoopingSoundscapeBlock.checkType(type, ModBlockEntityType.LOOPING_SOUNDSCAPE, LoopingSoundscapeBlockEntity::serverTick);
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
        return new LoopingSoundscapeBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}