package net.leafenzo.ltones.client.render;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.leafenzo.ltones.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;

public class ModRenderLayers {
    public static void registerBlockCutouts() {
//        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutoutMipped(),
//                ModBlocks.COMPRESSED_SPONGE
//        );
//        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(),
//        );
        for(Block block : ModBlocks.GLAXX_BLOCKS) {
            BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getTranslucent());
        }
    }
}
