package net.leafenzo.ltones.datageneration;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.leafenzo.ltones.Super;
import net.leafenzo.ltones.block.BlockSet;
import net.leafenzo.ltones.block.ModBlocks;
import net.leafenzo.ltones.item.ModItems;
import net.leafenzo.ltones.registry.tag.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) { super(output); }

    public static String hasTag(TagKey<Item> tag)  {
        return "has_" + tag.id().getPath();
    }

    public static String getRecipePath(ItemConvertible output, ItemConvertible ... inputs) {
        StringBuilder s = new StringBuilder(getItemPath(output));
        for (int i = 0; i < inputs.length; i++) {
            if(i == 0) { s.append("_from_").append(getItemPath(inputs[i])); }
            else { s.append("_and_").append(getItemPath(inputs[i])); }
        }
        return s.toString();
    }

    public static void offerStairsRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        createStairsRecipe(output, Ingredient.ofItems(input))
                .criterion(FabricRecipeProvider.hasItem(input), FabricRecipeProvider.conditionsFromItem(input))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(output)));
    }
    public static void offerSlabRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, output, input);
    }
    public static void offerWallRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, output, input);
    }

    public static void offerShapelessRecipe(Consumer<RecipeJsonProvider> exporter, RecipeCategory recipeCategory, ItemConvertible output, ItemConvertible input, ItemConvertible input2, @Nullable String group, int outputCount) {
        ShapelessRecipeJsonBuilder
                .create(recipeCategory, output, outputCount)
                .input(input)
                .input(input2)
                .group(group)
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter, getRecipePath(output, input, input2));
    }
    public static void offerShapelessRecipe(Consumer<RecipeJsonProvider> exporter, RecipeCategory recipeCategory, ItemConvertible output, ItemConvertible input, ItemConvertible input2, ItemConvertible input3, @Nullable String group, int outputCount) {
        ShapelessRecipeJsonBuilder
                .create(recipeCategory, output, outputCount)
                .input(input)
                .input(input2)
                .input(input3)
                .group(group)
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter, getRecipePath(output, input, input2, input3));
    }
    public static void offerShapelessRecipe(Consumer<RecipeJsonProvider> exporter, RecipeCategory recipeCategory, ItemConvertible output, ItemConvertible input, TagKey<Item> input2, @Nullable String group, int outputCount) {
        ShapelessRecipeJsonBuilder
                .create(recipeCategory, output, outputCount)
                .input(input)
                .input(input2)
                .group(group)
                .criterion(hasItem(input), conditionsFromItem(input))
                .criterion(hasTag(input2), conditionsFromTag(input2))
                .offerTo(exporter, getRecipePath(output, input) + "_and_" + input2.id().getPath());
    }
    public static void offerShapelessRecipe(Consumer<RecipeJsonProvider> exporter, RecipeCategory recipeCategory, ItemConvertible output, TagKey<Item> input, ItemConvertible input2, @Nullable String group, int outputCount) {
        ShapelessRecipeJsonBuilder
                .create(recipeCategory, output, outputCount)
                .input(input)
                .input(input2)
                .group(group)
                .criterion(hasTag(input), conditionsFromTag(input))
                .criterion(hasItem(input2), conditionsFromItem(input2))
                .offerTo(exporter, getRecipePath(output, input2) + "_and_" + input.id().getPath());
    }
    public static void offerShapelessRecipe(Consumer<RecipeJsonProvider> exporter, RecipeCategory recipeCategory, ItemConvertible output,  ItemConvertible input, ItemConvertible input2, int outputCount) {
        offerShapelessRecipe(exporter, recipeCategory, output, input, input2, Super.MOD_ID + output.toString(), outputCount);
    }
    public static void offerShapelessRecipe(Consumer<RecipeJsonProvider> exporter, RecipeCategory recipeCategory, ItemConvertible output,  ItemConvertible input, ItemConvertible input2, ItemConvertible input3, int outputCount) {
        offerShapelessRecipe(exporter, recipeCategory, output, input, input2, input3, Super.MOD_ID + output.toString(), outputCount);
    }
    public static void offerShapelessRecipe(Consumer<RecipeJsonProvider> exporter, RecipeCategory recipeCategory, ItemConvertible output,  ItemConvertible input, TagKey<Item> input2, int outputCount) {
        offerShapelessRecipe(exporter, recipeCategory, output, input, input2, Super.MOD_ID + output.toString(), outputCount);
    }
    public static void offerShapelessRecipe(Consumer<RecipeJsonProvider> exporter, RecipeCategory recipeCategory, ItemConvertible output, TagKey<Item> input, ItemConvertible input2, int outputCount) {
        offerShapelessRecipe(exporter, recipeCategory, output, input, input2, Super.MOD_ID + output.toString(), outputCount);
    }

    public static void offerStonecuttingRecipesForBlockSet(Consumer<RecipeJsonProvider> exporter, RecipeCategory recipeCategory, BlockSet blockSet) {
            //  List<Block> outputs = blockSet.blocks.stream().filter(x -> !ModBlocks.STAIR_FROM_BLOCK.containsKey(x) && !ModBlocks.SLAB_FROM_BLOCK.containsKey(x)).toList();   // Doesn't work
        List<Block> outputs = blockSet.blocks;
        TagKey<Item> inputs = blockSet.itemTag;

        for(ItemConvertible output : outputs) {
            SingleItemRecipeJsonBuilder.createStonecutting(Ingredient.fromTag(inputs), recipeCategory, output, 1)
                    .criterion("has_any_block_from_" + blockSet.name, RecipeProvider.conditionsFromTag(inputs))
                    .offerTo(exporter, RecipeProvider.getItemPath(output) + "_stonecutting");

            if(ModBlocks.SLAB_FROM_BLOCK.get(output) != null) { // if it has a slab
                SingleItemRecipeJsonBuilder.createStonecutting(Ingredient.fromTag(inputs), recipeCategory, ModBlocks.SLAB_FROM_BLOCK.get(output), 2)
                        .criterion("has_any_block_from_" + blockSet.name, RecipeProvider.conditionsFromTag(inputs))
                        .offerTo(exporter, RecipeProvider.getItemPath(ModBlocks.SLAB_FROM_BLOCK.get(output)) + "_stonecutting");
            }

            if(ModBlocks.STAIRS_FROM_BLOCK.get(output) != null) { // if it has stairs
                SingleItemRecipeJsonBuilder.createStonecutting(Ingredient.fromTag(inputs), recipeCategory, ModBlocks.STAIRS_FROM_BLOCK.get(output), 1)
                        .criterion("has_any_block_from_" + blockSet.name, RecipeProvider.conditionsFromTag(inputs))
                        .offerTo(exporter, RecipeProvider.getItemPath(ModBlocks.STAIRS_FROM_BLOCK.get(output)) + "_stonecutting");
            }
        }
    }

    public static void offerStonecuttingRecipes(Consumer<RecipeJsonProvider> exporter, RecipeCategory recipeCategory, ArrayList<Block> outputs, ArrayList<Block> inputs) {
        for (ItemConvertible input : inputs) {
            for (ItemConvertible output : outputs) {
                if(output != input) {
                    offerStonecuttingRecipe(exporter, recipeCategory, output, input, 1);
                }
            }
        }
    }

    public static void offerStonecuttingRecipes(Consumer<RecipeJsonProvider> exporter, RecipeCategory recipeCategory, ArrayList<Block> outputs, ItemConvertible input) {
        for (ItemConvertible output : outputs) {
            offerStonecuttingRecipe(exporter, recipeCategory, output, input, 1);
        }
    }

    public static void offerSurroundedRecipe(Consumer<RecipeJsonProvider> exporter, RecipeCategory recipeCategory, ItemConvertible output, ItemConvertible input1, TagKey<Item> input2, int count) {
        ShapedRecipeJsonBuilder.create(recipeCategory, output, count)
                .pattern("###")
                .pattern("#X#")
                .pattern("###")
                .input('X', input1)
                .input('#', input2)
                .criterion(FabricRecipeProvider.hasItem(input1.asItem()), FabricRecipeProvider.conditionsFromItem(input1))
                .criterion("from_" + input2.id().getPath(), FabricRecipeProvider.conditionsFromTag(input2))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(output)));
    }

    public static void offerSurroundedRecipe(Consumer<RecipeJsonProvider> exporter, RecipeCategory recipeCategory, ItemConvertible output, ItemConvertible input1, ItemConvertible input2, int count) {
        ShapedRecipeJsonBuilder.create(recipeCategory, output, count)
                .pattern("###")
                .pattern("#X#")
                .pattern("###")
                .input('X', input1)
                .input('#', input2)
                .criterion(FabricRecipeProvider.hasItem(input1.asItem()), FabricRecipeProvider.conditionsFromItem(input1))
                .criterion(FabricRecipeProvider.hasItem(input2.asItem()), FabricRecipeProvider.conditionsFromItem(input2))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(output)));
    }

    public static void offer2x2Recipe(Consumer<RecipeJsonProvider> exporter, RecipeCategory recipeCategory, ItemConvertible output, TagKey<Item> input1, int count) {
        ShapedRecipeJsonBuilder.create(recipeCategory, output, count)
                .pattern("##")
                .pattern("##")
                .input('#', input1)
                .criterion("from_" + input1.id().getPath(), FabricRecipeProvider.conditionsFromTag(input1))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(output)));
    }

    public static void offer2x2Recipe(Consumer<RecipeJsonProvider> exporter, RecipeCategory recipeCategory, ItemConvertible output, ItemConvertible input1, int count) {
        ShapedRecipeJsonBuilder.create(recipeCategory, output, count)
                .pattern("##")
                .pattern("##")
                .input('#', input1)
                .criterion(FabricRecipeProvider.hasItem(input1.asItem()), FabricRecipeProvider.conditionsFromItem(input1))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(output)));
    }

    public static void offer2x2CrossRecipe(Consumer<RecipeJsonProvider> exporter, RecipeCategory recipeCategory, ItemConvertible output, ItemConvertible input1, TagKey<Item> input2, int count) {
        ShapedRecipeJsonBuilder.create(recipeCategory, output, count)
                .pattern("XO")
                .pattern("OX")
                .input('X', input1)
                .input('O', input2)
                .criterion(FabricRecipeProvider.hasItem(input1.asItem()), FabricRecipeProvider.conditionsFromItem(input1))
                .criterion("from_" + input2.id().getPath(), FabricRecipeProvider.conditionsFromTag(input2))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(output)));
    }

    // biting the walls of my enclosure
    public static void offer2x2CrossRecipe(Consumer<RecipeJsonProvider> exporter, RecipeCategory recipeCategory, ItemConvertible output, TagKey<Item> input1, ItemConvertible input2, int count) {
        ShapedRecipeJsonBuilder.create(recipeCategory, output, count)
                .pattern("XO")
                .pattern("OX")
                .input('X', input1)
                .input('O', input2)
                .criterion("from_" + input1.id().getPath(), FabricRecipeProvider.conditionsFromTag(input1))
                .criterion(FabricRecipeProvider.hasItem(input2.asItem()), FabricRecipeProvider.conditionsFromItem(input2))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(output)));
    }

    public static void offer2x2CrossRecipe(Consumer<RecipeJsonProvider> exporter, RecipeCategory recipeCategory, ItemConvertible output, ItemConvertible input1, ItemConvertible input2, int count) {
        ShapedRecipeJsonBuilder.create(recipeCategory, output, count)
                    .pattern("XO")
                    .pattern("OX")
                    .input('X', input1)
                    .input('O', input2)
                    .criterion(FabricRecipeProvider.hasItem(input1.asItem()), FabricRecipeProvider.conditionsFromItem(input1))
                    .criterion(FabricRecipeProvider.hasItem(input2.asItem()), FabricRecipeProvider.conditionsFromItem(input2))
                    .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(output)));
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        //<- put ZTONE here when that exists
        offerShapelessRecipe(exporter, RecipeCategory.MISC, ModItems.OIL, Items.GLASS_BOTTLE, Items.COAL, 1);
        offerShapelessRecipe(exporter, RecipeCategory.MISC, ModItems.POLYMER, Items.BONE_MEAL, ModItems.OIL, 1);
        offerShapelessRecipe(exporter, RecipeCategory.MISC, ModItems.ARGON, Items.GLASS_BOTTLE, ModTags.Items.IGNEOUS_ROCKS,1);
        offerShapelessRecipe(exporter, RecipeCategory.MISC, ModItems.SLAG, ModItems.LITHIUM_INGOT, ModItems.OIL, 2);
        offerShapelessRecipe(exporter, RecipeCategory.MISC, ModItems.ANTIBRASS, ModItems.LITHIUM_INGOT, Items.COPPER_INGOT, 2);
        offerShapelessRecipe(exporter, RecipeCategory.MISC, ModItems.DIODE, ModItems.LITHIUM_CHUNK, Items.REDSTONE, 1);
        offerShapelessRecipe(exporter, RecipeCategory.MISC, ModItems.GLEAM, ModItems.LITHIUM_INGOT, Items.GLOWSTONE_DUST, 4);

        offerShapelessRecipe(exporter, RecipeCategory.MISC, ModItems.SCARLET_MEMBRANE, Items.ROTTEN_FLESH, ModItems.OIL,2);
        offerShapelessRecipe(exporter, RecipeCategory.MISC, ModItems.AZURE_RIVET, ModItems.ANTIBRASS, Items.LAPIS_LAZULI, 2);
        offerShapelessRecipe(exporter, RecipeCategory.MISC, ModItems.MIDASIUM, ModItems.LITHIUM_INGOT, Items.GOLD_INGOT,2);
        offerShapelessRecipe(exporter, RecipeCategory.MISC, ModItems.CONDUCTIUM,  ModItems.ANTIBRASS, Items.GOLD_NUGGET, 1);
        offerShapelessRecipe(exporter, RecipeCategory.MISC, ModItems.MOULDING, Items.CLAY_BALL,  Items.BONE_MEAL, ModItems.OIL, 2);
        offerShapelessRecipe(exporter, RecipeCategory.MISC, ModItems.G2V, ModItems.GLEAM, ModItems.OIL,  2);
        offerShapelessRecipe(exporter, RecipeCategory.MISC, ModItems.SCREEN, ModItems.GLEAM, ModItems.DIODE, Items.AMETHYST_SHARD,4);
        offerShapelessRecipe(exporter, RecipeCategory.MISC, ModItems.SHEETING, ModItems.POLYMER, ModItems.DIODE, ModItems.POLYMER,2);
        offerShapelessRecipe(exporter, RecipeCategory.MISC, ModItems.FIBROUS_POWDER, ModItems.SLAG, ModTags.Items.FIBRE,2);
        offerShapelessRecipe(exporter, RecipeCategory.MISC, ModItems.FIBROUS_POWDER, ModItems.SLAG, Items.KELP,2);
        offerShapelessRecipe(exporter, RecipeCategory.MISC, ModItems.THINKING_METAL, ModItems.DIODE,  Items.COPPER_INGOT, ModItems.DIODE,2);
        offerShapelessRecipe(exporter, RecipeCategory.MISC, ModItems.CORPOREAL_VAPOR, Items.AMETHYST_SHARD, ModItems.ARGON, 4);
        offerShapelessRecipe(exporter, RecipeCategory.MISC, ModItems.SHADE, ModItems.GLEAM, ModItems.ARGON,4);
        offerShapelessRecipe(exporter, RecipeCategory.MISC, ModItems.FLAKES, ModItems.ANTIBRASS, Items.QUARTZ,4);
        offerShapelessRecipe(exporter, RecipeCategory.MISC, ModItems.PLAQUE, Items.BONE, ModItems.OIL,4);
        offerShapelessRecipe(exporter, RecipeCategory.MISC, ModItems.ORGANIC_BRASS, ModItems.ANTIBRASS, Items.BAMBOO,1);
        offerShapelessRecipe(exporter, RecipeCategory.MISC, ModItems.AMALGAM, ModItems.SLAG, ModItems.DIODE,2);
        offerShapelessRecipe(exporter, RecipeCategory.MISC, ModItems.PORCELAIN, ModItems.SLAG, Items.CLAY_BALL, 2);
        offerShapelessRecipe(exporter, RecipeCategory.MISC, ModItems.RADIUM_PAINT, Items.BLACKSTONE, ModItems.SLAG,4);
        offerShapelessRecipe(exporter, RecipeCategory.MISC, ModItems.POLYCARBONATE, ModItems.ANTIBRASS, ModItems.POLYMER, 2);
        offerShapelessRecipe(exporter, RecipeCategory.MISC, ModItems.KERBESIUM, ModItems.ANTIBRASS, ModItems.SLAG,2);
        offerShapelessRecipe(exporter, RecipeCategory.MISC, ModItems.GAS_TUBE, ModItems.POLYMER, ModItems.ARGON,2);
        offerShapelessRecipe(exporter, RecipeCategory.MISC, ModItems.NETWORKING, ModTags.Items.MUSHROOMS, ModItems.ARGON,2);
        offerShapelessRecipe(exporter, RecipeCategory.MISC, ModItems.JELLY, Items.SLIME_BALL, ModItems.OIL,2);

        offer2x2CrossRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.AGON_BLOCKS.get(0), Blocks.GLASS, ModItems.ARGON, 4);
        offer2x2CrossRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.FORT_BLOCKS.get(0), ModBlocks.ZTONE, ModItems.POLYCARBONATE, 4);
        offerSurroundedRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LICORICE_GLAXX, ModItems.SHADE, Items.GLASS_PANE, 8);
        offer2x2CrossRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRAY, ModBlocks.ZTONE, ModItems.MOULDING, 4);
        offer2x2Recipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CAST, ModItems.POLYMER, 4);
        offer2x2CrossRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.EMPTY_HOST, ModItems.SLAG, ModItems.NETWORKING, 4);
        offer2x2Recipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ZANE, ModItems.FLAKES, 4);
        offer2x2CrossRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.VECT, ModBlocks.ZTONE, ModItems.KERBESIUM, 4);
        offerSurroundedRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.REDDS, ModItems.THINKING_METAL, ModBlocks.ZTONE, 4);
        offer2x2CrossRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MINN, ModBlocks.ZTONE, ModItems.FIBROUS_POWDER, 4);
        offer2x2CrossRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LAIR, Blocks.NETHERRACK, ModItems.SCARLET_MEMBRANE, 4);
        offer2x2CrossRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.KRYP, ModBlocks.ZTONE, ModItems.CONDUCTIUM, 4);
        offer2x2Recipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LAVE, ModItems.SHEETING, 4);
        offer2x2CrossRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.VEELD, ModBlocks.ZTONE, ModItems.ORGANIC_BRASS,4);
        offer2x2CrossRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.JELT, ModBlocks.ZTONE, ModItems.MIDASIUM,4);
        offer2x2CrossRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.KORP, ModBlocks.ZTONE, ModItems.SLAG,4);
        offer2x2CrossRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.TANK, ModBlocks.ZTONE, ModItems.TAWSINE,4);
        offer2x2CrossRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.EXRI, ModBlocks.ZTONE, ModItems.AMALGAM,4);
        offer2x2CrossRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.AZUR, ModBlocks.ZTONE, ModItems.AZURE_RIVET,4);
        offer2x2CrossRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.FLEQ, ModBlocks.ZTONE, ModItems.JELLY,4);
        offer2x2CrossRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ISZM, Blocks.GLASS, ModItems.SCREEN,4);
        offer2x2Recipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIGHT_GRAY_MYST, ModItems.CORPOREAL_VAPOR, 4);
        offer2x2CrossRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SYNC, ModBlocks.ZTONE, ModItems.RADIUM_PAINT,4);
        offer2x2CrossRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.NURR, ModBlocks.ZTONE, ModItems.GAS_TUBE,4);
        offer2x2CrossRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.TYEL, ModBlocks.ZTONE, ModItems.PORCELAIN,4);
        offer2x2Recipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ROEN, ModItems.PLAQUE,4);
        offer2x2CrossRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOL, ModBlocks.ZTONE, ModItems.G2V,4);

        offerStonecuttingRecipesForBlockSet(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.AGON_BLOCKSET);
        offerStonecuttingRecipesForBlockSet(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.FORT_BLOCKSET);
        offerStonecuttingRecipesForBlockSet(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLAXX_BLOCKSET);
        offerStonecuttingRecipesForBlockSet(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRAY_BLOCKSET);
        offerStonecuttingRecipesForBlockSet(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CAST_BLOCKSET);
        offerStonecuttingRecipesForBlockSet(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.HOST_BLOCKSET);
        offerStonecuttingRecipesForBlockSet(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ZANE_BLOCKSET);
        offerStonecuttingRecipesForBlockSet(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.VECT_BLOCKSET);
        offerStonecuttingRecipesForBlockSet(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.REDDS_BLOCKSET);
        offerStonecuttingRecipesForBlockSet(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MINN_BLOCKSET);
        offerStonecuttingRecipesForBlockSet(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LAIR_BLOCKSET);
        offerStonecuttingRecipesForBlockSet(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.KRYP_BLOCKSET);
        offerStonecuttingRecipesForBlockSet(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LAVE_BLOCKSET);
        offerStonecuttingRecipesForBlockSet(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.VEELD_BLOCKSET);
        offerStonecuttingRecipesForBlockSet(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.JELT_BLOCKSET);
        offerStonecuttingRecipesForBlockSet(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.KORP_BLOCKSET);
        offerStonecuttingRecipesForBlockSet(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.TANK_BLOCKSET);
        offerStonecuttingRecipesForBlockSet(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.EXRI_BLOCKSET);
        offerStonecuttingRecipesForBlockSet(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.AZUR_BLOCKSET);
        offerStonecuttingRecipesForBlockSet(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.FLEQ_BLOCKSET);
        offerStonecuttingRecipesForBlockSet(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ISZM_BLOCKSET);
        offerStonecuttingRecipesForBlockSet(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MYST_BLOCKSET);
        offerStonecuttingRecipesForBlockSet(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SYNC_BLOCKSET);
        offerStonecuttingRecipesForBlockSet(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.NURR_BLOCKSET);
        offerStonecuttingRecipesForBlockSet(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.TYEL_BLOCKSET);
        offerStonecuttingRecipesForBlockSet(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ROEN_BLOCKSET);
        offerStonecuttingRecipesForBlockSet(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOL_BLOCKSET);

        // Automatic Stairs & Slab Recipes
        for (Block block : ModBlocks.STAIRS_FROM_BLOCK.keySet()) {
//            offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.STAIR_FROM_BLOCK.get(block), block, 1); // handled by offerStonecuttingRecipesForBlockSet
            offerStairsRecipe(exporter, ModBlocks.STAIRS_FROM_BLOCK.get(block), block);
        }
        for (Block block : ModBlocks.SLAB_FROM_BLOCK.keySet()) {
//            offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SLAB_FROM_BLOCK.get(block), block, 2);  // handled by offerStonecuttingRecipesForBlockSet
            offerSlabRecipe(exporter, ModBlocks.SLAB_FROM_BLOCK.get(block), block);
        }

//        offerStairsRecipe(exporter, ModBlocks.LAVENDER_BRICK_STAIRS, ModBlocks.LAVENDER_BRICKS);
//        offerSlabRecipe(exporter, ModBlocks.LAVENDER_BRICK_SLAB, ModBlocks.LAVENDER_BRICKS);
//        offerWallRecipe(exporter, ModBlocks.LAVENDER_BRICK_WALL, ModBlocks.LAVENDER_BRICKS);
//        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LAVENDER_BRICK_STAIRS, ModBlocks.LAVENDER_BRICKS);
//        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LAVENDER_BRICK_SLAB, ModBlocks.LAVENDER_BRICKS, 2);
//        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LAVENDER_BRICK_WALL, ModBlocks.LAVENDER_BRICKS);


    }
}

