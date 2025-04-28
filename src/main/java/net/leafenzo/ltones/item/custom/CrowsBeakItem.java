package net.leafenzo.ltones.item.custom;

import net.leafenzo.ltones.registry.tag.ModTags;
import net.minecraft.item.*;

public class CrowsBeakItem extends MiningToolItem {
    public CrowsBeakItem(ToolMaterial material, int attackDamage, float attackSpeed, Item.Settings settings) {
        super(attackDamage, attackSpeed, material, ModTags.Blocks.CROWS_BEAK_MINEABLE, settings);
    }
}

