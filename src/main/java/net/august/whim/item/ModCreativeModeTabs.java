package net.august.whim.item;

import net.august.whim.Whim;
import net.august.whim.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Whim.MOD_ID);

    public static final Supplier<CreativeModeTab> BISMUTH_ITEMS_TAB = CREATIVE_MODE_TAB.register("bismuth_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BISMUTH.get()))
                    .title(Component.translatable("creativetab.whim.bismuth_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.BISMUTH);
                        output.accept(ModItems.RAW_BISMUTH);

                        output.accept(ModItems.CHISEL);
                        output.accept(ModItems.RADISH);


                        output.accept(ModItems.FROSTFIRE_ICE);
                        output.accept(ModItems.STARLIGHT_ASHES);

                        output.accept(ModItems.BISMUTH_SWORD);
                        output.accept(ModItems.BISMUTH_PICKAXE);
                        output.accept(ModItems.BISMUTH_SHOVEL);
                        output.accept(ModItems.BISMUTH_AXE);
                        output.accept(ModItems.BISMUTH_HOE);
                        output.accept(ModItems.CRIMSON_BOW);

                        output.accept(ModItems.BISMUTH_HAMMER);
                        output.accept(ModItems.TOMAHAWK);

                        output.accept(ModItems.BISMUTH_HELMET);
                        output.accept(ModItems.BISMUTH_CHESTPLATE);
                        output.accept(ModItems.BISMUTH_LEGGINGS);
                        output.accept(ModItems.BISMUTH_BOOTS);

                        output.accept(ModItems.BISMUTH_HORSE_ARMOR);
                        output.accept(ModItems.WITCHY_SMITHING_TEMPLATE);

                        output.accept(ModItems.BAR_BRAWL_MUSIC_DISC);

                        output.accept(ModItems.RADISH_SEEDS);
                        output.accept(ModItems.GOJI_BERRIES);

                        output.accept(ModItems.GECKO_SPAWN_EGG);

                        output.accept(ModItems.ASPECT_AER_SHARD);
                        output.accept(ModItems.ASPECT_AQUA_SHARD);
                        output.accept(ModItems.ASPECT_IGNIS_SHARD);
                        output.accept(ModItems.ASPECT_ORDO_SHARD);
                        output.accept(ModItems.ASPECT_PERDITIO_SHARD);
                        output.accept(ModItems.ASPECT_TERRA_SHARD);






                    }).build());

    public static final Supplier<CreativeModeTab> BISMUTH_BLOCK_TAB = CREATIVE_MODE_TAB.register("bismuth_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.BISMUTH_BLOCK))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(Whim.MOD_ID, "bismuth_items_tab"))
                    .title(Component.translatable("creativetab.whim.bismuth_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.BISMUTH_BLOCK);
                        output.accept(ModBlocks.BISMUTH_ORE);
                        output.accept(ModBlocks.BISMUTH_DEEPSLATE_ORE);

                        output.accept(ModBlocks.MAGIC_BLOCK);

                        output.accept(ModBlocks.BISMUTH_STAIRS);
                        output.accept(ModBlocks.BISMUTH_SLAB);

                        output.accept(ModBlocks.BISMUTH_PRESSURE_PLATE);
                        output.accept(ModBlocks.BISMUTH_BUTTON);

                        output.accept(ModBlocks.BISMUTH_FENCE);
                        output.accept(ModBlocks.BISMUTH_FENCE_GATE);
                        output.accept(ModBlocks.BISMUTH_WALL);

                        output.accept(ModBlocks.BISMUTH_DOOR);
                        output.accept(ModBlocks.BISMUTH_TRAPDOOR);

                        output.accept(ModBlocks.BISMUTH_LAMP);

                        output.accept(ModBlocks.BLOODWOOD_LOG.get());
                        output.accept(ModBlocks.BLOODWOOD_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_BLOODWOOD_LOG.get());
                        output.accept(ModBlocks.STRIPPED_BLOODWOOD_WOOD.get());

                        output.accept(ModBlocks.BLOODWOOD_PLANKS.get());
                        output.accept(ModBlocks.BLOODWOOD_SAPLING.get());

                        output.accept(ModBlocks.BLOODWOOD_LEAVES.get());

                        output.accept(ModBlocks.ASPECT_AER_ORE);
                        output.accept(ModBlocks.ASPECT_AQUA_ORE);
                        output.accept(ModBlocks.ASPECT_ORDO_ORE);
                        output.accept(ModBlocks.ASPECT_IGNIS_ORE);
                        output.accept(ModBlocks.ASPECT_PERDITIO_ORE);
                        output.accept(ModBlocks.ASPECT_TERRA_ORE);
                        output.accept(ModBlocks.ASPECT_AER_DEEPSLATE_ORE);
                        output.accept(ModBlocks.ASPECT_AQUA_DEEPSLATE_ORE);
                        output.accept(ModBlocks.ASPECT_ORDO_DEEPSLATE_ORE);
                        output.accept(ModBlocks.ASPECT_IGNIS_DEEPSLATE_ORE);
                        output.accept(ModBlocks.ASPECT_PERDITIO_DEEPSLATE_ORE);
                        output.accept(ModBlocks.ASPECT_TERRA_DEEPSLATE_ORE);

                        output.accept(ModBlocks.PEDESTAL);

                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
