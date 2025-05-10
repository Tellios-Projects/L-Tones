package net.leafenzo.ltones.block;

import net.leafenzo.ltones.ModInit;
import net.leafenzo.ltones.Super;
import net.leafenzo.ltones.block.custom.*;
import net.leafenzo.ltones.sound.ModBlockSetType;
import net.leafenzo.ltones.sound.ModBlockSoundGroup;
import net.leafenzo.ltones.sound.ModSoundEvents;
import net.leafenzo.ltones.util.ModUtil;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
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
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.BlockView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.ToIntFunction;

public class ModBlocks {

    //<editor-fold desc ="Hashmaps & BlockSets">
    // The reason why it's <Block, Block> instead of <Block, StairBlock> is because sometimes there will be block classes that have all the behavior of stair blocks without actually being children of them. This assumption is made for the hashmaps here as well.
    public static final ArrayList<Block> RENDER_LAYER_CUTOUT = new ArrayList<>();
    public static final ArrayList<Block> RENDER_LAYER_CUTOUT_MIPPED = new ArrayList<>();
    public static final ArrayList<Block> RENDER_LAYER_TRANSLUCENT = new ArrayList<>();
    public static final ArrayList<Block> HAS_FOLIAGE_COLOR_PROVIDER = new ArrayList<>();
    public static final ArrayList<Block> HAS_GRASS_COLOR_PROVIDER = new ArrayList<>();
    public static final ArrayList<Block> DECAL_BLOCKS = new ArrayList<>();
    public static final HashMap<Block, Block> STAIRS_FROM_BLOCK = new HashMap<>();
    public static final HashMap<Block, Block> SLAB_FROM_BLOCK = new HashMap<>();
    public static final ArrayList<Block> DOORS = new ArrayList<>();
    public static final ArrayList<Block> TRAPDOORS = new ArrayList<>();

    public static final ArrayList<Block> CRT_BLOCKS = new ArrayList<>();
    public static final ArrayList<Block> PC_BLOCKS = new ArrayList<>();
    public static final ArrayList<Block> KEYBOARD_BLOCKS = new ArrayList<>();
    public static final ArrayList<Block> MOUSE_BLOCKS = new ArrayList<>();
    public static final ArrayList<Block> SWITCH_BLOCKS = new ArrayList<>();

    public static final ArrayList<Block> AGON_BLOCKS = new ArrayList<>();
    public static final ArrayList<Block> FORTT_BLOCKS = new ArrayList<>();
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
    public static final ArrayList<Block> BITT_BLOCKS = new ArrayList<>();
    public static final ArrayList<Block> PLEX_BLOCKS = new ArrayList<>();
    public static final ArrayList<Block> ROST_BLOCKS = new ArrayList<>();
    public static final ArrayList<Block> ROST_BLOCKS_RUST = new ArrayList<>();
    public static final ArrayList<Block> SOUNDSCAPE_BLOCKS = new ArrayList<>();

    public static ArrayList<BlockSet> BLOCKSETS = new ArrayList<>();

    public static final BlockSet AGON_BLOCKSET = registerBlockSet(AGON_BLOCKS, "agon_blocks");
    public static final BlockSet FORTT_BLOCKSET = registerBlockSet(FORTT_BLOCKS, "fortt_blocks");
    public static final BlockSet GLAXX_BLOCKSET = registerBlockSet(GLAXX_BLOCKS, "glaxx_blocks");
    public static final BlockSet CRAY_BLOCKSET = registerBlockSet(CRAY_BLOCKS, "cray_blocks");
    public static final BlockSet CAST_BLOCKSET = registerBlockSet(CAST_BLOCKS, "cast_blocks");
    public static final BlockSet HOST_BLOCKSET = registerBlockSet(HOST_BLOCKS, "host_blocks");
    public static final BlockSet ZANE_BLOCKSET = registerBlockSet(ZANE_BLOCKS, "zane_blocks");
    public static final BlockSet VECT_BLOCKSET = registerBlockSet(VECT_BLOCKS, "vect_blocks");
    public static final BlockSet REDDS_BLOCKSET = registerBlockSet(REDDS_BLOCKS, "redds_blocks");
    public static final BlockSet MINN_BLOCKSET = registerBlockSet(MINN_BLOCKS, "minn_blocks");
    public static final BlockSet LAIR_BLOCKSET = registerBlockSet(LAIR_BLOCKS, "lair_blocks");
    public static final BlockSet KRYP_BLOCKSET = registerBlockSet(KRYP_BLOCKS, "kryp_blocks");
    public static final BlockSet LAVE_BLOCKSET = registerBlockSet(LAVE_BLOCKS, "lave_blocks");
    public static final BlockSet VEELD_BLOCKSET = registerBlockSet(VEELD_BLOCKS, "veeld_blocks");
    public static final BlockSet JELT_BLOCKSET = registerBlockSet(JELT_BLOCKS, "jelt_blocks");
    public static final BlockSet KORP_BLOCKSET = registerBlockSet(KORP_BLOCKS, "korp_blocks");
    public static final BlockSet TANK_BLOCKSET = registerBlockSet(TANK_BLOCKS, "tank_blocks");
    public static final BlockSet EXRI_BLOCKSET = registerBlockSet(EXRI_BLOCKS, "exri_blocks");
    public static final BlockSet AZUR_BLOCKSET = registerBlockSet(AZUR_BLOCKS, "azur_blocks");
    public static final BlockSet FLEQ_BLOCKSET = registerBlockSet(FLEQ_BLOCKS, "fleq_blocks");
    public static final BlockSet ISZM_BLOCKSET = registerBlockSet(ISZM_BLOCKS, "iszm_blocks");
    public static final BlockSet MYST_BLOCKSET = registerBlockSet(MYST_BLOCKS, "myst_blocks");
    public static final BlockSet SYNC_BLOCKSET = registerBlockSet(SYNC_BLOCKS, "sync_blocks");
    public static final BlockSet NURR_BLOCKSET = registerBlockSet(NURR_BLOCKS, "nurr_blocks");
    public static final BlockSet TYEL_BLOCKSET = registerBlockSet(TYEL_BLOCKS, "tyel_blocks");
    public static final BlockSet ROEN_BLOCKSET = registerBlockSet(ROEN_BLOCKS, "roen_blocks");
    public static final BlockSet SOL_BLOCKSET = registerBlockSet(SOL_BLOCKS, "sol_blocks");
    public static final BlockSet ROST_BLOCKSET = registerBlockSet(ROST_BLOCKS, "rost_blocks");
    public static final BlockSet ROST_BLOCKSET_RUST = registerBlockSet(ROST_BLOCKS_RUST, "rost_blocks_rust");
    public static final BlockSet BITT_BLOCKSET = registerBlockSet(BITT_BLOCKS, "bitt_blocks");
    public static final BlockSet PLEX_BLOCKSET = registerBlockSet(PLEX_BLOCKS, "plex_blocks");
    public static final BlockSet SOUNDSCAPE_BLOCKSET = registerBlockSet(SOUNDSCAPE_BLOCKS, "soundscape_blocks");
    //</editor-fold>
    //<editor-fold desc ="Blocks - AGON">

    private static final AbstractBlock agonMaterial = new Block(AbstractBlock.Settings.create()
            .strength(0.3f)
            .sounds(ModBlockSoundGroup.AGON)
            .luminance(state -> 15));
    public static final Block WHITE_AGON = registerBlockInBlockset(AGON_BLOCKS, "white_agon", new Block(AbstractBlock.Settings.copy(agonMaterial).mapColor(MapColor.WHITE)));
    public static final Block LIGHT_GRAY_AGON = registerBlockInBlockset(AGON_BLOCKS, "light_gray_agon", new Block(AbstractBlock.Settings.copy(agonMaterial).mapColor(MapColor.LIGHT_GRAY)));
    public static final Block GRAY_AGON = registerBlockInBlockset(AGON_BLOCKS, "gray_agon", new Block(AbstractBlock.Settings.copy(agonMaterial).mapColor(MapColor.GRAY)));
    public static final Block BLACK_AGON = registerBlockInBlockset(AGON_BLOCKS, "black_agon", new Block(AbstractBlock.Settings.copy(agonMaterial).mapColor(MapColor.BLACK)));
    public static final Block BROWN_AGON = registerBlockInBlockset(AGON_BLOCKS, "brown_agon", new Block(AbstractBlock.Settings.copy(agonMaterial).mapColor(MapColor.BROWN)));
    public static final Block RED_AGON = registerBlockInBlockset(AGON_BLOCKS, "red_agon", new Block(AbstractBlock.Settings.copy(agonMaterial).mapColor(MapColor.RED)));
    public static final Block ORANGE_AGON = registerBlockInBlockset(AGON_BLOCKS, "orange_agon", new Block(AbstractBlock.Settings.copy(agonMaterial).mapColor(MapColor.ORANGE)));
    public static final Block YELLOW_AGON = registerBlockInBlockset(AGON_BLOCKS, "yellow_agon", new Block(AbstractBlock.Settings.copy(agonMaterial).mapColor(MapColor.YELLOW)));
    public static final Block LIME_AGON = registerBlockInBlockset(AGON_BLOCKS, "lime_agon", new Block(AbstractBlock.Settings.copy(agonMaterial).mapColor(MapColor.LIME)));
    public static final Block GREEN_AGON = registerBlockInBlockset(AGON_BLOCKS, "green_agon", new Block(AbstractBlock.Settings.copy(agonMaterial).mapColor(MapColor.GREEN)));
    public static final Block CYAN_AGON = registerBlockInBlockset(AGON_BLOCKS, "cyan_agon", new Block(AbstractBlock.Settings.copy(agonMaterial).mapColor(MapColor.CYAN)));
    public static final Block BLUE_AGON = registerBlockInBlockset(AGON_BLOCKS, "blue_agon", new Block(AbstractBlock.Settings.copy(agonMaterial).mapColor(MapColor.BLUE)));
    public static final Block PURPLE_AGON = registerBlockInBlockset(AGON_BLOCKS, "purple_agon", new Block(AbstractBlock.Settings.copy(agonMaterial).mapColor(MapColor.PURPLE)));
    public static final Block MAGENTA_AGON = registerBlockInBlockset(AGON_BLOCKS, "magenta_agon", new Block(AbstractBlock.Settings.copy(agonMaterial).mapColor(MapColor.MAGENTA)));
    public static final Block PINK_AGON = registerBlockInBlockset(AGON_BLOCKS, "pink_agon", new Block(AbstractBlock.Settings.copy(agonMaterial).mapColor(MapColor.PINK)));
    //</editor-fold>
    //</editor-fold>

    //<editor-fold desc ="Blocks - FORTT">
    private static final AbstractBlock forttMaterial = new Block(AbstractBlock.Settings.create()
            .strength(1.0f)
            .sounds(ModBlockSoundGroup.FORTT));
    public static final Block FORTT = registerBlockInBlockset(FORTT_BLOCKS, "fortt", new Block(AbstractBlock.Settings.copy(forttMaterial).mapColor(MapColor.WHITE_GRAY)));
    public static final Block GRAY_FORTT = registerBlockInBlockset(FORTT_BLOCKS, "gray_fortt", new Block(AbstractBlock.Settings.copy(forttMaterial).mapColor(MapColor.IRON_GRAY)));
    public static final Block STONE_GRAY_FORTT = registerBlockInBlockset(FORTT_BLOCKS, "stone_gray_fortt", new Block(AbstractBlock.Settings.copy(forttMaterial).mapColor(MapColor.STONE_GRAY)));
    public static final Block SAND_BLUE_FORTT = registerBlockInBlockset(FORTT_BLOCKS, "sand_blue_fortt", new Block(AbstractBlock.Settings.copy(forttMaterial).mapColor(MapColor.LIGHT_BLUE_GRAY)));
    public static final Block DARK_RED_FORTT = registerBlockInBlockset(FORTT_BLOCKS, "dark_red_fortt", new Block(AbstractBlock.Settings.copy(forttMaterial).mapColor(MapColor.RED)));
    public static final Block BRIGHT_RED_FORTT = registerBlockInBlockset(FORTT_BLOCKS, "bright_red_fortt", new Block(AbstractBlock.Settings.copy(forttMaterial).mapColor(MapColor.DULL_RED)));
    public static final Block EARTH_ORANGE_FORTT = registerBlockInBlockset(FORTT_BLOCKS, "earth_orange_fortt", new Block(AbstractBlock.Settings.copy(forttMaterial).mapColor(MapColor.TERRACOTTA_ORANGE)));
    public static final Block ORANGE_FORTT = registerBlockInBlockset(FORTT_BLOCKS, "orange_fortt", new Block(AbstractBlock.Settings.copy(forttMaterial).mapColor(MapColor.ORANGE)));
    public static final Block BRIGHT_YELLOW_FORTT = registerBlockInBlockset(FORTT_BLOCKS, "bright_yellow_fortt", new Block(AbstractBlock.Settings.copy(forttMaterial).mapColor(MapColor.YELLOW)));
    public static final Block LIME_FORTT = registerBlockInBlockset(FORTT_BLOCKS, "lime_fortt", new Block(AbstractBlock.Settings.copy(forttMaterial).mapColor(MapColor.LIME)));
    public static final Block EARTH_GREEN_FORTT = registerBlockInBlockset(FORTT_BLOCKS, "earth_green_fortt", new Block(AbstractBlock.Settings.copy(forttMaterial).mapColor(MapColor.DARK_GREEN)));
    public static final Block DARK_TURQUOISE_FORTT = registerBlockInBlockset(FORTT_BLOCKS, "dark_turquoise_fortt", new Block(AbstractBlock.Settings.copy(forttMaterial).mapColor(MapColor.TEAL)));
    public static final Block MEDIUM_AZURE_FORTT = registerBlockInBlockset(FORTT_BLOCKS, "medium_azure_fortt", new Block(AbstractBlock.Settings.copy(forttMaterial).mapColor(MapColor.DIAMOND_BLUE)));
    public static final Block DARK_AZURE_FORTT = registerBlockInBlockset(FORTT_BLOCKS, "dark_azure_fortt", new Block(AbstractBlock.Settings.copy(forttMaterial).mapColor(MapColor.LAPIS_BLUE)));
    public static final Block BRIGHT_BLUE_FORTT = registerBlockInBlockset(FORTT_BLOCKS, "bright_blue_fortt", new Block(AbstractBlock.Settings.copy(forttMaterial).mapColor(MapColor.BLUE)));
    public static final Block BRIGHT_VIOLET_FORTT = registerBlockInBlockset(FORTT_BLOCKS, "bright_violet_fortt", new Block(AbstractBlock.Settings.copy(forttMaterial).mapColor(MapColor.TERRACOTTA_BLUE)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - GLAXX">
    private static final AbstractBlock glaxxMaterial = new Block(AbstractBlock.Settings.create()
            .mapColor(MapColor.CLEAR)
            .strength(0.3f)
            .sounds(ModBlockSoundGroup.GLAXX)
            .nonOpaque()
            .allowsSpawning(ModBlocks::never)
            .solidBlock(ModBlocks::never)
            .suffocates(ModBlocks::never)
            .blockVision(ModBlocks::never));
    public static final Block SANDALWOOD_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "sandalwood_glaxx", new TransparentBlock(AbstractBlock.Settings.copy(glaxxMaterial)/*.mapColor(MapColor.IRON_GRAY)*/));
    public static final Block LICORICE_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "licorice_glaxx", new TransparentBlock(AbstractBlock.Settings.copy(glaxxMaterial)/*.mapColor(MapColor.STONE_GRAY)*/));
    public static final Block INCENSE_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "incense_glaxx", new TransparentBlock(AbstractBlock.Settings.copy(glaxxMaterial)/*.mapColor(MapColor.GRAY)*/));
    public static final Block CINNAMON_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "cinnamon_glaxx", new TransparentBlock(AbstractBlock.Settings.copy(glaxxMaterial)/*.mapColor(MapColor.DARK_CRIMSON)*/));
    public static final Block CITRUS_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "citrus_glaxx", new TransparentBlock(AbstractBlock.Settings.copy(glaxxMaterial)/*.mapColor(MapColor.DIRT_BROWN)*/));
    public static final Block PINE_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "pine_glaxx", new TransparentBlock(AbstractBlock.Settings.copy(glaxxMaterial)/*.mapColor(MapColor.SPRUCE_BROWN)*/));
    public static final Block LEMON_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "lemon_glaxx", new TransparentBlock(AbstractBlock.Settings.copy(glaxxMaterial)/*.mapColor(MapColor.TERRACOTTA_YELLOW)*/));
    public static final Block THYME_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "thyme_glaxx", new TransparentBlock(AbstractBlock.Settings.copy(glaxxMaterial)/*.mapColor(MapColor.TERRACOTTA_GREEN)*/));
    public static final Block SAGE_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "sage_glaxx", new TransparentBlock(AbstractBlock.Settings.copy(glaxxMaterial)/*.mapColor(MapColor.TERRACOTTA_LIME)*/));
    public static final Block MINT_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "mint_glaxx", new TransparentBlock(AbstractBlock.Settings.copy(glaxxMaterial)/*.mapColor(MapColor.LICHEN_GREEN)*/));
    public static final Block COCONUT_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "coconut_glaxx", new TransparentBlock(AbstractBlock.Settings.copy(glaxxMaterial)/*.mapColor(MapColor.TERRACOTTA_CYAN)*/));
    public static final Block BRINE_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "brine_glaxx", new TransparentBlock(AbstractBlock.Settings.copy(glaxxMaterial)/*.mapColor(MapColor.CYAN)*/));
    public static final Block SASSAFRAS_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "sassafras_glaxx", new TransparentBlock(AbstractBlock.Settings.copy(glaxxMaterial)/*.mapColor(MapColor.BLUE)*/));
    public static final Block LAVENDER_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "lavender_glaxx", new TransparentBlock(AbstractBlock.Settings.copy(glaxxMaterial)/*.mapColor(MapColor.TERRACOTTA_BLUE)*/));
    public static final Block EUCALYPTUS_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "eucalyptus_glaxx", new TransparentBlock(AbstractBlock.Settings.copy(glaxxMaterial)/*.mapColor(MapColor.DARK_DULL_PINK)*/));
    public static final Block ROSE_GLAXX = registerBlockInBlockset(GLAXX_BLOCKS, "rose_glaxx", new TransparentBlock(AbstractBlock.Settings.copy(glaxxMaterial)/*.mapColor(MapColor.DULL_PINK)*/));
    //</editor-fold>
    //<editor-fold desc ="Blocks - CRAY">
    private static final AbstractBlock crayMaterial = new Block(AbstractBlock.Settings.create()
            .strength(0.8f) // same as sandstone
            .requiresTool()
            .sounds(ModBlockSoundGroup.CRAY));
    public static final Block CRAY = registerBlockInBlockset(CRAY_BLOCKS, "cray", new Block(AbstractBlock.Settings.copy(crayMaterial).mapColor(MapColor.WHITE_GRAY)));
    public static final Block BLACK_CRAY = registerBlockInBlockset(CRAY_BLOCKS, "black_cray", new Block(AbstractBlock.Settings.copy(crayMaterial).mapColor(MapColor.LIGHT_GRAY)));
    public static final Block RED_CRAY = registerBlockInBlockset(CRAY_BLOCKS, "red_cray", new Block(AbstractBlock.Settings.copy(crayMaterial).mapColor(MapColor.RED)));
    public static final Block ORANGE_CRAY = registerBlockInBlockset(CRAY_BLOCKS, "orange_cray", new Block(AbstractBlock.Settings.copy(crayMaterial).mapColor(MapColor.ORANGE)));
    public static final Block AMBER_CRAY = registerBlockInBlockset(CRAY_BLOCKS, "amber_cray", new Block(AbstractBlock.Settings.copy(crayMaterial).mapColor(MapColor.OAK_TAN)));
    public static final Block YELLOW_CRAY = registerBlockInBlockset(CRAY_BLOCKS, "yellow_cray", new Block(AbstractBlock.Settings.copy(crayMaterial).mapColor(MapColor.YELLOW)));
    public static final Block LIME_CRAY = registerBlockInBlockset(CRAY_BLOCKS, "lime_cray", new Block(AbstractBlock.Settings.copy(crayMaterial).mapColor(MapColor.LIME)));
    public static final Block GREEN_CRAY = registerBlockInBlockset(CRAY_BLOCKS, "green_cray", new Block(AbstractBlock.Settings.copy(crayMaterial).mapColor(MapColor.EMERALD_GREEN)));
    public static final Block MINT_CRAY = registerBlockInBlockset(CRAY_BLOCKS, "mint_cray", new Block(AbstractBlock.Settings.copy(crayMaterial).mapColor(MapColor.BRIGHT_TEAL)));
    public static final Block CYAN_CRAY = registerBlockInBlockset(CRAY_BLOCKS, "cyan_cray", new Block(AbstractBlock.Settings.copy(crayMaterial).mapColor(MapColor.DARK_AQUA)));
    public static final Block BLUE_CRAY = registerBlockInBlockset(CRAY_BLOCKS, "blue_cray", new Block(AbstractBlock.Settings.copy(crayMaterial).mapColor(MapColor.CYAN)));
    public static final Block NAVY_CRAY = registerBlockInBlockset(CRAY_BLOCKS, "navy_cray", new Block(AbstractBlock.Settings.copy(crayMaterial).mapColor(MapColor.LIGHT_BLUE)));
    public static final Block PURPLE_CRAY = registerBlockInBlockset(CRAY_BLOCKS, "purple_cray", new Block(AbstractBlock.Settings.copy(crayMaterial).mapColor(MapColor.PALE_PURPLE)));
    public static final Block VIOLET_CRAY = registerBlockInBlockset(CRAY_BLOCKS, "violet_cray", new Block(AbstractBlock.Settings.copy(crayMaterial).mapColor(MapColor.PURPLE)));
    public static final Block MAGENTA_CRAY = registerBlockInBlockset(CRAY_BLOCKS, "magenta_cray", new Block(AbstractBlock.Settings.copy(crayMaterial).mapColor(MapColor.MAGENTA)));
    public static final Block FUCHSIA_CRAY = registerBlockInBlockset(CRAY_BLOCKS, "fuchsia_cray", new Block(AbstractBlock.Settings.copy(crayMaterial).mapColor(MapColor.DULL_PINK)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - CAST">
    private static final AbstractBlock castMaterial = new Block(AbstractBlock.Settings.create()
            .strength(1.0f)
            .sounds(ModBlockSoundGroup.CAST));
    public static final Block CAST = registerBlockInBlockset(CAST_BLOCKS, "cast", new Block(AbstractBlock.Settings.copy(castMaterial).mapColor(MapColor.WHITE)));
    public static final Block BLACK_CAST = registerBlockInBlockset(CAST_BLOCKS, "black_cast", new Block(AbstractBlock.Settings.copy(castMaterial).mapColor(MapColor.BLACK)));
    public static final Block BROWN_CAST = registerBlockInBlockset(CAST_BLOCKS, "brown_cast", new Block(AbstractBlock.Settings.copy(castMaterial).mapColor(MapColor.TERRACOTTA_ORANGE)));
    public static final Block RED_CAST = registerBlockInBlockset(CAST_BLOCKS, "red_cast", new Block(AbstractBlock.Settings.copy(castMaterial).mapColor(MapColor.BRIGHT_RED)));
    public static final Block VERMILION_CAST = registerBlockInBlockset(CAST_BLOCKS, "vermilion_cast", new Block(AbstractBlock.Settings.copy(castMaterial).mapColor(MapColor.BRIGHT_RED)));
    public static final Block AMBER_CAST = registerBlockInBlockset(CAST_BLOCKS, "amber_cast", new Block(AbstractBlock.Settings.copy(castMaterial).mapColor(MapColor.TERRACOTTA_YELLOW)));
    public static final Block YELLOW_CAST = registerBlockInBlockset(CAST_BLOCKS, "yellow_cast", new Block(AbstractBlock.Settings.copy(castMaterial).mapColor(MapColor.YELLOW)));
    public static final Block CHARTREUSE_CAST = registerBlockInBlockset(CAST_BLOCKS, "chartreuse_cast", new Block(AbstractBlock.Settings.copy(castMaterial).mapColor(MapColor.PALE_GREEN)));
    public static final Block LIME_CAST = registerBlockInBlockset(CAST_BLOCKS, "lime_cast", new Block(AbstractBlock.Settings.copy(castMaterial).mapColor(MapColor.LIME)));
    public static final Block GREEN_CAST = registerBlockInBlockset(CAST_BLOCKS, "green_cast", new Block(AbstractBlock.Settings.copy(castMaterial).mapColor(MapColor.EMERALD_GREEN)));
    public static final Block CYAN_CAST = registerBlockInBlockset(CAST_BLOCKS, "cyan_cast", new Block(AbstractBlock.Settings.copy(castMaterial).mapColor(MapColor.CYAN)));
    public static final Block BLUE_CAST = registerBlockInBlockset(CAST_BLOCKS, "blue_cast", new Block(AbstractBlock.Settings.copy(castMaterial).mapColor(MapColor.LAPIS_BLUE)));
    public static final Block NAVY_CAST = registerBlockInBlockset(CAST_BLOCKS, "navy_cast", new Block(AbstractBlock.Settings.copy(castMaterial).mapColor(MapColor.WATER_BLUE)));
    public static final Block PURPLE_CAST = registerBlockInBlockset(CAST_BLOCKS, "purple_cast", new Block(AbstractBlock.Settings.copy(castMaterial).mapColor(MapColor.PURPLE)));
    public static final Block MAGENTA_CAST = registerBlockInBlockset(CAST_BLOCKS, "magenta_cast", new Block(AbstractBlock.Settings.copy(castMaterial).mapColor(MapColor.MAGENTA)));
    public static final Block VELVET_CAST = registerBlockInBlockset(CAST_BLOCKS, "velvet_cast", new Block(AbstractBlock.Settings.copy(castMaterial).mapColor(MapColor.DULL_RED)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - HOST">
    private static final AbstractBlock hostMaterial = new Block(AbstractBlock.Settings.create()
            .strength(1.5f)
            .requiresTool()
            .sounds(ModBlockSoundGroup.HOST));
    public static final Block EMPTY_HOST = registerBlockInBlockset(HOST_BLOCKS, "empty_host", new Block(AbstractBlock.Settings.copy(hostMaterial).mapColor(MapColor.BLACK).sounds(BlockSoundGroup.COPPER)));
    public static final Block HOST = registerBlockInBlockset(HOST_BLOCKS, "host", new Block(AbstractBlock.Settings.copy(hostMaterial).mapColor(MapColor.GRAY).luminance(state -> 3)));
    public static final Block RED_HOST = registerBlockInBlockset(HOST_BLOCKS, "red_host", new Block(AbstractBlock.Settings.copy(hostMaterial).mapColor(MapColor.GRAY).luminance(state -> 7)));
    public static final Block AMBER_HOST = registerBlockInBlockset(HOST_BLOCKS, "amber_host", new Block(AbstractBlock.Settings.copy(hostMaterial).mapColor(MapColor.GRAY).luminance(state -> 7)));
    public static final Block VERMILION_HOST = registerBlockInBlockset(HOST_BLOCKS, "vermilion_host", new Block(AbstractBlock.Settings.copy(hostMaterial).mapColor(MapColor.GRAY).luminance(state -> 7)));
    public static final Block YELLOW_HOST = registerBlockInBlockset(HOST_BLOCKS, "yellow_host", new Block(AbstractBlock.Settings.copy(hostMaterial).mapColor(MapColor.GRAY).luminance(state -> 7)));
    public static final Block LIME_HOST = registerBlockInBlockset(HOST_BLOCKS, "lime_host", new Block(AbstractBlock.Settings.copy(hostMaterial).mapColor(MapColor.GRAY).luminance(state -> 7)));
    public static final Block GREEN_HOST = registerBlockInBlockset(HOST_BLOCKS, "green_host", new Block(AbstractBlock.Settings.copy(hostMaterial).mapColor(MapColor.GRAY).luminance(state -> 7)));
    public static final Block MINT_HOST = registerBlockInBlockset(HOST_BLOCKS, "mint_host", new Block(AbstractBlock.Settings.copy(hostMaterial).mapColor(MapColor.GRAY).luminance(state -> 7)));
    public static final Block CYAN_HOST = registerBlockInBlockset(HOST_BLOCKS, "cyan_host", new Block(AbstractBlock.Settings.copy(hostMaterial).mapColor(MapColor.GRAY).luminance(state -> 7)));
    public static final Block BLUE_HOST = registerBlockInBlockset(HOST_BLOCKS, "blue_host", new Block(AbstractBlock.Settings.copy(hostMaterial).mapColor(MapColor.GRAY).luminance(state -> 7)));
    public static final Block NAVY_HOST = registerBlockInBlockset(HOST_BLOCKS, "navy_host", new Block(AbstractBlock.Settings.copy(hostMaterial).mapColor(MapColor.GRAY).luminance(state -> 7)));
    public static final Block PURPLE_HOST = registerBlockInBlockset(HOST_BLOCKS, "purple_host", new Block(AbstractBlock.Settings.copy(hostMaterial).mapColor(MapColor.GRAY).luminance(state -> 7)));
    public static final Block VIOLET_HOST = registerBlockInBlockset(HOST_BLOCKS, "violet_host", new Block(AbstractBlock.Settings.copy(hostMaterial).mapColor(MapColor.GRAY).luminance(state -> 7)));
    public static final Block MAGENTA_HOST = registerBlockInBlockset(HOST_BLOCKS, "magenta_host", new Block(AbstractBlock.Settings.copy(hostMaterial).mapColor(MapColor.GRAY).luminance(state -> 7)));
    public static final Block FUCHSIA_HOST = registerBlockInBlockset(HOST_BLOCKS, "fuchsia_host", new Block(AbstractBlock.Settings.copy(hostMaterial).mapColor(MapColor.GRAY).luminance(state -> 7)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - ZANE">
    private static final AbstractBlock zaneMaterial = new Block(AbstractBlock.Settings.create()
            .strength(0.75f)
            .requiresTool()
            .instrument(NoteBlockInstrument.BASEDRUM)
            .sounds(ModBlockSoundGroup.ZANE));
    public static final Block ZANE = registerBlockInBlockset(ZANE_BLOCKS, "zane", new Block(AbstractBlock.Settings.copy(zaneMaterial).mapColor(MapColor.WHITE)));
    public static final Block BLACK_ZANE = registerBlockInBlockset(ZANE_BLOCKS, "black_zane", new Block(AbstractBlock.Settings.copy(zaneMaterial).mapColor(MapColor.BLACK)));
    public static final Block RED_ZANE = registerBlockInBlockset(ZANE_BLOCKS, "red_zane", new Block(AbstractBlock.Settings.copy(zaneMaterial).mapColor(MapColor.RED)));
    public static final Block ORANGE_ZANE = registerBlockInBlockset(ZANE_BLOCKS, "orange_zane", new Block(AbstractBlock.Settings.copy(zaneMaterial).mapColor(MapColor.ORANGE)));
    public static final Block AMBER_ZANE = registerBlockInBlockset(ZANE_BLOCKS, "amber_zane", new Block(AbstractBlock.Settings.copy(zaneMaterial).mapColor(MapColor.TERRACOTTA_ORANGE)));
    public static final Block YELLOW_ZANE = registerBlockInBlockset(ZANE_BLOCKS, "yellow_zane", new Block(AbstractBlock.Settings.copy(zaneMaterial).mapColor(MapColor.YELLOW)));
    public static final Block LIME_ZANE = registerBlockInBlockset(ZANE_BLOCKS, "lime_zane", new Block(AbstractBlock.Settings.copy(zaneMaterial).mapColor(MapColor.LIME)));
    public static final Block GREEN_ZANE = registerBlockInBlockset(ZANE_BLOCKS, "green_zane", new Block(AbstractBlock.Settings.copy(zaneMaterial).mapColor(MapColor.GREEN)));
    public static final Block MINT_ZANE = registerBlockInBlockset(ZANE_BLOCKS, "mint_zane", new Block(AbstractBlock.Settings.copy(zaneMaterial).mapColor(MapColor.BRIGHT_TEAL)));
    public static final Block CYAN_ZANE = registerBlockInBlockset(ZANE_BLOCKS, "cyan_zane", new Block(AbstractBlock.Settings.copy(zaneMaterial).mapColor(MapColor.TEAL)));
    public static final Block BLUE_ZANE = registerBlockInBlockset(ZANE_BLOCKS, "blue_zane", new Block(AbstractBlock.Settings.copy(zaneMaterial).mapColor(MapColor.LIGHT_BLUE)));
    public static final Block CERULEAN_ZANE = registerBlockInBlockset(ZANE_BLOCKS, "cerulean_zane", new Block(AbstractBlock.Settings.copy(zaneMaterial).mapColor(MapColor.LAPIS_BLUE)));
    public static final Block NAVY_ZANE = registerBlockInBlockset(ZANE_BLOCKS, "navy_zane", new Block(AbstractBlock.Settings.copy(zaneMaterial).mapColor(MapColor.BLUE)));
    public static final Block PURPLE_ZANE = registerBlockInBlockset(ZANE_BLOCKS, "purple_zane", new Block(AbstractBlock.Settings.copy(zaneMaterial).mapColor(MapColor.PURPLE)));
    public static final Block MAGENTA_ZANE = registerBlockInBlockset(ZANE_BLOCKS, "magenta_zane", new Block(AbstractBlock.Settings.copy(zaneMaterial).mapColor(MapColor.MAGENTA)));
    public static final Block FUCHSIA_ZANE = registerBlockInBlockset(ZANE_BLOCKS, "fuchsia_zane", new Block(AbstractBlock.Settings.copy(zaneMaterial).mapColor(MapColor.DULL_PINK)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - VECT">
    private static final AbstractBlock vectMaterial = new Block(AbstractBlock.Settings.create()
            .mapColor(MapColor.YELLOW)
            .requiresTool()
            .strength(2.4f, 2.0f)
            .sounds(ModBlockSoundGroup.VECT));
    public static final Block VECT = registerBlockInBlockset(VECT_BLOCKS, "vect", new Block(AbstractBlock.Settings.copy(vectMaterial)));
    public static final Block VECT_TILE = registerBlockInBlockset(VECT_BLOCKS, "vect_tile", new Block(AbstractBlock.Settings.copy(vectMaterial)));
    public static final Block VECT_RIVET = registerBlockInBlockset(VECT_BLOCKS, "vect_rivet", new Block(AbstractBlock.Settings.copy(vectMaterial)));
    public static final Block VECT_HUB = registerBlockInBlockset(VECT_BLOCKS, "vect_hub", new Block(AbstractBlock.Settings.copy(vectMaterial)));
    public static final Block VECT_STRUT = registerBlockInBlockset(VECT_BLOCKS, "vect_strut", new PillarBlock(AbstractBlock.Settings.copy(vectMaterial)));
    public static final Block VECT_PAD = registerBlockInBlockset(VECT_BLOCKS, "vect_pad", new ReversiblePillarBlock(AbstractBlock.Settings.copy(vectMaterial)));
    public static final Block VECT_TRACKER = registerBlockInBlockset(VECT_BLOCKS, "vect_tracker", new Block(AbstractBlock.Settings.copy(vectMaterial).mapColor(MapColor.BLACK)));
    public static final Block VECT_CORE = registerBlockInBlockset(VECT_BLOCKS, "vect_core", new Block(AbstractBlock.Settings.copy(vectMaterial).mapColor(MapColor.BLACK)));
    public static final Block VECT_TREADPLATE = registerBlockInBlockset(VECT_BLOCKS, "vect_treadplate", new Block(AbstractBlock.Settings.copy(vectMaterial)));
    public static final Block VECT_SHIELD = registerBlockInBlockset(VECT_BLOCKS, "vect_shield", new PillarBlock(AbstractBlock.Settings.copy(vectMaterial)));
    public static final Block VECT_PANEL = registerBlockInBlockset(VECT_BLOCKS, "vect_panel", new Block(AbstractBlock.Settings.copy(vectMaterial)));
    public static final Block VECT_RADIATOR = registerBlockInBlockset(VECT_BLOCKS, "vect_radiator", new Block(AbstractBlock.Settings.copy(vectMaterial).mapColor(MapColor.GOLD)));
    public static final Block VECT_BULKHEAD = registerBlockInBlockset(VECT_BLOCKS, "vect_bulkhead", new PillarBlock(AbstractBlock.Settings.copy(vectMaterial)));
    public static final Block VECT_TANK = registerBlockInBlockset(VECT_BLOCKS, "vect_tank", new Block(AbstractBlock.Settings.copy(vectMaterial).mapColor(MapColor.GOLD).strength(1.8f).sounds(ModBlockSoundGroup.VECT_FOIL)));
    public static final Block VECT_NETWORK = registerBlockInBlockset(VECT_BLOCKS, "vect_network", new Block(AbstractBlock.Settings.copy(vectMaterial).mapColor(MapColor.PALE_YELLOW)));
    public static final Block VECT_FOIL = registerBlockInBlockset(VECT_BLOCKS, "vect_foil", new Block(AbstractBlock.Settings.copy(vectMaterial).mapColor(MapColor.GOLD).strength(1.2f).sounds(ModBlockSoundGroup.VECT_FOIL)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - REDDS">
    private static final AbstractBlock reddsMaterial = new Block(AbstractBlock.Settings.create()
            .mapColor(MapColor.DARK_RED)
            .requiresTool()
            .strength(2.4f, 2.0f)
            .sounds(ModBlockSoundGroup.REDDS));
    public static final Block REDDS = registerBlockInBlockset(REDDS_BLOCKS, "redds", new LitBlock(AbstractBlock.Settings.copy(reddsMaterial).luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_REDDS_ACTIVATE, ModSoundEvents.BLOCK_REDDS_DEACTIVATE, false));
    public static final Block REDDS_PICE = registerBlockInBlockset(REDDS_BLOCKS, "redds_pice", new LitBlock(AbstractBlock.Settings.copy(reddsMaterial)));
    public static final Block REDDS_PICE_STAIRS = registerStairs(REDDS_PICE, "redds_pice_stairs", new LitStairsBlock(REDDS_PICE.getDefaultState(), AbstractBlock.Settings.copy(REDDS_PICE), null, null));
    public static final Block REDDS_PICE_SLAB = registerSlab(REDDS_PICE, "redds_pice_slab", new LitSlabBlock(AbstractBlock.Settings.copy(REDDS_PICE)));
    public static final Block REDDS_TRACT = registerBlockInBlockset(REDDS_BLOCKS, "redds_tract", new LitBlock(AbstractBlock.Settings.copy(reddsMaterial).luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_REDDS_ACTIVATE, ModSoundEvents.BLOCK_REDDS_DEACTIVATE, false));
    public static final Block REDDS_THOUGHT = registerBlockInBlockset(REDDS_BLOCKS, "redds_thought", new LitBlock(AbstractBlock.Settings.copy(reddsMaterial).luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_REDDS_ACTIVATE, ModSoundEvents.BLOCK_REDDS_DEACTIVATE, false));
    public static final Block REDDS_TILE = registerBlockInBlockset(REDDS_BLOCKS, "redds_tile", new LitBlock(AbstractBlock.Settings.copy(reddsMaterial).luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_REDDS_ACTIVATE, ModSoundEvents.BLOCK_REDDS_DEACTIVATE, false));
    public static final Block REDDS_MARK = registerBlockInBlockset(REDDS_BLOCKS, "redds_mark", new LitBlock(AbstractBlock.Settings.copy(reddsMaterial).luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_REDDS_ACTIVATE, ModSoundEvents.BLOCK_REDDS_DEACTIVATE, false));
    public static final Block REDDS_NEXUS = registerBlockInBlockset(REDDS_BLOCKS, "redds_nexus", new LitBlock(AbstractBlock.Settings.copy(reddsMaterial).luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_REDDS_ACTIVATE, ModSoundEvents.BLOCK_REDDS_DEACTIVATE, false));
    public static final Block REDDS_TAPE = registerBlockInBlockset(REDDS_BLOCKS, "redds_tape", new LitPillarBlock(AbstractBlock.Settings.copy(reddsMaterial).luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_REDDS_ACTIVATE, ModSoundEvents.BLOCK_REDDS_DEACTIVATE, false));
    public static final Block REDDS_GRATE = registerBlockInBlockset(REDDS_BLOCKS, "redds_grate", new LitBlock(AbstractBlock.Settings.copy(reddsMaterial).luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_REDDS_ACTIVATE, ModSoundEvents.BLOCK_REDDS_DEACTIVATE, false));
    public static final Block REDDS_HEART = registerBlockInBlockset(REDDS_BLOCKS, "redds_heart", new LitBlock(AbstractBlock.Settings.copy(reddsMaterial).luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_REDDS_ACTIVATE, ModSoundEvents.BLOCK_REDDS_DEACTIVATE, false));
    public static final Block REDDS_HOPPER = registerBlockInBlockset(REDDS_BLOCKS, "redds_hopper", new LitBlock(AbstractBlock.Settings.copy(reddsMaterial).luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_REDDS_ACTIVATE, ModSoundEvents.BLOCK_REDDS_DEACTIVATE, false));
    public static final Block REDDS_FRACTAL = registerBlockInBlockset(REDDS_BLOCKS, "redds_fractal", new LitBlock(AbstractBlock.Settings.copy(reddsMaterial).luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_REDDS_ACTIVATE, ModSoundEvents.BLOCK_REDDS_DEACTIVATE, false));
    public static final Block REDDS_FRAME = registerBlockInBlockset(REDDS_BLOCKS, "redds_frame", new LitBlock(AbstractBlock.Settings.copy(reddsMaterial).luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_REDDS_ACTIVATE, ModSoundEvents.BLOCK_REDDS_DEACTIVATE, false));
    public static final Block REDDS_GLAZED = registerBlockInBlockset(REDDS_BLOCKS, "redds_glazed", new LitGlazedTerracottaBlock(AbstractBlock.Settings.copy(reddsMaterial).luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_REDDS_ACTIVATE, ModSoundEvents.BLOCK_REDDS_DEACTIVATE, false));
    public static final Block REDDS_BALANCE = registerBlockInBlockset(REDDS_BLOCKS, "redds_balance", new LitBlock(AbstractBlock.Settings.copy(reddsMaterial).luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_REDDS_ACTIVATE, ModSoundEvents.BLOCK_REDDS_DEACTIVATE, false));
    public static final Block REDDS_CURRENT = registerBlockInBlockset(REDDS_BLOCKS, "redds_current", new LitBlock(AbstractBlock.Settings.copy(reddsMaterial).luminance(createLightLevelFromProperty(3, Properties.LIT)), ModSoundEvents.BLOCK_REDDS_ACTIVATE, ModSoundEvents.BLOCK_REDDS_DEACTIVATE, false));
    //</editor-fold>
    //<editor-fold desc ="Blocks - MINN">
    private static final AbstractBlock minnMaterial = new Block(AbstractBlock.Settings.create()
            .mapColor(MapColor.PALE_GREEN)
            .requiresTool()
            .strength(2.4f, 2.0f)
            .sounds(ModBlockSoundGroup.MINN));
    public static final Block MINN = registerBlockInBlockset(MINN_BLOCKS, "minn", new Block(AbstractBlock.Settings.copy(minnMaterial)));
    public static final Block MINN_TILES = registerBlockInBlockset(MINN_BLOCKS, "minn_tiles", new Block(AbstractBlock.Settings.copy(minnMaterial)));
    public static final Block MINN_RESONANCE = registerBlockInBlockset(MINN_BLOCKS, "minn_resonance", new Block(AbstractBlock.Settings.copy(minnMaterial)));
    public static final Block MINN_QUILT = registerBlockInBlockset(MINN_BLOCKS, "minn_quilt", new Block(AbstractBlock.Settings.copy(minnMaterial)));
    public static final Block MINN_POFFNODE = registerBlockInBlockset(MINN_BLOCKS, "minn_poffnode", new Block(AbstractBlock.Settings.copy(minnMaterial)));
    public static final Block MINN_POFFCAGE = registerBlockInBlockset(MINN_BLOCKS, "minn_poffcage", new Block(AbstractBlock.Settings.copy(minnMaterial)));
    public static final Block MINN_POFF = registerBlockInBlockset(MINN_BLOCKS, "minn_poff", new Block(AbstractBlock.Settings.copy(minnMaterial)));
    public static final Block MINN_PAD = registerBlockInBlockset(MINN_BLOCKS, "minn_pad", new Block(AbstractBlock.Settings.copy(minnMaterial)));
    public static final Block MINN_NEXUS = registerBlockInBlockset(MINN_BLOCKS, "minn_nexus", new Block(AbstractBlock.Settings.copy(minnMaterial)));
    public static final Block MINN_LINENODE = registerBlockInBlockset(MINN_BLOCKS, "minn_linenode", new Block(AbstractBlock.Settings.copy(minnMaterial)));
    public static final Block MINN_LINE = registerBlockInBlockset(MINN_BLOCKS, "minn_line", new PillarBlock(AbstractBlock.Settings.copy(minnMaterial)));
    public static final Block MINN_CIRCLE = registerBlockInBlockset(MINN_BLOCKS, "minn_circle", new Block(AbstractBlock.Settings.copy(minnMaterial)));
    public static final Block MINN_CAGE = registerBlockInBlockset(MINN_BLOCKS, "minn_cage", new Block(AbstractBlock.Settings.copy(minnMaterial)));
    public static final Block MINN_CUBES = registerBlockInBlockset(MINN_BLOCKS, "minn_cubes", new Block(AbstractBlock.Settings.copy(minnMaterial)));
    public static final Block MINN_BLANK = registerBlockInBlockset(MINN_BLOCKS, "minn_blank", new Block(AbstractBlock.Settings.copy(minnMaterial)));
    public static final Block MINN_BEVEL = registerBlockInBlockset(MINN_BLOCKS, "minn_bevel", new Block(AbstractBlock.Settings.copy(minnMaterial)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - LAIR">
    private static final AbstractBlock lairMaterial = new Block(AbstractBlock.Settings.create()
            .mapColor(MapColor.RAW_IRON_PINK)
            .requiresTool()
            .strength(0.75f)
            .instrument(NoteBlockInstrument.BASEDRUM)
            .sounds(ModBlockSoundGroup.LAIR));
    public static final Block LAIR = registerBlockInBlockset(LAIR_BLOCKS, "lair", new Block(AbstractBlock.Settings.copy(lairMaterial).mapColor(MapColor.DARK_CRIMSON)));
    public static final Block LAIR_STRUT = registerBlockInBlockset(LAIR_BLOCKS, "lair_strut", new Block(AbstractBlock.Settings.copy(lairMaterial)));
    public static final Block LAIR_SMOOTH = registerBlockInBlockset(LAIR_BLOCKS, "lair_smooth", new Block(AbstractBlock.Settings.copy(lairMaterial).mapColor(MapColor.DARK_CRIMSON)));
    public static final Block LAIR_RIGOR = registerBlockInBlockset(LAIR_BLOCKS, "lair_rigor", new Block(AbstractBlock.Settings.copy(lairMaterial)));
    public static final Block LAIR_RIGOR_STAIRS = registerStairs(LAIR_RIGOR, "lair_rigor_stairs", new StairsBlock(LAIR_RIGOR.getDefaultState(), AbstractBlock.Settings.copy(LAIR_RIGOR)));
    public static final Block LAIR_RIGOR_SLAB = registerSlab(LAIR_RIGOR, "lair_rigor_slab", new SlabBlock(AbstractBlock.Settings.copy(LAIR_RIGOR)));
    public static final Block LAIR_RIGID = registerBlockInBlockset(LAIR_BLOCKS, "lair_rigid", new Block(AbstractBlock.Settings.copy(lairMaterial).mapColor(MapColor.DARK_CRIMSON)));
    public static final Block LAIR_RIGID_STAIRS = registerStairs(LAIR_RIGID, "lair_rigid_stairs", new StairsBlock(LAIR_RIGID.getDefaultState(), AbstractBlock.Settings.copy(LAIR_RIGID)));
    public static final Block LAIR_RIGID_SLAB = registerSlab(LAIR_RIGID, "lair_rigid_slab", new SlabBlock(AbstractBlock.Settings.copy(LAIR_RIGID)));
    public static final Block LAIR_MESS = registerBlockInBlockset(LAIR_BLOCKS, "lair_mess", new Block(AbstractBlock.Settings.copy(lairMaterial)));
    public static final Block LAIR_MATTERTILES = registerBlockInBlockset(LAIR_BLOCKS, "lair_mattertiles", new Block(AbstractBlock.Settings.copy(lairMaterial)));
    public static final Block LAIR_MATTER = registerBlockInBlockset(LAIR_BLOCKS, "lair_matter", new Block(AbstractBlock.Settings.copy(lairMaterial)));
    public static final Block LAIR_JEWEL = registerBlockInBlockset(LAIR_BLOCKS, "lair_jewel", new Block(AbstractBlock.Settings.copy(lairMaterial)));
    public static final Block LAIR_HEAL = registerBlockInBlockset(LAIR_BLOCKS, "lair_heal", new Block(AbstractBlock.Settings.copy(lairMaterial)));
    public static final Block LAIR_DERMADENT = registerBlockInBlockset(LAIR_BLOCKS, "lair_dermadent", new Block(AbstractBlock.Settings.copy(lairMaterial)));
    public static final Block LAIR_DERMA = registerBlockInBlockset(LAIR_BLOCKS, "lair_derma", new Block(AbstractBlock.Settings.copy(lairMaterial)));
    public static final Block LAIR_DERMA_STAIRS = registerStairs(LAIR_DERMA, "lair_derma_stairs", new StairsBlock(LAIR_DERMA.getDefaultState(), AbstractBlock.Settings.copy(LAIR_DERMA)));
    public static final Block LAIR_DERMA_SLAB = registerSlab(LAIR_DERMA, "lair_derma_slab", new SlabBlock(AbstractBlock.Settings.copy(LAIR_DERMA)));
    public static final Block LAIR_CROWNED = registerBlockInBlockset(LAIR_BLOCKS, "lair_crowned", new PillarBlock(AbstractBlock.Settings.copy(lairMaterial)));
    public static final Block LAIR_CHUNK = registerBlockInBlockset(LAIR_BLOCKS, "lair_chunk", new ReversiblePillarBlock(AbstractBlock.Settings.copy(lairMaterial).mapColor(MapColor.DARK_CRIMSON)));
    public static final Block LAIR_CELL = registerBlockInBlockset(LAIR_BLOCKS, "lair_cell", new Block(AbstractBlock.Settings.copy(lairMaterial)));
    public static final Block LAIR_AGED = registerBlockInBlockset(LAIR_BLOCKS, "lair_aged", new Block(AbstractBlock.Settings.copy(lairMaterial).mapColor(MapColor.DARK_CRIMSON)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - KRYP">
    private static final AbstractBlock krypMaterial = new Block(AbstractBlock.Settings.create()
            .mapColor(MapColor.TERRACOTTA_LIGHT_GRAY)
            .requiresTool()
            .strength(3.0f, 6.0f)
            .sounds(ModBlockSoundGroup.KRYP));
    public static final Block KRYP = registerBlockInBlockset(KRYP_BLOCKS, "kryp", new Block(AbstractBlock.Settings.copy(krypMaterial).sounds(ModBlockSoundGroup.KRYP_BASE)));
    public static final Block KRYP_WIRE = registerBlockInBlockset(KRYP_BLOCKS, "kryp_wire", new Block(AbstractBlock.Settings.copy(krypMaterial)));
    public static final Block KRYP_WIRE_STAIRS = registerStairs(KRYP_WIRE, "kryp_wire_stairs", new StairsBlock(KRYP_WIRE.getDefaultState(), AbstractBlock.Settings.copy(KRYP_WIRE)));
    public static final Block KRYP_WIRE_SLAB = registerSlab(KRYP_WIRE, "kryp_wire_slab", new SlabBlock(AbstractBlock.Settings.copy(KRYP_WIRE)));
    public static final Block KRYP_SUPPORT = registerBlockInBlockset(KRYP_BLOCKS, "kryp_support", new PillarBlock(AbstractBlock.Settings.copy(krypMaterial)));
    public static final Block KRYP_STORAGE = registerBlockInBlockset(KRYP_BLOCKS, "kryp_storage", new Block(AbstractBlock.Settings.copy(krypMaterial)));
    public static final Block KRYP_SMOOTH = registerBlockInBlockset(KRYP_BLOCKS, "kryp_smooth", new Block(AbstractBlock.Settings.copy(krypMaterial).sounds(ModBlockSoundGroup.KRYP_BASE)));
    public static final Block KRYP_SMOOTH_STAIRS = registerStairs(KRYP_SMOOTH, "kryp_smooth_stairs", new StairsBlock(KRYP_SMOOTH.getDefaultState(), AbstractBlock.Settings.copy(KRYP_SMOOTH).sounds(ModBlockSoundGroup.KRYP_BASE)));
    public static final Block KRYP_SMOOTH_SLAB = registerSlab(KRYP_SMOOTH, "kryp_smooth_slab", new SlabBlock(AbstractBlock.Settings.copy(KRYP_SMOOTH).sounds(ModBlockSoundGroup.KRYP_BASE)));
    public static final Block KRYP_SHEEN = registerBlockInBlockset(KRYP_BLOCKS, "kryp_sheen", new Block(AbstractBlock.Settings.copy(krypMaterial).sounds(ModBlockSoundGroup.KRYP_BASE)));
    public static final Block KRYP_RUIN = registerBlockInBlockset(KRYP_BLOCKS, "kryp_ruin", new Block(AbstractBlock.Settings.copy(krypMaterial)));
    public static final Block KRYP_OMITTER = registerBlockInBlockset(KRYP_BLOCKS, "kryp_omitter", new LitBlock(AbstractBlock.Settings.copy(krypMaterial).sounds(ModBlockSoundGroup.KRYP_BASE).luminance(createLightLevelFromProperty(11, Properties.LIT)), null, null, true));
    public static final Block KRYP_LEVI = registerBlockInBlockset(KRYP_BLOCKS, "kryp_levi", new Block(AbstractBlock.Settings.copy(krypMaterial).luminance(state -> 9).sounds(ModBlockSoundGroup.KRYP_NODE)));
    public static final Block KRYP_KUBT = registerBlockInBlockset(KRYP_BLOCKS, "kryp_kubt", new PillarBlock(AbstractBlock.Settings.copy(krypMaterial)));
    public static final Block KRYP_INFO = registerBlockInBlockset(KRYP_BLOCKS, "kryp_info", new Block(AbstractBlock.Settings.copy(krypMaterial).luminance(state -> 5).sounds(ModBlockSoundGroup.KRYP_NODE)));
    public static final Block KRYP_DATA = registerBlockInBlockset(KRYP_BLOCKS, "kryp_data", new Block(AbstractBlock.Settings.copy(krypMaterial).luminance(state -> 5).sounds(ModBlockSoundGroup.KRYP_NODE)));
    public static final Block KRYP_CONNECTOR = registerBlockInBlockset(KRYP_BLOCKS, "kryp_connector", new Block(AbstractBlock.Settings.copy(krypMaterial).luminance(state -> 5).sounds(ModBlockSoundGroup.KRYP_NODE)));
    public static final Block KRYP_CHUNK = registerBlockInBlockset(KRYP_BLOCKS, "kryp_chunk", new GlazedTerracottaBlock(AbstractBlock.Settings.copy(krypMaterial)));
    public static final Block KRYP_BEAM = registerBlockInBlockset(KRYP_BLOCKS, "kryp_beam", new Block(AbstractBlock.Settings.copy(krypMaterial).luminance(state -> 9).sounds(ModBlockSoundGroup.KRYP_NODE)));
    public static final Block KRYP_BASE = registerBlockInBlockset(KRYP_BLOCKS, "kryp_base", new Block(AbstractBlock.Settings.copy(krypMaterial).sounds(ModBlockSoundGroup.KRYP_BASE)));
    public static final Block KRYP_STAIRS = registerStairs(KRYP, "kryp_stairs", new StairsBlock(KRYP.getDefaultState(), AbstractBlock.Settings.copy(KRYP).sounds(ModBlockSoundGroup.KRYP_BASE)));
    public static final Block KRYP_SLAB = registerSlab(KRYP, "kryp_slab", new SlabBlock(AbstractBlock.Settings.copy(KRYP).sounds(ModBlockSoundGroup.KRYP_BASE)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - LAVE">
    private static final AbstractBlock laveMaterial = new Block(AbstractBlock.Settings.create()
            .mapColor(MapColor.LIGHT_BLUE_GRAY)
            .instrument(NoteBlockInstrument.BASEDRUM)
            .requiresTool()
            .strength(0.8f)
            .sounds(ModBlockSoundGroup.LAVE));
    public static final Block LAVE = registerBlockInBlockset(LAVE_BLOCKS, "lave", new Block(AbstractBlock.Settings.copy(laveMaterial)));
    public static final Block LAVE_WINDOW = registerBlockInBlockset(LAVE_BLOCKS, "lave_window", new Block(AbstractBlock.Settings.copy(laveMaterial)));
    public static final Block LAVE_VENT = registerBlockInBlockset(LAVE_BLOCKS, "lave_vent", new Block(AbstractBlock.Settings.copy(laveMaterial)));
    public static final Block LAVE_UNEVEN = registerBlockInBlockset(LAVE_BLOCKS, "lave_uneven", new Block(AbstractBlock.Settings.copy(laveMaterial)));
    public static final Block LAVE_TRACKPAD = registerBlockInBlockset(LAVE_BLOCKS, "lave_trackpad", new PillarBlock(AbstractBlock.Settings.copy(laveMaterial)));
    public static final Block LAVE_TILE = registerBlockInBlockset(LAVE_BLOCKS, "lave_tile", new Block(AbstractBlock.Settings.copy(laveMaterial)));
    public static final Block LAVE_TILE_STAIRS = registerStairs(LAVE_TILE, "lave_tile_stairs", new StairsBlock(LAVE_TILE.getDefaultState(), AbstractBlock.Settings.copy(LAVE_TILE)));
    public static final Block LAVE_TILE_SLAB = registerSlab(LAVE_TILE, "lave_tile_slab", new SlabBlock(AbstractBlock.Settings.copy(LAVE_TILE)));
    public static final Block LAVE_THICK = registerBlockInBlockset(LAVE_BLOCKS, "lave_thick", new Block(AbstractBlock.Settings.copy(laveMaterial)));
    public static final Block LAVE_SECTION = registerBlockInBlockset(LAVE_BLOCKS, "lave_section", new Block(AbstractBlock.Settings.copy(laveMaterial)));
    public static final Block LAVE_PANEL = registerBlockInBlockset(LAVE_BLOCKS, "lave_panel", new Block(AbstractBlock.Settings.copy(laveMaterial)));
    public static final Block LAVE_LOW = registerBlockInBlockset(LAVE_BLOCKS, "lave_low", new Block(AbstractBlock.Settings.copy(laveMaterial).mapColor(MapColor.CYAN)));
    public static final Block LAVE_HEX = registerBlockInBlockset(LAVE_BLOCKS, "lave_hex", new Block(AbstractBlock.Settings.copy(laveMaterial)));
    public static final Block LAVE_ELEVATE = registerBlockInBlockset(LAVE_BLOCKS, "lave_elevate", new PillarBlock(AbstractBlock.Settings.copy(laveMaterial)));
    public static final Block LAVE_DIM = registerBlockInBlockset(LAVE_BLOCKS, "lave_dim", new Block(AbstractBlock.Settings.copy(laveMaterial)));
    public static final Block LAVE_DARK = registerBlockInBlockset(LAVE_BLOCKS, "lave_dark", new Block(AbstractBlock.Settings.copy(laveMaterial).mapColor(MapColor.CYAN)));
    public static final Block LAVE_CROSSSECTION = registerBlockInBlockset(LAVE_BLOCKS, "lave_crosssection", new Block(AbstractBlock.Settings.copy(laveMaterial)));
    public static final Block LAVE_BEAM = registerBlockInBlockset(LAVE_BLOCKS, "lave_beam", new PillarBlock(AbstractBlock.Settings.copy(laveMaterial)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - VEELD">
    private static final AbstractBlock veeldMaterial = new Block(AbstractBlock.Settings.create()
            .mapColor(MapColor.LICHEN_GREEN)
            .instrument(NoteBlockInstrument.BASEDRUM)
            .requiresTool()
            .strength(2.0f, 6.0f)
            .sounds(ModBlockSoundGroup.VEELD));
    public static final Block VEELD = registerBlockInBlockset(VEELD_BLOCKS, "veeld", new Block(AbstractBlock.Settings.copy(veeldMaterial).mapColor(MapColor.GREEN)));
    public static final Block VEELD_WET = registerBlockInBlockset(VEELD_BLOCKS, "veeld_wet", new Block(AbstractBlock.Settings.copy(veeldMaterial).mapColor(MapColor.GREEN)));
    public static final Block VEELD_TRACTION = registerBlockInBlockset(VEELD_BLOCKS, "veeld_traction", new PillarBlock(AbstractBlock.Settings.copy(veeldMaterial)));
    public static final Block VEELD_STRUCTURE = registerBlockInBlockset(VEELD_BLOCKS, "veeld_structure", new PillarBlock(AbstractBlock.Settings.copy(veeldMaterial)));
    public static final Block VEELD_RIVETED = registerBlockInBlockset(VEELD_BLOCKS, "veeld_riveted", new Block(AbstractBlock.Settings.copy(veeldMaterial)));
    public static final Block VEELD_RIPPLE = registerBlockInBlockset(VEELD_BLOCKS, "veeld_ripple", new Block(AbstractBlock.Settings.copy(veeldMaterial)));
    public static final Block VEELD_RIGIDBRICK = registerBlockInBlockset(VEELD_BLOCKS, "veeld_rigidbrick", new Block(AbstractBlock.Settings.copy(veeldMaterial).sounds(ModBlockSoundGroup.VEELD_BRICKS)));
    public static final Block VEELD_RIGID = registerBlockInBlockset(VEELD_BLOCKS, "veeld_rigid", new Block(AbstractBlock.Settings.copy(veeldMaterial)));
    public static final Block VEELD_PIPEWEAVE = registerBlockInBlockset(VEELD_BLOCKS, "veeld_pipeweave", new Block(AbstractBlock.Settings.copy(veeldMaterial)));
    public static final Block VEELD_PATTERNED = registerBlockInBlockset(VEELD_BLOCKS, "veeld_patterned", new GlazedTerracottaBlock(AbstractBlock.Settings.copy(veeldMaterial)));
    public static final Block VEELD_PANEL = registerBlockInBlockset(VEELD_BLOCKS, "veeld_panel", new Block(AbstractBlock.Settings.copy(veeldMaterial)));
    public static final Block VEELD_ETCHED = registerBlockInBlockset(VEELD_BLOCKS, "veeld_etched", new Block(AbstractBlock.Settings.copy(veeldMaterial).mapColor(MapColor.GREEN)));
    public static final Block VEELD_EMBOSSED = registerBlockInBlockset(VEELD_BLOCKS, "veeld_embossed", new Block(AbstractBlock.Settings.copy(veeldMaterial).mapColor(MapColor.GREEN)));
    public static final Block VEELD_DRILL = registerBlockInBlockset(VEELD_BLOCKS, "veeld_drill", new PillarBlock(AbstractBlock.Settings.copy(veeldMaterial)));
    public static final Block VEELD_CORE = registerBlockInBlockset(VEELD_BLOCKS, "veeld_core", new Block(AbstractBlock.Settings.copy(veeldMaterial)));
    public static final Block VEELD_BRICK = registerBlockInBlockset(VEELD_BLOCKS, "veeld_brick", new Block(AbstractBlock.Settings.copy(veeldMaterial).sounds(ModBlockSoundGroup.VEELD_BRICKS)));
    public static final Block VEELD_STAIRS = registerStairs(VEELD, "veeld_stairs", new StairsBlock(VEELD.getDefaultState(), AbstractBlock.Settings.copy(VEELD)));

    static {
        STAIRS_FROM_BLOCK.put(VEELD, VEELD_STAIRS);
    }

    public static final Block VEELD_SLAB = registerSlab(VEELD, "veeld_slab", new SlabBlock(AbstractBlock.Settings.copy(VEELD)));

    static {
        SLAB_FROM_BLOCK.put(VEELD, VEELD_SLAB);
    }

    //</editor-fold>
    //<editor-fold desc ="Blocks - JELT">
    private static final AbstractBlock jeltMaterial = new Block(AbstractBlock.Settings.create()
            .mapColor(MapColor.ORANGE)
            .requiresTool()
            .strength(2.4f, 2.0f)
            .sounds(ModBlockSoundGroup.JELT));
    public static final Block JELT = registerBlockInBlockset(JELT_BLOCKS, "jelt", new Block(AbstractBlock.Settings.copy(jeltMaterial)));
    public static final Block JELT_SUPPLY = registerBlockInBlockset(JELT_BLOCKS, "jelt_supply", new Block(AbstractBlock.Settings.copy(jeltMaterial)));
    public static final Block JELT_POKE = registerBlockInBlockset(JELT_BLOCKS, "jelt_poke", new Block(AbstractBlock.Settings.copy(jeltMaterial)));
    public static final Block JELT_PATHJOINT = registerBlockInBlockset(JELT_BLOCKS, "jelt_pathjoint", new GlazedTerracottaBlock(AbstractBlock.Settings.copy(jeltMaterial)));
    public static final Block JELT_PATH = registerBlockInBlockset(JELT_BLOCKS, "jelt_path", new PillarBlock(AbstractBlock.Settings.copy(jeltMaterial)));
    public static final Block JELT_ORGANIZE = registerBlockInBlockset(JELT_BLOCKS, "jelt_organize", new Block(AbstractBlock.Settings.copy(jeltMaterial)));
    public static final Block JELT_ORBULE = registerBlockInBlockset(JELT_BLOCKS, "jelt_orbule", new Block(AbstractBlock.Settings.copy(jeltMaterial)));
    public static final Block JELT_LUMINA = registerBlockInBlockset(JELT_BLOCKS, "jelt_lumina", new Block(AbstractBlock.Settings.copy(jeltMaterial)));
    public static final Block JELT_FUSION = registerBlockInBlockset(JELT_BLOCKS, "jelt_fusion", new Block(AbstractBlock.Settings.copy(jeltMaterial)));
    public static final Block JELT_FISSION = registerBlockInBlockset(JELT_BLOCKS, "jelt_fission", new Block(AbstractBlock.Settings.copy(jeltMaterial)));
    public static final Block JELT_EXHAUST = registerBlockInBlockset(JELT_BLOCKS, "jelt_exhaust", new PillarBlock(AbstractBlock.Settings.copy(jeltMaterial)));
    public static final Block JELT_ENERGY = registerBlockInBlockset(JELT_BLOCKS, "jelt_energy", new Block(AbstractBlock.Settings.copy(jeltMaterial)));
    public static final Block JELT_EMBOSS = registerBlockInBlockset(JELT_BLOCKS, "jelt_emboss", new Block(AbstractBlock.Settings.copy(jeltMaterial)));
    public static final Block JELT_DESTINE = registerBlockInBlockset(JELT_BLOCKS, "jelt_destine", new Block(AbstractBlock.Settings.copy(jeltMaterial)));
    public static final Block JELT_CONFINE = registerBlockInBlockset(JELT_BLOCKS, "jelt_confine", new Block(AbstractBlock.Settings.copy(jeltMaterial).mapColor(MapColor.BLACK)));
    public static final Block JELT_ATWAL = registerBlockInBlockset(JELT_BLOCKS, "jelt_atwal", new Block(AbstractBlock.Settings.copy(jeltMaterial)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - KORP">
    private static final AbstractBlock korpMaterial = new Block(AbstractBlock.Settings.create()
            .mapColor(MapColor.TERRACOTTA_BLACK)
            .requiresTool()
            .strength(2.0f, 6.0f)
            .sounds(ModBlockSoundGroup.KORP));
    public static final Block KORP = registerBlockInBlockset(KORP_BLOCKS, "korp", new Block(AbstractBlock.Settings.copy(korpMaterial)));
    public static final Block KORP_WALL = registerBlockInBlockset(KORP_BLOCKS, "korp_wall", new Block(AbstractBlock.Settings.copy(korpMaterial)));
    public static final Block KORP_VEST = registerBlockInBlockset(KORP_BLOCKS, "korp_vest", new PillarBlock(AbstractBlock.Settings.copy(korpMaterial)));
    public static final Block KORP_SECURE = registerBlockInBlockset(KORP_BLOCKS, "korp_secure", new Block(AbstractBlock.Settings.copy(korpMaterial)));
    public static final Block KORP_RUPT = registerBlockInBlockset(KORP_BLOCKS, "korp_rupt", new PillarBlock(AbstractBlock.Settings.copy(korpMaterial)));
    public static final Block KORP_RESOURCE = registerBlockInBlockset(KORP_BLOCKS, "korp_resource", new PillarBlock(AbstractBlock.Settings.copy(korpMaterial).mapColor(MapColor.DIAMOND_BLUE).luminance(state -> 11).sounds(ModBlockSoundGroup.KORP_NODE)));
    public static final Block KORP_REGULATE = registerBlockInBlockset(KORP_BLOCKS, "korp_regulate", new Block(AbstractBlock.Settings.copy(korpMaterial)));
    public static final Block KORP_OUTFLOW = registerBlockInBlockset(KORP_BLOCKS, "korp_outflow", new PillarBlock(AbstractBlock.Settings.copy(korpMaterial)));
    public static final Block KORP_MARK = registerBlockInBlockset(KORP_BLOCKS, "korp_mark", new Block(AbstractBlock.Settings.copy(korpMaterial)));
    public static final Block KORP_HOLDING = registerBlockInBlockset(KORP_BLOCKS, "korp_holding", new Block(AbstractBlock.Settings.copy(korpMaterial)));
    public static final Block KORP_GROWTH = registerBlockInBlockset(KORP_BLOCKS, "korp_growth", new Block(AbstractBlock.Settings.copy(korpMaterial)));
    public static final Block KORP_FLOW = registerBlockInBlockset(KORP_BLOCKS, "korp_flow", new PillarBlock(AbstractBlock.Settings.copy(korpMaterial).luminance(state -> 7).sounds(ModBlockSoundGroup.KORP_NODE)));
    public static final Block KORP_CONSUME = registerBlockInBlockset(KORP_BLOCKS, "korp_consume", new GlazedTerracottaBlock(AbstractBlock.Settings.copy(korpMaterial).luminance(state -> 7).sounds(ModBlockSoundGroup.KORP_NODE)));
    public static final Block KORP_COMMAND = registerBlockInBlockset(KORP_BLOCKS, "korp_command", new Block(AbstractBlock.Settings.copy(korpMaterial)));
    public static final Block KORP_BANK = registerBlockInBlockset(KORP_BLOCKS, "korp_bank", new Block(AbstractBlock.Settings.copy(korpMaterial).mapColor(MapColor.DIAMOND_BLUE).luminance(state -> 11).sounds(ModBlockSoundGroup.KORP_NODE)));
    public static final Block KORP_ASSET = registerBlockInBlockset(KORP_BLOCKS, "korp_asset", new Block(AbstractBlock.Settings.copy(korpMaterial)));

    //    };
    //</editor-fold>
    //<editor-fold desc ="Blocks - TANK">
    private static final AbstractBlock tankMaterial = new Block(AbstractBlock.Settings.create()
            .mapColor(MapColor.LIGHT_GRAY)
            .requiresTool()
            .strength(2.4f, 2.0f)
            .sounds(ModBlockSoundGroup.TANK));
    public static final Block TANK = registerBlockInBlockset(TANK_BLOCKS, "tank", new Block(AbstractBlock.Settings.copy(tankMaterial)));
    public static final Block TANK_CAMO = registerBlockInBlockset(TANK_BLOCKS, "tank_camo", new Block(AbstractBlock.Settings.copy(tankMaterial)));
    public static final Block TANK_CAMOCOVER = registerBlockInBlockset(TANK_BLOCKS, "tank_camocover", new PillarBlock(AbstractBlock.Settings.copy(tankMaterial)));
    public static final Block TANK_CANNON = registerBlockInBlockset(TANK_BLOCKS, "tank_cannon", new GlazedTerracottaBlock(AbstractBlock.Settings.copy(tankMaterial)));
    public static final Block TANK_CHUTE = registerBlockInBlockset(TANK_BLOCKS, "tank_chute", new PillarBlock(AbstractBlock.Settings.copy(tankMaterial)));
    public static final Block TANK_CLAD = registerBlockInBlockset(TANK_BLOCKS, "tank_clad", new Block(AbstractBlock.Settings.copy(tankMaterial)));
    public static final Block TANK_FORTIFIED = registerBlockInBlockset(TANK_BLOCKS, "tank_fortified", new Block(AbstractBlock.Settings.copy(tankMaterial)));
    public static final Block TANK_GATED = registerBlockInBlockset(TANK_BLOCKS, "tank_gated", new PillarBlock(AbstractBlock.Settings.copy(tankMaterial)));
    public static final Block TANK_MESH = registerBlockInBlockset(TANK_BLOCKS, "tank_mesh", new Block(AbstractBlock.Settings.copy(tankMaterial).mapColor(MapColor.GRAY)));
    public static final Block TANK_NET = registerBlockInBlockset(TANK_BLOCKS, "tank_net", new Block(AbstractBlock.Settings.copy(tankMaterial).mapColor(MapColor.GRAY)));
    public static final Block TANK_PANELS = registerBlockInBlockset(TANK_BLOCKS, "tank_panels", new Block(AbstractBlock.Settings.copy(tankMaterial)));
    public static final Block TANK_REINFORCED = registerBlockInBlockset(TANK_BLOCKS, "tank_reinforced", new Block(AbstractBlock.Settings.copy(tankMaterial)));
    public static final Block TANK_SHINGLE = registerBlockInBlockset(TANK_BLOCKS, "tank_shingle", new Block(AbstractBlock.Settings.copy(tankMaterial)));
    public static final Block TANK_STUD = registerBlockInBlockset(TANK_BLOCKS, "tank_stud", new Block(AbstractBlock.Settings.copy(tankMaterial)));
    public static final Block TANK_STURDY = registerBlockInBlockset(TANK_BLOCKS, "tank_sturdy", new PillarBlock(AbstractBlock.Settings.copy(tankMaterial)));
    public static final Block TANK_TREAD = registerBlockInBlockset(TANK_BLOCKS, "tank_tread", new Block(AbstractBlock.Settings.copy(tankMaterial)));

    //</editor-fold>
    //<editor-fold desc ="Blocks - EXRI">
    private static final AbstractBlock exriMaterial = new Block(AbstractBlock.Settings.create()
            .mapColor(MapColor.GRAY)
            .requiresTool()
            .strength(1.8f)
            .sounds(ModBlockSoundGroup.EXRI));
    public static final Block EXRI = registerBlockInBlockset(EXRI_BLOCKS, "exri", new Block(AbstractBlock.Settings.copy(exriMaterial)));
    public static final Block EXRI_LEVEL = registerBlockInBlockset(EXRI_BLOCKS, "exri_level", new LitHorizontalFacingBlock(AbstractBlock.Settings.copy(exriMaterial)));
    public static final Block EXRI_TECT = registerBlockInBlockset(EXRI_BLOCKS, "exri_tect", new Block(AbstractBlock.Settings.copy(exriMaterial)));
    public static final Block EXRI_STEM = registerBlockInBlockset(EXRI_BLOCKS, "exri_stem", new Block(AbstractBlock.Settings.copy(exriMaterial)));
    public static final Block EXRI_STEEL = registerBlockInBlockset(EXRI_BLOCKS, "exri_steel", new Block(AbstractBlock.Settings.copy(exriMaterial)));
    public static final Block EXRI_SERVE = registerBlockInBlockset(EXRI_BLOCKS, "exri_serve", new LitPillarBlock(AbstractBlock.Settings.copy(exriMaterial))); //TODO lit/unlit textures/anim
    public static final Block EXRI_SEAL = registerBlockInBlockset(EXRI_BLOCKS, "exri_seal", new Block(AbstractBlock.Settings.copy(exriMaterial)));
    public static final Block EXRI_SCREEN = registerBlockInBlockset(EXRI_BLOCKS, "exri_screen", new Block(AbstractBlock.Settings.copy(exriMaterial).sounds(ModBlockSoundGroup.ISZM)));
    public static final Block EXRI_ROGEN = registerBlockInBlockset(EXRI_BLOCKS, "exri_rogen", new Block(AbstractBlock.Settings.copy(exriMaterial)));
    public static final Block EXRI_MESH = registerBlockInBlockset(EXRI_BLOCKS, "exri_mesh", new Block(AbstractBlock.Settings.copy(exriMaterial)));
    public static final Block EXRI_FLOW = registerBlockInBlockset(EXRI_BLOCKS, "exri_flow", new LitBlock(AbstractBlock.Settings.copy(exriMaterial)));
    public static final Block EXRI_DIVIDE = registerBlockInBlockset(EXRI_BLOCKS, "exri_divide", new Block(AbstractBlock.Settings.copy(exriMaterial)));
    public static final Block EXRI_DIVIDE_STAIRS = registerStairs(EXRI_DIVIDE, "exri_divide_stairs", new StairsBlock(EXRI_DIVIDE.getDefaultState(), AbstractBlock.Settings.copy(EXRI_DIVIDE)));

    static {
        STAIRS_FROM_BLOCK.put(EXRI_DIVIDE, EXRI_DIVIDE_STAIRS);
    }

    public static final Block EXRI_DIVIDE_SLAB = registerSlab(EXRI_DIVIDE, "exri_divide_slab", new SlabBlock(AbstractBlock.Settings.copy(EXRI_DIVIDE)));

    static {
        SLAB_FROM_BLOCK.put(EXRI_DIVIDE, EXRI_DIVIDE_SLAB);
    }

    public static final Block EXRI_DISPLAY = registerBlockInBlockset(EXRI_BLOCKS, "exri_display", new LitHorizontalFacingBlock(AbstractBlock.Settings.copy(exriMaterial)));
    public static final Block EXRI_CURRENT = registerBlockInBlockset(EXRI_BLOCKS, "exri_current", new LitHorizontalFacingBlock(AbstractBlock.Settings.copy(exriMaterial)));
    public static final Block EXRI_CRITICAL = registerBlockInBlockset(EXRI_BLOCKS, "exri_critical", new LitHorizontalFacingBlock(AbstractBlock.Settings.copy(exriMaterial)));
    public static final Block EXRI_CONTROL = registerBlockInBlockset(EXRI_BLOCKS, "exri_control", new LitHorizontalFacingBlock(AbstractBlock.Settings.copy(exriMaterial)));

    //</editor-fold>
    //<editor-fold desc ="Blocks - AZUR">
    private static final AbstractBlock azurMaterial = new Block(AbstractBlock.Settings.create()
            .mapColor(MapColor.LAPIS_BLUE)
            .requiresTool()
            .strength(2.4f, 2.0f)
            .sounds(ModBlockSoundGroup.AZUR));
    public static final Block AZUR = registerBlockInBlockset(AZUR_BLOCKS, "azur", new Block(AbstractBlock.Settings.copy(azurMaterial)));
    public static final Block AZUR_CRIPT = registerBlockInBlockset(AZUR_BLOCKS, "azur_cript", new PillarBlock(AbstractBlock.Settings.copy(azurMaterial)));
    public static final Block AZUR_CUBE = registerBlockInBlockset(AZUR_BLOCKS, "azur_cube", new Block(AbstractBlock.Settings.copy(azurMaterial)));
    public static final Block AZUR_CYBER = registerBlockInBlockset(AZUR_BLOCKS, "azur_cyber", new PillarBlock(AbstractBlock.Settings.copy(azurMaterial)));
    public static final Block AZUR_GUIDE = registerBlockInBlockset(AZUR_BLOCKS, "azur_guide", new PillarBlock(AbstractBlock.Settings.copy(azurMaterial)));
    public static final Block AZUR_KINETIC = registerBlockInBlockset(AZUR_BLOCKS, "azur_kinetic", new Block(AbstractBlock.Settings.copy(azurMaterial)));
    public static final Block AZUR_NEURON = registerBlockInBlockset(AZUR_BLOCKS, "azur_neuron", new Block(AbstractBlock.Settings.copy(azurMaterial)));
    public static final Block AZUR_PAVE = registerBlockInBlockset(AZUR_BLOCKS, "azur_pave", new Block(AbstractBlock.Settings.copy(azurMaterial)));
    public static final Block AZUR_PERATION = registerBlockInBlockset(AZUR_BLOCKS, "azur_peration", new Block(AbstractBlock.Settings.copy(azurMaterial)));
    public static final Block AZUR_PLUG = registerBlockInBlockset(AZUR_BLOCKS, "azur_plug", new Block(AbstractBlock.Settings.copy(azurMaterial)));
    public static final Block AZUR_RIPPLE = registerBlockInBlockset(AZUR_BLOCKS, "azur_ripple", new Block(AbstractBlock.Settings.copy(azurMaterial)));
    public static final Block AZUR_RUN = registerBlockInBlockset(AZUR_BLOCKS, "azur_run", new Block(AbstractBlock.Settings.copy(azurMaterial)));
    public static final Block AZUR_SCRAPE = registerBlockInBlockset(AZUR_BLOCKS, "azur_scrape", new Block(AbstractBlock.Settings.copy(azurMaterial)));
    public static final Block AZUR_SENSORY = registerBlockInBlockset(AZUR_BLOCKS, "azur_sensory", new Block(AbstractBlock.Settings.copy(azurMaterial)));
    public static final Block AZUR_SIGN = registerBlockInBlockset(AZUR_BLOCKS, "azur_sign", new Block(AbstractBlock.Settings.copy(azurMaterial)));
    public static final Block AZUR_SIGNAL = registerBlockInBlockset(AZUR_BLOCKS, "azur_signal", new PillarBlock(AbstractBlock.Settings.copy(azurMaterial)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - FLEQ">
    private static final AbstractBlock fleqMaterial = new Block(AbstractBlock.Settings.create()
            .mapColor(MapColor.DARK_AQUA)
            .requiresTool()
            .strength(2.4f, 2.0f)
            .sounds(ModBlockSoundGroup.FLEQ));
    public static final Block FLEQ = registerBlockInBlockset(FLEQ_BLOCKS, "fleq", new Block(AbstractBlock.Settings.copy(fleqMaterial)));
    public static final Block FLEQ_WET = registerBlockInBlockset(FLEQ_BLOCKS, "fleq_wet", new Block(AbstractBlock.Settings.copy(fleqMaterial)));
    public static final Block FLEQ_VALVE = registerBlockInBlockset(FLEQ_BLOCKS, "fleq_valve", new Block(AbstractBlock.Settings.copy(fleqMaterial)));
    public static final Block FLEQ_TUBE = registerBlockInBlockset(FLEQ_BLOCKS, "fleq_tube", new PillarBlock(AbstractBlock.Settings.copy(fleqMaterial)));
    public static final Block FLEQ_STACK = registerBlockInBlockset(FLEQ_BLOCKS, "fleq_stack", new Block(AbstractBlock.Settings.copy(fleqMaterial)));
    public static final Block FLEQ_RUBBLE = registerBlockInBlockset(FLEQ_BLOCKS, "fleq_rubble", new Block(AbstractBlock.Settings.copy(fleqMaterial).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final Block FLEQ_RECK = registerBlockInBlockset(FLEQ_BLOCKS, "fleq_reck", new Block(AbstractBlock.Settings.copy(fleqMaterial).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final Block FLEQ_PIPE = registerBlockInBlockset(FLEQ_BLOCKS, "fleq_pipe", new GlazedTerracottaBlock(AbstractBlock.Settings.copy(fleqMaterial)));
    public static final Block FLEQ_LENT = registerBlockInBlockset(FLEQ_BLOCKS, "fleq_lent", new Block(AbstractBlock.Settings.copy(fleqMaterial)));
    public static final Block FLEQ_LARVAE = registerBlockInBlockset(FLEQ_BLOCKS, "fleq_larvae", new GlazedTerracottaBlock(AbstractBlock.Settings.copy(fleqMaterial)));
    public static final Block FLEQ_ILLUSION = registerBlockInBlockset(FLEQ_BLOCKS, "fleq_illusion", new Block(AbstractBlock.Settings.copy(fleqMaterial)));
    public static final Block FLEQ_ERODE = registerBlockInBlockset(FLEQ_BLOCKS, "fleq_erode", new Block(AbstractBlock.Settings.copy(fleqMaterial).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final Block FLEQ_DIRECT = registerBlockInBlockset(FLEQ_BLOCKS, "fleq_direct", new PillarBlock(AbstractBlock.Settings.copy(fleqMaterial)));
    public static final Block FLEQ_BUBBLE = registerBlockInBlockset(FLEQ_BLOCKS, "fleq_bubble", new Block(AbstractBlock.Settings.copy(fleqMaterial)));
    public static final Block FLEQ_BOLDEN = registerBlockInBlockset(FLEQ_BLOCKS, "fleq_bolden", new Block(AbstractBlock.Settings.copy(fleqMaterial)));
    public static final Block FLEQ_ABODE = registerBlockInBlockset(FLEQ_BLOCKS, "fleq_abode", new Block(AbstractBlock.Settings.copy(fleqMaterial)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - ISZM">
    private static final AbstractBlock iszmMaterial = new Block(AbstractBlock.Settings.create()
            .strength(0.3f)
            .luminance(createLightLevelFromProperty(11, Properties.LIT))
            .sounds(ModBlockSoundGroup.ISZM));
    public static final Block ISZM = registerBlockInBlockset(ISZM_BLOCKS, "iszm", new LitBlock(AbstractBlock.Settings.copy(iszmMaterial).mapColor(MapColor.GRAY)));
    public static final Block WHITE_ISZM = registerBlockInBlockset(ISZM_BLOCKS, "white_iszm", new LitBlock(AbstractBlock.Settings.copy(iszmMaterial).mapColor(MapColor.TERRACOTTA_WHITE)));
    public static final Block FADED_ISZM = registerBlockInBlockset(ISZM_BLOCKS, "faded_iszm", new LitBlock(AbstractBlock.Settings.copy(iszmMaterial).mapColor(MapColor.PALE_YELLOW)));
    public static final Block NEUTRAL_ISZM = registerBlockInBlockset(ISZM_BLOCKS, "neutral_iszm", new LitBlock(AbstractBlock.Settings.copy(iszmMaterial).mapColor(MapColor.WHITE_GRAY)));
    public static final Block DUSTY_ISZM = registerBlockInBlockset(ISZM_BLOCKS, "dusty_iszm", new LitBlock(AbstractBlock.Settings.copy(iszmMaterial).mapColor(MapColor.OAK_TAN)));
    public static final Block SCORCHED_ISZM = registerBlockInBlockset(ISZM_BLOCKS, "scorched_iszm", new LitBlock(AbstractBlock.Settings.copy(iszmMaterial).mapColor(MapColor.DARK_CRIMSON)));
    public static final Block DARK_ISZM = registerBlockInBlockset(ISZM_BLOCKS, "dark_iszm", new LitBlock(AbstractBlock.Settings.copy(iszmMaterial).mapColor(MapColor.DARK_RED)));
    public static final Block RED_ISZM = registerBlockInBlockset(ISZM_BLOCKS, "red_iszm", new LitBlock(AbstractBlock.Settings.copy(iszmMaterial).mapColor(MapColor.DULL_RED)));
    public static final Block PINK_ISZM = registerBlockInBlockset(ISZM_BLOCKS, "pink_iszm", new LitBlock(AbstractBlock.Settings.copy(iszmMaterial).mapColor(MapColor.TERRACOTTA_RED)));
    public static final Block GREEN_ISZM = registerBlockInBlockset(ISZM_BLOCKS, "green_iszm", new LitBlock(AbstractBlock.Settings.copy(iszmMaterial).mapColor(MapColor.LIME)));
    public static final Block WARM_ISZM = registerBlockInBlockset(ISZM_BLOCKS, "warm_iszm", new LitBlock(AbstractBlock.Settings.copy(iszmMaterial).mapColor(MapColor.TERRACOTTA_LIME)));
    public static final Block VIBRANT_ISZM = registerBlockInBlockset(ISZM_BLOCKS, "vibrant_iszm", new LitBlock(AbstractBlock.Settings.copy(iszmMaterial).mapColor(MapColor.PALE_GREEN)));
    public static final Block GAME_ISZM = registerBlockInBlockset(ISZM_BLOCKS, "game_iszm", new LitBlock(AbstractBlock.Settings.copy(iszmMaterial).mapColor(MapColor.GREEN)));
    public static final Block BURNED_ISZM = registerBlockInBlockset(ISZM_BLOCKS, "burned_iszm", new LitBlock(AbstractBlock.Settings.copy(iszmMaterial).mapColor(MapColor.TERRACOTTA_GREEN)));
    public static final Block COLD_ISZM = registerBlockInBlockset(ISZM_BLOCKS, "cold_iszm", new LitBlock(AbstractBlock.Settings.copy(iszmMaterial).mapColor(MapColor.TERRACOTTA_LIGHT_BLUE)));
    public static final Block STUDY_ISZM = registerBlockInBlockset(ISZM_BLOCKS, "study_iszm", new LitBlock(AbstractBlock.Settings.copy(iszmMaterial).mapColor(MapColor.BLUE)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - MYST">
    private static final AbstractBlock mystMaterial = new Block(AbstractBlock.Settings.create() // TODO, color based scrolling animation // what did i MEAN by this grrgrjgjrglerkgjer;kgkj;ekgrj // i assume u meant to sort the coloured blocks in the creative inventory?
            .strength(0.3f)
            .mapColor(MapColor.CLEAR)
            .nonOpaque()
            .allowsSpawning(ModBlocks::never)
            .solidBlock(ModBlocks::never)
            .suffocates(ModBlocks::never)
            .blockVision(ModBlocks::never)
            .sounds(ModBlockSoundGroup.MYST));
    public static final Block WHITE_MYST = registerBlockInBlockset(MYST_BLOCKS, "white_myst", new StainedGlassBlock(DyeColor.WHITE, AbstractBlock.Settings.copy(mystMaterial)));
    public static final Block LIGHT_GRAY_MYST = registerBlockInBlockset(MYST_BLOCKS, "light_gray_myst", new StainedGlassBlock(DyeColor.LIGHT_GRAY, AbstractBlock.Settings.copy(mystMaterial)));
    public static final Block GRAY_MYST = registerBlockInBlockset(MYST_BLOCKS, "gray_myst", new StainedGlassBlock(DyeColor.GRAY, AbstractBlock.Settings.copy(mystMaterial)));
    public static final Block BLACK_MYST = registerBlockInBlockset(MYST_BLOCKS, "black_myst", new StainedGlassBlock(DyeColor.BLACK, AbstractBlock.Settings.copy(mystMaterial)));
    public static final Block BROWN_MYST = registerBlockInBlockset(MYST_BLOCKS, "brown_myst", new StainedGlassBlock(DyeColor.BROWN, AbstractBlock.Settings.copy(mystMaterial)));
    public static final Block RED_MYST = registerBlockInBlockset(MYST_BLOCKS, "red_myst", new StainedGlassBlock(DyeColor.RED, AbstractBlock.Settings.copy(mystMaterial)));
    public static final Block ORANGE_MYST = registerBlockInBlockset(MYST_BLOCKS, "orange_myst", new StainedGlassBlock(DyeColor.ORANGE, AbstractBlock.Settings.copy(mystMaterial)));
    public static final Block YELLOW_MYST = registerBlockInBlockset(MYST_BLOCKS, "yellow_myst", new StainedGlassBlock(DyeColor.YELLOW, AbstractBlock.Settings.copy(mystMaterial)));
    public static final Block LIME_MYST = registerBlockInBlockset(MYST_BLOCKS, "lime_myst", new StainedGlassBlock(DyeColor.LIME, AbstractBlock.Settings.copy(mystMaterial)));
    public static final Block GREEN_MYST = registerBlockInBlockset(MYST_BLOCKS, "green_myst", new StainedGlassBlock(DyeColor.GREEN, AbstractBlock.Settings.copy(mystMaterial)));
    public static final Block CYAN_MYST = registerBlockInBlockset(MYST_BLOCKS, "cyan_myst", new StainedGlassBlock(DyeColor.CYAN, AbstractBlock.Settings.copy(mystMaterial)));
    public static final Block LIGHT_BLUE_MYST = registerBlockInBlockset(MYST_BLOCKS, "light_blue_myst", new StainedGlassBlock(DyeColor.LIGHT_BLUE, AbstractBlock.Settings.copy(mystMaterial)));
    public static final Block BLUE_MYST = registerBlockInBlockset(MYST_BLOCKS, "blue_myst", new StainedGlassBlock(DyeColor.BLUE, AbstractBlock.Settings.copy(mystMaterial)));
    public static final Block PURPLE_MYST = registerBlockInBlockset(MYST_BLOCKS, "purple_myst", new StainedGlassBlock(DyeColor.PURPLE, AbstractBlock.Settings.copy(mystMaterial)));
    public static final Block MAGENTA_MYST = registerBlockInBlockset(MYST_BLOCKS, "magenta_myst", new StainedGlassBlock(DyeColor.MAGENTA, AbstractBlock.Settings.copy(mystMaterial)));
    public static final Block PINK_MYST = registerBlockInBlockset(MYST_BLOCKS, "pink_myst", new StainedGlassBlock(DyeColor.PINK, AbstractBlock.Settings.copy(mystMaterial)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - SYNC">
    private static final AbstractBlock syncMaterial = new Block(AbstractBlock.Settings.create()
            .mapColor(MapColor.LIME)
            .requiresTool()
            .strength(2.4f, 2.0f)
            .sounds(ModBlockSoundGroup.SYNC));
    public static final Block SYNC = registerBlockInBlockset(SYNC_BLOCKS, "sync", new LitBlock(AbstractBlock.Settings.copy(syncMaterial)));
    public static final Block SYNC_TANK = registerBlockInBlockset(SYNC_BLOCKS, "sync_tank", new LitPillarBlock(AbstractBlock.Settings.copy(syncMaterial)));
    public static final Block SYNC_SHIELDING = registerBlockInBlockset(SYNC_BLOCKS, "sync_shielding", new LitBlock(AbstractBlock.Settings.copy(syncMaterial).mapColor(MapColor.BLACK)));
    public static final Block SYNC_SAFE = registerBlockInBlockset(SYNC_BLOCKS, "sync_safe", new LitBlock(AbstractBlock.Settings.copy(syncMaterial).mapColor(MapColor.BLACK)));
    public static final Block SYNC_MIZMER = registerBlockInBlockset(SYNC_BLOCKS, "sync_mizmer", new LitGlazedTerracottaBlock(AbstractBlock.Settings.copy(syncMaterial)));
    public static final Block SYNC_MESS = registerBlockInBlockset(SYNC_BLOCKS, "sync_mess", new LitBlock(AbstractBlock.Settings.copy(syncMaterial)));
    public static final Block SYNC_LEADED = registerBlockInBlockset(SYNC_BLOCKS, "sync_leaded", new LitBlock(AbstractBlock.Settings.copy(syncMaterial).mapColor(MapColor.BLACK)));
    public static final Block SYNC_JUNCTION = registerBlockInBlockset(SYNC_BLOCKS, "sync_junction", new LitBlock(AbstractBlock.Settings.copy(syncMaterial)));
    public static final Block SYNC_HEX = registerBlockInBlockset(SYNC_BLOCKS, "sync_hex", new LitPillarBlock(AbstractBlock.Settings.copy(syncMaterial)));
    public static final Block SYNC_HAZARD = registerBlockInBlockset(SYNC_BLOCKS, "sync_hazard", new LitBlock(AbstractBlock.Settings.copy(syncMaterial)));
    public static final Block SYNC_HATCH = registerBlockInBlockset(SYNC_BLOCKS, "sync_hatch", new LitBlock(AbstractBlock.Settings.copy(syncMaterial)));
    public static final Block SYNC_FRAMED = registerBlockInBlockset(SYNC_BLOCKS, "sync_framed", new LitBlock(AbstractBlock.Settings.copy(syncMaterial)));
    public static final Block SYNC_FORCE = registerBlockInBlockset(SYNC_BLOCKS, "sync_force", new LitBlock(AbstractBlock.Settings.copy(syncMaterial)));
    public static final Block SYNC_DATA = registerBlockInBlockset(SYNC_BLOCKS, "sync_data", new LitBlock(AbstractBlock.Settings.copy(syncMaterial)));
    public static final Block SYNC_CONTAIN = registerBlockInBlockset(SYNC_BLOCKS, "sync_contain", new LitBlock(AbstractBlock.Settings.copy(syncMaterial)));
    public static final Block SYNC_CAUTION = registerBlockInBlockset(SYNC_BLOCKS, "sync_caution", new LitPillarBlock(AbstractBlock.Settings.copy(syncMaterial)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - NURR">
    private static final AbstractBlock nurrMaterial = new Block(AbstractBlock.Settings.create()
            .requiresTool()
            .strength(1.2f)
            .luminance(state -> 11)
            .sounds(ModBlockSoundGroup.NURR));
    public static final Block NURR = registerBlockInBlockset(NURR_BLOCKS, "nurr", new PillarBlock(AbstractBlock.Settings.copy(nurrMaterial).mapColor(MapColor.GRAY)));
    public static final Block BLACK_NURR = registerBlockInBlockset(NURR_BLOCKS, "black_nurr", new PillarBlock(AbstractBlock.Settings.copy(nurrMaterial).mapColor(MapColor.BLACK).luminance(state -> 0)));
    public static final Block RED_NURR = registerBlockInBlockset(NURR_BLOCKS, "red_nurr", new PillarBlock(AbstractBlock.Settings.copy(nurrMaterial).mapColor(MapColor.RED)));
    public static final Block ORANGE_NURR = registerBlockInBlockset(NURR_BLOCKS, "orange_nurr", new PillarBlock(AbstractBlock.Settings.copy(nurrMaterial).mapColor(MapColor.ORANGE)));
    public static final Block AMBER_NURR = registerBlockInBlockset(NURR_BLOCKS, "amber_nurr", new PillarBlock(AbstractBlock.Settings.copy(nurrMaterial).mapColor(MapColor.TERRACOTTA_YELLOW)));
    public static final Block YELLOW_NURR = registerBlockInBlockset(NURR_BLOCKS, "yellow_nurr", new PillarBlock(AbstractBlock.Settings.copy(nurrMaterial).mapColor(MapColor.YELLOW)));
    public static final Block LIME_NURR = registerBlockInBlockset(NURR_BLOCKS, "lime_nurr", new PillarBlock(AbstractBlock.Settings.copy(nurrMaterial).mapColor(MapColor.LIME)));
    public static final Block GREEN_NURR = registerBlockInBlockset(NURR_BLOCKS, "green_nurr", new PillarBlock(AbstractBlock.Settings.copy(nurrMaterial).mapColor(MapColor.EMERALD_GREEN)));
    public static final Block MINT_NURR = registerBlockInBlockset(NURR_BLOCKS, "mint_nurr", new PillarBlock(AbstractBlock.Settings.copy(nurrMaterial).mapColor(MapColor.BRIGHT_TEAL)));
    public static final Block CYAN_NURR = registerBlockInBlockset(NURR_BLOCKS, "cyan_nurr", new PillarBlock(AbstractBlock.Settings.copy(nurrMaterial).mapColor(MapColor.DIAMOND_BLUE)));
    public static final Block CERULEAN_NURR = registerBlockInBlockset(NURR_BLOCKS, "cerulean_nurr", new PillarBlock(AbstractBlock.Settings.copy(nurrMaterial).mapColor(MapColor.LIGHT_BLUE)));
    public static final Block BLUE_NURR = registerBlockInBlockset(NURR_BLOCKS, "blue_nurr", new PillarBlock(AbstractBlock.Settings.copy(nurrMaterial).mapColor(MapColor.BLUE)));
    public static final Block NAVY_NURR = registerBlockInBlockset(NURR_BLOCKS, "navy_nurr", new PillarBlock(AbstractBlock.Settings.copy(nurrMaterial).mapColor(MapColor.TERRACOTTA_BLUE)));
    public static final Block PURPLE_NURR = registerBlockInBlockset(NURR_BLOCKS, "purple_nurr", new PillarBlock(AbstractBlock.Settings.copy(nurrMaterial).mapColor(MapColor.PURPLE)));
    public static final Block MAGENTA_NURR = registerBlockInBlockset(NURR_BLOCKS, "magenta_nurr", new PillarBlock(AbstractBlock.Settings.copy(nurrMaterial).mapColor(MapColor.MAGENTA)));
    public static final Block FUCHSIA_NURR = registerBlockInBlockset(NURR_BLOCKS, "fuchsia_nurr", new PillarBlock(AbstractBlock.Settings.copy(nurrMaterial).mapColor(MapColor.TERRACOTTA_MAGENTA)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - TYEL">
    private static final AbstractBlock tyelMaterial = new Block(AbstractBlock.Settings.create()
            .requiresTool()
            .strength(1.4f)
            .sounds(ModBlockSoundGroup.TYEL));
    public static final Block TYEL = registerBlockInBlockset(TYEL_BLOCKS, "tyel", new Block(AbstractBlock.Settings.copy(tyelMaterial).mapColor(MapColor.WHITE_GRAY)));
    public static final Block BLACK_TYEL = registerBlockInBlockset(TYEL_BLOCKS, "black_tyel", new Block(AbstractBlock.Settings.copy(tyelMaterial).mapColor(MapColor.BLACK)));
    public static final Block TAN_TYEL = registerBlockInBlockset(TYEL_BLOCKS, "tan_tyel", new Block(AbstractBlock.Settings.copy(tyelMaterial).mapColor(MapColor.RAW_IRON_PINK)));
    public static final Block RED_TYEL = registerBlockInBlockset(TYEL_BLOCKS, "red_tyel", new Block(AbstractBlock.Settings.copy(tyelMaterial).mapColor(MapColor.RED)));
    public static final Block VERMILION_TYEL = registerBlockInBlockset(TYEL_BLOCKS, "vermilion_tyel", new Block(AbstractBlock.Settings.copy(tyelMaterial).mapColor(MapColor.TERRACOTTA_ORANGE)));
    public static final Block AMBER_TYEL = registerBlockInBlockset(TYEL_BLOCKS, "amber_tyel", new Block(AbstractBlock.Settings.copy(tyelMaterial).mapColor(MapColor.TERRACOTTA_YELLOW)));
    public static final Block YELLOW_TYEL = registerBlockInBlockset(TYEL_BLOCKS, "yellow_tyel", new Block(AbstractBlock.Settings.copy(tyelMaterial).mapColor(MapColor.YELLOW)));
    public static final Block CHARTREUSE_TYEL = registerBlockInBlockset(TYEL_BLOCKS, "chartreuse_tyel", new Block(AbstractBlock.Settings.copy(tyelMaterial).mapColor(MapColor.LIME)));
    public static final Block LIME_TYEL = registerBlockInBlockset(TYEL_BLOCKS, "lime_tyel", new Block(AbstractBlock.Settings.copy(tyelMaterial).mapColor(MapColor.LIME)));
    public static final Block GREEN_TYEL = registerBlockInBlockset(TYEL_BLOCKS, "green_tyel", new Block(AbstractBlock.Settings.copy(tyelMaterial).mapColor(MapColor.GREEN)));
    public static final Block CYAN_TYEL = registerBlockInBlockset(TYEL_BLOCKS, "cyan_tyel", new Block(AbstractBlock.Settings.copy(tyelMaterial).mapColor(MapColor.DIAMOND_BLUE)));
    public static final Block CERULEAN_TYEL = registerBlockInBlockset(TYEL_BLOCKS, "cerulean_tyel", new Block(AbstractBlock.Settings.copy(tyelMaterial).mapColor(MapColor.LIGHT_BLUE)));
    public static final Block BLUE_TYEL = registerBlockInBlockset(TYEL_BLOCKS, "blue_tyel", new Block(AbstractBlock.Settings.copy(tyelMaterial).mapColor(MapColor.BLUE)));
    public static final Block PURPLE_TYEL = registerBlockInBlockset(TYEL_BLOCKS, "purple_tyel", new Block(AbstractBlock.Settings.copy(tyelMaterial).mapColor(MapColor.PURPLE)));
    public static final Block MAGENTA_TYEL = registerBlockInBlockset(TYEL_BLOCKS, "magenta_tyel", new Block(AbstractBlock.Settings.copy(tyelMaterial).mapColor(MapColor.MAGENTA)));
    public static final Block FUCHSIA_TYEL = registerBlockInBlockset(TYEL_BLOCKS, "fuchsia_tyel", new Block(AbstractBlock.Settings.copy(tyelMaterial).mapColor(MapColor.DULL_PINK)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - ROEN">
    private static final AbstractBlock roenMaterial = new Block(AbstractBlock.Settings.create()
            .mapColor(MapColor.LICHEN_GREEN)
            .strength(0.6f)
            .sounds(ModBlockSoundGroup.ROEN));
    public static final Block ROEN = registerBlockInBlockset(ROEN_BLOCKS, "roen", new Block(AbstractBlock.Settings.copy(roenMaterial).mapColor(MapColor.LIME)));
    public static final Block ROEN_DESSICATE = registerBlockInBlockset(ROEN_BLOCKS, "roen_dessicate", new Block(AbstractBlock.Settings.copy(roenMaterial).mapColor(MapColor.RAW_IRON_PINK)));
    public static final Block ROEN_LESION = registerBlockInBlockset(ROEN_BLOCKS, "roen_lesion", new PillarBlock(AbstractBlock.Settings.copy(roenMaterial).mapColor(MapColor.RED)));
    public static final Block ROEN_TRACT = registerBlockInBlockset(ROEN_BLOCKS, "roen_tract", new PillarBlock(AbstractBlock.Settings.copy(roenMaterial).mapColor(MapColor.PURPLE)));
    public static final Block ROEN_AGAR = registerBlockInBlockset(ROEN_BLOCKS, "roen_agar", new Block(AbstractBlock.Settings.copy(roenMaterial).mapColor(MapColor.MAGENTA)));
    public static final Block ROEN_KINESIN = registerBlockInBlockset(ROEN_BLOCKS, "roen_kinesin", new GlazedTerracottaBlock(AbstractBlock.Settings.copy(roenMaterial).mapColor(MapColor.GREEN)));
    public static final Block ROEN_GEL = registerBlockInBlockset(ROEN_BLOCKS, "roen_gel", new Block(AbstractBlock.Settings.copy(roenMaterial).mapColor(MapColor.DULL_PINK)));
    public static final Block ROEN_STRAND = registerBlockInBlockset(ROEN_BLOCKS, "roen_strand", new Block(AbstractBlock.Settings.copy(roenMaterial).mapColor(MapColor.DIAMOND_BLUE)));
    public static final Block ROEN_MEMB = registerBlockInBlockset(ROEN_BLOCKS, "roen_memb", new Block(AbstractBlock.Settings.copy(roenMaterial).mapColor(MapColor.LIME)));
    public static final Block ROEN_FILM = registerBlockInBlockset(ROEN_BLOCKS, "roen_film", new Block(AbstractBlock.Settings.copy(roenMaterial).mapColor(MapColor.LIGHT_BLUE)));
    public static final Block ROEN_ARRAY = registerBlockInBlockset(ROEN_BLOCKS, "roen_array", new Block(AbstractBlock.Settings.copy(roenMaterial).mapColor(MapColor.BLUE)));
    public static final Block ROEN_BACILLUS = registerBlockInBlockset(ROEN_BLOCKS, "roen_bacillus", new PillarBlock(AbstractBlock.Settings.copy(roenMaterial).mapColor(MapColor.TERRACOTTA_YELLOW)));
    public static final Block ROEN_ASSAY = registerBlockInBlockset(ROEN_BLOCKS, "roen_assay", new Block(AbstractBlock.Settings.copy(roenMaterial).mapColor(MapColor.YELLOW)));
    public static final Block ROEN_OPERON = registerBlockInBlockset(ROEN_BLOCKS, "roen_operon", new PillarBlock(AbstractBlock.Settings.copy(roenMaterial).mapColor(MapColor.TERRACOTTA_ORANGE)));
    public static final Block ROEN_ONCOGENE = registerBlockInBlockset(ROEN_BLOCKS, "roen_oncogene", new Block(AbstractBlock.Settings.copy(roenMaterial).mapColor(MapColor.BLACK)));
    public static final Block ROEN_GROUT = registerBlockInBlockset(ROEN_BLOCKS, "roen_grout", new Block(AbstractBlock.Settings.copy(roenMaterial).mapColor(MapColor.WHITE_GRAY)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - SOL">
    private static final AbstractBlock solMaterial = new Block(AbstractBlock.Settings.create()
            .mapColor(MapColor.TERRACOTTA_YELLOW)
            .strength(0.3f)
            .luminance(createLightLevelFromProperty(15, Properties.LIT))
            .mapColor(state -> state.get(Properties.LIT) ? MapColor.OFF_WHITE : MapColor.TERRACOTTA_YELLOW)
            .sounds(ModBlockSoundGroup.SOL));
    private static final AbstractBlock solMaterialDim = new Block(AbstractBlock.Settings.create()
            .mapColor(MapColor.TERRACOTTA_YELLOW)
            .strength(0.3f)
            .luminance(createLightLevelFromProperty(11, Properties.LIT))
            .mapColor(state -> state.get(Properties.LIT) ? MapColor.YELLOW : MapColor.TERRACOTTA_ORANGE)
            .sounds(ModBlockSoundGroup.SOL));
    public static final Block SOL = registerBlockInBlockset(SOL_BLOCKS, "sol", new LitBlock(AbstractBlock.Settings.copy(solMaterial)));
    public static final Block SOL_PHOTO = registerBlockInBlockset(SOL_BLOCKS, "sol_photo", new LitBlock(AbstractBlock.Settings.copy(solMaterial)));
    public static final Block SOL_ELECTRON = registerBlockInBlockset(SOL_BLOCKS, "sol_electron", new LitBlock(AbstractBlock.Settings.copy(solMaterial)));
    public static final Block SOL_MAX = registerBlockInBlockset(SOL_BLOCKS, "sol_max", new LitBlock(AbstractBlock.Settings.copy(solMaterial)));
    public static final Block SOL_MIN = registerBlockInBlockset(SOL_BLOCKS, "sol_min", new LitBlock(AbstractBlock.Settings.copy(solMaterialDim)));
    public static final Block SOL_CHROMA = registerBlockInBlockset(SOL_BLOCKS, "sol_chroma", new LitBlock(AbstractBlock.Settings.copy(solMaterialDim)));
    public static final Block SOL_FLARE = registerBlockInBlockset(SOL_BLOCKS, "sol_flare", new LitBlock(AbstractBlock.Settings.copy(solMaterialDim)));
    public static final Block SOL_BLIND = registerBlockInBlockset(SOL_BLOCKS, "sol_blind", new LitBlock(AbstractBlock.Settings.copy(solMaterialDim)));
    public static final Block SOL_PROTON = registerBlockInBlockset(SOL_BLOCKS, "sol_proton", new LitBlock(AbstractBlock.Settings.copy(solMaterialDim)));
    public static final Block SOL_BALANCE = registerBlockInBlockset(SOL_BLOCKS, "sol_balance", new LitBlock(AbstractBlock.Settings.copy(solMaterialDim)));
    public static final Block SOL_GLARE = registerBlockInBlockset(SOL_BLOCKS, "sol_glare", new LitBlock(AbstractBlock.Settings.copy(solMaterial)));
    public static final Block SOL_SPECTRA = registerBlockInBlockset(SOL_BLOCKS, "sol_spectra", new LitPillarBlock(AbstractBlock.Settings.copy(solMaterialDim)));
    public static final Block SOL_BLAZAR = registerBlockInBlockset(SOL_BLOCKS, "sol_blazar", new LitGlazedTerracottaBlock(AbstractBlock.Settings.copy(solMaterialDim)));
    public static final Block SOL_FIELD = registerBlockInBlockset(SOL_BLOCKS, "sol_field", new LitBlock(AbstractBlock.Settings.copy(solMaterialDim)));
    public static final Block SOL_NUCLEI = registerBlockInBlockset(SOL_BLOCKS, "sol_nuclei", new LitBlock(AbstractBlock.Settings.copy(solMaterial)));
    public static final Block SOL_CORONA = registerBlockInBlockset(SOL_BLOCKS, "sol_corona", new LitBlock(AbstractBlock.Settings.copy(solMaterial)));
    //</editor-fold>

    //<editor-fold desc ="Blocks - BITT">
    private static final AbstractBlock bittMaterial = new Block(AbstractBlock.Settings.create()
            .mapColor(MapColor.TERRACOTTA_GRAY)
            .strength(0.6f)
//          .luminance(state -> 5)
            .sounds(ModBlockSoundGroup.BITT));
    public static final Block BITT = registerBlockInBlockset(BITT_BLOCKS, "bitt", new BittBlock(AbstractBlock.Settings.copy(bittMaterial)));
    public static final Block SHELL_BITT = registerBlockInBlockset(BITT_BLOCKS, "shell_bitt", new BittBlock(AbstractBlock.Settings.copy(bittMaterial)));
    public static final Block RED_BITT = registerBlockInBlockset(BITT_BLOCKS, "red_bitt", new BittBlock(AbstractBlock.Settings.copy(bittMaterial)));
    public static final Block ORANGE_BITT = registerBlockInBlockset(BITT_BLOCKS, "orange_bitt", new BittBlock(AbstractBlock.Settings.copy(bittMaterial)));
    public static final Block AMBER_BITT = registerBlockInBlockset(BITT_BLOCKS, "amber_bitt", new BittBlock(AbstractBlock.Settings.copy(bittMaterial)));
    public static final Block YELLOW_BITT = registerBlockInBlockset(BITT_BLOCKS, "yellow_bitt", new BittBlock(AbstractBlock.Settings.copy(bittMaterial)));
    public static final Block LIME_BITT = registerBlockInBlockset(BITT_BLOCKS, "lime_bitt", new BittBlock(AbstractBlock.Settings.copy(bittMaterial)));
    public static final Block GREEN_BITT = registerBlockInBlockset(BITT_BLOCKS, "green_bitt", new BittBlock(AbstractBlock.Settings.copy(bittMaterial)));
    public static final Block MINT_BITT = registerBlockInBlockset(BITT_BLOCKS, "mint_bitt", new BittBlock(AbstractBlock.Settings.copy(bittMaterial)));
    public static final Block CYAN_BITT = registerBlockInBlockset(BITT_BLOCKS, "cyan_bitt", new BittBlock(AbstractBlock.Settings.copy(bittMaterial)));
    public static final Block LIGHT_BLUE_BITT = registerBlockInBlockset(BITT_BLOCKS, "light_blue_bitt", new BittBlock(AbstractBlock.Settings.copy(bittMaterial)));
    public static final Block BLUE_BITT = registerBlockInBlockset(BITT_BLOCKS, "blue_bitt", new BittBlock(AbstractBlock.Settings.copy(bittMaterial)));
    public static final Block INDIGO_BITT = registerBlockInBlockset(BITT_BLOCKS, "indigo_bitt", new BittBlock(AbstractBlock.Settings.copy(bittMaterial)));
    public static final Block PURPLE_BITT = registerBlockInBlockset(BITT_BLOCKS, "purple_bitt", new BittBlock(AbstractBlock.Settings.copy(bittMaterial)));
    public static final Block MAGENTA_BITT = registerBlockInBlockset(BITT_BLOCKS, "magenta_bitt", new BittBlock(AbstractBlock.Settings.copy(bittMaterial)));
    public static final Block FUCHSIA_BITT = registerBlockInBlockset(BITT_BLOCKS, "fuchsia_bitt", new BittBlock(AbstractBlock.Settings.copy(bittMaterial)));
    //</editor-fold>
    //</editor-fold>
    //<editor-fold desc ="Blocks - ROST">
    private static final AbstractBlock rostMaterial = new Block(AbstractBlock.Settings.create()
            .mapColor(MapColor.OAK_TAN)
            .requiresTool()
            .strength(2.4f, 2.0f)
            .sounds(ModBlockSoundGroup.ROST));

    private static final AbstractBlock rostRustMaterial = new Block(AbstractBlock.Settings.create()
            .mapColor(MapColor.DULL_RED)
            .requiresTool()
            .strength(2.4f, 2.0f)
            .sounds(ModBlockSoundGroup.ROST_RUST));
    //TODO: refactor rusting system in order to implement scraping with crow's beak
    public static final Block ROST_RUST = registerBlockInBlockset(ROST_BLOCKS_RUST, "rost_rust", new Block(AbstractBlock.Settings.copy(rostRustMaterial)));
    public static final Block ROST_WALLPAPER_RUST = registerBlockInBlockset(ROST_BLOCKS_RUST, "rost_wallpaper_rust", new Block(AbstractBlock.Settings.copy(rostRustMaterial)));
    public static final Block ROST_VELLUM_RUST = registerBlockInBlockset(ROST_BLOCKS_RUST, "rost_vellum_rust", new Block(AbstractBlock.Settings.copy(rostRustMaterial)));
    public static final Block ROST_VEIN_RUST = registerBlockInBlockset(ROST_BLOCKS_RUST, "rost_vein_rust", new GlazedTerracottaBlock(AbstractBlock.Settings.copy(rostRustMaterial)));
    public static final Block ROST_TUNNEL_RUST = registerBlockInBlockset(ROST_BLOCKS_RUST, "rost_tunnel_rust", new PillarBlock(AbstractBlock.Settings.copy(rostRustMaterial)));
    public static final Block ROST_RIBBING_RUST = registerBlockInBlockset(ROST_BLOCKS_RUST, "rost_ribbing_rust", new Block(AbstractBlock.Settings.copy(rostRustMaterial)));
    public static final Block ROST_SHIELDED_RUST = registerBlockInBlockset(ROST_BLOCKS_RUST, "rost_shielded_rust", new Block(AbstractBlock.Settings.copy(rostRustMaterial)));
    public static final Block ROST_SMOTHERED_RUST = registerBlockInBlockset(ROST_BLOCKS_RUST, "rost_smothered_rust", new Block(AbstractBlock.Settings.copy(rostRustMaterial)));
    public static final Block ROST_REBAR_RUST = registerBlockInBlockset(ROST_BLOCKS_RUST, "rost_rebar_rust", new PillarBlock(AbstractBlock.Settings.copy(rostRustMaterial)));
    public static final Block ROST_PLATES_RUST = registerBlockInBlockset(ROST_BLOCKS_RUST, "rost_plates_rust", new Block(AbstractBlock.Settings.copy(rostRustMaterial)));
    public static final Block ROST_PEEL_RUST = registerBlockInBlockset(ROST_BLOCKS_RUST, "rost_peel_rust", new Block(AbstractBlock.Settings.copy(rostRustMaterial)));
    public static final Block ROST_MOUND_RUST = registerBlockInBlockset(ROST_BLOCKS_RUST, "rost_mound_rust", new Block(AbstractBlock.Settings.copy(rostRustMaterial)));
    public static final Block ROST_LINOLEUM_RUST = registerBlockInBlockset(ROST_BLOCKS_RUST, "rost_linoleum_rust", new Block(AbstractBlock.Settings.copy(rostRustMaterial)));
    public static final Block ROST_CRETE_RUST = registerBlockInBlockset(ROST_BLOCKS_RUST, "rost_crete_rust", new Block(AbstractBlock.Settings.copy(rostRustMaterial)));
    public static final Block ROST_CORRIGOR_RUST = registerBlockInBlockset(ROST_BLOCKS_RUST, "rost_corrigor_rust", new Block(AbstractBlock.Settings.copy(rostRustMaterial)));
    public static final Block ROST_CAGE_RUST = registerBlockInBlockset(ROST_BLOCKS_RUST, "rost_cage_rust", new Block(AbstractBlock.Settings.copy(rostRustMaterial).nonOpaque().solidBlock(ModBlocks::never)));

    static {
        RENDER_LAYER_CUTOUT.add(ROST_CAGE_RUST);
    }

    public static final Block ROST = registerBlockInBlockset(ROST_BLOCKS, "rost", new RustingBlock(AbstractBlock.Settings.copy(rostMaterial), ROST_RUST.getDefaultState(), false));
    public static final Block ROST_WALLPAPER = registerBlockInBlockset(ROST_BLOCKS, "rost_wallpaper", new RustingBlock(AbstractBlock.Settings.copy(rostMaterial), ROST_WALLPAPER_RUST.getDefaultState(), false));
    public static final Block ROST_VELLUM = registerBlockInBlockset(ROST_BLOCKS, "rost_vellum", new RustingBlock(AbstractBlock.Settings.copy(rostMaterial), ROST_VELLUM_RUST.getDefaultState(), false));
    public static final Block ROST_VEIN = registerBlockInBlockset(ROST_BLOCKS, "rost_vein", new RustingGlazedTerracottaBlock(AbstractBlock.Settings.copy(rostMaterial), ROST_VEIN_RUST.getDefaultState(), false));
    public static final Block ROST_TUNNEL = registerBlockInBlockset(ROST_BLOCKS, "rost_tunnel", new RustingPillarBlock(AbstractBlock.Settings.copy(rostMaterial), ROST_TUNNEL_RUST.getDefaultState(), false));
    public static final Block ROST_RIBBING = registerBlockInBlockset(ROST_BLOCKS, "rost_ribbing", new RustingBlock(AbstractBlock.Settings.copy(rostMaterial), ROST_RIBBING_RUST.getDefaultState(), false));
    public static final Block ROST_SHIELDED = registerBlockInBlockset(ROST_BLOCKS, "rost_shielded", new RustingBlock(AbstractBlock.Settings.copy(rostMaterial), ROST_SHIELDED_RUST.getDefaultState(), false));
    public static final Block ROST_SMOTHERED = registerBlockInBlockset(ROST_BLOCKS, "rost_smothered", new RustingBlock(AbstractBlock.Settings.copy(rostMaterial), ROST_SMOTHERED_RUST.getDefaultState(), false));
    public static final Block ROST_REBAR = registerBlockInBlockset(ROST_BLOCKS, "rost_rebar", new RustingPillarBlock(AbstractBlock.Settings.copy(rostMaterial), ROST_REBAR_RUST.getDefaultState(), false));
    public static final Block ROST_PLATES = registerBlockInBlockset(ROST_BLOCKS, "rost_plates", new RustingBlock(AbstractBlock.Settings.copy(rostMaterial), ROST_PLATES_RUST.getDefaultState(), false));
    public static final Block ROST_PEEL = registerBlockInBlockset(ROST_BLOCKS, "rost_peel", new RustingBlock(AbstractBlock.Settings.copy(rostMaterial), ROST_PEEL_RUST.getDefaultState(), false));
    public static final Block ROST_MOUND = registerBlockInBlockset(ROST_BLOCKS, "rost_mound", new RustingBlock(AbstractBlock.Settings.copy(rostMaterial), ROST_MOUND_RUST.getDefaultState(), false));
    public static final Block ROST_LINOLEUM = registerBlockInBlockset(ROST_BLOCKS, "rost_linoleum", new RustingBlock(AbstractBlock.Settings.copy(rostMaterial), ROST_LINOLEUM_RUST.getDefaultState(), false));
    public static final Block ROST_CRETE = registerBlockInBlockset(ROST_BLOCKS, "rost_crete", new RustingBlock(AbstractBlock.Settings.copy(rostMaterial), ROST_CRETE_RUST.getDefaultState(), false));
    public static final Block ROST_CORRIGOR = registerBlockInBlockset(ROST_BLOCKS, "rost_corrigor", new RustingBlock(AbstractBlock.Settings.copy(rostMaterial), ROST_CORRIGOR_RUST.getDefaultState(), false));
    public static final Block ROST_CAGE = registerBlockInBlockset(ROST_BLOCKS, "rost_cage", new RustingBlock(AbstractBlock.Settings.copy(rostMaterial).nonOpaque().solidBlock(ModBlocks::never), ROST_CAGE_RUST.getDefaultState(), false));

    static {
        RENDER_LAYER_CUTOUT.add(ROST_CAGE);
    }

    //</editor-fold>
    //<editor-fold desc ="Blocks - VECT">
    private static final AbstractBlock plexMaterial = new Block(AbstractBlock.Settings.create()
            .mapColor(MapColor.LIME)
            .strength(0.3f)
            .sounds(ModBlockSoundGroup.PLEX));
    public static final Block PLEX = registerBlockInBlockset(PLEX_BLOCKS, "plex", new Block(AbstractBlock.Settings.copy(plexMaterial)));
    public static final Block PLEX_PLAID = registerBlockInBlockset(PLEX_BLOCKS, "plex_plaid", new Block(AbstractBlock.Settings.copy(plexMaterial).mapColor(MapColor.DIAMOND_BLUE)));
    public static final Block PLEX_PUFF = registerBlockInBlockset(PLEX_BLOCKS, "plex_puff", new Block(AbstractBlock.Settings.copy(plexMaterial).mapColor(MapColor.LIGHT_BLUE)));
    public static final Block PLEX_STUDDED = registerBlockInBlockset(PLEX_BLOCKS, "plex_studded", new Block(AbstractBlock.Settings.copy(plexMaterial).sounds(ModBlockSoundGroup.PLEX_STUDDED)));
    public static final Block PLEX_ROLL = registerBlockInBlockset(PLEX_BLOCKS, "plex_roll", new PillarBlock(AbstractBlock.Settings.copy(plexMaterial).mapColor(MapColor.BRIGHT_RED)));
    public static final Block PLEX_PRINT = registerBlockInBlockset(PLEX_BLOCKS, "plex_print", new GlazedTerracottaBlock(AbstractBlock.Settings.copy(plexMaterial)));
    //</editor-fold>
    //<editor-fold desc ="Blocks - SOUNDSCAPE">
    public static final Block SOUNDSCAPE_LAIR = registerBlockInBlockset(SOUNDSCAPE_BLOCKS, "soundscape_lair", new LoopingSoundscapeBlock(AbstractBlock.Settings.copy(lairMaterial).mapColor(MapColor.DARK_CRIMSON), ModSoundEvents.BLOCK_LAIR_AMBIENT, 20));
    public static final Block SOUNDSCAPE_LAVE = registerBlockInBlockset(SOUNDSCAPE_BLOCKS, "soundscape_lave", new SoundscapeBlock(AbstractBlock.Settings.copy(laveMaterial).sounds(ModBlockSoundGroup.LAVE), null, null, ModSoundEvents.BLOCK_LAVE_AMBIENT, false, 80));
    public static final Block SOUNDSCAPE_KORP = registerBlockInBlockset(SOUNDSCAPE_BLOCKS, "soundscape_korp", new SoundscapeBlock(AbstractBlock.Settings.copy(korpMaterial).luminance(createLightLevelFromProperty(11, Properties.LIT)).mapColor(MapColor.DIAMOND_BLUE).sounds(ModBlockSoundGroup.KORP_NODE), null, null, ModSoundEvents.BLOCK_KORP_AMBIENT, false, 80));
    public static final Block SOUNDSCAPE_TANK = registerBlockInBlockset(SOUNDSCAPE_BLOCKS, "soundscape_tank", new SoundscapeBlock(AbstractBlock.Settings.copy(tankMaterial), null, null, ModSoundEvents.BLOCK_SYNC_AMBIENT, false, 20));
    public static final Block SOUNDSCAPE_EXRI = registerBlockInBlockset(SOUNDSCAPE_BLOCKS, "soundscape_exri", new LoopingSoundscapeBlock(AbstractBlock.Settings.copy(exriMaterial), ModSoundEvents.BLOCK_EXRI_AMBIENT, 105));
    public static final Block SOUNDSCAPE_SYNC = registerBlockInBlockset(SOUNDSCAPE_BLOCKS, "soundscape_sync", new SoundscapeBlock(AbstractBlock.Settings.copy(syncMaterial), null, null, ModSoundEvents.BLOCK_SYNC_AMBIENT, false, 20));
    public static final Block SOUNDSCAPE_SOL = registerBlockInBlockset(SOUNDSCAPE_BLOCKS, "soundscape_sol", new SoundscapeBlock(AbstractBlock.Settings.copy(solMaterialDim), null, null, ModSoundEvents.BLOCK_SOL_AMBIENT, false, 80));
    //</editor-fold>
    //<editor-fold desc ="Blocks - Other">
    public static final Block ZTONE = registerBlock("ztone", new Block(AbstractBlock.Settings.copy(Blocks.BLACKSTONE)
            .mapColor(MapColor.LIGHT_GRAY)
            .sounds(ModBlockSoundGroup.ZTONE)
    ));
    public static final Block AURORA = registerBlock("aurora", new AuroraBlock(AbstractBlock.Settings.create()
            .mapColor(MapColor.TERRACOTTA_CYAN)
            .breakInstantly()
            .sounds(BlockSoundGroup.SNOW)
            .luminance(createLightLevelFromProperty(11, Properties.LIT))
    ));
    public static final Block RAW_LUESIUM_BLOCK = registerBlock("raw_luesium_block", new Block(AbstractBlock.Settings.copy(Blocks.RAW_IRON_BLOCK).mapColor(MapColor.PALE_PURPLE).sounds(ModBlockSoundGroup.LUESIUM_ORE)));
    public static final Block LUESIUM_BLOCK = registerBlock("luesium_block", new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).mapColor(MapColor.PALE_PURPLE).sounds(ModBlockSoundGroup.LUESIUM)));
    public static final Block LUESIUM_ORE = registerBlock("luesium_ore", new ExperienceDroppingBlock(UniformIntProvider.create(0, 0), AbstractBlock.Settings.copy(Blocks.IRON_ORE).sounds(ModBlockSoundGroup.LUESIUM_ORE)));
    public static final Block DEEPSLATE_LUESIUM_ORE = registerBlock("deepslate_luesium_ore", new ExperienceDroppingBlock(UniformIntProvider.create(0, 0), AbstractBlock.Settings.copy(Blocks.DEEPSLATE_IRON_ORE).sounds(ModBlockSoundGroup.DEEPSLATE_LUESIUM_ORE)));
    public static final Block ENDSTONE_LUESIUM_ORE = registerBlock("endstone_luesium_ore", new ExperienceDroppingBlock(UniformIntProvider.create(0, 1), AbstractBlock.Settings.copy(Blocks.END_STONE).strength(3.5f, 9.0f).sounds(ModBlockSoundGroup.LUESIUM_ORE)));
    public static final Block ANTIBRASS_BLOCK = registerBlock("antibrass_block", new Block(AbstractBlock.Settings.copy(Blocks.COPPER_BLOCK).mapColor(MapColor.TERRACOTTA_PINK).sounds(ModBlockSoundGroup.ANTIBRASS)));
    public static final Block TONE = registerBlock("tone", new Block(AbstractBlock.Settings.copy(Blocks.ANDESITE).mapColor(MapColor.TERRACOTTA_GRAY).sounds(ModBlockSoundGroup.TONE)));
    public static final Block TONE_BRICKS = registerBlock("tone_bricks", new Block(AbstractBlock.Settings.copy(Blocks.ANDESITE).mapColor(MapColor.TERRACOTTA_GRAY).sounds(ModBlockSoundGroup.TONE_BRICKS)));
    public static final Block POLISHED_TONE = registerBlock("polished_tone", new Block(AbstractBlock.Settings.copy(Blocks.ANDESITE).mapColor(MapColor.TERRACOTTA_GRAY).sounds(ModBlockSoundGroup.TONE)));
    public static final Block ABSTRACT_TONE = registerBlock("abstract_tone", new Block(AbstractBlock.Settings.copy(Blocks.ANDESITE).mapColor(MapColor.TERRACOTTA_GRAY).sounds(ModBlockSoundGroup.TONE)));
    public static final Block FRAMED_TONE = registerBlock("framed_tone", new Block(AbstractBlock.Settings.copy(Blocks.ANDESITE).mapColor(MapColor.TERRACOTTA_GRAY).sounds(ModBlockSoundGroup.TONE)));
    public static final Block FRAMED_TONE_BRICKS = registerBlock("framed_tone_bricks", new Block(AbstractBlock.Settings.copy(Blocks.ANDESITE).mapColor(MapColor.TERRACOTTA_GRAY).sounds(ModBlockSoundGroup.TONE_BRICKS)));
    public static final Block ZKUL = registerBlock("zkul", new ZkulBlock(AbstractBlock.Settings.copy(Blocks.REINFORCED_DEEPSLATE).mapColor(MapColor.BLACK).sounds(ModBlockSoundGroup.ZKUL).luminance(state -> 3).emissiveLighting(ModBlocks::always)));

    //CRT block entity and screen display
    public static final Block CRT = registerBlockInBlockset(CRT_BLOCKS, "crt", new CRTBlock(AbstractBlock.Settings.create().strength(1.2f).sounds(ModBlockSoundGroup.CRT).emissiveLighting((state, world, pos) -> state.get(Properties.LIT)).luminance(createLightLevelFromProperty(3, Properties.LIT)).strength(1.0f).mapColor(DyeColor.WHITE)));
    public static final Block AGED_CRT = registerBlockInBlockset(CRT_BLOCKS, "aged_crt", new CRTBlock(AbstractBlock.Settings.copy(CRT).mapColor(DyeColor.YELLOW)));
    public static final Block BLACK_CRT = registerBlockInBlockset(CRT_BLOCKS, "black_crt", new CRTBlock(AbstractBlock.Settings.copy(CRT).mapColor(DyeColor.BLACK)));
    public static final Block GRAY_CRT = registerBlockInBlockset(CRT_BLOCKS, "gray_crt", new CRTBlock(AbstractBlock.Settings.copy(CRT).mapColor(DyeColor.GRAY)));
    public static final Block PC = registerBlockInBlockset(PC_BLOCKS, "pc", new PCBlock(AbstractBlock.Settings.create().mapColor(MapColor.CLEAR).strength(0.1f).sounds(ModBlockSoundGroup.APPLIANCE).nonOpaque().blockVision(ModBlocks::never).allowsSpawning(ModBlocks::never).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block AGED_PC = registerBlockInBlockset(PC_BLOCKS, "aged_pc", new PCBlock(AbstractBlock.Settings.copy(PC).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block BLACK_PC = registerBlockInBlockset(PC_BLOCKS, "black_pc", new PCBlock(AbstractBlock.Settings.copy(PC).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block GRAY_PC = registerBlockInBlockset(PC_BLOCKS, "gray_pc", new PCBlock(AbstractBlock.Settings.copy(PC).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block KEYBOARD = registerBlockInBlockset(KEYBOARD_BLOCKS, "keyboard", new KeyboardBlock(AbstractBlock.Settings.create().mapColor(MapColor.CLEAR).strength(0.1f).sounds(ModBlockSoundGroup.APPLIANCE).nonOpaque().blockVision(ModBlocks::never).allowsSpawning(ModBlocks::never).pistonBehavior(PistonBehavior.DESTROY), ModSoundEvents.BLOCK_KEYBOARD_CLICK, 20));
    public static final Block AGED_KEYBOARD = registerBlockInBlockset(KEYBOARD_BLOCKS, "aged_keyboard", new KeyboardBlock(AbstractBlock.Settings.copy(KEYBOARD).pistonBehavior(PistonBehavior.DESTROY), ModSoundEvents.BLOCK_KEYBOARD_CLICK_AGED, 40));
    public static final Block BLACK_KEYBOARD = registerBlockInBlockset(KEYBOARD_BLOCKS, "black_keyboard", new KeyboardBlock(AbstractBlock.Settings.copy(KEYBOARD).pistonBehavior(PistonBehavior.DESTROY), ModSoundEvents.BLOCK_KEYBOARD_CLICK, 20));
    public static final Block GRAY_KEYBOARD = registerBlockInBlockset(KEYBOARD_BLOCKS, "gray_keyboard", new KeyboardBlock(AbstractBlock.Settings.copy(KEYBOARD).pistonBehavior(PistonBehavior.DESTROY), ModSoundEvents.BLOCK_KEYBOARD_CLICK, 20));
    public static final Block MOUSE = registerBlockInBlockset(MOUSE_BLOCKS, "mouse", new MouseBlock(AbstractBlock.Settings.create().mapColor(MapColor.CLEAR).strength(0.1f).sounds(ModBlockSoundGroup.APPLIANCE).nonOpaque().blockVision(ModBlocks::never).allowsSpawning(ModBlocks::never).pistonBehavior(PistonBehavior.DESTROY), ModSoundEvents.BLOCK_MOUSE_CLICK, 5));
    public static final Block AGED_MOUSE = registerBlockInBlockset(MOUSE_BLOCKS, "aged_mouse", new MouseBlock(AbstractBlock.Settings.copy(MOUSE).pistonBehavior(PistonBehavior.DESTROY), ModSoundEvents.BLOCK_MOUSE_CLICK_AGED, 10));
    public static final Block BLACK_MOUSE = registerBlockInBlockset(MOUSE_BLOCKS, "black_mouse", new MouseBlock(AbstractBlock.Settings.copy(MOUSE).pistonBehavior(PistonBehavior.DESTROY), ModSoundEvents.BLOCK_MOUSE_CLICK, 5));
    public static final Block GRAY_MOUSE = registerBlockInBlockset(MOUSE_BLOCKS, "gray_mouse", new MouseBlock(AbstractBlock.Settings.copy(MOUSE).pistonBehavior(PistonBehavior.DESTROY), ModSoundEvents.BLOCK_MOUSE_CLICK, 5));
    public static final Block SWITCH = registerBlockInBlockset(SWITCH_BLOCKS, "switch", new SwitchBlock(AbstractBlock.Settings.create().mapColor(MapColor.CLEAR).strength(0.1f).sounds(ModBlockSoundGroup.APPLIANCE).nonOpaque().blockVision(ModBlocks::never).allowsSpawning(ModBlocks::never).pistonBehavior(PistonBehavior.DESTROY), ModSoundEvents.BLOCK_SWITCH_TURN_ON, ModSoundEvents.BLOCK_SWITCH_TURN_OFF));
    public static final Block AGED_SWITCH = registerBlockInBlockset(SWITCH_BLOCKS, "aged_switch", new SwitchBlock(AbstractBlock.Settings.copy(MOUSE).pistonBehavior(PistonBehavior.DESTROY), ModSoundEvents.BLOCK_SWITCH_TURN_ON, ModSoundEvents.BLOCK_SWITCH_TURN_OFF));
    public static final Block BLACK_SWITCH = registerBlockInBlockset(SWITCH_BLOCKS, "black_switch", new SwitchBlock(AbstractBlock.Settings.copy(MOUSE).pistonBehavior(PistonBehavior.DESTROY), ModSoundEvents.BLOCK_SWITCH_TURN_ON, ModSoundEvents.BLOCK_SWITCH_TURN_OFF));
    public static final Block GRAY_SWITCH = registerBlockInBlockset(SWITCH_BLOCKS, "gray_switch", new SwitchBlock(AbstractBlock.Settings.copy(MOUSE).pistonBehavior(PistonBehavior.DESTROY), ModSoundEvents.BLOCK_SWITCH_TURN_ON, ModSoundEvents.BLOCK_SWITCH_TURN_OFF));
    public static final Block EMPTY_TIRE = registerBlock("empty_tire", new BouncyPillarBlock(AbstractBlock.Settings.create().mapColor(MapColor.BLACK).instrument(NoteBlockInstrument.BASS).strength(0.2f).sounds(ModBlockSoundGroup.TIRE)));
    public static final Block TIRE = registerBlock("tire", new PillarBlock(AbstractBlock.Settings.copy(EMPTY_TIRE).strength(1.0f).requiresTool()));
    public static final Block CRATE = registerBlock("crate", new CrateBlock(AbstractBlock.Settings.create().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.TERRACOTTA_GRAY).strength(3.5f, 50.0f).requiresTool().sounds(ModBlockSoundGroup.KORP)));

    public static final Block ANTENNA = registerBlock("antenna", new AntennaBlock(AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_GRAY).strength(3.0f, 6.0f).sounds(ModBlockSoundGroup.ANTENNA).nonOpaque().blockVision(ModBlocks::never).allowsSpawning(ModBlocks::never)));

    static {
        RENDER_LAYER_CUTOUT.add(ANTENNA);
    }

    public static final Block RADIO = registerBlock("radio", new RadioBlock(AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_GRAY).strength(1.0f).sounds(ModBlockSoundGroup.RADIO).nonOpaque().blockVision(ModBlocks::never).allowsSpawning(ModBlocks::never)));

    static {
        RENDER_LAYER_CUTOUT.add(RADIO);
    }
    //</editor-fold>

    //<editor-fold desc ="Blocks - Doors">
    public static Block registerDoor(String name, Block block) {
        Block b = registerBlock(name, block);
        DOORS.add(b);
        RENDER_LAYER_CUTOUT.add(b);
        return b;
    }

    public static final Block DOOR_PUNCTURE = registerDoor("door_puncture", new DoorBlock(ModBlockSetType.LUESIUM, AbstractBlock.Settings.copy(LUESIUM_BLOCK).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block DOOR_STEAK = registerDoor("door_steak", new DoorBlock(ModBlockSetType.FORTT, AbstractBlock.Settings.copy(forttMaterial).mapColor(MapColor.DEEPSLATE_GRAY).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block DOOR_NEON = registerDoor("door_neon", new DoorBlock(ModBlockSetType.CRAY, AbstractBlock.Settings.copy(crayMaterial).mapColor(MapColor.PURPLE).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block DOOR_TOY = registerDoor("door_toy", new DoorBlock(ModBlockSetType.CAST, AbstractBlock.Settings.copy(castMaterial).mapColor(MapColor.BRIGHT_RED).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block DOOR_POWER = registerDoor("door_power", new DoorBlock(ModBlockSetType.NURR, AbstractBlock.Settings.copy(nurrMaterial).mapColor(MapColor.BLACK).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block DOOR_VACUUM = registerDoor("door_vacuum", new DoorBlock(ModBlockSetType.VECT, AbstractBlock.Settings.copy(vectMaterial).mapColor(MapColor.BLACK).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block DOOR_CONFINE = registerDoor("door_confine", new DoorBlock(ModBlockSetType.MINN, AbstractBlock.Settings.copy(minnMaterial).mapColor(MapColor.WHITE).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block DOOR_END = registerDoor("door_end", new DoorBlock(ModBlockSetType.LAIR, AbstractBlock.Settings.copy(lairMaterial).mapColor(MapColor.DARK_CRIMSON).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block DOOR_HEAVY = registerDoor("door_heavy", new DoorBlock(ModBlockSetType.KRYP, AbstractBlock.Settings.copy(krypMaterial).mapColor(MapColor.SPRUCE_BROWN).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block DOOR_TEST = registerDoor("door_test", new DoorBlock(ModBlockSetType.LAVE, AbstractBlock.Settings.copy(laveMaterial).mapColor(MapColor.IRON_GRAY).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block DOOR_GROWN = registerDoor("door_grown", new DoorBlock(ModBlockSetType.VEELD, AbstractBlock.Settings.copy(veeldMaterial).mapColor(MapColor.DARK_GREEN).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block DOOR_KNET = registerDoor("door_knet", new DoorBlock(ModBlockSetType.KORP, AbstractBlock.Settings.copy(korpMaterial).mapColor(MapColor.CLEAR).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block DOOR_WORK = registerDoor("door_work", new DoorBlock(ModBlockSetType.TANK, AbstractBlock.Settings.copy(tankMaterial).mapColor(MapColor.GRAY).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block DOOR_SAFE = registerDoor("door_safe", new DoorBlock(ModBlockSetType.EXRI, AbstractBlock.Settings.copy(exriMaterial).mapColor(MapColor.BLACK).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block DOOR_PETRI = registerDoor("door_petri", new DoorBlock(ModBlockSetType.ROEN, AbstractBlock.Settings.copy(roenMaterial).mapColor(MapColor.PALE_YELLOW).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block DOOR_BUNKER = registerDoor("door_bunker", new DoorBlock(ModBlockSetType.TONE, AbstractBlock.Settings.copy(ModBlocks.ABSTRACT_TONE).mapColor(MapColor.IRON_GRAY).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block IRON_BAR_DOOR = registerDoor("iron_bar_door", new DoorBlock(BlockSetType.IRON, AbstractBlock.Settings.copy(Blocks.IRON_DOOR).mapColor(MapColor.IRON_GRAY).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    //</editor-fold>

    //<editor-fold desc ="Blocks - Trapdoors">
    public static Block registerTrapdoor(String name, Block block) {
        Block b = registerBlock(name, block);
        TRAPDOORS.add(b);
        RENDER_LAYER_CUTOUT.add(b);
        return b;
    }

    public static final Block TRAPDOOR_PUNCTURE = registerTrapdoor("trapdoor_puncture", new TrapdoorBlock(ModBlockSetType.LUESIUM, AbstractBlock.Settings.copy(LUESIUM_BLOCK).nonOpaque().allowsSpawning(ModBlocks::never)));
    public static final Block TRAPDOOR_STEAK = registerTrapdoor("trapdoor_steak", new TrapdoorBlock(ModBlockSetType.FORTT, AbstractBlock.Settings.copy(forttMaterial).mapColor(MapColor.DEEPSLATE_GRAY).nonOpaque().allowsSpawning(ModBlocks::never)));
    public static final Block TRAPDOOR_NEON = registerTrapdoor("trapdoor_neon", new TrapdoorBlock(ModBlockSetType.CRAY, AbstractBlock.Settings.copy(crayMaterial).mapColor(MapColor.PURPLE).nonOpaque().allowsSpawning(ModBlocks::never)));
    public static final Block TRAPDOOR_TOY = registerTrapdoor("trapdoor_toy", new TrapdoorBlock(ModBlockSetType.CAST, AbstractBlock.Settings.copy(castMaterial).mapColor(MapColor.BRIGHT_RED).nonOpaque().allowsSpawning(ModBlocks::never)));
    public static final Block TRAPDOOR_POWER = registerTrapdoor("trapdoor_power", new TrapdoorBlock(ModBlockSetType.NURR, AbstractBlock.Settings.copy(nurrMaterial).mapColor(MapColor.BLACK).nonOpaque().allowsSpawning(ModBlocks::never)));
    public static final Block TRAPDOOR_VACUUM = registerTrapdoor("trapdoor_vacuum", new TrapdoorBlock(ModBlockSetType.VECT, AbstractBlock.Settings.copy(vectMaterial).mapColor(MapColor.BLACK).nonOpaque().allowsSpawning(ModBlocks::never)));
    public static final Block TRAPDOOR_CONFINE = registerTrapdoor("trapdoor_confine", new TrapdoorBlock(ModBlockSetType.MINN, AbstractBlock.Settings.copy(minnMaterial).mapColor(MapColor.WHITE).nonOpaque().allowsSpawning(ModBlocks::never)));
    public static final Block TRAPDOOR_END = registerTrapdoor("trapdoor_end", new TrapdoorBlock(ModBlockSetType.LAIR, AbstractBlock.Settings.copy(lairMaterial).mapColor(MapColor.DARK_CRIMSON).nonOpaque().allowsSpawning(ModBlocks::never)));
    public static final Block TRAPDOOR_HEAVY = registerTrapdoor("trapdoor_heavy", new TrapdoorBlock(ModBlockSetType.KRYP, AbstractBlock.Settings.copy(krypMaterial).mapColor(MapColor.SPRUCE_BROWN).nonOpaque().allowsSpawning(ModBlocks::never)));
    public static final Block TRAPDOOR_TEST = registerTrapdoor("trapdoor_test", new TrapdoorBlock(ModBlockSetType.LAVE, AbstractBlock.Settings.copy(laveMaterial).mapColor(MapColor.IRON_GRAY).nonOpaque().allowsSpawning(ModBlocks::never)));
    public static final Block TRAPDOOR_GROWN = registerTrapdoor("trapdoor_grown", new TrapdoorBlock(ModBlockSetType.VEELD, AbstractBlock.Settings.copy(veeldMaterial).mapColor(MapColor.DARK_GREEN).nonOpaque().allowsSpawning(ModBlocks::never)));
    public static final Block TRAPDOOR_KNET = registerTrapdoor("trapdoor_knet", new TrapdoorBlock(ModBlockSetType.KORP, AbstractBlock.Settings.copy(korpMaterial).mapColor(MapColor.CLEAR).nonOpaque().allowsSpawning(ModBlocks::never)));
    public static final Block TRAPDOOR_WORK = registerTrapdoor("trapdoor_work", new TrapdoorBlock(ModBlockSetType.TANK, AbstractBlock.Settings.copy(tankMaterial).mapColor(MapColor.GRAY).nonOpaque().allowsSpawning(ModBlocks::never)));
    public static final Block TRAPDOOR_SAFE = registerTrapdoor("trapdoor_safe", new TrapdoorBlock(ModBlockSetType.EXRI, AbstractBlock.Settings.copy(exriMaterial).mapColor(MapColor.BLACK).nonOpaque().allowsSpawning(ModBlocks::never)));
    public static final Block TRAPDOOR_PETRI = registerTrapdoor("trapdoor_petri", new TrapdoorBlock(ModBlockSetType.ROEN, AbstractBlock.Settings.copy(roenMaterial).mapColor(MapColor.PALE_YELLOW).nonOpaque().allowsSpawning(ModBlocks::never)));
    public static final Block TRAPDOOR_BUNKER = registerTrapdoor("trapdoor_bunker", new TrapdoorBlock(ModBlockSetType.TONE, AbstractBlock.Settings.copy(ModBlocks.ABSTRACT_TONE).mapColor(MapColor.IRON_GRAY).nonOpaque().allowsSpawning(ModBlocks::never)));
    public static final Block IRON_BAR_TRAPDOOR = registerTrapdoor("iron_bar_trapdoor", new TrapdoorBlock(BlockSetType.IRON, AbstractBlock.Settings.copy(Blocks.IRON_TRAPDOOR).mapColor(MapColor.IRON_GRAY).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    //</editor-fold>

    //<editor-fold desc ="Blocks - Decals">
    private static Block registerDecalBlock(String name, Block block) {
        Block b = registerBlockWithoutBlockItem(name, block);
        DECAL_BLOCKS.add(b);
        return b;
    }

    private static final AbstractBlock decalMaterial = new Block(AbstractBlock.Settings.create()
            .mapColor(MapColor.CLEAR)
            .strength(0.1f)
            .nonOpaque()
            .noCollision()
            .pistonBehavior(PistonBehavior.DESTROY));
    public static final Block DECAL_LUESIUM = registerDecalBlock("decal_luesium", new DecalBlock(AbstractBlock.Settings.copy(decalMaterial).pistonBehavior(PistonBehavior.DESTROY).sounds(ModBlockSoundGroup.DECAL_LUESIUM)));

    static {
        RENDER_LAYER_TRANSLUCENT.add(DECAL_LUESIUM);
    }

    public static final Block DECAL_LUESIUM_CHUNK = registerDecalBlock("decal_luesium_chunk", new DecalBlock(AbstractBlock.Settings.copy(decalMaterial).pistonBehavior(PistonBehavior.DESTROY).sounds(ModBlockSoundGroup.DECAL_LUESIUM)));

    static {
        RENDER_LAYER_TRANSLUCENT.add(DECAL_LUESIUM_CHUNK);
    }

    public static final Block DECAL_RAW_LUESIUM = registerDecalBlock("decal_raw_luesium", new DecalBlock(AbstractBlock.Settings.copy(decalMaterial).pistonBehavior(PistonBehavior.DESTROY).sounds(ModBlockSoundGroup.DECAL_RAW_LUESIUM)));

    static {
        RENDER_LAYER_TRANSLUCENT.add(DECAL_RAW_LUESIUM);
    }

    public static final Block DECAL_ANTIBRASS = registerDecalBlock("decal_antibrass", new DecalBlock(AbstractBlock.Settings.copy(decalMaterial).pistonBehavior(PistonBehavior.DESTROY).sounds(ModBlockSoundGroup.DECAL_ANTIBRASS)));

    static {
        RENDER_LAYER_TRANSLUCENT.add(DECAL_ANTIBRASS);
    }

    public static final Block DECAL_CONDUCTIUM = registerDecalBlock("decal_conductium", new DecalBlock(AbstractBlock.Settings.copy(decalMaterial).pistonBehavior(PistonBehavior.DESTROY).sounds(ModBlockSoundGroup.DECAL_CONDUCTIUM)));

    static {
        RENDER_LAYER_TRANSLUCENT.add(DECAL_CONDUCTIUM);
    }

    public static final Block DECAL_KERBESIUM = registerDecalBlock("decal_kerbesium", new DecalBlock(AbstractBlock.Settings.copy(decalMaterial).pistonBehavior(PistonBehavior.DESTROY).sounds(ModBlockSoundGroup.DECAL_KERBESIUM)));

    static {
        RENDER_LAYER_TRANSLUCENT.add(DECAL_KERBESIUM);
    }

    public static final Block DECAL_ORGANIC_BRASS = registerDecalBlock("decal_organic_brass", new DecalBlock(AbstractBlock.Settings.copy(decalMaterial).pistonBehavior(PistonBehavior.DESTROY).sounds(ModBlockSoundGroup.DECAL_ORGANIC_BRASS)));

    static {
        RENDER_LAYER_TRANSLUCENT.add(DECAL_ORGANIC_BRASS);
    }

    public static final Block DECAL_MIDASIUM = registerDecalBlock("decal_midasium", new DecalBlock(AbstractBlock.Settings.copy(decalMaterial).pistonBehavior(PistonBehavior.DESTROY).sounds(ModBlockSoundGroup.DECAL_MIDASIUM)));

    static {
        RENDER_LAYER_TRANSLUCENT.add(DECAL_MIDASIUM);
    }

    public static final Block DECAL_TAWSINE = registerDecalBlock("decal_tawsine", new DecalBlock(AbstractBlock.Settings.copy(decalMaterial).pistonBehavior(PistonBehavior.DESTROY).sounds(ModBlockSoundGroup.DECAL_TAWSINE)));

    static {
        RENDER_LAYER_TRANSLUCENT.add(DECAL_TAWSINE);
    }

    public static final Block DECAL_THINKING_METAL = registerDecalBlock("decal_thinking_metal", new DecalBlock(AbstractBlock.Settings.copy(decalMaterial).pistonBehavior(PistonBehavior.DESTROY).sounds(ModBlockSoundGroup.DECAL_THINKING_METAL)));

    static {
        RENDER_LAYER_TRANSLUCENT.add(DECAL_THINKING_METAL);
    }

    public static final Block DECAL_ARGON = registerDecalBlock("decal_argon", new DecalBlock(AbstractBlock.Settings.copy(decalMaterial).pistonBehavior(PistonBehavior.DESTROY).sounds(ModBlockSoundGroup.DECAL_CORPOREAL_VALOR)));

    static {
        RENDER_LAYER_TRANSLUCENT.add(DECAL_ARGON);
    }

    public static final Block DECAL_OIL = registerDecalBlock("decal_oil", new DecalBlock(AbstractBlock.Settings.copy(decalMaterial).pistonBehavior(PistonBehavior.DESTROY).sounds(ModBlockSoundGroup.DECAL_OIL)));

    static {
        RENDER_LAYER_TRANSLUCENT.add(DECAL_OIL);
    }

    public static final Block DECAL_DIODE = registerDecalBlock("decal_diode", new DecalBlock(AbstractBlock.Settings.copy(decalMaterial).pistonBehavior(PistonBehavior.DESTROY).sounds(ModBlockSoundGroup.DECAL_DIODE)));

    static {
        RENDER_LAYER_TRANSLUCENT.add(DECAL_DIODE);
    }

    public static final Block DECAL_POLYMER = registerDecalBlock("decal_polymer", new DecalBlock(AbstractBlock.Settings.copy(decalMaterial).pistonBehavior(PistonBehavior.DESTROY).sounds(ModBlockSoundGroup.DECAL_POLYMER)));

    static {
        RENDER_LAYER_TRANSLUCENT.add(DECAL_POLYMER);
    }

    public static final Block DECAL_SHEETING = registerDecalBlock("decal_sheeting", new DecalBlock(AbstractBlock.Settings.copy(decalMaterial).pistonBehavior(PistonBehavior.DESTROY).sounds(ModBlockSoundGroup.DECAL_SHEETING)));

    static {
        RENDER_LAYER_TRANSLUCENT.add(DECAL_SHEETING);
    }

    public static final Block DECAL_POLYCARBONATE = registerDecalBlock("decal_polycarbonate", new DecalBlock(AbstractBlock.Settings.copy(decalMaterial).pistonBehavior(PistonBehavior.DESTROY).sounds(ModBlockSoundGroup.DECAL_POLYCARBONATE)));

    static {
        RENDER_LAYER_TRANSLUCENT.add(DECAL_POLYCARBONATE);
    }

    public static final Block DECAL_GAS_TUBE = registerDecalBlock("decal_gas_tube", new DecalBlock(AbstractBlock.Settings.copy(decalMaterial).pistonBehavior(PistonBehavior.DESTROY).sounds(ModBlockSoundGroup.DECAL_GLASS_TUBE)));

    static {
        RENDER_LAYER_TRANSLUCENT.add(DECAL_GAS_TUBE);
    }

    public static final Block DECAL_AZURE_RIVET = registerDecalBlock("decal_azure_rivet", new DecalBlock(AbstractBlock.Settings.copy(decalMaterial).pistonBehavior(PistonBehavior.DESTROY).sounds(ModBlockSoundGroup.DECAL_AZURE_RIVET)));

    static {
        RENDER_LAYER_TRANSLUCENT.add(DECAL_AZURE_RIVET);
    }

    public static final Block DECAL_GLEAM = registerDecalBlock("decal_gleam", new DecalBlock(AbstractBlock.Settings.copy(decalMaterial).pistonBehavior(PistonBehavior.DESTROY).sounds(ModBlockSoundGroup.DECAL_GLEAM)));

    static {
        RENDER_LAYER_TRANSLUCENT.add(DECAL_GLEAM);
    }

    public static final Block DECAL_G2V = registerDecalBlock("decal_g2v", new DecalBlock(AbstractBlock.Settings.copy(decalMaterial).pistonBehavior(PistonBehavior.DESTROY).sounds(ModBlockSoundGroup.DECAL_G2V)));

    static {
        RENDER_LAYER_TRANSLUCENT.add(DECAL_G2V);
    }

    public static final Block DECAL_SLAG = registerDecalBlock("decal_slag", new DecalBlock(AbstractBlock.Settings.copy(decalMaterial).pistonBehavior(PistonBehavior.DESTROY).sounds(ModBlockSoundGroup.DECAL_SLAG)));

    static {
        RENDER_LAYER_TRANSLUCENT.add(DECAL_SLAG);
    }

    public static final Block DECAL_REBITH = registerDecalBlock("decal_rebith", new DecalBlock(AbstractBlock.Settings.copy(decalMaterial).pistonBehavior(PistonBehavior.DESTROY).sounds(ModBlockSoundGroup.DECAL_REBITH)));

    static {
        RENDER_LAYER_TRANSLUCENT.add(DECAL_REBITH);
    }

    public static final Block DECAL_RADIUM_PAINT = registerDecalBlock("decal_radium_paint", new AmbientSoundDecalBlock(AbstractBlock.Settings.copy(decalMaterial).pistonBehavior(PistonBehavior.DESTROY).sounds(ModBlockSoundGroup.DECAL_RADIUM_PAINT), ModSoundEvents.BLOCK_SYNC_AMBIENT, 80));

    static {
        RENDER_LAYER_TRANSLUCENT.add(DECAL_RADIUM_PAINT);
    }

    public static final Block DECAL_FIBROUS_POWDER = registerDecalBlock("decal_fibrous_powder", new DecalBlock(AbstractBlock.Settings.copy(decalMaterial).pistonBehavior(PistonBehavior.DESTROY).sounds(ModBlockSoundGroup.DECAL_FIBROUS_POWDER)));

    static {
        RENDER_LAYER_TRANSLUCENT.add(DECAL_FIBROUS_POWDER);
    }

    public static final Block DECAL_AMALGAM = registerDecalBlock("decal_amalgam", new DecalBlock(AbstractBlock.Settings.copy(decalMaterial).pistonBehavior(PistonBehavior.DESTROY).sounds(ModBlockSoundGroup.DECAL_AMALGAM)));

    static {
        RENDER_LAYER_TRANSLUCENT.add(DECAL_AMALGAM);
    }

    public static final Block DECAL_SLUMP = registerDecalBlock("decal_slump", new DecalBlock(AbstractBlock.Settings.copy(decalMaterial).pistonBehavior(PistonBehavior.DESTROY).sounds(ModBlockSoundGroup.DECAL_SLUMP)));

    static {
        RENDER_LAYER_TRANSLUCENT.add(DECAL_SLUMP);
    }

    public static final Block DECAL_SHADE = registerDecalBlock("decal_shade", new DecalBlock(AbstractBlock.Settings.copy(decalMaterial).pistonBehavior(PistonBehavior.DESTROY).sounds(ModBlockSoundGroup.DECAL_SHADE)));

    static {
        RENDER_LAYER_TRANSLUCENT.add(DECAL_SHADE);
    }

    public static final Block DECAL_SCREEN = registerDecalBlock("decal_screen", new DecalBlock(AbstractBlock.Settings.copy(decalMaterial).pistonBehavior(PistonBehavior.DESTROY).sounds(ModBlockSoundGroup.DECAL_SCREEN)));

    static {
        RENDER_LAYER_TRANSLUCENT.add(DECAL_SCREEN);
    }

    public static final Block DECAL_SCARLET_MEMBRANE = registerDecalBlock("decal_scarlet_membrane", new DecalBlock(AbstractBlock.Settings.copy(decalMaterial).pistonBehavior(PistonBehavior.DESTROY).sounds(ModBlockSoundGroup.DECAL_SCARLET_MEMBRANE)));

    static {
        RENDER_LAYER_TRANSLUCENT.add(DECAL_SCARLET_MEMBRANE);
    }

    public static final Block DECAL_MOULDING = registerDecalBlock("decal_moulding", new DecalBlock(AbstractBlock.Settings.copy(decalMaterial).pistonBehavior(PistonBehavior.DESTROY).sounds(ModBlockSoundGroup.DECAL_MOULDING)));

    static {
        RENDER_LAYER_TRANSLUCENT.add(DECAL_MOULDING);
    }

    public static final Block DECAL_PLAQUE = registerDecalBlock("decal_plaque", new DecalBlock(AbstractBlock.Settings.copy(decalMaterial).pistonBehavior(PistonBehavior.DESTROY).sounds(ModBlockSoundGroup.DECAL_PLAQUE)));

    static {
        RENDER_LAYER_TRANSLUCENT.add(DECAL_PLAQUE);
    }

    public static final Block DECAL_JELLY = registerDecalBlock("decal_jelly", new DecalBlock(AbstractBlock.Settings.copy(decalMaterial).pistonBehavior(PistonBehavior.DESTROY).sounds(ModBlockSoundGroup.DECAL_JELLY)));

    static {
        RENDER_LAYER_TRANSLUCENT.add(DECAL_JELLY);
    }

    public static final Block DECAL_FELT = registerDecalBlock("decal_felt", new DecalBlock(AbstractBlock.Settings.copy(decalMaterial).pistonBehavior(PistonBehavior.DESTROY).sounds(ModBlockSoundGroup.DECAL_FELT)));

    static {
        RENDER_LAYER_TRANSLUCENT.add(DECAL_FELT);
    }

    public static final Block DECAL_CORPOREAL_VAPOR = registerDecalBlock("decal_corporeal_vapor", new DecalBlock(AbstractBlock.Settings.copy(decalMaterial).pistonBehavior(PistonBehavior.DESTROY).sounds(ModBlockSoundGroup.DECAL_CORPOREAL_VALOR)));

    static {
        RENDER_LAYER_TRANSLUCENT.add(DECAL_CORPOREAL_VAPOR);
    }

    public static final Block DECAL_FLAKES = registerDecalBlock("decal_flakes", new DecalBlock(AbstractBlock.Settings.copy(decalMaterial).pistonBehavior(PistonBehavior.DESTROY).sounds(ModBlockSoundGroup.DECAL_FLAKES)));

    static {
        RENDER_LAYER_TRANSLUCENT.add(DECAL_FLAKES);
    }

    public static final Block DECAL_NETWORKING = registerDecalBlock("decal_networking", new DecalBlock(AbstractBlock.Settings.copy(decalMaterial).pistonBehavior(PistonBehavior.DESTROY).sounds(ModBlockSoundGroup.DECAL_NETWORKING)));

    static {
        RENDER_LAYER_TRANSLUCENT.add(DECAL_NETWORKING);
    }

    public static final Block DECAL_SUGARING_PASTE = registerDecalBlock("decal_sugaring_paste", new DecalBlock(AbstractBlock.Settings.copy(decalMaterial).pistonBehavior(PistonBehavior.DESTROY).sounds(ModBlockSoundGroup.DECAL_SUGARING_PASTE)));

    static {
        RENDER_LAYER_TRANSLUCENT.add(DECAL_SUGARING_PASTE);
    }
    //</editor-fold>

    //<editor-fold desc ="Registration">
    public static BlockSet registerBlockSet(ArrayList<Block> blocks, String tagName) {
        BlockSet blockset = new BlockSet(blocks, tagName);
        BLOCKSETS.add(blockset);
        return blockset;
    }

    public static ArrayList<Block> registerBlocksetOfVanillaDyedBlocks(String name, AbstractBlock.Settings settings) {
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

    public static Block registerStairs(Block fullBlock, String name, Block block) {
        Block b = registerBlock(name, block);
        STAIRS_FROM_BLOCK.put(fullBlock, b);
        return b;
    }

    public static Block registerSlab(Block fullBlock, String name, Block block) {
        Block b = registerBlock(name, block);
        SLAB_FROM_BLOCK.put(fullBlock, b);
        return b;
    }

    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Super.MOD_ID, name), block);
    }

    public static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(Super.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        BlockItem blockItem = new BlockItem(block, new Item.Settings());
        //ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(blockItem));
        return Registry.register(Registries.ITEM, Identifier.of(Super.MOD_ID, name), blockItem);
    }
    //</editor-fold>

    //<editor-fold desc ="Attribute Util">
    private static boolean state(BlockState blockState, BlockView blockView, BlockPos blockPos, BooleanProperty property) {
        return blockState.get(property);
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
    //</editor-fold>

    private static boolean always(BlockState state, BlockView world, BlockPos pos) {
        return true;
    }

    public static void registerModBlocks() {
        ModInit.LOGGER.debug("Registering mod blocks for " + Super.MOD_ID);
    }
}
