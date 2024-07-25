package net.leafenzo.ltones.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.leafenzo.ltones.ModInit;
import net.leafenzo.ltones.Super;
import net.leafenzo.ltones.block.ModBlocks;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    //<editor-fold desc ="Items">
    public static final Item RAW_LITHIUM = registerItem("raw_lithium", new Item(new FabricItemSettings()));
    public static final Item LITHIUM_INGOT = registerItem("lithium_ingot", new Item(new FabricItemSettings()));
    public static final Item LITHIUM_CHUNK = registerItem("lithium_chunk", new Item(new FabricItemSettings()));
    public static final Item ANTIBRASS = registerItem("antibrass", new Item(new FabricItemSettings()));
    public static final Item CONDUCTIUM = registerItem("conductium", new AliasedBlockItem(ModBlocks.DECAL_CONDUCTIUM, new FabricItemSettings()));
    public static final Item KERBESIUM = registerItem("kerbesium", new AliasedBlockItem(ModBlocks.DECAL_KERBESIUM, new FabricItemSettings()));
    public static final Item ORGANIC_BRASS = registerItem("organic_brass", new AliasedBlockItem(ModBlocks.DECAL_ORGANIC_BRASS, new FabricItemSettings()));
    public static final Item MIDASIUM = registerItem("midasium", new AliasedBlockItem(ModBlocks.DECAL_MIDASIUM, new FabricItemSettings()));
    public static final Item TAWSINE = registerItem("tawsine", new AliasedBlockItem(ModBlocks.DECAL_TAWSINE, new FabricItemSettings()));
    public static final Item THINKING_METAL = registerItem("thinking_metal", new AliasedBlockItem(ModBlocks.DECAL_THINKING_METAL, new FabricItemSettings()));
    public static final Item ARGON = registerItem("argon", new AliasedBlockItem(ModBlocks.DECAL_ARGON, new FabricItemSettings()));
    public static final Item OIL = registerItem("oil", new AliasedBlockItem(ModBlocks.DECAL_OIL, new FabricItemSettings()));
    public static final Item DIODE = registerItem("diode", new AliasedBlockItem(ModBlocks.DECAL_DIODE, new FabricItemSettings()));
    public static final Item POLYMER = registerItem("polymer", new AliasedBlockItem(ModBlocks.DECAL_POLYMER, new FabricItemSettings()));
    public static final Item SHEETING = registerItem("sheeting", new AliasedBlockItem(ModBlocks.DECAL_SHEETING, new FabricItemSettings()));
    public static final Item POLYCARBONATE = registerItem("polycarbonate", new AliasedBlockItem(ModBlocks.DECAL_POLYCARBONATE, new FabricItemSettings()));
    public static final Item GAS_TUBE = registerItem("gas_tube", new AliasedBlockItem(ModBlocks.DECAL_GAS_TUBE, new FabricItemSettings()));
    public static final Item AZURE_RIVET = registerItem("azure_rivet", new AliasedBlockItem(ModBlocks.DECAL_AZURE_RIVET, new FabricItemSettings()));
    public static final Item GLEAM = registerItem("gleam", new AliasedBlockItem(ModBlocks.DECAL_GLEAM, new FabricItemSettings()));
    public static final Item G2V = registerItem("g2v", new AliasedBlockItem(ModBlocks.DECAL_G2V, new FabricItemSettings()));
    public static final Item SLAG = registerItem("slag", new AliasedBlockItem(ModBlocks.DECAL_SLAG, new FabricItemSettings()));
    public static final Item RADIUM_PAINT = registerItem("radium_paint", new AliasedBlockItem(ModBlocks.DECAL_RADIUM_PAINT, new FabricItemSettings()));
    public static final Item FIBROUS_POWDER = registerItem("fibrous_powder", new AliasedBlockItem(ModBlocks.DECAL_FIBROUS_POWDER, new FabricItemSettings()));
    public static final Item AMALGAM = registerItem("amalgam", new AliasedBlockItem(ModBlocks.DECAL_AMALGAM, new FabricItemSettings()));
    public static final Item SLUMP = registerItem("slump", new AliasedBlockItem(ModBlocks.DECAL_SLUMP, new FabricItemSettings()));
    public static final Item SHADE = registerItem("shade", new AliasedBlockItem(ModBlocks.DECAL_SHADE, new FabricItemSettings()));
    public static final Item SCREEN = registerItem("screen", new AliasedBlockItem(ModBlocks.DECAL_SCREEN, new FabricItemSettings()));
    public static final Item SCARLET_MEMBRANE = registerItem("scarlet_membrane", new AliasedBlockItem(ModBlocks.DECAL_SCARLET_MEMBRANE, new FabricItemSettings()));
    public static final Item MOULDING = registerItem("moulding", new AliasedBlockItem(ModBlocks.DECAL_MOULDING, new FabricItemSettings()));
    public static final Item PLAQUE = registerItem("plaque", new AliasedBlockItem(ModBlocks.DECAL_PLAQUE, new FabricItemSettings()));
    public static final Item JELLY = registerItem("jelly", new AliasedBlockItem(ModBlocks.DECAL_JELLY, new FabricItemSettings()));
    public static final Item CORPOREAL_VAPOR = registerItem("corporeal_vapor", new AliasedBlockItem(ModBlocks.DECAL_CORPOREAL_VAPOR, new FabricItemSettings()));
    public static final Item FLAKES = registerItem("flakes", new AliasedBlockItem(ModBlocks.DECAL_FLAKES, new FabricItemSettings()));
    public static final Item NETWORKING = registerItem("networking", new AliasedBlockItem(ModBlocks.DECAL_NETWORKING, new FabricItemSettings()));
    //</editor-fold>

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Super.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ModInit.LOGGER.info("Registering Mod Items for " + Super.MOD_ID);
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }}
