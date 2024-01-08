package net.leafenzo.ltones.block;


import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.leafenzo.ltones.ModInit;
import net.leafenzo.ltones.Super;
import net.leafenzo.ltones.sound.ModBlockSoundGroup;
import net.leafenzo.ltones.sound.ModSoundEvents;
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

import java.util.HashMap;
import java.util.function.ToIntFunction;

public class ModBlocks {
    private static final FabricBlockSettings agonMaterial = FabricBlockSettings.create()
            .strength(0.3f)
            .sounds(ModBlockSoundGroup.NEON)
            .luminance(15);
    public static final HashMap<Block, DyeColor> AGON_BLOCKS = registerHashMapOfColoredBlocks("agon", agonMaterial);

    private static final FabricBlockSettings fortMaterial = FabricBlockSettings.create()
            .strength(1.0f)
            .sounds(ModBlockSoundGroup.METAL_STICKS);
    public static final Block[] FORT_BLOCKS = {
            registerBlock("fort", new Block(fortMaterial.mapColor(MapColor.WHITE_GRAY))),
            registerBlock("bright_blue_fort", new Block(fortMaterial.mapColor(MapColor.BLUE))),
            registerBlock("bright_red_fort", new Block(fortMaterial.mapColor(MapColor.DULL_RED))),
            registerBlock("bright_violet_fort", new Block(fortMaterial.mapColor(MapColor.TERRACOTTA_BLUE))),
            registerBlock("bright_yellow_fort", new Block(fortMaterial.mapColor(MapColor.YELLOW))),
            registerBlock("dark_azure_fort", new Block(fortMaterial.mapColor(MapColor.LAPIS_BLUE))),
            registerBlock("dark_red_fort", new Block(fortMaterial.mapColor(MapColor.RED))),
            registerBlock("dark_turquoise_fort", new Block(fortMaterial.mapColor(MapColor.TEAL))),
            registerBlock("earth_green_fort", new Block(fortMaterial.mapColor(MapColor.DARK_GREEN))),
            registerBlock("earth_orange_fort", new Block(fortMaterial.mapColor(MapColor.TERRACOTTA_ORANGE))),
            registerBlock("gray_fort", new Block(fortMaterial.mapColor(MapColor.IRON_GRAY))),
            registerBlock("lime_fort", new Block(fortMaterial.mapColor(MapColor.LIME))),
            registerBlock("medium_azure_fort", new Block(fortMaterial.mapColor(MapColor.DIAMOND_BLUE))),
            registerBlock("orange_fort", new Block(fortMaterial.mapColor(MapColor.ORANGE))),
            registerBlock("sand_blue_fort", new Block(fortMaterial.mapColor(MapColor.LIGHT_BLUE_GRAY))),
            registerBlock("stone_gray_fort", new Block(fortMaterial.mapColor(MapColor.STONE_GRAY))),
    };

    private static final FabricBlockSettings glaxxMaterial = FabricBlockSettings.create()
            .strength(0.3f)
            .sounds(BlockSoundGroup.STONE) // TODO custom sound
            .nonOpaque()
            .allowsSpawning(ModBlocks::never)
            .solidBlock(ModBlocks::never)
            .suffocates(ModBlocks::never)
            .blockVision(ModBlocks::never);
    public static final Block[] GLAXX_BLOCKS = {
            registerBlock("thyme_glaxx", new GlassBlock(glaxxMaterial.mapColor(MapColor.TERRACOTTA_GREEN))),
            registerBlock("sassafras_glaxx", new GlassBlock(glaxxMaterial.mapColor(MapColor.BLUE))),
            registerBlock("sandalwood_glaxx", new GlassBlock(glaxxMaterial.mapColor(MapColor.IRON_GRAY))),
            registerBlock("sage_glaxx", new GlassBlock(glaxxMaterial.mapColor(MapColor.TERRACOTTA_LIME))),
            registerBlock("rose_glaxx", new GlassBlock(glaxxMaterial.mapColor(MapColor.DULL_PINK))),
            registerBlock("pine_glaxx", new GlassBlock(glaxxMaterial.mapColor(MapColor.SPRUCE_BROWN))),
            registerBlock("mint_glaxx", new GlassBlock(glaxxMaterial.mapColor(MapColor.LICHEN_GREEN))),
            registerBlock("licorice_glaxx", new GlassBlock(glaxxMaterial.mapColor(MapColor.STONE_GRAY))),
            registerBlock("lemon_glaxx", new GlassBlock(glaxxMaterial.mapColor(MapColor.TERRACOTTA_YELLOW))),
            registerBlock("lavender_glaxx", new GlassBlock(glaxxMaterial.mapColor(MapColor.TERRACOTTA_BLUE))),
            registerBlock("incense_glaxx", new GlassBlock(glaxxMaterial.mapColor(MapColor.GRAY))),
            registerBlock("eucalyptus_glaxx", new GlassBlock(glaxxMaterial.mapColor(MapColor.DARK_DULL_PINK))),
            registerBlock("coconut_glaxx", new GlassBlock(glaxxMaterial.mapColor(MapColor.TERRACOTTA_CYAN))),
            registerBlock("cinnimon_glaxx", new GlassBlock(glaxxMaterial.mapColor(MapColor.DARK_CRIMSON))),
            registerBlock("citrus_glaxx", new GlassBlock(glaxxMaterial.mapColor(MapColor.DIRT_BROWN))),
            registerBlock("brine_glaxx", new GlassBlock(glaxxMaterial.mapColor(MapColor.CYAN)))
    };

    private static final FabricBlockSettings crayMaterial = FabricBlockSettings.create()
            .strength(1.0f)
            .requiresTool()
            .sounds(BlockSoundGroup.DECORATED_POT) // perfect
            .nonOpaque();
    public static final Block[] CRAY_BLOCKS = {
            registerBlock("yellow_cray", new Block(crayMaterial.mapColor(MapColor.YELLOW))),
            registerBlock("violet_cray", new Block(crayMaterial.mapColor(MapColor.PURPLE))),
            registerBlock("red_cray", new Block(crayMaterial.mapColor(MapColor.RED))),
            registerBlock("purple_cray", new Block(crayMaterial.mapColor(MapColor.PALE_PURPLE))),
            registerBlock("orange_cray", new Block(crayMaterial.mapColor(MapColor.ORANGE))),
            registerBlock("navy_cray", new Block(crayMaterial.mapColor(MapColor.LIGHT_BLUE))),
            registerBlock("mint_cray", new Block(crayMaterial.mapColor(MapColor.BRIGHT_TEAL))),
            registerBlock("magenta_cray", new Block(crayMaterial.mapColor(MapColor.MAGENTA))),
            registerBlock("lime_cray", new Block(crayMaterial.mapColor(MapColor.LIME))),
            registerBlock("green_cray", new Block(crayMaterial.mapColor(MapColor.EMERALD_GREEN))),
            registerBlock("fuchsia_cray", new Block(crayMaterial.mapColor(MapColor.DULL_PINK))),
            registerBlock("empty_cray", new Block(crayMaterial.mapColor(MapColor.LIGHT_GRAY))),
            registerBlock("cyan_cray", new Block(crayMaterial.mapColor(MapColor.DARK_AQUA))),
            registerBlock("blue_cray", new Block(crayMaterial.mapColor(MapColor.CYAN))),
            registerBlock("amber_cray", new Block(crayMaterial.mapColor(MapColor.OAK_TAN))),
            registerBlock("cray", new Block(crayMaterial.mapColor(MapColor.WHITE_GRAY)))
    };

    private static final FabricBlockSettings castMaterial = FabricBlockSettings.create()
            .strength(1.0f)
            .sounds(ModBlockSoundGroup.METAL_STICKS); // TODO custom plastic sound
    public static final Block[] CAST_BLOCKS = {
            registerBlock("yellow_cast", new Block(castMaterial.mapColor(MapColor.YELLOW))),
            registerBlock("vermilion_cast", new Block(castMaterial.mapColor(MapColor.BRIGHT_RED))),
            registerBlock("velvet_cast", new Block(castMaterial.mapColor(MapColor.DULL_RED))),
            registerBlock("red_cast", new Block(castMaterial.mapColor(MapColor.BRIGHT_RED))),
            registerBlock("purple_cast", new Block(castMaterial.mapColor(MapColor.PURPLE))),
            registerBlock("navy_cast", new Block(castMaterial.mapColor(MapColor.WATER_BLUE))),
            registerBlock("magenta_cast", new Block(castMaterial.mapColor(MapColor.MAGENTA))),
            registerBlock("lime_cast", new Block(castMaterial.mapColor(MapColor.LIME))),
            registerBlock("green_cast", new Block(castMaterial.mapColor(MapColor.EMERALD_GREEN))),
            registerBlock("empty_cast", new Block(castMaterial.mapColor(MapColor.BLACK))),
            registerBlock("cyan_cast", new Block(castMaterial.mapColor(MapColor.CYAN))),
            registerBlock("chartreuse_cast", new Block(castMaterial.mapColor(MapColor.PALE_GREEN))),
            registerBlock("brown_cast", new Block(castMaterial.mapColor(MapColor.TERRACOTTA_ORANGE))),
            registerBlock("blue_cast", new Block(castMaterial.mapColor(MapColor.LAPIS_BLUE))),
            registerBlock("amber_cast", new Block(castMaterial.mapColor(MapColor.TERRACOTTA_YELLOW))),
            registerBlock("cast", new Block(castMaterial.mapColor(MapColor.WHITE)))
    };

    private static final FabricBlockSettings hostMaterial = FabricBlockSettings.create()
            .strength(1.5f)
            .requiresTool()
            .sounds(BlockSoundGroup.COPPER);
    public static final Block[] HOST_BLOCKS = {
            registerBlock("yellow_host", new Block(hostMaterial.mapColor(MapColor.GRAY).luminance(7))),
            registerBlock("violet_host", new Block(hostMaterial.mapColor(MapColor.GRAY).luminance(7))),
            registerBlock("vermilion_host", new Block(hostMaterial.mapColor(MapColor.GRAY).luminance(7))),
            registerBlock("red_host", new Block(hostMaterial.mapColor(MapColor.GRAY).luminance(7))),
            registerBlock("purple_host", new Block(hostMaterial.mapColor(MapColor.GRAY).luminance(7))),
            registerBlock("navy_host", new Block(hostMaterial.mapColor(MapColor.GRAY).luminance(7))),
            registerBlock("mint_host", new Block(hostMaterial.mapColor(MapColor.GRAY).luminance(7))),
            registerBlock("magenta_host", new Block(hostMaterial.mapColor(MapColor.GRAY).luminance(7))),
            registerBlock("lime_host", new Block(hostMaterial.mapColor(MapColor.GRAY).luminance(7))),
            registerBlock("green_host", new Block(hostMaterial.mapColor(MapColor.GRAY).luminance(7))),
            registerBlock("fuchsia_host", new Block(hostMaterial.mapColor(MapColor.GRAY).luminance(7))),
            registerBlock("empty_host", new Block(hostMaterial.mapColor(MapColor.BLACK))),
            registerBlock("cyan_host", new Block(hostMaterial.mapColor(MapColor.GRAY).luminance(7))),
            registerBlock("blue_host", new Block(hostMaterial.mapColor(MapColor.GRAY).luminance(7))),
            registerBlock("amber_host", new Block(hostMaterial.mapColor(MapColor.GRAY).luminance(7))),
            registerBlock("host", new Block(hostMaterial.mapColor(MapColor.GRAY).luminance(3)))
    };

    private static final FabricBlockSettings zaneMaterial = FabricBlockSettings.create()
            .strength(0.75f)
            .requiresTool()
            .sounds(BlockSoundGroup.CALCITE);
    public static final Block[] ZANE_BLOCKS = {
            registerBlock("red_zane", new Block(zaneMaterial.mapColor(MapColor.RED))),
            registerBlock("amber_zane", new Block(zaneMaterial.mapColor(MapColor.TERRACOTTA_ORANGE))),
            registerBlock("empty_zane", new Block(zaneMaterial.mapColor(MapColor.BLACK))),
            registerBlock("orange_zane", new Block(zaneMaterial.mapColor(MapColor.ORANGE))),
            registerBlock("yellow_zane", new Block(zaneMaterial.mapColor(MapColor.YELLOW))),
            registerBlock("purple_zane", new Block(zaneMaterial.mapColor(MapColor.PURPLE))),
            registerBlock("navy_zane", new Block(zaneMaterial.mapColor(MapColor.BLUE))),
            registerBlock("mint_zane", new Block(zaneMaterial.mapColor(MapColor.BRIGHT_TEAL))),
            registerBlock("magenta_zane", new Block(zaneMaterial.mapColor(MapColor.MAGENTA))),
            registerBlock("lime_zane", new Block(zaneMaterial.mapColor(MapColor.LIME))),
            registerBlock("green_zane", new Block(zaneMaterial.mapColor(MapColor.GREEN))),
            registerBlock("fuchsia_zane", new Block(zaneMaterial.mapColor(MapColor.DULL_PINK))),
            registerBlock("cyan_zane", new Block(zaneMaterial.mapColor(MapColor.TEAL))),
            registerBlock("cerulean_zane", new Block(zaneMaterial.mapColor(MapColor.LAPIS_BLUE))),
            registerBlock("blue_zane", new Block(zaneMaterial.mapColor(MapColor.LIGHT_BLUE))),
            registerBlock("zane", new Block(zaneMaterial.mapColor(MapColor.WHITE)))
    };

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
    public static Block VECT = VECT_BLOCKS[0];
    public static Block VECT_TILE = VECT_BLOCKS[1];
    public static Block VECT_RIVET = VECT_BLOCKS[2];
    public static Block VECT_HUB = VECT_BLOCKS[3];
    public static Block VECT_STRUT = VECT_BLOCKS[4];
    public static Block VECT_PAD = VECT_BLOCKS[5];
    public static Block VECT_TRACKER = VECT_BLOCKS[6];
    public static Block VECT_CORE = VECT_BLOCKS[7];
    public static Block VECT_TREADPLATE = VECT_BLOCKS[8];
    public static Block VECT_SHIELD = VECT_BLOCKS[9];
    public static Block VECT_PANEL = VECT_BLOCKS[10];
    public static Block VECT_RADIATOR = VECT_BLOCKS[11];
    public static Block VECT_BULKHEAD = VECT_BLOCKS[12];
    public static Block VECT_TANK = VECT_BLOCKS[13];
    public static Block VECT_NETWORK = VECT_BLOCKS[14];
    public static Block VECT_FOIL = VECT_BLOCKS[15];

    private static final FabricBlockSettings reddsMaterial = FabricBlockSettings.create()
            .mapColor(MapColor.DARK_RED)
            .requiresTool()
            .strength(2.4f, 2.0f)
            .sounds(ModBlockSoundGroup.POLYGON);
    public static final Block[] REDDS_BLOCKS = {
            registerBlock("redds", new LitBlock(reddsMaterial.luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_POLYGON_ACTIVATE, null)),
            registerBlock("redds_pice", new LitBlock(reddsMaterial, null, null)),
            null, // I'm the worst to have ever' done it.
            null,
            registerBlock("redds_tract", new LitBlock(reddsMaterial.luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_POLYGON_ACTIVATE, null)),
            registerBlock("redds_thought", new LitBlock(reddsMaterial.luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_POLYGON_ACTIVATE, null)),
            registerBlock("redds_tile", new LitBlock(reddsMaterial.luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_POLYGON_ACTIVATE, null)),
            registerBlock("redds_mark", new LitBlock(reddsMaterial.luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_POLYGON_ACTIVATE, null)),
            registerBlock("redds_nexus", new LitBlock(reddsMaterial.luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_POLYGON_ACTIVATE, null)),
            registerBlock("redds_tape", new LitPillarBlock(reddsMaterial.luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_POLYGON_ACTIVATE, null)),
            registerBlock("redds_grate", new LitBlock(reddsMaterial.luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_POLYGON_ACTIVATE, null)),
            registerBlock("redds_heart", new LitBlock(reddsMaterial.luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_POLYGON_ACTIVATE, null)),
            registerBlock("redds_hopper", new LitBlock(reddsMaterial.luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_POLYGON_ACTIVATE, null)),
            registerBlock("redds_fractal", new LitBlock(reddsMaterial.luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_POLYGON_ACTIVATE, null)),
            registerBlock("redds_frame", new LitBlock(reddsMaterial.luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_POLYGON_ACTIVATE, null)),
            registerBlock("redds_glazed", new LitGlazedTerracottaBlock(reddsMaterial.luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_POLYGON_ACTIVATE, null)),
            registerBlock("redds_balance", new LitBlock(reddsMaterial.luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_POLYGON_ACTIVATE, null)),
            registerBlock("redds_current", new LitBlock(reddsMaterial.luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_POLYGON_ACTIVATE, null)),
    };
    public static final Block REDDS = REDDS_BLOCKS[0];
    public static final Block REDDS_PICE = REDDS_BLOCKS[1];
    public static final Block REDDS_PICE_SLAB = registerBlock("redds_pice_slab", new LitSlabBlock(FabricBlockSettings.copyOf(REDDS_PICE), null, null));
    static { REDDS_BLOCKS[2] = REDDS_PICE_SLAB;  } //ah, that's where that went.
    public static final Block REDDS_PICE_STAIRS = registerBlock("redds_pice_stairs", new LitStairsBlock(REDDS_PICE.getDefaultState(), FabricBlockSettings.copyOf(REDDS_PICE), null, null));
    static { REDDS_BLOCKS[3] = REDDS_PICE_STAIRS;  }
    public static final Block REDDS_TRACT = REDDS_BLOCKS[4];
    public static final Block REDDS_THOUGHT = REDDS_BLOCKS[5];
    public static final Block REDDS_TILE = REDDS_BLOCKS[6];
    public static final Block REDDS_MARK = REDDS_BLOCKS[7];
    public static final Block REDDS_NEXUS = REDDS_BLOCKS[8];
    public static final Block REDDS_TAPE = REDDS_BLOCKS[9];
    public static final Block REDDS_GRATE = REDDS_BLOCKS[10];
    public static final Block REDDS_HEART = REDDS_BLOCKS[11];
    public static final Block REDDS_HOPPER = REDDS_BLOCKS[12];
    public static final Block REDDS_FRACTAL = REDDS_BLOCKS[13];
    public static final Block REDDS_FRAME = REDDS_BLOCKS[14];
    public static final Block REDDS_GLAZED = REDDS_BLOCKS[15];
    public static final Block REDDS_BALANCE = REDDS_BLOCKS[16];
    public static final Block REDDS_CURRENT = REDDS_BLOCKS[17];


//    public static Block[] registerSetOfColoredBlocks(String name, FabricBlockSettings settings) {
//        DyeColor[] colors = ModUtil.VANILLA_DYE_COLORS;
//        Block[] blocks = new Block[colors.length];
//        for (int i = 0; i < colors.length; i++) {
//            DyeColor color = colors[i];
//            blocks[i] = registerBlock(color.getName() + "_" + name, new Block(settings.mapColor(color)));
//        }
//        return blocks;
//    }
    public static HashMap<Block, DyeColor> registerHashMapOfColoredBlocks(String name, FabricBlockSettings settings) {
        HashMap<Block, DyeColor> hashMap = new HashMap<Block, DyeColor>();
        DyeColor[] colors = ModUtil.VANILLA_DYE_COLORS;
        for (int i = 0; i < colors.length; i++) {
            DyeColor color = colors[i];
            Block block = registerBlock(color.getName() + "_" + name, new Block(settings.mapColor(color)));
            hashMap.put(block, color);
        }
        return hashMap;
    }
//    public static final HashMap<DyeColor, String> AGON_NAME_FROM_COLOR = new HashMap<DyeColor, String>(); static {
//        AGON_NAME_FROM_COLOR.put(DyeColor.WHITE, "sandalwood_agon");
//        AGON_NAME_FROM_COLOR.put(DyeColor.ORANGE, "_agon");
//        AGON_NAME_FROM_COLOR.put(DyeColor.MAGENTA, "_agon");
//        AGON_NAME_FROM_COLOR.put(DyeColor.LIGHT_BLUE, "_agon");
//        AGON_NAME_FROM_COLOR.put(DyeColor.YELLOW, "_agon");
//        AGON_NAME_FROM_COLOR.put(DyeColor.LIME, "_agon");
//        AGON_NAME_FROM_COLOR.put(DyeColor.PINK, "_agon");
//        AGON_NAME_FROM_COLOR.put(DyeColor.GRAY, "_agon");
//        AGON_NAME_FROM_COLOR.put(DyeColor.LIGHT_GRAY, "_agon");
//        AGON_NAME_FROM_COLOR.put(DyeColor.CYAN, "_agon");
//        AGON_NAME_FROM_COLOR.put(DyeColor.PURPLE, "_agon");
//        AGON_NAME_FROM_COLOR.put(DyeColor.BLUE, "_agon");
//        AGON_NAME_FROM_COLOR.put(DyeColor.BROWN, "_agon");
//        AGON_NAME_FROM_COLOR.put(DyeColor.GREEN, "_agon");
//        AGON_NAME_FROM_COLOR.put(DyeColor.RED, "_agon");
//        AGON_NAME_FROM_COLOR.put(DyeColor.BLACK, "_agon");
//    }
//    public static Block[] registerSetOfColoredBlocks(HashMap<DyeColor, String> nameMap, FabricBlockSettings settings) {
//        DyeColor[] colors = ModUtil.VANILLA_DYE_COLORS;
//        Block[] blocks = new Block[colors.length];
//        for (int i = 0; i < colors.length; i++) {
//            DyeColor color = colors[i];
//            blocks[i] = registerBlock(color.getName() + "_" + name, new Block(settings.mapColor(color)));
//        }
//        return blocks;
//    }

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
