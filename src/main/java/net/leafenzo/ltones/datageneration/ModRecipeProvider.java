package net.leafenzo.ltones.datageneration;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.leafenzo.ltones.Super;
import net.leafenzo.ltones.item.ModItems;
import net.leafenzo.ltones.registry.tag.ModTags;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.TagKey;
import org.jetbrains.annotations.Nullable;

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

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        //<- put ZTONE here when that exists
        offerShapelessRecipe(exporter, RecipeCategory.MISC, ModItems.OIL, Items.GLASS_BOTTLE, Items.COAL, 1);
        offerShapelessRecipe(exporter, RecipeCategory.MISC, ModItems.POLYMER, Items.BONE_MEAL, ModItems.OIL, 1);
        offerShapelessRecipe(exporter, RecipeCategory.MISC, ModItems.ARGON, Items.GLASS_BOTTLE, ModTags.Items.IGNEOUS_ROCKS,1);
        offerShapelessRecipe(exporter, RecipeCategory.MISC, ModItems.SLAG, Items.IRON_INGOT, ModItems.OIL, 2);
        offerShapelessRecipe(exporter, RecipeCategory.MISC, ModItems.ANTIBRASS, ModItems.LITHIUM_INGOT, Items.COPPER_INGOT, 2);
        offerShapelessRecipe(exporter, RecipeCategory.MISC, ModItems.DIODE, ModItems.LITHIUM_INGOT, Items.REDSTONE, 1);
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
    }
}

