package net.leafenzo.ltones.datageneration;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

import net.leafenzo.ltones.Super;
import net.leafenzo.ltones.block.ModBlocks;
import net.leafenzo.ltones.util.ModUtil;
import net.minecraft.block.Block;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Debug;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static net.leafenzo.ltones.util.ModUtil.toSentanceCase;

public class ModEnglishLangProvider extends FabricLanguageProvider {
    Set<String> usedTranslationKeys = new HashSet<String>(); // For duplicate handling

    public ModEnglishLangProvider(FabricDataOutput dataGenerator) {
        super(dataGenerator, "en_us");
    }
    private void generateTranslation(TranslationBuilder translationBuilder, String key, String translation) {
        if(usedTranslationKeys.contains(key)) {
            //("Duplicate translation key " + key + "ignored");
            return;
        }
        translationBuilder.add(key, translation);
        usedTranslationKeys.add(key);
    }
    private void generateTranslation(TranslationBuilder translationBuilder, Block block, String translation) {
        generateTranslation(translationBuilder, block.getTranslationKey(), translation);
    }
    private void generateTranslation(TranslationBuilder translationBuilder, Item item, String translation) {
        generateTranslation(translationBuilder, item.getTranslationKey(), translation);
    }
    private void generatePotionTranslation(TranslationBuilder translationBuilder,  String subKey, String effectName) {
        String potionKey = "item.minecraft.potion.effect." + subKey;
        generateTranslation(translationBuilder, potionKey, "Potion of " + effectName);

        String splashPotionKey = "item.minecraft.splash_potion.effect." + subKey;
        generateTranslation(translationBuilder, splashPotionKey, "Splash Potion of " + effectName);

        String lingeringPotionKey = "item.minecraft.lingering_potion.effect." + subKey;
        generateTranslation(translationBuilder, lingeringPotionKey, "Lingering Potion of " + effectName);

        String arrowKey = "item.minecraft.tipped_arrow.effect." + subKey;
        generateTranslation(translationBuilder, arrowKey, "Arrow of " + effectName);
    }

    /**
     * Can be necessary to run before automatic translation building to avoid wall banner nonsense
     * @param translationBuilder
     * @param BannerBlocks
     */
    private void generateBannerTranslations(TranslationBuilder translationBuilder, ArrayList<Block> BannerBlocks) {
        for(Block block : BannerBlocks) {
            generateTranslation(translationBuilder, block.getTranslationKey(), toSentanceCase(Registries.BLOCK.getId(block).getPath()));
        }
    }
    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        //Manual
        //<editor-fold desc ="EnglishLang - Manual Translations">
        generateTranslation(translationBuilder, ModBlocks.RAW_LITHIUM_BLOCK, "Block of Raw Lithium");
        generateTranslation(translationBuilder, ModBlocks.CRT, "CRT Monitor");
        generateTranslation(translationBuilder, ModBlocks.AGED_CRT, "Aged CRT Monitor");
        generateTranslation(translationBuilder, ModBlocks.BLACK_CRT, "Black CRT Monitor");
        generateTranslation(translationBuilder, ModBlocks.GRAY_CRT, "Gray CRT Monitor");





        //</editor-fold
        //<editor-fold desc ="EnglishLang - Fallback">
        for(Identifier id : ModUtil.allBlockIdsInNamespace(Super.MOD_ID)) {
            String key = Registries.BLOCK.get(id).getTranslationKey();
            if(usedTranslationKeys.contains(key)) { continue; } //Skip over duplicate translation keys
            usedTranslationKeys.add(key);
            translationBuilder.add(key, toSentanceCase(id.getPath()));
        }
        for(Identifier id : ModUtil.allItemIdsInNamespace(Super.MOD_ID)) {
            String key = Registries.ITEM.get(id).getTranslationKey();
            if(usedTranslationKeys.contains(key)) { continue; } //Skip over duplicate translation keys
            usedTranslationKeys.add(key);
            translationBuilder.add(key, toSentanceCase(id.getPath()));
        }
        for(Identifier id : ModUtil.allItemGroupIdsInNamespace(Super.MOD_ID)) {
            String key = Registries.ITEM_GROUP.get(id).getDisplayName().getString();
            if(usedTranslationKeys.contains(key)) { continue; } //Skip over duplicate translation keys
            usedTranslationKeys.add(key);
            translationBuilder.add(key, toSentanceCase(id.getPath()));
        }
        for(Identifier id : ModUtil.allStatusEffectIdsInNamespace(Super.MOD_ID)) {
            String key = Registries.STATUS_EFFECT.get(id).getTranslationKey();
            if(usedTranslationKeys.contains(key)) { continue; } //Skip over duplicate translation keys
            usedTranslationKeys.add(key);
            translationBuilder.add(key, toSentanceCase(id.getPath()));
        }
        // This is a mess, just do this part manually for now.
        // Effects, Potions, and Tipped arrows
//        for(Identifier id : ModUtil.allPotionIdsInNamespace(Super.MOD_ID)) {
//            String key = Registries.POTION.get(id).finishTranslationKey("item.minecraft.potion.effect."); // what does this even do
//            if(usedTranslationKeys.contains(key)) { continue; } //Skip over duplicate translation keys
//            usedTranslationKeys.add(key);
//
//            String effectName = Registries.POTION.get(id).getEffects().get(0).getEffectType().getName().toString());
//
//            // Potion
//            translationBuilder.add(key, "Potion of " + effectName);
//
//            // Tipped Arrow
//            String arrowKey = "item.minecraft.tipped_arrow.effect.";
//            arrowKey = arrowKey.concat(Pattern.compile("(?<=potion\\.)[^.]+").matcher(key).toString());
//            translationBuilder.add(arrowKey, "Arrow of " + toSentanceCase(effectName));
//        }
        //</editor-fold
    }
}