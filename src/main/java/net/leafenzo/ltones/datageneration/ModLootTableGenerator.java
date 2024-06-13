package net.leafenzo.ltones.datageneration;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.leafenzo.ltones.Super;
import net.leafenzo.ltones.block.ModBlocks;
import net.leafenzo.ltones.item.ModItems;
import net.leafenzo.ltones.util.ModUtil;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MultifaceGrowthBlock;
import net.minecraft.data.server.loottable.vanilla.VanillaBlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.ArrayList;
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
        this.lootTables.put(block.getLootTableId(), lootTable);
        usedBlocks.add(block);
    }

    public ModLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
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
        this.addDrop(ModBlocks.LITHIUM_ORE, (Block block) -> this.oreDrops((Block)block, ModItems.RAW_LITHIUM));
        this.addDrop(ModBlocks.DEEPSLATE_LITHIUM_ORE, (Block block) -> this.oreDrops((Block)block, ModItems.RAW_LITHIUM));
        this.addDrop(ModBlocks.ENDSTONE_LITHIUM_ORE, (Block block) -> VanillaBlockLootTableGenerator.dropsWithSilkTouch(block, (LootPoolEntry.Builder)this.applyExplosionDecay((ItemConvertible)block, ((LeafEntry.Builder)ItemEntry.builder(ModItems.LITHIUM_CHUNK).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 6.0f)))).apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE)))));

        for(Block block : ModBlocks.DECAL_BLOCKS) {
            this.addDrop(block, (Block b) -> this.decalDrops((Block) b));
        }

        for(Block block : ModBlocks.SLAB_FROM_BLOCK.values()) {
            this.addDrop(block, (Block b) -> this.slabDrops((Block) b));
        }

        for(Block block : ModBlocks.DOORS) {
            this.addDrop(block, (Block b) -> this.doorDrops((Block) b));
        }

        //Fallback
        for(Identifier id : ModUtil.allBlockIdsInNamespace(Super.MOD_ID)) {
            Block block = Registries.BLOCK.get(id);
            if(usedBlocks.contains(block)) { continue; }
            this.addDrop(block);
        }
    }
}
