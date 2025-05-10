package net.leafenzo.ltones.datageneration;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.leafenzo.ltones.Super;
import net.leafenzo.ltones.block.ModBlocks;
import net.leafenzo.ltones.item.ModItems;
import net.leafenzo.ltones.util.ModUtil;
import net.minecraft.block.Block;
import net.minecraft.block.MultifaceGrowthBlock;
import net.minecraft.data.server.loottable.vanilla.VanillaBlockLootTableGenerator;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {
    public static final ArrayList<Block> usedBlocks = new ArrayList<Block>();

    public void addDrop(Block block, ItemConvertible drop) {
        this.addDrop(block, this.drops(drop));
        usedBlocks.add(block);
    }
    public void addDrop(Block block, Function<Block, LootTable.Builder> lootTableFunction) {
        addDrop(block, lootTableFunction.apply(block));
        usedBlocks.add(block);
    }
    public void addDrop(Block block) {
        addDrop(block, block);
        usedBlocks.add(block);
    }
    public void addDrop(Block block, LootTable.Builder lootTable) {
        this.lootTables.put(block.getLootTableKey(), lootTable);
        usedBlocks.add(block);
    }

    public ModLootTableGenerator(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> future) {
        super(dataOutput, future);

    }

    public LootTable.Builder decalDrops(Block drop) { // similar to BlockLootTableGenerator.multifaceGrowthDrops
        return LootTable.builder().pool(LootPool.builder()
                .with((LootPoolEntry.Builder)this.applyExplosionDecay(drop, ((LeafEntry.Builder)((LeafEntry.Builder) ItemEntry.builder(drop))
                        .apply(Direction.values(), direction -> SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f), true)
                        .conditionally(BlockStatePropertyLootCondition.builder(drop).properties(StatePredicate.Builder.create().exactMatch(MultifaceGrowthBlock.getProperty((Direction) direction), true)))))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(-1.0f), true)))));
    }


    @Override
    public void generate() {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        this.addDrop(ModBlocks.LUESIUM_ORE, (Block block) -> this.oreDrops(block, ModItems.RAW_LUESIUM));
        this.addDrop(ModBlocks.DEEPSLATE_LUESIUM_ORE, (Block block) -> this.oreDrops(block, ModItems.RAW_LUESIUM));
        this.addDrop(ModBlocks.ENDSTONE_LUESIUM_ORE, (Block block) -> this.dropsWithSilkTouch(block, this.applyExplosionDecay(block, ItemEntry.builder(ModItems.LUESIUM_CHUNK).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 6.0F))).apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE))))));
        this.addDrop(ModBlocks.CRATE, (Block block) -> this.nameableContainerDrops(block));

        for(Block block : ModBlocks.DECAL_BLOCKS) {
            this.addDrop(block, (Block b) -> this.decalDrops(b));
        }

        for(Block block : ModBlocks.SLAB_FROM_BLOCK.values()) {
            this.addDrop(block, (Block b) -> this.slabDrops(b));
        }

        for(Block block : ModBlocks.DOORS) {
            this.addDrop(block, (Block b) -> this.doorDrops(b));
        }

        //Fallback
        for(Identifier id : ModUtil.allBlockIdsInNamespace(Super.MOD_ID)) {
            Block block = Registries.BLOCK.get(id);
            if(usedBlocks.contains(block)) { continue; }
            this.addDrop(block);
        }
    }
}
