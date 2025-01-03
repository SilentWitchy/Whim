package net.august.whim.worldgen;

import net.august.whim.Whim;
import net.august.whim.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> BISMUTH_ORE_PLACED_KEY = registerKey("bismuth_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_BISMUTH_ORE_PLACED_KEY = registerKey("nether_bismuth_ore_placed");
    public static final ResourceKey<PlacedFeature> END_BISMUTH_ORE_PLACED_KEY = registerKey("end_bismuth_ore_placed");

    public static final ResourceKey<PlacedFeature> ESSENCE_AER_ORE_PLACED_KEY = registerKey("essence_aer_ore_placed");
    public static final ResourceKey<PlacedFeature> ESSENCE_AQUA_ORE_PLACED_KEY = registerKey("essence_aqua_ore_placed");
    public static final ResourceKey<PlacedFeature> ESSENCE_TERRA_ORE_PLACED_KEY = registerKey("essence_terra_ore_placed");
    public static final ResourceKey<PlacedFeature> ESSENCE_IGNIS_ORE_PLACED_KEY = registerKey("essence_ignis_ore_placed");
    public static final ResourceKey<PlacedFeature> ESSENCE_ORDO_ORE_PLACED_KEY = registerKey("essence_ordo_ore_placed");
    public static final ResourceKey<PlacedFeature> ESSENCE_PERIDITIO_ORE_PLACED_KEY = registerKey("essence_periditio_ore_placed");

    public static final ResourceKey<PlacedFeature> BLOODWOOD_PLACED_KEY = registerKey("bloodwood_placed");
    public static final ResourceKey<PlacedFeature> GOJI_BERRY_BUSH_PLACED_KEY = registerKey("goji_berry_bush_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, BISMUTH_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_BISMUTH_ORE_KEY),
                ModOrePlacement.commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, NETHER_BISMUTH_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_BISMUTH_ORE_KEY),
                ModOrePlacement.commonOrePlacement(7, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, END_BISMUTH_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_BISMUTH_ORE_KEY),
                ModOrePlacement.commonOrePlacement(5, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
// pCount is veins per chunk
// HeightRangePlacement.uniform means anywhere from height -64 to 80 you have an equal chance of finding the ore
// Triangle means its distributed closer to the ends
        register(context, ESSENCE_AER_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_ASPECT_AER_ORE_KEY),
                ModOrePlacement.rareOrePlacement(9, HeightRangePlacement.triangle(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(80))));
        register(context, ESSENCE_AQUA_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_ASPECT_AQUA_ORE_KEY),
                ModOrePlacement.rareOrePlacement(9, HeightRangePlacement.triangle(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(80))));
        register(context, ESSENCE_IGNIS_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_ASPECT_IGNIS_ORE_KEY),
                ModOrePlacement.rareOrePlacement(9, HeightRangePlacement.triangle(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(80))));
        register(context, ESSENCE_TERRA_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_ASPECT_TERRA_ORE_KEY),
                ModOrePlacement.rareOrePlacement(9, HeightRangePlacement.triangle(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(80))));
        register(context, ESSENCE_ORDO_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_ASPECT_ORDO_ORE_KEY),
                ModOrePlacement.rareOrePlacement(9, HeightRangePlacement.triangle(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(80))));
        register(context, ESSENCE_PERIDITIO_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_ASPECT_PERDITIO_ORE_KEY),
                ModOrePlacement.rareOrePlacement(9, HeightRangePlacement.triangle(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(80))));

        register(context, BLOODWOOD_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BLOODWOOD_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2),
                        ModBlocks.BLOODWOOD_SAPLING.get()));

        register(context, GOJI_BERRY_BUSH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.GOJI_BERRY_BUSH_KEY),
                List.of(RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(Whim.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
