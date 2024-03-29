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
    public static final ArrayList<Block> SYNC_BLOCKS = new ArrayList<>();
    public static final ArrayList<Block> NURR_BLOCKS = new ArrayList<>();
    public static final ArrayList<Block> TYEL_BLOCKS = new ArrayList<>();
    public static final ArrayList<Block> ROEN_BLOCKS = new ArrayList<>();
    public static final ArrayList<Block> SOL_BLOCKS = new ArrayList<>();
    //</editor-fold>

    //<editor-fold desc ="Blocks - FORT">
    private static final FabricBlockSettings fortMaterial = FabricBlockSettings.create()
            .strength(1.0f)
            .sounds(ModBlockSoundGroup.METAL_STICKS);  // TODO make sound less metal-y and more plastic-y
    public static final Block FORT = registerBlockInBlockset(FORT_BLOCKS, "fort", new Block(FabricBlockSettings.copyOf(fortMaterial).mapColor(MapColor.WHITE_GRAY)));
    public static final Block BRIGHT_BLUE_FORT = registerBlockInBlockset(FORT_BLOCKS, "bright_blue_fort", new Block(FabricBlockSettings.copyOf(fortMaterial).mapColor(MapColor.BLUE)));
    public static final Block BRIGHT_RED_FORT = registerBlockInBlockset(FORT_BLOCKS, "bright_red_fort", new Block(FabricBlockSettings.copyOf(fortMaterial).mapColor(MapColor.DULL_RED)));
    public static final Block BRIGHT_VIOLET_FORT = registerBlockInBlockset(FORT_BLOCKS, "bright_violet_fort", new Block(FabricBlockSettings.copyOf(fortMaterial).mapColor(MapColor.TERRACOTTA_BLUE)));
    public static final Block BRIGHT_YELLOW_FORT = registerBlockInBlockset(FORT_BLOCKS, "bright_yellow_fort", new Block(FabricBlockSettings.copyOf(fortMaterial).mapColor(MapColor.YELLOW)));
    public static final Block DARK_AZURE_FORT = registerBlockInBlockset(FORT_BLOCKS, "dark_azure_fort", new Block(FabricBlockSettings.copyOf(fortMaterial).mapColor(MapColor.LAPIS_BLUE)));
    public static final Block DARK_RED_FORT = registerBlockInBlockset(FORT_BLOCKS, "dark_red_fort", new Block(FabricBlockSettings.copyOf(fortMaterial).mapColor(MapColor.RED)));
    public static final Block DARK_TURQUOISE_FORT = registerBlockInBlockset(FORT_BLOCKS, "dark_turquoise_fort", new Block(FabricBlockSettings.copyOf(fortMaterial).mapColor(MapColor.TEAL)));
    public static final Block EARTH_GREEN_FORT = registerBlockInBlockset(FORT_BLOCKS, "earth_green_fort", new Block(FabricBlockSettings.copyOf(fortMaterial).mapColor(MapColor.DARK_GREEN)));
    public static final Block EARTH_ORANGE_FORT = registerBlockInBlockset(FORT_BLOCKS, "earth_orange_fort", new Block(FabricBlockSettings.copyOf(fortMaterial).mapColor(MapColor.TERRACOTTA_ORANGE)));
    public static final Block GRAY_FORT = registerBlockInBlockset(FORT_BLOCKS, "gray_fort", new Block(FabricBlockSettings.copyOf(fortMaterial).mapColor(MapColor.IRON_GRAY)));
    public static final Block LIME_FORT = registerBlockInBlockset(FORT_BLOCKS, "lime_fort", new Block(FabricBlockSettings.copyOf(fortMaterial).mapColor(MapColor.LIME)));
    public static final Block MEDIUM_AZURE_FORT = registerBlockInBlockset(FORT_BLOCKS, "medium_azure_fort", new Block(FabricBlockSettings.copyOf(fortMaterial).mapColor(MapColor.DIAMOND_BLUE)));
    public static final Block ORANGE_FORT = registerBlockInBlockset(FORT_BLOCKS, "orange_fort", new Block(FabricBlockSettings.copyOf(fortMaterial).mapColor(MapColor.ORANGE)));
    public static final Block SAND_BLUE_FORT = registerBlockInBlockset(FORT_BLOCKS, "sand_blue_fort", new Block(FabricBlockSettings.copyOf(fortMaterial).mapColor(MapColor.LIGHT_BLUE_GRAY)));
    public static final Block STONE_GRAY_FORT = registerBlockInBlockset(FORT_BLOCKS, "stone_gray_fort", new Block(FabricBlockSettings.copyOf(fortMaterial).mapColor(MapColor.STONE_GRAY)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - GLAXX">
    private static final FabricBlockSettings glaxxMaterial = FabricBlockSettings.create()
            .mapColor(MapColor.CLEAR)
            .strength(0.3f)
            .sounds(BlockSoundGroup.STONE) // TODO custom sound
            .nonOpaque()
            .allowsSpawning(ModBlocks::never)
            .solidBlock(ModBlocks::never)
            .suffocates(ModBlocks::never)
            .blockVision(ModBlocks::never);
    public static final Block THYME_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "thyme_glaxx", new GlassBlock(FabricBlockSettings.copyOf(glaxxMaterial)/*.mapColor(MapColor.TERRACOTTA_GREEN)*/));
    public static final Block SASSAFRAS_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "sassafras_glaxx", new GlassBlock(FabricBlockSettings.copyOf(glaxxMaterial)/*.mapColor(MapColor.BLUE)*/));
    public static final Block SANDALWOOD_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "sandalwood_glaxx", new GlassBlock(FabricBlockSettings.copyOf(glaxxMaterial)/*.mapColor(MapColor.IRON_GRAY)*/));
    public static final Block SAGE_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "sage_glaxx", new GlassBlock(FabricBlockSettings.copyOf(glaxxMaterial)/*.mapColor(MapColor.TERRACOTTA_LIME)*/));
    public static final Block ROSE_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "rose_glaxx", new GlassBlock(FabricBlockSettings.copyOf(glaxxMaterial)/*.mapColor(MapColor.DULL_PINK)*/));
    public static final Block PINE_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "pine_glaxx", new GlassBlock(FabricBlockSettings.copyOf(glaxxMaterial)/*.mapColor(MapColor.SPRUCE_BROWN)*/));
    public static final Block MINT_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "mint_glaxx", new GlassBlock(FabricBlockSettings.copyOf(glaxxMaterial)/*.mapColor(MapColor.LICHEN_GREEN)*/));
    public static final Block LICORICE_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "licorice_glaxx", new GlassBlock(FabricBlockSettings.copyOf(glaxxMaterial)/*.mapColor(MapColor.STONE_GRAY)*/));
    public static final Block LEMON_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "lemon_glaxx", new GlassBlock(FabricBlockSettings.copyOf(glaxxMaterial)/*.mapColor(MapColor.TERRACOTTA_YELLOW)*/));
    public static final Block LAVENDER_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "lavender_glaxx", new GlassBlock(FabricBlockSettings.copyOf(glaxxMaterial)/*.mapColor(MapColor.TERRACOTTA_BLUE)*/));
    public static final Block INCENSE_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "incense_glaxx", new GlassBlock(FabricBlockSettings.copyOf(glaxxMaterial)/*.mapColor(MapColor.GRAY)*/));
    public static final Block EUCALYPTUS_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "eucalyptus_glaxx", new GlassBlock(FabricBlockSettings.copyOf(glaxxMaterial)/*.mapColor(MapColor.DARK_DULL_PINK)*/));
    public static final Block COCONUT_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "coconut_glaxx", new GlassBlock(FabricBlockSettings.copyOf(glaxxMaterial)/*.mapColor(MapColor.TERRACOTTA_CYAN)*/));
    public static final Block CINNIMON_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "cinnimon_glaxx", new GlassBlock(FabricBlockSettings.copyOf(glaxxMaterial)/*.mapColor(MapColor.DARK_CRIMSON)*/));
    public static final Block CITRUS_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "citrus_glaxx", new GlassBlock(FabricBlockSettings.copyOf(glaxxMaterial)/*.mapColor(MapColor.DIRT_BROWN)*/));
    public static final Block BRINE_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "brine_glaxx", new GlassBlock(FabricBlockSettings.copyOf(glaxxMaterial)/*.mapColor(MapColor.CYAN)*/));
    //</editor-fold>
    //<editor-fold desc ="Blocks - CRAY">
    private static final FabricBlockSettings crayMaterial = FabricBlockSettings.create()
            .strength(0.8f) // same as sandstone
            .requiresTool()
            .sounds(BlockSoundGroup.DECORATED_POT); // perfect
    public static final Block YELLOW_CRAY = registerBlockInBlockset(CRAY_BLOCKS, "yellow_cray", new Block(FabricBlockSettings.copyOf(crayMaterial).mapColor(MapColor.YELLOW)));
    public static final Block VIOLET_CRAY = registerBlockInBlockset(CRAY_BLOCKS, "violet_cray", new Block(FabricBlockSettings.copyOf(crayMaterial).mapColor(MapColor.PURPLE)));
    public static final Block RED_CRAY = registerBlockInBlockset(CRAY_BLOCKS, "red_cray", new Block(FabricBlockSettings.copyOf(crayMaterial).mapColor(MapColor.RED)));
    public static final Block PURPLE_CRAY = registerBlockInBlockset(CRAY_BLOCKS, "purple_cray", new Block(FabricBlockSettings.copyOf(crayMaterial).mapColor(MapColor.PALE_PURPLE)));
    public static final Block ORANGE_CRAY = registerBlockInBlockset(CRAY_BLOCKS, "orange_cray", new Block(FabricBlockSettings.copyOf(crayMaterial).mapColor(MapColor.ORANGE)));
    public static final Block NAVY_CRAY = registerBlockInBlockset(CRAY_BLOCKS, "navy_cray", new Block(FabricBlockSettings.copyOf(crayMaterial).mapColor(MapColor.LIGHT_BLUE)));
    public static final Block MINT_CRAY = registerBlockInBlockset(CRAY_BLOCKS, "mint_cray", new Block(FabricBlockSettings.copyOf(crayMaterial).mapColor(MapColor.BRIGHT_TEAL)));
    public static final Block MAGENTA_CRAY = registerBlockInBlockset(CRAY_BLOCKS, "magenta_cray", new Block(FabricBlockSettings.copyOf(crayMaterial).mapColor(MapColor.MAGENTA)));
    public static final Block LIME_CRAY = registerBlockInBlockset(CRAY_BLOCKS, "lime_cray", new Block(FabricBlockSettings.copyOf(crayMaterial).mapColor(MapColor.LIME)));
    public static final Block GREEN_CRAY = registerBlockInBlockset(CRAY_BLOCKS, "green_cray", new Block(FabricBlockSettings.copyOf(crayMaterial).mapColor(MapColor.EMERALD_GREEN)));
    public static final Block FUCHSIA_CRAY = registerBlockInBlockset(CRAY_BLOCKS, "fuchsia_cray", new Block(FabricBlockSettings.copyOf(crayMaterial).mapColor(MapColor.DULL_PINK)));
    public static final Block EMPTY_CRAY = registerBlockInBlockset(CRAY_BLOCKS, "empty_cray", new Block(FabricBlockSettings.copyOf(crayMaterial).mapColor(MapColor.LIGHT_GRAY)));
    public static final Block CYAN_CRAY = registerBlockInBlockset(CRAY_BLOCKS, "cyan_cray", new Block(FabricBlockSettings.copyOf(crayMaterial).mapColor(MapColor.DARK_AQUA)));
    public static final Block BLUE_CRAY = registerBlockInBlockset(CRAY_BLOCKS, "blue_cray", new Block(FabricBlockSettings.copyOf(crayMaterial).mapColor(MapColor.CYAN)));
    public static final Block AMBER_CRAY = registerBlockInBlockset(CRAY_BLOCKS, "amber_cray", new Block(FabricBlockSettings.copyOf(crayMaterial).mapColor(MapColor.OAK_TAN)));
    public static final Block CRAY = registerBlockInBlockset(CRAY_BLOCKS, "cray", new Block(FabricBlockSettings.copyOf(crayMaterial).mapColor(MapColor.WHITE_GRAY)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - CAST">
    private static final FabricBlockSettings castMaterial = FabricBlockSettings.create()
            .strength(1.0f)
            .sounds(ModBlockSoundGroup.METAL_STICKS); // TODO custom plastic sound
    public static final Block YELLOW_CAST = registerBlockInBlockset(CAST_BLOCKS, "yellow_cast", new Block(FabricBlockSettings.copyOf(castMaterial).mapColor(MapColor.YELLOW)));
    public static final Block VERMILION_CAST = registerBlockInBlockset(CAST_BLOCKS, "vermilion_cast", new Block(FabricBlockSettings.copyOf(castMaterial).mapColor(MapColor.BRIGHT_RED)));
    public static final Block VELVET_CAST = registerBlockInBlockset(CAST_BLOCKS, "velvet_cast", new Block(FabricBlockSettings.copyOf(castMaterial).mapColor(MapColor.DULL_RED)));
    public static final Block RED_CAST = registerBlockInBlockset(CAST_BLOCKS, "red_cast", new Block(FabricBlockSettings.copyOf(castMaterial).mapColor(MapColor.BRIGHT_RED)));
    public static final Block PURPLE_CAST = registerBlockInBlockset(CAST_BLOCKS, "purple_cast", new Block(FabricBlockSettings.copyOf(castMaterial).mapColor(MapColor.PURPLE)));
    public static final Block NAVY_CAST = registerBlockInBlockset(CAST_BLOCKS, "navy_cast", new Block(FabricBlockSettings.copyOf(castMaterial).mapColor(MapColor.WATER_BLUE)));
    public static final Block MAGENTA_CAST = registerBlockInBlockset(CAST_BLOCKS, "magenta_cast", new Block(FabricBlockSettings.copyOf(castMaterial).mapColor(MapColor.MAGENTA)));
    public static final Block LIME_CAST = registerBlockInBlockset(CAST_BLOCKS, "lime_cast", new Block(FabricBlockSettings.copyOf(castMaterial).mapColor(MapColor.LIME)));
    public static final Block GREEN_CAST = registerBlockInBlockset(CAST_BLOCKS, "green_cast", new Block(FabricBlockSettings.copyOf(castMaterial).mapColor(MapColor.EMERALD_GREEN)));
    public static final Block EMPTY_CAST = registerBlockInBlockset(CAST_BLOCKS, "empty_cast", new Block(FabricBlockSettings.copyOf(castMaterial).mapColor(MapColor.BLACK)));
    public static final Block CYAN_CAST = registerBlockInBlockset(CAST_BLOCKS, "cyan_cast", new Block(FabricBlockSettings.copyOf(castMaterial).mapColor(MapColor.CYAN)));
    public static final Block CHARTREUSE_CAST = registerBlockInBlockset(CAST_BLOCKS, "chartreuse_cast", new Block(FabricBlockSettings.copyOf(castMaterial).mapColor(MapColor.PALE_GREEN)));
    public static final Block BROWN_CAST = registerBlockInBlockset(CAST_BLOCKS, "brown_cast", new Block(FabricBlockSettings.copyOf(castMaterial).mapColor(MapColor.TERRACOTTA_ORANGE)));
    public static final Block BLUE_CAST = registerBlockInBlockset(CAST_BLOCKS, "blue_cast", new Block(FabricBlockSettings.copyOf(castMaterial).mapColor(MapColor.LAPIS_BLUE)));
    public static final Block AMBER_CAST = registerBlockInBlockset(CAST_BLOCKS, "amber_cast", new Block(FabricBlockSettings.copyOf(castMaterial).mapColor(MapColor.TERRACOTTA_YELLOW)));
    public static final Block CAST = registerBlockInBlockset(CAST_BLOCKS, "cast", new Block(FabricBlockSettings.copyOf(castMaterial).mapColor(MapColor.WHITE)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - HOST">
    private static final FabricBlockSettings hostMaterial = FabricBlockSettings.create()
            .strength(1.5f)
            .requiresTool()
            .sounds(BlockSoundGroup.COPPER);
    public static final Block YELLOW_HOST = registerBlockInBlockset(HOST_BLOCKS, "yellow_host", new Block(FabricBlockSettings.copyOf(hostMaterial).mapColor(MapColor.GRAY).luminance(state -> 7)));
    public static final Block VIOLET_HOST = registerBlockInBlockset(HOST_BLOCKS, "violet_host", new Block(FabricBlockSettings.copyOf(hostMaterial).mapColor(MapColor.GRAY).luminance(state -> 7)));
    public static final Block VERMILION_HOST = registerBlockInBlockset(HOST_BLOCKS, "vermilion_host", new Block(FabricBlockSettings.copyOf(hostMaterial).mapColor(MapColor.GRAY).luminance(state -> 7)));
    public static final Block RED_HOST = registerBlockInBlockset(HOST_BLOCKS, "red_host", new Block(FabricBlockSettings.copyOf(hostMaterial).mapColor(MapColor.GRAY).luminance(state -> 7)));
    public static final Block PURPLE_HOST = registerBlockInBlockset(HOST_BLOCKS, "purple_host", new Block(FabricBlockSettings.copyOf(hostMaterial).mapColor(MapColor.GRAY).luminance(state -> 7)));
    public static final Block NAVY_HOST = registerBlockInBlockset(HOST_BLOCKS, "navy_host", new Block(FabricBlockSettings.copyOf(hostMaterial).mapColor(MapColor.GRAY).luminance(state -> 7)));
    public static final Block MINT_HOST = registerBlockInBlockset(HOST_BLOCKS, "mint_host", new Block(FabricBlockSettings.copyOf(hostMaterial).mapColor(MapColor.GRAY).luminance(state -> 7)));
    public static final Block MAGENTA_HOST = registerBlockInBlockset(HOST_BLOCKS, "magenta_host", new Block(FabricBlockSettings.copyOf(hostMaterial).mapColor(MapColor.GRAY).luminance(state -> 7)));
    public static final Block LIME_HOST = registerBlockInBlockset(HOST_BLOCKS, "lime_host", new Block(FabricBlockSettings.copyOf(hostMaterial).mapColor(MapColor.GRAY).luminance(state -> 7)));
    public static final Block GREEN_HOST = registerBlockInBlockset(HOST_BLOCKS, "green_host", new Block(FabricBlockSettings.copyOf(hostMaterial).mapColor(MapColor.GRAY).luminance(state -> 7)));
    public static final Block FUCHSIA_HOST = registerBlockInBlockset(HOST_BLOCKS, "fuchsia_host", new Block(FabricBlockSettings.copyOf(hostMaterial).mapColor(MapColor.GRAY).luminance(state -> 7)));
    public static final Block EMPTY_HOST = registerBlockInBlockset(HOST_BLOCKS, "empty_host", new Block(FabricBlockSettings.copyOf(hostMaterial).mapColor(MapColor.BLACK)));
    public static final Block CYAN_HOST = registerBlockInBlockset(HOST_BLOCKS, "cyan_host", new Block(FabricBlockSettings.copyOf(hostMaterial).mapColor(MapColor.GRAY).luminance(state -> 7)));
    public static final Block BLUE_HOST = registerBlockInBlockset(HOST_BLOCKS, "blue_host", new Block(FabricBlockSettings.copyOf(hostMaterial).mapColor(MapColor.GRAY).luminance(state -> 7)));
    public static final Block AMBER_HOST = registerBlockInBlockset(HOST_BLOCKS, "amber_host", new Block(FabricBlockSettings.copyOf(hostMaterial).mapColor(MapColor.GRAY).luminance(state -> 7)));
    public static final Block HOST = registerBlockInBlockset(HOST_BLOCKS, "host", new Block(FabricBlockSettings.copyOf(hostMaterial).mapColor(MapColor.GRAY).luminance(state -> 3)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - ZANE">
    private static final FabricBlockSettings zaneMaterial = FabricBlockSettings.create()
            .strength(0.75f)
            .requiresTool()
            .instrument(Instrument.BASEDRUM)
            .sounds(BlockSoundGroup.CALCITE);
    public static final Block RED_ZANE = registerBlockInBlockset(ZANE_BLOCKS, "red_zane", new Block(FabricBlockSettings.copyOf(zaneMaterial).mapColor(MapColor.RED)));
    public static final Block AMBER_ZANE = registerBlockInBlockset(ZANE_BLOCKS, "amber_zane", new Block(FabricBlockSettings.copyOf(zaneMaterial).mapColor(MapColor.TERRACOTTA_ORANGE)));
    public static final Block EMPTY_ZANE = registerBlockInBlockset(ZANE_BLOCKS, "empty_zane", new Block(FabricBlockSettings.copyOf(zaneMaterial).mapColor(MapColor.BLACK)));
    public static final Block ORANGE_ZANE = registerBlockInBlockset(ZANE_BLOCKS, "orange_zane", new Block(FabricBlockSettings.copyOf(zaneMaterial).mapColor(MapColor.ORANGE)));
    public static final Block YELLOW_ZANE = registerBlockInBlockset(ZANE_BLOCKS, "yellow_zane", new Block(FabricBlockSettings.copyOf(zaneMaterial).mapColor(MapColor.YELLOW)));
    public static final Block PURPLE_ZANE = registerBlockInBlockset(ZANE_BLOCKS, "purple_zane", new Block(FabricBlockSettings.copyOf(zaneMaterial).mapColor(MapColor.PURPLE)));
    public static final Block NAVY_ZANE = registerBlockInBlockset(ZANE_BLOCKS, "navy_zane", new Block(FabricBlockSettings.copyOf(zaneMaterial).mapColor(MapColor.BLUE)));
    public static final Block MINT_ZANE = registerBlockInBlockset(ZANE_BLOCKS, "mint_zane", new Block(FabricBlockSettings.copyOf(zaneMaterial).mapColor(MapColor.BRIGHT_TEAL)));
    public static final Block MAGENTA_ZANE = registerBlockInBlockset(ZANE_BLOCKS, "magenta_zane", new Block(FabricBlockSettings.copyOf(zaneMaterial).mapColor(MapColor.MAGENTA)));
    public static final Block LIME_ZANE = registerBlockInBlockset(ZANE_BLOCKS, "lime_zane", new Block(FabricBlockSettings.copyOf(zaneMaterial).mapColor(MapColor.LIME)));
    public static final Block GREEN_ZANE = registerBlockInBlockset(ZANE_BLOCKS, "green_zane", new Block(FabricBlockSettings.copyOf(zaneMaterial).mapColor(MapColor.GREEN)));
    public static final Block FUCHSIA_ZANE = registerBlockInBlockset(ZANE_BLOCKS, "fuchsia_zane", new Block(FabricBlockSettings.copyOf(zaneMaterial).mapColor(MapColor.DULL_PINK)));
    public static final Block CYAN_ZANE = registerBlockInBlockset(ZANE_BLOCKS, "cyan_zane", new Block(FabricBlockSettings.copyOf(zaneMaterial).mapColor(MapColor.TEAL)));
    public static final Block CERULEAN_ZANE = registerBlockInBlockset(ZANE_BLOCKS, "cerulean_zane", new Block(FabricBlockSettings.copyOf(zaneMaterial).mapColor(MapColor.LAPIS_BLUE)));
    public static final Block BLUE_ZANE = registerBlockInBlockset(ZANE_BLOCKS, "blue_zane", new Block(FabricBlockSettings.copyOf(zaneMaterial).mapColor(MapColor.LIGHT_BLUE)));
    public static final Block ZANE = registerBlockInBlockset(ZANE_BLOCKS, "zane", new Block(FabricBlockSettings.copyOf(zaneMaterial).mapColor(MapColor.WHITE)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - VECT">
    private static final FabricBlockSettings vectMaterial = FabricBlockSettings.create()
            .mapColor(MapColor.YELLOW)
            .requiresTool()
            .strength(2.4f, 2.0f)
            .sounds(BlockSoundGroup.METAL);
    public static final Block VECT = registerBlockInBlockset(VECT_BLOCKS, "vect", new Block(FabricBlockSettings.copyOf(vectMaterial)));
    public static final Block VECT_TILE = registerBlockInBlockset(VECT_BLOCKS, "vect_tile", new Block(FabricBlockSettings.copyOf(vectMaterial)));
    public static final Block VECT_RIVET = registerBlockInBlockset(VECT_BLOCKS, "vect_rivet", new Block(FabricBlockSettings.copyOf(vectMaterial)));
    public static final Block VECT_HUB = registerBlockInBlockset(VECT_BLOCKS, "vect_hub", new Block(FabricBlockSettings.copyOf(vectMaterial)));
    public static final Block VECT_STRUT = registerBlockInBlockset(VECT_BLOCKS, "vect_strut", new PillarBlock(FabricBlockSettings.copyOf(vectMaterial)));
    public static final Block VECT_PAD = registerBlockInBlockset(VECT_BLOCKS, "vect_pad", new ReversiblePillarBlock(FabricBlockSettings.copyOf(vectMaterial)));
    public static final Block VECT_TRACKER = registerBlockInBlockset(VECT_BLOCKS, "vect_tracker", new Block(FabricBlockSettings.copyOf(vectMaterial).mapColor(MapColor.BLACK)));
    public static final Block VECT_CORE = registerBlockInBlockset(VECT_BLOCKS, "vect_core", new Block(FabricBlockSettings.copyOf(vectMaterial).mapColor(MapColor.BLACK)));
    public static final Block VECT_TREADPLATE = registerBlockInBlockset(VECT_BLOCKS, "vect_treadplate", new Block(FabricBlockSettings.copyOf(vectMaterial)));
    public static final Block VECT_SHIELD = registerBlockInBlockset(VECT_BLOCKS, "vect_shield", new PillarBlock(FabricBlockSettings.copyOf(vectMaterial)));
    public static final Block VECT_PANEL = registerBlockInBlockset(VECT_BLOCKS, "vect_panel", new Block(FabricBlockSettings.copyOf(vectMaterial)));
    public static final Block VECT_RADIATOR = registerBlockInBlockset(VECT_BLOCKS, "vect_radiator", new Block(FabricBlockSettings.copyOf(vectMaterial).mapColor(MapColor.GOLD)));
    public static final Block VECT_BULKHEAD = registerBlockInBlockset(VECT_BLOCKS, "vect_bulkhead", new PillarBlock(FabricBlockSettings.copyOf(vectMaterial)));
    public static final Block VECT_TANK = registerBlockInBlockset(VECT_BLOCKS, "vect_tank", new Block(FabricBlockSettings.copyOf(vectMaterial).mapColor(MapColor.GOLD).strength(1.8f).sounds(ModBlockSoundGroup.FOIL)));
    public static final Block VECT_NETWORK = registerBlockInBlockset(VECT_BLOCKS, "vect_network", new Block(FabricBlockSettings.copyOf(vectMaterial).mapColor(MapColor.PALE_YELLOW)));
    public static final Block VECT_FOIL = registerBlockInBlockset(VECT_BLOCKS, "vect_foil", new Block(FabricBlockSettings.copyOf(vectMaterial).mapColor(MapColor.GOLD).strength(1.2f).sounds(ModBlockSoundGroup.FOIL)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - REDDS">
    private static final FabricBlockSettings reddsMaterial = FabricBlockSettings.create()
            .mapColor(MapColor.DARK_RED)
            .requiresTool()
            .strength(2.4f, 2.0f)
            .sounds(ModBlockSoundGroup.POLYGON);
    public static final Block REDDS = registerBlockInBlockset(REDDS_BLOCKS, "redds", new LitBlock(FabricBlockSettings.copyOf(reddsMaterial).luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_POLYGON_ACTIVATE, null));
    public static final Block REDDS_PICE = registerBlockInBlockset(REDDS_BLOCKS, "redds_pice", new LitBlock(FabricBlockSettings.copyOf(reddsMaterial), null, null));
    public static final Block REDDS_PICE_STAIRS = registerBlockInBlockset(REDDS_BLOCKS, "redds_pice_stairs", new LitStairsBlock(REDDS_PICE.getDefaultState(), FabricBlockSettings.copyOf(REDDS_PICE), null, null)); static { STAIR_FROM_BLOCK.put(REDDS_PICE, REDDS_PICE_STAIRS); }
    public static final Block REDDS_PICE_SLAB = registerBlockInBlockset(REDDS_BLOCKS, "redds_pice_slab", new LitSlabBlock(FabricBlockSettings.copyOf(REDDS_PICE), null, null)); static { SLAB_FROM_BLOCK.put(REDDS_PICE, REDDS_PICE_SLAB); }
    public static final Block REDDS_TRACT = registerBlockInBlockset(REDDS_BLOCKS, "redds_tract", new LitBlock(FabricBlockSettings.copyOf(reddsMaterial).luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_POLYGON_ACTIVATE, null));
    public static final Block REDDS_THOUGHT = registerBlockInBlockset(REDDS_BLOCKS, "redds_thought", new LitBlock(FabricBlockSettings.copyOf(reddsMaterial).luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_POLYGON_ACTIVATE, null));
    public static final Block REDDS_TILE = registerBlockInBlockset(REDDS_BLOCKS, "redds_tile", new LitBlock(FabricBlockSettings.copyOf(reddsMaterial).luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_POLYGON_ACTIVATE, null));
    public static final Block REDDS_MARK = registerBlockInBlockset(REDDS_BLOCKS, "redds_mark", new LitBlock(FabricBlockSettings.copyOf(reddsMaterial).luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_POLYGON_ACTIVATE, null));
    public static final Block REDDS_NEXUS = registerBlockInBlockset(REDDS_BLOCKS, "redds_nexus", new LitBlock(FabricBlockSettings.copyOf(reddsMaterial).luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_POLYGON_ACTIVATE, null));
    public static final Block REDDS_TAPE = registerBlockInBlockset(REDDS_BLOCKS, "redds_tape", new LitPillarBlock(FabricBlockSettings.copyOf(reddsMaterial).luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_POLYGON_ACTIVATE, null));
    public static final Block REDDS_GRATE = registerBlockInBlockset(REDDS_BLOCKS, "redds_grate", new LitBlock(FabricBlockSettings.copyOf(reddsMaterial).luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_POLYGON_ACTIVATE, null));
    public static final Block REDDS_HEART = registerBlockInBlockset(REDDS_BLOCKS, "redds_heart", new LitBlock(FabricBlockSettings.copyOf(reddsMaterial).luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_POLYGON_ACTIVATE, null));
    public static final Block REDDS_HOPPER = registerBlockInBlockset(REDDS_BLOCKS, "redds_hopper", new LitBlock(FabricBlockSettings.copyOf(reddsMaterial).luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_POLYGON_ACTIVATE, null));
    public static final Block REDDS_FRACTAL = registerBlockInBlockset(REDDS_BLOCKS, "redds_fractal", new LitBlock(FabricBlockSettings.copyOf(reddsMaterial).luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_POLYGON_ACTIVATE, null));
    public static final Block REDDS_FRAME = registerBlockInBlockset(REDDS_BLOCKS, "redds_frame", new LitBlock(FabricBlockSettings.copyOf(reddsMaterial).luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_POLYGON_ACTIVATE, null));
    public static final Block REDDS_GLAZED = registerBlockInBlockset(REDDS_BLOCKS, "redds_glazed", new LitGlazedTerracottaBlock(FabricBlockSettings.copyOf(reddsMaterial).luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_POLYGON_ACTIVATE, null));
    public static final Block REDDS_BALANCE = registerBlockInBlockset(REDDS_BLOCKS, "redds_balance", new LitBlock(FabricBlockSettings.copyOf(reddsMaterial).luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_POLYGON_ACTIVATE, null));
    public static final Block REDDS_CURRENT = registerBlockInBlockset(REDDS_BLOCKS, "redds_current", new LitBlock(FabricBlockSettings.copyOf(reddsMaterial).luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_POLYGON_ACTIVATE, null));
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
    public static final Block LAIR_STRUT = registerBlockInBlockset(LAIR_BLOCKS, "lair_strut", new Block(FabricBlockSettings.copyOf(lairMaterial))); 
    public static final Block LAIR_SMOOTH = registerBlockInBlockset(LAIR_BLOCKS, "lair_smooth", new Block(FabricBlockSettings.copyOf(lairMaterial).mapColor(MapColor.DARK_CRIMSON)));
    public static final Block LAIR_RIGOR = registerBlockInBlockset(LAIR_BLOCKS, "lair_rigor", new Block(FabricBlockSettings.copyOf(lairMaterial)));
    public static final Block LAIR_RIGOR_STAIRS = registerBlockInBlockset(LAIR_BLOCKS, "lair_rigor_stairs", new StairsBlock(LAIR_RIGOR.getDefaultState(), FabricBlockSettings.copyOf(LAIR_RIGOR))); static { STAIR_FROM_BLOCK.put(LAIR_RIGOR, LAIR_RIGOR_STAIRS); }
    public static final Block LAIR_RIGOR_SLAB = registerBlockInBlockset(LAIR_BLOCKS, "lair_rigor_slab", new SlabBlock(FabricBlockSettings.copyOf(LAIR_RIGOR))); static { SLAB_FROM_BLOCK.put(LAIR_RIGOR, LAIR_RIGOR_SLAB); }
    public static final Block LAIR_RIGID = registerBlockInBlockset(LAIR_BLOCKS, "lair_rigid", new Block(FabricBlockSettings.copyOf(lairMaterial).mapColor(MapColor.DARK_CRIMSON)));
    public static final Block LAIR_RIGID_STAIRS = registerBlockInBlockset(LAIR_BLOCKS, "lair_rigid_stairs", new StairsBlock(LAIR_RIGID.getDefaultState(), FabricBlockSettings.copyOf(LAIR_RIGID))); static { STAIR_FROM_BLOCK.put(LAIR_RIGID, LAIR_RIGID_STAIRS); }
    public static final Block LAIR_RIGID_SLAB = registerBlockInBlockset(LAIR_BLOCKS, "lair_rigid_slab", new SlabBlock(FabricBlockSettings.copyOf(LAIR_RIGID))); static { SLAB_FROM_BLOCK.put(LAIR_RIGID, LAIR_RIGID_SLAB); }
    public static final Block LAIR_MESS = registerBlockInBlockset(LAIR_BLOCKS, "lair_mess", new Block(FabricBlockSettings.copyOf(lairMaterial)));
    public static final Block LAIR_MATTERTILES = registerBlockInBlockset(LAIR_BLOCKS, "lair_mattertiles", new Block(FabricBlockSettings.copyOf(lairMaterial))); 
    public static final Block LAIR_MATTER = registerBlockInBlockset(LAIR_BLOCKS, "lair_matter", new Block(FabricBlockSettings.copyOf(lairMaterial))); 
    public static final Block LAIR_JEWEL = registerBlockInBlockset(LAIR_BLOCKS, "lair_jewel", new Block(FabricBlockSettings.copyOf(lairMaterial))); 
    public static final Block LAIR_HEAL = registerBlockInBlockset(LAIR_BLOCKS, "lair_heal", new Block(FabricBlockSettings.copyOf(lairMaterial))); 
    public static final Block LAIR_DERMADENT = registerBlockInBlockset(LAIR_BLOCKS, "lair_dermadent", new Block(FabricBlockSettings.copyOf(lairMaterial)));
    public static final Block LAIR_DERMA = registerBlockInBlockset(LAIR_BLOCKS, "lair_derma", new Block(FabricBlockSettings.copyOf(lairMaterial)));
    public static final Block LAIR_DERMA_STAIRS = registerBlockInBlockset(LAIR_BLOCKS, "lair_derma_stairs", new StairsBlock(LAIR_DERMA.getDefaultState(), FabricBlockSettings.copyOf(LAIR_DERMA))); static { STAIR_FROM_BLOCK.put(LAIR_DERMA, LAIR_DERMA_STAIRS); }
    public static final Block LAIR_DERMA_SLAB = registerBlockInBlockset(LAIR_BLOCKS, "lair_derma_slab", new SlabBlock(FabricBlockSettings.copyOf(LAIR_DERMA))); static { SLAB_FROM_BLOCK.put(LAIR_DERMA, LAIR_DERMA_SLAB); }
    public static final Block LAIR_CROWNED = registerBlockInBlockset(LAIR_BLOCKS, "lair_crowned", new PillarBlock(FabricBlockSettings.copyOf(lairMaterial)));
    public static final Block LAIR_CHUNK = registerBlockInBlockset(LAIR_BLOCKS, "lair_chunk", new ReversiblePillarBlock(FabricBlockSettings.copyOf(lairMaterial).mapColor(MapColor.DARK_CRIMSON))); 
    public static final Block LAIR_CELL = registerBlockInBlockset(LAIR_BLOCKS, "lair_cell", new Block(FabricBlockSettings.copyOf(lairMaterial))); 
    public static final Block LAIR_AGED = registerBlockInBlockset(LAIR_BLOCKS, "lair_aged", new Block(FabricBlockSettings.copyOf(lairMaterial).mapColor(MapColor.DARK_CRIMSON))); 
    public static final Block LAIR = registerBlockInBlockset(LAIR_BLOCKS, "lair", new Block(FabricBlockSettings.copyOf(lairMaterial).mapColor(MapColor.DARK_CRIMSON)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - KRYP">
    private static final FabricBlockSettings krypMaterial = FabricBlockSettings.create()
            .mapColor(MapColor.TERRACOTTA_LIGHT_GRAY)
            .requiresTool()
            .strength(3.0f, 6.0f)
            .sounds(BlockSoundGroup.COPPER);
    public static final Block KRYP_WIRE = registerBlockInBlockset(KRYP_BLOCKS, "kryp_wire", new Block(FabricBlockSettings.copyOf(krypMaterial)));
    public static final Block KRYP_WIRE_STAIRS = registerBlockInBlockset(KRYP_BLOCKS, "kryp_wire_stairs", new StairsBlock(KRYP_WIRE.getDefaultState(), FabricBlockSettings.copyOf(KRYP_WIRE))); static { STAIR_FROM_BLOCK.put(KRYP_WIRE, KRYP_WIRE_STAIRS); }
    public static final Block KRYP_WIRE_SLAB = registerBlockInBlockset(KRYP_BLOCKS, "kryp_wire_slab", new SlabBlock(FabricBlockSettings.copyOf(KRYP_WIRE))); static { SLAB_FROM_BLOCK.put(KRYP_WIRE, KRYP_WIRE_SLAB); }
    public static final Block KRYP_SUPPORT = registerBlockInBlockset(KRYP_BLOCKS, "kryp_support", new PillarBlock(FabricBlockSettings.copyOf(krypMaterial)));
    public static final Block KRYP_STORAGE = registerBlockInBlockset(KRYP_BLOCKS, "kryp_storage", new Block(FabricBlockSettings.copyOf(krypMaterial)));
    public static final Block KRYP_SMOOTH = registerBlockInBlockset(KRYP_BLOCKS, "kryp_smooth", new Block(FabricBlockSettings.copyOf(krypMaterial).sounds(BlockSoundGroup.CALCITE)));
    public static final Block KRYP_SMOOTH_STAIRS = registerBlockInBlockset(KRYP_BLOCKS, "kryp_smooth_stairs", new StairsBlock(KRYP_SMOOTH.getDefaultState(), FabricBlockSettings.copyOf(KRYP_SMOOTH))); static { STAIR_FROM_BLOCK.put(KRYP_SMOOTH, KRYP_SMOOTH_STAIRS); }
    public static final Block KRYP_SMOOTH_SLAB = registerBlockInBlockset(KRYP_BLOCKS, "kryp_smooth_slab", new SlabBlock(FabricBlockSettings.copyOf(KRYP_SMOOTH))); static { SLAB_FROM_BLOCK.put(KRYP_SMOOTH, KRYP_SMOOTH_SLAB); }
    public static final Block KRYP_SHEEN = registerBlockInBlockset(KRYP_BLOCKS, "kryp_sheen", new Block(FabricBlockSettings.copyOf(krypMaterial)));
    public static final Block KRYP_RUIN = registerBlockInBlockset(KRYP_BLOCKS, "kryp_ruin", new Block(FabricBlockSettings.copyOf(krypMaterial)));
    public static final Block KRYP_OMITTER = registerBlockInBlockset(KRYP_BLOCKS, "kryp_omitter", new LitBlock(FabricBlockSettings.copyOf(krypMaterial).luminance(createLightLevelFromProperty(11, Properties.LIT)), ModSoundEvents.BLOCK_POLYGON_ACTIVATE, null));
    public static final Block KRYP_LEVI = registerBlockInBlockset(KRYP_BLOCKS, "kryp_levi", new Block(FabricBlockSettings.copyOf(krypMaterial).luminance(state -> 9)));
    public static final Block KRYP_KUBT = registerBlockInBlockset(KRYP_BLOCKS, "kryp_kubt", new PillarBlock(FabricBlockSettings.copyOf(krypMaterial)));
    public static final Block KRYP_INFO = registerBlockInBlockset(KRYP_BLOCKS, "kryp_info", new Block(FabricBlockSettings.copyOf(krypMaterial).luminance(state -> 5)));
    public static final Block KRYP_DATA = registerBlockInBlockset(KRYP_BLOCKS, "kryp_data", new Block(FabricBlockSettings.copyOf(krypMaterial).luminance(state -> 5)));
    public static final Block KRYP_CONNECTOR = registerBlockInBlockset(KRYP_BLOCKS, "kryp_connector", new Block(FabricBlockSettings.copyOf(krypMaterial).luminance(state -> 5)));
    public static final Block KRYP_CHUNK = registerBlockInBlockset(KRYP_BLOCKS, "kryp_chunk", new GlazedTerracottaBlock(FabricBlockSettings.copyOf(krypMaterial)));
    public static final Block KRYP_BEAM = registerBlockInBlockset(KRYP_BLOCKS, "kryp_beam", new Block(FabricBlockSettings.copyOf(krypMaterial).luminance(state -> 9)));
    public static final Block KRYP_BASE = registerBlockInBlockset(KRYP_BLOCKS, "kryp_base", new Block(FabricBlockSettings.copyOf(krypMaterial).sounds(BlockSoundGroup.STONE)));
    public static final Block KRYP = registerBlockInBlockset(KRYP_BLOCKS, "kryp", new Block(FabricBlockSettings.copyOf(krypMaterial).sounds(BlockSoundGroup.CALCITE)));
    public static final Block KRYP_STAIRS = registerBlockInBlockset(KRYP_BLOCKS, "kryp_stairs", new StairsBlock(KRYP.getDefaultState(), FabricBlockSettings.copyOf(KRYP))); static { STAIR_FROM_BLOCK.put(KRYP, KRYP_STAIRS); }
    public static final Block KRYP_SLAB = registerBlockInBlockset(KRYP_BLOCKS, "kryp_slab", new SlabBlock(FabricBlockSettings.copyOf(KRYP))); static { SLAB_FROM_BLOCK.put(KRYP, KRYP_SLAB); }
    //</editor-fold>
    //<editor-fold desc ="Blocks - LAVE">
    private static final FabricBlockSettings laveMaterial = FabricBlockSettings.create()
            .mapColor(MapColor.LIGHT_BLUE_GRAY)
            .instrument(Instrument.BASEDRUM)
            .requiresTool()
            .strength(0.8f)
            .sounds(BlockSoundGroup.DECORATED_POT);
    public static final Block LAVE_WINDOW = registerBlockInBlockset(LAVE_BLOCKS, "lave_window", new Block(FabricBlockSettings.copyOf(laveMaterial)));
    public static final Block LAVE_VENT = registerBlockInBlockset(LAVE_BLOCKS, "lave_vent", new Block(FabricBlockSettings.copyOf(laveMaterial)));
    public static final Block LAVE_UNEVEN = registerBlockInBlockset(LAVE_BLOCKS, "lave_uneven", new Block(FabricBlockSettings.copyOf(laveMaterial)));
    public static final Block LAVE_TRACKPAD = registerBlockInBlockset(LAVE_BLOCKS, "lave_trackpad", new PillarBlock(FabricBlockSettings.copyOf(laveMaterial)));
    public static final Block LAVE_TILE = registerBlockInBlockset(LAVE_BLOCKS, "lave_tile", new Block(FabricBlockSettings.copyOf(laveMaterial)));
    public static final Block LAVE_TILE_STAIRS = registerBlockInBlockset(LAVE_BLOCKS, "lave_tile_stairs", new StairsBlock(LAVE_TILE.getDefaultState(), FabricBlockSettings.copyOf(LAVE_TILE))); static { STAIR_FROM_BLOCK.put(LAVE_TILE, LAVE_TILE_STAIRS); }
    public static final Block LAVE_TILE_SLAB = registerBlockInBlockset(LAVE_BLOCKS, "lave_tile_slab", new SlabBlock(FabricBlockSettings.copyOf(LAVE_TILE))); static { SLAB_FROM_BLOCK.put(LAVE_TILE, LAVE_TILE_SLAB); }
    public static final Block LAVE_THICK = registerBlockInBlockset(LAVE_BLOCKS, "lave_thick", new Block(FabricBlockSettings.copyOf(laveMaterial)));
    public static final Block LAVE_SECTION = registerBlockInBlockset(LAVE_BLOCKS, "lave_section", new Block(FabricBlockSettings.copyOf(laveMaterial)));
    public static final Block LAVE_PANEL = registerBlockInBlockset(LAVE_BLOCKS, "lave_panel", new Block(FabricBlockSettings.copyOf(laveMaterial)));
    public static final Block LAVE_LOW = registerBlockInBlockset(LAVE_BLOCKS, "lave_low", new Block(FabricBlockSettings.copyOf(laveMaterial).mapColor(MapColor.CYAN)));
    public static final Block LAVE_HEX = registerBlockInBlockset(LAVE_BLOCKS, "lave_hex", new Block(FabricBlockSettings.copyOf(laveMaterial)));
    public static final Block LAVE_ELEVATE = registerBlockInBlockset(LAVE_BLOCKS, "lave_elevate", new PillarBlock(FabricBlockSettings.copyOf(laveMaterial)));
    public static final Block LAVE_DIM = registerBlockInBlockset(LAVE_BLOCKS, "lave_dim", new Block(FabricBlockSettings.copyOf(laveMaterial)));
    public static final Block LAVE_DARK = registerBlockInBlockset(LAVE_BLOCKS, "lave_dark", new Block(FabricBlockSettings.copyOf(laveMaterial).mapColor(MapColor.CYAN)));
    public static final Block LAVE_CROSSSECTION = registerBlockInBlockset(LAVE_BLOCKS, "lave_crosssection", new Block(FabricBlockSettings.copyOf(laveMaterial)));
    public static final Block LAVE_BEAM = registerBlockInBlockset(LAVE_BLOCKS, "lave_beam", new PillarBlock(FabricBlockSettings.copyOf(laveMaterial)));
    public static final Block LAVE = registerBlockInBlockset(LAVE_BLOCKS, "lave", new Block(FabricBlockSettings.copyOf(laveMaterial)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - VEELD">
    private static final FabricBlockSettings veeldMaterial = FabricBlockSettings.create()
            .mapColor(MapColor.LICHEN_GREEN)
            .instrument(Instrument.BASEDRUM)
            .requiresTool()
            .strength(2.0f, 6.0f)
            .sounds(BlockSoundGroup.STONE);
    public static final Block VEELD_WET = registerBlockInBlockset(VEELD_BLOCKS, "veeld_wet", new Block(FabricBlockSettings.copyOf(veeldMaterial).mapColor(MapColor.GREEN)));
    public static final Block VEELD_TRACTION = registerBlockInBlockset(VEELD_BLOCKS, "veeld_traction", new PillarBlock(FabricBlockSettings.copyOf(veeldMaterial)));
    public static final Block VEELD_STRUCTURE = registerBlockInBlockset(VEELD_BLOCKS, "veeld_structure", new PillarBlock(FabricBlockSettings.copyOf(veeldMaterial)));
    public static final Block VEELD_RIVETED = registerBlockInBlockset(VEELD_BLOCKS, "veeld_riveted", new Block(FabricBlockSettings.copyOf(veeldMaterial)));
    public static final Block VEELD_RIPPLE = registerBlockInBlockset(VEELD_BLOCKS, "veeld_ripple", new Block(FabricBlockSettings.copyOf(veeldMaterial)));
    public static final Block VEELD_RIGIDBRICK = registerBlockInBlockset(VEELD_BLOCKS, "veeld_rigidbrick", new Block(FabricBlockSettings.copyOf(veeldMaterial)));
    public static final Block VEELD_RIGID = registerBlockInBlockset(VEELD_BLOCKS, "veeld_rigid", new Block(FabricBlockSettings.copyOf(veeldMaterial)));
    public static final Block VEELD_PIPEWEAVE = registerBlockInBlockset(VEELD_BLOCKS, "veeld_pipeweave", new Block(FabricBlockSettings.copyOf(veeldMaterial)));
    public static final Block VEELD_PATTERNED = registerBlockInBlockset(VEELD_BLOCKS, "veeld_patterned", new GlazedTerracottaBlock(FabricBlockSettings.copyOf(veeldMaterial)));
    public static final Block VEELD_PANEL = registerBlockInBlockset(VEELD_BLOCKS, "veeld_panel", new Block(FabricBlockSettings.copyOf(veeldMaterial)));
    public static final Block VEELD_ETCHED = registerBlockInBlockset(VEELD_BLOCKS, "veeld_etched", new Block(FabricBlockSettings.copyOf(veeldMaterial).mapColor(MapColor.GREEN)));
    public static final Block VEELD_EMBOSSED = registerBlockInBlockset(VEELD_BLOCKS, "veeld_embossed", new Block(FabricBlockSettings.copyOf(veeldMaterial).mapColor(MapColor.GREEN)));
    public static final Block VEELD_DRILL = registerBlockInBlockset(VEELD_BLOCKS, "veeld_drill", new PillarBlock(FabricBlockSettings.copyOf(veeldMaterial)));
    public static final Block VEELD_CORE = registerBlockInBlockset(VEELD_BLOCKS, "veeld_core", new Block(FabricBlockSettings.copyOf(veeldMaterial)));
    public static final Block VEELD_BRICK = registerBlockInBlockset(VEELD_BLOCKS, "veeld_brick", new Block(FabricBlockSettings.copyOf(veeldMaterial)));
    public static final Block VEELD = registerBlockInBlockset(VEELD_BLOCKS, "veeld", new Block(FabricBlockSettings.copyOf(veeldMaterial).mapColor(MapColor.GREEN)));
    public static final Block VEELD_STAIRS = registerBlockInBlockset(VEELD_BLOCKS, "veeld_stairs", new StairsBlock(VEELD.getDefaultState(), FabricBlockSettings.copyOf(VEELD))); static { STAIR_FROM_BLOCK.put(VEELD, VEELD_STAIRS); }
    public static final Block VEELD_SLAB = registerBlockInBlockset(VEELD_BLOCKS, "veeld_slab", new SlabBlock(FabricBlockSettings.copyOf(VEELD))); static { SLAB_FROM_BLOCK.put(VEELD, VEELD_SLAB); }
    //</editor-fold>
    //<editor-fold desc ="Blocks - JELT">
    private static final FabricBlockSettings jeltMaterial = FabricBlockSettings.create()
            .mapColor(MapColor.ORANGE)
            .requiresTool()
            .strength(2.4f, 2.0f)
            .sounds(ModBlockSoundGroup.POLYGON);
    public static final Block JELT_SUPPLY = registerBlockInBlockset(JELT_BLOCKS, "jelt_supply", new Block(FabricBlockSettings.copyOf(jeltMaterial)));
    public static final Block JELT_POKE = registerBlockInBlockset(JELT_BLOCKS, "jelt_poke", new Block(FabricBlockSettings.copyOf(jeltMaterial)));
    public static final Block JELT_PATHJOINT = registerBlockInBlockset(JELT_BLOCKS, "jelt_pathjoint", new GlazedTerracottaBlock(FabricBlockSettings.copyOf(jeltMaterial)));
    public static final Block JELT_PATH = registerBlockInBlockset(JELT_BLOCKS, "jelt_path", new PillarBlock(FabricBlockSettings.copyOf(jeltMaterial)));
    public static final Block JELT_ORGANIZE = registerBlockInBlockset(JELT_BLOCKS, "jelt_organize", new Block(FabricBlockSettings.copyOf(jeltMaterial)));
    public static final Block JELT_ORBULE = registerBlockInBlockset(JELT_BLOCKS, "jelt_orbule", new Block(FabricBlockSettings.copyOf(jeltMaterial)));
    public static final Block JELT_LUMINA = registerBlockInBlockset(JELT_BLOCKS, "jelt_lumina", new Block(FabricBlockSettings.copyOf(jeltMaterial)));
    public static final Block JELT_FUSION = registerBlockInBlockset(JELT_BLOCKS, "jelt_fusion", new Block(FabricBlockSettings.copyOf(jeltMaterial)));
    public static final Block JELT_FISSION = registerBlockInBlockset(JELT_BLOCKS, "jelt_fission", new Block(FabricBlockSettings.copyOf(jeltMaterial)));
    public static final Block JELT_EXHAUST = registerBlockInBlockset(JELT_BLOCKS, "jelt_exhaust", new PillarBlock(FabricBlockSettings.copyOf(jeltMaterial)));
    public static final Block JELT_ENERGY = registerBlockInBlockset(JELT_BLOCKS, "jelt_energy", new Block(FabricBlockSettings.copyOf(jeltMaterial)));
    public static final Block JELT_EMBOSS = registerBlockInBlockset(JELT_BLOCKS, "jelt_emboss", new Block(FabricBlockSettings.copyOf(jeltMaterial)));
    public static final Block JELT_DESTINE = registerBlockInBlockset(JELT_BLOCKS, "jelt_destine", new Block(FabricBlockSettings.copyOf(jeltMaterial)));
    public static final Block JELT_CONFINE = registerBlockInBlockset(JELT_BLOCKS, "jelt_confine", new Block(FabricBlockSettings.copyOf(jeltMaterial).mapColor(MapColor.BLACK)));
    public static final Block JELT_ATWAL = registerBlockInBlockset(JELT_BLOCKS, "jelt_atwal", new Block(FabricBlockSettings.copyOf(jeltMaterial)));
    public static final Block JELT = registerBlockInBlockset(JELT_BLOCKS, "jelt", new Block(FabricBlockSettings.copyOf(jeltMaterial)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - KORP">
    private static final FabricBlockSettings korpMaterial = FabricBlockSettings.create()
                    .mapColor(MapColor.TERRACOTTA_BLACK)
                    .requiresTool()
                    .strength(2.0f, 6.0f)
                    .sounds(BlockSoundGroup.METAL);
    public static final Block KORP_WALL = registerBlockInBlockset(KORP_BLOCKS, "korp_wall", new Block(FabricBlockSettings.copyOf(korpMaterial)));
    public static final Block KORP_VEST = registerBlockInBlockset(KORP_BLOCKS, "korp_vest", new PillarBlock(FabricBlockSettings.copyOf(korpMaterial)));
    public static final Block KORP_SECURE = registerBlockInBlockset(KORP_BLOCKS, "korp_secure", new Block(FabricBlockSettings.copyOf(korpMaterial)));
    public static final Block KORP_RUPT = registerBlockInBlockset(KORP_BLOCKS, "korp_rupt", new PillarBlock(FabricBlockSettings.copyOf(korpMaterial)));
    public static final Block KORP_RESOURCE = registerBlockInBlockset(KORP_BLOCKS, "korp_resource", new PillarBlock(FabricBlockSettings.copyOf(korpMaterial).mapColor(MapColor.DIAMOND_BLUE).luminance(state -> 11)));
    public static final Block KORP_REGULATE = registerBlockInBlockset(KORP_BLOCKS, "korp_regulate", new Block(FabricBlockSettings.copyOf(korpMaterial)));
    public static final Block KORP_OUTFLOW = registerBlockInBlockset(KORP_BLOCKS, "korp_outflow", new PillarBlock(FabricBlockSettings.copyOf(korpMaterial)));
    public static final Block KORP_MARK = registerBlockInBlockset(KORP_BLOCKS, "korp_mark", new Block(FabricBlockSettings.copyOf(korpMaterial)));
    public static final Block KORP_HOLDING = registerBlockInBlockset(KORP_BLOCKS, "korp_holding", new Block(FabricBlockSettings.copyOf(korpMaterial)));
    public static final Block KORP_GROWTH = registerBlockInBlockset(KORP_BLOCKS, "korp_growth", new Block(FabricBlockSettings.copyOf(korpMaterial)));
    public static final Block KORP_FLOW = registerBlockInBlockset(KORP_BLOCKS, "korp_flow", new PillarBlock(FabricBlockSettings.copyOf(korpMaterial).luminance(state -> 7)));
    public static final Block KORP_CONSUME = registerBlockInBlockset(KORP_BLOCKS, "korp_consume", new GlazedTerracottaBlock(FabricBlockSettings.copyOf(korpMaterial).luminance(state -> 7)));
    public static final Block KORP_COMMAND = registerBlockInBlockset(KORP_BLOCKS, "korp_command", new Block(FabricBlockSettings.copyOf(korpMaterial)));
    public static final Block KORP_BANK = registerBlockInBlockset(KORP_BLOCKS, "korp_bank", new Block(FabricBlockSettings.copyOf(korpMaterial).mapColor(MapColor.DIAMOND_BLUE).luminance(state -> 11)));
    public static final Block KORP_ASSET = registerBlockInBlockset(KORP_BLOCKS, "korp_asset", new Block(FabricBlockSettings.copyOf(korpMaterial)));
    public static final Block KORP = registerBlockInBlockset(KORP_BLOCKS, "korp", new Block(FabricBlockSettings.copyOf(korpMaterial)));
//    };
    //</editor-fold>
    //<editor-fold desc ="Blocks - TANK">
    private static final FabricBlockSettings tankMaterial = FabricBlockSettings.create()
            .mapColor(MapColor.LIGHT_GRAY)
            .requiresTool()
            .strength(2.4f, 2.0f)
            .sounds(ModBlockSoundGroup.POLYGON);
    public static final Block TANK_ZIZER = registerBlockInBlockset(TANK_BLOCKS, "tank_zizer", new Block(FabricBlockSettings.copyOf(tankMaterial)));
    public static final Block TANK_WINDOW = registerBlockInBlockset(TANK_BLOCKS, "tank_window", new Block(FabricBlockSettings.copyOf(tankMaterial)));
    public static final Block TANK_TREAD = registerBlockInBlockset(TANK_BLOCKS, "tank_tread", new Block(FabricBlockSettings.copyOf(tankMaterial)));
    public static final Block TANK_TILES = registerBlockInBlockset(TANK_BLOCKS, "tank_tiles", new Block(FabricBlockSettings.copyOf(tankMaterial)));
    public static final Block TANK_SECURE = registerBlockInBlockset(TANK_BLOCKS, "tank_secure", new Block(FabricBlockSettings.copyOf(tankMaterial)));
    public static final Block TANK_RIVET = registerBlockInBlockset(TANK_BLOCKS, "tank_rivet", new Block(FabricBlockSettings.copyOf(tankMaterial)));
    public static final Block TANK_RIGID = registerBlockInBlockset(TANK_BLOCKS, "tank_rigid", new PillarBlock(FabricBlockSettings.copyOf(tankMaterial)));
    public static final Block TANK_FUNCTION = registerBlockInBlockset(TANK_BLOCKS, "tank_function", new Block(FabricBlockSettings.copyOf(tankMaterial)));
    public static final Block TANK_FORTIFIED = registerBlockInBlockset(TANK_BLOCKS, "tank_fortified", new Block(FabricBlockSettings.copyOf(tankMaterial)));
    public static final Block TANK_FLEXI = registerBlockInBlockset(TANK_BLOCKS, "tank_flexi", new Block(FabricBlockSettings.copyOf(tankMaterial).mapColor(MapColor.GRAY)));
    public static final Block TANK_CONJUNCTION = registerBlockInBlockset(TANK_BLOCKS, "tank_conjunction", new Block(FabricBlockSettings.copyOf(tankMaterial)));
    public static final Block TANK_CANNON = registerBlockInBlockset(TANK_BLOCKS, "tank_cannon", new GlazedTerracottaBlock(FabricBlockSettings.copyOf(tankMaterial)));
    public static final Block TANK_BEAM = registerBlockInBlockset(TANK_BLOCKS, "tank_beam", new PillarBlock(FabricBlockSettings.copyOf(tankMaterial)));
    public static final Block TANK_BAND = registerBlockInBlockset(TANK_BLOCKS, "tank_band", new Block(FabricBlockSettings.copyOf(tankMaterial).mapColor(MapColor.GRAY)));
    public static final Block TANK_ARMOR = registerBlockInBlockset(TANK_BLOCKS, "tank_armor", new Block(FabricBlockSettings.copyOf(tankMaterial)));
    public static final Block TANK = registerBlockInBlockset(TANK_BLOCKS, "tank", new Block(FabricBlockSettings.copyOf(tankMaterial)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - EXRI">
    private static final FabricBlockSettings exriMaterial = FabricBlockSettings.create()
            .mapColor(MapColor.GRAY)
            .requiresTool()
            .strength(1.8f)
            .sounds(BlockSoundGroup.COPPER);
    public static final Block EXRI_LEVEL = registerBlockInBlockset(EXRI_BLOCKS, "exri_level", new RedstoneLampBlock(FabricBlockSettings.copyOf(exriMaterial)));
    public static final Block EXRI_TECT = registerBlockInBlockset(EXRI_BLOCKS, "exri_tect", new Block(FabricBlockSettings.copyOf(exriMaterial)));
    public static final Block EXRI_STEM = registerBlockInBlockset(EXRI_BLOCKS, "exri_stem", new Block(FabricBlockSettings.copyOf(exriMaterial)));
    public static final Block EXRI_STEEL = registerBlockInBlockset(EXRI_BLOCKS, "exri_steel", new Block(FabricBlockSettings.copyOf(exriMaterial)));
    public static final Block EXRI_SERVE = registerBlockInBlockset(EXRI_BLOCKS, "exri_serve", new RedstoneLampBlock(FabricBlockSettings.copyOf(exriMaterial)));
    public static final Block EXRI_SEAL = registerBlockInBlockset(EXRI_BLOCKS, "exri_seal", new Block(FabricBlockSettings.copyOf(exriMaterial)));
    public static final Block EXRI_SCREEN = registerBlockInBlockset(EXRI_BLOCKS, "exri_screen", new Block(FabricBlockSettings.copyOf(exriMaterial).sounds(ModBlockSoundGroup.NEON)));
    public static final Block EXRI_ROGEN = registerBlockInBlockset(EXRI_BLOCKS, "exri_rogen", new Block(FabricBlockSettings.copyOf(exriMaterial)));
    public static final Block EXRI_MESH = registerBlockInBlockset(EXRI_BLOCKS, "exri_mesh", new Block(FabricBlockSettings.copyOf(exriMaterial)));
    public static final Block EXRI_FLOW = registerBlockInBlockset(EXRI_BLOCKS, "exri_flow", new RedstoneLampBlock(FabricBlockSettings.copyOf(exriMaterial)));
    public static final Block EXRI_DIVIDE = registerBlockInBlockset(EXRI_BLOCKS, "exri_divide", new Block(FabricBlockSettings.copyOf(exriMaterial)));
    public static final Block EXRI_DIVIDE_STAIRS = registerBlockInBlockset(EXRI_BLOCKS, "exri_divide_stairs", new StairsBlock(EXRI_DIVIDE.getDefaultState(), FabricBlockSettings.copyOf(EXRI_DIVIDE))); static { STAIR_FROM_BLOCK.put(EXRI_DIVIDE, EXRI_DIVIDE_STAIRS); }
    public static final Block EXRI_DIVIDE_SLAB = registerBlockInBlockset(EXRI_BLOCKS, "exri_divide_slab", new SlabBlock(FabricBlockSettings.copyOf(EXRI_DIVIDE))); static { SLAB_FROM_BLOCK.put(EXRI_DIVIDE, EXRI_DIVIDE_SLAB); }
    public static final Block EXRI_DISPLAY = registerBlockInBlockset(EXRI_BLOCKS, "exri_display", new RedstoneLampBlock(FabricBlockSettings.copyOf(exriMaterial)));
    public static final Block EXRI_CURRENT = registerBlockInBlockset(EXRI_BLOCKS, "exri_current", new RedstoneLampBlock(FabricBlockSettings.copyOf(exriMaterial)));
    public static final Block EXRI_CRITICAL = registerBlockInBlockset(EXRI_BLOCKS, "exri_critical", new RedstoneLampBlock(FabricBlockSettings.copyOf(exriMaterial)));
    public static final Block EXRI_CONTROL = registerBlockInBlockset(EXRI_BLOCKS, "exri_control", new RedstoneLampBlock(FabricBlockSettings.copyOf(exriMaterial)));
    public static final Block EXRI = registerBlockInBlockset(EXRI_BLOCKS, "exri", new Block(FabricBlockSettings.copyOf(exriMaterial)));

    //TODO bit blockset always emits a redstone level of 1   
    //</editor-fold>
    //<editor-fold desc ="Blocks - AZUR">
    private static final FabricBlockSettings azurMaterial = FabricBlockSettings.create()
            .mapColor(MapColor.LAPIS_BLUE)
            .requiresTool()
            .strength(2.4f, 2.0f)
            .sounds(ModBlockSoundGroup.POLYGON);
    public static final Block AZUR_CRIPT = registerBlockInBlockset(AZUR_BLOCKS, "azur_cript", new PillarBlock(FabricBlockSettings.copyOf(azurMaterial)));
    public static final Block AZUR_CUBE = registerBlockInBlockset(AZUR_BLOCKS, "azur_cube", new Block(FabricBlockSettings.copyOf(azurMaterial)));
    public static final Block AZUR_CYBER = registerBlockInBlockset(AZUR_BLOCKS, "azur_cyber", new PillarBlock(FabricBlockSettings.copyOf(azurMaterial)));
    public static final Block AZUR_GUIDE = registerBlockInBlockset(AZUR_BLOCKS, "azur_guide", new PillarBlock(FabricBlockSettings.copyOf(azurMaterial)));
    public static final Block AZUR_KINETIC = registerBlockInBlockset(AZUR_BLOCKS, "azur_kinetic", new Block(FabricBlockSettings.copyOf(azurMaterial)));
    public static final Block AZUR_NEURON = registerBlockInBlockset(AZUR_BLOCKS, "azur_neuron", new Block(FabricBlockSettings.copyOf(azurMaterial)));
    public static final Block AZUR_PAVE = registerBlockInBlockset(AZUR_BLOCKS, "azur_pave", new Block(FabricBlockSettings.copyOf(azurMaterial)));
    public static final Block AZUR_PERATION = registerBlockInBlockset(AZUR_BLOCKS, "azur_peration", new Block(FabricBlockSettings.copyOf(azurMaterial)));
    public static final Block AZUR_PLUG = registerBlockInBlockset(AZUR_BLOCKS, "azur_plug", new Block(FabricBlockSettings.copyOf(azurMaterial)));
    public static final Block AZUR_RIPPLE = registerBlockInBlockset(AZUR_BLOCKS, "azur_ripple", new Block(FabricBlockSettings.copyOf(azurMaterial)));
    public static final Block AZUR_RUN = registerBlockInBlockset(AZUR_BLOCKS, "azur_run", new Block(FabricBlockSettings.copyOf(azurMaterial)));
    public static final Block AZUR_SCRAPE = registerBlockInBlockset(AZUR_BLOCKS, "azur_scrape", new Block(FabricBlockSettings.copyOf(azurMaterial)));
    public static final Block AZUR_SENSORY = registerBlockInBlockset(AZUR_BLOCKS, "azur_sensory", new Block(FabricBlockSettings.copyOf(azurMaterial)));
    public static final Block AZUR_SIGN = registerBlockInBlockset(AZUR_BLOCKS, "azur_sign", new Block(FabricBlockSettings.copyOf(azurMaterial)));
    public static final Block AZUR_SIGNAL = registerBlockInBlockset(AZUR_BLOCKS, "azur_signal", new PillarBlock(FabricBlockSettings.copyOf(azurMaterial)));
    public static final Block AZUR = registerBlockInBlockset(AZUR_BLOCKS, "azur", new Block(FabricBlockSettings.copyOf(azurMaterial)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - FLEQ">
    private static final FabricBlockSettings fleqMaterial = FabricBlockSettings.create()
            .mapColor(MapColor.DARK_AQUA)
            .requiresTool()
            .strength(2.4f, 2.0f)
            .sounds(ModBlockSoundGroup.POLYGON);
    public static final Block FLEQ_WET = registerBlockInBlockset(FLEQ_BLOCKS, "fleq_wet", new Block(FabricBlockSettings.copyOf(fleqMaterial)));
    public static final Block FLEQ_VALVE = registerBlockInBlockset(FLEQ_BLOCKS, "fleq_valve", new Block(FabricBlockSettings.copyOf(fleqMaterial)));
    public static final Block FLEQ_TUBE = registerBlockInBlockset(FLEQ_BLOCKS, "fleq_tube", new PillarBlock(FabricBlockSettings.copyOf(fleqMaterial)));
    public static final Block FLEQ_STACK = registerBlockInBlockset(FLEQ_BLOCKS, "fleq_stack", new Block(FabricBlockSettings.copyOf(fleqMaterial)));
    public static final Block FLEQ_RUBBLE = registerBlockInBlockset(FLEQ_BLOCKS, "fleq_rubble", new Block(FabricBlockSettings.copyOf(fleqMaterial).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final Block FLEQ_RECK = registerBlockInBlockset(FLEQ_BLOCKS, "fleq_reck", new Block(FabricBlockSettings.copyOf(fleqMaterial).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final Block FLEQ_PIPE = registerBlockInBlockset(FLEQ_BLOCKS, "fleq_pipe", new GlazedTerracottaBlock(FabricBlockSettings.copyOf(fleqMaterial)));
    public static final Block FLEQ_LENT = registerBlockInBlockset(FLEQ_BLOCKS, "fleq_lent", new Block(FabricBlockSettings.copyOf(fleqMaterial)));
    public static final Block FLEQ_LARVAE = registerBlockInBlockset(FLEQ_BLOCKS, "fleq_larvae", new GlazedTerracottaBlock(FabricBlockSettings.copyOf(fleqMaterial)));
    public static final Block FLEQ_ILLUSION = registerBlockInBlockset(FLEQ_BLOCKS, "fleq_illusion", new Block(FabricBlockSettings.copyOf(fleqMaterial)));
    public static final Block FLEQ_ERODE = registerBlockInBlockset(FLEQ_BLOCKS, "fleq_erode", new Block(FabricBlockSettings.copyOf(fleqMaterial).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final Block FLEQ_DIRECT = registerBlockInBlockset(FLEQ_BLOCKS, "fleq_direct", new PillarBlock(FabricBlockSettings.copyOf(fleqMaterial)));
    public static final Block FLEQ_BUBBLE = registerBlockInBlockset(FLEQ_BLOCKS, "fleq_bubble", new Block(FabricBlockSettings.copyOf(fleqMaterial)));
    public static final Block FLEQ_BOLDEN = registerBlockInBlockset(FLEQ_BLOCKS, "fleq_bolden", new Block(FabricBlockSettings.copyOf(fleqMaterial)));
    public static final Block FLEQ_ABODE = registerBlockInBlockset(FLEQ_BLOCKS, "fleq_abode", new Block(FabricBlockSettings.copyOf(fleqMaterial)));
    public static final Block FLEQ = registerBlockInBlockset(FLEQ_BLOCKS, "fleq", new Block(FabricBlockSettings.copyOf(fleqMaterial)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - ISZM">
    private static final FabricBlockSettings iszmMaterial = FabricBlockSettings.create()
            .strength(0.3f)
            .luminance(state -> 11)
            .sounds(ModBlockSoundGroup.NEON);
    public static final Block WARM_ISZM = registerBlockInBlockset(ISZM_BLOCKS, "warm_iszm", new Block(FabricBlockSettings.copyOf(iszmMaterial).mapColor(MapColor.TERRACOTTA_LIME)));
    public static final Block VIBRANT_ISZM = registerBlockInBlockset(ISZM_BLOCKS, "vibrant_iszm", new Block(FabricBlockSettings.copyOf(iszmMaterial).mapColor(MapColor.PALE_GREEN)));
    public static final Block STUDY_ISZM = registerBlockInBlockset(ISZM_BLOCKS, "study_iszm", new Block(FabricBlockSettings.copyOf(iszmMaterial).mapColor(MapColor.BLUE)));
    public static final Block SCORCHED_ISZM = registerBlockInBlockset(ISZM_BLOCKS, "scorched_iszm", new Block(FabricBlockSettings.copyOf(iszmMaterial).mapColor(MapColor.DARK_CRIMSON)));
    public static final Block RED_ISZM = registerBlockInBlockset(ISZM_BLOCKS, "red_iszm", new Block(FabricBlockSettings.copyOf(iszmMaterial).mapColor(MapColor.DULL_RED)));
    public static final Block PINK_ISZM = registerBlockInBlockset(ISZM_BLOCKS, "pink_iszm", new Block(FabricBlockSettings.copyOf(iszmMaterial).mapColor(MapColor.TERRACOTTA_RED)));
    public static final Block NEUTRAL_ISZM = registerBlockInBlockset(ISZM_BLOCKS, "neutral_iszm", new Block(FabricBlockSettings.copyOf(iszmMaterial).mapColor(MapColor.WHITE_GRAY)));
    public static final Block GREEN_ISZM = registerBlockInBlockset(ISZM_BLOCKS, "green_iszm", new Block(FabricBlockSettings.copyOf(iszmMaterial).mapColor(MapColor.LIME)));
    public static final Block GAME_ISZM = registerBlockInBlockset(ISZM_BLOCKS, "game_iszm", new Block(FabricBlockSettings.copyOf(iszmMaterial).mapColor(MapColor.GREEN)));
    public static final Block FADED_ISZM = registerBlockInBlockset(ISZM_BLOCKS, "faded_iszm", new Block(FabricBlockSettings.copyOf(iszmMaterial).mapColor(MapColor.PALE_YELLOW)));
    public static final Block DUSTY_ISZM = registerBlockInBlockset(ISZM_BLOCKS, "dusty_iszm", new Block(FabricBlockSettings.copyOf(iszmMaterial).mapColor(MapColor.OAK_TAN)));
    public static final Block DARK_ISZM = registerBlockInBlockset(ISZM_BLOCKS, "dark_iszm", new Block(FabricBlockSettings.copyOf(iszmMaterial).mapColor(MapColor.DARK_RED)));
    public static final Block COLD_ISZM = registerBlockInBlockset(ISZM_BLOCKS, "cold_iszm", new Block(FabricBlockSettings.copyOf(iszmMaterial).mapColor(MapColor.TERRACOTTA_LIGHT_BLUE)));
    public static final Block BURNED_ISZM = registerBlockInBlockset(ISZM_BLOCKS, "burned_iszm", new Block(FabricBlockSettings.copyOf(iszmMaterial).mapColor(MapColor.TERRACOTTA_GREEN)));
    public static final Block WHITE_ISZM = registerBlockInBlockset(ISZM_BLOCKS, "white_iszm", new Block(FabricBlockSettings.copyOf(iszmMaterial).mapColor(MapColor.TERRACOTTA_WHITE)));
    public static final Block ISZM = registerBlockInBlockset(ISZM_BLOCKS, "iszm", new Block(FabricBlockSettings.copyOf(iszmMaterial).mapColor(MapColor.GRAY)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - MYST">
    private static final FabricBlockSettings mystMaterial = FabricBlockSettings.create() // TODO, color based scrolling animation
            .strength(0.3f)
            .mapColor(MapColor.CLEAR)
            .nonOpaque()
            .allowsSpawning(ModBlocks::never)
            .solidBlock(ModBlocks::never)
            .suffocates(ModBlocks::never)
            .blockVision(ModBlocks::never)
            .sounds(BlockSoundGroup.SNOW);
    public static final Block RED_MYST = registerBlockInBlockset(MYST_BLOCKS, "red_myst", new GlassBlock(FabricBlockSettings.copyOf(mystMaterial)));
    public static final Block PURPLE_MYST = registerBlockInBlockset(MYST_BLOCKS, "purple_myst", new GlassBlock(FabricBlockSettings.copyOf(mystMaterial)));
    public static final Block PINK_MYST = registerBlockInBlockset(MYST_BLOCKS, "pink_myst", new GlassBlock(FabricBlockSettings.copyOf(mystMaterial)));
    public static final Block ORANGE_MYST = registerBlockInBlockset(MYST_BLOCKS, "orange_myst", new GlassBlock(FabricBlockSettings.copyOf(mystMaterial)));
    public static final Block MAGENTA_MYST = registerBlockInBlockset(MYST_BLOCKS, "magenta_myst", new GlassBlock(FabricBlockSettings.copyOf(mystMaterial)));
    public static final Block LIME_MYST = registerBlockInBlockset(MYST_BLOCKS, "lime_myst", new GlassBlock(FabricBlockSettings.copyOf(mystMaterial)));
    public static final Block LIGHT_GRAY_MYST = registerBlockInBlockset(MYST_BLOCKS, "light_gray_myst", new GlassBlock(FabricBlockSettings.copyOf(mystMaterial)));
    public static final Block LIGHT_BLUE_MYST = registerBlockInBlockset(MYST_BLOCKS, "light_blue_myst", new GlassBlock(FabricBlockSettings.copyOf(mystMaterial)));
    public static final Block GREEN_MYST = registerBlockInBlockset(MYST_BLOCKS, "green_myst", new GlassBlock(FabricBlockSettings.copyOf(mystMaterial)));
    public static final Block GRAY_MYST = registerBlockInBlockset(MYST_BLOCKS, "gray_myst", new GlassBlock(FabricBlockSettings.copyOf(mystMaterial)));
    public static final Block CYAN_MYST = registerBlockInBlockset(MYST_BLOCKS, "cyan_myst", new GlassBlock(FabricBlockSettings.copyOf(mystMaterial)));
    public static final Block BROWN_MYST = registerBlockInBlockset(MYST_BLOCKS, "brown_myst", new GlassBlock(FabricBlockSettings.copyOf(mystMaterial)));
    public static final Block BLUE_MYST = registerBlockInBlockset(MYST_BLOCKS, "blue_myst", new GlassBlock(FabricBlockSettings.copyOf(mystMaterial)));
    public static final Block BLACK_MYST = registerBlockInBlockset(MYST_BLOCKS, "black_myst", new GlassBlock(FabricBlockSettings.copyOf(mystMaterial)));
    public static final Block YELLOW_MYST = registerBlockInBlockset(MYST_BLOCKS, "yellow_myst", new GlassBlock(FabricBlockSettings.copyOf(mystMaterial)));
    public static final Block WHITE_MYST = registerBlockInBlockset(MYST_BLOCKS, "white_myst", new GlassBlock(FabricBlockSettings.copyOf(mystMaterial)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - SYNC">
    private static final FabricBlockSettings syncMaterial = FabricBlockSettings.create()
            .mapColor(MapColor.LIME)
            .requiresTool()
            .strength(2.4f, 2.0f)
            .sounds(ModBlockSoundGroup.POLYGON);
    public static final Block SYNC_TANK = registerBlockInBlockset(SYNC_BLOCKS, "sync_tank", new PillarBlock(FabricBlockSettings.copyOf(syncMaterial)));
    public static final Block SYNC_SHIELDING = registerBlockInBlockset(SYNC_BLOCKS, "sync_shielding", new Block(FabricBlockSettings.copyOf(syncMaterial).mapColor(MapColor.BLACK)));
    public static final Block SYNC_SAFE = registerBlockInBlockset(SYNC_BLOCKS, "sync_safe", new Block(FabricBlockSettings.copyOf(syncMaterial).mapColor(MapColor.BLACK)));
    public static final Block SYNC_MIZMER = registerBlockInBlockset(SYNC_BLOCKS, "sync_mizmer", new GlazedTerracottaBlock(FabricBlockSettings.copyOf(syncMaterial)));
    public static final Block SYNC_MESS = registerBlockInBlockset(SYNC_BLOCKS, "sync_mess", new Block(FabricBlockSettings.copyOf(syncMaterial)));
    public static final Block SYNC_LEADED = registerBlockInBlockset(SYNC_BLOCKS, "sync_leaded", new Block(FabricBlockSettings.copyOf(syncMaterial).mapColor(MapColor.BLACK)));
    public static final Block SYNC_JUNCTION = registerBlockInBlockset(SYNC_BLOCKS, "sync_junction", new Block(FabricBlockSettings.copyOf(syncMaterial)));
    public static final Block SYNC_HEX = registerBlockInBlockset(SYNC_BLOCKS, "sync_hex", new PillarBlock(FabricBlockSettings.copyOf(syncMaterial)));
    public static final Block SYNC_HAZARD = registerBlockInBlockset(SYNC_BLOCKS, "sync_hazard", new Block(FabricBlockSettings.copyOf(syncMaterial)));
    public static final Block SYNC_HATCH = registerBlockInBlockset(SYNC_BLOCKS, "sync_hatch", new Block(FabricBlockSettings.copyOf(syncMaterial)));
    public static final Block SYNC_FRAMED = registerBlockInBlockset(SYNC_BLOCKS, "sync_framed", new Block(FabricBlockSettings.copyOf(syncMaterial)));
    public static final Block SYNC_FORCE = registerBlockInBlockset(SYNC_BLOCKS, "sync_force", new Block(FabricBlockSettings.copyOf(syncMaterial)));
    public static final Block SYNC_DATA = registerBlockInBlockset(SYNC_BLOCKS, "sync_data", new Block(FabricBlockSettings.copyOf(syncMaterial)));
    public static final Block SYNC_CONTAIN = registerBlockInBlockset(SYNC_BLOCKS, "sync_contain", new Block(FabricBlockSettings.copyOf(syncMaterial)));
    public static final Block SYNC_CAUTION = registerBlockInBlockset(SYNC_BLOCKS, "sync_caution", new PillarBlock(FabricBlockSettings.copyOf(syncMaterial)));
    public static final Block SYNC = registerBlockInBlockset(SYNC_BLOCKS, "sync", new Block(FabricBlockSettings.copyOf(syncMaterial)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - NURR">
    private static final FabricBlockSettings nurrMaterial = FabricBlockSettings.create()
            .requiresTool()
            .strength(1.2f)
            .luminance(state -> 11)
            .sounds(ModBlockSoundGroup.NEON);
    public static final Block NURR_EMPTY = registerBlockInBlockset(NURR_BLOCKS, "empty_nurr", new PillarBlock(FabricBlockSettings.copyOf(nurrMaterial).mapColor(MapColor.BLACK).luminance(state -> 0)));
    public static final Block NURR = registerBlockInBlockset(NURR_BLOCKS, "nurr", new PillarBlock(FabricBlockSettings.copyOf(nurrMaterial).mapColor(MapColor.GRAY)));
    public static final Block NAVY_NURR = registerBlockInBlockset(NURR_BLOCKS, "navy_nurr", new PillarBlock(FabricBlockSettings.copyOf(nurrMaterial).mapColor(MapColor.TERRACOTTA_BLUE)));
    public static final Block MINT_NURR = registerBlockInBlockset(NURR_BLOCKS, "mint_nurr", new PillarBlock(FabricBlockSettings.copyOf(nurrMaterial).mapColor(MapColor.BRIGHT_TEAL)));
    public static final Block MAGENTA_NURR = registerBlockInBlockset(NURR_BLOCKS, "magenta_nurr", new PillarBlock(FabricBlockSettings.copyOf(nurrMaterial).mapColor(MapColor.MAGENTA)));
    public static final Block LIME_NURR = registerBlockInBlockset(NURR_BLOCKS, "lime_nurr", new PillarBlock(FabricBlockSettings.copyOf(nurrMaterial).mapColor(MapColor.LIME)));
    public static final Block GREEN_NURR = registerBlockInBlockset(NURR_BLOCKS, "green_nurr", new PillarBlock(FabricBlockSettings.copyOf(nurrMaterial).mapColor(MapColor.EMERALD_GREEN)));
    public static final Block FUCHSIA_NURR = registerBlockInBlockset(NURR_BLOCKS, "fuchsia_nurr", new PillarBlock(FabricBlockSettings.copyOf(nurrMaterial).mapColor(MapColor.TERRACOTTA_MAGENTA)));
    public static final Block CYAN_NURR = registerBlockInBlockset(NURR_BLOCKS, "cyan_nurr", new PillarBlock(FabricBlockSettings.copyOf(nurrMaterial).mapColor(MapColor.DIAMOND_BLUE)));
    public static final Block CERULEAN_NURR = registerBlockInBlockset(NURR_BLOCKS, "cerulean_nurr", new PillarBlock(FabricBlockSettings.copyOf(nurrMaterial).mapColor(MapColor.LIGHT_BLUE)));
    public static final Block BLUE_NURR = registerBlockInBlockset(NURR_BLOCKS, "blue_nurr", new PillarBlock(FabricBlockSettings.copyOf(nurrMaterial).mapColor(MapColor.BLUE)));
    public static final Block AMBER_NURR = registerBlockInBlockset(NURR_BLOCKS, "amber_nurr", new PillarBlock(FabricBlockSettings.copyOf(nurrMaterial).mapColor(MapColor.TERRACOTTA_YELLOW)));
    public static final Block YELLOW_NURR = registerBlockInBlockset(NURR_BLOCKS, "yellow_nurr", new PillarBlock(FabricBlockSettings.copyOf(nurrMaterial).mapColor(MapColor.YELLOW)));
    public static final Block RED_NURR = registerBlockInBlockset(NURR_BLOCKS, "red_nurr", new PillarBlock(FabricBlockSettings.copyOf(nurrMaterial).mapColor(MapColor.RED)));
    public static final Block PURPLE_NURR = registerBlockInBlockset(NURR_BLOCKS, "purple_nurr", new PillarBlock(FabricBlockSettings.copyOf(nurrMaterial).mapColor(MapColor.PURPLE)));
    public static final Block ORANGE_NURR = registerBlockInBlockset(NURR_BLOCKS, "orange_nurr", new PillarBlock(FabricBlockSettings.copyOf(nurrMaterial).mapColor(MapColor.ORANGE)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - TYEL">
    private static final FabricBlockSettings tyelMaterial = FabricBlockSettings.create()
            .requiresTool()
            .strength(1.4f)
            .sounds(BlockSoundGroup.STONE);
    public static final Block TAN_TYEL = registerBlockInBlockset(TYEL_BLOCKS, "tan_tyel", new Block(FabricBlockSettings.copyOf(tyelMaterial).mapColor(MapColor.RAW_IRON_PINK)));
    public static final Block RED_TYEL = registerBlockInBlockset(TYEL_BLOCKS, "red_tyel", new Block(FabricBlockSettings.copyOf(tyelMaterial).mapColor(MapColor.RED)));
    public static final Block PURPLE_TYEL = registerBlockInBlockset(TYEL_BLOCKS, "purple_tyel", new Block(FabricBlockSettings.copyOf(tyelMaterial).mapColor(MapColor.PURPLE)));
    public static final Block MAGENTA_TYEL = registerBlockInBlockset(TYEL_BLOCKS, "magenta_tyel", new Block(FabricBlockSettings.copyOf(tyelMaterial).mapColor(MapColor.MAGENTA)));
    public static final Block LIME_TYEL = registerBlockInBlockset(TYEL_BLOCKS, "lime_tyel", new Block(FabricBlockSettings.copyOf(tyelMaterial).mapColor(MapColor.LIME)));
    public static final Block GREEN_TYEL = registerBlockInBlockset(TYEL_BLOCKS, "green_tyel", new Block(FabricBlockSettings.copyOf(tyelMaterial).mapColor(MapColor.GREEN)));
    public static final Block FUCHSIA_TYEL = registerBlockInBlockset(TYEL_BLOCKS, "fuchsia_tyel", new Block(FabricBlockSettings.copyOf(tyelMaterial).mapColor(MapColor.DULL_PINK)));
    public static final Block CYAN_TYEL = registerBlockInBlockset(TYEL_BLOCKS, "cyan_tyel", new Block(FabricBlockSettings.copyOf(tyelMaterial).mapColor(MapColor.DIAMOND_BLUE)));
    public static final Block CHARTREUSE_TYEL = registerBlockInBlockset(TYEL_BLOCKS, "chartreuse_tyel", new Block(FabricBlockSettings.copyOf(tyelMaterial).mapColor(MapColor.LIME)));
    public static final Block CERULEAN_TYEL = registerBlockInBlockset(TYEL_BLOCKS, "cerulean_tyel", new Block(FabricBlockSettings.copyOf(tyelMaterial).mapColor(MapColor.LIGHT_BLUE)));
    public static final Block BLUE_TYEL = registerBlockInBlockset(TYEL_BLOCKS, "blue_tyel", new Block(FabricBlockSettings.copyOf(tyelMaterial).mapColor(MapColor.BLUE)));
    public static final Block AMBER_TYEL = registerBlockInBlockset(TYEL_BLOCKS, "amber_tyel", new Block(FabricBlockSettings.copyOf(tyelMaterial).mapColor(MapColor.TERRACOTTA_YELLOW)));
    public static final Block YELLOW_TYEL = registerBlockInBlockset(TYEL_BLOCKS, "yellow_tyel", new Block(FabricBlockSettings.copyOf(tyelMaterial).mapColor(MapColor.YELLOW)));
    public static final Block VERMILION_TYEL = registerBlockInBlockset(TYEL_BLOCKS, "vermilion_tyel", new Block(FabricBlockSettings.copyOf(tyelMaterial).mapColor(MapColor.TERRACOTTA_ORANGE)));
    public static final Block TYEL_EMPTY = registerBlockInBlockset(TYEL_BLOCKS, "tyel_empty", new Block(FabricBlockSettings.copyOf(tyelMaterial).mapColor(MapColor.BLACK)));
    public static final Block TYEL = registerBlockInBlockset(TYEL_BLOCKS, "tyel", new Block(FabricBlockSettings.copyOf(tyelMaterial).mapColor(MapColor.WHITE_GRAY)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - ROEN">
    private static final FabricBlockSettings roenMaterial = FabricBlockSettings.create()
            .mapColor(MapColor.LICHEN_GREEN)
            .strength(0.6f)
            .sounds(ModBlockSoundGroup.LAIR);
    public static final Block ROEN_DESSICATE = registerBlockInBlockset(ROEN_BLOCKS, "roen_dessicate", new Block(FabricBlockSettings.copyOf(roenMaterial).mapColor(MapColor.RAW_IRON_PINK)));
    public static final Block ROEN_LESION = registerBlockInBlockset(ROEN_BLOCKS, "roen_lesion", new PillarBlock(FabricBlockSettings.copyOf(roenMaterial).mapColor(MapColor.RED))); //TODO custom top texture
    public static final Block ROEN_TRACT = registerBlockInBlockset(ROEN_BLOCKS, "roen_tract", new PillarBlock(FabricBlockSettings.copyOf(roenMaterial).mapColor(MapColor.PURPLE)));
    public static final Block ROEN_AGAR = registerBlockInBlockset(ROEN_BLOCKS, "roen_agar", new Block(FabricBlockSettings.copyOf(roenMaterial).mapColor(MapColor.MAGENTA)));
    public static final Block ROEN_KINESIN = registerBlockInBlockset(ROEN_BLOCKS, "roen_kinesin", new GlazedTerracottaBlock(FabricBlockSettings.copyOf(roenMaterial).mapColor(MapColor.GREEN)));
    public static final Block ROEN_GEL = registerBlockInBlockset(ROEN_BLOCKS, "roen_gel", new Block(FabricBlockSettings.copyOf(roenMaterial).mapColor(MapColor.DULL_PINK)));
    public static final Block ROEN_STRAND = registerBlockInBlockset(ROEN_BLOCKS, "roen_strand", new Block(FabricBlockSettings.copyOf(roenMaterial).mapColor(MapColor.DIAMOND_BLUE)));
    public static final Block ROEN_MEMB = registerBlockInBlockset(ROEN_BLOCKS, "roen_memb", new Block(FabricBlockSettings.copyOf(roenMaterial).mapColor(MapColor.LIME)));
    public static final Block ROEN_FILM = registerBlockInBlockset(ROEN_BLOCKS, "roen_film", new Block(FabricBlockSettings.copyOf(roenMaterial).mapColor(MapColor.LIGHT_BLUE)));
    public static final Block ROEN_ARRAY = registerBlockInBlockset(ROEN_BLOCKS, "roen_array", new Block(FabricBlockSettings.copyOf(roenMaterial).mapColor(MapColor.BLUE)));
    public static final Block ROEN_BACILLUS = registerBlockInBlockset(ROEN_BLOCKS, "roen_bacillus", new PillarBlock(FabricBlockSettings.copyOf(roenMaterial).mapColor(MapColor.TERRACOTTA_YELLOW)));
    public static final Block ROEN_ASSAY = registerBlockInBlockset(ROEN_BLOCKS, "roen_assay", new Block(FabricBlockSettings.copyOf(roenMaterial).mapColor(MapColor.YELLOW)));
    public static final Block ROEN_OPERON = registerBlockInBlockset(ROEN_BLOCKS, "roen_operon", new PillarBlock(FabricBlockSettings.copyOf(roenMaterial).mapColor(MapColor.TERRACOTTA_ORANGE))); //TODO custom top texture
    public static final Block ROEN_ONCOGENE = registerBlockInBlockset(ROEN_BLOCKS, "roen_oncogene", new Block(FabricBlockSettings.copyOf(roenMaterial).mapColor(MapColor.BLACK)));
    public static final Block ROEN_GROUT = registerBlockInBlockset(ROEN_BLOCKS, "roen_grout", new Block(FabricBlockSettings.copyOf(roenMaterial).mapColor(MapColor.WHITE_GRAY)));
    public static final Block ROEN = registerBlockInBlockset(ROEN_BLOCKS, "roen", new Block(FabricBlockSettings.copyOf(roenMaterial).mapColor(MapColor.LIME)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - SOL">
    private static final FabricBlockSettings solMaterial = FabricBlockSettings.create()
            .mapColor(MapColor.TERRACOTTA_YELLOW)
            .strength(0.3f)
            .luminance(createLightLevelFromProperty(15, Properties.LIT))
            .mapColor(state -> state.get(Properties.LIT) ? MapColor.OFF_WHITE : MapColor.TERRACOTTA_YELLOW)
            .sounds(ModBlockSoundGroup.SOL);
    private static final FabricBlockSettings solMaterialDim = FabricBlockSettings.create()
            .mapColor(MapColor.TERRACOTTA_YELLOW)
            .strength(0.3f)
            .luminance(createLightLevelFromProperty(11, Properties.LIT))
            .mapColor(state -> state.get(Properties.LIT) ? MapColor.YELLOW : MapColor.TERRACOTTA_ORANGE)
            .sounds(ModBlockSoundGroup.SOL);
    public static final Block SOL_PHOTO = registerBlockInBlockset(SOL_BLOCKS, "sol_photo", new LitBlock(FabricBlockSettings.copyOf(solMaterial), null, null));
    public static final Block SOL_ELECTRON = registerBlockInBlockset(SOL_BLOCKS, "sol_electron", new LitBlock(FabricBlockSettings.copyOf(solMaterial), null, null));
    public static final Block SOL_MAX = registerBlockInBlockset(SOL_BLOCKS, "sol_max", new LitBlock(FabricBlockSettings.copyOf(solMaterial), null, null));
    public static final Block SOL_MIN = registerBlockInBlockset(SOL_BLOCKS, "sol_min", new LitBlock(FabricBlockSettings.copyOf(solMaterialDim), null, null));
    public static final Block SOL_CHROMA = registerBlockInBlockset(SOL_BLOCKS, "sol_chroma", new LitBlock(FabricBlockSettings.copyOf(solMaterialDim), null, null));
    public static final Block SOL_FLARE = registerBlockInBlockset(SOL_BLOCKS, "sol_flare", new LitBlock(FabricBlockSettings.copyOf(solMaterialDim), null, null));
    public static final Block SOL_BLIND = registerBlockInBlockset(SOL_BLOCKS, "sol_blind", new LitBlock(FabricBlockSettings.copyOf(solMaterialDim), null, null));
    public static final Block SOL_PROTON = registerBlockInBlockset(SOL_BLOCKS, "sol_proton", new LitBlock(FabricBlockSettings.copyOf(solMaterialDim), null, null));
    public static final Block SOL_BALANCE = registerBlockInBlockset(SOL_BLOCKS, "sol_balance", new LitBlock(FabricBlockSettings.copyOf(solMaterialDim), null, null));
    public static final Block SOL_GLARE = registerBlockInBlockset(SOL_BLOCKS, "sol_glare", new LitBlock(FabricBlockSettings.copyOf(solMaterial), null, null));
    public static final Block SOL_SPECTRA = registerBlockInBlockset(SOL_BLOCKS, "sol_spectra", new LitPillarBlock(FabricBlockSettings.copyOf(solMaterialDim), null, null));
    public static final Block SOL_BLAZAR = registerBlockInBlockset(SOL_BLOCKS, "sol_blazar", new LitGlazedTerracottaBlock(FabricBlockSettings.copyOf(solMaterialDim), null, null));
    public static final Block SOL_FIELD = registerBlockInBlockset(SOL_BLOCKS, "sol_field", new LitBlock(FabricBlockSettings.copyOf(solMaterialDim), null, null));
    public static final Block SOL_NUCLEI = registerBlockInBlockset(SOL_BLOCKS, "sol_nuclei", new LitBlock(FabricBlockSettings.copyOf(solMaterial), null, null));
    public static final Block SOL_CORONA = registerBlockInBlockset(SOL_BLOCKS, "sol_corona", new LitBlock(FabricBlockSettings.copyOf(solMaterial), null, null));
    public static final Block SOL = registerBlockInBlockset(SOL_BLOCKS, "sol", new LitBlock(FabricBlockSettings.copyOf(solMaterial), null, null));
    //</editor-fold>

    //<editor-fold desc ="Other Blocks">
    //</editor-fold>
    public static final Block AURORA = registerBlock("aurora", new AuroraBlock(FabricBlockSettings.create()
            .mapColor(MapColor.TERRACOTTA_CYAN)
            .breakInstantly()
            .sounds(BlockSoundGroup.SNOW)
            .luminance(createLightLevelFromProperty(11, Properties.LIT))
    ));


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
