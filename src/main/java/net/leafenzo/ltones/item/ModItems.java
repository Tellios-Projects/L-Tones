package net.leafenzo.ltones.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.leafenzo.ltones.ModInit;
import net.leafenzo.ltones.Super;
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
    public static final Item CONDUCTIUM = registerItem("conductium", new Item(new FabricItemSettings()));
    public static final Item KERBESIUM = registerItem("kerbesium", new Item(new FabricItemSettings()));
    public static final Item ORGANIC_BRASS = registerItem("organic_brass", new Item(new FabricItemSettings()));
    public static final Item MIDASIUM = registerItem("midasium", new Item(new FabricItemSettings()));
    public static final Item TAWSINE = registerItem("tawsine", new Item(new FabricItemSettings()));
    public static final Item THINKING_METAL = registerItem("thinking_metal", new Item(new FabricItemSettings()));
    public static final Item ARGON = registerItem("argon", new Item(new FabricItemSettings()));
    public static final Item OIL = registerItem("oil", new Item(new FabricItemSettings()));
    public static final Item DIODE = registerItem("diode", new Item(new FabricItemSettings()));
    public static final Item POLYMER = registerItem("polymer", new Item(new FabricItemSettings()));
    public static final Item SHEETING = registerItem("sheeting", new Item(new FabricItemSettings()));
    public static final Item POLYCARBONATE = registerItem("polycarbonate", new Item(new FabricItemSettings()));
    public static final Item GAS_TUBE = registerItem("gas_tube", new Item(new FabricItemSettings()));
    public static final Item AZURE_RIVET = registerItem("azure_rivet", new Item(new FabricItemSettings()));
    public static final Item GLEAM = registerItem("gleam", new Item(new FabricItemSettings()));
    public static final Item G2V = registerItem("g2v", new Item(new FabricItemSettings()));
    public static final Item SLAG = registerItem("slag", new Item(new FabricItemSettings()));
    public static final Item RADIUM_PAINT = registerItem("radium_paint", new Item(new FabricItemSettings()));
    public static final Item FIBROUS_POWDER = registerItem("fibrous_powder", new Item(new FabricItemSettings()));
    public static final Item AMALGAM = registerItem("amalgam", new Item(new FabricItemSettings()));
    public static final Item PORCELAIN = registerItem("porcelain", new Item(new FabricItemSettings()));
    public static final Item SHADE = registerItem("shade", new Item(new FabricItemSettings()));
    public static final Item SCREEN = registerItem("screen", new Item(new FabricItemSettings()));
    public static final Item SCARLET_MEMBRANE = registerItem("scarlet_membrane", new Item(new FabricItemSettings()));
    public static final Item MOULDING = registerItem("moulding", new Item(new FabricItemSettings()));
    public static final Item PLAQUE = registerItem("plaque", new Item(new FabricItemSettings()));
    public static final Item JELLY = registerItem("jelly", new Item(new FabricItemSettings()));
    public static final Item CORPOREAL_VAPOR = registerItem("corporeal_vapor", new Item(new FabricItemSettings()));
    public static final Item FLAKES = registerItem("flakes", new Item(new FabricItemSettings()));
    public static final Item NETWORKING = registerItem("networking", new Item(new FabricItemSettings()));
    //</editor-fold>

//    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) { // I have no idea what this is or what it does
//
//    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Super.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ModInit.LOGGER.info("Registering Mod Items for " + Super.MOD_ID);
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }}
