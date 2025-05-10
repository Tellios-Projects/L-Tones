package net.leafenzo.ltones.block.custom;

import com.mojang.serialization.MapCodec;
import net.leafenzo.ltones.block.ModBlocks;
import net.leafenzo.ltones.block.entity.ZkulBlockEntity;
import net.leafenzo.ltones.item.ModItems;
import net.leafenzo.ltones.particle.ModParticleTypes;
import net.leafenzo.ltones.sound.ModSoundEvents;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.SculkShriekerBlockEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import net.minecraft.world.explosion.ExplosionBehavior;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class ZkulBlock extends BlockWithEntity {

    public ZkulBlock(Settings settings) {
        super(settings);
    }

    public static final MapCodec<ZkulBlock> CODEC = createCodec(ZkulBlock::new);

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (random.nextInt(20) == 0) {
            world.playSoundAtBlockCenter(pos, ModSoundEvents.BLOCK_ZKUL_AMBIENT, SoundCategory.BLOCKS, 0.25f, (float) (world.getRandom().nextFloat() * 0.2 + 1.0), false);
        }

        // if (random.nextInt(50) == 0) {
        //     world.playSound(((world.getRandom().nextFloat() - 0.5f) * 32) + pos.getX(), ((world.getRandom().nextFloat() - 0.5f) * 32) + pos.getY(), ((world.getRandom().nextFloat() - 0.5f) * 32) + pos.getZ(), SoundEvents.AMBIENT_CAVE.value(), SoundCategory.BLOCKS, 2f, (float) (world.getRandom().nextFloat() * 0.2 + 0.5f), false);
        // }

        for (int i = 0; i < 5; i++) {
            world.addParticle(ModParticleTypes.ZKUL, ((world.getRandom().nextFloat() - 0.5f) * 32) + pos.getX(), ((world.getRandom().nextFloat() - 0.5f) * 32) + pos.getY(), ((world.getRandom().nextFloat() - 0.5f) * 32) + pos.getZ(), 0, 0, 0);
        }
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!(player.isCreative() || player.getStackInHand(Hand.MAIN_HAND).isOf(ModItems.CROWS_BEAK))) {
            this.explode(world, pos);
        } else if (!player.isCreative() && player.getStackInHand(Hand.MAIN_HAND).isOf(ModItems.CROWS_BEAK)) {
            world.removeBlock(pos, false);
            dropStack(world, pos, ModBlocks.ZKUL.getPickStack(world, pos, state));
            for (int i = 0; i < 8; i++) {
                world.addParticle(ModParticleTypes.ZKUL, world.getRandom().nextFloat() + pos.getX(), world.getRandom().nextFloat() + pos.getY(), world.getRandom().nextFloat() + pos.getZ(), 0, 2, 0);
            }
            //player.getStackInHand(Hand.MAIN_HAND).damage(1,player,p -> p.sendToolBreakStatus(Hand.MAIN_HAND));
            world.playSoundAtBlockCenter(pos, ModSoundEvents.BLOCK_ZKUL_OBTAIN, SoundCategory.BLOCKS, 1, world.getRandom().nextFloat() * 0.2f + 0.8f, false);
        } else if (player.isCreative()) {
            world.playSoundAtBlockCenter(pos, ModSoundEvents.BLOCK_ZKUL_BROKEN, SoundCategory.BLOCKS, 1, 0.8f, false);
        }
        super.onBreak(world, pos, state, player);
        return state;
    }

    private boolean hitCooldownActive;

    @Override
    public void onBlockBreakStart(BlockState state, World world, BlockPos pos, PlayerEntity player) {
        if (!player.getStackInHand(Hand.MAIN_HAND).isOf(ModItems.CROWS_BEAK)) {
            world.scheduleBlockTick(pos, state.getBlock(), 60);
            if (world instanceof ServerWorld) {
                ServerPlayerEntity serverPlayerEntity = SculkShriekerBlockEntity.findResponsiblePlayerFromEntity(player);
                if (serverPlayerEntity != null) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 260, 0, false, false));
                }
            }
            if (!hitCooldownActive) {
                hitCooldownActive = true;
                for (int i = 0; i < 50; i++) {
                    world.addParticle(ModParticleTypes.ZKUL, ((world.getRandom().nextFloat() - 0.5f) * 8) + pos.getX(), ((world.getRandom().nextFloat() - 0.5f) * 8) + pos.getY(), ((world.getRandom().nextFloat() - 0.5f) * 8) + pos.getZ(), 0, 0, 0);
                }
                world.playSoundAtBlockCenter(pos, ModSoundEvents.BLOCK_ZKUL_WARN, SoundCategory.BLOCKS, 1, world.getRandom().nextFloat() * 0.2f + 0.8f, false);
            }
        }
        super.onBlockBreakStart(state, world, pos, player);
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        hitCooldownActive = false;
    }

    private void explode(World world, final BlockPos explodedPos) {
        world.playSoundAtBlockCenter(explodedPos, ModSoundEvents.BLOCK_ZKUL_WARN, SoundCategory.BLOCKS, 1, world.getRandom().nextFloat() * 0.2f + 0.5f, false);
        for (int i = 0; i < 50; i++) {
            world.addParticle(ModParticleTypes.ZKUL, ((world.getRandom().nextFloat() - 0.5f) * 8) + explodedPos.getX(), ((world.getRandom().nextFloat() - 0.5f) * 8) + explodedPos.getY(), ((world.getRandom().nextFloat() - 0.5f) * 8) + explodedPos.getZ(), 0, 0, 0);
        }
        world.removeBlock(explodedPos, false);
        ExplosionBehavior explosionBehavior = new ExplosionBehavior() {

            @Override
            public Optional<Float> getBlastResistance(Explosion explosion, BlockView world, BlockPos pos, BlockState blockState, FluidState fluidState) {
                return super.getBlastResistance(explosion, world, pos, blockState, fluidState);
            }
        };
        Vec3d vec3d = explodedPos.toCenterPos();
        world.createExplosion(null, world.getDamageSources().magic(), explosionBehavior, vec3d, 5.0f, true, World.ExplosionSourceType.BLOCK);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ZkulBlockEntity(pos, state); // useful for future
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}