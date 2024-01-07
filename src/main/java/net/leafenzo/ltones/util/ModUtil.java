/*
       SOURCES:
       Avetharun - https://github.com/avetharun/herbiary/blob/7017ddbf6d3fd1adddb451dc4b6ccdf93e72a3c3/remappedSrc/com/avetharun/herbiary/hUtil/alib.java#L208
 */

package net.leafenzo.ltones.util;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.random.Random;

import java.util.*;

public class ModUtil {

    public static final DyeColor[] VANILLA_DYE_COLORS = { DyeColor.WHITE, DyeColor.ORANGE, DyeColor.MAGENTA, DyeColor.LIGHT_BLUE, DyeColor.YELLOW, DyeColor.LIME, DyeColor.PINK, DyeColor.GRAY, DyeColor.LIGHT_GRAY, DyeColor.CYAN, DyeColor.PURPLE, DyeColor.BLUE, DyeColor.BROWN, DyeColor.GREEN, DyeColor.RED, DyeColor.BLACK };

//    public static final Block[] WHITE_VANILLA_COLORED_BLOCKS = { Blocks.WHITE_WOOL, Blocks.WHITE_CARPET, Blocks.WHITE_TERRACOTTA, Blocks.WHITE_CONCRETE, Blocks.WHITE_CONCRETE_POWDER, Blocks.WHITE_GLAZED_TERRACOTTA, Blocks.WHITE_STAINED_GLASS, Blocks.WHITE_STAINED_GLASS_PANE, Blocks.WHITE_SHULKER_BOX, Blocks.WHITE_BED, Blocks.WHITE_CANDLE, Blocks.WHITE_BANNER };
//    public static final Block[] ORANGE_VANILLA_COLORED_BLOCKS = { Blocks.ORANGE_WOOL, Blocks.ORANGE_CARPET, Blocks.ORANGE_TERRACOTTA, Blocks.ORANGE_CONCRETE, Blocks.ORANGE_CONCRETE_POWDER, Blocks.ORANGE_GLAZED_TERRACOTTA, Blocks.ORANGE_STAINED_GLASS, Blocks.ORANGE_STAINED_GLASS_PANE, Blocks.ORANGE_SHULKER_BOX, Blocks.ORANGE_BED, Blocks.ORANGE_CANDLE, Blocks.ORANGE_BANNER };
//    public static final Block[] MAGENTA_VANILLA_COLORED_BLOCKS = { Blocks.MAGENTA_WOOL, Blocks.MAGENTA_CARPET, Blocks.MAGENTA_TERRACOTTA, Blocks.MAGENTA_CONCRETE, Blocks.MAGENTA_CONCRETE_POWDER, Blocks.MAGENTA_GLAZED_TERRACOTTA, Blocks.MAGENTA_STAINED_GLASS, Blocks.MAGENTA_STAINED_GLASS_PANE, Blocks.MAGENTA_SHULKER_BOX, Blocks.MAGENTA_BED, Blocks.MAGENTA_CANDLE, Blocks.MAGENTA_BANNER };
//    public static final Block[] LIGHT_BLUE_VANILLA_COLORED_BLOCKS = { Blocks.LIGHT_BLUE_WOOL, Blocks.LIGHT_BLUE_CARPET, Blocks.LIGHT_BLUE_TERRACOTTA, Blocks.LIGHT_BLUE_CONCRETE, Blocks.LIGHT_BLUE_CONCRETE_POWDER, Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA, Blocks.LIGHT_BLUE_STAINED_GLASS, Blocks.LIGHT_BLUE_STAINED_GLASS_PANE, Blocks.LIGHT_BLUE_SHULKER_BOX, Blocks.LIGHT_BLUE_BED, Blocks.LIGHT_BLUE_CANDLE, Blocks.LIGHT_BLUE_BANNER };
//    public static final Block[] YELLOW_VANILLA_COLORED_BLOCKS = { Blocks.YELLOW_WOOL, Blocks.YELLOW_CARPET, Blocks.YELLOW_TERRACOTTA, Blocks.YELLOW_CONCRETE, Blocks.YELLOW_CONCRETE_POWDER, Blocks.YELLOW_GLAZED_TERRACOTTA, Blocks.YELLOW_STAINED_GLASS, Blocks.YELLOW_STAINED_GLASS_PANE, Blocks.YELLOW_SHULKER_BOX, Blocks.YELLOW_BED, Blocks.YELLOW_CANDLE, Blocks.YELLOW_BANNER };
//    public static final Block[] LIME_VANILLA_COLORED_BLOCKS = { Blocks.LIME_WOOL, Blocks.LIME_CARPET, Blocks.LIME_TERRACOTTA, Blocks.LIME_CONCRETE, Blocks.LIME_CONCRETE_POWDER, Blocks.LIME_GLAZED_TERRACOTTA, Blocks.LIME_STAINED_GLASS, Blocks.LIME_STAINED_GLASS_PANE, Blocks.LIME_SHULKER_BOX, Blocks.LIME_BED, Blocks.LIME_CANDLE, Blocks.LIME_BANNER };
//    public static final Block[] PINK_VANILLA_COLORED_BLOCKS = { Blocks.PINK_WOOL, Blocks.PINK_CARPET, Blocks.PINK_TERRACOTTA, Blocks.PINK_CONCRETE, Blocks.PINK_CONCRETE_POWDER, Blocks.PINK_GLAZED_TERRACOTTA, Blocks.PINK_STAINED_GLASS, Blocks.PINK_STAINED_GLASS_PANE, Blocks.PINK_SHULKER_BOX, Blocks.PINK_BED, Blocks.PINK_CANDLE, Blocks.PINK_BANNER };
//    public static final Block[] GRAY_VANILLA_COLORED_BLOCKS = { Blocks.GRAY_WOOL, Blocks.GRAY_CARPET, Blocks.GRAY_TERRACOTTA, Blocks.GRAY_CONCRETE, Blocks.GRAY_CONCRETE_POWDER, Blocks.GRAY_GLAZED_TERRACOTTA, Blocks.GRAY_STAINED_GLASS, Blocks.GRAY_STAINED_GLASS_PANE, Blocks.GRAY_SHULKER_BOX, Blocks.GRAY_BED, Blocks.GRAY_CANDLE, Blocks.GRAY_BANNER };
//    public static final Block[] LIGHT_GRAY_VANILLA_COLORED_BLOCKS = { Blocks.LIGHT_GRAY_WOOL, Blocks.LIGHT_GRAY_CARPET, Blocks.LIGHT_GRAY_TERRACOTTA, Blocks.LIGHT_GRAY_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE_POWDER, Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA, Blocks.LIGHT_GRAY_STAINED_GLASS, Blocks.LIGHT_GRAY_STAINED_GLASS_PANE, Blocks.LIGHT_GRAY_SHULKER_BOX, Blocks.LIGHT_GRAY_BED, Blocks.LIGHT_GRAY_CANDLE, Blocks.LIGHT_GRAY_BANNER };
//    public static final Block[] CYAN_VANILLA_COLORED_BLOCKS = { Blocks.CYAN_WOOL, Blocks.CYAN_CARPET, Blocks.CYAN_TERRACOTTA, Blocks.CYAN_CONCRETE, Blocks.CYAN_CONCRETE_POWDER, Blocks.CYAN_GLAZED_TERRACOTTA, Blocks.CYAN_STAINED_GLASS, Blocks.CYAN_STAINED_GLASS_PANE, Blocks.CYAN_SHULKER_BOX, Blocks.CYAN_BED, Blocks.CYAN_CANDLE, Blocks.CYAN_BANNER };
//    public static final Block[] PURPLE_VANILLA_COLORED_BLOCKS = { Blocks.PURPLE_WOOL, Blocks.PURPLE_CARPET, Blocks.PURPLE_TERRACOTTA, Blocks.PURPLE_CONCRETE, Blocks.PURPLE_CONCRETE_POWDER, Blocks.PURPLE_GLAZED_TERRACOTTA, Blocks.PURPLE_STAINED_GLASS, Blocks.PURPLE_STAINED_GLASS_PANE, Blocks.PURPLE_SHULKER_BOX, Blocks.PURPLE_BED, Blocks.PURPLE_CANDLE, Blocks.PURPLE_BANNER };
//    public static final Block[] BLUE_VANILLA_COLORED_BLOCKS = { Blocks.BLUE_WOOL, Blocks.BLUE_CARPET, Blocks.BLUE_TERRACOTTA, Blocks.BLUE_CONCRETE, Blocks.BLUE_CONCRETE_POWDER, Blocks.BLUE_GLAZED_TERRACOTTA, Blocks.BLUE_STAINED_GLASS, Blocks.BLUE_STAINED_GLASS_PANE, Blocks.BLUE_SHULKER_BOX, Blocks.BLUE_BED, Blocks.BLUE_CANDLE, Blocks.BLUE_BANNER };
//    public static final Block[] BROWN_VANILLA_COLORED_BLOCKS = { Blocks.BROWN_WOOL, Blocks.BROWN_CARPET, Blocks.BROWN_TERRACOTTA, Blocks.BROWN_CONCRETE, Blocks.BROWN_CONCRETE_POWDER, Blocks.BROWN_GLAZED_TERRACOTTA, Blocks.BROWN_STAINED_GLASS, Blocks.BROWN_STAINED_GLASS_PANE, Blocks.BROWN_SHULKER_BOX, Blocks.BROWN_BED, Blocks.BROWN_CANDLE, Blocks.BROWN_BANNER };
//    public static final Block[] GREEN_VANILLA_COLORED_BLOCKS = { Blocks.GREEN_WOOL, Blocks.GREEN_CARPET, Blocks.GREEN_TERRACOTTA, Blocks.GREEN_CONCRETE, Blocks.GREEN_CONCRETE_POWDER, Blocks.GREEN_GLAZED_TERRACOTTA, Blocks.GREEN_STAINED_GLASS, Blocks.GREEN_STAINED_GLASS_PANE, Blocks.GREEN_SHULKER_BOX, Blocks.GREEN_BED, Blocks.GREEN_CANDLE, Blocks.GREEN_BANNER };
//    public static final Block[] RED_VANILLA_COLORED_BLOCKS = { Blocks.RED_WOOL, Blocks.RED_CARPET, Blocks.RED_TERRACOTTA, Blocks.RED_CONCRETE, Blocks.RED_CONCRETE_POWDER, Blocks.RED_GLAZED_TERRACOTTA, Blocks.RED_STAINED_GLASS, Blocks.RED_STAINED_GLASS_PANE, Blocks.RED_SHULKER_BOX, Blocks.RED_BED, Blocks.RED_CANDLE, Blocks.RED_BANNER };
//    public static final Block[] BLACK_VANILLA_COLORED_BLOCKS = { Blocks.BLACK_WOOL, Blocks.BLACK_CARPET, Blocks.BLACK_TERRACOTTA, Blocks.BLACK_CONCRETE, Blocks.BLACK_CONCRETE_POWDER, Blocks.BLACK_GLAZED_TERRACOTTA, Blocks.BLACK_STAINED_GLASS, Blocks.BLACK_STAINED_GLASS_PANE, Blocks.BLACK_SHULKER_BOX, Blocks.BLACK_BED, Blocks.BLACK_CANDLE, Blocks.BLACK_BANNER };
//
//    public static final Block[] WHITE_VANILLA_FUNCTIONAL_BLOCKS = { Blocks.WHITE_SHULKER_BOX, Blocks.WHITE_BED, Blocks.WHITE_CANDLE, Blocks.WHITE_BANNER };
//    public static final Block[] ORANGE_VANILLA_FUNCTIONAL_BLOCKS = { Blocks.ORANGE_SHULKER_BOX, Blocks.ORANGE_BED, Blocks.ORANGE_CANDLE, Blocks.ORANGE_BANNER };
//    public static final Block[] MAGENTA_VANILLA_FUNCTIONAL_BLOCKS = { Blocks.MAGENTA_SHULKER_BOX, Blocks.MAGENTA_BED, Blocks.MAGENTA_CANDLE, Blocks.MAGENTA_BANNER };
//    public static final Block[] LIGHT_BLUE_VANILLA_FUNCTIONAL_BLOCKS = { Blocks.LIGHT_BLUE_SHULKER_BOX, Blocks.LIGHT_BLUE_BED, Blocks.LIGHT_BLUE_CANDLE, Blocks.LIGHT_BLUE_BANNER };
//    public static final Block[] YELLOW_VANILLA_FUNCTIONAL_BLOCKS = { Blocks.YELLOW_SHULKER_BOX, Blocks.YELLOW_BED, Blocks.YELLOW_CANDLE, Blocks.YELLOW_BANNER };
//    public static final Block[] LIME_VANILLA_FUNCTIONAL_BLOCKS = { Blocks.LIME_SHULKER_BOX, Blocks.LIME_BED, Blocks.LIME_CANDLE, Blocks.LIME_BANNER };
//    public static final Block[] PINK_VANILLA_FUNCTIONAL_BLOCKS = { Blocks.PINK_SHULKER_BOX, Blocks.PINK_BED, Blocks.PINK_CANDLE, Blocks.PINK_BANNER };
//    public static final Block[] GRAY_VANILLA_FUNCTIONAL_BLOCKS = { Blocks.GRAY_SHULKER_BOX, Blocks.GRAY_BED, Blocks.GRAY_CANDLE, Blocks.GRAY_BANNER };
//    public static final Block[] LIGHT_GRAY_VANILLA_FUNCTIONAL_BLOCKS = { Blocks.LIGHT_GRAY_SHULKER_BOX, Blocks.LIGHT_GRAY_BED, Blocks.LIGHT_GRAY_CANDLE, Blocks.LIGHT_GRAY_BANNER };
//    public static final Block[] CYAN_VANILLA_FUNCTIONAL_BLOCKS = { Blocks.CYAN_SHULKER_BOX, Blocks.CYAN_BED, Blocks.CYAN_CANDLE, Blocks.CYAN_BANNER };
//    public static final Block[] PURPLE_VANILLA_FUNCTIONAL_BLOCKS = { Blocks.PURPLE_SHULKER_BOX, Blocks.PURPLE_BED, Blocks.PURPLE_CANDLE, Blocks.PURPLE_BANNER };
//    public static final Block[] BLUE_VANILLA_FUNCTIONAL_BLOCKS = { Blocks.BLUE_SHULKER_BOX, Blocks.BLUE_BED, Blocks.BLUE_CANDLE, Blocks.BLUE_BANNER };
//    public static final Block[] BROWN_VANILLA_FUNCTIONAL_BLOCKS = { Blocks.BROWN_SHULKER_BOX, Blocks.BROWN_BED, Blocks.BROWN_CANDLE, Blocks.BROWN_BANNER };
//    public static final Block[] GREEN_VANILLA_FUNCTIONAL_BLOCKS = { Blocks.GREEN_SHULKER_BOX, Blocks.GREEN_BED, Blocks.GREEN_CANDLE, Blocks.GREEN_BANNER };
//    public static final Block[] RED_VANILLA_FUNCTIONAL_BLOCKS = { Blocks.RED_SHULKER_BOX, Blocks.RED_BED, Blocks.RED_CANDLE, Blocks.RED_BANNER };
//    public static final Block[] BLACK_VANILLA_FUNCTIONAL_BLOCKS = { Blocks.BLACK_SHULKER_BOX, Blocks.BLACK_BED, Blocks.BLACK_CANDLE, Blocks.BLACK_BANNER };
//
//    public static Block[] ColoredBlocksOfColor(DyeColor color) {
//        // for vanilla colors
//        switch (color) {
//            case WHITE:
//                return WHITE_VANILLA_COLORED_BLOCKS;
//            case ORANGE:
//                return ORANGE_VANILLA_COLORED_BLOCKS;
//            case MAGENTA:
//                return MAGENTA_VANILLA_COLORED_BLOCKS;
//            case LIGHT_BLUE:
//                return LIGHT_BLUE_VANILLA_COLORED_BLOCKS;
//            case YELLOW:
//                return YELLOW_VANILLA_COLORED_BLOCKS;
//            case LIME:
//                return LIME_VANILLA_COLORED_BLOCKS;
//            case PINK:
//                return PINK_VANILLA_COLORED_BLOCKS;
//            case GRAY:
//                return GRAY_VANILLA_COLORED_BLOCKS;
//            case LIGHT_GRAY:
//                return LIGHT_GRAY_VANILLA_COLORED_BLOCKS;
//            case CYAN:
//                return CYAN_VANILLA_COLORED_BLOCKS;
//            case PURPLE:
//                return PURPLE_VANILLA_COLORED_BLOCKS;
//            case BLUE:
//                return BLUE_VANILLA_COLORED_BLOCKS;
//            case BROWN:
//                return BROWN_VANILLA_COLORED_BLOCKS;
//            case GREEN:
//                return GREEN_VANILLA_COLORED_BLOCKS;
//            case RED:
//                return RED_VANILLA_COLORED_BLOCKS;
//        }
//        return BLACK_VANILLA_COLORED_BLOCKS;
//    }
//    public static Block[] FunctionalBlocksOfColor(DyeColor color) {
//        // for vanilla colors
//        switch (color) {
//            case WHITE:
//                return WHITE_VANILLA_FUNCTIONAL_BLOCKS;
//            case ORANGE:
//                return ORANGE_VANILLA_FUNCTIONAL_BLOCKS;
//            case MAGENTA:
//                return MAGENTA_VANILLA_FUNCTIONAL_BLOCKS;
//            case LIGHT_BLUE:
//                return LIGHT_BLUE_VANILLA_FUNCTIONAL_BLOCKS;
//            case YELLOW:
//                return YELLOW_VANILLA_FUNCTIONAL_BLOCKS;
//            case LIME:
//                return LIME_VANILLA_FUNCTIONAL_BLOCKS;
//            case PINK:
//                return PINK_VANILLA_FUNCTIONAL_BLOCKS;
//            case GRAY:
//                return GRAY_VANILLA_FUNCTIONAL_BLOCKS;
//            case LIGHT_GRAY:
//                return LIGHT_GRAY_VANILLA_FUNCTIONAL_BLOCKS;
//            case CYAN:
//                return CYAN_VANILLA_FUNCTIONAL_BLOCKS;
//            case PURPLE:
//                return PURPLE_VANILLA_FUNCTIONAL_BLOCKS;
//            case BLUE:
//                return BLUE_VANILLA_FUNCTIONAL_BLOCKS;
//            case BROWN:
//                return BROWN_VANILLA_FUNCTIONAL_BLOCKS;
//            case GREEN:
//                return GREEN_VANILLA_FUNCTIONAL_BLOCKS;
//            case RED:
//                return RED_VANILLA_FUNCTIONAL_BLOCKS;
//        }
//        return BLACK_VANILLA_FUNCTIONAL_BLOCKS;
//    }

    public static <T> T[] concat(T[] array1, T[] array2) {
        T[] result = Arrays.copyOf(array1, array1.length + array2.length);
        System.arraycopy(array2, 0, result, array1.length, array2.length);
        return result;
    }

    public static String formatMultipleIdsForErrorLog(Block[] blocks) {
        String s = "{ ";
        for (int i = 0; i < blocks.length; i++) {
            s = s.concat(Registries.BLOCK.getId(blocks[i]).toString());
            if (i != blocks.length - 1) {
                s = s.concat(", ");
            } // if not the last entry
        }
        return s.concat(" }");
    }

    public static String toSentanceCase(String s) {
        String words[] = s.split("[\\s|_]");
        StringBuilder capitalizeWord = new StringBuilder();
        for (String w : words) {
            String first = w.substring(0, 1);
            String afterfirst = w.substring(1);
            capitalizeWord
                    .append(first.toUpperCase())
                    .append(afterfirst)
                    .append(" ");
        }
        return capitalizeWord.toString().trim();
    }


    public static Set<Identifier> allBlockIdsInNamespace(String namespace) {
        Set<Identifier> set = Registries.BLOCK.getIds();
        Set<Identifier> a = new HashSet<>();
        for (Identifier id : set) {
            if (Objects.equals(id.getNamespace(), namespace)) {
                a.add(id);
            }
        }
        return a;
    }

    public static Set<Identifier> allItemIdsInNamespace(String namespace) {
        Set<Identifier> set = Registries.ITEM.getIds();
        Set<Identifier> a = new HashSet<>();
        for (Identifier id : set) {
            if (Objects.equals(id.getNamespace(), namespace)) {
                a.add(id);
            }
        }
        return a;
    }

    public static Set<Identifier> allItemGroupIdsInNamespace(String namespace) {
        Set<Identifier> set = Registries.ITEM_GROUP.getIds();
        Set<Identifier> a = new HashSet<>();
        for (Identifier id : set) {
            if (Objects.equals(id.getNamespace(), namespace)) {
                a.add(id);
            }
        }
        return a;
    }


    /*
          SOURCE:
          Avetharun - https://github.com/avetharun/herbiary/blob/7017ddbf6d3fd1adddb451dc4b6ccdf93e72a3c3/remappedSrc/com/avetharun/herbiary/hUtil/alib.java#L208
    */
    public static ArrayList<Block> allBlocksInTag(TagKey<Block> tag) {
        ArrayList<Block> blocks = new ArrayList<>();
        Optional<RegistryEntryList.Named<Block>> init_BLOCKS = Registries.BLOCK.getEntryList(tag);
        init_BLOCKS.ifPresent(registryEntries -> registryEntries.forEach(entry -> {
            blocks.add(entry.value());
        }));
        return blocks;
    }

    public static Set<Identifier> allPotionIdsInNamespace(String namespace) {
        Set<Identifier> set = Registries.POTION.getIds();
        Set<Identifier> a = new HashSet<>();
        for (Identifier id : set) {
            if (Objects.equals(id.getNamespace(), namespace)) {
                a.add(id);
            }
        }
        return a;
    }

    public static Set<Identifier> allStatusEffectIdsInNamespace(String namespace) {
        Set<Identifier> set = Registries.STATUS_EFFECT.getIds();
        Set<Identifier> a = new HashSet<>();
        for (Identifier id : set) {
            if (Objects.equals(id.getNamespace(), namespace)) {
                a.add(id);
            }
        }
        return a;
    }


}

