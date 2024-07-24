package net.leafenzo.ltones.item;


import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.leafenzo.ltones.ModInit;
import net.leafenzo.ltones.Super;
import net.leafenzo.ltones.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.ArrayList;

public class ModItemGroups {
    public static void registerModItemGroups() {
        ModInit.LOGGER.debug("Registering item groups for " + Super.MOD_ID);
    }

    public static ArrayList<Block> includeVariants(ArrayList<Block> inputs) {
        ArrayList<Block> blocks = new ArrayList<Block>();
        for(Block block : inputs) {
            blocks.add(block);
            if (ModBlocks.STAIRS_FROM_BLOCK.get(block) != null) { blocks.add(ModBlocks.STAIRS_FROM_BLOCK.get(block)); }
            if (ModBlocks.SLAB_FROM_BLOCK.get(block) != null) { blocks.add(ModBlocks.SLAB_FROM_BLOCK.get(block)); }
        }
        return blocks;
    }

    public static ItemGroup LTONES = Registry.register(Registries.ITEM_GROUP, new Identifier(Super.MOD_ID, "ltones"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ltones"))
                    .icon(() -> new ItemStack(ModBlocks.REDDS_TILE)).entries((displayContext, entries) -> {
                        for(Block block : includeVariants(ModBlocks.AGON_BLOCKS)) { entries.add(block); }
                        for(Block block : includeVariants(ModBlocks.FORTT_BLOCKS)) { entries.add(block); }
                        for(Block block : includeVariants(ModBlocks.GLAXX_BLOCKS)) { entries.add(block); }
                        for(Block block : includeVariants(ModBlocks.BITT_BLOCKS)) { entries.add(block); }
                        for(Block block : includeVariants(ModBlocks.CRAY_BLOCKS)) { entries.add(block); }
                        for(Block block : includeVariants(ModBlocks.CAST_BLOCKS)) { entries.add(block); }
                        for(Block block : includeVariants(ModBlocks.HOST_BLOCKS)) { entries.add(block); }
                        for(Block block : includeVariants(ModBlocks.ZANE_BLOCKS)) { entries.add(block); }
                        for(Block block : includeVariants(ModBlocks.ISZM_BLOCKS)) { entries.add(block); }
                        for(Block block : includeVariants(ModBlocks.MYST_BLOCKS)) { entries.add(block); }
                        for(Block block : includeVariants(ModBlocks.NURR_BLOCKS)) { entries.add(block); }
                        for(Block block : includeVariants(ModBlocks.TYEL_BLOCKS)) { entries.add(block); }
                        for(Block block : includeVariants(ModBlocks.VECT_BLOCKS)) { entries.add(block); }
                        for(Block block : includeVariants(ModBlocks.REDDS_BLOCKS)) { entries.add(block); }
                        for(Block block : includeVariants(ModBlocks.MINN_BLOCKS)) { entries.add(block); }
                        for(Block block : includeVariants(ModBlocks.LAIR_BLOCKS)) { entries.add(block); }
                        for(Block block : includeVariants(ModBlocks.KRYP_BLOCKS)) { entries.add(block); }
                        for(Block block : includeVariants(ModBlocks.LAVE_BLOCKS)) { entries.add(block); }
                        for(Block block : includeVariants(ModBlocks.VEELD_BLOCKS)) { entries.add(block); }
                        for(Block block : includeVariants(ModBlocks.JELT_BLOCKS)) { entries.add(block); }
                        for(Block block : includeVariants(ModBlocks.KORP_BLOCKS)) { entries.add(block); }
                        for(Block block : includeVariants(ModBlocks.TANK_BLOCKS)) { entries.add(block); }
                        for(Block block : includeVariants(ModBlocks.EXRI_BLOCKS)) { entries.add(block); }
                        for(Block block : includeVariants(ModBlocks.AZUR_BLOCKS)) { entries.add(block); }
                        for(Block block : includeVariants(ModBlocks.FLEQ_BLOCKS)) { entries.add(block); }
                        for(Block block : includeVariants(ModBlocks.SYNC_BLOCKS)) { entries.add(block); }
                        for(Block block : includeVariants(ModBlocks.ROEN_BLOCKS)) { entries.add(block); }
                        for(Block block : includeVariants(ModBlocks.SOL_BLOCKS)) { entries.add(block); }
                        entries.add(ModBlocks.DOOR_STEAK);
                        entries.add(ModBlocks.DOOR_NEON);
                        entries.add(ModBlocks.DOOR_TOY);
                        entries.add(ModBlocks.DOOR_POWER);
                        entries.add(ModBlocks.DOOR_VACUUM);
                        entries.add(ModBlocks.DOOR_CONFINE);
                        entries.add(ModBlocks.DOOR_END);
                        entries.add(ModBlocks.DOOR_HEAVY);
                        entries.add(ModBlocks.DOOR_TEST);
                        entries.add(ModBlocks.DOOR_GROWN);
                        entries.add(ModBlocks.DOOR_KNET);
                        entries.add(ModBlocks.DOOR_WORK);
                        entries.add(ModBlocks.DOOR_SAFE);
                        entries.add(ModBlocks.DOOR_PETRI);
                        entries.add(ModBlocks.DOOR_BUNKER);
                        entries.add(ModBlocks.IRON_BAR_DOOR);
                        entries.add(ModBlocks.TONE);
                        entries.add(ModBlocks.TONE_BRICKS);
                        entries.add(ModBlocks.POLISHED_TONE);
                        entries.add(ModBlocks.ABSTRACT_TONE);
                        entries.add(ModBlocks.FRAMED_TONE);
                        entries.add(ModBlocks.FRAMED_TONE_BRICKS);
                        entries.add(ModBlocks.ZTONE);
                        entries.add(ModBlocks.AURORA);
                        entries.add(ModBlocks.CRT);
                        entries.add(ModBlocks.KEYBOARD);
                        entries.add(ModBlocks.AGED_CRT);
                        entries.add(ModBlocks.AGED_KEYBOARD);
                        entries.add(ModBlocks.BLACK_CRT);
                        entries.add(ModBlocks.BLACK_KEYBOARD);
                        entries.add(ModBlocks.GRAY_CRT);
                        entries.add(ModBlocks.GRAY_KEYBOARD);
                        entries.add(ModBlocks.EMPTY_TIRE);
                        entries.add(ModBlocks.TIRE);
                        entries.add(ModBlocks.CRATE);
                        entries.add(ModBlocks.LITHIUM_ORE);
                        entries.add(ModBlocks.DEEPSLATE_LITHIUM_ORE);
                        entries.add(ModBlocks.ENDSTONE_LITHIUM_ORE);
                        entries.add(ModBlocks.RAW_LITHIUM_BLOCK);
                        entries.add(ModItems.RAW_LITHIUM);
                        entries.add(ModBlocks.LITHIUM_BLOCK);
                        entries.add(ModItems.LITHIUM_INGOT);
                        entries.add(ModItems.LITHIUM_CHUNK);
                        entries.add(ModItems.ANTIBRASS);
                        entries.add(ModItems.CONDUCTIUM);
                        entries.add(ModItems.KERBESIUM);
                        entries.add(ModItems.ORGANIC_BRASS);
                        entries.add(ModItems.MIDASIUM);
                        entries.add(ModItems.TAWSINE);
                        entries.add(ModItems.THINKING_METAL);
                        entries.add(ModItems.ARGON);
                        entries.add(ModItems.OIL);
                        entries.add(ModItems.DIODE);
                        entries.add(ModItems.POLYMER);
                        entries.add(ModItems.SHEETING);
                        entries.add(ModItems.POLYCARBONATE);
                        entries.add(ModItems.GAS_TUBE);
                        entries.add(ModItems.AZURE_RIVET);
                        entries.add(ModItems.GLEAM);
                        entries.add(ModItems.G2V);
                        entries.add(ModItems.SLAG);
                        entries.add(ModItems.RADIUM_PAINT);
                        entries.add(ModItems.FIBROUS_POWDER);
                        entries.add(ModItems.AMALGAM);
                        entries.add(ModItems.PORCELAIN);
                        entries.add(ModItems.SHADE);
                        entries.add(ModItems.SCREEN);
                        entries.add(ModItems.SCARLET_MEMBRANE);
                        entries.add(ModItems.MOULDING);
                        entries.add(ModItems.PLAQUE);
                        entries.add(ModItems.JELLY);
                        entries.add(ModItems.CORPOREAL_VAPOR);
                        entries.add(ModItems.FLAKES);
                        entries.add(ModItems.NETWORKING);
                    }).build());
}
