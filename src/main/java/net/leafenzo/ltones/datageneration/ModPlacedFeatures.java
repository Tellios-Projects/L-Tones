package net.leafenzo.ltones.datageneration;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBiomeTags;
import net.leafenzo.ltones.Super;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> ORE_LITHIUM_PLACED = registerKey("ore_lithium_placed");
    public static final RegistryKey<PlacedFeature> ORE_LITHIUM_LOWER_PLACED = registerKey("ore_lithium_lower_placed");
    public static final RegistryKey<PlacedFeature> ORE_LITHIUM_END_PLACED = registerKey("ore_lithium_end_placed");

    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }
    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }
    private static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier) {
        return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
    }

    public static void bootstrap(Registerable <PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        registerKey(context, ORE_LITHIUM_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ORE_LITHIUM),
                modifiersWithCount(31, HeightRangePlacementModifier.trapezoid(YOffset.fixed(-144), YOffset.fixed(80))) // interestingly, it seems that 256 is the limit of how many veins you can have in a chunk
        );

        registerKey(context, ORE_LITHIUM_LOWER_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ORE_LITHIUM),
                modifiersWithCount(43, HeightRangePlacementModifier.trapezoid(YOffset.fixed(-96), YOffset.fixed(-32))) // interestingly, it seems that 256 is the limit of how many veins you can have in a chunk
        );

        registerKey(context, ORE_LITHIUM_END_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ORE_LITHIUM_END),
                modifiersWithCount(123, HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(40)))
        );
    }

    public static void registerModifications() {
        BiomeModifications.create(new Identifier(Super.MOD_ID, "overworld_additions"))
                .add(ModificationPhase.ADDITIONS,
                BiomeSelectors.foundInOverworld(),
                context -> { context.getGenerationSettings().addFeature(GenerationStep.Feature.UNDERGROUND_ORES, ORE_LITHIUM_PLACED); }
                )
                .add(ModificationPhase.ADDITIONS,
                        BiomeSelectors.foundInOverworld(),
                        context -> { context.getGenerationSettings().addFeature(GenerationStep.Feature.UNDERGROUND_ORES, ORE_LITHIUM_LOWER_PLACED); }
                );

        BiomeModifications.create(new Identifier(Super.MOD_ID, "end_additions"))
                .add(ModificationPhase.ADDITIONS,
                BiomeSelectors.foundInTheEnd(),
                context -> { context.getGenerationSettings().addFeature(GenerationStep.Feature.UNDERGROUND_ORES, ORE_LITHIUM_END_PLACED); }
                );
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

