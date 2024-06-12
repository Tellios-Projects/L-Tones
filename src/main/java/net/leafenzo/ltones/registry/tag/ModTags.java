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
        public static final TagKey<Item> GLASS_PANES = getOrCreateCommonTag("glass_panes");
//        public static final TagKey<Item> MULTIFACE_BLOCKS = getOrCreateCommonTag("multiface_blocks");

        public static final TagKey<Item> AGON_BLOCKS = getOrCreateTag("agon_blocks");
        public static final TagKey<Item> FORT_BLOCKS = getOrCreateTag("fort_blocks");
        public static final TagKey<Item> GLAXX_BLOCKS = getOrCreateTag("glaxx_blocks");
        public static final TagKey<Item> CRAY_BLOCKS = getOrCreateTag("cray_blocks");
        public static final TagKey<Item> CAST_BLOCKS = getOrCreateTag("cast_blocks");
        public static final TagKey<Item> HOST_BLOCKS = getOrCreateTag("host_blocks");
        public static final TagKey<Item> ZANE_BLOCKS = getOrCreateTag("zane_blocks");
        public static final TagKey<Item> VECT_BLOCKS = getOrCreateTag("vect_blocks");
        public static final TagKey<Item> REDDS_BLOCKS = getOrCreateTag("redds_blocks");
        public static final TagKey<Item> MINN_BLOCKS = getOrCreateTag("minn_blocks");
        public static final TagKey<Item> LAIR_BLOCKS = getOrCreateTag("lair_blocks");
        public static final TagKey<Item> KRYP_BLOCKS = getOrCreateTag("kryp_blocks");
        public static final TagKey<Item> LAVE_BLOCKS = getOrCreateTag("lave_blocks");
        public static final TagKey<Item> VEELD_BLOCKS = getOrCreateTag("veeld_blocks");
        public static final TagKey<Item> JELT_BLOCKS = getOrCreateTag("jelt_blocks");
        public static final TagKey<Item> KORP_BLOCKS = getOrCreateTag("korp_blocks");
        public static final TagKey<Item> TANK_BLOCKS = getOrCreateTag("tank_blocks");
        public static final TagKey<Item> EXRI_BLOCKS = getOrCreateTag("exri_blocks");
        public static final TagKey<Item> AZUR_BLOCKS = getOrCreateTag("azur_blocks");
        public static final TagKey<Item> FLEQ_BLOCKS = getOrCreateTag("fleq_blocks");
        public static final TagKey<Item> ISZM_BLOCKS = getOrCreateTag("iszm_blocks");
        public static final TagKey<Item> MYST_BLOCKS = getOrCreateTag("myst_blocks");
        public static final TagKey<Item> SYNC_BLOCKS = getOrCreateTag("sync_blocks");
        public static final TagKey<Item> NURR_BLOCKS = getOrCreateTag("nurr_blocks");
        public static final TagKey<Item> TYEL_BLOCKS = getOrCreateTag("tyel_blocks");
        public static final TagKey<Item> ROEN_BLOCKS = getOrCreateTag("roen_blocks");
        public static final TagKey<Item> SOL_BLOCKS = getOrCreateTag("sol_blocks");


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