package net.leafenzo.ltones.block;


import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.leafenzo.ltones.ModInit;
import net.leafenzo.ltones.Super;
import net.leafenzo.ltones.sound.ModBlockSoundGroup;
import net.leafenzo.ltones.sound.ModSoundEvents;
import net.leafenzo.ltones.util.ModUtil;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.ToIntFunction;

public class ModBlocks {

    //<editor-fold desc ="Hashmaps & Arrays">
    // The reason why it's <Block, Block> instead of <Block, StairBlock> is because sometimes there will be block classes that have all the behavior of stair blocks without actually being children of them. This assumption is made for the hashmaps here as well.
    public static final HashMap<Block, Block> STAIR_FROM_BLOCK = new HashMap<Block, Block>();
    public static final HashMap<Block, Block> SLAB_FROM_BLOCK = new HashMap<Block, Block>();

    public static final ArrayList<Block> AGON_BLOCKS = registerBlocksetOfVanillaDyedBlocks("agon", FabricBlockSettings.create().strength(0.3f).sounds(ModBlockSoundGroup.NEON).luminance(state -> 15));
    public static final ArrayList<Block> FORT_BLOCKS = new ArrayList<>();
    public static final ArrayList<Block> GLAXX_BLOCKS = new ArrayList<>();
    public static final ArrayList<Block> CRAY_BLOCKS = new ArrayList<>();
    public static final ArrayList<Block> CAST_BLOCKS = new ArrayList<>();
    public static final ArrayList<Block> HOST_BLOCKS = new ArrayList<>();
    public static final ArrayList<Block> ZANE_BLOCKS = new ArrayList<>();
    public static final ArrayList<Block> VECT_BLOCKS = new ArrayList<>();
    public static final ArrayList<Block> REDDS_BLOCKS = new ArrayList<>();
    public static final ArrayList<Block> MINN_BLOCKS = new ArrayList<>();
    public static final ArrayList<Block> LAIR_BLOCKS = new ArrayList<>();
    public static final ArrayList<Block> KRYP_BLOCKS = new ArrayList<>();
    public static final ArrayList<Block> LAVE_BLOCKS = new ArrayList<>();
    public static final ArrayList<Block> VEELD_BLOCKS = new ArrayList<>();
    public static final ArrayList<Block> JELT_BLOCKS = new ArrayList<>();
    public static final ArrayList<Block> KORP_BLOCKS = new ArrayList<>();
    public static final ArrayList<Block> TANK_BLOCKS = new ArrayList<>();
    public static final ArrayList<Block> EXRI_BLOCKS = new ArrayList<>();
    public static final ArrayList<Block> AZUR_BLOCKS = new ArrayList<>();
    public static final ArrayList<Block> FLEQ_BLOCKS = new ArrayList<>();
    public static final ArrayList<Block> ISZM_BLOCKS = new ArrayList<>();
    public static final ArrayList<Block> MYST_BLOCKS = new ArrayList<>();
    //</editor-fold>

    //<editor-fold desc ="Blocks - FORT">
    private static final FabricBlockSettings fortMaterial = FabricBlockSettings.create()
            .strength(1.0f)
            .sounds(ModBlockSoundGroup.METAL_STICKS);
    public static final Block FORT = registerBlockInBlockset(FORT_BLOCKS, "fort", new Block(fortMaterial.mapColor(MapColor.WHITE_GRAY)));
    public static final Block BRIGHT_BLUE_FORT = registerBlockInBlockset(FORT_BLOCKS, "bright_blue_fort", new Block(fortMaterial.mapColor(MapColor.BLUE)));
    public static final Block BRIGHT_RED_FORT = registerBlockInBlockset(FORT_BLOCKS, "bright_red_fort", new Block(fortMaterial.mapColor(MapColor.DULL_RED)));
    public static final Block BRIGHT_VIOLET_FORT = registerBlockInBlockset(FORT_BLOCKS, "bright_violet_fort", new Block(fortMaterial.mapColor(MapColor.TERRACOTTA_BLUE)));
    public static final Block BRIGHT_YELLOW_FORT = registerBlockInBlockset(FORT_BLOCKS, "bright_yellow_fort", new Block(fortMaterial.mapColor(MapColor.YELLOW)));
    public static final Block DARK_AZURE_FORT = registerBlockInBlockset(FORT_BLOCKS, "dark_azure_fort", new Block(fortMaterial.mapColor(MapColor.LAPIS_BLUE)));
    public static final Block DARK_RED_FORT = registerBlockInBlockset(FORT_BLOCKS, "dark_red_fort", new Block(fortMaterial.mapColor(MapColor.RED)));
    public static final Block DARK_TURQUOISE_FORT = registerBlockInBlockset(FORT_BLOCKS, "dark_turquoise_fort", new Block(fortMaterial.mapColor(MapColor.TEAL)));
    public static final Block EARTH_GREEN_FORT = registerBlockInBlockset(FORT_BLOCKS, "earth_green_fort", new Block(fortMaterial.mapColor(MapColor.DARK_GREEN)));
    public static final Block EARTH_ORANGE_FORT = registerBlockInBlockset(FORT_BLOCKS, "earth_orange_fort", new Block(fortMaterial.mapColor(MapColor.TERRACOTTA_ORANGE)));
    public static final Block GRAY_FORT = registerBlockInBlockset(FORT_BLOCKS, "gray_fort", new Block(fortMaterial.mapColor(MapColor.IRON_GRAY)));
    public static final Block LIME_FORT = registerBlockInBlockset(FORT_BLOCKS, "lime_fort", new Block(fortMaterial.mapColor(MapColor.LIME)));
    public static final Block MEDIUM_AZURE_FORT = registerBlockInBlockset(FORT_BLOCKS, "medium_azure_fort", new Block(fortMaterial.mapColor(MapColor.DIAMOND_BLUE)));
    public static final Block ORANGE_FORT = registerBlockInBlockset(FORT_BLOCKS, "orange_fort", new Block(fortMaterial.mapColor(MapColor.ORANGE)));
    public static final Block SAND_BLUE_FORT = registerBlockInBlockset(FORT_BLOCKS, "sand_blue_fort", new Block(fortMaterial.mapColor(MapColor.LIGHT_BLUE_GRAY)));
    public static final Block STONE_GRAY_FORT = registerBlockInBlockset(FORT_BLOCKS, "stone_gray_fort", new Block(fortMaterial.mapColor(MapColor.STONE_GRAY)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - GLAXX">
    private static final FabricBlockSettings glaxxMaterial = FabricBlockSettings.create()
            .strength(0.3f)
            .sounds(BlockSoundGroup.STONE) // TODO custom sound
            .nonOpaque()
            .allowsSpawning(ModBlocks::never)
            .solidBlock(ModBlocks::never)
            .suffocates(ModBlocks::never)
            .blockVision(ModBlocks::never);
    public static final Block THYME_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "thyme_glaxx", new GlassBlock(glaxxMaterial.mapColor(MapColor.TERRACOTTA_GREEN)));
    public static final Block SASSAFRAS_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "sassafras_glaxx", new GlassBlock(glaxxMaterial.mapColor(MapColor.BLUE)));
    public static final Block SANDALWOOD_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "sandalwood_glaxx", new GlassBlock(glaxxMaterial.mapColor(MapColor.IRON_GRAY)));
    public static final Block SAGE_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "sage_glaxx", new GlassBlock(glaxxMaterial.mapColor(MapColor.TERRACOTTA_LIME)));
    public static final Block ROSE_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "rose_glaxx", new GlassBlock(glaxxMaterial.mapColor(MapColor.DULL_PINK)));
    public static final Block PINE_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "pine_glaxx", new GlassBlock(glaxxMaterial.mapColor(MapColor.SPRUCE_BROWN)));
    public static final Block MINT_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "mint_glaxx", new GlassBlock(glaxxMaterial.mapColor(MapColor.LICHEN_GREEN)));
    public static final Block LICORICE_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "licorice_glaxx", new GlassBlock(glaxxMaterial.mapColor(MapColor.STONE_GRAY)));
    public static final Block LEMON_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "lemon_glaxx", new GlassBlock(glaxxMaterial.mapColor(MapColor.TERRACOTTA_YELLOW)));
    public static final Block LAVENDER_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "lavender_glaxx", new GlassBlock(glaxxMaterial.mapColor(MapColor.TERRACOTTA_BLUE)));
    public static final Block INCENSE_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "incense_glaxx", new GlassBlock(glaxxMaterial.mapColor(MapColor.GRAY)));
    public static final Block EUCALYPTUS_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "eucalyptus_glaxx", new GlassBlock(glaxxMaterial.mapColor(MapColor.DARK_DULL_PINK)));
    public static final Block COCONUT_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "coconut_glaxx", new GlassBlock(glaxxMaterial.mapColor(MapColor.TERRACOTTA_CYAN)));
    public static final Block CINNIMON_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "cinnimon_glaxx", new GlassBlock(glaxxMaterial.mapColor(MapColor.DARK_CRIMSON)));
    public static final Block CITRUS_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "citrus_glaxx", new GlassBlock(glaxxMaterial.mapColor(MapColor.DIRT_BROWN)));
    public static final Block BRINE_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "brine_glaxx", new GlassBlock(glaxxMaterial.mapColor(MapColor.CYAN)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - CRAY">
    private static final FabricBlockSettings crayMaterial = FabricBlockSettings.create()
            .strength(0.8f) // same as sandstone
            .requiresTool()
            .sounds(BlockSoundGroup.DECORATED_POT); // perfect
    public static final Block YELLOW_CRAY = registerBlockInBlockset(CRAY_BLOCKS, "yellow_cray", new Block(crayMaterial.mapColor(MapColor.YELLOW)));
    public static final Block VIOLET_CRAY = registerBlockInBlockset(CRAY_BLOCKS, "violet_cray", new Block(crayMaterial.mapColor(MapColor.PURPLE)));
    public static final Block RED_CRAY = registerBlockInBlockset(CRAY_BLOCKS, "red_cray", new Block(crayMaterial.mapColor(MapColor.RED)));
    public static final Block PURPLE_CRAY = registerBlockInBlockset(CRAY_BLOCKS, "purple_cray", new Block(crayMaterial.mapColor(MapColor.PALE_PURPLE)));
    public static final Block ORANGE_CRAY = registerBlockInBlockset(CRAY_BLOCKS, "orange_cray", new Block(crayMaterial.mapColor(MapColor.ORANGE)));
    public static final Block NAVY_CRAY = registerBlockInBlockset(CRAY_BLOCKS, "navy_cray", new Block(crayMaterial.mapColor(MapColor.LIGHT_BLUE)));
    public static final Block MINT_CRAY = registerBlockInBlockset(CRAY_BLOCKS, "mint_cray", new Block(crayMaterial.mapColor(MapColor.BRIGHT_TEAL)));
    public static final Block MAGENTA_CRAY = registerBlockInBlockset(CRAY_BLOCKS, "magenta_cray", new Block(crayMaterial.mapColor(MapColor.MAGENTA)));
    public static final Block LIME_CRAY = registerBlockInBlockset(CRAY_BLOCKS, "lime_cray", new Block(crayMaterial.mapColor(MapColor.LIME)));
    public static final Block GREEN_CRAY = registerBlockInBlockset(CRAY_BLOCKS, "green_cray", new Block(crayMaterial.mapColor(MapColor.EMERALD_GREEN)));
    public static final Block FUCHSIA_CRAY = registerBlockInBlockset(CRAY_BLOCKS, "fuchsia_cray", new Block(crayMaterial.mapColor(MapColor.DULL_PINK)));
    public static final Block EMPTY_CRAY = registerBlockInBlockset(CRAY_BLOCKS, "empty_cray", new Block(crayMaterial.mapColor(MapColor.LIGHT_GRAY)));
    public static final Block CYAN_CRAY = registerBlockInBlockset(CRAY_BLOCKS, "cyan_cray", new Block(crayMaterial.mapColor(MapColor.DARK_AQUA)));
    public static final Block BLUE_CRAY = registerBlockInBlockset(CRAY_BLOCKS, "blue_cray", new Block(crayMaterial.mapColor(MapColor.CYAN)));
    public static final Block AMBER_CRAY = registerBlockInBlockset(CRAY_BLOCKS, "amber_cray", new Block(crayMaterial.mapColor(MapColor.OAK_TAN)));
    public static final Block CRAY = registerBlockInBlockset(CRAY_BLOCKS, "cray", new Block(crayMaterial.mapColor(MapColor.WHITE_GRAY)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - CAST">
    private static final FabricBlockSettings castMaterial = FabricBlockSettings.create()
            .strength(1.0f)
            .sounds(ModBlockSoundGroup.METAL_STICKS); // TODO custom plastic sound
    public static final Block YELLOW_CAST = registerBlockInBlockset(CAST_BLOCKS, "yellow_cast", new Block(castMaterial.mapColor(MapColor.YELLOW)));
    public static final Block VERMILION_CAST = registerBlockInBlockset(CAST_BLOCKS, "vermilion_cast", new Block(castMaterial.mapColor(MapColor.BRIGHT_RED)));
    public static final Block VELVET_CAST = registerBlockInBlockset(CAST_BLOCKS, "velvet_cast", new Block(castMaterial.mapColor(MapColor.DULL_RED)));
    public static final Block RED_CAST = registerBlockInBlockset(CAST_BLOCKS, "red_cast", new Block(castMaterial.mapColor(MapColor.BRIGHT_RED)));
    public static final Block PURPLE_CAST = registerBlockInBlockset(CAST_BLOCKS, "purple_cast", new Block(castMaterial.mapColor(MapColor.PURPLE)));
    public static final Block NAVY_CAST = registerBlockInBlockset(CAST_BLOCKS, "navy_cast", new Block(castMaterial.mapColor(MapColor.WATER_BLUE)));
    public static final Block MAGENTA_CAST = registerBlockInBlockset(CAST_BLOCKS, "magenta_cast", new Block(castMaterial.mapColor(MapColor.MAGENTA)));
    public static final Block LIME_CAST = registerBlockInBlockset(CAST_BLOCKS, "lime_cast", new Block(castMaterial.mapColor(MapColor.LIME)));
    public static final Block GREEN_CAST = registerBlockInBlockset(CAST_BLOCKS, "green_cast", new Block(castMaterial.mapColor(MapColor.EMERALD_GREEN)));
    public static final Block EMPTY_CAST = registerBlockInBlockset(CAST_BLOCKS, "empty_cast", new Block(castMaterial.mapColor(MapColor.BLACK)));
    public static final Block CYAN_CAST = registerBlockInBlockset(CAST_BLOCKS, "cyan_cast", new Block(castMaterial.mapColor(MapColor.CYAN)));
    public static final Block CHARTREUSE_CAST = registerBlockInBlockset(CAST_BLOCKS, "chartreuse_cast", new Block(castMaterial.mapColor(MapColor.PALE_GREEN)));
    public static final Block BROWN_CAST = registerBlockInBlockset(CAST_BLOCKS, "brown_cast", new Block(castMaterial.mapColor(MapColor.TERRACOTTA_ORANGE)));
    public static final Block BLUE_CAST = registerBlockInBlockset(CAST_BLOCKS, "blue_cast", new Block(castMaterial.mapColor(MapColor.LAPIS_BLUE)));
    public static final Block AMBER_CAST = registerBlockInBlockset(CAST_BLOCKS, "amber_cast", new Block(castMaterial.mapColor(MapColor.TERRACOTTA_YELLOW)));
    public static final Block CAST = registerBlockInBlockset(CAST_BLOCKS, "cast", new Block(castMaterial.mapColor(MapColor.WHITE)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - HOST">
    private static final FabricBlockSettings hostMaterial = FabricBlockSettings.create()
            .strength(1.5f)
            .requiresTool()
            .sounds(BlockSoundGroup.COPPER);
    public static final Block YELLOW_HOST = registerBlockInBlockset(HOST_BLOCKS, "yellow_host", new Block(hostMaterial.mapColor(MapColor.GRAY).luminance(state -> 7)));
    public static final Block VIOLET_HOST = registerBlockInBlockset(HOST_BLOCKS, "violet_host", new Block(hostMaterial.mapColor(MapColor.GRAY).luminance(state -> 7)));
    public static final Block VERMILION_HOST = registerBlockInBlockset(HOST_BLOCKS, "vermilion_host", new Block(hostMaterial.mapColor(MapColor.GRAY).luminance(state -> 7)));
    public static final Block RED_HOST = registerBlockInBlockset(HOST_BLOCKS, "red_host", new Block(hostMaterial.mapColor(MapColor.GRAY).luminance(state -> 7)));
    public static final Block PURPLE_HOST = registerBlockInBlockset(HOST_BLOCKS, "purple_host", new Block(hostMaterial.mapColor(MapColor.GRAY).luminance(state -> 7)));
    public static final Block NAVY_HOST = registerBlockInBlockset(HOST_BLOCKS, "navy_host", new Block(hostMaterial.mapColor(MapColor.GRAY).luminance(state -> 7)));
    public static final Block MINT_HOST = registerBlockInBlockset(HOST_BLOCKS, "mint_host", new Block(hostMaterial.mapColor(MapColor.GRAY).luminance(state -> 7)));
    public static final Block MAGENTA_HOST = registerBlockInBlockset(HOST_BLOCKS, "magenta_host", new Block(hostMaterial.mapColor(MapColor.GRAY).luminance(state -> 7)));
    public static final Block LIME_HOST = registerBlockInBlockset(HOST_BLOCKS, "lime_host", new Block(hostMaterial.mapColor(MapColor.GRAY).luminance(state -> 7)));
    public static final Block GREEN_HOST = registerBlockInBlockset(HOST_BLOCKS, "green_host", new Block(hostMaterial.mapColor(MapColor.GRAY).luminance(state -> 7)));
    public static final Block FUCHSIA_HOST = registerBlockInBlockset(HOST_BLOCKS, "fuchsia_host", new Block(hostMaterial.mapColor(MapColor.GRAY).luminance(state -> 7)));
    public static final Block EMPTY_HOST = registerBlockInBlockset(HOST_BLOCKS, "empty_host", new Block(hostMaterial.mapColor(MapColor.BLACK)));
    public static final Block CYAN_HOST = registerBlockInBlockset(HOST_BLOCKS, "cyan_host", new Block(hostMaterial.mapColor(MapColor.GRAY).luminance(state -> 7)));
    public static final Block BLUE_HOST = registerBlockInBlockset(HOST_BLOCKS, "blue_host", new Block(hostMaterial.mapColor(MapColor.GRAY).luminance(state -> 7)));
    public static final Block AMBER_HOST = registerBlockInBlockset(HOST_BLOCKS, "amber_host", new Block(hostMaterial.mapColor(MapColor.GRAY).luminance(state -> 7)));
    public static final Block HOST = registerBlockInBlockset(HOST_BLOCKS, "host", new Block(hostMaterial.mapColor(MapColor.GRAY).luminance(state -> 3)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - ZANE">
    private static final FabricBlockSettings zaneMaterial = FabricBlockSettings.create()
            .strength(0.75f)
            .requiresTool()
            .instrument(Instrument.BASEDRUM)
            .sounds(BlockSoundGroup.CALCITE);
    public static final Block RED_ZANE = registerBlockInBlockset(ZANE_BLOCKS, "red_zane", new Block(zaneMaterial.mapColor(MapColor.RED)));
    public static final Block AMBER_ZANE = registerBlockInBlockset(ZANE_BLOCKS, "amber_zane", new Block(zaneMaterial.mapColor(MapColor.TERRACOTTA_ORANGE)));
    public static final Block EMPTY_ZANE = registerBlockInBlockset(ZANE_BLOCKS, "empty_zane", new Block(zaneMaterial.mapColor(MapColor.BLACK)));
    public static final Block ORANGE_ZANE = registerBlockInBlockset(ZANE_BLOCKS, "orange_zane", new Block(zaneMaterial.mapColor(MapColor.ORANGE)));
    public static final Block YELLOW_ZANE = registerBlockInBlockset(ZANE_BLOCKS, "yellow_zane", new Block(zaneMaterial.mapColor(MapColor.YELLOW)));
    public static final Block PURPLE_ZANE = registerBlockInBlockset(ZANE_BLOCKS, "purple_zane", new Block(zaneMaterial.mapColor(MapColor.PURPLE)));
    public static final Block NAVY_ZANE = registerBlockInBlockset(ZANE_BLOCKS, "navy_zane", new Block(zaneMaterial.mapColor(MapColor.BLUE)));
    public static final Block MINT_ZANE = registerBlockInBlockset(ZANE_BLOCKS, "mint_zane", new Block(zaneMaterial.mapColor(MapColor.BRIGHT_TEAL)));
    public static final Block MAGENTA_ZANE = registerBlockInBlockset(ZANE_BLOCKS, "magenta_zane", new Block(zaneMaterial.mapColor(MapColor.MAGENTA)));
    public static final Block LIME_ZANE = registerBlockInBlockset(ZANE_BLOCKS, "lime_zane", new Block(zaneMaterial.mapColor(MapColor.LIME)));
    public static final Block GREEN_ZANE = registerBlockInBlockset(ZANE_BLOCKS, "green_zane", new Block(zaneMaterial.mapColor(MapColor.GREEN)));
    public static final Block FUCHSIA_ZANE = registerBlockInBlockset(ZANE_BLOCKS, "fuchsia_zane", new Block(zaneMaterial.mapColor(MapColor.DULL_PINK)));
    public static final Block CYAN_ZANE = registerBlockInBlockset(ZANE_BLOCKS, "cyan_zane", new Block(zaneMaterial.mapColor(MapColor.TEAL)));
    public static final Block CERULEAN_ZANE = registerBlockInBlockset(ZANE_BLOCKS, "cerulean_zane", new Block(zaneMaterial.mapColor(MapColor.LAPIS_BLUE)));
    public static final Block BLUE_ZANE = registerBlockInBlockset(ZANE_BLOCKS, "blue_zane", new Block(zaneMaterial.mapColor(MapColor.LIGHT_BLUE)));
    public static final Block ZANE = registerBlockInBlockset(ZANE_BLOCKS, "zane", new Block(zaneMaterial.mapColor(MapColor.WHITE)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - VECT">
    private static final FabricBlockSettings vectMaterial = FabricBlockSettings.create()
            .mapColor(MapColor.YELLOW)
            .requiresTool()
            .strength(2.4f, 2.0f)
            .sounds(BlockSoundGroup.METAL);
    public static final Block VECT = registerBlockInBlockset(VECT_BLOCKS, "vect", new Block(vectMaterial));
    public static final Block VECT_TILE = registerBlockInBlockset(VECT_BLOCKS, "vect_tile", new Block(vectMaterial));
    public static final Block VECT_RIVET = registerBlockInBlockset(VECT_BLOCKS, "vect_rivet", new Block(vectMaterial));
    public static final Block VECT_HUB = registerBlockInBlockset(VECT_BLOCKS, "vect_hub", new Block(vectMaterial));
    public static final Block VECT_STRUT = registerBlockInBlockset(VECT_BLOCKS, "vect_strut", new PillarBlock(vectMaterial));
    public static final Block VECT_PAD = registerBlockInBlockset(VECT_BLOCKS, "vect_pad", new ReversiblePillarBlock(vectMaterial));
    public static final Block VECT_TRACKER = registerBlockInBlockset(VECT_BLOCKS, "vect_tracker", new Block(vectMaterial.mapColor(MapColor.BLACK)));
    public static final Block VECT_CORE = registerBlockInBlockset(VECT_BLOCKS, "vect_core", new Block(vectMaterial.mapColor(MapColor.BLACK)));
    public static final Block VECT_TREADPLATE = registerBlockInBlockset(VECT_BLOCKS, "vect_treadplate", new Block(vectMaterial));
    public static final Block VECT_SHIELD = registerBlockInBlockset(VECT_BLOCKS, "vect_shield", new PillarBlock(vectMaterial));
    public static final Block VECT_PANEL = registerBlockInBlockset(VECT_BLOCKS, "vect_panel", new Block(vectMaterial));
    public static final Block VECT_RADIATOR = registerBlockInBlockset(VECT_BLOCKS, "vect_radiator", new Block(vectMaterial.mapColor(MapColor.GOLD)));
    public static final Block VECT_BULKHEAD = registerBlockInBlockset(VECT_BLOCKS, "vect_bulkhead", new PillarBlock(vectMaterial));
    public static final Block VECT_TANK = registerBlockInBlockset(VECT_BLOCKS, "vect_tank", new Block(vectMaterial.mapColor(MapColor.GOLD).strength(1.8f).sounds(ModBlockSoundGroup.FOIL)));
    public static final Block VECT_NETWORK = registerBlockInBlockset(VECT_BLOCKS, "vect_network", new Block(vectMaterial.mapColor(MapColor.PALE_YELLOW)));
    public static final Block VECT_FOIL = registerBlockInBlockset(VECT_BLOCKS, "vect_foil", new Block(vectMaterial.mapColor(MapColor.GOLD).strength(1.2f).sounds(ModBlockSoundGroup.FOIL)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - REDDS">
    private static final FabricBlockSettings reddsMaterial = FabricBlockSettings.create()
            .mapColor(MapColor.DARK_RED)
            .requiresTool()
            .strength(2.4f, 2.0f)
            .sounds(ModBlockSoundGroup.POLYGON);
    public static final Block REDDS = registerBlockInBlockset(REDDS_BLOCKS, "redds", new LitBlock(reddsMaterial.luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_POLYGON_ACTIVATE, null));
    public static final Block REDDS_PICE = registerBlockInBlockset(REDDS_BLOCKS, "redds_pice", new LitBlock(reddsMaterial, null, null));
    public static final Block REDDS_PICE_SLAB = registerBlock("redds_pice_slab", new LitSlabBlock(FabricBlockSettings.copyOf(REDDS_PICE), null, null)); static { SLAB_FROM_BLOCK.put(REDDS_PICE, REDDS_PICE_SLAB); }
    public static final Block REDDS_PICE_STAIRS = registerBlock("redds_pice_stairs", new LitStairsBlock(REDDS_PICE.getDefaultState(), FabricBlockSettings.copyOf(REDDS_PICE), null, null)); static { STAIR_FROM_BLOCK.put(REDDS_PICE, REDDS_PICE_STAIRS); }
    public static final Block REDDS_TRACT = registerBlockInBlockset(REDDS_BLOCKS, "redds_tract", new LitBlock(reddsMaterial.luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_POLYGON_ACTIVATE, null));
    public static final Block REDDS_THOUGHT = registerBlockInBlockset(REDDS_BLOCKS, "redds_thought", new LitBlock(reddsMaterial.luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_POLYGON_ACTIVATE, null));
    public static final Block REDDS_TILE = registerBlockInBlockset(REDDS_BLOCKS, "redds_tile", new LitBlock(reddsMaterial.luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_POLYGON_ACTIVATE, null));
    public static final Block REDDS_MARK = registerBlockInBlockset(REDDS_BLOCKS, "redds_mark", new LitBlock(reddsMaterial.luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_POLYGON_ACTIVATE, null));
    public static final Block REDDS_NEXUS = registerBlockInBlockset(REDDS_BLOCKS, "redds_nexus", new LitBlock(reddsMaterial.luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_POLYGON_ACTIVATE, null));
    public static final Block REDDS_TAPE = registerBlockInBlockset(REDDS_BLOCKS, "redds_tape", new LitPillarBlock(reddsMaterial.luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_POLYGON_ACTIVATE, null));
    public static final Block REDDS_GRATE = registerBlockInBlockset(REDDS_BLOCKS, "redds_grate", new LitBlock(reddsMaterial.luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_POLYGON_ACTIVATE, null));
    public static final Block REDDS_HEART = registerBlockInBlockset(REDDS_BLOCKS, "redds_heart", new LitBlock(reddsMaterial.luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_POLYGON_ACTIVATE, null));
    public static final Block REDDS_HOPPER = registerBlockInBlockset(REDDS_BLOCKS, "redds_hopper", new LitBlock(reddsMaterial.luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_POLYGON_ACTIVATE, null));
    public static final Block REDDS_FRACTAL = registerBlockInBlockset(REDDS_BLOCKS, "redds_fractal", new LitBlock(reddsMaterial.luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_POLYGON_ACTIVATE, null));
    public static final Block REDDS_FRAME = registerBlockInBlockset(REDDS_BLOCKS, "redds_frame", new LitBlock(reddsMaterial.luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_POLYGON_ACTIVATE, null));
    public static final Block REDDS_GLAZED = registerBlockInBlockset(REDDS_BLOCKS, "redds_glazed", new LitGlazedTerracottaBlock(reddsMaterial.luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_POLYGON_ACTIVATE, null));
    public static final Block REDDS_BALANCE = registerBlockInBlockset(REDDS_BLOCKS, "redds_balance", new LitBlock(reddsMaterial.luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_POLYGON_ACTIVATE, null));
    public static final Block REDDS_CURRENT = registerBlockInBlockset(REDDS_BLOCKS, "redds_current", new LitBlock(reddsMaterial.luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_POLYGON_ACTIVATE, null));
    //</editor-fold>
    //<editor-fold desc ="Blocks - MINN">
    private static final FabricBlockSettings minnMaterial = FabricBlockSettings.create()
            .mapColor(MapColor.PALE_GREEN)
            .requiresTool()
            .strength(2.4f, 2.0f)
            .sounds(ModBlockSoundGroup.POLYGON);
    public static final Block MINN_TILES = registerBlockInBlockset(MINN_BLOCKS, "minn_tiles", new Block(minnMaterial));
    public static final Block MINN_RESONANCE = registerBlockInBlockset(MINN_BLOCKS, "minn_resonance", new Block(minnMaterial));
    public static final Block MINN_QUILT = registerBlockInBlockset(MINN_BLOCKS, "minn_quilt", new Block(minnMaterial));
    public static final Block MINN_POFFNODE = registerBlockInBlockset(MINN_BLOCKS, "minn_poffnode", new Block(minnMaterial));
    public static final Block MINN_POFFCAGE = registerBlockInBlockset(MINN_BLOCKS, "minn_poffcage", new Block(minnMaterial));
    public static final Block MINN_POFF = registerBlockInBlockset(MINN_BLOCKS, "minn_poff", new Block(minnMaterial));
    public static final Block MINN_PAD = registerBlockInBlockset(MINN_BLOCKS, "minn_pad", new Block(minnMaterial));
    public static final Block MINN_NEXUS = registerBlockInBlockset(MINN_BLOCKS, "minn_nexus", new Block(minnMaterial));
    public static final Block MINN_LINENODE = registerBlockInBlockset(MINN_BLOCKS, "minn_linenode", new Block(minnMaterial));
    public static final Block MINN_LINE = registerBlockInBlockset(MINN_BLOCKS, "minn_line", new PillarBlock(minnMaterial));
    public static final Block MINN_CIRCLE = registerBlockInBlockset(MINN_BLOCKS, "minn_circle", new Block(minnMaterial));
    public static final Block MINN_CAGE = registerBlockInBlockset(MINN_BLOCKS, "minn_cage", new Block(minnMaterial));
    public static final Block MINN_CUBES = registerBlockInBlockset(MINN_BLOCKS, "minn_cubes", new Block(minnMaterial));
    public static final Block MINN_BLANK = registerBlockInBlockset(MINN_BLOCKS, "minn_blank", new Block(minnMaterial));
    public static final Block MINN_BEVEL = registerBlockInBlockset(MINN_BLOCKS, "minn_bevel", new Block(minnMaterial));
    public static final Block MINN = registerBlockInBlockset(MINN_BLOCKS, "minn", new Block(minnMaterial));
    //</editor-fold>
    //<editor-fold desc ="Blocks - LAIR">
    private static final FabricBlockSettings lairMaterial = FabricBlockSettings.create()
            .mapColor(MapColor.RAW_IRON_PINK)
            .requiresTool()
            .strength(0.75f)
            .instrument(Instrument.BASEDRUM)
            .sounds(ModBlockSoundGroup.LAIR);
    public static final Block LAIR_STRUT = registerBlockInBlockset(LAIR_BLOCKS, "lair_strut", new Block(lairMaterial)); 
    public static final Block LAIR_SMOOTH = registerBlockInBlockset(LAIR_BLOCKS, "lair_smooth", new Block(lairMaterial.mapColor(MapColor.DARK_CRIMSON)));
    public static final Block LAIR_RIGOR = registerBlockInBlockset(LAIR_BLOCKS, "lair_rigor", new Block(lairMaterial));
    public static final Block LAIR_RIGOR_SLAB = registerBlockInBlockset(LAIR_BLOCKS, "lair_rigor_slab", new SlabBlock(FabricBlockSettings.copyOf(LAIR_RIGOR))); static { SLAB_FROM_BLOCK.put(LAIR_RIGOR, LAIR_RIGOR_SLAB); }
    public static final Block LAIR_RIGOR_STAIRS = registerBlockInBlockset(LAIR_BLOCKS, "lair_rigor_stairs", new StairsBlock(LAIR_RIGOR.getDefaultState(), FabricBlockSettings.copyOf(LAIR_RIGOR))); static { STAIR_FROM_BLOCK.put(LAIR_RIGOR, LAIR_RIGOR_STAIRS); }
    public static final Block LAIR_RIGID = registerBlockInBlockset(LAIR_BLOCKS, "lair_rigid", new Block(lairMaterial.mapColor(MapColor.DARK_CRIMSON))); 
    public static final Block LAIR_RIGID_SLAB = registerBlockInBlockset(LAIR_BLOCKS, "lair_rigid_slab", new SlabBlock(FabricBlockSettings.copyOf(LAIR_RIGID))); static { SLAB_FROM_BLOCK.put(LAIR_RIGID, LAIR_RIGID_SLAB); }
    public static final Block LAIR_RIGID_STAIRS = registerBlockInBlockset(LAIR_BLOCKS, "lair_rigid_stairs", new StairsBlock(LAIR_RIGID.getDefaultState(), FabricBlockSettings.copyOf(LAIR_RIGID))); static { STAIR_FROM_BLOCK.put(LAIR_RIGID, LAIR_RIGID_STAIRS); }
    public static final Block LAIR_MESS = registerBlockInBlockset(LAIR_BLOCKS, "lair_mess", new Block(lairMaterial)); 
    public static final Block LAIR_MATTERTILES = registerBlockInBlockset(LAIR_BLOCKS, "lair_mattertiles", new Block(lairMaterial)); 
    public static final Block LAIR_MATTER = registerBlockInBlockset(LAIR_BLOCKS, "lair_matter", new Block(lairMaterial)); 
    public static final Block LAIR_JEWEL = registerBlockInBlockset(LAIR_BLOCKS, "lair_jewel", new Block(lairMaterial)); 
    public static final Block LAIR_HEAL = registerBlockInBlockset(LAIR_BLOCKS, "lair_heal", new Block(lairMaterial)); 
    public static final Block LAIR_DERMADENT = registerBlockInBlockset(LAIR_BLOCKS, "lair_dermadent", new Block(lairMaterial));
    public static final Block LAIR_DERMA = registerBlockInBlockset(LAIR_BLOCKS, "lair_derma", new Block(lairMaterial));
    public static final Block LAIR_DERMA_SLAB = registerBlockInBlockset(LAIR_BLOCKS, "lair_derma_slab", new SlabBlock(FabricBlockSettings.copyOf(LAIR_DERMA))); static { SLAB_FROM_BLOCK.put(LAIR_DERMA, LAIR_DERMA_SLAB); }
    public static final Block LAIR_DERMA_STAIRS = registerBlockInBlockset(LAIR_BLOCKS, "lair_derma_stairs", new StairsBlock(LAIR_DERMA.getDefaultState(), FabricBlockSettings.copyOf(LAIR_DERMA))); static { STAIR_FROM_BLOCK.put(LAIR_DERMA, LAIR_DERMA_STAIRS); }
    public static final Block LAIR_CROWNED = registerBlockInBlockset(LAIR_BLOCKS, "lair_crowned", new PillarBlock(lairMaterial)); 
    public static final Block LAIR_CHUNK = registerBlockInBlockset(LAIR_BLOCKS, "lair_chunk", new ReversiblePillarBlock(lairMaterial.mapColor(MapColor.DARK_CRIMSON))); 
    public static final Block LAIR_CELL = registerBlockInBlockset(LAIR_BLOCKS, "lair_cell", new Block(lairMaterial)); 
    public static final Block LAIR_AGED = registerBlockInBlockset(LAIR_BLOCKS, "lair_aged", new Block(lairMaterial.mapColor(MapColor.DARK_CRIMSON))); 
    public static final Block LAIR = registerBlockInBlockset(LAIR_BLOCKS, "lair", new Block(lairMaterial.mapColor(MapColor.DARK_CRIMSON)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - KRYP">
    private static final FabricBlockSettings krypMaterial = FabricBlockSettings.create()
            .mapColor(MapColor.TERRACOTTA_LIGHT_GRAY)
            .requiresTool()
            .strength(3.0f, 6.0f)
            .sounds(BlockSoundGroup.COPPER);
    public static final Block KRYP_WIRE = registerBlockInBlockset(KRYP_BLOCKS, "kryp_wire", new Block(krypMaterial));
    public static final Block KRYP_SUPPORT = registerBlockInBlockset(KRYP_BLOCKS, "kryp_support", new Block(krypMaterial));
    public static final Block KRYP_STORAGE = registerBlockInBlockset(KRYP_BLOCKS, "kryp_storage", new Block(krypMaterial));
    public static final Block KRYP_SMOOTH = registerBlockInBlockset(KRYP_BLOCKS, "kryp_smooth", new Block(krypMaterial));
    public static final Block KRYP_SHEEN = registerBlockInBlockset(KRYP_BLOCKS, "kryp_sheen", new Block(krypMaterial));
    public static final Block KRYP_RUIN = registerBlockInBlockset(KRYP_BLOCKS, "kryp_ruin", new Block(krypMaterial));
    public static final Block KRYP_OMITTER = registerBlockInBlockset(KRYP_BLOCKS, "kryp_omitter", new Block(krypMaterial));
    public static final Block KRYP_LEVI = registerBlockInBlockset(KRYP_BLOCKS, "kryp_levi", new Block(krypMaterial));
    public static final Block KRYP_KUBT = registerBlockInBlockset(KRYP_BLOCKS, "kryp_kubt", new Block(krypMaterial));
    public static final Block KRYP_INFO = registerBlockInBlockset(KRYP_BLOCKS, "kryp_info", new Block(krypMaterial));
    public static final Block KRYP_DATA = registerBlockInBlockset(KRYP_BLOCKS, "kryp_data", new Block(krypMaterial));
    public static final Block KRYP_CONNECTOR = registerBlockInBlockset(KRYP_BLOCKS, "kryp_connector", new Block(krypMaterial));
    public static final Block KRYP_CHUNK = registerBlockInBlockset(KRYP_BLOCKS, "kryp_chunk", new Block(krypMaterial));
    public static final Block KRYP_BEAM = registerBlockInBlockset(KRYP_BLOCKS, "kryp_beam", new Block(krypMaterial));
    public static final Block KRYP_BASE = registerBlockInBlockset(KRYP_BLOCKS, "kryp_base", new Block(krypMaterial.sounds(BlockSoundGroup.STONE)));
    public static final Block KRYP = registerBlockInBlockset(KRYP_BLOCKS, "kryp", new Block(krypMaterial.sounds(BlockSoundGroup.CALCITE)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - LAVE">
    private static final FabricBlockSettings laveMaterial = FabricBlockSettings.create()
            .mapColor(MapColor.LIGHT_BLUE_GRAY)
            .instrument(Instrument.BASEDRUM)
            .requiresTool()
            .strength(0.8f)
            .sounds(BlockSoundGroup.DECORATED_POT);
    public static final Block LAVE_WINDOW = registerBlockInBlockset(LAVE_BLOCKS, "lave_window", new Block(laveMaterial));
    public static final Block LAVE_VENT = registerBlockInBlockset(LAVE_BLOCKS, "lave_vent", new Block(laveMaterial));
    public static final Block LAVE_UNEVEN = registerBlockInBlockset(LAVE_BLOCKS, "lave_uneven", new Block(laveMaterial));
    public static final Block LAVE_TRACKPAD = registerBlockInBlockset(LAVE_BLOCKS, "lave_trackpad", new PillarBlock(laveMaterial));
    public static final Block LAVE_TILE = registerBlockInBlockset(LAVE_BLOCKS, "lave_tile", new Block(laveMaterial));
    public static final Block LAVE_THICK = registerBlockInBlockset(LAVE_BLOCKS, "lave_thick", new Block(laveMaterial));
    public static final Block LAVE_SECTION = registerBlockInBlockset(LAVE_BLOCKS, "lave_section", new Block(laveMaterial));
    public static final Block LAVE_PANEL = registerBlockInBlockset(LAVE_BLOCKS, "lave_panel", new Block(laveMaterial));
    public static final Block LAVE_LOW = registerBlockInBlockset(LAVE_BLOCKS, "lave_low", new Block(laveMaterial.mapColor(MapColor.CYAN)));
    public static final Block LAVE_HEX = registerBlockInBlockset(LAVE_BLOCKS, "lave_hex", new Block(laveMaterial));
    public static final Block LAVE_ELEVATE = registerBlockInBlockset(LAVE_BLOCKS, "lave_elevate", new PillarBlock(laveMaterial));
    public static final Block LAVE_DIM = registerBlockInBlockset(LAVE_BLOCKS, "lave_dim", new Block(laveMaterial));
    public static final Block LAVE_DARK = registerBlockInBlockset(LAVE_BLOCKS, "lave_dark", new Block(laveMaterial.mapColor(MapColor.CYAN)));
    public static final Block LAVE_CROSSSECTION = registerBlockInBlockset(LAVE_BLOCKS, "lave_crosssection", new Block(laveMaterial));
    public static final Block LAVE_BEAM = registerBlockInBlockset(LAVE_BLOCKS, "lave_beam", new PillarBlock(laveMaterial));
    public static final Block LAVE = registerBlockInBlockset(LAVE_BLOCKS, "lave", new Block(laveMaterial));
    //</editor-fold>
    //<editor-fold desc ="Blocks - VEELD">
    private static final FabricBlockSettings veeldMaterial = FabricBlockSettings.create()
            .mapColor(MapColor.LICHEN_GREEN)
            .instrument(Instrument.BASEDRUM)
            .requiresTool()
            .strength(2.0f, 6.0f)
            .sounds(BlockSoundGroup.STONE);
    public static final Block VEELD_WET = registerBlockInBlockset(VEELD_BLOCKS, "veeld_wet", new Block(veeldMaterial.mapColor(MapColor.GREEN)));
    public static final Block VEELD_TRACTION = registerBlockInBlockset(VEELD_BLOCKS, "veeld_traction", new PillarBlock(veeldMaterial));
    public static final Block VEELD_STRUCTURE = registerBlockInBlockset(VEELD_BLOCKS, "veeld_structure", new PillarBlock(veeldMaterial));
    public static final Block VEELD_RIVETED = registerBlockInBlockset(VEELD_BLOCKS, "veeld_riveted", new Block(veeldMaterial));
    public static final Block VEELD_RIPPLE = registerBlockInBlockset(VEELD_BLOCKS, "veeld_ripple", new Block(veeldMaterial));
    public static final Block VEELD_RIGIDBRICK = registerBlockInBlockset(VEELD_BLOCKS, "veeld_rigidbrick", new Block(veeldMaterial));
    public static final Block VEELD_RIGID = registerBlockInBlockset(VEELD_BLOCKS, "veeld_rigid", new Block(veeldMaterial));
    public static final Block VEELD_PIPEWEAVE = registerBlockInBlockset(VEELD_BLOCKS, "veeld_pipeweave", new Block(veeldMaterial));
    public static final Block VEELD_PATTERNED = registerBlockInBlockset(VEELD_BLOCKS, "veeld_patterned", new GlazedTerracottaBlock(veeldMaterial));
    public static final Block VEELD_PANEL = registerBlockInBlockset(VEELD_BLOCKS, "veeld_panel", new Block(veeldMaterial));
    public static final Block VEELD_ETCHED = registerBlockInBlockset(VEELD_BLOCKS, "veeld_etched", new Block(veeldMaterial.mapColor(MapColor.GREEN)));
    public static final Block VEELD_EMBOSSED = registerBlockInBlockset(VEELD_BLOCKS, "veeld_embossed", new Block(veeldMaterial.mapColor(MapColor.GREEN)));
    public static final Block VEELD_DRILL = registerBlockInBlockset(VEELD_BLOCKS, "veeld_drill", new PillarBlock(veeldMaterial));
    public static final Block VEELD_CORE = registerBlockInBlockset(VEELD_BLOCKS, "veeld_core", new Block(veeldMaterial));
    public static final Block VEELD_BRICK = registerBlockInBlockset(VEELD_BLOCKS, "veeld_brick", new Block(veeldMaterial));
    public static final Block VEELD = registerBlockInBlockset(VEELD_BLOCKS, "veeld", new Block(veeldMaterial.mapColor(MapColor.GREEN)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - JELT">
    //</editor-fold>
    //<editor-fold desc ="Blocks - KORP">
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
    //</editor-fold>
    //<editor-fold desc ="Blocks - TANK">
    //</editor-fold>
    //<editor-fold desc ="Blocks - EXRI">
    //</editor-fold>
    //<editor-fold desc ="Blocks - AZUR">
    //</editor-fold>
    //<editor-fold desc ="Blocks - FLEQ">

    //</editor-fold>
    //<editor-fold desc ="Blocks - ISZM">

    //</editor-fold>
    //<editor-fold desc ="Blocks - MYST">

    //</editor-fold>



    //<editor-fold desc ="Registration">
    public static ArrayList<Block> registerBlocksetOfVanillaDyedBlocks(String name, FabricBlockSettings settings) {
        ArrayList<Block> blocks = new ArrayList<>();
        DyeColor[] colors = ModUtil.VANILLA_DYE_COLORS;
        for (int i = 0; i < colors.length; i++) {
            DyeColor color = colors[i];
            Block block = registerBlock(color.getName() + "_" + name, new Block(settings.mapColor(color)));
            blocks.add(block);
        }
        return blocks;
    }
    public static Block registerBlock(String name, Block block, ItemGroup group) {
        return registerBlock(name, block);
    }
    public static Block registerBlockInBlockset(ArrayList<Block> blockset, String name, Block block) {
        blockset.add(block);
        return registerBlock(name, block);
    }
    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name,block);
        return Registry.register(Registries.BLOCK, new Identifier(Super.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block) {
        BlockItem blockItem = new BlockItem(block, new FabricItemSettings());
        //ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(blockItem));
        return Registry.register(Registries.ITEM, new Identifier(Super.MOD_ID, name), blockItem);
    }
    //</editor-fold>

    //<editor-fold desc ="Attribute Util">
    private static boolean never(BlockState blockState, BlockView blockView, BlockPos blockPos) {
        return false;
    }
    public static boolean never(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
        return false;
    }
    private static ToIntFunction<BlockState> createLightLevelFromProperty(int litLevel, BooleanProperty property) {
        return state -> state.get(property) != false ? litLevel : 0;
    }
    //</editor-fold>

    public static void registerModBlocks() {
        ModInit.LOGGER.debug("Registering mod blocks for " + Super.MOD_ID);
    }
}
