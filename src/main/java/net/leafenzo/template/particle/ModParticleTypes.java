package net.leafenzo.template.particle;

import com.mojang.serialization.Codec;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.leafenzo.template.ModInit;
import net.leafenzo.template.Super;
import net.leafenzo.template.particle.ExampleParticle;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModParticleTypes {
    public static final DefaultParticleType EXAMPLE_PARTICLE = registerParticle("example_particle");

    private static DefaultParticleType registerParticle(String name) {
        return Registry.register(Registries.PARTICLE_TYPE, new Identifier(Super.MOD_ID, name), FabricParticleTypes.simple());
    }

    public static void registerFactoriesForClient() {
        ParticleFactoryRegistry registry = ParticleFactoryRegistry.getInstance();

        registry.register(EXAMPLE_PARTICLE, ExampleParticle.Factory::new);
    }

    public static void registerModParticleTypes() {
        ModInit.LOGGER.debug("Registering particle types for " + Super.MOD_ID);
    }
}
