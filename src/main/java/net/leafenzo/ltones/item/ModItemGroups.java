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

public class ModItemGroups {
    public static void registerModItemGroups() {
        ModInit.LOGGER.debug("Registering item groups for " + Super.MOD_ID);
    }

    public static ItemGroup LTONES = Registry.register(Registries.ITEM_GROUP, new Identifier(Super.MOD_ID, "ltones"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ltones"))
                    .icon(() -> new ItemStack(ModBlocks.REDDS_TILE)).entries((displayContext, entries) -> {
                        for(Block block : ModBlocks.AGON_BLOCKS) { entries.add(block); }
                        for(Block block : ModBlocks.FORT_BLOCKS) { entries.add(block); }
                        for(Block block : ModBlocks.GLAXX_BLOCKS) { entries.add(block); }
                        for(Block block : ModBlocks.CRAY_BLOCKS) { entries.add(block); }
                        for(Block block : ModBlocks.CAST_BLOCKS) { entries.add(block); }
                        for(Block block : ModBlocks.HOST_BLOCKS) { entries.add(block); }
                        for(Block block : ModBlocks.ZANE_BLOCKS) { entries.add(block); }
                        for(Block block : ModBlocks.ISZM_BLOCKS) { entries.add(block); }
                        for(Block block : ModBlocks.MYST_BLOCKS) { entries.add(block); }
                        for(Block block : ModBlocks.NURR_BLOCKS) { entries.add(block); }
                        for(Block block : ModBlocks.TYEL_BLOCKS) { entries.add(block); }
                        for(Block block : ModBlocks.VECT_BLOCKS) { entries.add(block); }
                        for(Block block : ModBlocks.REDDS_BLOCKS) { entries.add(block); }
                        for(Block block : ModBlocks.MINN_BLOCKS) { entries.add(block); }
                        for(Block block : ModBlocks.LAIR_BLOCKS) { entries.add(block); }
                        for(Block block : ModBlocks.KRYP_BLOCKS) { entries.add(block); }
                        for(Block block : ModBlocks.LAVE_BLOCKS) { entries.add(block); }
                        for(Block block : ModBlocks.VEELD_BLOCKS) { entries.add(block); }
                        for(Block block : ModBlocks.JELT_BLOCKS) { entries.add(block); }
                        for(Block block : ModBlocks.KORP_BLOCKS) { entries.add(block); }
                        for(Block block : ModBlocks.TANK_BLOCKS) { entries.add(block); }
                        for(Block block : ModBlocks.EXRI_BLOCKS) { entries.add(block); }
                        for(Block block : ModBlocks.AZUR_BLOCKS) { entries.add(block); }
                        for(Block block : ModBlocks.FLEQ_BLOCKS) { entries.add(block); }
                        for(Block block : ModBlocks.SYNC_BLOCKS) { entries.add(block); }
                        for(Block block : ModBlocks.ROEN_BLOCKS) { entries.add(block); }
                        for(Block block : ModBlocks.SOL_BLOCKS) { entries.add(block); }
                        entries.add(ModBlocks.ZTONE);
                        entries.add(ModItems.RAW_LITHIUM);
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
