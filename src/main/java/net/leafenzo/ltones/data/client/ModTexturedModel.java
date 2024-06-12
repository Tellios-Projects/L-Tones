package net.leafenzo.ltones.data.client;

import net.minecraft.block.Block;
import net.minecraft.data.client.TextureKey;
import net.minecraft.data.client.TextureMap;
import net.minecraft.data.client.TexturedModel;

public class ModTexturedModel {

    public static final TexturedModel.Factory ORIENTABLE_TOP_BOTTOM_SIDE_BACK = TexturedModel.makeFactory(ModTexturedModel::orientableTopBottomSideBack, ModModels.ORIENTABLE_TOP_BOTTOM_SIDE_BACK);
    public static final TexturedModel.Factory CRT = TexturedModel.makeFactory(ModTexturedModel::orientableTopBottomSideBack, ModModels.CRT);

    public static TextureMap orientableTopBottomSideBack(Block block) {
        return  new TextureMap()
                .put(TextureKey.TOP, TextureMap.getSubId(block, "_top"))
                .put(TextureKey.BOTTOM, TextureMap.getSubId(block, "_bottom"))
                .put(TextureKey.SIDE, TextureMap.getSubId(block, "_side"))
                .put(TextureKey.FRONT, TextureMap.getSubId(block, "_front"))
                .put(TextureKey.BACK, TextureMap.getSubId(block, "_back"))
                ;
    }
}
