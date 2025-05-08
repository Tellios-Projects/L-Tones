package net.leafenzo.ltones.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent SUGARING_PASTE = (new FoodComponent.Builder()).hunger(0).saturationModifier(0.3F).snack().statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200, 0), 1.0F).build();
    public static final FoodComponent PACKAGED_MEAL = (new FoodComponent.Builder()).hunger(4).saturationModifier(0.8F).build();

    public ModFoodComponents() {
    }
}
