package net.leafenzo.template.datageneration;

//package net.leafenzo.mint.datageneration;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBiomeTags;
import net.leafenzo.template.Super;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.util.Identifier;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {
//    public static final RegistryKey<PlacedFeature> PATCH_EXAMPLE_PLACED = registerKey("patch_example_placed");

    public static void bootstrap(Registerable <PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);


    }

    public static void registerModifications() {
//        BiomeModifications.create(new Identifier(Super.MOD_ID, "overworld_vegetation"))
//                .add(ModificationPhase.ADDITIONS,
//                        BiomeSelectors.includeByKey(BiomeKeys.MEADOW).or(BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_BIRCH_FOREST).or(BiomeSelectors.includeByKey(BiomeKeys.BIRCH_FOREST))),
//                        context -> { context.getGenerationSettings().addFeature(GenerationStep.Feature.VEGETAL_DECORATION, PATCH_WILD_MINT_PLACED); }
//                )

    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Super.MOD_ID, name));
    }

    private static void registerKey(Registerable<PlacedFeature> context, RegistryKey <PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void registerKey(Registerable <PlacedFeature> context, RegistryKey <PlacedFeature> key, RegistryEntry <ConfiguredFeature <?, ?>> configuration, PlacementModifier... modifiers) {
        registerKey(context, key, configuration, List.of(modifiers));
    }
}

