package net.leafenzo.template;

import net.fabricmc.api.ClientModInitializer;
import net.leafenzo.template.client.render.ModColorHandler;
import net.leafenzo.template.client.render.ModRenderLayers;
import net.leafenzo.template.particle.ModParticleTypes;

public class ModClientInit implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModRenderLayers.registerBlockCutouts();
        ModColorHandler.registerBlockColorProviders();

        ModParticleTypes.registerFactoriesForClient();
    }
}
