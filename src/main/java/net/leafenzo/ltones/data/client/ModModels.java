package net.leafenzo.ltones.data.client;

import net.leafenzo.ltones.Super;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.TextureKey;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModels {
    public static final Model DECAL = block(Super.MOD_ID + ":block/decal", TextureKey.PARTICLE, TextureKey.ALL);
    public static final Model ORIENTABLE_TOP_BOTTOM_SIDE_BACK = block(Super.MOD_ID + ":block/orientable_top_bottom_side_back", TextureKey.TOP, TextureKey.BOTTOM, TextureKey.SIDE, TextureKey.FRONT, TextureKey.BACK);
    public static final Model CRT = block(Super.MOD_ID + ":block/crt_template", TextureKey.TOP, TextureKey.BOTTOM, TextureKey.SIDE, TextureKey.FRONT, TextureKey.BACK);
    public static final Model KEYBOARD = block(Super.MOD_ID + ":block/keyboard_template", TextureKey.PARTICLE, TextureKey.ALL);

    private static Model block(String path, TextureKey ... requiredTextureKeys) {
        return new Model(Optional.of(new Identifier(path)), Optional.empty(), requiredTextureKeys);
    }
}
