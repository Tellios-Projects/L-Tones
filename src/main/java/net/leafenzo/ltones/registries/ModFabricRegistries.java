package net.leafenzo.ltones.registries;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;


public class ModFabricRegistries {
    public static void registerOxidizableBlocks() {
        //OxidizableBlocksRegistry.registerOxidizableBlockPair(ModBlocks., ModBlocks.);
    }

    public static void registerFlammableBlocks() {
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();
        //registry.add(ModBlocks.EXAMPLE, 65536, 65536);
    }
}
