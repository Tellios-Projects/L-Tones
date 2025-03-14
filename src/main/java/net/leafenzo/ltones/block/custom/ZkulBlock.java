package net.leafenzo.ltones.block.custom;

import net.leafenzo.ltones.block.entity.ModBlockEntityType;
import net.leafenzo.ltones.block.entity.ZkulBlockEntity;
import net.leafenzo.ltones.particle.ModParticleTypes;
import net.leafenzo.ltones.sound.ModSoundEvents;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.SculkShriekerBlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;

public class ZkulBlock extends BlockWithEntity {

    public ZkulBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (random.nextInt(20) == 0) {
            world.playSoundAtBlockCenter(pos, ModSoundEvents.BLOCK_ZKUL_AMBIENT, SoundCategory.BLOCKS, 0.25f, (float) (world.getRandom().nextFloat() * 0.2 + 1.0), false);
        }

        for (int i = 0; i < 5; i++) {
            world.addParticle(ModParticleTypes.ZKUL, ((world.getRandom().nextFloat() - 0.5f) * 32) + pos.getX(), ((world.getRandom().nextFloat() - 0.5f) * 32) + pos.getY(), ((world.getRandom().nextFloat() - 0.5f) * 32) + pos.getZ(), 0, 0, 0);
        }
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (world instanceof ServerWorld) {
            ServerWorld serverWorld = (ServerWorld)world;
            ServerPlayerEntity serverPlayerEntity = SculkShriekerBlockEntity.findResponsiblePlayerFromEntity(entity);
            if (serverPlayerEntity != null) {
                serverWorld.getBlockEntity(pos, ModBlockEntityType.ZKUL).ifPresent(blockEntity -> blockEntity.darkness(serverWorld, pos));
            }
        }
        super.onSteppedOn(world, pos, state, entity);
    }

    @Override
    public void onBlockBreakStart(BlockState state, World world, BlockPos pos, PlayerEntity player) {
        if (world instanceof ServerWorld) {
            ServerWorld serverWorld = (ServerWorld)world;
            ServerPlayerEntity serverPlayerEntity = SculkShriekerBlockEntity.findResponsiblePlayerFromEntity(player);
            if (serverPlayerEntity != null) {
                serverWorld.getBlockEntity(pos, ModBlockEntityType.ZKUL).ifPresent(blockEntity -> blockEntity.darkness(serverWorld, pos));
            }
        }
        world.playSoundAtBlockCenter(pos, ModSoundEvents.BLOCK_ZKUL_WARN, SoundCategory.BLOCKS, 1, world.getRandom().nextFloat() * 0.2f + 0.8f, false);
        super.onBlockBreakStart(state, world, pos, player);
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof ZkulBlockEntity) {
            ((ZkulBlockEntity)blockEntity).tick();
        }
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state)  {
        return new ZkulBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}