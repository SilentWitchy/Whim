package net.august.whim.worldgen;

import net.august.whim.Whim;
import net.august.whim.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_BISMUTH_ORE_KEY = registerKey("bismuth_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_BISMUTH_ORE_KEY = registerKey("nether_bismuth_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_BISMUTH_ORE_KEY = registerKey("end_bismuth_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_ASPECT_AER_ORE_KEY = registerKey("aspect_aer_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_ASPECT_IGNIS_ORE_KEY = registerKey("aspect_ignis_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_ASPECT_AQUA_ORE_KEY = registerKey("aspect_aqua_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_ASPECT_TERRA_ORE_KEY = registerKey("aspect_terra_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_ASPECT_ORDO_ORE_KEY = registerKey("aspect_ordo_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_ASPECT_PERDITIO_ORE_KEY = registerKey("aspect_perditio_ore");


    public static final ResourceKey<ConfiguredFeature<?, ?>> BLOODWOOD_KEY = registerKey("bloodwood");

    public static final ResourceKey<ConfiguredFeature<?, ?>> GOJI_BERRY_BUSH_KEY = registerKey("goji_berry_bush");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldBismuthOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.BISMUTH_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.BISMUTH_DEEPSLATE_ORE.get().defaultBlockState()));

//Size is how many per vein...uwu
        register(context, OVERWORLD_BISMUTH_ORE_KEY, Feature.ORE, new OreConfiguration(overworldBismuthOres, 9));
        register(context, NETHER_BISMUTH_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables,
                ModBlocks.BISMUTH_NETHER_ORE.get().defaultBlockState(), 9));
        register(context, END_BISMUTH_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables,
                ModBlocks.BISMUTH_END_ORE.get().defaultBlockState(), 9));
// ------------
        List<OreConfiguration.TargetBlockState> overworldAspectAerOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.ASPECT_AER_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.ASPECT_AER_ORE.get().defaultBlockState()));


        register(context, OVERWORLD_ASPECT_AER_ORE_KEY, Feature.ORE, new OreConfiguration(overworldAspectAerOres, 2));
// ------------
        List<OreConfiguration.TargetBlockState> overworldAspectIgnisOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.ASPECT_IGNIS_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.ASPECT_IGNIS_ORE.get().defaultBlockState()));


        register(context, OVERWORLD_ASPECT_IGNIS_ORE_KEY, Feature.ORE, new OreConfiguration(overworldAspectIgnisOres, 2));
// ------------
        List<OreConfiguration.TargetBlockState> overworldAspectAquaOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.ASPECT_AQUA_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.ASPECT_AQUA_ORE.get().defaultBlockState()));


        register(context, OVERWORLD_ASPECT_AQUA_ORE_KEY, Feature.ORE, new OreConfiguration(overworldAspectAquaOres, 2));
// ------------
        List<OreConfiguration.TargetBlockState> overworldAspectTerraOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.ASPECT_TERRA_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.ASPECT_TERRA_ORE.get().defaultBlockState()));


        register(context, OVERWORLD_ASPECT_TERRA_ORE_KEY, Feature.ORE, new OreConfiguration(overworldAspectTerraOres, 2));
// ------------
        List<OreConfiguration.TargetBlockState> overworldAspectOrdoOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.ASPECT_ORDO_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.ASPECT_ORDO_ORE.get().defaultBlockState()));


        register(context, OVERWORLD_ASPECT_ORDO_ORE_KEY, Feature.ORE, new OreConfiguration(overworldAspectOrdoOres, 2));
// ------------
        List<OreConfiguration.TargetBlockState> overworldAspectPerditioOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.ASPECT_PERDITIO_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.ASPECT_PERDITIO_ORE.get().defaultBlockState()));


        register(context, OVERWORLD_ASPECT_PERDITIO_ORE_KEY, Feature.ORE, new OreConfiguration(overworldAspectPerditioOres, 2));
// ------------

        register(context, BLOODWOOD_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.BLOODWOOD_LOG.get()),
                new ForkingTrunkPlacer(4, 4, 3),

                BlockStateProvider.simple(ModBlocks.BLOODWOOD_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(3), 3),

                new TwoLayersFeatureSize(1, 0, 2)).dirt(BlockStateProvider.simple(Blocks.NETHERRACK)).build());

        register(context, GOJI_BERRY_BUSH_KEY, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.GOJI_BERRY_BUSH.get()
                                .defaultBlockState().setValue(SweetBerryBushBlock.AGE, 3))
                        ), List.of(Blocks.GRASS_BLOCK)));

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(Whim.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
