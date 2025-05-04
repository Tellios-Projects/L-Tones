package net.leafenzo.ltones.datageneration;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

import net.leafenzo.ltones.Super;
import net.leafenzo.ltones.block.ModBlocks;
import net.leafenzo.ltones.item.ModItems;
import net.leafenzo.ltones.util.ModUtil;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static net.leafenzo.ltones.util.ModUtil.toSentenceCase;

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
            generateTranslation(translationBuilder, block.getTranslationKey(), toSentenceCase(Registries.BLOCK.getId(block).getPath()));
        }
    }
    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        //Manual
        //<editor-fold desc ="EnglishLang - Manual Translations">

        generateTranslation(translationBuilder, "itemgroup.ltones", "L-Tones");
        generateTranslation(translationBuilder, "subtitles.block.keyboard.click", "Keyboard clicks");
        generateTranslation(translationBuilder, "subtitles.block.mouse.click", "Mouse clicks");
        generateTranslation(translationBuilder, "subtitles.block.switch.toggle", "Switch clicks");
        generateTranslation(translationBuilder, "subtitles.block.pc.toggle", "PC clicks");
        generateTranslation(translationBuilder, ModBlocks.RAW_LUESIUM_BLOCK, "Block of Raw Luesium");
        generateTranslation(translationBuilder, ModBlocks.LUESIUM_BLOCK, "Block of Luesium");
        generateTranslation(translationBuilder, ModBlocks.ANTIBRASS_BLOCK, "Block of Antibrass");
        generateTranslation(translationBuilder, ModBlocks.CRT, "CRT Monitor");
        generateTranslation(translationBuilder, ModBlocks.AGED_CRT, "Aged CRT Monitor");
        generateTranslation(translationBuilder, ModBlocks.BLACK_CRT, "Black CRT Monitor");
        generateTranslation(translationBuilder, ModBlocks.GRAY_CRT, "Gray CRT Monitor");
        generateTranslation(translationBuilder, ModBlocks.PC, "PC Tower");
        generateTranslation(translationBuilder, ModBlocks.AGED_PC, "Aged PC Tower");
        generateTranslation(translationBuilder, ModBlocks.BLACK_PC, "Black PC Tower");
        generateTranslation(translationBuilder, ModBlocks.GRAY_PC, "Gray PC Tower");
        generateTranslation(translationBuilder, "container.crate", "Crate");
        generateTranslation(translationBuilder, ModItems.CROWS_BEAK, "Crow's Beak");
        generateTranslation(translationBuilder, ModItems.PCB_BOARD, "PCB_Board");

        generateTranslation(translationBuilder, ModBlocks.ROST_RUST, "Rusted Rost");
        generateTranslation(translationBuilder, ModBlocks.ROST_CAGE_RUST, "Rusted Rost Cage");
        generateTranslation(translationBuilder, ModBlocks.ROST_CORRIGOR_RUST, "Rusted Rost Corrigor");
        generateTranslation(translationBuilder, ModBlocks.ROST_CRETE_RUST, "Rusted Rost Crete");
        generateTranslation(translationBuilder, ModBlocks.ROST_LINOLEUM_RUST, "Rusted Rost Linoleum");
        generateTranslation(translationBuilder, ModBlocks.ROST_MOUND_RUST, "Rusted Rost Mound");
        generateTranslation(translationBuilder, ModBlocks.ROST_PEEL_RUST, "Rusted Rost Peel");
        generateTranslation(translationBuilder, ModBlocks.ROST_PLATES_RUST, "Rusted Rost Plates");
        generateTranslation(translationBuilder, ModBlocks.ROST_REBAR_RUST, "Rusted Rost Rebar");
        generateTranslation(translationBuilder, ModBlocks.ROST_RIBBING_RUST, "Rusted Rost Ribbing");
        generateTranslation(translationBuilder, ModBlocks.ROST_SHIELDED_RUST, "Rusted Rost Shielding");
        generateTranslation(translationBuilder, ModBlocks.ROST_SMOTHERED_RUST, "Rusted Rost Smothered");
        generateTranslation(translationBuilder, ModBlocks.ROST_TUNNEL_RUST, "Rusted Rost Tunnel");
        generateTranslation(translationBuilder, ModBlocks.ROST_VEIN_RUST, "Rusted Rost Vein");
        generateTranslation(translationBuilder, ModBlocks.ROST_VELLUM_RUST, "Rusted Rost Vellum");
        generateTranslation(translationBuilder, ModBlocks.ROST_WALLPAPER_RUST, "Rusted Rost Wallpaper");

        //</editor-fold
        //<editor-fold desc ="EnglishLang - Fallback">
        for(Identifier id : ModUtil.allBlockIdsInNamespace(Super.MOD_ID)) {
            String key = Registries.BLOCK.get(id).getTranslationKey();
            if(usedTranslationKeys.contains(key)) { continue; } //Skip over duplicate translation keys
            usedTranslationKeys.add(key);
            translationBuilder.add(key, toSentenceCase(id.getPath()));
        }
        for(Identifier id : ModUtil.allItemIdsInNamespace(Super.MOD_ID)) {
            String key = Registries.ITEM.get(id).getTranslationKey();
            if(usedTranslationKeys.contains(key)) { continue; } //Skip over duplicate translation keys
            usedTranslationKeys.add(key);
            translationBuilder.add(key, toSentenceCase(id.getPath()));
        }
        for(Identifier id : ModUtil.allItemGroupIdsInNamespace(Super.MOD_ID)) {
            String key = Registries.ITEM_GROUP.get(id).getDisplayName().getString();
            if(usedTranslationKeys.contains(key)) { continue; } //Skip over duplicate translation keys
            usedTranslationKeys.add(key);
            translationBuilder.add(key, toSentenceCase(id.getPath()));
        }
        for(Identifier id : ModUtil.allStatusEffectIdsInNamespace(Super.MOD_ID)) {
            String key = Registries.STATUS_EFFECT.get(id).getTranslationKey();
            if(usedTranslationKeys.contains(key)) { continue; } //Skip over duplicate translation keys
            usedTranslationKeys.add(key);
            translationBuilder.add(key, toSentenceCase(id.getPath()));
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