package net.leafenzo.ltones.datageneration;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.leafenzo.ltones.Super;
import net.leafenzo.ltones.block.LitSlabBlock;
import net.leafenzo.ltones.block.ModBlocks;
import net.leafenzo.ltones.util.ModUtil;
import net.minecraft.block.Block;
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
    private void registerAxisRotatedBlockWithTopTexturePath(BlockStateModelGenerator blockStateModelGenerator, Block block, String topTexturePath) {
        TextureMap map = new TextureMap()
                .put(TextureKey.PARTICLE, TextureMap.getId(block))
                .put(TextureKey.NORTH, TextureMap.getId(block))
                .put(TextureKey.SOUTH, TextureMap.getId(block))
                .put(TextureKey.EAST, TextureMap.getId(block))
                .put(TextureKey.WEST, TextureMap.getId(block))
                .put(TextureKey.UP, Super.asResource(topTexturePath))
                .put(TextureKey.DOWN, Super.asResource(topTexturePath));

        Identifier identifier = Models.CUBE.upload(block, map, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block, BlockStateVariant.create().put(VariantSettings.MODEL, identifier)).coordinate(BlockStateModelGenerator.createAxisRotatedVariantMap()));
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //<editor-fold desc = "Models - agon">
        for(Block block : ModBlocks.AGON_BLOCKS) {
            blockStateModelGenerator.registerCubeAllModelTexturePool(block);
        }
        //</editor-fold>
        //<editor-fold desc = "Models - fort">
        for(Block block : ModBlocks.FORT_BLOCKS) {
            blockStateModelGenerator.registerCubeAllModelTexturePool(block);
        }
        //</editor-fold>
        //<editor-fold desc = "Models - glaxx">
        for(Block block : ModBlocks.GLAXX_BLOCKS) {
            blockStateModelGenerator.registerCubeAllModelTexturePool(block);
        }
        //</editor-fold>
        //<editor-fold desc = "Models - cray">
        for(Block block : ModBlocks.CRAY_BLOCKS) {
            blockStateModelGenerator.registerCubeAllModelTexturePool(block);
        }
        //</editor-fold>
        //<editor-fold desc = "Models - cast">
        for(Block block : ModBlocks.CAST_BLOCKS) {
            blockStateModelGenerator.registerCubeAllModelTexturePool(block);
        }
        //</editor-fold>
        //<editor-fold desc = "Models - host">
        for(Block block : ModBlocks.HOST_BLOCKS) {
            blockStateModelGenerator.registerCubeAllModelTexturePool(block);
        }
        //</editor-fold>
        //<editor-fold desc = "Models - zane">
        for(Block block : ModBlocks.ZANE_BLOCKS) {
            blockStateModelGenerator.registerCubeAllModelTexturePool(block);
        }
        //</editor-fold>
        //<editor-fold desc = "Models - redds">
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
        //</editor-fold>
        //<editor-fold desc = "Models - vect">
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
        //</editor-fold>
        //<editor-fold desc = "Models - minn">
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MINN_TILES);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MINN_RESONANCE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MINN_QUILT);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MINN_POFFNODE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MINN_POFFCAGE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MINN_POFF);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MINN_PAD);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MINN_NEXUS);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MINN_LINENODE);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.MINN_LINE, TexturedModel.CUBE_ALL); ;
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MINN_CIRCLE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MINN_CAGE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MINN_CUBES);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MINN_BLANK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MINN_BEVEL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MINN);
        //</editor-fold>
        //<editor-fold desc = "Models - lair">
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LAIR_STRUT);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LAIR_SMOOTH);
        BlockStateModelGenerator.BlockTexturePool lairRigorTexturePool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LAIR_RIGOR);
            lairRigorTexturePool.slab(ModBlocks.LAIR_RIGOR_SLAB);
            lairRigorTexturePool.stairs(ModBlocks.LAIR_RIGOR_STAIRS);
        BlockStateModelGenerator.BlockTexturePool lairRigidTexturePool  =
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LAIR_RIGID);
            lairRigidTexturePool.slab(ModBlocks.LAIR_RIGID_SLAB);
            lairRigidTexturePool.stairs(ModBlocks.LAIR_RIGID_STAIRS);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LAIR_MESS);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LAIR_MATTERTILES);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LAIR_MATTER);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LAIR_JEWEL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LAIR_HEAL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LAIR_DERMADENT);
        BlockStateModelGenerator.BlockTexturePool lairDermaTexturePool =
            blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LAIR_DERMA);
            lairDermaTexturePool.slab(ModBlocks.LAIR_DERMA_SLAB);
            lairDermaTexturePool.stairs(ModBlocks.LAIR_DERMA_STAIRS);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.LAIR_CROWNED, TexturedModel.CUBE_ALL);
        registerUpDefaultOrientable(blockStateModelGenerator, ModBlocks.LAIR_CHUNK, TexturedModel.CUBE_ALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LAIR_CELL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LAIR_AGED);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LAIR);
        //</editor-fold>
        //<editor-fold desc = "Models - kryp">
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.KRYP_WIRE);
        BlockStateModelGenerator.BlockTexturePool krypStorageTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.KRYP_STORAGE);
        krypStorageTexturePool.slab(ModBlocks.KRYP_STORAGE_SLAB);
        krypStorageTexturePool.stairs(ModBlocks.KRYP_STORAGE_STAIRS);
        BlockStateModelGenerator.BlockTexturePool krypSmoothTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.KRYP_SMOOTH);
        krypSmoothTexturePool.slab(ModBlocks.KRYP_SMOOTH_SLAB);
        krypSmoothTexturePool.stairs(ModBlocks.KRYP_SMOOTH_STAIRS);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.KRYP_SHEEN);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.KRYP_RUIN);
        registerLitOnOffBlock(blockStateModelGenerator, ModBlocks.KRYP_OMITTER, Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.KRYP_LEVI);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.KRYP_INFO);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.KRYP_DATA);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.KRYP_CONNECTOR);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.KRYP_BEAM);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.KRYP_BASE);
        BlockStateModelGenerator.BlockTexturePool krypTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.KRYP);
        krypTexturePool.slab(ModBlocks.KRYP_SLAB);
        krypTexturePool.stairs(ModBlocks.KRYP_STAIRS);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.KRYP_SUPPORT, TexturedModel.CUBE_ALL);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.KRYP_KUBT, TexturedModel.CUBE_ALL);
        blockStateModelGenerator.registerSouthDefaultHorizontalFacing(TexturedModel.TEMPLATE_GLAZED_TERRACOTTA, ModBlocks.KRYP_CHUNK);
        //</editor-fold>
        //<editor-fold desc = "Models - lave">
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LAVE_WINDOW);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LAVE_VENT);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LAVE_UNEVEN);
        BlockStateModelGenerator.BlockTexturePool laveTileTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LAVE_TILE);
        laveTileTexturePool.slab(ModBlocks.LAVE_TILE_SLAB);
        laveTileTexturePool.stairs(ModBlocks.LAVE_TILE_STAIRS);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LAVE_THICK);
        BlockStateModelGenerator.BlockTexturePool laveSectionTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LAVE_SECTION);
        laveSectionTexturePool.slab(ModBlocks.LAVE_SECTION_SLAB);
        laveSectionTexturePool.stairs(ModBlocks.LAVE_SECTION_STAIRS);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LAVE_PANEL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LAVE_LOW);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LAVE_HEX);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LAVE_DIM);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LAVE_DARK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LAVE_CROSSSECTION);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LAVE);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.LAVE_TRACKPAD, TexturedModel.CUBE_ALL);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.LAVE_ELEVATE, TexturedModel.CUBE_ALL);
        registerAxisRotatedBlockWithTopTexturePath(blockStateModelGenerator, ModBlocks.LAVE_BEAM, "block/lave_panel");
        //</editor-fold>
        //<editor-fold desc = "Models - veeld">
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.VEELD_WET);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.VEELD_RIVETED);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.VEELD_RIPPLE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.VEELD_RIGIDBRICK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.VEELD_RIGID);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.VEELD_PIPEWEAVE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.VEELD_PANEL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.VEELD_ETCHED);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.VEELD_EMBOSSED);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.VEELD_CORE);
        BlockStateModelGenerator.BlockTexturePool veeldBrickTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.VEELD_BRICK);
        veeldBrickTexturePool.slab(ModBlocks.VEELD_BRICK_SLAB);
        veeldBrickTexturePool.stairs(ModBlocks.VEELD_BRICK_STAIRS);
        BlockStateModelGenerator.BlockTexturePool veeldTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.VEELD);
        veeldTexturePool.slab(ModBlocks.VEELD_SLAB);
        veeldTexturePool.stairs(ModBlocks.VEELD_STAIRS);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.VEELD_TRACTION, TexturedModel.CUBE_ALL);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.VEELD_STRUCTURE, TexturedModel.CUBE_ALL);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.VEELD_DRILL, TexturedModel.CUBE_ALL);
        blockStateModelGenerator.registerSouthDefaultHorizontalFacing(TexturedModel.TEMPLATE_GLAZED_TERRACOTTA, ModBlocks.VEELD_PATTERNED);
        //</editor-fold>
        //<editor-fold desc = "Models - jelt">
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.JELT_SUPPLY);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.JELT_POKE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.JELT_ORGANIZE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.JELT_ORBULE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.JELT_LUMINA);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.JELT_FUSION);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.JELT_FISSION);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.JELT_ENERGY);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.JELT_EMBOSS);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.JELT_DESTINE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.JELT_CONFINE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.JELT_ATWAL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.JELT);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.JELT_PATH, TexturedModel.CUBE_ALL);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.JELT_EXHAUST, TexturedModel.CUBE_ALL);
        blockStateModelGenerator.registerSouthDefaultHorizontalFacing(TexturedModel.TEMPLATE_GLAZED_TERRACOTTA, ModBlocks.JELT_PATHJOINT);
        //</editor-fold>
        //<editor-fold desc = "Models - korp">
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.KORP_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.KORP_SECURE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.KORP_REGULATE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.KORP_MARK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.KORP_HOLDING);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.KORP_GROWTH);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.KORP_COMMAND);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.KORP_BANK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.KORP_ASSET);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.KORP);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.KORP_VEST, TexturedModel.CUBE_ALL);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.KORP_RUPT, TexturedModel.CUBE_ALL);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.KORP_RESOURCE, TexturedModel.CUBE_ALL);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.KORP_FLOW, TexturedModel.CUBE_ALL);
        registerAxisRotatedBlockWithTopTexturePath(blockStateModelGenerator, ModBlocks.KORP_OUTFLOW, "block/korp_regulate");
        blockStateModelGenerator.registerSouthDefaultHorizontalFacing(TexturedModel.TEMPLATE_GLAZED_TERRACOTTA, ModBlocks.KORP_CONSUME);
        //</editor-fold>
        //<editor-fold desc = "Models - tank">
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.TANK_ZIZER);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.TANK_WINDOW);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.TANK_TREAD);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.TANK_TILES);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.TANK_SECURE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.TANK_RIVET);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.TANK_FUNCTION);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.TANK_FORTIFIED);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.TANK_FLEXI);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.TANK_CONJUNCTION);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.TANK_BAND);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.TANK_ARMOR);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.TANK);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.TANK_RIGID, TexturedModel.CUBE_ALL);
        registerAxisRotatedBlockWithTopTexturePath(blockStateModelGenerator, ModBlocks.TANK_BEAM, "block/tank_secure");
        blockStateModelGenerator.registerSouthDefaultHorizontalFacing(TexturedModel.TEMPLATE_GLAZED_TERRACOTTA, ModBlocks.TANK_CANNON);
        //</editor-fold>
        //<editor-fold desc = "Models - axri">
        // TODO horizontal placement and exri_seal sides
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.EXRI_TECT);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.EXRI_STEM);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.EXRI_STEEL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.EXRI_SEAL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.EXRI_SCREEN);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.EXRI_ROGEN);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.EXRI_MESH);
        BlockStateModelGenerator.BlockTexturePool exriDivideTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.EXRI_DIVIDE);
        exriDivideTexturePool.slab(ModBlocks.EXRI_DIVIDE_SLAB);
        exriDivideTexturePool.stairs(ModBlocks.EXRI_DIVIDE_STAIRS);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.EXRI);
        registerLitOnOffBlock(blockStateModelGenerator, ModBlocks.EXRI_FLOW, Models.CUBE_ALL, TextureMap::all);
        registerLitOnOffBlock(blockStateModelGenerator, ModBlocks.EXRI_SERVE, Models.CUBE_ALL, TextureMap::all);
        registerLitOnOffBlock(blockStateModelGenerator, ModBlocks.EXRI_DISPLAY, Models.CUBE_ALL, TextureMap::all);
        registerLitOnOffBlock(blockStateModelGenerator, ModBlocks.EXRI_CURRENT, Models.CUBE_ALL, TextureMap::all);
        registerLitOnOffBlock(blockStateModelGenerator, ModBlocks.EXRI_CRITICAL, Models.CUBE_ALL, TextureMap::all);
        registerLitOnOffBlock(blockStateModelGenerator, ModBlocks.EXRI_CONTROL, Models.CUBE_ALL, TextureMap::all);
        registerLitOnOffBlock(blockStateModelGenerator, ModBlocks.EXRI_LEVEL, Models.CUBE_ALL, TextureMap::all);
        //</editor-fold>
        //<editor-fold desc = "Models - azur">
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.AZUR_CUBE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.AZUR_KINETIC);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.AZUR_NEURON);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.AZUR_PAVE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.AZUR_PERATION);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.AZUR_PLUG);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.AZUR_RIPPLE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.AZUR_RUN);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.AZUR_SCRAPE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.AZUR_SENSORY);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.AZUR_SIGN);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.AZUR);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.AZUR_CRIPT, TexturedModel.CUBE_ALL);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.AZUR_CYBER, TexturedModel.CUBE_ALL);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.AZUR_GUIDE, TexturedModel.CUBE_ALL);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.AZUR_SIGNAL, TexturedModel.CUBE_ALL);
        //</editor-fold>
        //<editor-fold desc = "Models - fleq">
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.FLEQ_WET);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.FLEQ_VALVE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.FLEQ_STACK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.FLEQ_RUBBLE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.FLEQ_RECK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.FLEQ_LENT);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.FLEQ_ILLUSION);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.FLEQ_ERODE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.FLEQ_BUBBLE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.FLEQ_BOLDEN);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.FLEQ_ABODE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.FLEQ);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.FLEQ_DIRECT, TexturedModel.CUBE_ALL);
        registerAxisRotatedBlockWithTopTexturePath(blockStateModelGenerator, ModBlocks.FLEQ_TUBE, "block/fleq_valve");
        blockStateModelGenerator.registerSouthDefaultHorizontalFacing(TexturedModel.TEMPLATE_GLAZED_TERRACOTTA, ModBlocks.FLEQ_LARVAE);
        blockStateModelGenerator.registerSouthDefaultHorizontalFacing(TexturedModel.TEMPLATE_GLAZED_TERRACOTTA, ModBlocks.FLEQ_PIPE);
        //</editor-fold>
        //<editor-fold desc = "Models - iszm">
        for(Block block : ModBlocks.ISZM_BLOCKS) {
            blockStateModelGenerator.registerCubeAllModelTexturePool(block);
        }
        //</editor-fold>
        //<editor-fold desc = "Models - myst">
        for(Block block : ModBlocks.MYST_BLOCKS) {
            blockStateModelGenerator.registerCubeAllModelTexturePool(block);
        }
        //</editor-fold>
        //<editor-fold desc = "Models - sync">
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SYNC_SHIELDING);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SYNC_SAFE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SYNC_MESS);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SYNC_LEADED);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SYNC_JUNCTION);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SYNC_HAZARD);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SYNC_HATCH);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SYNC_FRAMED);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SYNC_FORCE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SYNC_DATA);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SYNC_CONTAIN);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SYNC);
//        blockStateModelGenerator.registerAxisRotated(ModBlocks.SYNC_TANK, TexturedModel.CUBE_ALL);
//        blockStateModelGenerator.registerAxisRotated(ModBlocks.SYNC_CAUTION, TexturedModel.CUBE_ALL);
        registerAxisRotatedBlockWithTopTexturePath(blockStateModelGenerator, ModBlocks.SYNC_TANK, "block/sync_shielding");
        registerAxisRotatedBlockWithTopTexturePath(blockStateModelGenerator, ModBlocks.SYNC_HEX, "block/sync_junction");
        registerAxisRotatedBlockWithTopTexturePath(blockStateModelGenerator, ModBlocks.SYNC_CAUTION, "block/sync_shielding");
        blockStateModelGenerator.registerSouthDefaultHorizontalFacing(TexturedModel.TEMPLATE_GLAZED_TERRACOTTA, ModBlocks.SYNC_MIZMER);
        //</editor-fold>
        //<editor-fold desc = "Models - nurr">
        for(Block block : ModBlocks.NURR_BLOCKS) {
            blockStateModelGenerator.registerAxisRotated(block, TexturedModel.CUBE_ALL);
        }
        //</editor-fold>
        //<editor-fold desc = "Models - tyel">
        for(Block block : ModBlocks.TYEL_BLOCKS) {
            blockStateModelGenerator.registerCubeAllModelTexturePool(block);
        }
        //</editor-fold>
        //<editor-fold desc = "Models - roen">
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ROEN_DESSICATE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ROEN_AGAR);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ROEN_GEL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ROEN_STRAND);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ROEN_MEMB);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ROEN_FILM);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ROEN_ARRAY);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ROEN_ASSAY);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ROEN_ONCOGENE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ROEN_GROUT);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ROEN);
//        registerAxisRotatedBlockWithTopTexturePath(blockStateModelGenerator, ModBlocks.ROEN_LESION, "block/roen_dessicate");
        blockStateModelGenerator.registerAxisRotated(ModBlocks.ROEN_LESION, TexturedModel.CUBE_ALL);
        registerAxisRotatedBlockWithTopTexturePath(blockStateModelGenerator, ModBlocks.ROEN_TRACT, "block/roen_assay");
        registerAxisRotatedBlockWithTopTexturePath(blockStateModelGenerator, ModBlocks.ROEN_BACILLUS, "block/roen_agar");
        registerAxisRotatedBlockWithTopTexturePath(blockStateModelGenerator, ModBlocks.ROEN_OPERON, "block/roen_film");
        blockStateModelGenerator.registerSouthDefaultHorizontalFacing(TexturedModel.TEMPLATE_GLAZED_TERRACOTTA, ModBlocks.ROEN_KINESIN);
        //</editor-fold>


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


        // BlockItem Models // Fallback
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