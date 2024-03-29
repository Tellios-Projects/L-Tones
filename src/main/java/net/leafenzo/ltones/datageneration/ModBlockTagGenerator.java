package net.leafenzo.ltones.datageneration;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.leafenzo.ltones.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends FabricTagProvider<Block> {
    /**
     * Constructs a new {@link FabricTagProvider} with the default computed path.
     *
     * <p>Common implementations of this class are provided.
     *
     * @param output           the {@link FabricDataOutput} instance
     * @param registriesFuture the backing registry for the tag type
     */
    public ModBlockTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, Registries.BLOCK.getKey(), registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        //<editor-fold desc ="BlockTags for Blocksets">
        for(Block block : ModBlocks.AGON_BLOCKS) {
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(block);
        }
        for(Block block : ModBlocks.FORT_BLOCKS) {
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(block);
        }
        for(Block block : ModBlocks.GLAXX_BLOCKS) {
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(block);
        }
        for(Block block : ModBlocks.CRAY_BLOCKS) {
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(block);
        }
        for(Block block : ModBlocks.CAST_BLOCKS) {
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(block);
        }
        for(Block block : ModBlocks.HOST_BLOCKS) {
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(block);
        }
        for(Block block : ModBlocks.ZANE_BLOCKS) {
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(block);
        }
        for(Block block : ModBlocks.VECT_BLOCKS) {
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(block);
        }
        for(Block block : ModBlocks.REDDS_BLOCKS) {
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(block);
        }
        for(Block block : ModBlocks.MINN_BLOCKS) {
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(block);
        }
        for(Block block : ModBlocks.LAIR_BLOCKS) {
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(block);
        }
        for(Block block : ModBlocks.KRYP_BLOCKS) {
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(block);
        }
        for(Block block : ModBlocks.LAVE_BLOCKS) {
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(block);
        }
        for(Block block : ModBlocks.VEELD_BLOCKS) {
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(block);
        }
        for(Block block : ModBlocks.JELT_BLOCKS) {
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(block);
        }
        for(Block block : ModBlocks.TANK_BLOCKS) {
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(block);
        }
        for(Block block : ModBlocks.EXRI_BLOCKS) {
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(block);
        }
        for(Block block : ModBlocks.AZUR_BLOCKS) {
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(block);
        }
        for(Block block : ModBlocks.FLEQ_BLOCKS) {
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(block);
        }
        for(Block block : ModBlocks.NURR_BLOCKS) {
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(block);
        }
        for(Block block : ModBlocks.TYEL_BLOCKS) {
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(block);
        }
        for(Block block : ModBlocks.ROEN_BLOCKS) {
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(block);
        }
        for(Block block : ModBlocks.SOL_BLOCKS) {
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(block);
        }
        //</editor-fold>

        //<editor-fold desc ="BlockTags for Individual Blocks">
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                //.add(ModBlocks.)
             ;

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
        //.add(ModBlocks.)
        ;

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
        //.add(ModBlocks.)
        ;

        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
        //.add(ModBlocks.)
        ;

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
        //.add(ModBlocks.)
        ;

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
        //.add(ModBlocks.)
        ;

        getOrCreateTagBuilder(BlockTags.LEAVES)
        //.add(ModBlocks.)
        ;

        getOrCreateTagBuilder(BlockTags.WOOL)
        //.add(ModBlocks.)
        ;

        getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS)
        //.add(ModBlocks.)
        ;

        getOrCreateTagBuilder(BlockTags.CRYSTAL_SOUND_BLOCKS)
        //.add(ModBlocks.)
        ;

        getOrCreateTagBuilder(BlockTags.INFINIBURN_OVERWORLD)
        //.add(ModBlocks.)
        ;

        getOrCreateTagBuilder(BlockTags.SOUL_FIRE_BASE_BLOCKS)
        //.add(ModBlocks.)
        ;

        getOrCreateTagBuilder(BlockTags.SOUL_SPEED_BLOCKS)
        //.add(ModBlocks.)
        ;

        getOrCreateTagBuilder(BlockTags.WITHER_IMMUNE)
        //.add(ModBlocks.)
        ;

        getOrCreateTagBuilder(BlockTags.GUARDED_BY_PIGLINS)
        //.add(ModBlocks.)
        ;

        getOrCreateTagBuilder(BlockTags.CLIMBABLE)
        //.add(ModBlocks.)
        ;

        getOrCreateTagBuilder(BlockTags.SAND)
        //.add(ModBlocks.)
        ;

        getOrCreateTagBuilder(BlockTags.DIRT)
        //.add(ModBlocks.)
        ;

        getOrCreateTagBuilder(BlockTags.DEAD_BUSH_MAY_PLACE_ON)
        //.add(ModBlocks.)
        ;
        //</editor-fold>
    }
}

