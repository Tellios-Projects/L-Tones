package net.leafenzo.ltones;

import net.fabricmc.api.ModInitializer;
import net.leafenzo.ltones.block.ModBlocks;
import net.leafenzo.ltones.block.entity.ModBlockEntityType;
import net.leafenzo.ltones.item.ModItemGroups;
import net.leafenzo.ltones.item.ModItems;
import net.leafenzo.ltones.particle.ModParticleTypes;
import net.leafenzo.ltones.registries.ModFabricRegistries;
import net.leafenzo.ltones.stat.ModStats;
import net.leafenzo.ltones.util.ModWorldGen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModInit implements ModInitializer {
    public static final String MOD_ID = Super.MOD_ID;
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        ModBlocks.registerModBlocks();
        ModItems.registerModItems();
//        ModBlockEntityType.RegisterModBlockEntityTypes();
        ModParticleTypes.registerModParticleTypes();
        ModFabricRegistries.registerFlammableBlocks();
//        ModFabricRegistries.registerCompostingChances();
//        ModFabricRegistries.registerVillagerInteractions();
//        ModFabricRegistries.registerFuels();
//        DispenserBehavior.RegisterDispenserBehaviors();
//        ModRecipeSerializer.registerModRecipeSerializer();
//        ModEffects.registerModEffects();
//        ModPotions.registerModPotions();
        ModBlockEntityType.registerModBlockEntityTypes();
        ModStats.registerModStats();
        ModWorldGen.registerWorldGen();
        ModItemGroups.registerModItemGroups();
    }
}

