package net.leafenzo.ltones.block.custom;

import net.minecraft.block.PillarBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BlockView;

public class BouncyPillarBlock extends PillarBlock {

    public BouncyPillarBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onEntityLand(BlockView blockView, Entity entity) {
        if (entity.bypassesLandingEffects()) {
            super.onEntityLand(blockView, entity);
        } else {
            this.bounceEntity(entity);
            if (Math.abs(entity.getVelocity().y) > 0.05f) {
                entity.playSound(this.soundGroup.getFallSound(), 0.25f, 0.8f);
            }
        }
    }

    private void bounceEntity(Entity entity) {
        Vec3d vec3d = entity.getVelocity();
        if (vec3d.y < 0.0) {
            double d = entity instanceof LivingEntity ? 1.0 : 0.8;
            entity.setVelocity(vec3d.x, -vec3d.y * (double)0.66f * d, vec3d.z);
        }
    }
}
