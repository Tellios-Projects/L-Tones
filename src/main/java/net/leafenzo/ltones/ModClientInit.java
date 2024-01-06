package net.leafenzo.ltones;

import net.fabricmc.api.ClientModInitializer;
import net.leafenzo.ltones.client.render.ModColorHandler;
import net.leafenzo.ltones.client.render.ModRenderLayers;
import net.leafenzo.ltones.particle.ModParticleTypes;

public class ModClientInit implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModRenderLayers.registerBlockCutouts();
        ModColorHandler.registerBlockColorProviders();

        ModParticleTypes.registerFactoriesForClient();
    }
}
