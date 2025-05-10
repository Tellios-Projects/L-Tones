// SOURCE:
// Eko-byte - Nature's Spirit - https://github.com/Team-Hibiscus/NatureSpirit/blob/dev/src/main/java/net/hibiscus/naturespirit/datagen/HibiscusConfiguredFeatures.java
//

package net.leafenzo.ltones.datageneration;

import net.leafenzo.ltones.Super;
import net.leafenzo.ltones.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class ModConfiguredFeatures {

    public static final RegistryKey <ConfiguredFeature <?, ?>> ORE_LUESIUM = registerKey("ore_luesium");
    public static final RegistryKey <ConfiguredFeature <?, ?>> ORE_LUESIUM_END = registerKey("ore_luesium_end");
    public static final RegistryKey <ConfiguredFeature <?, ?>> ORE_TONE = registerKey("ore_tone");
    public static final RegistryKey <ConfiguredFeature <?, ?>> ORE_ZKUL = registerKey("ore_zkul");


    public static void bootstrap(Registerable <ConfiguredFeature <?, ?>> context) {
//        var placedFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);
//        RegistryEntryLookup<Block> holderGetter = context.getRegistryLookup(RegistryKeys.BLOCK);

        TagMatchRuleTest isBaseStoneOverworld = new TagMatchRuleTest(BlockTags.BASE_STONE_OVERWORLD);
        TagMatchRuleTest isStone = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        TagMatchRuleTest isDeepslate = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        BlockMatchRuleTest isNetherrack = new BlockMatchRuleTest(Blocks.NETHERRACK);
        TagMatchRuleTest isBaseStoneNether = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        BlockMatchRuleTest isEndstone = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> overworldLuesiumTargets = List.of(
                OreFeatureConfig.createTarget(isStone, ModBlocks.LUESIUM_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(isDeepslate, ModBlocks.DEEPSLATE_LUESIUM_ORE.getDefaultState())
        );
        register(context, ORE_LUESIUM, Feature.ORE, new OreFeatureConfig(overworldLuesiumTargets, 5));

        List<OreFeatureConfig.Target> endLuesiumTargets = List.of(
                OreFeatureConfig.createTarget(isEndstone, ModBlocks.ENDSTONE_LUESIUM_ORE.getDefaultState())
        );
        register(context, ORE_LUESIUM_END, Feature.ORE, new OreFeatureConfig(endLuesiumTargets, 5));

        List<OreFeatureConfig.Target> toneTargets = List.of(
                OreFeatureConfig.createTarget(isBaseStoneOverworld, ModBlocks.TONE.getDefaultState())
        );
        register(context, ORE_TONE, Feature.ORE, new OreFeatureConfig(toneTargets, 64));

        List<OreFeatureConfig.Target> overworldZkulTargets = List.of(
                OreFeatureConfig.createTarget(isDeepslate, ModBlocks.ZKUL.getDefaultState())
        );
        register(context, ORE_ZKUL, Feature.ORE, new OreFeatureConfig(overworldZkulTargets, 1)); //TODO: redo this to not be shit

    }
    private static <FC extends FeatureConfig, F extends Feature <FC>> void register(Registerable <ConfiguredFeature <?, ?>> context, RegistryKey <ConfiguredFeature <?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature <>(feature, configuration));
    }

    public static RegistryKey <ConfiguredFeature <?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(Super.MOD_ID, name));
    }

}
