package net.leafenzo.template.mixin;

import com.mojang.serialization.Codec;
import net.leafenzo.template.world.ModSimpleBlockStateProvider;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.BlockStateProviderType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(BlockStateProviderType.class) public interface BlockStateProviderMixin {
    @Invoker
    static <P extends BlockStateProvider> BlockStateProviderType <P> callRegister(String id, Codec<ModSimpleBlockStateProvider> codec) {
        throw new IllegalStateException();
    }
}
