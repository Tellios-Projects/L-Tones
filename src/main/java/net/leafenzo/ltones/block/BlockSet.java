package net.leafenzo.ltones.block;

import net.leafenzo.ltones.registry.tag.ModTags;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.TagKey;

import java.util.ArrayList;

public class BlockSet {
    public final String name;
    public final TagKey<Block> blockTag;
    public final TagKey<Item> itemTag;
    public ArrayList<Block> blocks;

    public BlockSet(ArrayList<Block> blocks, String name) {
        this.name = name;
        this.blocks = blocks;
        this.blockTag = ModTags.Blocks.getOrCreateTag(name);
        this.itemTag = ModTags.Items.getOrCreateTag(name);
    }
}
