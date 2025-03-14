package net.leafenzo.ltones.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

// if you're reading this, i apologize for my awful code
// -amber

@Environment(value = EnvType.CLIENT)
public class ZkulParticle extends SpriteBillboardParticle {
    protected ZkulParticle(ClientWorld clientWorld, double xCoord, double yCoord, double zCoord, double xd, double yd, double zd) {
        super(clientWorld, xCoord, yCoord, zCoord, xd, yd, zd);
        this.maxAge = (int)(100.0f / (this.random.nextFloat() * 0.9f + 0.1f));
        this.scale = 0.3f;
        this.velocityX = 0;
        this.velocityY = 0.05f;
        this.velocityZ = 0;
    }

    @Override
    public int getBrightness(float tint) {
        return 240;
    }

    @Override
    public void tick() {
        this.prevPosX = this.x;
        this.prevPosY = this.y;
        this.prevPosZ = this.z;
        if (this.age++ >= this.maxAge) {
            this.markDead();
            return;
        }
        this.velocityY += 0.002;
        this.move(this.velocityX, this.velocityY, this.velocityZ);
        float c = this.maxAge / 35000f;
        this.velocityX = c * (world.getRandom().nextFloat() - 0.5f) * 2;
        this.velocityY = c * (world.getRandom().nextFloat() - 0.5f) * 2; // yes these have to be effectively duplicated or else they'll all share the same motion
        this.velocityZ = c * (world.getRandom().nextFloat() - 0.5f) * 2;
        this.velocityY *= 0.05f;
        this.prevAngle = this.angle;
        this.angle = c * (world.getRandom().nextFloat() - 0.5f) * 15f;
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_OPAQUE;
    }

    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        public Particle createParticle(DefaultParticleType particleType, ClientWorld level, double x, double y, double z, double dx, double dy, double dz) {
            ZkulParticle particle = new ZkulParticle(level, x, y, z, dx, dy, dz);
            particle.setSprite(spriteProvider);
            return particle;
        }
    }
}
