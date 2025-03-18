package net.leafenzo.ltones.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class SoundscapeBlock extends Block {
    public static final BooleanProperty LIT = Properties.LIT;
    public final SoundEvent turnOnSound;
    public final SoundEvent turnOffSound;
    public SoundEvent sound;
    public int soundFrequency;
    public boolean looping;

    public SoundscapeBlock(Settings settings, @Nullable SoundEvent turnOnSound, @Nullable SoundEvent turnOffSound, SoundEvent ambientSound, boolean loopingSound, int ambientSoundFrequency) {
        super(settings);
        this.turnOnSound = turnOnSound;
        this.turnOffSound = turnOffSound;
        this.setDefaultState(this.getDefaultState().with(LIT, false));
        sound = ambientSound;
        looping = loopingSound; // TODO: figure out how the hell to implement this
        soundFrequency = ambientSoundFrequency;
    }

    @Override
    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(LIT, ctx.getWorld().isReceivingRedstonePower(ctx.getBlockPos()));
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (random.nextInt(soundFrequency) == 0 && state.get(LIT)) {
            world.playSoundAtBlockCenter(pos, sound, SoundCategory.BLOCKS, 0.25f, (float) (world.getRandom().nextFloat() * 0.2 + 1.0), false);
        }
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
        if(state.get(LIT).booleanValue()) {
            if(turnOffSound != null) world.playSound(null, pos, this.turnOffSound, SoundCategory.BLOCKS, 1.0f, 1.0f);
        }
        else {
            if(turnOnSound != null) world.playSound(null, pos, this.turnOnSound, SoundCategory.BLOCKS, 1.0f, 1.0f);
        }
        world.setBlockState(pos, state.cycle(LIT), Block.NOTIFY_LISTENERS);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(LIT);
    }

}
