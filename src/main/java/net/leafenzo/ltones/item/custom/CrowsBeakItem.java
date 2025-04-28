package net.leafenzo.ltones.item.custom;

import net.leafenzo.ltones.registry.tag.ModTags;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;

public class CrowsBeakItem extends MiningToolItem {
    public CrowsBeakItem(int attackDamage, float attackSpeed, Item.Settings settings) {
        super(attackDamage, attackSpeed, new ToolMaterial() {
            @Override
            public int getDurability() {
                return 752;
            }

            @Override
            public float getMiningSpeedMultiplier() {
                return 7.0f;
            }

            @Override
            public float getAttackDamage() {
                return 2.5f;
            }

            @Override
            public int getMiningLevel() {
                return 3;
            }

            @Override
            public int getEnchantability() {
                return 20;
            }

            @Override
            public Ingredient getRepairIngredient() {
                return Ingredient.ofItems(Items.NETHERITE_SCRAP);
            }
        }, ModTags.Blocks.CROWS_BEAK_MINEABLE, settings);
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        if (state.toString().contains("ltones:") && !state.isIn(ModTags.Blocks.NOT_INSTAMINE_CROWS_BEAK)) {
            return 15000f;
        } else if (state.isIn(ModTags.Blocks.CROWS_BEAK_MINEABLE) && !state.isIn(BlockTags.NEEDS_DIAMOND_TOOL)) {
            return 7.0f;
        }
        return 1.0f;
    }
}

