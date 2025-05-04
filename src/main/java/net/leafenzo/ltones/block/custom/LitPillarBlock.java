package net.leafenzo.ltones.block.custom;

import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.SoundEvent;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

public class LitPillarBlock extends LitBlock {
    public static final EnumProperty<Direction.Axis> AXIS = Properties.AXIS;

    public LitPillarBlock(Settings settings, @Nullable SoundEvent turnOnSound, @Nullable SoundEvent turnOffSound, boolean Flickers) {
        super(settings, turnOnSound, turnOffSound, Flickers);
        this.setDefaultState(this.getDefaultState().with(AXIS, Direction.Axis.Y));
    }
    public LitPillarBlock(Settings settings) {
        super(settings, null, null, false);
        this.setDefaultState(this.getDefaultState().with(AXIS, Direction.Axis.Y));
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return PillarBlock.changeRotation(state, rotation);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(AXIS);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(LIT, ctx.getWorld().isReceivingRedstonePower(ctx.getBlockPos())).with(AXIS, ctx.getSide().getAxis());
    }
}
