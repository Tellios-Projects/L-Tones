package net.leafenzo.template.item;


import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.leafenzo.template.ModInit;
import net.leafenzo.template.Super;
import net.leafenzo.template.block.ModBlocks;
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

    public static ItemGroup TEMPLATE = Registry.register(Registries.ITEM_GROUP, new Identifier(Super.MOD_ID, "template"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.template"))
                    .icon(() -> new ItemStack(Blocks.AIR)).entries((displayContext, entries) -> {
                     //entries.add(ModBlocks.);
                    }).build());
}
