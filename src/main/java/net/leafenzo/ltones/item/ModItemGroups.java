package net.leafenzo.ltones.item;


import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.leafenzo.ltones.ModInit;
import net.leafenzo.ltones.Super;
import net.leafenzo.ltones.block.ModBlocks;
import net.leafenzo.ltones.util.ModUtil;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
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
                    }).build());
}
