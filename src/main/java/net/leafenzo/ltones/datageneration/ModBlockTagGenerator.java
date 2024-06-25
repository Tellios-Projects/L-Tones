package net.leafenzo.ltones.datageneration;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.leafenzo.ltones.block.BlockSet;
import net.leafenzo.ltones.block.ModBlocks;
import net.leafenzo.ltones.registry.tag.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
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
        //<editor-fold desc ="BlockTags - Vanilla Blocks">
        getOrCreateTagBuilder(ModTags.Blocks.IGNEOUS_ROCKS)
                .add(Blocks.GRANITE)
                .add(Blocks.ANDESITE)
                .add(Blocks.DIORITE)
                .add(Blocks.BASALT)
        ;
        //</editor-fold
        //<editor-fold desc ="BlockTags - BlockSet Self-tags">
        for(BlockSet blockSet : ModBlocks.BLOCKSETS) {
            if(blockSet.blockTag != null) {
                for(Block block : blockSet.blocks) {
                    getOrCreateTagBuilder(blockSet.blockTag).add(block);
                }
            }
        }
        //</editor-fold
        //<editor-fold desc ="BlockTags - Blockset Specific">
        for(Block block : ModBlocks.AGON_BLOCKS) {
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(block);
        }
        for(Block block : ModBlocks.FORTT_BLOCKS) {
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
        //</editor-fold
        //<editor-fold desc ="BlockTags - Individual Blocks">
        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
            .add(ModBlocks.RAW_LITHIUM_BLOCK)
            .add(ModBlocks.LITHIUM_BLOCK)
            .add(ModBlocks.LITHIUM_ORE)
            .add(ModBlocks.DEEPSLATE_LITHIUM_ORE)
            .add(ModBlocks.ENDSTONE_LITHIUM_ORE)
        ;

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
                .add(ModBlocks.ZTONE)
                .add(ModBlocks.RAW_LITHIUM_BLOCK)
                .add(ModBlocks.LITHIUM_BLOCK)
                .add(ModBlocks.LITHIUM_ORE)
                .add(ModBlocks.DEEPSLATE_LITHIUM_ORE)
                .add(ModBlocks.ENDSTONE_LITHIUM_ORE)
                .add(ModBlocks.TONE)
                .add(ModBlocks.TONE_BRICKS)
                .add(ModBlocks.POLISHED_TONE)
                .add(ModBlocks.ABSTRACT_TONE)
                .add(ModBlocks.FRAMED_TONE)
                .add(ModBlocks.FRAMED_TONE_BRICKS)
                .add(ModBlocks.TIRE)
                .add(ModBlocks.CRATE)
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
        //<editor-fold desc ="BlockTags - Automatic Slabs, Stairs & Doors">
        for(Block block : ModBlocks.SLAB_FROM_BLOCK.values()) {
            getOrCreateTagBuilder(BlockTags.SLABS).add(block);
        }

        for(Block block : ModBlocks.STAIRS_FROM_BLOCK.values()) {
            getOrCreateTagBuilder(BlockTags.STAIRS).add(block);
        }

        for(Block block : ModBlocks.DOORS) {
            getOrCreateTagBuilder(BlockTags.DOORS).add(block);
        }
        //</editor-fold
    }
}

