package net.leafenzo.ltones.data.client;

import net.leafenzo.ltones.Super;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.TextureKey;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModels {
    public static final Model DECAL = block(Super.MOD_ID + ":block/decal", TextureKey.PARTICLE, TextureKey.ALL);

    private static Model block(String path, TextureKey ... requiredTextureKeys) {
        return new Model(Optional.of(new Identifier(path)), Optional.empty(), requiredTextureKeys);
    }
}
