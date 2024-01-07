package net.leafenzo.ltones.block;


import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.leafenzo.ltones.ModInit;
import net.leafenzo.ltones.Super;
import net.leafenzo.ltones.sound.ModBlockSoundGroup;
import net.leafenzo.ltones.util.ModUtil;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

import java.util.function.ToIntFunction;

public class ModBlocks {
    public static final Block[] ISZM_BLOCKS = registerSetOfColoredBlocks("iszm", FabricBlockSettings.create().strength(0.3f).sounds(BlockSoundGroup.GLASS)); //Glass Screen
    public static final Block[] FORRT_BLOCKS = registerSetOfColoredBlocks("forrt", FabricBlockSettings.create().strength(1.4f).sounds(ModBlockSoundGroup.METAL_STICKS)); //Plastic
    public static final Block[] MYST_BLOCKS = registerSetOfColoredBlocks("myst", FabricBlockSettings.create().strength(0.3f).sounds(BlockSoundGroup.STONE)); //TODO what material is this?
    public static final Block[] ZANE_BLOCKS = registerSetOfColoredBlocks("zane", FabricBlockSettings.create().strength(1.4f).sounds(ModBlockSoundGroup.METAL_STICKS)); //Plastic

//    private static final FabricBlockSettings korpMaterial = FabricBlockSettings.create()
//                    .mapColor(MapColor.TERRACOTTA_BLACK)
//                    .requiresTool()
//                    .strength(4.0f, 6.0f)
//                    .sounds(BlockSoundGroup.METAL);
//    public static final Block[] KORP_BLOCKS = {
//        registerBlock("enchained_korp", new Block(korpMaterial.strength(2.0f, 3.0f))),
//        registerBlock("rough_korp", new Block(korpMaterial.strength(1.6f))),
//        registerBlock("smooth_korp", new Block(korpMaterial.strength(2.0f, 3.0f))),
//        registerBlock("polished_korp", new Block(korpMaterial.strength(2.0f, 3.0f))),
//        registerBlock("korp_vent", new Block(korpMaterial.strength(2.0f, 3.0f))),
//        registerBlock("korp_pillar", new Block(korpMaterial.strength(2.0f, 3.0f))),
//        registerBlock("korp_pillar", new Block(korpMaterial.strength(2.0f, 3.0f))),
//    };

    private static final FabricBlockSettings vectMaterial = FabricBlockSettings.create()
            .mapColor(MapColor.YELLOW)
            .requiresTool()
            .strength(2.4f, 2.0f)
            .sounds(BlockSoundGroup.METAL);
    public static final Block[] VECT_BLOCKS = {
        registerBlock("vect", new Block(vectMaterial)),
        registerBlock("vect_tile", new Block(vectMaterial)),
        registerBlock("vect_rivet", new Block(vectMaterial)),
        registerBlock("vect_hub", new Block(vectMaterial)),
        registerBlock("vect_strut", new Block(vectMaterial)),
        registerBlock("vect_pad", new Block(vectMaterial)),
        registerBlock("vect_tracker", new Block(vectMaterial.mapColor(MapColor.BLACK))),
        registerBlock("vect_core", new Block(vectMaterial.mapColor(MapColor.BLACK))),
        registerBlock("vect_treadplate", new Block(vectMaterial)),
        registerBlock("vect_shield", new Block(vectMaterial)),
        registerBlock("vect_panel", new Block(vectMaterial)),
        registerBlock("vect_radiator", new Block(vectMaterial.mapColor(MapColor.GOLD))),
        registerBlock("vect_bulkhead", new Block(vectMaterial)),
        registerBlock("vect_tank", new Block(vectMaterial.mapColor(MapColor.GOLD).strength(1.8f).sounds(ModBlockSoundGroup.FOIL))),
        registerBlock("vect_network", new Block(vectMaterial.mapColor(MapColor.PALE_YELLOW))),
        registerBlock("vect_foil", new Block(vectMaterial.mapColor(MapColor.GOLD).strength(1.2f).sounds(ModBlockSoundGroup.FOIL))),
    };

    private static final FabricBlockSettings reddsMaterial = FabricBlockSettings.create()
            .mapColor(MapColor.DARK_RED)
            .requiresTool()
            .strength(2.4f, 2.0f)
            .sounds(ModBlockSoundGroup.POLYGON);
    public static final Block[] REDDS_BLOCKS = {
            registerBlock("redds", new LitBlock(reddsMaterial.luminance(createLightLevelFromProperty(1, Properties.LIT)))),
            registerBlock("redds_pice", new LitBlock(reddsMaterial.luminance(createLightLevelFromProperty(1, Properties.LIT)))),
            registerBlock("redds_tract", new LitBlock(reddsMaterial.luminance(createLightLevelFromProperty(1, Properties.LIT)))),
            registerBlock("redds_thought", new LitBlock(reddsMaterial.luminance(createLightLevelFromProperty(1, Properties.LIT)))),
            registerBlock("redds_tile", new LitBlock(reddsMaterial.luminance(createLightLevelFromProperty(1, Properties.LIT)))),
            registerBlock("redds_mark", new LitBlock(reddsMaterial.luminance(createLightLevelFromProperty(1, Properties.LIT)))),
            registerBlock("redds_nexus", new LitBlock(reddsMaterial.luminance(createLightLevelFromProperty(1, Properties.LIT)))),
            registerBlock("redds_tape", new LitPillarBlock(reddsMaterial.luminance(createLightLevelFromProperty(1, Properties.LIT)))),
            registerBlock("redds_grate", new LitBlock(reddsMaterial.luminance(createLightLevelFromProperty(1, Properties.LIT)))),
            registerBlock("redds_heart", new LitBlock(reddsMaterial.luminance(createLightLevelFromProperty(1, Properties.LIT)))),
            registerBlock("redds_hopper", new LitBlock(reddsMaterial.luminance(createLightLevelFromProperty(1, Properties.LIT)))),
            registerBlock("redds_fractal", new LitBlock(reddsMaterial.luminance(createLightLevelFromProperty(1, Properties.LIT)))),
            registerBlock("redds_frame", new LitBlock(reddsMaterial.luminance(createLightLevelFromProperty(1, Properties.LIT)))),
            registerBlock("redds_glazed", new LitGlazedTerracottaBlock(reddsMaterial.luminance(createLightLevelFromProperty(1, Properties.LIT)))),
            registerBlock("redds_balance", new LitBlock(reddsMaterial.luminance(createLightLevelFromProperty(1, Properties.LIT)))),
            registerBlock("redds_current", new LitBlock(reddsMaterial.luminance(createLightLevelFromProperty(1, Properties.LIT)))),
    };
    public static final Block REDDS = REDDS_BLOCKS[0];
    public static final Block REDDS_PICE = REDDS_BLOCKS[1];
    public static final Block REDDS_TRACT = REDDS_BLOCKS[2];
    public static final Block REDDS_THOUGHT = REDDS_BLOCKS[3];
    public static final Block REDDS_TILE = REDDS_BLOCKS[4];
    public static final Block REDDS_MARK = REDDS_BLOCKS[5];
    public static final Block REDDS_NEXUS = REDDS_BLOCKS[6];
    public static final Block REDDS_TAPE = REDDS_BLOCKS[7];
    public static final Block REDDS_GRATE = REDDS_BLOCKS[8];
    public static final Block REDDS_HEART = REDDS_BLOCKS[9];
    public static final Block REDDS_HOPPER = REDDS_BLOCKS[10];
    public static final Block REDDS_FRACTAL = REDDS_BLOCKS[11];
    public static final Block REDDS_FRAME = REDDS_BLOCKS[12];
    public static final Block REDDS_GLAZED = REDDS_BLOCKS[13];
    public static final Block REDDS_BALANCE = REDDS_BLOCKS[14];
    public static final Block REDDS_CURRENT = REDDS_BLOCKS[15];


    public static Block[] registerSetOfColoredBlocks(String name, FabricBlockSettings settings) {
        DyeColor[] colors = ModUtil.VANILLA_DYE_COLORS;
        Block[] blocks = new Block[colors.length];
        for (int i = 0; i < colors.length; i++) {
            DyeColor color = colors[i];
            blocks[i] = registerBlock(color.getName() + "_" + name, new Block(settings.mapColor(color)));
        }
        return blocks;
    }




//    public static class BlockSet {
//        public final String name;
//        public Block[] Blocks;
//
//        public BlockSet(String name, Block[] blocks) {
//            this.name = name;
//            this.Blocks = blocks;
//        }
//    }

//    public static Block registerBlockInBlockSet(BlockSet blockSet, String name, Block block, ItemGroup group) {
//        Block block1 = registerBlock(name, block, group);
//        blockSet.Blocks.add(block1);
//        return block1;
//    }

    public static Block registerBlock(String name, Block block, ItemGroup group) {
        return registerBlock(name, block);
    }

    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name,block);
        return Registry.register(Registries.BLOCK, new Identifier(Super.MOD_ID, name), block);
    }

    private static boolean never(BlockState blockState, BlockView blockView, BlockPos blockPos) {
        return false;
    }

    public static boolean never(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
        return false;
    }

    private static ToIntFunction<BlockState> createLightLevelFromProperty(int litLevel, BooleanProperty property) {
        return state -> state.get(property) != false ? litLevel : 0;
    }

    private static Item registerBlockItem(String name, Block block) {
        BlockItem blockItem = new BlockItem(block, new FabricItemSettings());
        //ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(blockItem));
        return Registry.register(Registries.ITEM, new Identifier(Super.MOD_ID, name), blockItem);
    }

    public static void registerModBlocks() {
        ModInit.LOGGER.debug("Registering mod blocks for " + Super.MOD_ID);
    }
}
