package net.leafenzo.ltones.item;


import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.leafenzo.ltones.ModInit;
import net.leafenzo.ltones.Super;
import net.leafenzo.ltones.block.ModBlocks;
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
                    .icon(() -> new ItemStack(ModBlocks.REDDS)).entries((displayContext, entries) -> {
                     entries.add(ModBlocks.REDDS);
                    }).build());
}
