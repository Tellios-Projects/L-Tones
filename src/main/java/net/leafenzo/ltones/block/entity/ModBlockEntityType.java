package net.leafenzo.ltones.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.leafenzo.ltones.ModInit;
import net.leafenzo.ltones.Super;
import net.leafenzo.ltones.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModBlockEntityType {
    public static final BlockEntityType<CrateBlockEntity> CRATE = register(
            "detached_rift",
            CrateBlockEntity::new,
            ModBlocks.CRATE);

    private static <E extends BlockEntity> BlockEntityType<E> register(String id, FabricBlockEntityTypeBuilder.Factory<E> factory, Block... blocks) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Super.MOD_ID + ":" + id, FabricBlockEntityTypeBuilder.create(factory, blocks).build());
    }

    public static void registerModBlockEntityTypes() {
        ModInit.LOGGER.debug("Registering block entity types for " + Super.MOD_ID);
    }
}
