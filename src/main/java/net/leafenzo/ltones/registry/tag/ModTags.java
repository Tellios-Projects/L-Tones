package net.leafenzo.ltones.registry.tag;

import net.leafenzo.ltones.Super;
import net.minecraft.block.Block;
import net.minecraft.item.DyeItem;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> IGNEOUS_ROCKS = getOrCreateTag("igneous_rocks");

        public static TagKey<Block> getOrCreateTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(Super.MOD_ID, name));
        }
        private static TagKey<Block> getOrCreateCommonTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier("c", name));
        }
    }
    public static class Items {
        public static final TagKey<Item> IGNEOUS_ROCKS = getOrCreateTag("igneous_rocks");
        public static final TagKey<Item> FIBRE = getOrCreateTag("fibre");
        public static final TagKey<Item> MUSHROOMS = getOrCreateCommonTag("mushrooms");

        public static TagKey<Item> getOrCreateTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(Super.MOD_ID, name));
        }
        public static TagKey<Item> getOrCreateCommonTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier("c", name));
        }
        public static TagKey<Item> getOrCreateDyeItemCommonTag(DyeItem item) {
            return getOrCreateCommonTag(item.getColor().getName()+"_dyes");
        }
    }
}