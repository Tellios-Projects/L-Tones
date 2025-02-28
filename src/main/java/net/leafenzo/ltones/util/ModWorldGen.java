package net.leafenzo.ltones.util;

import com.mojang.serialization.Codec;
import net.leafenzo.ltones.ModInit;
import net.leafenzo.ltones.Super;
import net.leafenzo.ltones.datageneration.ModPlacedFeatures;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.minecraft.world.gen.stateprovider.BlockStateProviderType;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

public class ModWorldGen {
    //public static final FoliagePlacerType<HugeWaxcapMushroomFoliagePlacer> HUGE_WAXCAP_MUSHROOM_FOLIAGE_PLACER_TYPE = registerFoliagePlacer("huge_waxcap_mushroom_foliage_placer", HugeWaxcapMushroomFoliagePlacer.CODEC);
//    public static final TreeDecoratorType<HugeWaxcapMushroomDecorator> HUGE_WAXCAP_MUSHROOM_DECORATOR = registerTreeDecorator("huge_waxcap_mushroom_decorator", HugeWaxcapMushroomDecorator.CODEC);
//    public static final TreeDecoratorType<MushroomBlockDirectionDecorator> MUSHROOM_BLOCK_DIRECTION_DECORATOR = registerTreeDecorator("mushroom_block_direction_decorator", MushroomBlockDirectionDecorator.CODEC);
//    public static final FoliagePlacerType<HugeWaxcapMushroomFoliagePlacer> HUGE_WAXCAP_MUSHROOM_FOLIAGE_PLACER = registerFoliagePlacer("huge_waxcap_mushroom_foliage_placer", HugeWaxcapMushroomFoliagePlacer.CODEC);

//    public static final BlockStateProviderType<ModSimpleBlockStateProvider> MOD_SIMPLE_BLOCK_STATE_PROVIDER = BlockStateProviderMixin.callRegister("mod_simple_block_state_provider", ModSimpleBlockStateProvider.CODEC);

    private static <P extends FoliagePlacer> FoliagePlacerType<P> registerFoliagePlacer(String id, Codec<P> codec) {
        return (FoliagePlacerType) Registry.register(Registries.FOLIAGE_PLACER_TYPE, new Identifier(Super.MOD_ID, id), new FoliagePlacerType(codec));
    }
    private static <P extends TrunkPlacer> TrunkPlacerType<P> registerTrunkPlacer(String id, Codec<P> codec) {
        return (TrunkPlacerType)Registry.register(Registries.TRUNK_PLACER_TYPE,  new Identifier(Super.MOD_ID, id), new TrunkPlacerType(codec));
    }
    private static <P extends TreeDecorator> TreeDecoratorType<P> registerTreeDecorator(String id, Codec<P> codec) {
        return (TreeDecoratorType)Registry.register(Registries.TREE_DECORATOR_TYPE,  new Identifier(Super.MOD_ID, id), new TreeDecoratorType(codec));
    }

    public static void registerWorldGen() {
        ModInit.LOGGER.debug("Registering mod world gen for " + Super.MOD_ID);
        ModPlacedFeatures.registerModifications(); // feels a bit wrong calling this here. It should work fine it just feels smelly to me.
    }
}