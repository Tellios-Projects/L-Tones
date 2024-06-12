package net.leafenzo.ltones.registries;

import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.VillagerInteractionRegistries;
import net.leafenzo.ltones.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.ItemConvertible;


public class ModFabricRegistries {

    public static void registerFlammable(Block block, int burn, int spread) {
        FlammableBlockRegistry flammableBlockRegistry = FlammableBlockRegistry.getDefaultInstance();
        flammableBlockRegistry.add(block, burn, spread);
    }
    public static void registerFuel(ItemConvertible item, int value) {
        FuelRegistry fuelRegistry = FuelRegistry.INSTANCE;
        fuelRegistry.add(item, value);
    }
    public static void registerCompostable(ItemConvertible item, float chance) {
        CompostingChanceRegistry compostingChanceRegistry = CompostingChanceRegistry.INSTANCE;
        compostingChanceRegistry.add(item, chance);
        VillagerInteractionRegistries.registerCompostable(item);
    }

    public static void registerCompostingChances() {
//        CompostingChanceRegistry compostingChanceRegistry = CompostingChanceRegistry.INSTANCE;
    }

    public static void registerOxidizableBlocks() {
        //OxidizableBlocksRegistry.registerOxidizableBlockPair(ModBlocks., ModBlocks.);
    }

    public static void registerFlammableBlocks() {
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();
        //registry.add(ModBlocks.EXAMPLE, 65536, 65536);
    }
}
