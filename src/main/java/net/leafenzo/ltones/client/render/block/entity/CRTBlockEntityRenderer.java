//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.leafenzo.ltones.client.render.block.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.leafenzo.ltones.block.entity.CRTBlockEntity;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.util.math.MatrixStack;

@Environment(EnvType.CLIENT)
public class CRTBlockEntityRenderer implements BlockEntityRenderer<CRTBlockEntity> {

    public CRTBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
        ModelPart modelPart = ctx.getLayerModelPart(EntityModelLayers.BELL);
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData modelPartData2 = modelPartData.addChild("bell_body", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -6.0F, -3.0F, 6.0F, 7.0F, 6.0F), ModelTransform.pivot(8.0F, 12.0F, 8.0F));
        modelPartData2.addChild("bell_base", ModelPartBuilder.create().uv(0, 13).cuboid(4.0F, 4.0F, 4.0F, 8.0F, 2.0F, 8.0F), ModelTransform.pivot(-8.0F, -12.0F, -8.0F));
        return TexturedModelData.of(modelData, 32, 32);
    }

    @Override
    public void render(CRTBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {

    }
}
