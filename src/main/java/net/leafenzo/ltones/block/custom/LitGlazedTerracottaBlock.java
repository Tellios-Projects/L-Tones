package net.leafenzo.ltones.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.SoundEvent;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import org.jetbrains.annotations.Nullable;

public class LitGlazedTerracottaBlock extends LitBlock {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public LitGlazedTerracottaBlock(Settings settings, @Nullable SoundEvent turnOnSound, @Nullable SoundEvent turnOffSound) {
        super(settings, turnOnSound, turnOffSound);
    }
    public LitGlazedTerracottaBlock(Settings settings) {
        super(settings, null, null);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(FACING);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return (BlockState)state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }
}
