// SOURCE:
// Eko-byte - Nature's Spirit - https://github.com/Team-Hibiscus/NatureSpirit/blob/dev/src/main/java/net/hibiscus/naturespirit/datagen/HibiscusConfiguredFeatures.java
//

package net.leafenzo.template.datageneration;

import net.leafenzo.template.Super;
import net.minecraft.block.*;
import net.minecraft.block.enums.SlabType;
import net.minecraft.fluid.Fluids;
import net.minecraft.registry.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.state.property.Properties;
import net.minecraft.structure.rule.BlockStateMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.intprovider.BiasedToBottomIntProvider;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.*;
import net.minecraft.world.gen.placementmodifier.BlockFilterPlacementModifier;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.NoiseThresholdBlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;
import java.util.OptionalInt;
import java.util.Random;

public class ModConfiguredFeatures {

//    public static final RegistryKey <ConfiguredFeature <?, ?>> PATCH_EXAMPLE = registerKey("patch_example");

    public static void bootstrap(Registerable <ConfiguredFeature <?, ?>> context) {
//        var placedFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);
//        RegistryEntryLookup<Block> holderGetter = context.getRegistryLookup(RegistryKeys.BLOCK);

    }
    private static <FC extends FeatureConfig, F extends Feature <FC>> void register(Registerable <ConfiguredFeature <?, ?>> context, RegistryKey <ConfiguredFeature <?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature <>(feature, configuration));
    }

    public static RegistryKey <ConfiguredFeature <?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Super.MOD_ID, name));
    }

//    public static void registerConfiguredFeatures() {
//        System.out.println("Registering Configured Features For:" + Super.MOD_ID);
//    }

}
