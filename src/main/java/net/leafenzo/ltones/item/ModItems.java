package net.leafenzo.ltones.item;

import net.leafenzo.ltones.ModInit;
import net.leafenzo.ltones.Super;
import net.leafenzo.ltones.block.ModBlocks;
import net.leafenzo.ltones.item.custom.CrowsBeakItem;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    //<editor-fold desc ="Items">
    public static final Item CROWS_BEAK = registerItem("crows_beak", new CrowsBeakItem(4, 0.9f, new Item.Settings()));

    public static final Item RAW_LUESIUM = registerItem("raw_luesium", new AliasedBlockItem(ModBlocks.DECAL_RAW_LUESIUM, new Item.Settings()));
    public static final Item LUESIUM_INGOT = registerItem("luesium_ingot", new AliasedBlockItem(ModBlocks.DECAL_LUESIUM, new Item.Settings()));
    public static final Item LUESIUM_CHUNK = registerItem("luesium_chunk", new AliasedBlockItem(ModBlocks.DECAL_LUESIUM_CHUNK, new Item.Settings()));
    public static final Item ANTIBRASS_INGOT = registerItem("antibrass_ingot", new AliasedBlockItem(ModBlocks.DECAL_ANTIBRASS, new Item.Settings()));
    public static final Item CONDUCTIUM = registerItem("conductium", new AliasedBlockItem(ModBlocks.DECAL_CONDUCTIUM, new Item.Settings()));
    public static final Item KERBESIUM = registerItem("kerbesium", new AliasedBlockItem(ModBlocks.DECAL_KERBESIUM, new Item.Settings()));
    public static final Item ORGANIC_BRASS = registerItem("organic_brass", new AliasedBlockItem(ModBlocks.DECAL_ORGANIC_BRASS, new Item.Settings()));
    public static final Item MIDASIUM = registerItem("midasium", new AliasedBlockItem(ModBlocks.DECAL_MIDASIUM, new Item.Settings()));
    public static final Item TAWSINE = registerItem("tawsine", new AliasedBlockItem(ModBlocks.DECAL_TAWSINE, new Item.Settings()));
    public static final Item THINKING_METAL = registerItem("thinking_metal", new AliasedBlockItem(ModBlocks.DECAL_THINKING_METAL, new Item.Settings()));
    public static final Item ARGON = registerItem("argon", new AliasedBlockItem(ModBlocks.DECAL_ARGON, new Item.Settings()));
    public static final Item OIL = registerItem("oil", new AliasedBlockItem(ModBlocks.DECAL_OIL, new Item.Settings()));
    public static final Item DIODE = registerItem("diode", new AliasedBlockItem(ModBlocks.DECAL_DIODE, new Item.Settings()));
    public static final Item POLYMER = registerItem("polymer", new AliasedBlockItem(ModBlocks.DECAL_POLYMER, new Item.Settings()));
    public static final Item SHEETING = registerItem("sheeting", new AliasedBlockItem(ModBlocks.DECAL_SHEETING, new Item.Settings()));
    public static final Item REBITH = registerItem("rebith", new AliasedBlockItem(ModBlocks.DECAL_REBITH, new Item.Settings()));
    public static final Item POLYCARBONATE = registerItem("polycarbonate", new AliasedBlockItem(ModBlocks.DECAL_POLYCARBONATE, new Item.Settings()));
    public static final Item GAS_TUBE = registerItem("gas_tube", new AliasedBlockItem(ModBlocks.DECAL_GAS_TUBE, new Item.Settings()));
    public static final Item AZURE_RIVET = registerItem("azure_rivet", new AliasedBlockItem(ModBlocks.DECAL_AZURE_RIVET, new Item.Settings()));
    public static final Item GLEAM = registerItem("gleam", new AliasedBlockItem(ModBlocks.DECAL_GLEAM, new Item.Settings()));
    public static final Item G2V = registerItem("g2v", new AliasedBlockItem(ModBlocks.DECAL_G2V, new Item.Settings()));
    public static final Item SLAG = registerItem("slag", new AliasedBlockItem(ModBlocks.DECAL_SLAG, new Item.Settings()));
    public static final Item RADIUM_PAINT = registerItem("radium_paint", new AliasedBlockItem(ModBlocks.DECAL_RADIUM_PAINT, new Item.Settings()));
    public static final Item FIBROUS_POWDER = registerItem("fibrous_powder", new AliasedBlockItem(ModBlocks.DECAL_FIBROUS_POWDER, new Item.Settings()));
    public static final Item AMALGAM = registerItem("amalgam", new AliasedBlockItem(ModBlocks.DECAL_AMALGAM, new Item.Settings()));
    public static final Item SLUMP = registerItem("slump", new AliasedBlockItem(ModBlocks.DECAL_SLUMP, new Item.Settings()));
    public static final Item SHADE = registerItem("shade", new AliasedBlockItem(ModBlocks.DECAL_SHADE, new Item.Settings()));
    public static final Item SCREEN = registerItem("screen", new AliasedBlockItem(ModBlocks.DECAL_SCREEN, new Item.Settings()));
    public static final Item SCARLET_MEMBRANE = registerItem("scarlet_membrane", new AliasedBlockItem(ModBlocks.DECAL_SCARLET_MEMBRANE, new Item.Settings()));
    public static final Item MOULDING = registerItem("moulding", new AliasedBlockItem(ModBlocks.DECAL_MOULDING, new Item.Settings()));
    public static final Item PLAQUE = registerItem("plaque", new AliasedBlockItem(ModBlocks.DECAL_PLAQUE, new Item.Settings()));
    public static final Item JELLY = registerItem("jelly", new AliasedBlockItem(ModBlocks.DECAL_JELLY, new Item.Settings()));
    public static final Item CORPOREAL_VAPOR = registerItem("corporeal_vapor", new AliasedBlockItem(ModBlocks.DECAL_CORPOREAL_VAPOR, new Item.Settings()));
    public static final Item FLAKES = registerItem("flakes", new AliasedBlockItem(ModBlocks.DECAL_FLAKES, new Item.Settings()));
    public static final Item NETWORKING = registerItem("networking", new AliasedBlockItem(ModBlocks.DECAL_NETWORKING, new Item.Settings()));
    public static final Item FELT = registerItem("felt", new AliasedBlockItem(ModBlocks.DECAL_FELT, new Item.Settings()));

    public static final Item PCB_BOARD = registerItem("pcb_board", new Item(new Item.Settings()));
    public static final Item STORAGE_PEARL = registerItem("storage_pearl", new Item(new Item.Settings()));
    public static final Item INDUSTRIAL_DIAMOND = registerItem("industrial_diamond", new Item(new Item.Settings()));
    public static final Item MEDICINE_PILLS = registerItem("medicine_pills", new Item(new Item.Settings()));
    public static final Item BOXED_MEDICINE = registerItem("boxed_medicine", new Item(new Item.Settings()));
    public static final Item SUGARING_PASTE = registerItem("sugaring_paste", new AliasedBlockItem(ModBlocks.DECAL_SUGARING_PASTE, new Item.Settings().food(ModFoodComponents.SUGARING_PASTE)));
    public static final Item PENCIL = registerItem("pencil", new Item(new Item.Settings()));
    public static final Item BROKEN_PENCIL = registerItem("broken_pencil", new Item(new Item.Settings()));
    public static final Item PACKAGED_MEAL = registerItem("packaged_meal", new Item(new Item.Settings().food(ModFoodComponents.PACKAGED_MEAL)));
    public static final Item DECK_OF_CARDS = registerItem("deck_of_cards", new Item(new Item.Settings()));
    //</editor-fold>

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Super.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ModInit.LOGGER.info("Registering Mod Items for " + Super.MOD_ID);
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }}
