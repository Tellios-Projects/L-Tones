package net.leafenzo.ltones.datageneration;

import net.leafenzo.ltones.block.BlockSet;
import net.leafenzo.ltones.block.ModBlocks;
import net.leafenzo.ltones.registry.tag.ModTags;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends FabricTagProvider<Item> {
    /**
     * Constructs a new {@link FabricTagProvider} with the default computed path.
     *
     * <p>Common implementations of this class are provided.
     *
     * @param output           the {@link FabricDataOutput} instance
     * @param registriesFuture the backing registry for the tag type
     */
    public ModItemTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, Registries.ITEM.getKey(), registriesFuture);
    }
    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        // For Blocksets
        for(BlockSet blockSet : ModBlocks.BLOCKSETS) {
            if(blockSet.itemTag != null) {
                for(Block block : blockSet.blocks) {
                    getOrCreateTagBuilder(blockSet.itemTag).add(block.asItem());
                }
            }
        }

        // Vanilla
        getOrCreateTagBuilder(ModTags.Items.GLASS_PANES)
                .add(Items.GLASS_PANE)
                .add(Items.WHITE_STAINED_GLASS_PANE)
                .add(Items.ORANGE_STAINED_GLASS_PANE)
                .add(Items.MAGENTA_STAINED_GLASS_PANE)
                .add(Items.LIGHT_BLUE_STAINED_GLASS_PANE)
                .add(Items.YELLOW_STAINED_GLASS_PANE)
                .add(Items.LIME_STAINED_GLASS_PANE)
                .add(Items.PINK_STAINED_GLASS_PANE)
                .add(Items.GRAY_STAINED_GLASS_PANE)
                .add(Items.LIGHT_GRAY_STAINED_GLASS_PANE)
                .add(Items.CYAN_STAINED_GLASS_PANE)
                .add(Items.PURPLE_STAINED_GLASS_PANE)
                .add(Items.BLUE_STAINED_GLASS_PANE)
                .add(Items.BROWN_STAINED_GLASS_PANE)
                .add(Items.GREEN_STAINED_GLASS_PANE)
                .add(Items.RED_STAINED_GLASS_PANE)
                .add(Items.BLACK_STAINED_GLASS_PANE)
        ;

        getOrCreateTagBuilder(ModTags.Items.IGNEOUS_ROCKS)
                .add(Items.GRANITE)
                .add(Items.ANDESITE)
                .add(Items.DIORITE)
                .add(Items.BASALT)
        ;

        getOrCreateTagBuilder(ModTags.Items.FIBRE)
                .add(Items.GRASS)
                .add(Items.TALL_GRASS)
                .add(Items.FERN)
                .add(Items.LARGE_FERN)
                .add(Items.SEAGRASS)
                .add(Items.VINE)
                .add(Items.HANGING_ROOTS)
        ;

        getOrCreateTagBuilder(ModTags.Items.MUSHROOMS)
                .add(Items.BROWN_MUSHROOM)
                .add(Items.RED_MUSHROOM)
        ;
    }
}
