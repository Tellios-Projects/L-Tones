// SOURCE:
// Eko-byte - Nature's Spirit - https://github.com/Team-Hibiscus/NatureSpirit/blob/dev/src/main/java/net/hibiscus/naturespirit/datagen/HibiscusConfiguredFeatures.java
//

package net.leafenzo.ltones.datageneration;

import net.leafenzo.ltones.Super;
import net.leafenzo.ltones.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;

import java.util.List;

public class ModConfiguredFeatures {

    public static final RegistryKey <ConfiguredFeature <?, ?>> ORE_LITHIUM = registerKey("ore_lithium");
    public static final RegistryKey <ConfiguredFeature <?, ?>> ORE_LITHIUM_END = registerKey("ore_lithium_end");
    public static final RegistryKey <ConfiguredFeature <?, ?>> ORE_TONE = registerKey("ore_tone");


    public static void bootstrap(Registerable <ConfiguredFeature <?, ?>> context) {
//        var placedFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);
//        RegistryEntryLookup<Block> holderGetter = context.getRegistryLookup(RegistryKeys.BLOCK);

        TagMatchRuleTest isBaseStoneOverworld = new TagMatchRuleTest(BlockTags.BASE_STONE_OVERWORLD);
        TagMatchRuleTest isStone = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        TagMatchRuleTest isDeepslate = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        BlockMatchRuleTest isNetherrack = new BlockMatchRuleTest(Blocks.NETHERRACK);
        TagMatchRuleTest isBaseStoneNether = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        BlockMatchRuleTest isEndstone = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> overworldLithiumTargets = List.of(
                OreFeatureConfig.createTarget(isStone, ModBlocks.LITHIUM_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(isDeepslate, ModBlocks.DEEPSLATE_LITHIUM_ORE.getDefaultState())
        );
        register(context, ORE_LITHIUM, Feature.ORE, new OreFeatureConfig(overworldLithiumTargets, 5));

        List<OreFeatureConfig.Target> endLithiumTargets = List.of(
                OreFeatureConfig.createTarget(isEndstone, ModBlocks.ENDSTONE_LITHIUM_ORE.getDefaultState())
        );
        register(context, ORE_LITHIUM_END, Feature.ORE, new OreFeatureConfig(endLithiumTargets, 5));

        List<OreFeatureConfig.Target> toneTargets = List.of(
                OreFeatureConfig.createTarget(isBaseStoneOverworld, ModBlocks.TONE.getDefaultState())
        );
        register(context, ORE_TONE, Feature.ORE, new OreFeatureConfig(toneTargets, 64));

    }
    private static <FC extends FeatureConfig, F extends Feature <FC>> void register(Registerable <ConfiguredFeature <?, ?>> context, RegistryKey <ConfiguredFeature <?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature <>(feature, configuration));
    }

    public static RegistryKey <ConfiguredFeature <?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Super.MOD_ID, name));
    }

}
