package net.leafenzo.ltones.datageneration;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.leafenzo.ltones.Super;
import net.leafenzo.ltones.block.LitSlabBlock;
import net.leafenzo.ltones.block.ModBlocks;
import net.leafenzo.ltones.util.ModUtil;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.data.client.*;
import net.minecraft.registry.Registries;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.ArrayList;
import java.util.function.Function;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    private void registerUpDefaultOrientable(BlockStateModelGenerator blockStateModelGenerator, Block block, TexturedModel.Factory modelFactory) {
        Identifier identifier = modelFactory.upload(block, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block, BlockStateVariant.create().put(VariantSettings.MODEL, identifier)).coordinate(this.createUpDefaultRotationStates()));
        //blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block).coordinate(BlockStateModelGenerator.createNorthDefaultRotationStates(), identifier));
    }
    private static BlockStateVariantMap createUpDefaultRotationStates() {
        return BlockStateVariantMap.create(Properties.FACING).register(Direction.DOWN, BlockStateVariant.create().put(VariantSettings.X, VariantSettings.Rotation.R180)).register(Direction.UP, BlockStateVariant.create()).register(Direction.NORTH, BlockStateVariant.create().put(VariantSettings.X, VariantSettings.Rotation.R90)).register(Direction.SOUTH, BlockStateVariant.create().put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R180)).register(Direction.WEST, BlockStateVariant.create().put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R270)).register(Direction.EAST, BlockStateVariant.create().put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R90));
    }
//    public static Identifier createSubModel(Block block, String suffix, TexturedModel.Factory modelFactory) {
//        return modelFactory.upload(block, suffix, )
//    }
    private void registerLitOnOffBlock(BlockStateModelGenerator blockStateModelGenerator, Block block, Model model,  Function<Identifier, TextureMap> textureFactory) {
        Identifier identifier = model.upload(block, textureFactory.apply(TextureMap.getId(block)), blockStateModelGenerator.modelCollector);
        Identifier identifier2 = blockStateModelGenerator.createSubModel(block, "_on", model, textureFactory);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block).coordinate(BlockStateModelGenerator.createBooleanModelMap(Properties.LIT, identifier2, identifier)));

    }
    private void registerLitOnOffAxisRotatedBlock(BlockStateModelGenerator blockStateModelGenerator, Block block, Model model,  Function<Identifier, TextureMap> textureFactory) {
        Identifier identifier = model.upload(block, textureFactory.apply(TextureMap.getId(block)), blockStateModelGenerator.modelCollector);
        Identifier identifier2 = blockStateModelGenerator.createSubModel(block, "_on", model, textureFactory);
        blockStateModelGenerator.blockStateCollector.accept(
                VariantsBlockStateSupplier.create(block)
                        .coordinate(BlockStateModelGenerator.createAxisRotatedVariantMap())
                        .coordinate(BlockStateModelGenerator.createBooleanModelMap(Properties.LIT, identifier2, identifier)));
    }
    private void registerLitOnOffGlazedTerracottaBlock(BlockStateModelGenerator blockStateModelGenerator, Block block, Model model,  Function<Identifier, TextureMap> textureFactory) {
        Identifier identifier = model.upload(block, textureFactory.apply(TextureMap.getId(block)), blockStateModelGenerator.modelCollector);
        Identifier identifier2 = blockStateModelGenerator.createSubModel(block, "_on", model, textureFactory);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block, BlockStateVariant.create().put(VariantSettings.MODEL, identifier)).coordinate(BlockStateModelGenerator.createSouthDefaultHorizontalRotationStates()).coordinate(BlockStateModelGenerator.createBooleanModelMap(Properties.LIT, identifier2, identifier)));
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //  AGON
        for(Block block : ModBlocks.AGON_BLOCKS.keySet()) {
            blockStateModelGenerator.registerCubeAllModelTexturePool(block);
        }
        //  FORT
        for(Block block : ModBlocks.FORT_BLOCKS) {
            blockStateModelGenerator.registerCubeAllModelTexturePool(block);
        }
        //  GLAXX
        for(Block block : ModBlocks.GLAXX_BLOCKS) {
            blockStateModelGenerator.registerCubeAllModelTexturePool(block);
        }
        //  CRAY
        for(Block block : ModBlocks.CRAY_BLOCKS) {
            blockStateModelGenerator.registerCubeAllModelTexturePool(block);
        }
        //  CAST
        for(Block block : ModBlocks.CAST_BLOCKS) {
            blockStateModelGenerator.registerCubeAllModelTexturePool(block);
        }
        //  HOST
        for(Block block : ModBlocks.HOST_BLOCKS) {
            blockStateModelGenerator.registerCubeAllModelTexturePool(block);
        }
        //  ZANE
        for(Block block : ModBlocks.ZANE_BLOCKS) {
            blockStateModelGenerator.registerCubeAllModelTexturePool(block);
        }

        //  REDDS
        BlockStateModelGenerator.BlockTexturePool reddsPiceTexturePool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.REDDS_PICE);
        reddsPiceTexturePool.slab(ModBlocks.REDDS_PICE_SLAB);
        reddsPiceTexturePool.stairs(ModBlocks.REDDS_PICE_STAIRS);
        registerLitOnOffBlock(blockStateModelGenerator, ModBlocks.REDDS, Models.CUBE_ALL, TextureMap::all);
        registerLitOnOffBlock(blockStateModelGenerator, ModBlocks.REDDS_TRACT, Models.CUBE_ALL, TextureMap::all);
        registerLitOnOffBlock(blockStateModelGenerator, ModBlocks.REDDS_THOUGHT, Models.CUBE_ALL, TextureMap::all);
        registerLitOnOffBlock(blockStateModelGenerator, ModBlocks.REDDS_TILE, Models.CUBE_ALL, TextureMap::all);
        registerLitOnOffBlock(blockStateModelGenerator, ModBlocks.REDDS_MARK, Models.CUBE_ALL, TextureMap::all);
        registerLitOnOffBlock(blockStateModelGenerator, ModBlocks.REDDS_NEXUS, Models.CUBE_ALL, TextureMap::all);
        registerLitOnOffBlock(blockStateModelGenerator, ModBlocks.REDDS_GRATE, Models.CUBE_ALL, TextureMap::all);
        registerLitOnOffBlock(blockStateModelGenerator, ModBlocks.REDDS_HEART, Models.CUBE_ALL, TextureMap::all);
        registerLitOnOffBlock(blockStateModelGenerator, ModBlocks.REDDS_HOPPER, Models.CUBE_ALL, TextureMap::all);
        registerLitOnOffBlock(blockStateModelGenerator, ModBlocks.REDDS_FRACTAL, Models.CUBE_ALL, TextureMap::all);
        registerLitOnOffBlock(blockStateModelGenerator, ModBlocks.REDDS_FRAME, Models.CUBE_ALL, TextureMap::all);
        registerLitOnOffBlock(blockStateModelGenerator, ModBlocks.REDDS_BALANCE, Models.CUBE_ALL, TextureMap::all);
        registerLitOnOffBlock(blockStateModelGenerator, ModBlocks.REDDS_CURRENT, Models.CUBE_ALL, TextureMap::all);
        registerLitOnOffAxisRotatedBlock(blockStateModelGenerator, ModBlocks.REDDS_TAPE, Models.CUBE_ALL, TextureMap::all);
        registerLitOnOffGlazedTerracottaBlock(blockStateModelGenerator, ModBlocks.REDDS_GLAZED, Models.CUBE_ALL, TextureMap::all);

        //  VECT
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.VECT);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.VECT_TILE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.VECT_RIVET);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.VECT_HUB);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.VECT_STRUT, TexturedModel.CUBE_ALL);
        registerUpDefaultOrientable(blockStateModelGenerator, ModBlocks.VECT_PAD, TexturedModel.CUBE_ALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.VECT_TRACKER);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.VECT_CORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.VECT_TREADPLATE);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.VECT_SHIELD, TexturedModel.CUBE_ALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.VECT_PANEL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.VECT_RADIATOR);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.VECT_BULKHEAD, TexturedModel.CUBE_ALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.VECT_TANK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.VECT_NETWORK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.VECT_FOIL);

        //  MINN
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MINN_TILES);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MINN_RESONANCE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MINN_QUILT);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MINN_POFFNODE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MINN_POFFCAGE);
//        registerUpDefaultOrientable(blockStateModelGenerator, ModBlocks.MINN_POFFCAGE, TexturedModel.CUBE_ALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MINN_POFF);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MINN_PAD);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MINN_NEXUS);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MINN_LINENODE);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.MINN_LINE, TexturedModel.CUBE_ALL); ;
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MINN_CIRCLE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MINN_CAGE);
//        registerUpDefaultOrientable(blockStateModelGenerator, ModBlocks.MINN_CAGE, TexturedModel.CUBE_ALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MINN_CUBES);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MINN_BLANK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MINN_BEVEL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MINN);


        //  LAIR
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LAIR_STRUT);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LAIR_SMOOTH);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LAIR_RIGOR);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LAIR_RIGID);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LAIR_MESS);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LAIR_MATTERTILES);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LAIR_MATTER);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LAIR_JEWEL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LAIR_HEAL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LAIR_DERMADENT);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LAIR_DERMA);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.LAIR_CROWNED, TexturedModel.CUBE_ALL);
        registerUpDefaultOrientable(blockStateModelGenerator, ModBlocks.LAIR_CHUNK, TexturedModel.CUBE_ALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LAIR_CELL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LAIR_AGED);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LAIR);


    // Block Models
        // Cube with all sides the same texture, IE Dirt
        // blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.COMPRESSED_STONE);

        // Non-rotatable Cube with faces of different textures
        //blockStateModelGenerator.registerSingleton(ModBlocks.BOOK_BLOCK, TexturedModel.CUBE_COLUMN);

        // Pillar Block, IE Oak Logs
        //blockStateModelGenerator.registerAxisRotated(ModBlocks.SUPER_COMPRESSED_DEEPSLATE, TexturedModel.CUBE_COLUMN);

        // Reversible Pillar Block
        //registerUpDefaultOrientable(blockStateModelGenerator, ModBlocks.BLAZE_ROD_BLOCK, TexturedModel.CUBE_COLUMN);

        // Leaves Like Blocks, includes things that sample from Biome Color maps.
        //blockStateModelGenerator.registerSingleton(ModBlocks.GRASS_CLIPPINGS_BLOCK, TexturedModel.LEAVES);

        // BlockItem Models
            // Fallback
        generateFallbackBlockItemModels(blockStateModelGenerator);
    }
    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }

    public ArrayList<Identifier> usedBlockItems = new ArrayList<Identifier>();
    public void registerParentedBlockItemModel(BlockStateModelGenerator blockStateModelGenerator, Block block, Identifier identifier) {
        if(!usedBlockItems.contains(identifier)) {
            blockStateModelGenerator.registerParentedItemModel(block, identifier);
            usedBlockItems.add(identifier);
        }
    }
    public void generateFallbackBlockItemModels(BlockStateModelGenerator blockStateModelGenerator) {
        for (Identifier id : ModUtil.allBlockIdsInNamespace(Super.MOD_ID)) {
            Block block = Registries.BLOCK.get(id);
            if(block instanceof StairsBlock || block instanceof LitSlabBlock || block instanceof SlabBlock) continue; //Jank but it works
            registerParentedBlockItemModel(blockStateModelGenerator, Registries.BLOCK.get(id), Super.asResource("block/" + id.getPath()));
        }
    }
}