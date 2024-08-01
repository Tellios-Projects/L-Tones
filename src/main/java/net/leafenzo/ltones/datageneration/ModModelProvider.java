package net.leafenzo.ltones.datageneration;

import com.mojang.datafixers.util.Pair;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.leafenzo.ltones.Super;
import net.leafenzo.ltones.block.custom.DecalBlock;
import net.leafenzo.ltones.block.custom.LitSlabBlock;
import net.leafenzo.ltones.block.ModBlocks;
import net.leafenzo.ltones.data.client.ModModels;
import net.leafenzo.ltones.data.client.ModTexturedModel;
import net.leafenzo.ltones.item.ModItems;
import net.leafenzo.ltones.util.ModUtil;
import net.minecraft.block.*;
import net.minecraft.data.client.*;
import net.minecraft.registry.Registries;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.Direction;

import java.util.ArrayList;
import java.util.Objects;
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
    private void registerAxisRotatedBlockWithCustomTexturePaths(BlockStateModelGenerator blockStateModelGenerator, Block block, String topTexturePath, String sideTexturePath) {
        TextureMap map = new TextureMap()
                .put(TextureKey.PARTICLE, Super.asResource(sideTexturePath))
                .put(TextureKey.NORTH, Super.asResource(sideTexturePath))
                .put(TextureKey.SOUTH, Super.asResource(sideTexturePath))
                .put(TextureKey.EAST, Super.asResource(sideTexturePath))
                .put(TextureKey.WEST, Super.asResource(sideTexturePath))
                .put(TextureKey.UP, Super.asResource(topTexturePath))
                .put(TextureKey.DOWN, Super.asResource(topTexturePath));

        Identifier identifier = Models.CUBE.upload(block, map, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block, BlockStateVariant.create().put(VariantSettings.MODEL, identifier)).coordinate(BlockStateModelGenerator.createAxisRotatedVariantMap()));
    }

    public final void registerMultiStateDecal(BlockStateModelGenerator blockStateModelGenerator, Block block) {
        blockStateModelGenerator.registerItemModel(block.asItem());

        Identifier identifier = blockStateModelGenerator.createSubModel(block, "_floor", ModModels.DECAL, TextureMap::all);
        Identifier identifier2 = blockStateModelGenerator.createSubModel(block, "_wall", ModModels.DECAL, TextureMap::all);

        MultipartBlockStateSupplier multipartBlockStateSupplier = MultipartBlockStateSupplier.create(block);
        When.PropertyCondition propertyCondition2 = Util.make(When.create(), propertyCondition -> blockStateModelGenerator.CONNECTION_VARIANT_FUNCTIONS.stream().map(Pair::getFirst).forEach(property -> {
            if (block.getDefaultState().contains(property)) {
                propertyCondition.set(property, false);
            }
        }));
        for (Pair<BooleanProperty, Function<Identifier, BlockStateVariant>> pair : blockStateModelGenerator.CONNECTION_VARIANT_FUNCTIONS) {
            BooleanProperty booleanProperty = pair.getFirst();
            Function<Identifier, BlockStateVariant> function = pair.getSecond();
            if (!block.getDefaultState().contains(booleanProperty)) continue;

            if(Objects.equals(booleanProperty.getName(), "up") || Objects.equals(booleanProperty.getName(), "down")) {
                multipartBlockStateSupplier.with((When)When.create().set(booleanProperty, true), function.apply(identifier));
                multipartBlockStateSupplier.with((When)propertyCondition2, function.apply(identifier));
            }
            else {
                multipartBlockStateSupplier.with((When)When.create().set(booleanProperty, true), function.apply(identifier2));
                multipartBlockStateSupplier.with((When)propertyCondition2, function.apply(identifier2));
            }
        }
        blockStateModelGenerator.blockStateCollector.accept(multipartBlockStateSupplier);
    }
    public final void registerSingleStateDecal(BlockStateModelGenerator blockStateModelGenerator, Block block) {
        blockStateModelGenerator.registerItemModel(block.asItem());
        Identifier identifier = blockStateModelGenerator.createSubModel(block, "", ModModels.DECAL, TextureMap::all);

        MultipartBlockStateSupplier multipartBlockStateSupplier = MultipartBlockStateSupplier.create(block);
        When.PropertyCondition propertyCondition2 = Util.make(When.create(), propertyCondition -> blockStateModelGenerator.CONNECTION_VARIANT_FUNCTIONS.stream().map(Pair::getFirst).forEach(property -> {
            if (block.getDefaultState().contains(property)) {
                propertyCondition.set(property, false);
            }
        }));
        for (Pair<BooleanProperty, Function<Identifier, BlockStateVariant>> pair : blockStateModelGenerator.CONNECTION_VARIANT_FUNCTIONS) {
            BooleanProperty booleanProperty = pair.getFirst();
            Function<Identifier, BlockStateVariant> function = pair.getSecond();
            if (!block.getDefaultState().contains(booleanProperty)) continue;
            multipartBlockStateSupplier.with((When)When.create().set(booleanProperty, true), function.apply(identifier));
            multipartBlockStateSupplier.with((When)propertyCondition2, function.apply(identifier));
        }
        blockStateModelGenerator.blockStateCollector.accept(multipartBlockStateSupplier);
    }
    public final void registerCRT(BlockStateModelGenerator blockStateModelGenerator, Block block) {
        TexturedModel.Factory modelFactory = ModTexturedModel.CRT;
        Identifier identifier = modelFactory.upload(block, blockStateModelGenerator.modelCollector);

        TextureMap map = new TextureMap()
                .put(TextureKey.TOP, TextureMap.getSubId(block, "_top"))
                .put(TextureKey.BOTTOM, TextureMap.getSubId(block, "_bottom"))
                .put(TextureKey.SIDE, TextureMap.getSubId(block, "_side"))
                .put(TextureKey.FRONT, TextureMap.getSubId(block, "_front_on"))
                .put(TextureKey.BACK, TextureMap.getSubId(block, "_back"))
                ;
        Model model = ModModels.CRT;
        Identifier identifier2 = model.upload(block, "_on", map, blockStateModelGenerator.modelCollector);

        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block, BlockStateVariant.create()
                .put(VariantSettings.MODEL, identifier)).coordinate(BlockStateModelGenerator.createNorthDefaultHorizontalRotationStates())
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(Properties.LIT, identifier2, identifier)));
    }
    public final void registerGlazedTerracottaCubeWithCustomTexturePaths(BlockStateModelGenerator blockStateModelGenerator, Block block, String northTexture, String southTexture, String eastTexture, String westTexture, String upTexture, String downTexture, String particleTexture) {
        TextureMap map = new TextureMap()
                .put(TextureKey.NORTH, Super.asResource(northTexture))
                .put(TextureKey.SOUTH, Super.asResource(southTexture))
                .put(TextureKey.EAST, Super.asResource(eastTexture))
                .put(TextureKey.WEST, Super.asResource(westTexture))
                .put(TextureKey.UP, Super.asResource(upTexture))
                .put(TextureKey.DOWN, Super.asResource(downTexture))
                .put(TextureKey.PARTICLE, Super.asResource(particleTexture))
                ;
        Identifier identifier = Models.CUBE.upload(block, map, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block, BlockStateVariant.create().put(VariantSettings.MODEL, identifier)).coordinate(BlockStateModelGenerator.createSouthDefaultHorizontalRotationStates()));
    }
    public final void registerGlazedTerracottaCubeWithCustomTexturePaths(BlockStateModelGenerator blockStateModelGenerator, Block block, String northTexture, String southTexture, String eastTexture, String westTexture, String upTexture, String downTexture) {
        registerGlazedTerracottaCubeWithCustomTexturePaths(blockStateModelGenerator, block, northTexture, southTexture, eastTexture, westTexture, upTexture, downTexture, northTexture);
    }
    public final void registerLitHorizontalFacingCubeWithCustomTexturePaths(BlockStateModelGenerator blockStateModelGenerator, Block block, TextureMap offMap, TextureMap onMap) {
        Identifier identifier = Models.CUBE.upload(block, offMap, blockStateModelGenerator.modelCollector);
        Identifier identifier2 = Models.CUBE.upload(block, "_on", onMap, blockStateModelGenerator.modelCollector);

        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block, BlockStateVariant.create().put(VariantSettings.MODEL, identifier))
                .coordinate(BlockStateModelGenerator.createNorthDefaultHorizontalRotationStates())
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(Properties.LIT, identifier2, identifier)));
    }
    public final void registerHorizontalFacingCubeWithCustomTexturePaths(BlockStateModelGenerator blockStateModelGenerator, Block block, String northTexture, String southTexture, String eastTexture, String westTexture, String upTexture, String downTexture, String particleTexture) {
        TextureMap map = new TextureMap()
                .put(TextureKey.NORTH, Super.asResource(northTexture))
                .put(TextureKey.SOUTH, Super.asResource(southTexture))
                .put(TextureKey.EAST, Super.asResource(eastTexture))
                .put(TextureKey.WEST, Super.asResource(westTexture))
                .put(TextureKey.UP, Super.asResource(upTexture))
                .put(TextureKey.DOWN, Super.asResource(downTexture))
                .put(TextureKey.PARTICLE, Super.asResource(particleTexture))
                ;
        Identifier identifier = Models.CUBE.upload(block, map, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block, BlockStateVariant.create().put(VariantSettings.MODEL, identifier)).coordinate(BlockStateModelGenerator.createNorthDefaultHorizontalRotationStates()));
    }
    public final void registerHorizontalFacingCubeWithCustomTexturePaths(BlockStateModelGenerator blockStateModelGenerator, Block block, String northTexture, String southTexture, String eastTexture, String westTexture, String upTexture, String downTexture) {
        registerHorizontalFacingCubeWithCustomTexturePaths(blockStateModelGenerator, block, northTexture, southTexture, eastTexture, westTexture, upTexture, downTexture, northTexture);
    }
    private void registerCrate(BlockStateModelGenerator blockStateModelGenerator, Block block) {
        Identifier identifier = TextureMap.getSubId(block, "_top_open");
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block).coordinate(blockStateModelGenerator.createUpDefaultFacingVariantMap()).coordinate(BlockStateVariantMap.create(Properties.OPEN).register((Boolean)false, BlockStateVariant.create().put(VariantSettings.MODEL, TexturedModel.CUBE_TOP.upload(block, blockStateModelGenerator.modelCollector))).register((Boolean)true, BlockStateVariant.create().put(VariantSettings.MODEL, TexturedModel.CUBE_TOP.get(block).textures(textureMap -> textureMap.put(TextureKey.TOP, identifier)).upload(block, "_open", blockStateModelGenerator.modelCollector)))));
    }
    private void registerKeyboardBlock(BlockStateModelGenerator blockStateModelGenerator, Block block) {
        Identifier identifier = blockStateModelGenerator.createSubModel(block, "", ModModels.KEYBOARD, TextureMap::all);
//        blockStateModelGenerator.registerItemModel(block.asItem());
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block, BlockStateVariant.create().put(VariantSettings.MODEL, identifier)).coordinate(BlockStateModelGenerator.createNorthDefaultHorizontalRotationStates()));
    }
    private void registerAntennaBlock(BlockStateModelGenerator blockStateModelGenerator, Block block) {
        Identifier identifier = new Identifier("ltones", "block/antenna");
//        blockStateModelGenerator.registerItemModel(block.asItem());
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block, BlockStateVariant.create().put(VariantSettings.MODEL, identifier)).coordinate(BlockStateModelGenerator.createNorthDefaultHorizontalRotationStates()));
    }
    private void registerRadioBlock(BlockStateModelGenerator blockStateModelGenerator, Block block) {
        Identifier identifier = new Identifier("ltones", "block/radio");
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block, BlockStateVariant.create().put(VariantSettings.MODEL, identifier)).coordinate(BlockStateModelGenerator.createNorthDefaultHorizontalRotationStates()));
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //<editor-fold desc = "Models - decals">
        this.registerMultiStateDecal(blockStateModelGenerator, ModBlocks.DECAL_CONDUCTIUM);
        this.registerSingleStateDecal(blockStateModelGenerator, ModBlocks.DECAL_KERBESIUM);
        this.registerMultiStateDecal(blockStateModelGenerator, ModBlocks.DECAL_ORGANIC_BRASS);
        this.registerSingleStateDecal(blockStateModelGenerator, ModBlocks.DECAL_MIDASIUM);
        this.registerMultiStateDecal(blockStateModelGenerator, ModBlocks.DECAL_TAWSINE);
        this.registerSingleStateDecal(blockStateModelGenerator, ModBlocks.DECAL_THINKING_METAL);
        this.registerSingleStateDecal(blockStateModelGenerator, ModBlocks.DECAL_ARGON);
        this.registerMultiStateDecal(blockStateModelGenerator, ModBlocks.DECAL_OIL);
        this.registerSingleStateDecal(blockStateModelGenerator, ModBlocks.DECAL_DIODE);
        this.registerMultiStateDecal(blockStateModelGenerator, ModBlocks.DECAL_POLYMER);
        this.registerSingleStateDecal(blockStateModelGenerator, ModBlocks.DECAL_SHEETING);
        this.registerMultiStateDecal(blockStateModelGenerator, ModBlocks.DECAL_POLYCARBONATE);
        this.registerMultiStateDecal(blockStateModelGenerator, ModBlocks.DECAL_GAS_TUBE);
        this.registerMultiStateDecal(blockStateModelGenerator, ModBlocks.DECAL_AZURE_RIVET);
        this.registerSingleStateDecal(blockStateModelGenerator, ModBlocks.DECAL_GLEAM);
        this.registerSingleStateDecal(blockStateModelGenerator, ModBlocks.DECAL_G2V);
        this.registerSingleStateDecal(blockStateModelGenerator, ModBlocks.DECAL_SLAG);
        this.registerSingleStateDecal(blockStateModelGenerator, ModBlocks.DECAL_RADIUM_PAINT);
        this.registerMultiStateDecal(blockStateModelGenerator, ModBlocks.DECAL_FIBROUS_POWDER);
        this.registerMultiStateDecal(blockStateModelGenerator, ModBlocks.DECAL_AMALGAM);
        this.registerMultiStateDecal(blockStateModelGenerator, ModBlocks.DECAL_SLUMP);
        this.registerSingleStateDecal(blockStateModelGenerator, ModBlocks.DECAL_SHADE);
        this.registerMultiStateDecal(blockStateModelGenerator, ModBlocks.DECAL_SCREEN);
        this.registerMultiStateDecal(blockStateModelGenerator, ModBlocks.DECAL_SCARLET_MEMBRANE);
        this.registerMultiStateDecal(blockStateModelGenerator, ModBlocks.DECAL_MOULDING);
        this.registerMultiStateDecal(blockStateModelGenerator, ModBlocks.DECAL_PLAQUE);
        this.registerSingleStateDecal(blockStateModelGenerator, ModBlocks.DECAL_JELLY);
        this.registerSingleStateDecal(blockStateModelGenerator, ModBlocks.DECAL_CORPOREAL_VAPOR);
        this.registerMultiStateDecal(blockStateModelGenerator, ModBlocks.DECAL_FLAKES);
        this.registerMultiStateDecal(blockStateModelGenerator, ModBlocks.DECAL_NETWORKING);
        //</editor-fold>

        //<editor-fold desc = "Models - agon">
        for(Block block : ModBlocks.AGON_BLOCKS) {
            blockStateModelGenerator.registerCubeAllModelTexturePool(block);
        }
        //</editor-fold>
        //<editor-fold desc = "Models - fortt">
        for(Block block : ModBlocks.FORTT_BLOCKS) {
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
        BlockStateModelGenerator.BlockTexturePool krypWireTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.KRYP_WIRE);
        krypWireTexturePool.slab(ModBlocks.KRYP_WIRE_SLAB);
        krypWireTexturePool.stairs(ModBlocks.KRYP_WIRE_STAIRS);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.KRYP_STORAGE);
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
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LAVE_SECTION);
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
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.VEELD_BRICK);
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
        registerLitOnOffAxisRotatedBlock(blockStateModelGenerator, ModBlocks.EXRI_SERVE, Models.CUBE_ALL, TextureMap::all);

        registerLitHorizontalFacingCubeWithCustomTexturePaths(blockStateModelGenerator, ModBlocks.EXRI_DISPLAY,
                new TextureMap()
                        .put(TextureKey.NORTH, Super.asResource("block/exri_display"))
                        .put(TextureKey.SOUTH, Super.asResource("block/exri_stem"))
                        .put(TextureKey.EAST, Super.asResource("block/exri_flow"))
                        .put(TextureKey.WEST, Super.asResource("block/exri_flow"))
                        .put(TextureKey.UP, Super.asResource("block/exri_seal"))
                        .put(TextureKey.DOWN, Super.asResource("block/exri_seal"))
                        .put(TextureKey.PARTICLE, Super.asResource("block/exri_tect")),
                new TextureMap()
                        .put(TextureKey.NORTH, Super.asResource("block/exri_display_on"))
                        .put(TextureKey.SOUTH, Super.asResource("block/exri_stem"))
                        .put(TextureKey.EAST, Super.asResource("block/exri_flow_on"))
                        .put(TextureKey.WEST, Super.asResource("block/exri_flow_on"))
                        .put(TextureKey.UP, Super.asResource("block/exri_seal"))
                        .put(TextureKey.DOWN, Super.asResource("block/exri_seal"))
                        .put(TextureKey.PARTICLE, Super.asResource("block/exri_tect"))
        );
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
        blockStateModelGenerator.registerAxisRotated(ModBlocks.ROEN_LESION, TexturedModel.CUBE_ALL);
        registerAxisRotatedBlockWithTopTexturePath(blockStateModelGenerator, ModBlocks.ROEN_TRACT, "block/roen_assay");
        registerAxisRotatedBlockWithTopTexturePath(blockStateModelGenerator, ModBlocks.ROEN_BACILLUS, "block/roen_agar");
        registerAxisRotatedBlockWithTopTexturePath(blockStateModelGenerator, ModBlocks.ROEN_OPERON, "block/roen_film");
        blockStateModelGenerator.registerSouthDefaultHorizontalFacing(TexturedModel.TEMPLATE_GLAZED_TERRACOTTA, ModBlocks.ROEN_KINESIN);
        //</editor-fold>
        //<editor-fold desc = "Models - sol">
        registerLitOnOffBlock(blockStateModelGenerator, ModBlocks.SOL_PHOTO, Models.CUBE_ALL, TextureMap::all);
        registerLitOnOffBlock(blockStateModelGenerator, ModBlocks.SOL_ELECTRON, Models.CUBE_ALL, TextureMap::all);
        registerLitOnOffBlock(blockStateModelGenerator, ModBlocks.SOL_MAX, Models.CUBE_ALL, TextureMap::all);
        registerLitOnOffBlock(blockStateModelGenerator, ModBlocks.SOL_MIN, Models.CUBE_ALL, TextureMap::all);
        registerLitOnOffBlock(blockStateModelGenerator, ModBlocks.SOL_CHROMA, Models.CUBE_ALL, TextureMap::all);
        registerLitOnOffBlock(blockStateModelGenerator, ModBlocks.SOL_FLARE, Models.CUBE_ALL, TextureMap::all);
        registerLitOnOffBlock(blockStateModelGenerator, ModBlocks.SOL_BLIND, Models.CUBE_ALL, TextureMap::all);
        registerLitOnOffBlock(blockStateModelGenerator, ModBlocks.SOL_PROTON, Models.CUBE_ALL, TextureMap::all);
        registerLitOnOffBlock(blockStateModelGenerator, ModBlocks.SOL_BALANCE, Models.CUBE_ALL, TextureMap::all);
        registerLitOnOffBlock(blockStateModelGenerator, ModBlocks.SOL_GLARE, Models.CUBE_ALL, TextureMap::all);
        registerLitOnOffBlock(blockStateModelGenerator, ModBlocks.SOL_FIELD, Models.CUBE_ALL, TextureMap::all);
        registerLitOnOffBlock(blockStateModelGenerator, ModBlocks.SOL_NUCLEI, Models.CUBE_ALL, TextureMap::all);
        registerLitOnOffBlock(blockStateModelGenerator, ModBlocks.SOL_CORONA, Models.CUBE_ALL, TextureMap::all);
        registerLitOnOffBlock(blockStateModelGenerator, ModBlocks.SOL, Models.CUBE_ALL, TextureMap::all);
        registerLitOnOffAxisRotatedBlock(blockStateModelGenerator, ModBlocks.SOL_SPECTRA, Models.CUBE_ALL, TextureMap::all);
        registerLitOnOffGlazedTerracottaBlock(blockStateModelGenerator, ModBlocks.SOL_BLAZAR,  Models.CUBE_ALL, TextureMap::all);
        //</editor-fold>
        //<editor-fold desc = "Models - bitt">
        for(Block block : ModBlocks.BITT_BLOCKS) {
            blockStateModelGenerator.registerCubeAllModelTexturePool(block);
        }
        //</editor-fold>

        //<editor-fold desc = "Models - Other Blocks">
        registerLitOnOffBlock(blockStateModelGenerator, ModBlocks.AURORA, Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ZTONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_LITHIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LITHIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LITHIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_LITHIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ENDSTONE_LITHIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TONE_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.POLISHED_TONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ABSTRACT_TONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FRAMED_TONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FRAMED_TONE_BRICKS);

        registerCRT(blockStateModelGenerator, ModBlocks.CRT);
        registerCRT(blockStateModelGenerator, ModBlocks.AGED_CRT);
        registerCRT(blockStateModelGenerator, ModBlocks.BLACK_CRT);
        registerCRT(blockStateModelGenerator, ModBlocks.GRAY_CRT);
        registerAxisRotatedBlockWithCustomTexturePaths(blockStateModelGenerator, ModBlocks.TIRE, "block/tire_top", "block/tire_side");
        registerAxisRotatedBlockWithCustomTexturePaths(blockStateModelGenerator, ModBlocks.EMPTY_TIRE, "block/empty_tire_top", "block/tire_side");
        registerCrate(blockStateModelGenerator, ModBlocks.CRATE);
        registerKeyboardBlock(blockStateModelGenerator, ModBlocks.KEYBOARD);
        registerKeyboardBlock(blockStateModelGenerator, ModBlocks.AGED_KEYBOARD);
        registerKeyboardBlock(blockStateModelGenerator, ModBlocks.BLACK_KEYBOARD);
        registerKeyboardBlock(blockStateModelGenerator, ModBlocks.GRAY_KEYBOARD);
        registerAntennaBlock(blockStateModelGenerator, ModBlocks.ANTENNA);
        registerRadioBlock(blockStateModelGenerator, ModBlocks.RADIO);
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

        // Door Models
        for (Block block : ModBlocks.DOORS) {
            blockStateModelGenerator.registerDoor(block);
        }

        // Fallback BlockItem Models
        generateFallbackBlockItemModels(blockStateModelGenerator);
    }
    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RAW_LITHIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.LITHIUM_CHUNK, Models.GENERATED);
        itemModelGenerator.register(ModItems.LITHIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ANTIBRASS, Models.GENERATED);
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
            if(block instanceof StairsBlock || block instanceof LitSlabBlock || block instanceof SlabBlock || block instanceof DecalBlock || block instanceof DoorBlock) continue; //Jank but it works // WOW this sucks -me, months later
            registerParentedBlockItemModel(blockStateModelGenerator, Registries.BLOCK.get(id), Super.asResource("block/" + id.getPath()));
        }
    }
}