package net.august.whim.datagen;

import net.august.whim.Whim;
import net.august.whim.block.ModBlocks;
import net.august.whim.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Whim.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.BISMUTH_BLOCK.get())
                .add(ModBlocks.BISMUTH_ORE.get())
                .add(ModBlocks.BISMUTH_LAMP.get())
                .add(ModBlocks.BISMUTH_DEEPSLATE_ORE.get())
                .add(ModBlocks.ASPECT_AER_ORE.get())
                .add(ModBlocks.ASPECT_AQUA_ORE.get())
                .add(ModBlocks.ASPECT_IGNIS_ORE.get())
                .add(ModBlocks.ASPECT_ORDO_ORE.get())
                .add(ModBlocks.ASPECT_TERRA_ORE.get())
                .add(ModBlocks.ASPECT_PERDITIO_ORE.get())
                .add(ModBlocks.PEDESTAL.get())
                .add(ModBlocks.ASPECT_AER_DEEPSLATE_ORE.get())
                .add(ModBlocks.ASPECT_AQUA_DEEPSLATE_ORE.get())
                .add(ModBlocks.ASPECT_IGNIS_DEEPSLATE_ORE.get())
                .add(ModBlocks.ASPECT_ORDO_DEEPSLATE_ORE.get())
                .add(ModBlocks.ASPECT_TERRA_DEEPSLATE_ORE.get())
                .add(ModBlocks.ASPECT_PERDITIO_DEEPSLATE_ORE.get());


        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.BISMUTH_DEEPSLATE_ORE.get())
                .add(ModBlocks.ASPECT_AER_ORE.get())
                .add(ModBlocks.ASPECT_AQUA_ORE.get())
                .add(ModBlocks.ASPECT_IGNIS_ORE.get())
                .add(ModBlocks.ASPECT_ORDO_ORE.get())
                .add(ModBlocks.ASPECT_TERRA_ORE.get())
                .add(ModBlocks.ASPECT_PERDITIO_ORE.get())
                .add(ModBlocks.ASPECT_AER_DEEPSLATE_ORE.get())
                .add(ModBlocks.ASPECT_AQUA_DEEPSLATE_ORE.get())
                .add(ModBlocks.ASPECT_IGNIS_DEEPSLATE_ORE.get())
                .add(ModBlocks.ASPECT_ORDO_DEEPSLATE_ORE.get())
                .add(ModBlocks.ASPECT_TERRA_DEEPSLATE_ORE.get())
                .add(ModBlocks.ASPECT_PERDITIO_DEEPSLATE_ORE.get());


        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.BISMUTH_LAMP.get());

        tag(BlockTags.FENCES).add(ModBlocks.BISMUTH_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.BISMUTH_FENCE_GATE.get());
        tag(BlockTags.WALLS).add(ModBlocks.BISMUTH_WALL.get());

        tag(ModTags.Blocks.NEEDS_BISMUTH_TOOL)
                .add(ModBlocks.BISMUTH_LAMP.get())
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_BISMUTH_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(ModTags.Blocks.NEEDS_BISMUTH_TOOL);

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.BLOODWOOD_LOG.get())
                .add(ModBlocks.BLOODWOOD_WOOD.get())
                .add(ModBlocks.STRIPPED_BLOODWOOD_LOG.get())
                .add(ModBlocks.STRIPPED_BLOODWOOD_WOOD.get());
    }
}
